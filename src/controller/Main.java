package controller;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import view.SplashScreen;

public class Main {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());

			new SplashScreen().showSplash();
			new ControladorLecturaDatosUsuario();
			new ControladorLoginWindow();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
