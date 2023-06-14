package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import animaciones.ZoomAnimation;
import model.Usuario;
import view.VentanaPrincipalEmpleado;

/**
 * Controlador para la ventana principal del empleado.
 */
public class ControladorVentanaEmpleado implements ActionListener {

	private VentanaPrincipalEmpleado ventanaEmpleado; // Ventana principal del empleado

	/**
	 * Constructor de la clase.
	 * 
	 * @param loginWindow Ventana de inicio de sesión
	 * @param usuario     Usuario actualmente logueado
	 */
	public ControladorVentanaEmpleado(view.VentanaLoginWindow loginWindow, Usuario usuario) {
		ventanaEmpleado = new VentanaPrincipalEmpleado();
		ventanaEmpleado.setLocationRelativeTo(loginWindow);
		loginWindow.dispose();

		ventanaEmpleado.getBtnGestionJuegos().addActionListener(this);
		ventanaEmpleado.getBtnGestionUsuarios().addActionListener(this);
		ventanaEmpleado.getBtnGestionPrestamos().addActionListener(this);
		ventanaEmpleado.getBtnGestionIncidencias().addActionListener(this);
		ventanaEmpleado.getBtnGestionSalir().addActionListener(this);

		ventanaEmpleado.getLblRellenarUsuario().setText(usuario.getNombre());
		new ZoomAnimation(ventanaEmpleado.getLblRellenarUsuario());
		ventanaEmpleado.setVisible(true);
	}

	/**
	 * Maneja los eventos de acción.
	 * 
	 * @param e Evento de acción
	 */
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
