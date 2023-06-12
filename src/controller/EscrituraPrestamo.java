package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Juego;
import model.ModeloGenerico;
import model.ModeloPrestamo;
import model.Prestamo;

public class EscrituraPrestamo {

	private BufferedWriter escritura;

	public EscrituraPrestamo(Prestamo prestamo) {

		File ficheroDatos = new File("data/prestamos.dat");

		if (ficheroDatos.exists()) {

			try {

				escritura = new BufferedWriter(new FileWriter(ficheroDatos, true));

				escribirPrestamo(prestamo, escritura);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			try {

				escritura = new BufferedWriter(new FileWriter(ficheroDatos));

				escribirPrestamo(prestamo, escritura);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private static void escribirPrestamo(Prestamo prestamo, BufferedWriter escritura) throws IOException {

		String fechafin;

		if (prestamo.getFechaFin() == null) {
			fechafin = "null";
		} else {
			fechafin = prestamo.getFechaFin().toString();
		}

		String temp = prestamo.getIdJuego() + "," + prestamo.getUnidad() + "," + prestamo.getUsuario() + ","
				+ prestamo.getFechaInicio().toString() + "," + fechafin;

		escritura.write(temp);
		escritura.newLine();
		escritura.close();

	}

	public static void ModificacionArchivo(ModeloPrestamo prestamo) {

		File fichero = new File("data/prestamos_copia.dat");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void sobrescribirArchivoOriginal() throws IOException {
		File archivoOriginal = new File("data/prestamos.dat");
		File archivoCopia = new File("data/prestamos_copia.dat");

		if (archivoOriginal.exists()) {
			archivoOriginal.delete();
		}

		archivoCopia.renameTo(archivoOriginal);
	}

}
