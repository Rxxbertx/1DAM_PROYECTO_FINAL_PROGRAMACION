package model;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Videojuego extends Juego implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1630599723949522104L;
	private String compañia;
	private String platSelecciona;
	private ImageIcon imagen;

	/**
	 *
	 */
	public Videojuego() {
		super();
	}

	// Constructor con parámetros
	public Videojuego(String nombre, int numJugadores, int unidades, int udsUtilizadas, String compañia,
			String platSelecciona, String id, ImageIcon imagen) {
		super(nombre, numJugadores, unidades, udsUtilizadas, id);
		this.compañia = compañia;

		this.platSelecciona = platSelecciona;
		this.imagen = imagen;
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

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

}
