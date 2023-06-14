package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.DefaultListModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Juego;
import model.Juego.Incidencia;
import model.Juego.Unidad;
import model.ModeloGenerico;
import model.ModeloPrestamo;
import model.Prestamo;
import model.Videojuego;
import objetosModificados.renderizadoDeCeldaJListUnidadCentrado;
import utilidades.utilidades;
import view.VentanaGestionPrestamo;
import view.VentanaInfoPrestamos;

/**
 * La clase ControladorVentanaInfoJuegoEmpleado es un controlador que gestiona
 * la ventana de información de un juego para los empleados. Implementa las
 * interfaces ActionListener y ListSelectionListener para manejar eventos de
 * acción y selección de listas.
 */
public class ControladorVentanaInfoJuegoEmpleado implements ActionListener, ListSelectionListener {

	private VentanaInfoPrestamos ventana;
	private ModeloGenerico<Juego> juegos;
	private Videojuego videojuego;
	private ModeloPrestamo prestamos;

	/**
	 * Constructor de la clase ControladorVentanaInfoJuegoEmpleado.
	 * 
	 * @param temp   El juego seleccionado.
	 * @param juegos El modelo de juegos.
	 * @param root   La ventana principal de gestión de préstamos.
	 */
	public ControladorVentanaInfoJuegoEmpleado(Juego temp, ModeloGenerico<Juego> juegos, VentanaGestionPrestamo root) {

		this.juegos = juegos;

		videojuego = (Videojuego) juegos.consultar(temp.getId());

		this.prestamos = new ModeloPrestamo();

		ventana = new VentanaInfoPrestamos();
		ventana.setLocationRelativeTo(root);

		configuracionGeneral();

		ventana.setVisible(true);

	}

	/**
	 * Realiza la configuración general de la ventana de información del juego.
	 */
	private void configuracionGeneral() {

		new ControladorLecturaPrestamo();

		ventana.getLbImagenJuego().setIcon(utilidades.resizeIcon(videojuego.getImagen(), 150, 150));
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

	/**
	 * Manejador de eventos para los botones.
	 * 
	 * @param e Evento de acción.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(ventana.getBtnDevolver())) {

			Juego.Unidad unidad = videojuego.obtenerUnidad(ventana.getListJuegos().getSelectedIndex());

			Prestamo prestamo = utilidades.buscarPrestamo(prestamos.getPrestamos(), unidad.getPrestamo());

			videojuego.setUdsUtilizadas(-1);

			unidad.setPrestamo(null);

			if (prestamo != null) {
				prestamo.setFechaFin(LocalDateTime.now());
			}

			ControladorEscrituraPrestamo.ModificacionArchivo(prestamos);
			ControladorEscrituraElementos.ModificacionArchivo(juegos);

			ventana.getListJuegos().clearSelection();

		}

	}

	/**
	 * Manejador de eventos para la selección de elementos en la lista de juegos.
	 * 
	 * @param e Evento de selección.
	 */
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

				for (Incidencia incidencia : selectedValue.obtenerIncidencias()) {

					if (incidencia.isResuelta()) {

					} else {
						incidencias += j + "- " + incidencia.getDescripcion() + "\n";
						j++;
					}

				}

				String estado = "";

				if (selectedValue.getPrestamo() != null) {
					estado = " Prestado A: " + selectedValue.getPrestamo().getUsuario() + " Fecha: "
							+ utilidades.obtenerFecha(selectedValue.getPrestamo().getFechaInicio());

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
