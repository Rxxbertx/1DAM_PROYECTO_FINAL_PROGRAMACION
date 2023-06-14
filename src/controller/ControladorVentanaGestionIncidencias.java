package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import model.Juego;
import model.ModeloGenerico;
import model.ModeloIncidencias;
import model.Videojuego;
import utilidades.utilidades;
import view.VentanaGestionIncidencias;
import view.VentanaPrincipalEmpleado;

/**
 * Controlador para la ventana de gestión de incidencias.
 */
public class ControladorVentanaGestionIncidencias implements ActionListener {

	private VentanaGestionIncidencias ventana; // Ventana de gestión de incidencias
	private ModeloGenerico<Juego> juegos; // Modelo de datos para los juegos
	private ModeloIncidencias incidencias; // Modelo de datos para las incidencias

	/**
	 * Constructor de la clase.
	 * 
	 * @param root Ventana principal del empleado
	 */
	public ControladorVentanaGestionIncidencias(VentanaPrincipalEmpleado root) {
		configuracionInicial(root);

		ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		ventana.setVisible(true);
	}

	/**
	 * Realiza la configuración inicial de la ventana.
	 * 
	 * @param ventanaEmpleado Ventana principal del empleado
	 */
	private void configuracionInicial(VentanaPrincipalEmpleado ventanaEmpleado) {
		ventana = new VentanaGestionIncidencias();
		incidencias = new ModeloIncidencias();
		juegos = new ModeloGenerico<>();

		añadirJuegosAPanel();

		ventana.setLocationRelativeTo(ventanaEmpleado);
		ventana.getBtnHistorico().addActionListener(this);
		ventana.getBtnSalir().addActionListener(this);
	}

	/**
	 * Añade los juegos al panel de la ventana.
	 */
	private void añadirJuegosAPanel() {
		try {
			juegos.setElementos(new ControladorLecturaElementos().devolverElementos());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		for (Object juego : juegos.getElementos().values()) {
			Videojuego temp = (Videojuego) juego;

			JButton boton = new JButton();
			boton.setText("<html> <center>" + temp.getNombre() + "<br>" + "(" + temp.getPlatSelecciona() + ")" + "<br>"
					+ "Num Jugadores: " + temp.getNumJugadores() + " </center></html>");
			boton.setIcon(utilidades.resizeIcon(temp.getImagen(), 200, 200));

			boton.setHorizontalAlignment(SwingConstants.CENTER);
			boton.setVerticalAlignment(SwingConstants.CENTER);
			boton.setHorizontalTextPosition(SwingConstants.CENTER);
			boton.setVerticalTextPosition(SwingConstants.BOTTOM);

			boton.setFont(new Font("Tahoma", Font.BOLD, 15));

			// Agregar ActionListener al botón
			boton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Código a ejecutar cuando se hace clic en el botón
					new ControladorVentanaInfoIncidencias(ventana, juegos, temp, incidencias);
				}
			});

			ventana.getPanelJuegos().add(boton);
		}
	}

	/**
	 * Maneja los eventos de acción.
	 * 
	 * @param e Evento de acción
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnSalir())) {
			ventana.dispose();
		}
		if (e.getSource().equals(ventana.getBtnHistorico())) {
			new ControladorVerHistorialIncidencias(ventana, incidencias);
		}
	}
}
