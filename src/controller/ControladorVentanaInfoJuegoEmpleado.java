package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Juego;
import model.Juego.Incidencia;
import model.Juego.Unidad;
import model.ModeloGenerico;
import model.ModeloIncidencias;
import model.ModeloPrestamo;
import model.Prestamo;
import model.Usuario;
import model.Videojuego;
import objetosModificados.renderizadoDeCeldaJListUnidadCentrado;
import utilidades.utilidades;
import view.GestionPrestamo;
import view.VentanaInfoPrestamos;
import view.VentanaPrinicipalSocio;

public class ControladorVentanaInfoJuegoEmpleado implements ActionListener, ListSelectionListener {

	private VentanaInfoPrestamos ventana;
	private ModeloGenerico<Juego> juegos;
	private Videojuego videojuego;
	private ModeloPrestamo prestamos;

	public ControladorVentanaInfoJuegoEmpleado(Juego temp, ModeloGenerico<Juego> juegos, GestionPrestamo root) {

		this.juegos = juegos;

		videojuego = (Videojuego) juegos.consultar(temp.getId());

		this.prestamos = new ModeloPrestamo();

		ventana = new VentanaInfoPrestamos();
		ventana.setLocationRelativeTo(root);

		configuracionGeneral();

		ventana.setVisible(true);

	}

	private void configuracionGeneral() {

		new LecturaPrestamo();

		ventana.getLbImagenJuego().setIcon(utilidades.resizeIcon(new ImageIcon(videojuego.getImagen()), 150, 150));
		ventana.getLblCompañiaRellenar().setText(videojuego.getCompañia());
		ventana.getLblNombreRellenar().setText(videojuego.getNombre());
		ventana.getLblPlataformaRellenar().setText(videojuego.getPlatSelecciona());

		ventana.getBtnDevolver().addActionListener(this);

		ventana.getBtnPrestar().setVisible(false);
		ventana.getListJuegos().addListSelectionListener(this);
		ventana.getListJuegos().setCellRenderer(new renderizadoDeCeldaJListUnidadCentrado());
		DefaultListModel<Juego.Unidad> unidades = new DefaultListModel<>();
		unidades.addAll(videojuego.getUnidades());
		ventana.getListJuegos().setModel(unidades);
		ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(ventana.getBtnDevolver())) {

			Juego.Unidad unidad = videojuego.obtenerUnidad(ventana.getListJuegos().getSelectedIndex());

			Prestamo prestamo = utilidades.buscarPrestamo(prestamos.getPrestamos(), unidad.getPrestamo());

			videojuego.setUdsUtilizadas(-1);

			unidad.setPrestamo(null);

			prestamo.setFechaFin(LocalDateTime.now());

			EscrituraPrestamo.ModificacionArchivo(prestamos);
			EscrituraElementos.ModificacionArchivo(juegos);

			ventana.getListJuegos().clearSelection();

		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (!e.getValueIsAdjusting()) {

			if (ventana.getListJuegos().isSelectionEmpty()) {

				ventana.getBtnDevolver().setEnabled(false);
				ventana.gettInformacion().setText("");

			} else {

				Unidad selectedValue = ventana.getListJuegos().getSelectedValue();

				int j = 1;
				String incidencias = "Ninguna";

				for (Incidencia incidencia : selectedValue.obtenerIncidenciasSinResolver()) {

					incidencias += j + "- " + incidencia.getDescripcion() + "\n";
					j++;
				}

				String estado = "";

				if (selectedValue.getPrestamo() != null) {
					estado = " Prestado A: " + selectedValue.getPrestamo().getUsuario() + " Fecha: "
							+ selectedValue.getPrestamo().getFechaInicio().format(DateTimeFormatter.ISO_LOCAL_DATE)
							+ " Hora: "
							+ selectedValue.getPrestamo().getFechaInicio().format(DateTimeFormatter.ISO_LOCAL_TIME);
					ventana.getBtnDevolver().setEnabled(true);
				} else {
					estado += " Sin Prestar";
					ventana.getBtnDevolver().setEnabled(false);

				}

				String texto = "Estado: " + (estado) + "\n" + "Incidencias: " + incidencias;

				ventana.gettInformacion().setText(texto);

			}
		}

	}

}
