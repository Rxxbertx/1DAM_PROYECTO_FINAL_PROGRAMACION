package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Juego;
import model.Juego.Incidencia;
import model.Juego.Unidad;
import model.ModeloGenerico;
import model.ModeloPrestamo;
import model.Prestamo;
import model.Usuario;
import model.Videojuego;
import objetosModificados.renderizadoDeCeldaJListUnidadCentrado;
import utilidades.utilidades;
import view.VentanaInfoPrestamos;
import view.VentanaPrinicipalSocio;

public class ControladorVentanaInfoJuegoSocio implements ActionListener, ListSelectionListener {

	private VentanaInfoPrestamos ventana;
	private ModeloGenerico<Juego> juegos;
	private Videojuego videojuego;
	private ModeloPrestamo prestamos;
	private Usuario usuario;

	public ControladorVentanaInfoJuegoSocio(Usuario usuario, Videojuego temp, VentanaPrinicipalSocio root,
			ModeloGenerico<Juego> juegosModel, ModeloPrestamo prestamos) {

		

		juegos = juegosModel;

		videojuego = temp;
		this.usuario = usuario;
		this.prestamos = prestamos;

		ventana = new VentanaInfoPrestamos();
		ventana.setLocationRelativeTo(root);

		configuracionGeneral();

		ventana.setVisible(true);

	}

	private void configuracionGeneral() {

		ventana.getLbImagenJuego().setIcon(utilidades.resizeIcon(videojuego.getImagen(), 150, 150));
		ventana.getLblCompañiaRellenar().setText(videojuego.getCompañia());
		ventana.getLblNombreRellenar().setText(videojuego.getNombre());
		ventana.getLblPlataformaRellenar().setText(videojuego.getPlatSelecciona());

		Prestamo prestamo = prestamos.obtenerPrestamoActivoUsuario(usuario);
		if (prestamo == null) {

			ventana.getBtnPrestar().setEnabled(false);

		} else {
			ventana.getBtnPrestar().setVisible(false);
			ventana.getBtnPrestar().setEnabled(false);
		}

		ventana.getBtnDevolver().setVisible(false);
		ventana.getBtnPrestar().addActionListener(this);
		ventana.getListJuegos().addListSelectionListener(this);
		ventana.getListJuegos().setCellRenderer(new renderizadoDeCeldaJListUnidadCentrado());
		DefaultListModel<Juego.Unidad> unidades = new DefaultListModel<>();
		unidades.addAll(videojuego.getUnidades());
		ventana.getListJuegos().setModel(unidades);
		ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(ventana.getBtnPrestar())) {

			Juego.Unidad unidad = videojuego.obtenerUnidad(ventana.getListJuegos().getSelectedIndex());

			Prestamo prestamo = new Prestamo(videojuego.getId(), unidad.getId(), usuario.getNomUsuario(),
					LocalDateTime.now(), null);

			unidad.setPrestamo(prestamo);

			prestamos.añadir(prestamo);
			videojuego.setUdsUtilizadas(1);

			juegos.añadir(videojuego.getId(), videojuego);

			ControladorEscrituraElementos.ModificacionArchivo(juegos);

			new ControladorEscrituraPrestamo(prestamo);

			ventana.getBtnPrestar().setVisible(false);

			JOptionPane.showMessageDialog(ventana, "PRESTAMO REALIZADO, DISFRUTE DE SU JUEGO");

			ventana.getListJuegos().clearSelection();

		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (!e.getValueIsAdjusting()) {

			if (ventana.getListJuegos().isSelectionEmpty()) {

				ventana.gettInformacion().setText("");

			} else {

				Unidad selectedValue = ventana.getListJuegos().getSelectedValue();

				int j = 1;
				
String incidencias = "";
				for (Incidencia incidencia : selectedValue.obtenerIncidencias()) {

					if (incidencia.isResuelta()) {

					} else {
						incidencias += j + "- " + incidencia.getDescripcion() + "\n";
						j++;
					}
				}

				String estado = "";

				if (selectedValue.getPrestamo() != null) {
					estado = " Prestado";
					ventana.getBtnPrestar().setEnabled(false);
				} else {
					estado += " Sin Prestar";
					ventana.getBtnPrestar().setEnabled(true);
				}

				String texto = "Estado: " + (estado) + "\n" + "Incidencias: " + incidencias;

				ventana.gettInformacion().setText(texto);

			}
		}

	}

}
