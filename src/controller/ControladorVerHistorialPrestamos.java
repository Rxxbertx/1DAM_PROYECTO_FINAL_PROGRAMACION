package controller;

import java.awt.Window;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import model.Juego;
import model.ModeloGenerico;
import model.ModeloPrestamo;
import model.Prestamo;
import model.Videojuego;
import objetosModificados.renderizaDeImagenTabla;
import utilidades.utilidades;
import view.GestionPrestamo;
import view.VentanaHistorialPrestamos;

public class ControladorVerHistorialPrestamos {

	private VentanaHistorialPrestamos ventana;
	private ModeloPrestamo prestamos;
	private ModeloGenerico<Juego> juegos;

	public ControladorVerHistorialPrestamos(GestionPrestamo root) {

		// Definir los nombres de las columnas

		ventana = new VentanaHistorialPrestamos();

		prestamos = new ModeloPrestamo();
		new ControladorLecturaPrestamo();
		juegos = new ModeloGenerico<Juego>();
		try {
			juegos.setElementos(new ControladorLecturaElementos().devolverElementos());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Crear el modelo de tabla con los datos y las columnas

		añadirDatosTabla();

		ventana.setModal(true);
		ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		ventana.setLocationRelativeTo(root);
		ventana.setVisible(true);

	}

	private void añadirDatosTabla() {

		for (Prestamo prestamo : prestamos.getPrestamos()) {

			Juego temp = juegos.consultar(prestamo.getIdJuego());

			ventana.getDatos()
					.addRow(new String[] { temp.getNombre(), temp.getId(), String.valueOf(prestamo.getUnidad()),
							prestamo.getUsuario(), utilidades.obtenerFecha(prestamo.getFechaInicio()),
							utilidades.obtenerFecha(prestamo.getFechaFin()), });

		}

	}

}
