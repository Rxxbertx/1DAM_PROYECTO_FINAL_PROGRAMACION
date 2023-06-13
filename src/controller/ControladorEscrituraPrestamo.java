package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.ModeloPrestamo;
import model.Prestamo;

public class ControladorEscrituraPrestamo {

	private BufferedWriter escritura;

	public ControladorEscrituraPrestamo(Prestamo prestamo) {

		File ficheroDatos = new File("data/prestamos.dat");

		if (ficheroDatos.exists()) {

			try {

				escritura = new BufferedWriter(new FileWriter(ficheroDatos, true));

				escribirPrestamo(prestamo, escritura);
				escritura.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			try {

				escritura = new BufferedWriter(new FileWriter(ficheroDatos));

				escribirPrestamo(prestamo, escritura);
				escritura.close();

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
