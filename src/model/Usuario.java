package model;

public abstract class Usuario {

	private String nombre;
	private String apellidos;
	
	

	//COnstructor con parámetros
	public Usuario(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	
	//Constructor por defecto
	public Usuario() {
		super();
	}
	
	//Getters y setters
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

}
