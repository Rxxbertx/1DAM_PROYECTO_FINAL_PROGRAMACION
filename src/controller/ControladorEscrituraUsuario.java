package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import model.Usuario;

public class ControladorEscrituraUsuario {

	private BufferedWriter escritura;

	public ControladorEscrituraUsuario(Usuario usuario) {

		File ficheroDatos = new File("data/datosUsuario.dat");

		if (ficheroDatos.exists()) {

			try {

				escritura = new BufferedWriter(new FileWriter(ficheroDatos, true));

				escribirUsuario(usuario);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			try {

				escritura = new BufferedWriter(new FileWriter(ficheroDatos));

				escribirUsuario(usuario);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void escribirUsuario(Usuario usuario) throws IOException {

		String nombreCodificado = Base64.getEncoder().encodeToString(usuario.getNombre().getBytes());
		String apellidosCodificados = Base64.getEncoder().encodeToString(usuario.getApellidos().getBytes());
		String esEmpleadoCodificado = Base64.getEncoder()
				.encodeToString(String.valueOf(usuario.getEsEmpleado()).getBytes());
		String nomUsuarioCodificado = Base64.getEncoder()
				.encodeToString(String.valueOf(usuario.getNomUsuario()).getBytes());
		String ContraseñaCodificado = Base64.getEncoder()
				.encodeToString(String.valueOf(usuario.getContraseña()).getBytes());

		String temp = (nombreCodificado + "," + apellidosCodificados + "," + esEmpleadoCodificado + ","
				+ ContraseñaCodificado + "," + nomUsuarioCodificado);

		escritura.write(temp);
		escritura.newLine();
		escritura.close();
	}
}
