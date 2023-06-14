package controller;

import javax.swing.WindowConstants;

import model.Juego;
import model.Juego.Incidencia;
import model.Prestamo;
import view.VentanaGestionJuegos;
import view.VentanaVerIncidencias;

public class ControladorVentanaVerIncidencias {

	private VentanaVerIncidencias ventana;

	public ControladorVentanaVerIncidencias(Juego juego, VentanaGestionJuegos root) {

		ventana = new VentanaVerIncidencias();
		ventana.setLocationRelativeTo(root);
		ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		llenarTablaConDatos(juego);

		ventana.setVisible(true);

	}

	/**
	 * @param juego
	 */
	private void llenarTablaConDatos(Juego juego) {
		for (int i = 0; i < juego.getUnidades().size(); i++) {

			Juego.Unidad unidad = juego.obtenerUnidad(i);

			if (unidad.obtenerIncidenciasNoResueltas().size() <= 0) {

			} else {

				Prestamo prestamo = unidad.getPrestamo();
				String descPrestamo = "Sin Prestar";

				System.out.println("1111");

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

				System.out.println(datosCelda);


				ventana.getDatos().addRow(datosCelda);

			}

		}
	}

}
