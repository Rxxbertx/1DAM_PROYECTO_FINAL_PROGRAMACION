package controller;

import java.util.List;

import model.Juego;
import model.Juego.Incidencia;
import model.Prestamo;
import view.GestionJuegos;
import view.VentanaVerIncidencias;

public class ControladorVentanaVerIncidencias {

	private VentanaVerIncidencias ventana;

	public ControladorVentanaVerIncidencias(Juego juego, GestionJuegos ventanaGestionJuegos) {

		ventana = new VentanaVerIncidencias();

		llenarTablaConDatos(juego);

		ventana.setVisible(true);

	}

	/**
	 * @param juego
	 */
	private void llenarTablaConDatos(Juego juego) {
		for (int i = 0; i < juego.getUnidades().size(); i++) {

			Juego.Unidad unidad = juego.obtenerUnidad(i);
			Prestamo prestamo = unidad.getPrestamo();
			String descPrestamo = "Sin Prestar";

			if (prestamo != null) {
				descPrestamo = "Prestado A: " + prestamo.getUsuario();
			}

			List<Incidencia> incidencia = unidad.obtenerIncidencias();
			int j = 1;
			String descIncidencias = "";
			for (Incidencia incidencia2 : incidencia) {

				if (incidencia2.isResuelta()) {

				} else {
					descIncidencias += j + "-  " + incidencia2.getDescripcion() + "\n";
					j++;
				}

			}

			String[] datosCelda = { String.valueOf(unidad.getId()), descPrestamo, descIncidencias };

			ventana.getDatos().addRow(datosCelda);

		}
	}

}
