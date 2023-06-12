package controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;

import model.Juego;
import model.ModeloGenerico;
import objetosModificados.ObjectOutputStreamNoHead;

public class EscrituraElementos {

	private FileOutputStream acceso;
	private ObjectOutputStream escritura;

	public EscrituraElementos(Juego juego) throws IOException {

		File fichero = new File("data/elementos.dat");

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

	public static void ModificacionArchivo(ModeloGenerico<Juego> modelo) {

		File fichero = new File("data/elementos_copia.dat");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void sobrescribirArchivoOriginal() throws IOException {
		File archivoOriginal = new File("data/elementos.dat");
		File archivoCopia = new File("data/elementos_copia.dat");

		if (archivoOriginal.exists()) {
			archivoOriginal.delete();
		}

		archivoCopia.renameTo(archivoOriginal);
	}

}
