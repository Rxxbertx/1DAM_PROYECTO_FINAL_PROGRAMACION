package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Juego;
import model.Juego.Incidencia;
import model.Juego.Unidad;
import model.ModeloGenerico;
import model.ModeloIncidencias;
import model.Usuario;
import model.Videojuego;
import objetosModificados.renderizadoDeCeldaJListUnidadCentrado;
import utilidades.utilidades;
import view.VentanaInfoPrestamos;
import view.VentanaPrinicipalSocio;

public class ControladorVentanaInfoJuego implements ActionListener, ListSelectionListener {

	private VentanaInfoPrestamos ventana;
	private ModeloGenerico<Juego> juegos;
	private Videojuego videojuego;
	private ModeloIncidencias incidencias;

	public ControladorVentanaInfoJuego(Usuario usuario, Videojuego temp, VentanaPrinicipalSocio root,
			ModeloGenerico<Juego> juegosModel) {

		juegos = juegosModel;
		incidencias = new ModeloIncidencias();
		videojuego = temp;
		ventana = new VentanaInfoPrestamos();
		ventana.setLocationRelativeTo(root);

		ventana.setVisible(true);
		configuracionGeneral();

	}

	private void configuracionGeneral() {

		ventana.getBtnDevolver().setVisible(false);
		ventana.getBtnPrestar().addActionListener(this);
		ventana.getListJuegos().addListSelectionListener(this);
		ventana.getListJuegos().setCellRenderer(new renderizadoDeCeldaJListUnidadCentrado());
		DefaultListModel<Unidad> unidades = new DefaultListModel<>();
		unidades.addAll(videojuego.getUnidades());
		ventana.getListJuegos().setModel(unidades);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (!e.getValueIsAdjusting()) {

			if (ventana.getListJuegos().isSelectionEmpty()) {

				ventana.getLbImagenJuego().setIcon(null);
				ventana.getLblCompañiaRellenar().setText("");
				ventana.getLblNombreRellenar().setText("");
				ventana.getLblPlataformaRellenar().setText("");

			} else {

				Unidad selectedValue = ventana.getListJuegos().getSelectedValue();

				ventana.getLbImagenJuego()
						.setIcon(utilidades.resizeIcon(new ImageIcon(videojuego.getImagen()), 150, 150));
				ventana.getLblCompañiaRellenar().setText(videojuego.getCompañia());
				ventana.getLblNombreRellenar().setText(videojuego.getNombre());
				ventana.getLblPlataformaRellenar().setText(videojuego.getPlatSelecciona());
				ventana.gettInformacion().setText("");

				int j = 1;
				String incidencias = "Ninguna";

				for (Incidencia incidencia : selectedValue.obtenerIncidenciasSinResolver()) {

					incidencias += j + "- " + incidencia.getDescripcion() + "\n";
					j++;
				}

				String texto = "Estado: " + (selectedValue.getPrestamo() != null ? "Prestado" : "Disponible") + "\n"
						+ "Incidencias: " + incidencias;

				ventana.gettInformacion().setText(texto);

			}
		}

	}

}
