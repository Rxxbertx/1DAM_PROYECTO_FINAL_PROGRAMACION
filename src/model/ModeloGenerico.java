package model;

import java.util.HashMap;

public class ModeloGenerico<E> {

	private HashMap<String, E> elementos = new HashMap<>();

	/**
	 * Añade un elemento al modelo.
	 * 
	 * @param i         la clave del elemento
	 * @param elemento  el elemento a añadir
	 * @return          true si se añadió con éxito, false si la clave ya existe en el modelo
	 */
	public boolean añadir(String i, E elemento) {
		// Verifica si la clave ya existe en el modelo
		if (consultar(i) != null) {
			return false;  // La clave ya existe, retorna false
		} else {
			elementos.put(i, elemento);  // La clave no existe, se añade el elemento al modelo
			return true;
		}
	}

	/**
	 * Elimina un elemento del modelo.
	 * 
	 * @param string  la clave del elemento a eliminar
	 */
	public void eliminar(String string) {
		elementos.remove(string);  // Elimina el elemento asociado a la clave
	}

	/**
	 * Consulta un elemento en el modelo.
	 * 
	 * @param i  la clave del elemento a consultar
	 * @return   el elemento asociado a la clave, o null si la clave no existe en el modelo
	 */
	public E consultar(String i) {
		return elementos.get(i);  // Retorna el elemento asociado a la clave, o null si la clave no existe
	}

	/**
	 * Obtiene todos los elementos del modelo.
	 * 
	 * @return  un HashMap con todos los elementos del modelo
	 */
	public HashMap<String, E> getElementos() {
		return elementos;
	}

	/**
	 * Establece los elementos del modelo.
	 * 
	 * @param elementos  el HashMap con los elementos a establecer
	 */
	public void setElementos(HashMap<String, E> elementos) {
		if (elementos != null) {
			this.elementos = elementos;
		}
	}
}

