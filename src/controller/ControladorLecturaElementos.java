package controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import model.Juego;
import model.ModeloGenerico;

/**
 * Controlador para la lectura de elementos desde un archivo.
 */
public class ControladorLecturaElementos {

	private ModeloGenerico<Juego> modeloDatos; // Modelo de datos

	/**
	 * Constructor de la clase.
	 * 
	 * @throws IOException            Excepción de E/S
	 * @throws ClassNotFoundException Excepción de clase no encontrada
	 */
	public ControladorLecturaElementos() throws IOException, ClassNotFoundException {
		modeloDatos = new ModeloGenerico<>();

		File fichero = new File("data/elementos.dat"); // Ruta del archivo de datos de elementos

		if (fichero.exists()) {
			FileInputStream acceso = new FileInputStream(fichero);
			ObjectInputStream lectura = new ObjectInputStream(acceso);
			Object datos;

			try {
				while (true) {
					datos = lectura.readObject();

					if (datos instanceof Juego) {
						modeloDatos.añadir(((Juego) datos).getId(), (Juego) datos);
					}
				}
			} catch (EOFException eof) {
				// Fin del archivo alcanzado
			}

			lectura.close();
			acceso.close();
		}
	}

	/**
	 * Devuelve los elementos leídos del archivo.
	 * 
	 * @return HashMap de elementos
	 */
	public HashMap<String, Juego> devolverElementos() {
		return modeloDatos.getElementos();
	}
}
