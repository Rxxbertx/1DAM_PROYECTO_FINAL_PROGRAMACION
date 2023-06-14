package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import model.Juego;
import model.Juego.Incidencia;
import model.ModeloGenerico;
import model.ModeloIncidencias;
import view.VentanaGestionIncidencias;
import view.VentanaHistorialIncidencias;

public class ControladorVerHistorialIncidencias {

	private VentanaHistorialIncidencias ventana;
	private ModeloIncidencias incidencias;
	private ModeloGenerico<Juego> juegos;

	/**
	 * Constructor de la clase ControladorVerHistorialIncidencias.
	 *
	 * @param root        La ventana principal desde la cual se invoca el historial de incidencias.
	 * @param incidencias El modelo de incidencias.
	 */
	public ControladorVerHistorialIncidencias(VentanaGestionIncidencias root, ModeloIncidencias incidencias) {

		this.incidencias = incidencias;
		this.juegos = new ModeloGenerico<>();

		ventana = new VentanaHistorialIncidencias();
		ventana.setLocationRelativeTo(root);

		configuracionGeneral();

		ventana.setVisible(true);
	}

	/**
	 * Realiza la configuración general de la ventana y muestra los datos del historial de incidencias.
	 */
	private void configuracionGeneral() {

		try {
			// Obtener los juegos desde un archivo
			juegos.setElementos(new ControladorLecturaElementos().devolverElementos());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		for (Juego juego : juegos.getElementos().values()) {

			// Obtener las incidencias del juego
			HashMap<Integer, List<Incidencia>> obtencionIncidencias = incidencias.obtenerIncidenciasJuego(juego);

			for (Entry<Integer, List<Incidencia>> entry : obtencionIncidencias.entrySet()) {

				Integer unidad = entry.getKey();
				List<Incidencia> val = entry.getValue();

				int j = 1;
				for (Incidencia incidencia : val) {

					if (incidencia.isResuelta()) {
						// Incidencia resuelta
						String[] datos = {
								juego.getNombre(),
								juego.getId(),
								String.valueOf(unidad),
								j + "- " + incidencia.getDescripcion(),
								"RESUELTA"
						};

						ventana.getModeloResuelto().addRow(datos);
					} else {
						// Incidencia sin resolver
						String[] datos = {
								juego.getNombre(),
								juego.getId(),
								String.valueOf(unidad),
								j + "- " + incidencia.getDescripcion(),
								"Sin Resolver"
						};

						ventana.getModeloNoResuelto().addRow(datos);
					}

					j++;
				}
			}
		}
	}
}
