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

public class ControladorVentanaInfoIncidencias implements ActionListener, ListSelectionListener, ItemListener {

	private VentanaInfoIncidencias ventana;
	private ModeloGenerico<Juego> juegos;
	private Videojuego videojuego;

	public ControladorVentanaInfoIncidencias(VentanaGestionIncidencias root, ModeloGenerico<Juego> juegos,
			Videojuego temp, ModeloIncidencias incidencias) {

		this.juegos = juegos;
		this.videojuego = (Videojuego) juegos.consultar(temp.getId());

		ventana = new VentanaInfoIncidencias();
		ventana.setLocationRelativeTo(root);

		configuracionGeneral();

		ventana.setVisible(true);

	}

	private void configuracionGeneral() {

		ventana.getLblImagenRellenar().setIcon(utilidades.resizeIcon(videojuego.getImagen(), 100, 100));
		ventana.getLblNombreJuegoRellenar().setText(videojuego.getNombre());
		ventana.getLbNombreRelleno2().setText(videojuego.getNombre());
		ventana.getLblImagenRellenar2().setIcon(utilidades.resizeIcon(videojuego.getImagen(), 100, 100));
		ventana.getLblNumJugaRelleno().setText("Num Jugadores: " + String.valueOf(videojuego.getNumJugadores()));
		ventana.getLblNumJugaRelleno2().setText("Num Jugadores: " + String.valueOf(videojuego.getNumJugadores()));
		ventana.getLblPlataformaRelleno().setText(videojuego.getPlatSelecciona());
		ventana.getLblPlataformaRelleno2().setText(videojuego.getPlatSelecciona());

		ventana.getBtnEliminar().addActionListener(this);
		ventana.getBtnAñadir().addActionListener(this);
		ventana.getBtnModificar().addActionListener(this);
		ventana.getBtnAbrir().addActionListener(this);
		ventana.getList().addListSelectionListener(this);
		ventana.getComboJuego().addItemListener(this);

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

			if (ventana.getTextArea().getText().isBlank() | ventana.getList().getSelectedIndex() == -1) {

				JOptionPane.showMessageDialog(ventana,
						"SELECCIONA UNA UNIDAD \n Y DESPUES INTRODUCE ALGO ANTES DE AÑADIR");
			} else {

				videojuego.obtenerUnidad(ventana.getList().getSelectedIndex())
						.agregarIncidencia(new Incidencia(ventana.getTextArea().getText()));
				JOptionPane.showMessageDialog(ventana, "INCIDENCIA CREADA CORRECTAMENTE");

				ventana.getTextArea().setText("");

				actualizarDatos();

			}

		}

		if (e.getSource().equals(ventana.getBtnModificar())) {

			if (ventana.gettIncidencia().getText().isBlank()
					| videojuego.obtenerUnidad(ventana.getList().getSelectedIndex()).obtenerIncidenciasNoResueltas()
							.get(ventana.getComboJuego().getSelectedIndex()).getDescripcion()
							.equals(ventana.gettIncidencia().getText())) {

				JOptionPane.showMessageDialog(ventana, "ESCRIBE ALGO ANTES DE MODIFICAR");

			} else {
				videojuego.obtenerUnidad(ventana.getList().getSelectedIndex()).obtenerIncidenciasNoResueltas()
						.get(ventana.getComboJuego().getSelectedIndex())
						.setDescripcion(ventana.gettIncidencia().getText());
				JOptionPane.showMessageDialog(ventana, "INCIDENCIA MODIFICADA CORRECTAMENTE");

				ControladorEscrituraElementos.ModificacionArchivo(juegos);
			}

		}

		if (e.getSource().equals(ventana.getBtnEliminar())) {

			videojuego.obtenerUnidad(ventana.getList().getSelectedIndex()).obtenerIncidenciasNoResueltas()
					.get(ventana.getComboJuego().getSelectedIndex()).marcarComoResuelta();

			JOptionPane.showMessageDialog(ventana, "INCIDENCIA RESUELTA");

			actualizarDatos();

		}

	}

	/**
	 *
	 */
	private void actualizarDatos() {
		int i = ventana.getList().getSelectedIndex();
		ventana.getList().clearSelection();
		ventana.getList().setSelectedIndex(i);

		ControladorEscrituraElementos.ModificacionArchivo(juegos);

	}

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

			}

		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource().equals(ventana.getComboJuego())) {

			if (ventana.getComboJuego().getSelectedIndex() != -1) {

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
