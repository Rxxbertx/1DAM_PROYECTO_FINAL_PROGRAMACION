package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;

import javax.swing.JOptionPane;

import animaciones.AnimacionShake;
import model.Empleado;
import model.ModeloUsuario;
import model.Socio;
import model.Usuario;

public class LoginWindow implements ActionListener {

	private view.LoginWindow loginWindow;
	private ModeloUsuario modeloUsuario;

	public LoginWindow() {

		loginWindow = new view.LoginWindow();
		modeloUsuario = new ModeloUsuario();
		loginWindow.getBtnEntrar().addActionListener(this);
		loginWindow.getBtnAltaLogin().addActionListener(this);
		loginWindow.getBtnAlta().addActionListener(this);
		loginWindow.getBtnVolver().addActionListener(this);
		loginWindow.setVisible(true);
		
		
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(loginWindow.getBtnVolver())) {
			loginWindow.getLblError().setVisible(false);
			((CardLayout) loginWindow.getPanelCard().getLayout()).show(loginWindow.getPanelCard(), "panelLogin");

		}

		if (e.getSource().equals(loginWindow.getBtnAlta())) {

			if (modeloUsuario.consultar(loginWindow.getTextFieldUsuarioRegistro().getText()) != null) {
				JOptionPane.showMessageDialog(loginWindow, "ESE NOMBRE DE USUARIO YA EXISTE", "ALTA", 0);
			} else {

				if (añadirUsuario()) {
					((CardLayout) loginWindow.getPanelCard().getLayout()).show(loginWindow.getPanelCard(),
							"panelLogin");
					loginWindow.getLblError().setVisible(false);
				} else {
					// Otra lógica en caso de que no se cumpla la condición
				}
			}

		}
		if (e.getSource().equals(loginWindow.getBtnAltaLogin())) {

			loginWindow.getTextFieldContraseñaLogin().setText("");
			loginWindow.getTextFieldContraseñaRegistro().setText("");
			((CardLayout) loginWindow.getPanelCard().getLayout()).show(loginWindow.getPanelCard(), "panelRegistrar");

		}
		if (e.getSource().equals(loginWindow.getBtnEntrar())) {

			Usuario usuario = comprobarCredenciales();

			if (usuario != null) {

				if (usuario instanceof Empleado)
					new ControladorVentanaEmpleado(loginWindow, usuario);

				else
					new ControladorVentanaSocio();

				loginWindow.dispose();

			} else {
				loginWindow.getLblError().setVisible(true);
				new AnimacionShake(loginWindow.getLblError());
				new AnimacionShake(loginWindow.getTextFieldUsuarioLogin());
				new AnimacionShake(loginWindow.getTextFieldContraseñaLogin());
			}

		}

	}

	private boolean añadirUsuario() {

		if (loginWindow.getTextFieldNombreRegistro().getText().isBlank()
				| loginWindow.getTextFieldApellidosRegistro().getText().isBlank()
				| new String(loginWindow.getTextFieldContraseñaRegistro().getPassword()).isBlank()
				| loginWindow.getTextFieldUsuarioRegistro().getText().isBlank()) {

			JOptionPane.showMessageDialog(loginWindow, "COMPRUEBA LOS CAMPOS", "ALTA", 0);
			return false;
		} else {

			Usuario usuario = new Socio(loginWindow.getTextFieldNombreRegistro().getText(),
					loginWindow.getTextFieldApellidosRegistro().getText(), false,
					new String(loginWindow.getTextFieldContraseñaRegistro().getPassword()),
					loginWindow.getTextFieldUsuarioRegistro().getText());

			modeloUsuario.añadir(loginWindow.getTextFieldUsuarioRegistro().getText(), usuario);

			new ControladorEscrituraUsuario(usuario);

			JOptionPane.showMessageDialog(loginWindow, "DADO DE ALTA CORRECTAMENTE", "ALTA", 1);

			loginWindow.getTextFieldUsuarioLogin().setText(loginWindow.getTextFieldUsuarioRegistro().getText());
			return true;

		}

	}

	private Usuario comprobarCredenciales() {

		Usuario usuario = modeloUsuario.consultar(loginWindow.getTextFieldUsuarioLogin().getText());
		if (usuario != null && usuario.getContraseña()
				.equals(new String(loginWindow.getTextFieldContraseñaLogin().getPassword()))) {
			return usuario;
		}

		return null;

	}

}
