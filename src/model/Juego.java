package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Juego implements Serializable {

	/**
	 * Serial version UID for serialization.
	 */
	private static final long serialVersionUID = -6025569216836396211L;

	private String nombre;
	private int numJugadores;
	private int udsUtilizadas;
	private List<Unidad> unidades;
	private int uds;
	private String id;

	/**
	 * Crea un objeto Juego vacío.
	 */
	public Juego() {
		super();
	}

	/**
	 * Crea un objeto Juego con la información del juego.
	 * 
	 * @param nombre        el nombre del juego
	 * @param numJugadores  el número de jugadores
	 * @param uds           el número total de unidades
	 * @param udsUtilizadas el número de unidades utilizadas
	 * @param id            el identificador del juego
	 */
	public Juego(String nombre, int numJugadores, int uds, int udsUtilizadas, String id) {
		super();
		this.nombre = nombre;
		this.numJugadores = numJugadores;
		this.uds = uds;
		this.udsUtilizadas = udsUtilizadas;
		this.id = id;
		this.unidades = new ArrayList<>();
	}

	/**
	 * Agrega una unidad al juego.
	 * 
	 * @param unidad la unidad a agregar
	 */
	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}

	/**
	 * Elimina una unidad del juego.
	 * 
	 * @param i el índice de la unidad a eliminar
	 */
	public void eliminarUnidad(int i) {
		unidades.remove(i);
	}

	/**
	 * Obtiene una unidad del juego.
	 * 
	 * @param i el índice de la unidad a obtener
	 * @return la unidad correspondiente al índice
	 */
	public Unidad obtenerUnidad(int i) {
		return unidades.get(i);
	}

	/**
	 * Devuelve el nombre del juego.
	 * 
	 * @return el nombre del juego
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del juego.
	 * 
	 * @param nombre el nombre del juego
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el número de jugadores del juego.
	 * 
	 * @return el número de jugadores del juego
	 */
	public int getNumJugadores() {
		return numJugadores;
	}

	/**
	 * Establece el número de jugadores del juego.
	 * 
	 * @param numJugadores el número de jugadores del juego
	 */
	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}

	/**
	 * Devuelve el número de unidades utilizadas del juego.
	 * 
	 * @return el número de unidades utilizadas del juego
	 */
	public int getUdsUtilizadas() {
		return udsUtilizadas;
	}

	/**
	 * Establece el número de unidades utilizadas del juego.
	 * 
	 * @param udsUtilizadas el número de unidades utilizadas del juego
	 */
	public void setUdsUtilizadas(int udsUtilizadas) {
		this.udsUtilizadas += udsUtilizadas;
	}

	/**
	 * Devuelve el identificador del juego.
	 * 
	 * @return el identificador del juego
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador del juego.
	 * 
	 * @param id el identificador del juego
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Devuelve la lista de unidades del juego.
	 * 
	 * @return la lista de unidades del juego
	 */
	public List<Unidad> getUnidades() {
		if (unidades != null) {
			return unidades;
		} else {
			return new ArrayList<>();
		}
	}

	/**
	 * Devuelve el número total de unidades del juego.
	 * 
	 * @return el número total de unidades del juego
	 */
	public int getUds() {
		return uds;
	}

	/**
	 * Establece el número total de unidades del juego.
	 * 
	 * @param uds el número total de unidades del juego
	 */
	public void setUds(int uds) {
		this.uds = uds;
	}

	public static class Unidad implements Serializable {
		/**
		 * Serial version UID for serialization.
		 */
		private static final long serialVersionUID = -3519533619257921015L;

		private String nombre;
		private int id;
		private String idJuego;
		private List<Incidencia> incidencias;
		private Prestamo prestamo;

		/**
		 * Crea un objeto Unidad con la información de la unidad.
		 * 
		 * @param nombre  el nombre de la unidad
		 * @param numero  el número de la unidad
		 * @param idJuego el identificador del juego asociado a la unidad
		 */
		public Unidad(String nombre, int numero, String idJuego) {
			this.setNombreUnidad(nombre);
			this.id = numero;
			this.incidencias = new ArrayList<>();
			this.setIdJuego(idJuego);
			this.prestamo = getPrestamo();
		}

		/**
		 * Devuelve el préstamo asociado a la unidad.
		 * 
		 * @return el préstamo asociado a la unidad
		 */
		public Prestamo getPrestamo() {
			return prestamo;
		}

		/**
		 * Establece el préstamo asociado a la unidad.
		 * 
		 * @param prestamo el préstamo a establecer
		 */
		public void setPrestamo(Prestamo prestamo) {
			this.prestamo = prestamo;
		}

		/**
		 * Devuelve el identificador de la unidad.
		 * 
		 * @return el identificador de la unidad
		 */
		public int getId() {
			return id;
		}

		/**
		 * Agrega una incidencia a la unidad.
		 * 
		 * @param incidencia la incidencia a agregar
		 */
		public void agregarIncidencia(Incidencia incidencia) {
			incidencias.add(incidencia);
		}

		/**
		 * Obtiene la lista de incidencias de la unidad.
		 * 
		 * @return la lista de incidencias de la unidad
		 */
		public List<Incidencia> obtenerIncidencias() {
			return incidencias;
		}

		/**
		 * Devuelve el número de incidencias de la unidad.
		 * 
		 * @return el número de incidencias de la unidad
		 */
		public Integer getIncidendiasNumero() {
			if (obtenerIncidencias().isEmpty()) {
				return 0;
			} else {
				return obtenerIncidencias().size();
			}
		}

		/**
		 * Devuelve el identificador del juego asociado a la unidad.
		 * 
		 * @return el identificador del juego asociado a la unidad
		 */
		public String getIdJuego() {
			return idJuego;
		}

		/**
		 * Establece el identificador del juego asociado a la unidad.
		 * 
		 * @param idJuego el identificador del juego a establecer
		 */
		public void setIdJuego(String idJuego) {
			this.idJuego = idJuego;
		}

		/**
		 * Devuelve el nombre de la unidad.
		 * 
		 * @return el nombre de la unidad
		 */
		public String getNombreUnidad() {
			return nombre;
		}

		/**
		 * Establece el nombre de la unidad.
		 * 
		 * @param nombre el nombre de la unidad a establecer
		 */
		public void setNombreUnidad(String nombre) {
			this.nombre = nombre;
		}

		/**
		 * Devuelve el número de incidencias no resueltas de la unidad.
		 * 
		 * @return el número de incidencias no resueltas de la unidad
		 */
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

		/**
		 * Obtiene la lista de incidencias no resueltas de la unidad.
		 * 
		 * @return la lista de incidencias no resueltas de la unidad
		 */
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
			 * Serial version UID for serialization.
			 */
			private static final long serialVersionUID = 4603311692135041971L;

			private String descripcion;
			private boolean resuelta;

			/**
			 * Crea un objeto Incidencia con la descripción de la incidencia y se marca como
			 * no resuelta.
			 * 
			 * @param descripcion la descripción de la incidencia
			 */
			public Incidencia(String descripcion) {
				this.descripcion = descripcion;
				this.resuelta = false;
			}

			/**
			 * Marca la incidencia como resuelta.
			 */
			public void marcarComoResuelta() {
				resuelta = true;
			}

			/**
			 * Devuelve la descripción de la incidencia.
			 * 
			 * @return la descripción de la incidencia
			 */
			public String getDescripcion() {
				return descripcion;
			}

			/**
			 * Devuelve true si la incidencia está resuelta, false de lo contrario.
			 * 
			 * @return true si la incidencia está resuelta, false de lo contrario
			 */
			public boolean isResuelta() {
				return resuelta;
			}

			/**
			 * Establece la descripción de la incidencia.
			 * 
			 * @param descripcion la descripción de la incidencia a establecer
			 */
			public void setDescripcion(String descripcion) {
				this.descripcion = descripcion;
			}
		}

	}

