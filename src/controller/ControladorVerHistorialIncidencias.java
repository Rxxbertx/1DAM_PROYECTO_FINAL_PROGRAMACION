package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import model.Juego;
import model.Juego.Incidencia;
import model.ModeloGenerico;
import model.ModeloIncidencias;
import view.VentanaGestionIncidencias;
import view.VentanaVerHistorialIncidencias;

public class ControladorVerHistorialIncidencias {

	private VentanaVerHistorialIncidencias ventana;
	private ModeloIncidencias incidencias;
	private ModeloGenerico<Juego> juegos;

	public ControladorVerHistorialIncidencias(VentanaGestionIncidencias root, ModeloIncidencias incidencias) {

		this.incidencias = incidencias;

		ventana = new VentanaVerHistorialIncidencias();

		configuracionGeneral();

	}

	private void configuracionGeneral() {

		try {
			juegos.setElementos(new ControladorLecturaElementos().devolverElementos());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Juego juego : juegos.getElementos().values()) {

			HashMap<Integer, List<Incidencia>> obtencionIncidencias = incidencias.obtenerIncidenciasJuego(juego);

			for (Entry<Integer, List<Incidencia>> entry : obtencionIncidencias.entrySet()) {

				Integer unidad = entry.getKey();
				List<Incidencia> val = entry.getValue();
				
				for (Incidencia incidencia : val) {
					
					
					
					
				}
				

			}

		}

	}

}
