package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import model.Juego.Unidad;

public class Prestamo {
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private String usuario;
	private int unidad;
	private String idJuego;

	public Prestamo(String idJuego, int unidad, String usuario, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.usuario = usuario;
		this.setUnidad(unidad);
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getUnidad() {
		return unidad;
	}

	public void setUnidad(int unidad2) {
		this.unidad = unidad2;
	}

	public String getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(String idJuego) {
		this.idJuego = idJuego;
	}
}
