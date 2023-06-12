package model;

import java.io.Serializable;

public class Videojuego extends Juego implements Serializable {

	private String compañia;
	private String platSelecciona;
	private String imagen;

	/** 
	 * 
	 */
	public Videojuego() {
		super();
	}

	// Constructor con parámetros
	public Videojuego(String nombre, int numJugadores, int unidades, int udsUtilizadas,
			String compañia,String platSelecciona, String id, String imagen) {
		super(nombre, numJugadores, unidades, udsUtilizadas, id);
		this.compañia = compañia;

		this.platSelecciona = platSelecciona;
		this.setImagen(imagen);
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}


	public String getPlatSelecciona() {
		return platSelecciona;
	}

	public void setPlatSelecciona(String platSelecciona) {
		this.platSelecciona = platSelecciona;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
