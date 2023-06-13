package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

import model.Empleado;
import model.ModeloUsuario;
import model.Socio;

public class LecturaDatosUsuario {

	private ModeloUsuario modeloUsuario;

	public LecturaDatosUsuario() {

		modeloUsuario = new ModeloUsuario();

		File ficheroDatos = new File("data/datosUsuario.dat");

		if (ficheroDatos.exists()) {

			try {

				BufferedReader lector = new BufferedReader(new FileReader(ficheroDatos));
				String linea;
				while ((linea = lector.readLine()) != null) {
					String[] datosUsuario = linea.split(",");

					String nombre = new String(Base64.getDecoder().decode(datosUsuario[0]));
					String apellido = new String(Base64.getDecoder().decode(datosUsuario[1]));
					boolean esEmpleado = Boolean.parseBoolean(new String(Base64.getDecoder().decode(datosUsuario[2])));
					String contraseña = new String(Base64.getDecoder().decode(datosUsuario[3]));
					String nomUsuario = new String(Base64.getDecoder().decode(datosUsuario[4]));

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
