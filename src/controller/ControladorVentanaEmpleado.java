package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import animaciones.ZoomAnimation;
import model.Usuario;
import view.VentanaLoginWindow;
import view.VentanaPrincipalEmpleado;

public class ControladorVentanaEmpleado implements ActionListener {

	private VentanaPrincipalEmpleado ventanaEmpleado;

	public ControladorVentanaEmpleado(view.VentanaLoginWindow loginWindow, Usuario usuario) {

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

			new ControladorVentanaGestionJuegos(ventanaEmpleado);

		}
		if (e.getSource().equals(ventanaEmpleado.getBtnGestionUsuarios())) {

			new ControladorVentanaGestionUsuarios(ventanaEmpleado);

		}

		if (e.getSource().equals(ventanaEmpleado.getBtnGestionPrestamos())) {
			new ControladorVentanaGestionPrestamos(ventanaEmpleado);
		}

		if (e.getSource().equals(ventanaEmpleado.getBtnGestionIncidencias())) {

			new ControladorVentanaGestionIncidencias(ventanaEmpleado);
		}

		if (e.getSource().equals(ventanaEmpleado.getBtnGestionSalir())) {
			ventanaEmpleado.dispose();
			System.exit(0);
		}

	}

}
