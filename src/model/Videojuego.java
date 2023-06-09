package model;

public class Videojuego extends Juego {
	
	private static int idVideojuego;
	private String compañia;
	private String[] plataforma;
	private String platSelecciona;
	/**
	 * 
	 */
	public Videojuego() {
		super();
	}
	//Constructor con parámetros
	public Videojuego(String nombre, int numJugadores, int unidades, int udsUtilizadas, String incidencias, String compañia, String[] plataforma, String platSelecciona) {
		super(nombre, numJugadores, unidades, udsUtilizadas, incidencias);
		idVideojuego++;
		this.compañia = compañia;
		this.plataforma = plataforma;
		this.platSelecciona = platSelecciona;
	}
	public int getIdVideojuego() {
		return idVideojuego;
	}
	public void setIdVideojuego(int idVideojuego) {
		this.idVideojuego = idVideojuego;
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
	
	
	
	

}