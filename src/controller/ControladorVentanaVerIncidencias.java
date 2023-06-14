package controller;

import javax.swing.WindowConstants;

import model.Juego;
import model.Juego.Incidencia;
import model.Prestamo;
import view.VentanaGestionJuegos;
import view.VentanaVerIncidencias;

public class ControladorVentanaVerIncidencias {

	private VentanaVerIncidencias ventana;

	/**
	 * Constructor de la clase ControladorVentanaVerIncidencias.
	 *
	 * @param juego El juego del cual se mostrarán las incidencias.
	 * @param root  La ventana principal desde la cual se invoca la visualización de incidencias.
	 */
	public ControladorVentanaVerIncidencias(Juego juego, VentanaGestionJuegos root) {

		ventana = new VentanaVerIncidencias();
		ventana.setLocationRelativeTo(root);
		ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		llenarTablaConDatos(juego);

		ventana.setVisible(true);
	}

	/**
	 * Llena la tabla de la ventana con los datos de las incidencias del juego.
	 *
	 * @param juego El juego del cual se obtienen las incidencias.
	 */
	private void llenarTablaConDatos(Juego juego) {
		for (int i = 0; i < juego.getUnidades().size(); i++) {

			Juego.Unidad unidad = juego.obtenerUnidad(i);

			if (unidad.obtenerIncidenciasNoResueltas().size() <= 0) {
				// Si no hay incidencias no resueltas, no se hace nada.
			} else {

				Prestamo prestamo = unidad.getPrestamo();
				String descPrestamo = "Sin Prestar";

				if (prestamo != null) {
					descPrestamo = "Prestado A: " + prestamo.getUsuario();
				}

				int j = 1;
				String descIncidencias = "";
				for (Incidencia incidencia : unidad.obtenerIncidenciasNoResueltas()) {
					descIncidencias += j + "-  " + incidencia.getDescripcion() + "\n";
					j++;
				}

				String[] datosCelda = { String.valueOf(unidad.getId()), descPrestamo, descIncidencias };

				ventana.getDatos().addRow(datosCelda);
			}
		}
	}

}

