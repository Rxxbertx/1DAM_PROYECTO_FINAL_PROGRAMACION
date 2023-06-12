package controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import model.Juego;
import model.ModeloGenerico;

public class LecturaElementos {

	private ModeloGenerico<Juego> modeloDatos;

	public LecturaElementos() throws IOException, ClassNotFoundException {

		modeloDatos = new ModeloGenerico<>();

		File fichero = new File("data/elementos.dat");

		if (fichero.exists()) {

			FileInputStream acceso = new FileInputStream(fichero);

			ObjectInputStream lectura = new ObjectInputStream(acceso);

			Object datos;

			try {
				while (true) {
					datos = lectura.readObject();

					if (datos instanceof Juego) {

						modeloDatos.añadir(((Juego) (datos)).getId(), (Juego) datos);

					}
				}
			} catch (EOFException eof) {

				System.out.println("Fin de fichero");

			}

			lectura.close();
			acceso.close();

		}

	}

	public HashMap<String, Juego> devolverElementos() {

		return modeloDatos.getElementos();

	}

}
