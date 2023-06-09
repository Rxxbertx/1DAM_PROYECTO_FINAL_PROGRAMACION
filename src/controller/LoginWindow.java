package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JOptionPane;

import model.Empleado;
import model.ModeloUsuario;
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

			new JOptionPane().showMessageDialog(loginWindow, "DADO DE ALTA CORRECTAMENTE", "ALTA", 0);
			((CardLayout) loginWindow.getPanelCard().getLayout()).show(loginWindow.getPanelCard(), "panelLogin");

		}
		if (e.getSource().equals(loginWindow.getBtnAltaLogin())) {

			((CardLayout) loginWindow.getPanelCard().getLayout()).show(loginWindow.getPanelCard(), "panelRegistrar");

		}
		if (e.getSource().equals(loginWindow.getBtnEntrar())) {

			Usuario usuario = comprobarCredenciales();

			if (usuario != null) {

				if (usuario instanceof Empleado)
					new ControladorVentanaEmpleado();
				else
					new ControladorVentanaSocio();
			} else {
				loginWindow.getLblError().setVisible(true);
			}

		}

	}

	private Usuario comprobarCredenciales() {

		Usuario usuario = modeloUsuario.consultar(loginWindow.getTextFieldUsuarioLogin().getText());
		if (usuario != null && usuario.getContraseña().equals(loginWindow.getTextFieldContraseñaLogin())) {
			return usuario;
		}

		return null;

	}

}
