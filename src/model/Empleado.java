package model;

/**
 * Esta clase representa a un empleado, que es un tipo de usuario.
 */
public class Empleado extends Usuario {

	/**
	 * Crea un objeto Empleado con los parámetros especificados.
	 * @param nombre el nombre del empleado
	 * @param apellidos los apellidos del empleado
	 * @param esEmpleado indica si el usuario es un empleado (siempre será true en este caso)
	 * @param contraseña la contraseña del empleado
	 * @param nomUsuario el nombre de usuario del empleado
	 */
	public Empleado(String nombre, String apellidos, Boolean esEmpleado, String contraseña, String nomUsuario) {
		super(nombre, apellidos, esEmpleado, contraseña, nomUsuario);
	}

}

