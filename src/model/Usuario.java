package model;

public abstract class Usuario {

	private String nombre;
	private String apellidos;
	private Boolean esEmpleado;
	private String contraseña;
	private String nomUsuario;

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

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Boolean getEsEmpleado() {
		return esEmpleado;
	}

	/**
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * @return the nomUsuario
	 */
	public String getNomUsuario() {
		return nomUsuario;
	}

	/**
	 * @param nomUsuario the nomUsuario to set
	 */
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	/**
	 * @param esEmpleado the esEmpleado to set
	 */
	public void setEsEmpleado(Boolean esEmpleado) {
		this.esEmpleado = esEmpleado;
	}

}
