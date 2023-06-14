package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import model.Juego.Incidencia;
import model.Juego.Unidad;

public class ModeloIncidencias {

	private static ArrayList<Incidencia> incidencias = new ArrayList<>();

	/**
	 * Añade una incidencia al modelo.
	 * 
	 * @param e  la incidencia a añadir
	 */
	public void añadir(Incidencia e) {
		incidencias.add(e);
	}

	/**
	 * Elimina una incidencia del modelo.
	 * 
	 * @param i  el índice de la incidencia a eliminar
	 */
	public void eliminar(int i) {
		incidencias.remove(i);
	}

	/**
	 * Obtiene un HashMap con las incidencias de cada unidad en un juego.
	 * 
	 * @param juego  el juego del cual se obtienen las incidencias
	 * @return       un HashMap que mapea el ID de cada unidad con su lista de incidencias
	 */
	public HashMap<Integer, List<Incidencia>> obtenerIncidenciasJuego(Juego juego) {
		HashMap<Integer, List<Incidencia>> incidencias = new HashMap<>();

		for (Unidad u : juego.getUnidades()) {
			incidencias.put(u.getId(), u.obtenerIncidencias());
		}

		return incidencias;
	}

	/**
	 * Obtiene el número de incidencias sin resolver en un juego.
	 * 
	 * @param juego  el juego del cual se obtienen las incidencias
	 * @return       el número de incidencias sin resolver
	 */
	public int obtenerNumeroIncidenciasSinResolver(Juego juego) {
		int i = 0;

		for (Entry<Integer, List<Incidencia>> entry : obtenerIncidenciasJuego(juego).entrySet()) {
			List<Incidencia> val = entry.getValue();

			for (Incidencia incidencia : val) {
				if (incidencia.isResuelta()) {
					// No se cuenta la incidencia resuelta
				} else {
					i++;
				}
			}
		}

		return i;
	}

	/**
	 * Obtiene las incidencias de una unidad en un juego.
	 * 
	 * @param temp           el juego del cual se obtienen las incidencias
	 * @param selectedIndex  el índice de la unidad seleccionada
	 * @return               una lista con las incidencias de la unidad seleccionada
	 */
	public List<Incidencia> obtenerIncidenciasUnidad(Juego temp, int selectedIndex) {
		return temp.obtenerUnidad(selectedIndex).obtenerIncidencias();
	}
}

