
package model;

import java.util.HashMap;

public class ModeloGenerico<E> {

	private HashMap<String, E> elementos = new HashMap<>();

	public boolean añadir(String i, E elemento) {

		if (consultar(i) != null) {
			return false;
		} else {
			elementos.put(i, elemento);
			return true;

		}

	}

	public void eliminar(String string) {
		elementos.remove(string);
	}

	public E consultar(String i) {
		return elementos.get(i);
	}

	/**
	 * @return the elementos
	 */
	public HashMap<String, E> getElementos() {
		return (HashMap<String, E>) elementos;
	}

	/**
	 * @param elementos the elementos to set
	 */
	public void setElementos(HashMap<String, E> elementos) {

		if (elementos != null) {
			this.elementos = elementos;
		}

	}
}
