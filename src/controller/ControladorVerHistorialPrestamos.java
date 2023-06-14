package controller;

import java.io.IOException;

import javax.swing.WindowConstants;

import model.Juego;
import model.ModeloGenerico;
import model.ModeloPrestamo;
import model.Prestamo;
import utilidades.utilidades;
import view.VentanaGestionPrestamo;
import view.VentanaHistorialPrestamos;

public class ControladorVerHistorialPrestamos {

	private VentanaHistorialPrestamos ventana;
	private ModeloPrestamo prestamos;
	private ModeloGenerico<Juego> juegos;

	/**
	 * Constructor de la clase ControladorVerHistorialPrestamos.
	 *
	 * @param root La ventana principal desde la cual se invoca el historial de préstamos.
	 */
	public ControladorVerHistorialPrestamos(VentanaGestionPrestamo root) {

		// Crear la instancia de la ventana de historial de préstamos
		ventana = new VentanaHistorialPrestamos();

		// Crear el modelo de préstamos
		prestamos = new ModeloPrestamo();

		// Leer los préstamos desde un archivo
		new ControladorLecturaPrestamo();

		// Crear el modelo de juegos
		juegos = new ModeloGenerico<>();

		try {
			// Obtener los juegos desde un archivo
			juegos.setElementos(new ControladorLecturaElementos().devolverElementos());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Añadir los datos a la tabla de la ventana
		añadirDatosTabla();

		// Configurar la ventana
		ventana.setModal(true);
		ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(root);
		ventana.setVisible(true);
	}

	/**
	 * Añade los datos de los préstamos a la tabla de la ventana.
	 */
	private void añadirDatosTabla() {

		for (Prestamo prestamo : prestamos.getPrestamos()) {

			Juego temp = juegos.consultar(prestamo.getIdJuego());

			ventana.getDatos().addRow(new String[] {
					temp.getNombre(),
					temp.getId(),
					String.valueOf(prestamo.getUnidad()),
					prestamo.getUsuario(),
					utilidades.obtenerFecha(prestamo.getFechaInicio()),
					utilidades.obtenerFecha(prestamo.getFechaFin())
			});
		}
	}
}

