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
import view.GestionJuegos;
import view.VentanaPrincipalEmpleado;

public class ControladorGestionJuegos implements ActionListener, ItemListener {

	private ModeloGenerico<Juego> juegos;

	private GestionJuegos ventanaGestionJuegos;

	private ModeloPrestamo prestamos;

	private ModeloIncidencias incidencias;

	public ControladorGestionJuegos(VentanaPrincipalEmpleado ventanaEmpleado) {

		juegos = new ModeloGenerico<>();
		prestamos = new ModeloPrestamo();
		incidencias = new ModeloIncidencias();

		ventanaGestionJuegos = new GestionJuegos();
		ventanaGestionJuegos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		ventanaGestionJuegos.setLocationRelativeTo(ventanaEmpleado);

		configurarPanelVer();
		configurarPanelModificar();
		configurarPanelAñadir();
		configurarPanelEliminar();

		configuracionesGenerales();

		cambioPanel(ventanaGestionJuegos.getPanelCard(), "ver");

		ventanaGestionJuegos.setVisible(true);

	}

	private void configuracionesGenerales() {
		ventanaGestionJuegos.getModeloComboJuegos().addAll(añadirJuegos());

		ventanaGestionJuegos.getcPlataformaAñadir().setModel(new DefaultComboBoxModel<>(new String[] { "Pc", "Movil",
				"PS2", "PS3", "PS4", "PS5", "Xbox Series X", "Nintendo Switch", "Xbox One", "Desconocido" }));
		ventanaGestionJuegos.getcPlataformaModificar().setModel(ventanaGestionJuegos.getcPlataformaAñadir().getModel());

	}

	private void configurarPanelEliminar() {
		ventanaGestionJuegos.getBtnEliminarJuego().addActionListener(this);
		ventanaGestionJuegos.getBtnEliminar().addActionListener(this);
		ventanaGestionJuegos.getBtnEliminarTodos().addActionListener(this);
		ventanaGestionJuegos.getComboJuegos_1().setRenderer(new renderizadoDeCeldaComboBox());
		ventanaGestionJuegos.getComboJuegos_1().addItemListener(this);
		ventanaGestionJuegos.getComboBoxUnidades().addItemListener(this);
	}

	private void configurarPanelAñadir() {
		ventanaGestionJuegos.getBtnAñadirJuego().addActionListener(this);
		ventanaGestionJuegos.getBtnAñadir().addActionListener(this);
		ventanaGestionJuegos.getBtnSeleccionarImagen().addActionListener(this);
	}

	private void configurarPanelModificar() {
		ventanaGestionJuegos.getBtnModificarJuego().addActionListener(this);
		ventanaGestionJuegos.getBtnModificar().addActionListener(this);
	}

	private void configurarPanelVer() {

		ventanaGestionJuegos.getComboJuegos().setRenderer(new renderizadoDeCeldaComboBox());
		ventanaGestionJuegos.getBtnVerJuego().addActionListener(this);
		ventanaGestionJuegos.getBtnSeleccionar().addActionListener(this);
		ventanaGestionJuegos.getBtnVerIncidencias().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		accionesPanelAlta(e);
		accionesPanelBaja(e);
		accionesPanelModificar(e);
		accionesPanelConsulta(e);

	}

	private void accionesPanelConsulta(ActionEvent e) {

		if (e.getSource().equals(ventanaGestionJuegos.getBtnVerJuego())) {

			cambioPanel(ventanaGestionJuegos.getPanelCard(), "ver");
			cambioPanel(ventanaGestionJuegos.getPanelCard1(), "sinSeleccion");

		}

		if (e.getSource().equals(ventanaGestionJuegos.getBtnSeleccionar())) {

			if (ventanaGestionJuegos.getComboJuegos().getSelectedIndex() != -1) {

				cambioPanel(ventanaGestionJuegos.getPanelCard1(), "conSeleccion");

				Juego juego = (Juego) ventanaGestionJuegos.getComboJuegos().getSelectedItem();

				ventanaGestionJuegos.getLblNombreRellenar().setText(juego.getNombre());

				ventanaGestionJuegos.getLblIncidenciasRellenar()
						.setText(String.valueOf(incidencias.obtenerIncidenciasJuegoSinResolver(juego).size()));
				ventanaGestionJuegos.getLblNumJugadoresRellenar().setText(String.valueOf(juego.getNumJugadores()));

				ventanaGestionJuegos.getLblUnidadesRellenar().setText(String.valueOf(juego.getUnidades().size()));
				ventanaGestionJuegos.getLblUdsUtilizadasRellenar().setText(String.valueOf(juego.getUdsUtilizadas()));

				if (utilidades.extraerIncidenciasTotalesUnidades(juego.getUnidades()) <= 0) {
					ventanaGestionJuegos.getBtnVerIncidencias().setEnabled(false);
				}

				if (juego instanceof Videojuego) {

					ventanaGestionJuegos.getLblPlataformaRellenar().setText(((Videojuego) juego).getPlatSelecciona());
					ventanaGestionJuegos.getLblCompañiaRellenar().setText(((Videojuego) juego).getCompañia());

				}

			}

		}

		if (e.getSource().equals(ventanaGestionJuegos.getBtnVerIncidencias())) {

			Juego juego = utilidades.obtenerElementoJuegoComboBox(ventanaGestionJuegos.getComboJuegos());

			new ControladorVentanaVerIncidencias(juego, ventanaGestionJuegos);

		}

	}

	private void accionesPanelModificar(ActionEvent e) {

		if (e.getSource().equals(ventanaGestionJuegos.getBtnModificarJuego())) {

			cambioPanel(ventanaGestionJuegos.getPanelCard(), "modificar");
		}

	}

	private void accionesPanelBaja(ActionEvent e) {

		if (e.getSource().equals(ventanaGestionJuegos.getBtnEliminarJuego())) {

			cambioPanel(ventanaGestionJuegos.getPanelCard(), "eliminar");

		}

		if (e.getSource().equals(ventanaGestionJuegos.getBtnEliminar())) {

			if (ventanaGestionJuegos.getComboJuegos_1().getSelectedIndex() != -1
					&& ventanaGestionJuegos.getComboBoxUnidades().getSelectedIndex() != -1) {

				Juego temp = utilidades.obtenerElementoJuegoComboBox(ventanaGestionJuegos.getComboJuegos_1());
				int i = ventanaGestionJuegos.getComboBoxUnidades().getSelectedIndex();
				temp.eliminarUnidad(i);

				ventanaGestionJuegos.getComboBoxUnidades().removeItemAt(i);

				EscrituraElementos.ModificacionArchivo(juegos);

			}

		}

		if (e.getSource().equals(ventanaGestionJuegos.getBtnEliminarTodos())) {

			if (ventanaGestionJuegos.getComboJuegos_1().getSelectedIndex() != -1
					&& ventanaGestionJuegos.getComboBoxUnidades().getSelectedIndex() != -1) {

				int i = JOptionPane.showConfirmDialog(ventanaGestionJuegos,
						"ADEVERTENCIA VAS A ELIMINAR EL ARTICULO ENTERO");
				if (i == JOptionPane.YES_OPTION) {
					juegos.eliminar(
							utilidades.obtenerElementoJuegoComboBox(ventanaGestionJuegos.getComboJuegos_1()).getId());

					ventanaGestionJuegos.getModeloComboJuegos()
							.removeElementAt(ventanaGestionJuegos.getComboJuegos_1().getSelectedIndex());

					EscrituraElementos.ModificacionArchivo(juegos);
				}

			}

		}

	}

	private void accionesPanelAlta(ActionEvent e) {

		if (e.getSource().equals(ventanaGestionJuegos.getBtnAñadirJuego())) {

			cambioPanel(ventanaGestionJuegos.getPanelCard(), "añadir");

		}

		if (e.getSource().equals(ventanaGestionJuegos.getBtnAñadir())) {

			String nombre = ventanaGestionJuegos.gettNombreAñadir().getText();
			String plataforma = ventanaGestionJuegos.getcPlataformaAñadir().getSelectedItem().toString();
			int jugadores = (int) ventanaGestionJuegos.getNumJugadoresAlta().getValue();
			int unidades = (int) ventanaGestionJuegos.getNumUnidadesAlta().getValue();
			String compañia = ventanaGestionJuegos.getCompañiaAlta().getText();
			String imagen = ventanaGestionJuegos.getLblImagenAñadir().getToolTipText();

			if (nombre.isBlank() | plataforma.isBlank() | jugadores <= 0 | unidades <= 0 | compañia.isBlank()) {

				new AnimacionShake(ventanaGestionJuegos, 5, 50, 10);
				JOptionPane.showMessageDialog(ventanaGestionJuegos,
						"ERROR EN LA CREACION, FALTAN CAMPOS POR COMPLETAR");

			} else {

				String id = utilidades.generarIdJuego(nombre, plataforma, jugadores);

				añadirJuego(id, nombre, jugadores, unidades, compañia, plataforma, imagen);

			}

		}

		if (e.getSource().equals(ventanaGestionJuegos.getBtnSeleccionarImagen())) {

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
	 *
	 */
	private void cambioPanel(JPanel panel, String nombrePanel) {

		switch (nombrePanel) {
		case "ver":

			break;
		case "añadir":

			ventanaGestionJuegos.gettNombreAñadir().setText("");
			ventanaGestionJuegos.getNumJugadoresAlta().setValue(0);
			ventanaGestionJuegos.getNumUnidadesAlta().setValue(0);
			ventanaGestionJuegos.getCompañiaAlta().setText("");
			ventanaGestionJuegos.getLblImagenAñadir().setToolTipText("");
			ventanaGestionJuegos.getLblImagenAñadir().setIcon(null);

			break;
		case "modificar":

			break;
		case "eliminar":

			break;
		case "conSeleccion":

			ventanaGestionJuegos.getBtnVerIncidencias().setEnabled(true);

			break;

		default:
			break;
		}

		((CardLayout) panel.getLayout()).show(panel, nombrePanel);
	}

	private void añadirJuego(String id, String nombre, int jugadores, int unidades, String compañia, String plataforma,
			String imagen) {

		Juego juego = new Videojuego(nombre, jugadores, unidades, 0, compañia, plataforma, id, imagen);

		generarUnidades(juego, unidades);

		if (juegos.añadir(id, juego)) {
			JOptionPane.showMessageDialog(ventanaGestionJuegos, "JUEGO INTRODUCIDO CORRECTAMENTE");

			ventanaGestionJuegos.getModeloComboJuegos().addElement(juego);
			ventanaGestionJuegos.getModeloComboJuegos().setSelectedItem(juego);

			try {
				new EscrituraElementos(juego);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(ventanaGestionJuegos, "JUEGO YA EXISTENTE");
		}

	}

	private void generarUnidades(Juego juego, int unidades) {

		for (int i = 1; i <= unidades; i++) {

			juego.agregarUnidad(new Juego.Unidad("Unidad " + i, i, juego.getId()));

		}

	}

	private Collection<? extends Juego> añadirJuegos() {

		try {
			juegos.setElementos(new LecturaElementos().devolverElementos());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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

					ventanaGestionJuegos.gettEstadoPrestamo()
							.setText("Prestado a " + prestamo.getUsuario());
				} else {
					ventanaGestionJuegos.gettEstadoPrestamo().setText("Sin prestar");

				}

				ventanaGestionJuegos.gettNombreEliminar().setText(juego.getNombre());

				ventanaGestionJuegos.gettPlataformaEliminar()
						.setText(juego instanceof Videojuego ? ((Videojuego) juego).getPlatSelecciona() : "Error");

			} else {

				if (ventanaGestionJuegos.getModeloComboJuegos().getSize() >= 1) {

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
	 *
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
