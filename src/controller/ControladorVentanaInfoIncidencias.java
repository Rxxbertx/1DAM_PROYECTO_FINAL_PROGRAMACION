package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Juego;
import model.Juego.Incidencia;
import model.ModeloGenerico;
import model.ModeloIncidencias;
import model.Videojuego;
import objetosModificados.renderizadoDeJListCentradoIncidencia;
import utilidades.utilidades;
import view.VentanaGestionIncidencias;
import view.VentanaInfoIncidencias;

/**
 * Controlador para la ventana de información de incidencias de un videojuego.
 */
public class ControladorVentanaInfoIncidencias implements ActionListener, ListSelectionListener, ItemListener {

	private VentanaInfoIncidencias ventana; // Ventana de información de incidencias
	private ModeloGenerico<Juego> juegos; // Modelo de datos de los juegos
	private Videojuego videojuego; // Videojuego actual

	/**
	 * Constructor de la clase.
	 *
	 * @param root        Ventana de gestión de incidencias
	 * @param juegos      Modelo de datos de los juegos
	 * @param temp        Videojuego actual
	 * @param incidencias Modelo de incidencias
	 */
	public ControladorVentanaInfoIncidencias(VentanaGestionIncidencias root, ModeloGenerico<Juego> juegos,
			Videojuego temp, ModeloIncidencias incidencias) {

		this.juegos = juegos;
		this.videojuego = (Videojuego) juegos.consultar(temp.getId());

		ventana = new VentanaInfoIncidencias();
		ventana.setLocationRelativeTo(root);

		configuracionGeneral();

		ventana.setVisible(true);
	}

	/**
	 * Realiza la configuración general de la ventana de información de incidencias.
	 */
	private void configuracionGeneral() {

		// Configuración de los elementos visuales con información del videojuego
		ventana.getLblImagenRellenar().setIcon(utilidades.resizeIcon(videojuego.getImagen(), 100, 100));
		ventana.getLblNombreJuegoRellenar().setText(videojuego.getNombre());
		ventana.getLbNombreRelleno2().setText(videojuego.getNombre());
		ventana.getLblImagenRellenar2().setIcon(utilidades.resizeIcon(videojuego.getImagen(), 100, 100));
		ventana.getLblNumJugaRelleno().setText("Num Jugadores: " + String.valueOf(videojuego.getNumJugadores()));
		ventana.getLblNumJugaRelleno2().setText("Num Jugadores: " + String.valueOf(videojuego.getNumJugadores()));
		ventana.getLblPlataformaRelleno().setText(videojuego.getPlatSelecciona());
		ventana.getLblPlataformaRelleno2().setText(videojuego.getPlatSelecciona());

		// Configuración de los listeners de los botones y otros elementos interactivos
		ventana.getBtnEliminar().addActionListener(this);
		ventana.getBtnAñadir().addActionListener(this);
		ventana.getBtnModificar().addActionListener(this);
		ventana.getBtnAbrir().addActionListener(this);
		ventana.getList().addListSelectionListener(this);
		ventana.getComboJuego().addItemListener(this);

		// Configuración del modelo de datos de la lista de unidades del videojuego
		DefaultListModel<Juego.Unidad> datos = new DefaultListModel<>();
		datos.addAll(videojuego.getUnidades());
		ventana.getList().setCellRenderer(new renderizadoDeJListCentradoIncidencia());
		ventana.getList().setModel(datos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(ventana.getBtnAbrir())) {
			cambioPanel(ventana.getPanelCard(), "sinIncidencias");
		}

		if (e.getSource().equals(ventana.getBtnAñadir())) {
			// Verifica si se ha seleccionado una unidad y se ha introducido una descripción
			// antes de añadir la incidencia
			if (ventana.getTextArea().getText().isBlank() || ventana.getList().getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(ventana,
						"SELECCIONA UNA UNIDAD \n Y DESPUES INTRODUCE ALGO ANTES DE AÑADIR");
			} else {
				// Crea una nueva incidencia y la agrega a la unidad seleccionada
				videojuego.obtenerUnidad(ventana.getList().getSelectedIndex())
						.agregarIncidencia(new Incidencia(ventana.getTextArea().getText()));
				JOptionPane.showMessageDialog(ventana, "INCIDENCIA CREADA CORRECTAMENTE");

				ventana.getTextArea().setText("");

				actualizarDatos();
			}
		}

		if (e.getSource().equals(ventana.getBtnModificar())) {
			// Verifica si se ha ingresado una descripción y si es diferente a la
			// descripción actual antes de modificar la incidencia
			if (ventana.gettIncidencia().getText().isBlank()
					|| videojuego.obtenerUnidad(ventana.getList().getSelectedIndex()).obtenerIncidenciasNoResueltas()
							.get(ventana.getComboJuego().getSelectedIndex()).getDescripcion()
							.equals(ventana.gettIncidencia().getText())) {
				JOptionPane.showMessageDialog(ventana, "ESCRIBE ALGO ANTES DE MODIFICAR");
			} else {
				// Modifica la descripción de la incidencia seleccionada
				videojuego.obtenerUnidad(ventana.getList().getSelectedIndex()).obtenerIncidenciasNoResueltas()
						.get(ventana.getComboJuego().getSelectedIndex())
						.setDescripcion(ventana.gettIncidencia().getText());
				JOptionPane.showMessageDialog(ventana, "INCIDENCIA MODIFICADA CORRECTAMENTE");

				ControladorEscrituraElementos.ModificacionArchivo(juegos);
			}
		}

		if (e.getSource().equals(ventana.getBtnEliminar())) {
			// Marca la incidencia seleccionada como resuelta
			videojuego.obtenerUnidad(ventana.getList().getSelectedIndex()).obtenerIncidenciasNoResueltas()
					.get(ventana.getComboJuego().getSelectedIndex()).marcarComoResuelta();

			JOptionPane.showMessageDialog(ventana, "INCIDENCIA RESUELTA");

			actualizarDatos();
		}
	}

	/**
	 * Actualiza los datos de la ventana de información de incidencias.
	 */
	private void actualizarDatos() {
		int i = ventana.getList().getSelectedIndex();
		ventana.getList().clearSelection();
		ventana.getList().setSelectedIndex(i);

		ControladorEscrituraElementos.ModificacionArchivo(juegos);
	}

	/**
	 * Cambia el panel actual de la ventana.
	 *
	 * @param panel       Panel de la ventana
	 * @param nombrePanel Nombre del panel a mostrar
	 */
	private void cambioPanel(JPanel panel, String nombrePanel) {
		((CardLayout) panel.getLayout()).show(panel, nombrePanel);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource().equals(ventana.getList())) {
			if (ventana.getList().getSelectedIndex() != -1) {
				if (videojuego.obtenerUnidad(ventana.getList().getSelectedIndex())
						.getIncidendiasNumeroSinResolver() > 0) {
					DefaultComboBoxModel<Integer> datosIncidencia = new DefaultComboBoxModel<>();
					ventana.getComboJuego().setModel(datosIncidencia);

					// Agrega los números de incidencia al combo box
					for (int i = 1; i <= videojuego.obtenerUnidad(ventana.getList().getSelectedIndex())
							.getIncidendiasNumeroSinResolver(); i++) {
						datosIncidencia.addElement(i);
					}
					cambioPanel(ventana.getPanelCard(), "conIncidencias");
					ventana.getComboJuego().setSelectedIndex(0);
				} else {
					cambioPanel(ventana.getPanelCard(), "sinIncidencias");
				}
			} else {
				// No se ha seleccionado ninguna unidad
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(ventana.getComboJuego())) {
			if (ventana.getComboJuego().getSelectedIndex() != -1) {
				// Obtiene la descripción de la incidencia seleccionada y la muestra en el campo
				// correspondiente
				String texto = videojuego.obtenerUnidad(ventana.getList().getSelectedIndex())
						.obtenerIncidenciasNoResueltas().get(ventana.getComboJuego().getSelectedIndex())
						.getDescripcion();

				ventana.gettIncidencia().setText(texto);
			} else {
				ventana.gettIncidencia().setText("");
				cambioPanel(ventana.getPanelCard(), "sinIncidencias");
			}
		}
	}
}
