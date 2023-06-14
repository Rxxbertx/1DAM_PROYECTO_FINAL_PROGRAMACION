package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import animaciones.AnimacionShake;
import model.Empleado;
import model.Juego;
import model.ModeloGenerico;
import model.ModeloPrestamo;
import model.ModeloUsuario;
import model.Prestamo;
import model.Socio;
import model.Usuario;
import utilidades.utilidades;
import view.VentanaGestionUsuario;
import view.VentanaPrincipalEmpleado;

public class ControladorVentanaGestionUsuario implements ActionListener, ListSelectionListener {

	private ModeloUsuario modelo;
	private VentanaGestionUsuario ventana;
	private ModeloGenerico<Juego> juegos;
	private Usuario usuario;
	private ModeloPrestamo prestamo;

	/**
	 * Constructor de la clase ControladorVentanaGestionUsuario.
	 * 
	 * @param root    VentanaPrincipalEmpleado que sirve como ventana padre.
	 * @param usuario Usuario que ha iniciado sesión.
	 */
	public ControladorVentanaGestionUsuario(VentanaPrincipalEmpleado root, Usuario usuario) {
		ventana = new VentanaGestionUsuario();
		this.usuario = usuario;

		ventana.setLocationRelativeTo(root);
		ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		configuracionIncial();

		ventana.setVisible(true);
	}

	/**
	 * Realiza la configuración inicial de la ventana.
	 */
	private void configuracionIncial() {
		modelo = new ModeloUsuario();

		prestamo = new ModeloPrestamo();
		new ControladorLecturaPrestamo();

		juegos = new ModeloGenerico<>();

		try {
			juegos.setElementos(new ControladorLecturaElementos().devolverElementos());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		ventana.getBtnAñadir().addActionListener(this);
		ventana.getBtnEliminar().addActionListener(this);
		ventana.getBtnEliminarPanel().addActionListener(this);
		ventana.getList().addListSelectionListener(this);
		ventana.getBtnAñadirPanel().addActionListener(this);

		añadirDatosTabla();
	}

	/**
	 * Añade los datos de los usuarios existentes en la tabla.
	 */
	private void añadirDatosTabla() {
		for (Usuario usuario : modelo.getUsuarios().values()) {
			if (this.usuario.getNomUsuario().equals(usuario.getNomUsuario())) {
				// Omitir el usuario actual
			} else {
				String data = usuario.getNomUsuario() + " ; " + (usuario.getEsEmpleado() ? "Es Empleado" : "Es Socio");
				ventana.getDatos().addElement(data);
			}
		}
	}

	/**
	 * Realiza el cambio de panel en la ventana.
	 * 
	 * @param panel       Panel contenedor.
	 * @param nombrePanel Nombre del panel a mostrar.
	 */
	private void cambioPanel(JPanel panel, String nombrePanel) {
		switch (nombrePanel) {
		case "añadir":
			ventana.gettApellidosRellenar().setText("");
			ventana.gettContraseñaRellenar().setText("");
			ventana.gettNombreRellenar().setText("");
			ventana.gettNomUsuarioRellenar().setText("");
			break;

		case "eliminar":
			if (ventana.getList().getModel().getSize() > 0) {
				ventana.getList().setSelectedIndex(0);
			}
			break;

		default:
			break;
		}

		((CardLayout) panel.getLayout()).show(panel, nombrePanel);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// Manejar el evento de selección de la lista
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnAñadir())) {
			// Acción al pulsar el botón de añadir usuario
			String nombre = ventana.gettNombreRellenar().getText();
			String apellidos = ventana.gettApellidosRellenar().getText();
			String nomUsuario = ventana.gettNomUsuarioRellenar().getText();
			String contraseña = new String(ventana.gettContraseñaRellenar().getPassword());
			Boolean esEmpleado = ventana.getChckbxSerEmpleado().isSelected();

			if (nombre.isBlank() || contraseña.isBlank() || apellidos.isBlank() || nomUsuario.isBlank()) {
				// Mostrar mensaje de error si hay campos vacíos
				new AnimacionShake(ventana.getBtnAñadir(), 2, 50, 20);
				JOptionPane.showMessageDialog(ventana, "RELLENA LOS CAMPOS DE MANERA ADECUADA");
			} else if (modelo.consultar(nomUsuario) != null) {
				// Mostrar mensaje de error si el usuario ya existe
				new AnimacionShake(ventana.getBtnAñadir(), 2, 50, 20);
				JOptionPane.showMessageDialog(ventana, "YA EXISTE ESE USUARIO");
			} else {
				// Crear un nuevo usuario y guardarlo
				if (esEmpleado) {
					new ControladorEscrituraUsuario(
							new Empleado(nombre, apellidos, esEmpleado, nomUsuario, contraseña));
				} else {
					new ControladorEscrituraUsuario(new Socio(nombre, apellidos, esEmpleado, nomUsuario, contraseña));
				}
				cambioPanel(ventana.getPanelCard(), "añadir");
			}
		}

		if (e.getSource().equals(ventana.getBtnEliminar())) {
			// Acción al pulsar el botón de eliminar usuario
			if (ventana.getList().getSelectedIndex() != -1) {
				String data = ventana.getList().getSelectedValue();
				String[] array = data.split(";");
				String userName = array[0].trim();

				Prestamo temp = prestamo.obtenerPrestamoActivoUsuario(modelo.consultar(userName));

				if (temp != null) {
					utilidades.extraerUnidadPrestada(juegos.consultar(temp.getIdJuego()), temp);
					temp.setFechaFin(LocalDateTime.now());

					ControladorEscrituraElementos.ModificacionArchivo(juegos);
					ControladorEscrituraPrestamo.ModificacionArchivo(prestamo);
				}

				modelo.eliminar(userName);
				ControladorEscrituraUsuario.ModificacionArchivo(modelo);
				ventana.getDatos().removeElement(data);
			}
		}

		if (e.getSource().equals(ventana.getBtnEliminarPanel())) {
			// Acción al pulsar el botón de cambiar al panel de eliminación de usuario
			cambioPanel(ventana.getPanelCard(), "eliminar");
		}

		if (e.getSource().equals(ventana.getBtnAñadirPanel())) {
			// Acción al pulsar el botón de cambiar al panel de añadir usuario
			cambioPanel(ventana.getPanelCard(), "añadir");
		}
	}
}
