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
	private ObjectOutputStream lectura;

	public EscrituraElementos(ModeloGenerico<Juego> modelo, Juego juego) throws IOException {

		File fichero = new File("data/elementos.dat");

		if (!fichero.exists()) {

			acceso = new FileOutputStream(fichero);

			lectura = new ObjectOutputStream(acceso);

			lectura.writeObject(juego);

		} else {

			acceso = new FileOutputStream(fichero, true);

			lectura = new ObjectOutputStreamNoHead(acceso);

			lectura.writeObject(juego);

		}

	}

}
