package model;

import model.Juego.Unidad;

public class Prestamo {
	private String fechaInicio;
	private String fechaFin;
	private Usuario usuario;
	private Unidad unidad;

	public Prestamo(String fechaInicio, String fechaFin, Usuario usuario,Unidad unidad) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.usuario = usuario;
		this.unidad=unidad;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
