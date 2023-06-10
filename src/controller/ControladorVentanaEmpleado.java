package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import animaciones.AnimacionShake;
import animaciones.ZoomAnimation;
import model.Juego;
import model.ModeloGenerico;
import model.Usuario;
import view.VentanaPrincipal;

public class ControladorVentanaEmpleado implements ActionListener {

	private VentanaPrincipal ventanaEmpleado;
	public ControladorVentanaEmpleado(view.LoginWindow loginWindow, Usuario usuario) {

		

		ventanaEmpleado = new VentanaPrincipal();
		ventanaEmpleado.setLocationRelativeTo(loginWindow);
		ventanaEmpleado.getBtnGestionJuegos().addActionListener(this);
		ventanaEmpleado.getBtnGestionUsuarios().addActionListener(this);
		ventanaEmpleado.getLblRellenarUsuario().setText(usuario.getNombre());
		new ZoomAnimation(ventanaEmpleado.getLblRellenarUsuario());
		ventanaEmpleado.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(ventanaEmpleado.getBtnGestionJuegos())) {

			new ControladorGestionJuegos(ventanaEmpleado);

		}
		if (e.getSource().equals(ventanaEmpleado.getBtnGestionUsuarios())) {

			new ControladorGestionUsuarios(ventanaEmpleado);

		}

	}

}
