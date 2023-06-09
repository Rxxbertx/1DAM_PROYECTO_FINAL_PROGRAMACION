package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import model.Empleado;
import model.ModeloUsuario;
import model.Socio;

public class LecturaDatosUsuario {

	private ModeloUsuario modeloUsuario;

	public LecturaDatosUsuario() {

		modeloUsuario = new ModeloUsuario();

		File ficheroDatos = new File("datosUsuario");

		if (ficheroDatos.exists()) {

			try {

				BufferedReader lector = new BufferedReader(new FileReader(ficheroDatos));
				String linea;
				while ((linea = lector.readLine()) != null) {
					String[] datosUsuario = linea.split(",");

					String nombre = datosUsuario[0];
					String apellido = datosUsuario[1];
					boolean esEmpleado = Boolean.parseBoolean(datosUsuario[2]);
					String contraseña = datosUsuario[3];
					String nomUsuario = datosUsuario[4];

					if (esEmpleado) {
						modeloUsuario.añadir(nomUsuario,
								new Empleado(nombre, apellido, esEmpleado, contraseña, nomUsuario));
					} else {
						modeloUsuario.añadir(nomUsuario,
								new Socio(nombre, apellido, esEmpleado, contraseña, nomUsuario));

					}

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
