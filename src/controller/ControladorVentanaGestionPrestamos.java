package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import model.Juego;
import model.ModeloGenerico;
import objetosModificados.renderizadoDeCeldaJList;
import utilidades.utilidades;
import view.VentanaGestionPrestamo;
import view.VentanaPrincipalEmpleado;

public class ControladorVentanaGestionPrestamos implements ActionListener {

	private VentanaGestionPrestamo ventana;
	private ModeloGenerico<Juego> juegos;

	/**
	 * Constructor de la clase ControladorVentanaGestionPrestamos.
	 *
	 * @param ventanaEmpleado La ventana principal del empleado.
	 */
	public ControladorVentanaGestionPrestamos(VentanaPrincipalEmpleado ventanaEmpleado) {
		configuracionInicial(ventanaEmpleado);

		ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		ventana.setVisible(true);
	}

	/**
	 * Realiza la configuración inicial de la ventana de gestión de préstamos.
	 *
	 * @param ventanaEmpleado La ventana principal del empleado.
	 */
	private void configuracionInicial(VentanaPrincipalEmpleado ventanaEmpleado) {
		ventana = new VentanaGestionPrestamo();

		// Carga los elementos de juego desde el controlador de lectura de elementos
		juegos = new ModeloGenerico<>();
		try {
			juegos.setElementos(new ControladorLecturaElementos().devolverElementos());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ventana.setLocationRelativeTo(ventanaEmpleado);
		ventana.getBtnHistorico().addActionListener(this);
		ventana.getBtnVer().addActionListener(this);
		ventana.getBtnSalir().addActionListener(this);

		DefaultListModel<Juego> datos = new DefaultListModel<>();
		ventana.getListPrestamo().setCellRenderer(new renderizadoDeCeldaJList());

		datos.addAll(juegos.getElementos().values());
		ventana.getListPrestamo().setModel(datos);

		if (datos.isEmpty()) {
			JOptionPane.showMessageDialog(ventanaEmpleado, "No hay juegos para mostrar");
			ventana.getBtnVer().setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnSalir())) {
			ventana.dispose();
		}
		if (e.getSource().equals(ventana.getBtnHistorico())) {
			new ControladorVerHistorialPrestamos(ventana);
		}
		if (e.getSource().equals(ventana.getBtnVer())) {
			if (ventana.getListPrestamo().getSelectedIndex() != -1) {
				// Abre la ventana de información del juego seleccionado
				new ControladorVentanaInfoJuegoEmpleado(utilidades.obtenerElementoJuegoJList(ventana.getListPrestamo()),
						juegos, ventana);
			} else {
				JOptionPane.showMessageDialog(ventana, "Selecciona un Elemento Antes de Ver");
			}
		}
	}
}
