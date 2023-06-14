package controller;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import view.SplashScreen;

public class Main {

	public static void main(String[] args) {

		try {
			// Establecer el aspecto visual Nimbus Look and Feel
			UIManager.setLookAndFeel(new NimbusLookAndFeel());

			// Mostrar la pantalla de presentación
			new SplashScreen().showSplash();

			// Crear y configurar el controlador para la lectura de datos de usuario
			new ControladorLecturaDatosUsuario();

			// Crear y configurar el controlador para la ventana de inicio de sesión
			new ControladorLoginWindow();
		} catch (Exception e) {
			// Manejar cualquier excepción que ocurra durante la ejecución
		}

	}

}

