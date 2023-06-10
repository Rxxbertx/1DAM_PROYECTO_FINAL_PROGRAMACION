package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Juego;
import model.ModeloGenerico;
import view.VentanaPrincipal;

public class ControladorVentanaEmpleado implements ActionListener {

	private VentanaPrincipal ventanaEmpleado;
	private ModeloGenerico<Juego> juegos;

	public ControladorVentanaEmpleado(view.LoginWindow loginWindow) {

		juegos = new ModeloGenerico<>();

		try {
			juegos.setElementos(new LecturaElementos().devolverElementos());

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ventanaEmpleado = new VentanaPrincipal();

		ventanaEmpleado.setLocationRelativeTo(loginWindow);

		ventanaEmpleado.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
