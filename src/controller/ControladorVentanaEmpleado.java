package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import animaciones.ZoomAnimation;
import model.Usuario;
import view.LoginWindow;
import view.VentanaPrincipalEmpleado;

public class ControladorVentanaEmpleado implements ActionListener {

	private VentanaPrincipalEmpleado ventanaEmpleado;

	public ControladorVentanaEmpleado(view.LoginWindow loginWindow, Usuario usuario) {

		ventanaEmpleado = new VentanaPrincipalEmpleado();
		ventanaEmpleado.setLocationRelativeTo(loginWindow);
		loginWindow.dispose();
		ventanaEmpleado.getBtnGestionJuegos().addActionListener(this);
		ventanaEmpleado.getBtnGestionUsuarios().addActionListener(this);
		ventanaEmpleado.getBtnGestionPrestamos().addActionListener(this);
		ventanaEmpleado.getBtnGestionIncidencias().addActionListener(this);
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

		if (e.getSource().equals(ventanaEmpleado.getBtnGestionPrestamos())) {
			new ControladorGestionPrestamos(ventanaEmpleado);
		}

		if (e.getSource().equals(ventanaEmpleado.getBtnGestionIncidencias())) {
			// todo
		}

		if (e.getSource().equals(ventanaEmpleado.getBtnGestionSalir())) {
			ventanaEmpleado.dispose();
			System.exit(0);
		}

	}

}
