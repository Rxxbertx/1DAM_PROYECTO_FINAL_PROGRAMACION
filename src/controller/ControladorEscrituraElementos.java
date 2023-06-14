package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Juego;
import model.ModeloGenerico;
import objetosModificados.ObjectOutputStreamNoHead;

/**
 * Controlador para la escritura de datos de elementos (juegos) en un archivo.
 */
public class ControladorEscrituraElementos {

	private FileOutputStream acceso; // Acceso al archivo
	private ObjectOutputStream escritura; // Escritura en el archivo

	/**
	 * Constructor de la clase.
	 * 
	 * @param juego Juego a escribir en el archivo.
	 * @throws IOException Si ocurre un error de escritura.
	 */
	public ControladorEscrituraElementos(Juego juego) throws IOException {
		File fichero = new File("data/elementos.dat"); // Ruta del archivo de elementos

		if (!fichero.exists()) {
			acceso = new FileOutputStream(fichero);
			escritura = new ObjectOutputStream(acceso);
			escritura.writeObject(juego);
		} else {
			acceso = new FileOutputStream(fichero, true);
			escritura = new ObjectOutputStreamNoHead(acceso);
			escritura.writeObject(juego);
		}

		escritura.close();
		acceso.close();
	}

	/**
	 * Realiza la modificación del archivo de elementos.
	 * 
	 * @param modelo Modelo que contiene los elementos a ser escritos en el archivo.
	 */
	public static void ModificacionArchivo(ModeloGenerico<Juego> modelo) {
		File fichero = new File("data/elementos_copia.dat"); // Ruta del archivo de copia
		FileOutputStream acceso;
		ObjectOutputStream escritura;

		try {
			acceso = new FileOutputStream(fichero);
			escritura = new ObjectOutputStream(acceso);

			for (Juego juego : modelo.getElementos().values()) {
				escritura.writeObject(juego);
			}

			escritura.close();
			acceso.close();

			sobrescribirArchivoOriginal();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sobrescribe el archivo original de elementos con la copia actualizada.
	 * 
	 * @throws IOException Si ocurre un error durante la sobrescritura.
	 */
	public static void sobrescribirArchivoOriginal() throws IOException {
		File archivoOriginal = new File("data/elementos.dat"); // Ruta del archivo original
		File archivoCopia = new File("data/elementos_copia.dat"); // Ruta del archivo de copia

		if (archivoOriginal.exists()) {
			archivoOriginal.delete();
		}

		archivoCopia.renameTo(archivoOriginal);
	}
}
