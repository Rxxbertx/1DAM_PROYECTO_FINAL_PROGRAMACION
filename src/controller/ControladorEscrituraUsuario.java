package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import model.Usuario;

/**
 * Controlador para la escritura de datos de usuario en un archivo.
 */
public class ControladorEscrituraUsuario {

	private BufferedWriter escritura; // Escritura en el archivo

	/**
	 * Constructor de la clase.
	 * 
	 * @param usuario Usuario a escribir en el archivo.
	 */
	public ControladorEscrituraUsuario(Usuario usuario) {
		File ficheroDatos = new File("data/datosUsuario.dat"); // Ruta del archivo de datos de usuario

		if (ficheroDatos.exists()) {
			try {
				escritura = new BufferedWriter(new FileWriter(ficheroDatos, true));
				escribirUsuario(usuario);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				escritura = new BufferedWriter(new FileWriter(ficheroDatos));
				escribirUsuario(usuario);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Escribe los datos del usuario en el archivo.
	 * 
	 * @param usuario Usuario a escribir en el archivo.
	 * @throws IOException Si ocurre un error de escritura.
	 */
	private void escribirUsuario(Usuario usuario) throws IOException {
		String nombreCodificado = Base64.getEncoder().encodeToString(usuario.getNombre().getBytes());
		String apellidosCodificados = Base64.getEncoder().encodeToString(usuario.getApellidos().getBytes());
		String esEmpleadoCodificado = Base64.getEncoder()
				.encodeToString(String.valueOf(usuario.getEsEmpleado()).getBytes());
		String nomUsuarioCodificado = Base64.getEncoder().encodeToString(usuario.getNomUsuario().getBytes());
		String contraseñaCodificado = Base64.getEncoder().encodeToString(usuario.getContraseña().getBytes());

		String temp = (nombreCodificado + "," + apellidosCodificados + "," + esEmpleadoCodificado + ","
				+ contraseñaCodificado + "," + nomUsuarioCodificado);

		escritura.write(temp);
		escritura.newLine();
		escritura.close();
	}
}
