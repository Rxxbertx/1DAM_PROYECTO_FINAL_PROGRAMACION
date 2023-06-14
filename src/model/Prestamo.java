package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Prestamo implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -1166145454522290630L;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private String usuario;
	private int unidad;
	private String idJuego;

	/**
	 * Crea un objeto Prestamo con la información del préstamo.
	 * 
	 * @param idJuego       el identificador del juego
	 * @param unidad        el identificador de la unidad
	 * @param usuario       el nombre de usuario del solicitante del préstamo
	 * @param fechaInicio   la fecha y hora de inicio del préstamo
	 * @param fechaFin      la fecha y hora de fin del préstamo
	 */
	public Prestamo(String idJuego, int unidad, String usuario, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		this.idJuego = idJuego;
		this.unidad = unidad;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.usuario = usuario;
	}

	/**
	 * Obtiene la fecha y hora de inicio del préstamo.
	 * 
	 * @return la fecha y hora de inicio del préstamo
	 */
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece la fecha y hora de inicio del préstamo.
	 * 
	 * @param fechaInicio la fecha y hora de inicio del préstamo
	 */
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene la fecha y hora de fin del préstamo.
	 * 
	 * @return la fecha y hora de fin del préstamo
	 */
	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece la fecha y hora de fin del préstamo.
	 * 
	 * @param fechaFin la fecha y hora de fin del préstamo
	 */
	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Obtiene el nombre de usuario del solicitante del préstamo.
	 * 
	 * @return el nombre de usuario del solicitante del préstamo
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece el nombre de usuario del solicitante del préstamo.
	 * 
	 * @param usuario el nombre de usuario del solicitante del préstamo
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene el identificador de la unidad prestada.
	 * 
	 * @return el identificador de la unidad prestada
	 */
	public int getUnidad() {
		return unidad;
	}

	/**
	 * Establece el identificador de la unidad prestada.
	 * 
	 * @param unidad el identificador de la unidad prestada
	 */
	public void setUnidad(int unidad2) {
		this.unidad = unidad2;
	}

	/**
	 * Obtiene el identificador del juego asociado al préstamo.
	 * 
	 * @return el identificador del juego
	 */
	public String getIdJuego() {
		return idJuego;
	}

	/**
	 * Establece el identificador del juego asociado al préstamo.
	 * 
	 * @param idJuego el identificador del juego
	 */
	public void setIdJuego(String idJuego) {
		this.idJuego = idJuego;
	}
}

