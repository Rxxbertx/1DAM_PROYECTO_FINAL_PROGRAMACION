package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.Juego;
import model.ModeloGenerico;
import model.Videojuego;
import view.GestionJuegos;
import view.VentanaPrincipal;

public class ControladorGestionJuegos implements ActionListener {

	private ModeloGenerico<Juego> juegos;

	private GestionJuegos ventanaGestionJuegos;

	public ControladorGestionJuegos(VentanaPrincipal ventanaEmpleado) {

		juegos = new ModeloGenerico<>();
		ventanaGestionJuegos = new GestionJuegos();
		ventanaGestionJuegos.setLocationRelativeTo(ventanaEmpleado);
		ventanaGestionJuegos.getBtnAñadirJuego().addActionListener(this);
		ventanaGestionJuegos.getBtnEliminarJuego().addActionListener(this);
		ventanaGestionJuegos.getBtnModificarJuego().addActionListener(this);
		ventanaGestionJuegos.getBtnVerJuego().addActionListener(this);
		ventanaGestionJuegos.getBtnAñadir().addActionListener(this);
		ventanaGestionJuegos.getBtnEliminar().addActionListener(this);
		ventanaGestionJuegos.getBtnModificar().addActionListener(this);
		ventanaGestionJuegos.getBtnSeleccionar().addActionListener(this);

		// ventanaGestionJuegos.getModeloComboJuegos().addAll(añadirLabels());

		((CardLayout) ventanaGestionJuegos.getPanelCard().getLayout()).show(ventanaGestionJuegos.getPanelCard(), "ver");

		ventanaGestionJuegos.setVisible(true);

		/*
		 * try { juegos.setElementos(new LecturaElementos().devolverElementos());
		 * 
		 * } catch (ClassNotFoundException | IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

		/*
		 * Juego juego1 = new Videojuego("Need For Speed: No Limits", 1, 20, 0, "",
		 * "EA", new String[] { "Pc", "Movil" }, "", 0, "images/nfsNoLimits.gif");
		 * 
		 * juegos.añadir(1, juego1);
		 * 
		 * JLabel temp = new JLabel(new ImageIcon(((Videojuego) juego1).getImagen()));
		 * temp.setText("  " + juego1.getNombre());
		 * temp.setHorizontalTextPosition(SwingConstants.RIGHT);
		 * 
		 * ventanaGestionJuegos.getModeloComboJuegos().addElement(temp);
		 * 
		 * try { new EscrituraElementos(juegos, juego1); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

	}

	/*
	 * private Collection<? extends JLabel> añadirLabels() {
	 * 
	 * ArrayList<JLabel> datos = new ArrayList<>();
	 * 
	 * if (!juegos.getElementos().isEmpty()) { for (Entry<Integer, Juego> entry :
	 * juegos.getElementos().entrySet()) {
	 * 
	 * Integer key = entry.getKey(); Juego val = entry.getValue();
	 * 
	 * JLabel temp = new JLabel( val instanceof Videojuego ? new
	 * ImageIcon(((Videojuego) val).getImagen()) : null); temp.setText("  " +
	 * val.getNombre()); temp.setHorizontalTextPosition(SwingConstants.RIGHT);
	 * temp.setVerticalAlignment(SwingConstants.CENTER); datos.add(temp);
	 * 
	 * } }
	 * 
	 * return datos; }
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		accionesPanelAlta(e);
		accionesPanelBaja(e);
		accionesPanelModificar(e);
		accionesPanelConsulta(e);

	}

	private void accionesPanelConsulta(ActionEvent e) {

		if (e.getSource().equals(ventanaGestionJuegos.getBtnVerJuego())) {

			((CardLayout) ventanaGestionJuegos.getPanelCard().getLayout()).show(ventanaGestionJuegos.getPanelCard(),
					"ver");

		}

	}

	private void accionesPanelModificar(ActionEvent e) {

		if (e.getSource().equals(ventanaGestionJuegos.getBtnModificarJuego())) {

			((CardLayout) ventanaGestionJuegos.getPanelCard().getLayout()).show(ventanaGestionJuegos.getPanelCard(),
					"modificar");

		}

	}

	private void accionesPanelBaja(ActionEvent e) {

		if (e.getSource().equals(ventanaGestionJuegos.getBtnEliminarJuego())) {

			((CardLayout) ventanaGestionJuegos.getPanelCard().getLayout()).show(ventanaGestionJuegos.getPanelCard(),
					"eliminar");

		}

	}

	private void accionesPanelAlta(ActionEvent e) {

		if (e.getSource().equals(ventanaGestionJuegos.getBtnAñadirJuego())) {

			((CardLayout) ventanaGestionJuegos.getPanelCard().getLayout()).show(ventanaGestionJuegos.getPanelCard(),
					"añadir");

		}

	}

}
