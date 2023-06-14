package model;

public class Socio extends Usuario {

	/**
	 * Crea un objeto Socio con la información del socio.
	 * 
	 * @param nombre       el nombre del socio
	 * @param apellidos    los apellidos del socio
	 * @param esEmpleado   indica si el socio es empleado o no
	 * @param contraseña   la contraseña del socio
	 * @param nomUsuario   el nombre de usuario del socio
	 */
	public Socio(String nombre, String apellidos, Boolean esEmpleado, String contraseña, String nomUsuario) {
		super(nombre, apellidos, esEmpleado, contraseña, nomUsuario);
	}
}
