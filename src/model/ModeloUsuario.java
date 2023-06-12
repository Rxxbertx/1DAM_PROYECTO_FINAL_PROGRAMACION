package model;

import java.util.HashMap;

public class ModeloUsuario {


	private static HashMap<String, Usuario> usuarios = new HashMap<>();

	public void añadir(String i, Usuario elemento) {

		usuarios.put(i, elemento);

	}

	public void eliminar(String i) {
		usuarios.remove(i);
	}

	public  Usuario consultar(String i) {
		return usuarios.get(i);
	}


}
