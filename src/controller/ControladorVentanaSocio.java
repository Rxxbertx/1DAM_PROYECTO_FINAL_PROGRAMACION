package controller;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import animaciones.AnimacionShake;
import animaciones.ZoomAnimation;
import model.Juego;
import model.ModeloGenerico;
import model.ModeloPrestamo;
import model.Prestamo;
import model.Usuario;
import model.Videojuego;
import utilidades.utilidades;
import view.VentanaLoginWindow;
import view.VentanaPrinicipalSocio;

public class ControladorVentanaSocio implements ActionListener {

	private VentanaPrinicipalSocio ventana;
	private ModeloGenerico<Juego> juegos;
	private ModeloPrestamo prestamos;
	private Usuario usuario;

	public ControladorVentanaSocio(VentanaLoginWindow login, Usuario usuario) {

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

		new ControladorLecturaPrestamo();

		Prestamo prestamo = prestamos.obtenerPrestamoActivoUsuario(usuario);

		if (prestamo != null) {

			Juego juego = juegos.consultar(prestamo.getIdJuego());
			Videojuego videojuego = (Videojuego) juego;
			cambioPanel(ventana.getPanelCard(), "juego");

			ventana.getBtnJuegoPrestado().setIcon(utilidades.resizeIcon(videojuego.getImagen(), 200, 200));
			ventana.getBtnJuegoPrestado().setText(videojuego.getNombre() + "  Unidad: (" + prestamo.getUnidad() + ")");

		} else {
			cambioPanel(ventana.getPanelCard(), "inicio");
		}

	}

	private void configurarGeneral(Usuario usuario) {

		this.usuario = usuario;
		juegos = new ModeloGenerico<>();
		prestamos = new ModeloPrestamo();

		try {
			juegos.setElementos(new ControladorLecturaElementos().devolverElementos());
			new ControladorLecturaPrestamo();
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
		accionesPanelInicio(e);

	}

	private void accionesPanelInicio(ActionEvent e) {

		if (e.getSource().equals(ventana.getBtnDevolver())) {

			Prestamo prestamo = prestamos.obtenerPrestamoActivoUsuario(usuario);

			if (prestamo != null) {

				Juego juego = juegos.consultar(prestamo.getIdJuego());

				utilidades.extraerUnidadPrestada(juego, prestamo);

				prestamo.setFechaFin(LocalDateTime.now());

				ControladorEscrituraPrestamo.ModificacionArchivo(prestamos);
				ControladorEscrituraElementos.ModificacionArchivo(juegos);
				comprobarPrestamos();

			} else {
				cambioPanel(ventana.getPanelCard(), "inicio");
			}

		}

		if (e.getSource().equals(ventana.getBtnJuegoPrestado())) {
			new AnimacionShake(ventana.getBtnJuegoPrestado(), 3, 10, 30);
		}

	}

	private void accionesPanelSalir(ActionEvent e) {

		if (e.getSource().equals(ventana.getBtnSalirSi())) {
			ventana.dispose();
		}

		if (e.getSource().equals(ventana.getBtnSalirNo())) {
			comprobarPrestamos();
		}

		if (e.getSource().equals(ventana.getBtnSalir())) {
			cambioPanel(ventana.getPanelCard(), "salir");
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
		case "ver":

			añadirJuegosVentana();

			break;

		default:
			break;
		}

		((CardLayout) panel.getLayout()).show(panel, nombrePanel);
	}

	private void añadirJuegosVentana() {

		try {

			ventana.getPanelJuegos().removeAll();

			juegos.setElementos(new ControladorLecturaElementos().devolverElementos());

			for (Object juego : juegos.getElementos().values()) {

				Videojuego temp = (Videojuego) juego;

				JButton boton = new JButton();
				boton.setText(

						"<html> <center>" + temp.getNombre() + "<br>" + "(" + temp.getPlatSelecciona() + ")" + "<br>"
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
						new ControladorVentanaInfoJuegoSocio(usuario, temp, ventana, juegos, prestamos);

					}
				});

				ventana.getPanelJuegos().add(boton);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
