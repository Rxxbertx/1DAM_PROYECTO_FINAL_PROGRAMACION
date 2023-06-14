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

    /**
     * Constructor de la clase ControladorVentanaSocio.
     * 
     * @param login    Ventana de inicio de sesión.
     * @param usuario  Objeto Usuario que representa al socio que ha iniciado sesión.
     */
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
        // Configurar los botones de inicio
        ventana.getBtnDevolver().addActionListener(this);
        ventana.getBtnJuegoPrestado().addActionListener(this);

    }

    private void comprobarPrestamos() {
        // Verificar si el usuario tiene un juego prestado
        new ControladorLecturaPrestamo();

        Prestamo prestamo = prestamos.obtenerPrestamoActivoUsuario(usuario);

        if (prestamo != null) {
            // Si el usuario tiene un juego prestado, se muestra en la ventana principal
            Juego juego = juegos.consultar(prestamo.getIdJuego());
            Videojuego videojuego = (Videojuego) juego;
            cambioPanel(ventana.getPanelCard(), "juego");

            ventana.getBtnJuegoPrestado().setIcon(utilidades.resizeIcon(videojuego.getImagen(), 200, 200));
            ventana.getBtnJuegoPrestado().setText(videojuego.getNombre() + "  Unidad: (" + prestamo.getUnidad() + ")");

        } else {
            // Si el usuario no tiene un juego prestado, se muestra el panel de inicio
            cambioPanel(ventana.getPanelCard(), "inicio");
        }

    }

    private void configurarGeneral(Usuario usuario) {
        // Configurar datos generales y modelos
        this.usuario = usuario;
        juegos = new ModeloGenerico<>();
        prestamos = new ModeloPrestamo();

        try {
            juegos.setElementos(new ControladorLecturaElementos().devolverElementos());
            new ControladorLecturaPrestamo();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ventana.getLblUsuarioRellenar().setText(usuario.getNombre());

        new ZoomAnimation(ventana.getLblUsuarioRellenar());

    }

    private void configurarPanelSalir() {
        // Configurar el panel de salida
        ventana.getBtnSalir().addActionListener(this);
        ventana.getBtnSalirNo().addActionListener(this);
        ventana.getBtnSalirSi().addActionListener(this);

    }

    private void configurarPanelInfoUsuario() {
        // Configurar el panel de información del usuario
        ventana.getBtnAjustesCuenta().addActionListener(this);

    }

    private void configurarPanelVer() {
        // Configurar el panel de visualización de juegos
        ventana.getBtnVerJuegos().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Acciones realizadas al interactuar con los componentes de la ventana
        accionesPanelVer(e);
        accionesPanelInfo(e);
        accionesPanelSalir(e);
        accionesPanelInicio(e);

    }

    private void accionesPanelInicio(ActionEvent e) {
        // Acciones realizadas en el panel de inicio
        if (e.getSource().equals(ventana.getBtnDevolver())) {
            // Devolver el juego prestado por el usuario
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
            // Realizar alguna acción cuando se interactúa con el botón del juego prestado
            new AnimacionShake(ventana.getBtnJuegoPrestado(), 3, 10, 30);
        }

    }

    private void accionesPanelSalir(ActionEvent e) {
        // Acciones realizadas en el panel de salida
        if (e.getSource().equals(ventana.getBtnSalirSi())) {
            // Salir de la aplicación
            ventana.dispose();
        }

        if (e.getSource().equals(ventana.getBtnSalirNo())) {
            // Volver a comprobar los juegos prestados
            comprobarPrestamos();
        }

        if (e.getSource().equals(ventana.getBtnSalir())) {
            // Mostrar el panel de salida
            cambioPanel(ventana.getPanelCard(), "salir");
        }

    }

    private void accionesPanelInfo(ActionEvent e) {
        // Acciones realizadas en el panel de información del usuario
        if (e.getSource().equals(ventana.getBtnAjustesCuenta())) {
            // Mostrar el panel de ajustes de cuenta
            cambioPanel(ventana.getPanelCard(), "ajustes");
        }

    }

    private void accionesPanelVer(ActionEvent e) {
        // Acciones realizadas en el panel de visualización de juegos
        if (e.getSource().equals(ventana.getBtnVerJuegos())) {
            // Mostrar el panel de visualización de juegos
            cambioPanel(ventana.getPanelCard(), "ver");
        }

    }

    private void cambioPanel(JPanel panel, String nombrePanel) {
        // Cambiar al panel especificado
        switch (nombrePanel) {
            case "ajustes":
                // Mostrar el panel de ajustes de cuenta y configurar los datos del usuario
                ventana.getLblApellidosRellenar().setText(usuario.getApellidos());
                ventana.getLblNombreRellenar().setText(usuario.getNombre());
                ventana.getLblUsuarioRellenar2().setText(usuario.getNomUsuario());
                break;
            case "ver":
                // Mostrar el panel de visualización de juegos y agregar los juegos al panel
                añadirJuegosVentana();
                break;
            default:
                break;
        }

        ((CardLayout) panel.getLayout()).show(panel, nombrePanel);
    }

    private void añadirJuegosVentana() {
        // Agregar los juegos al panel de visualización
        try {
            ventana.getPanelJuegos().removeAll();

            juegos.setElementos(new ControladorLecturaElementos().devolverElementos());

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
                        // Abrir la ventana de información del juego cuando se hace clic en el botón
                        new ControladorVentanaInfoJuegoSocio(usuario, temp, ventana, juegos, prestamos);

                    }
                });

                ventana.getPanelJuegos().add(boton);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

