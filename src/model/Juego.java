package model;

public abstract class Juego {

	private String nombre;
	private int numJugadores;
	private int unidades;
	private int udsUtilizadas;
	private String incidencias;

	// Constructor por defecto
	public Juego() {
		super();
	}

	// Constructor con parámetros
	public Juego(String nombre, int numJugadores, int unidades, int udsUtilizadas, String incidencias) {
		super();
		this.nombre = nombre;
		this.numJugadores = numJugadores;
		this.unidades = unidades;
		this.udsUtilizadas = udsUtilizadas;
		this.incidencias = incidencias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumJugadores() {
		return numJugadores;
	}

	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public int getUdsUtilizadas() {
		return udsUtilizadas;
	}

	public void setUdsUtilizadas(int udsUtilizadas) {
		this.udsUtilizadas = udsUtilizadas;
	}

	public String getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(String incidencias) {
		this.incidencias = incidencias;
	}

}
