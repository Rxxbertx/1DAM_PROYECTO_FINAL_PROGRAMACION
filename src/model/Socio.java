package model;

public class Socio extends Usuario{
	
	private int idSocio;
	private String nomUsuario;
	
	//Constructor por defecto
	public Socio(String nombre, String apellidos) {
		super(nombre, apellidos);
	}

	//Constructor con parámetros
	public Socio(int idSocio, String nombre, String apellidos, String nomUsuario) {
		super(nombre, apellidos);
		this.idSocio = idSocio;
		this.nomUsuario = nomUsuario;
	}
	
	//Getters y setters

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	
	
	
	
	
	

}
