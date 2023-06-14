package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import model.ModeloUsuario;
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
				escribirUsuario(usuario, escritura);
				escritura.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				escritura = new BufferedWriter(new FileWriter(ficheroDatos));
				escribirUsuario(usuario, escritura);
				escritura.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Escribe los datos del usuario en el archivo.
	 *
	 * @param usuario   Usuario a escribir en el archivo.
	 * @param escritura
	 * @throws IOException Si ocurre un error de escritura.
	 */
	private static void escribirUsuario(Usuario usuario, BufferedWriter escritura) throws IOException {
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

	}

	public static void ModificacionArchivo(ModeloUsuario usuario) {
		File fichero = new File("data/datosUsuario_copia.dat"); // Ruta del archivo de copia
		FileWriter acceso;
		BufferedWriter escritura;

		try {
			acceso = new FileWriter(fichero);
			escritura = new BufferedWriter(acceso);

			for (Usuario str : usuario.getUsuarios().values()) {
				escribirUsuario(str, escritura);

			}

			escritura.close();
			acceso.close();

			sobrescribirArchivoOriginal();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sobrescribe el archivo original de usuarios con la copia actualizada.
	 *
	 * @throws IOException Si ocurre un error durante la sobrescritura.
	 */
	public static void sobrescribirArchivoOriginal() throws IOException {
		File archivoOriginal = new File("data/datosUsuario.dat"); // Ruta del archivo original
		File archivoCopia = new File("data/datosUsuario_copia.dat"); // Ruta del archivo de copia

		if (archivoOriginal.exists()) {
			archivoOriginal.delete();
		}

		archivoCopia.renameTo(archivoOriginal);
	}

}
