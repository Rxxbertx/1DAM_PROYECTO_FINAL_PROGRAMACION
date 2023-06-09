package model;

public class Empleado extends Usuario {

	// Constructor con parámetros heredados de la clase abstracta
	public Empleado(String nombre, String apellidos, Boolean esEmpleado, String contraseña, String nomUsuario) {
		super(nombre, apellidos, esEmpleado, contraseña, nomUsuario);
	}

}
