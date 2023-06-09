package model;

import java.util.HashMap;

public class ModeloGenerico<E> {

	private HashMap<Integer, E> elementos = new HashMap<>();

	public void añadir(int i, E elemento) {

		elementos.put(i, elemento);

	}

	public void eliminar(int i) {
		elementos.remove(i);
	}

	public E consultar(int i) {
		return elementos.get(i);
	}

	/**
	 * @return the elementos
	 */
	public HashMap<Integer, E> getElementos() {
		return elementos;
	}

	/**
	 * @param elementos the elementos to set
	 */
	public void setElementos(HashMap<Integer, E> elementos) {
		this.elementos = elementos;
	}

}
