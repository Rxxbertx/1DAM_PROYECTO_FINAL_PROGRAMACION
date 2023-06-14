package model;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Videojuego extends Juego implements Serializable {

	/**
	 * Serial version UID for serialization.
	 */
	private static final long serialVersionUID = -1630599723949522104L;

	private String compañia;
	private String platSelecciona;
	private ImageIcon imagen;

	/**
	 * Crea un objeto Videojuego vacío.
	 */
	public Videojuego() {
		super();
	}

	/**
	 * Crea un objeto Videojuego con la información del videojuego.
	 * 
	 * @param nombre         el nombre del videojuego
	 * @param numJugadores   el número de jugadores
	 * @param unidades       el número total de unidades
	 * @param udsUtilizadas  el número de unidades utilizadas
	 * @param compañia       la compañía desarrolladora del videojuego
	 * @param platSelecciona la plataforma seleccionada del videojuego
	 * @param id             el identificador del videojuego
	 * @param imagen         la imagen asociada al videojuego
	 */
	public Videojuego(String nombre, int numJugadores, int unidades, int udsUtilizadas, String compañia,
			String platSelecciona, String id, ImageIcon imagen) {
		super(nombre, numJugadores, unidades, udsUtilizadas, id);
		this.compañia = compañia;
		this.platSelecciona = platSelecciona;
		this.imagen = imagen;
	}

	/**
	 * Devuelve la compañía desarrolladora del videojuego.
	 * 
	 * @return la compañía desarrolladora del videojuego
	 */
	public String getCompañia() {
		return compañia;
	}

	/**
	 * Establece la compañía desarrolladora del videojuego.
	 * 
	 * @param compañia la compañía desarrolladora del videojuego
	 */
	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	/**
	 * Devuelve la plataforma seleccionada del videojuego.
	 * 
	 * @return la plataforma seleccionada del videojuego
	 */
	public String getPlatSelecciona() {
		return platSelecciona;
	}

	/**
	 * Establece la plataforma seleccionada del videojuego.
	 * 
	 * @param platSelecciona la plataforma seleccionada del videojuego
	 */
	public void setPlatSelecciona(String platSelecciona) {
		this.platSelecciona = platSelecciona;
	}

	/**
	 * Devuelve la imagen asociada al videojuego.
	 * 
	 * @return la imagen asociada al videojuego
	 */
	public ImageIcon getImagen() {
		return imagen;
	}

	/**
	 * Establece la imagen asociada al videojuego.
	 * 
	 * @param imagen la imagen asociada al videojuego
	 */
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

}

