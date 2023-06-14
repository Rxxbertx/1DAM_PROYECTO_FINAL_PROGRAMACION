package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import animaciones.AnimacionShake;
import model.Juego;
import model.ModeloGenerico;
import model.ModeloIncidencias;
import model.ModeloPrestamo;
import model.Prestamo;
import model.Videojuego;
import objetosModificados.renderizadoDeCeldaComboBox;
import utilidades.utilidades;
import view.VentanaGestionJuegos;
import view.VentanaPrincipalEmpleado;

/**
 * Controlador para la ventana de gestión de juegos.
 */
public class ControladorVentanaGestionJuegos implements ActionListener, ItemListener {

	private ModeloGenerico<Juego> juegos;
	private ModeloPrestamo prestamos;
	private ModeloIncidencias incidencias;
	private VentanaGestionJuegos ventanaGestionJuegos;

	/**
	 * Constructor de la clase ControladorVentanaGestionJuegos.
	 * 
	 * @param ventanaEmpleado La ventana principal del empleado.
	 */
	public ControladorVentanaGestionJuegos(VentanaPrincipalEmpleado ventanaEmpleado) {

		// Inicializar modelos
		juegos = new ModeloGenerico<>();
		prestamos = new ModeloPrestamo();
		incidencias = new ModeloIncidencias();

		// Configurar ventana
		ventanaGestionJuegos = new VentanaGestionJuegos();
		ventanaGestionJuegos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		ventanaGestionJuegos.setLocationRelativeTo(ventanaEmpleado);

		// Configurar paneles
		configurarPanelVer();
		configurarPanelModificar();
		configurarPanelAñadir();
		configurarPanelEliminar();

		// Configuraciones generales
		configuracionesGenerales();

		// Cambiar al panel "Ver"
		cambioPanel(ventanaGestionJuegos.getPanelCard(), "ver");

		// Mostrar ventana
		ventanaGestionJuegos.setVisible(true);
	}

	/**
	 * Realiza las configuraciones generales de la ventana de gestión de juegos.
	 */
	private void configuracionesGenerales() {
		// Agregar juegos al modelo del combo box
		ventanaGestionJuegos.getModeloComboJuegos().addAll(añadirJuegos());

		// Configurar opciones de plataforma para añadir y modificar
		ventanaGestionJuegos.getcPlataformaAñadir().setModel(new DefaultComboBoxModel<>(new String[] { "Pc", "Movil",
				"PS2", "PS3", "PS4", "PS5", "Xbox Series X", "Nintendo Switch", "Xbox One", "Desconocido" }));
		ventanaGestionJuegos.getcPlataformaModificar().setModel(ventanaGestionJuegos.getcPlataformaAñadir().getModel());
	}

	/**
	 * Configura el panel de eliminación de juegos.
	 */
	private void configurarPanelEliminar() {
		ventanaGestionJuegos.getBtnEliminarJuego().addActionListener(this);
		ventanaGestionJuegos.getBtnEliminar().addActionListener(this);
		ventanaGestionJuegos.getBtnEliminarTodos().addActionListener(this);
		ventanaGestionJuegos.getComboJuegos_1().setRenderer(new renderizadoDeCeldaComboBox());
		ventanaGestionJuegos.getComboJuegos_1().addItemListener(this);
		ventanaGestionJuegos.getComboBoxUnidades().addItemListener(this);
	}

	/**
	 * Configura el panel de añadir juegos.
	 */
	private void configurarPanelAñadir() {
		ventanaGestionJuegos.getBtnAñadirJuego().addActionListener(this);
		ventanaGestionJuegos.getBtnAñadir().addActionListener(this);
		ventanaGestionJuegos.getBtnSeleccionarImagen().addActionListener(this);
	}

	/**
	 * Configura el panel de modificar juegos.
	 */
	private void configurarPanelModificar() {
		ventanaGestionJuegos.getBtnModificarJuego().addActionListener(this);
		ventanaGestionJuegos.getBtnModificar().addActionListener(this);
	}

	/**
	 * Configura el panel de visualización de juegos.
	 */
	private void configurarPanelVer() {
		ventanaGestionJuegos.getComboJuegos().setRenderer(new renderizadoDeCeldaComboBox());
		ventanaGestionJuegos.getBtnVerJuego().addActionListener(this);
		ventanaGestionJuegos.getBtnSeleccionar().addActionListener(this);
		ventanaGestionJuegos.getBtnVerIncidencias().addActionListener(this);
	}

	/**
	 * Realiza las acciones correspondientes a los eventos de acción en la ventana
	 * de gestión de juegos.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		accionesPanelAlta(e);
		accionesPanelBaja(e);
		accionesPanelModificar(e);
		accionesPanelConsulta(e);
	}

	/**
	 * Realiza las acciones correspondientes a los eventos de acción en el panel de
	 * consulta de juegos.
	 * 
	 * @param e Evento de acción
	 */
	private void accionesPanelConsulta(ActionEvent e) {
		if (e.getSource().equals(ventanaGestionJuegos.getBtnVerJuego())) {
			// Acción del botón "Ver Juego"
			cambioPanel(ventanaGestionJuegos.getPanelCard(), "ver");
			cambioPanel(ventanaGestionJuegos.getPanelCard1(), "sinSeleccion");
		}

		if (e.getSource().equals(ventanaGestionJuegos.getBtnSeleccionar())) {
			// Acción del botón "Seleccionar"
			if (ventanaGestionJuegos.getComboJuegos().getSelectedIndex() != -1) {
				cambioPanel(ventanaGestionJuegos.getPanelCard1(), "conSeleccion");

				Juego juego = (Juego) ventanaGestionJuegos.getComboJuegos().getSelectedItem();

				ventanaGestionJuegos.getLblNombreRellenar().setText(juego.getNombre());
				ventanaGestionJuegos.getLblIncidenciasRellenar()
						.setText(String.valueOf(incidencias.obtenerNumeroIncidenciasSinResolver(juego)));
				ventanaGestionJuegos.getLblNumJugadoresRellenar().setText(String.valueOf(juego.getNumJugadores()));
				ventanaGestionJuegos.getLblUnidadesRellenar().setText(String.valueOf(juego.getUnidades().size()));
				ventanaGestionJuegos.getLblUdsUtilizadasRellenar().setText(String.valueOf(juego.getUdsUtilizadas()));

				if (incidencias.obtenerNumeroIncidenciasSinResolver(juego) <= 0) {
					ventanaGestionJuegos.getBtnVerIncidencias().setEnabled(false);
				}

				if (juego instanceof Videojuego) {
					ventanaGestionJuegos.getLblPlataformaRellenar().setText(((Videojuego) juego).getPlatSelecciona());
					ventanaGestionJuegos.getLblCompañiaRellenar().setText(((Videojuego) juego).getCompañia());
				}
			}
		}

		if (e.getSource().equals(ventanaGestionJuegos.getBtnVerIncidencias())) {
			// Acción del botón "Ver Incidencias"
			Juego juego = utilidades.obtenerElementoJuegoComboBox(ventanaGestionJuegos.getComboJuegos());
			new ControladorVentanaVerIncidencias(juego, ventanaGestionJuegos);
		}
	}

	/**
	 * Realiza las acciones correspondientes a los eventos de acción en el panel de
	 * modificación de juegos.
	 * 
	 * @param e Evento de acción
	 */
	private void accionesPanelModificar(ActionEvent e) {
		if (e.getSource().equals(ventanaGestionJuegos.getBtnModificarJuego())) {
			// Acción del botón "Modificar Juego"
			cambioPanel(ventanaGestionJuegos.getPanelCard(), "modificar");
		}
	}

	/**
	 * Realiza las acciones correspondientes a los eventos de acción en el panel de
	 * baja de juegos.
	 * 
	 * @param e Evento de acción
	 */
	private void accionesPanelBaja(ActionEvent e) {
		if (e.getSource().equals(ventanaGestionJuegos.getBtnEliminarJuego())) {
			// Acción del botón "Eliminar Juego"
			cambioPanel(ventanaGestionJuegos.getPanelCard(), "eliminar");
		}

		if (e.getSource().equals(ventanaGestionJuegos.getBtnEliminar())) {
			// Acción del botón "Eliminar"
			if (ventanaGestionJuegos.getComboJuegos_1().getSelectedIndex() != -1
					&& ventanaGestionJuegos.getComboBoxUnidades().getSelectedIndex() != -1) {

				Juego temp = utilidades.obtenerElementoJuegoComboBox(ventanaGestionJuegos.getComboJuegos_1());
				int i = ventanaGestionJuegos.getComboBoxUnidades().getSelectedIndex();
				temp.eliminarUnidad(i);

				ventanaGestionJuegos.getComboBoxUnidades().removeItemAt(i);

				ControladorEscrituraElementos.ModificacionArchivo(juegos);
			}
		}

		if (e.getSource().equals(ventanaGestionJuegos.getBtnEliminarTodos())) {
			// Acción del botón "Eliminar Todos"
			if (ventanaGestionJuegos.getComboJuegos_1().getSelectedIndex() != -1
					&& ventanaGestionJuegos.getComboBoxUnidades().getSelectedIndex() != -1) {

				int i = JOptionPane.showConfirmDialog(ventanaGestionJuegos,
						"ADEVERTENCIA VAS A ELIMINAR EL ARTICULO ENTERO");
				if (i == JOptionPane.YES_OPTION) {
					juegos.eliminar(
							utilidades.obtenerElementoJuegoComboBox(ventanaGestionJuegos.getComboJuegos_1()).getId());

					ventanaGestionJuegos.getModeloComboJuegos()
							.removeElementAt(ventanaGestionJuegos.getComboJuegos_1().getSelectedIndex());

					ControladorEscrituraElementos.ModificacionArchivo(juegos);
				}
			}
		}
	}

	/**
	 * Realiza las acciones correspondientes a los eventos de acción en el panel de
	 * alta de juegos.
	 * 
	 * @param e Evento de acción
	 */
	private void accionesPanelAlta(ActionEvent e) {
		if (e.getSource().equals(ventanaGestionJuegos.getBtnAñadirJuego())) {
			// Acción del botón "Añadir Juego"
			cambioPanel(ventanaGestionJuegos.getPanelCard(), "añadir");
		}

		if (e.getSource().equals(ventanaGestionJuegos.getBtnAñadir())) {
			// Acción del botón "Añadir"
			String nombre = ventanaGestionJuegos.gettNombreAñadir().getText();
			String plataforma = ventanaGestionJuegos.getcPlataformaAñadir().getSelectedItem().toString();
			int jugadores = (int) ventanaGestionJuegos.getNumJugadoresAlta().getValue();
			int unidades = (int) ventanaGestionJuegos.getNumUnidadesAlta().getValue();
			String compañia = ventanaGestionJuegos.getCompañiaAlta().getText();
			String imagen = ventanaGestionJuegos.getLblImagenAñadir().getToolTipText();

			if (nombre.isBlank() | plataforma.isBlank() | jugadores <= 0 | unidades <= 0 | compañia.isBlank()) {
				// Validación de campos vacíos
				new AnimacionShake(ventanaGestionJuegos, 5, 50, 10);
				JOptionPane.showMessageDialog(ventanaGestionJuegos,
						"ERROR EN LA CREACION, FALTAN CAMPOS POR COMPLETAR");
			} else {
				String id = utilidades.generarIdJuego(nombre, plataforma, jugadores);
				añadirJuego(id, nombre, jugadores, unidades, compañia, plataforma, new ImageIcon(imagen));
			}
		}

		if (e.getSource().equals(ventanaGestionJuegos.getBtnSeleccionarImagen())) {
			// Acción del botón "Seleccionar Imagen"
			JFileChooser ficheros = new JFileChooser(new File("src/images"));
			ficheros.addChoosableFileFilter(new FileNameExtensionFilter("Imagen file", "jpg", "jpeg", "png"));
			ficheros.setAcceptAllFileFilterUsed(false);
			File fichero;

			int i = ficheros.showOpenDialog(ventanaGestionJuegos);
			if (i == JFileChooser.APPROVE_OPTION) {
				fichero = ficheros.getSelectedFile();
				ventanaGestionJuegos.getLblImagenAñadir()
						.setIcon(utilidades.resizeIcon(new ImageIcon(fichero.getPath()), 100, 100));
				ventanaGestionJuegos.getLblImagenAñadir().setToolTipText(fichero.getPath());
			}
		}
	}

	/**
	 * Cambia el panel actualmente mostrado en la ventana.
	 *
	 * @param panel       Panel que contiene los diferentes paneles a mostrar.
	 * @param nombrePanel Nombre del panel a mostrar.
	 */
	private void cambioPanel(JPanel panel, String nombrePanel) {

		switch (nombrePanel) {
		case "ver":
			// Acciones específicas para el panel de visualización
			break;
		case "añadir":
			// Acciones específicas para el panel de añadir
			ventanaGestionJuegos.gettNombreAñadir().setText("");
			ventanaGestionJuegos.getNumJugadoresAlta().setValue(0);
			ventanaGestionJuegos.getNumUnidadesAlta().setValue(0);
			ventanaGestionJuegos.getCompañiaAlta().setText("");
			ventanaGestionJuegos.getLblImagenAñadir().setToolTipText("");
			ventanaGestionJuegos.getLblImagenAñadir().setIcon(null);
			break;
		case "modificar":
			// Acciones específicas para el panel de modificar
			break;
		case "eliminar":
			// Acciones específicas para el panel de eliminar
			break;
		case "conSeleccion":
			// Acciones específicas para el panel con selección
			ventanaGestionJuegos.getBtnVerIncidencias().setEnabled(true);
			break;
		default:
			break;
		}

		((CardLayout) panel.getLayout()).show(panel, nombrePanel);
	}

	/**
	 * Añade un juego a la lista de juegos.
	 *
	 * @param id         ID del juego.
	 * @param nombre     Nombre del juego.
	 * @param jugadores  Número de jugadores.
	 * @param unidades   Número de unidades disponibles.
	 * @param compañia   Compañía desarrolladora del juego.
	 * @param plataforma Plataforma del juego.
	 * @param imagen     Icono representativo del juego.
	 */
	private void añadirJuego(String id, String nombre, int jugadores, int unidades, String compañia, String plataforma,
			ImageIcon imagen) {

		Juego juego = new Videojuego(nombre, jugadores, unidades, 0, compañia, plataforma, id, imagen);

		generarUnidades(juego, unidades);

		if (juegos.añadir(id, juego)) {
			JOptionPane.showMessageDialog(ventanaGestionJuegos, "JUEGO INTRODUCIDO CORRECTAMENTE");

			ventanaGestionJuegos.getModeloComboJuegos().addElement(juego);
			ventanaGestionJuegos.getModeloComboJuegos().setSelectedItem(juego);

			try {
				new ControladorEscrituraElementos(juego);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(ventanaGestionJuegos, "JUEGO YA EXISTENTE");
		}
	}

	/**
	 * Genera las unidades correspondientes a un juego.
	 *
	 * @param juego    Juego al que se generarán las unidades.
	 * @param unidades Número de unidades a generar.
	 */
	private void generarUnidades(Juego juego, int unidades) {
		for (int i = 1; i <= unidades; i++) {
			juego.agregarUnidad(new Juego.Unidad("Unidad " + i, i, juego.getId()));
		}
	}

	/**
	 * Añade los juegos existentes a la colección de juegos.
	 *
	 * @return Colección de juegos añadidos.
	 */
	private Collection<? extends Juego> añadirJuegos() {
		try {
			juegos.setElementos(new ControladorLecturaElementos().devolverElementos());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return juegos.getElementos().values();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(ventanaGestionJuegos.getComboBoxUnidades())) {
			if (ventanaGestionJuegos.getComboBoxUnidades().getSelectedIndex() != -1) {
				Juego juego = utilidades.obtenerElementoJuegoComboBox(ventanaGestionJuegos.getComboJuegos_1());
				Prestamo prestamo = prestamos.obtenerPrestamoUnidad(juego,
						ventanaGestionJuegos.getComboBoxUnidades().getSelectedIndex());
				if (prestamo != null) {
					ventanaGestionJuegos.gettEstadoPrestamo().setText("Prestado a " + prestamo.getUsuario());
				} else {
					ventanaGestionJuegos.gettEstadoPrestamo().setText("Sin prestar");
				}
				ventanaGestionJuegos.gettNombreEliminar().setText(juego.getNombre());
				ventanaGestionJuegos.gettPlataformaEliminar()
						.setText(juego instanceof Videojuego ? ((Videojuego) juego).getPlatSelecciona() : "Error");
			} else {
				if (ventanaGestionJuegos.getModeloComboJuegos().getSize() >= 1) {
					// Acciones adicionales cuando no se selecciona una unidad
				} else {
					ventanaGestionJuegos.getModeloComboJuegos()
							.removeElementAt(ventanaGestionJuegos.getComboJuegos_1().getSelectedIndex());
				}
				ventanaGestionJuegos.gettEstadoPrestamo().setText("");
				ventanaGestionJuegos.gettNombreEliminar().setText("");
				ventanaGestionJuegos.gettPlataformaEliminar().setText("");
			}
		}
		if (e.getSource().equals(ventanaGestionJuegos.getComboJuegos_1())) {
			if (ventanaGestionJuegos.getComboJuegos_1().getSelectedIndex() != -1) {
				crearDatosParaComboBoxUnidades();
			} else {
				ventanaGestionJuegos.gettEstadoPrestamo().setText("");
				ventanaGestionJuegos.gettNombreEliminar().setText("");
				ventanaGestionJuegos.gettPlataformaEliminar().setText("");
				ventanaGestionJuegos.getComboBoxUnidades().removeAllItems();
			}
		}
	}

	/**
	 * Crea los datos necesarios para el ComboBox de unidades.
	 */
	private void crearDatosParaComboBoxUnidades() {
		DefaultComboBoxModel<Integer> unidades = new DefaultComboBoxModel<>();
		unidades.addAll(utilidades.extraerNumeroUnidades(
				((Juego) ventanaGestionJuegos.getModeloComboJuegos().getSelectedItem()).getUnidades()));
		if (unidades.getSize() <= 0) {
			ventanaGestionJuegos.getComboBoxUnidades().setModel(unidades);
		} else {
			ventanaGestionJuegos.getComboBoxUnidades().setModel(unidades);
			ventanaGestionJuegos.getComboBoxUnidades().setSelectedIndex(0);
		}
	}

}
