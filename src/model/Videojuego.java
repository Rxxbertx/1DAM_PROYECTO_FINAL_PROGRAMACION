package model;

import java.io.Serializable;

public class Videojuego extends Juego implements Serializable {

	private String compañia;
	private String[] plataforma;
	private String platSelecciona;
	private String imagen;

	/**
	 * 
	 */
	public Videojuego() {
		super();
	}

	// Constructor con parámetros
	public Videojuego(String nombre, int numJugadores, int unidades, int udsUtilizadas, String incidencias,
			String compañia, String[] plataforma, String platSelecciona, int id, String imagen) {
		super(nombre, numJugadores, unidades, udsUtilizadas, incidencias, id);
		this.compañia = compañia;
		this.plataforma = plataforma;
		this.platSelecciona = platSelecciona;
		this.setImagen(imagen);
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public String[] getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String[] plataforma) {
		this.plataforma = plataforma;
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
