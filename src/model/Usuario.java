package model;

public abstract class Usuario {

	private String nombre;
	private String apellidos;
	private Boolean esEmpleado;
	private String contraseña;
	private String nomUsuario;

	/**
	 * Crea un objeto Usuario con la información del usuario.
	 * 
	 * @param nombre       el nombre del usuario
	 * @param apellidos    los apellidos del usuario
	 * @param esEmpleado   indica si el usuario es un empleado
	 * @param contraseña   la contraseña del usuario
	 * @param nomUsuario   el nombre de usuario del usuario
	 */
	public Usuario(String nombre, String apellidos, Boolean esEmpleado, String contraseña, String nomUsuario) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.esEmpleado = esEmpleado;
		this.contraseña = contraseña;
		this.nomUsuario = nomUsuario;
	}

	// Constructor por defecto
	public Usuario() {
		super();
	}

	/**
	 * Devuelve el nombre del usuario.
	 * 
	 * @return el nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del usuario.
	 * 
	 * @param nombre el nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve los apellidos del usuario.
	 * 
	 * @return los apellidos del usuario
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Establece los apellidos del usuario.
	 * 
	 * @param apellidos los apellidos del usuario
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Indica si el usuario es un empleado.
	 * 
	 * @return true si el usuario es un empleado, false si no lo es
	 */
	public Boolean getEsEmpleado() {
		return esEmpleado;
	}

	/**
	 * Establece si el usuario es un empleado.
	 * 
	 * @param esEmpleado true si el usuario es un empleado, false si no lo es
	 */
	public void setEsEmpleado(Boolean esEmpleado) {
		this.esEmpleado = esEmpleado;
	}

	/**
	 * Devuelve la contraseña del usuario.
	 * 
	 * @return la contraseña del usuario
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * Establece la contraseña del usuario.
	 * 
	 * @param contraseña la contraseña del usuario
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * Devuelve el nombre de usuario del usuario.
	 * 
	 * @return el nombre de usuario del usuario
	 */
	public String getNomUsuario() {
		return nomUsuario;
	}

	/**
	 * Establece el nombre de usuario del usuario.
	 * 
	 * @param nomUsuario el nombre de usuario del usuario
	 */
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

}

