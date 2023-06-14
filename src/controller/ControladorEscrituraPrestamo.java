package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.ModeloPrestamo;
import model.Prestamo;

/**
 * Controlador para la escritura de datos de préstamo en un archivo.
 */
public class ControladorEscrituraPrestamo {

	private BufferedWriter escritura; // Escritura en el archivo

	/**
	 * Constructor de la clase.
	 * 
	 * @param prestamo Préstamo a escribir en el archivo.
	 */
	public ControladorEscrituraPrestamo(Prestamo prestamo) {
		File ficheroDatos = new File("data/prestamos.dat"); // Ruta del archivo de préstamos

		if (ficheroDatos.exists()) {
			try {
				escritura = new BufferedWriter(new FileWriter(ficheroDatos, true));
				escribirPrestamo(prestamo, escritura);
				escritura.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				escritura = new BufferedWriter(new FileWriter(ficheroDatos));
				escribirPrestamo(prestamo, escritura);
				escritura.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Escribe los datos del préstamo en el archivo.
	 * 
	 * @param prestamo  Préstamo a escribir en el archivo.
	 * @param escritura BufferedWriter para la escritura en el archivo.
	 * @throws IOException Si ocurre un error de escritura.
	 */
	private static void escribirPrestamo(Prestamo prestamo, BufferedWriter escritura) throws IOException {
		String fechaFin;
		if (prestamo.getFechaFin() == null) {
			fechaFin = "null";
		} else {
			fechaFin = prestamo.getFechaFin().toString();
		}

		String temp = prestamo.getIdJuego() + "," + prestamo.getUnidad() + "," + prestamo.getUsuario() + ","
				+ prestamo.getFechaInicio().toString() + "," + fechaFin;

		escritura.write(temp);
		escritura.newLine();
	}

	/**
	 * Realiza la modificación del archivo de préstamos.
	 * 
	 * @param prestamo Modelo de préstamo que contiene los préstamos a ser escritos
	 *                 en el archivo.
	 */
	public static void ModificacionArchivo(ModeloPrestamo prestamo) {
		File fichero = new File("data/prestamos_copia.dat"); // Ruta del archivo de copia
		FileWriter acceso;
		BufferedWriter escritura;

		try {
			acceso = new FileWriter(fichero);
			escritura = new BufferedWriter(acceso);

			for (Prestamo str : prestamo.getPrestamos()) {
				escribirPrestamo(str, escritura);
			}

			escritura.close();
			acceso.close();

			sobrescribirArchivoOriginal();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sobrescribe el archivo original de préstamos con la copia actualizada.
	 * 
	 * @throws IOException Si ocurre un error durante la sobrescritura.
	 */
	public static void sobrescribirArchivoOriginal() throws IOException {
		File archivoOriginal = new File("data/prestamos.dat"); // Ruta del archivo original
		File archivoCopia = new File("data/prestamos_copia.dat"); // Ruta del archivo de copia

		if (archivoOriginal.exists()) {
			archivoOriginal.delete();
		}

		archivoCopia.renameTo(archivoOriginal);
	}
}
