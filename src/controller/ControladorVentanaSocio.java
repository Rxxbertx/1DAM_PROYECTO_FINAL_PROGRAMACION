package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import animaciones.ZoomAnimation;
import model.Juego;
import model.ModeloGenerico;
import model.ModeloPrestamo;
import model.Prestamo;
import model.Usuario;
import model.Videojuego;
import utilidades.utilidades;
import view.LoginWindow;
import view.VentanaPrincipalEmpleado;
import view.VentanaPrinicipalSocio;

public class ControladorVentanaSocio implements ActionListener {

	private VentanaPrinicipalSocio ventana;
	private ModeloGenerico juegos;
	private ModeloPrestamo prestamos;
	private Usuario usuario;

	public ControladorVentanaSocio(LoginWindow login, Usuario usuario) {

		ventana = new VentanaPrinicipalSocio();

		ventana.setLocationRelativeTo(login);
		login.dispose();

		configurarGeneral(usuario);
		configurarPanelVer();
		configurarPanelInfoUsuario();
		configurarPanelSalir();
		configurarPanelInicio();
		comprobarPrestamos();
		ventana.setVisible(true);

	}

	private void configurarPanelInicio() {

		ventana.getBtnDevolver().addActionListener(this);
		ventana.getBtnJuegoPrestado().addActionListener(this);

	}

	private void comprobarPrestamos() {

		Prestamo prestamo = prestamos.obtenerPrestamoActivoUsuario(usuario);
		Juego juego = (Juego) juegos.consultar(prestamo.getIdJuego());
		Videojuego videojuego = (Videojuego) juego;

		if (prestamo != null) {

			cambioPanel(ventana.getPanelCard(), "juego");

			ventana.getBtnJuegoPrestado()
					.setIcon(utilidades.resizeIcon(new ImageIcon(videojuego.getImagen()), 150, 150));
			ventana.getBtnJuegoPrestado().setText(videojuego.getNombre() + "Unidad: (" + prestamo.getUnidad() + ")");

		} else {
			cambioPanel(ventana.getPanelCard(), "inicio");
		}

	}

	private void configurarGeneral(Usuario usuario) {

		this.usuario = usuario;
		juegos = new ModeloGenerico<>();
		prestamos = new ModeloPrestamo();

		try {
			juegos.setElementos(new LecturaElementos().devolverElementos());
			new LecturaPrestamo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ventana.getLblUsuarioRellenar().setText(usuario.getNombre());

		new ZoomAnimation(ventana.getLblUsuarioRellenar());

	}

	private void configurarPanelSalir() {

		ventana.getBtnSalir().addActionListener(this);
		ventana.getBtnSalirNo().addActionListener(this);
		ventana.getBtnSalirSi().addActionListener(this);

	}

	private void configurarPanelInfoUsuario() {
		ventana.getBtnAjustesCuenta().addActionListener(this);

	}

	private void configurarPanelVer() {
		ventana.getBtnVerJuegos().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		accionesPanelVer(e);
		accionesPanelInfo(e);
		accionesPanelSalir(e);

	}

	private void accionesPanelSalir(ActionEvent e) {

		if (e.getSource().equals(ventana.getBtnSalirSi())) {
			ventana.dispose();
		}

		if (e.getSource().equals(ventana.getBtnSalirNo())) {
			comprobarPrestamos();
		}

	}

	private void accionesPanelInfo(ActionEvent e) {

		if (e.getSource().equals(ventana.getBtnAjustesCuenta())) {
			cambioPanel(ventana.getPanelCard(), "ajustes");
		}

	}

	private void accionesPanelVer(ActionEvent e) {

		if (e.getSource().equals(ventana.getBtnVerJuegos())) {

			cambioPanel(ventana.getPanelCard(), "ver");

		}

	}

	private void cambioPanel(JPanel panel, String nombrePanel) {

		switch (nombrePanel) {
		case "ajustes":

			ventana.getLblApellidosRellenar().setText(usuario.getApellidos());
			ventana.getLblNombreRellenar().setText(usuario.getNombre());
			ventana.getLblUsuarioRellenar2().setText(usuario.getNomUsuario());

			break;
		case "salir":

			break;
		case "ver":

			añadirJuegosVentana();

			break;
		case "eliminar":

			break;
		case "conSeleccion":

			break;

		default:
			break;
		}

		((CardLayout) panel.getLayout()).show(panel, nombrePanel);
	}

	private void añadirJuegosVentana() {

		for (Object juego : juegos.getElementos().values()) {

			Videojuego temp = (Videojuego) juego;

			JButton boton = new JButton();
			boton.setText(temp.getNombre());
			boton.setIcon(utilidades.resizeIcon(new ImageIcon(temp.getImagen()), 100, 100));
			boton.setVerticalTextPosition(SwingConstants.BOTTOM);

			// Agregar ActionListener al botón
			boton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Código a ejecutar cuando se hace clic en el botón
					new ControladorVentanaInfoJuego(usuario, temp, ventana);

				}
			});

			ventana.getPanelJuegos().add(boton);

		}

	}

}
