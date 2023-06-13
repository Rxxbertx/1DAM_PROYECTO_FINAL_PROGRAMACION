package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.ModeloPrestamo;
import model.Prestamo;

public class ControladorLecturaPrestamo {

	private ModeloPrestamo modeloPrestamo;

	public ControladorLecturaPrestamo() {

		modeloPrestamo = new ModeloPrestamo();

		modeloPrestamo.setPrestamos(new ArrayList<>());

		File ficheroDatos = new File("data/prestamos.dat");

		if (ficheroDatos.exists()) {

			try {

				BufferedReader lector = new BufferedReader(new FileReader(ficheroDatos));
				String linea;
				while ((linea = lector.readLine()) != null) {
					String[] datosUsuario = linea.split(",");

					String idJuego = datosUsuario[0];
					int idUnidad = Integer.parseInt(datosUsuario[1]);
					String numUsuario = datosUsuario[2];
					LocalDateTime fechaInicio = LocalDateTime.parse(datosUsuario[3]);
					LocalDateTime fechaFin = datosUsuario[4].equals("null") ? null
							: LocalDateTime.parse(datosUsuario[4]);

					modeloPrestamo.añadir(new Prestamo(idJuego, idUnidad, numUsuario, fechaInicio, fechaFin));

				}
				lector.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

		}

	}

}
