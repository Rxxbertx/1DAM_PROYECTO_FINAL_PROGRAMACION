package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Juego.Incidencia;
import model.Juego.Unidad;

public class ModeloIncidencias {

	
	
	private static ArrayList<Incidencia> incidencias = new ArrayList<>();

	public void añadir(Incidencia e) {

		incidencias.add(e);

	}

	public void eliminar(int i) {
		incidencias.remove(i);
	}

	public HashMap<Integer, List<Incidencia>> obtenerIncidenciasJuego(Juego juego) {

		HashMap<Integer, List<Incidencia>> incidencias = new HashMap<>();

		for (Unidad u : juego.getUnidades()) {

			incidencias.put(u.getId(), u.obtenerIncidencias());

		}

		return incidencias;

	}
	
	
	public HashMap<Integer, List<Incidencia>> obtenerIncidenciasJuegoSinResolver(Juego juego) {

		HashMap<Integer, List<Incidencia>> incidencias = new HashMap<>();

		for (Unidad u : juego.getUnidades()) {

			incidencias.put(u.getId(), u.obtenerIncidenciasSinResolver());

		}

		return incidencias;

	}
	
	

	public  List<Incidencia> obtenerIncidenciasUnidad(Juego temp, int selectedIndex) {

		return temp.obtenerUnidad(selectedIndex).obtenerIncidencias();

	}
	
	
	
	
	
	
}
