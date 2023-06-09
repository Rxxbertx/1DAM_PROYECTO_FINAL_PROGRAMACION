package model;

import java.util.HashMap;

public class Empleado extends Usuario {

	// Atributos
	private int idEmpleado;

	// Constructor por defecto
	public Empleado(String nombre, String apellidos) {
		super(nombre, apellidos);
	}

	// Constructor con parámetros heredados de la clase abstracta
	public Empleado(int idEmpleado, String nombre, String apellidos) {
		super(nombre, apellidos);
		this.idEmpleado = idEmpleado;
	}

	// Getters y setters
	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

}
