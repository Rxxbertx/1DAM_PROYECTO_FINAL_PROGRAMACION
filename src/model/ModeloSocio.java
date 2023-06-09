package model;

import java.util.HashMap;
import java.util.Map.Entry;

public class ModeloSocio {

	private static HashMap<Integer, Socio> socios = new HashMap<>();

	// Constructor
	public ModeloSocio() {

		socios = new HashMap<Integer, Socio>();
	}
	
	
	//Getter
	public HashMap<Integer, Socio> getSocios() {
		return socios;
	}
	
	public static void altaSocio(Socio socio) {

		socios.put(socio.getIdSocio(), socio);

	}

	public static void bajaSocio(Socio socio) {
		socios.remove(socio.getIdSocio(), socio);

	}
	
	public static Socio consultarSocios(Socio socio, String nombre) {

		for (Entry<Integer, Socio> entry : socios.entrySet()) {
			Integer key = entry.getKey();
			Socio val = entry.getValue();
			if (val.getNombre().equals(nombre)) {
				return val;
			}

		}
		return null;

	}
	

}
