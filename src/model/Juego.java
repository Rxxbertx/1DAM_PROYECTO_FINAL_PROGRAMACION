package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Juego implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6025569216836396211L;
	/**
	 *
	 */

	private String nombre;
	private int numJugadores;
	private int udsUtilizadas;
	private List<Unidad> unidades;
	private int uds;
	private String id;

	// Constructor por defecto
	public Juego() {
		super();
	}

	// Constructor con parámetros
	public Juego(String nombre, int numJugadores, int uds, int udsUtilizadas, String id) {
		super();
		this.nombre = nombre;
		this.numJugadores = numJugadores;
		this.setUds(uds);
		this.udsUtilizadas = udsUtilizadas;
		this.id = id;
		this.unidades = new ArrayList<>();
	}

	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}

	public void eliminarUnidad(int i) {
		unidades.remove(i);
	}

	public Unidad obtenerUnidad(int i) {
		return unidades.get(i);
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

	public int getUdsUtilizadas() {
		return udsUtilizadas;
	}

	public void setUdsUtilizadas(int udsUtilizadas) {
		this.udsUtilizadas += udsUtilizadas;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the unidades
	 */
	public List<Unidad> getUnidades() {

		if (unidades != null) {
			return unidades;
		} else {
			return new ArrayList<>();
		}

	}

	public int getUds() {
		return uds;
	}

	public void setUds(int uds) {
		this.uds = uds;
	}

	// unidades

	public static class Unidad implements Serializable {
		/**
		 *
		 */
		private static final long serialVersionUID = -3519533619257921015L;
		private String nombre;
		private int id;
		private String idJuego;
		private List<Incidencia> incidencias;
		private Prestamo prestamo;

		public Unidad(String nombre, int numero, String idJuego) {
			this.setNombreUnidad(nombre);
			this.id = numero;
			this.incidencias = new ArrayList<>();
			this.setIdJuego(idJuego);
			this.prestamo = getPrestamo();
		}

		public Prestamo getPrestamo() {
			return prestamo;
		}

		public void setPrestamo(Prestamo prestamo) {
			this.prestamo = prestamo;
		}

		public int getId() {
			// TODO Auto-generated method stub
			return id;
		}

		public void agregarIncidencia(Incidencia incidencia) {
			incidencias.add(incidencia);
		}

		public List<Incidencia> obtenerIncidencias() {
			return incidencias;
		}

		public Integer getIncidendiasNumero() {

			if (obtenerIncidencias().isEmpty()) {
				return 0;
			} else {
				return obtenerIncidencias().size();
			}

		}

		public String getIdJuego() {
			return idJuego;
		}

		public void setIdJuego(String idJuego) {
			this.idJuego = idJuego;
		}

		public String getNombreUnidad() {
			return nombre;
		}

		public void setNombreUnidad(String nombre) {
			this.nombre = nombre;
		}

		public int getIncidendiasNumeroSinResolver() {

			int i = 0;

			for (Incidencia incidencia : incidencias) {
				if (incidencia.isResuelta()) {

				} else {
					i++;
				}
			}

			return i;
		}

		public List<Incidencia> obtenerIncidenciasNoResueltas() {

			List<Incidencia> incidencia = new ArrayList<>();

			for (Incidencia incidencia2 : incidencias) {

				if (incidencia2.isResuelta()) {

				} else {
					incidencia.add(incidencia2);
				}

			}
			return incidencia;

		}
	}

	// incidencias

	// Clase para representar las incidencias de una unidad
	public static class Incidencia implements Serializable {
		/**
		 *
		 */
		private static final long serialVersionUID = 4603311692135041971L;
		private String descripcion;
		private boolean resuelta;

		public Incidencia(String descripcion) {
			this.descripcion = descripcion;
			this.resuelta = false;
		}

		public void marcarComoResuelta() {
			resuelta = true;
		}

		/**
		 * @return the descripcion
		 */
		public String getDescripcion() {
			return descripcion;
		}

		/**
		 * @return the resuelta
		 */
		public boolean isResuelta() {
			return resuelta;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;

		}

		// Resto de los métodos y atributos de la clase Incidencia...
	}

}
