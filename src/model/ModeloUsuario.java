package model;

import java.util.HashMap;

public class ModeloUsuario {

	private static HashMap<String, Usuario> usuarios = new HashMap<>();

	/**
	 * Añade un usuario al modelo.
	 * 
	 * @param i          el identificador del usuario
	 * @param elemento   el usuario a añadir
	 */
	public void añadir(String i, Usuario elemento) {
		usuarios.put(i, elemento);
	}

	/**
	 * Elimina un usuario del modelo.
	 * 
	 * @param i  el identificador del usuario a eliminar
	 */
	public void eliminar(String i) {
		usuarios.remove(i);
	}

	/**
	 * Consulta un usuario en el modelo.
	 * 
	 * @param i  el identificador del usuario a consultar
	 * @return   el usuario correspondiente al identificador especificado, o null si no existe
	 */
	public Usuario consultar(String i) {
		return usuarios.get(i);
	}
}
