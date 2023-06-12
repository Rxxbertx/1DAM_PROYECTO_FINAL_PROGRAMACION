package utilidades;

import java.awt.Image;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import model.Juego;
import model.Juego.Unidad;

public class utilidades {

	public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}

	public static String generarIdJuego(String nombre, String plataforma, int jugadores) {

		String[] var = nombre.split(" ");
		String[] var2 = plataforma.split(" ");
		String id = "";

		for (int i = 0; i < nombre.split(" ").length; i++) {
			id += var[i].charAt(0);
			id += var[i].length();
		}

		for (int i = 0; i < var2.length; i++) {
			id += var2[i];
		}

		return id + jugadores;
	}

	public static Juego obtenerElementoJuegoComboBox(JComboBox<Juego> combo) {

		return ((Juego) combo.getSelectedItem());

	}

	public static List<Integer> extraerNumeroUnidades(List<Unidad> unidades) {

		List<Integer> numeroUnidad = new ArrayList<>();

		for (Unidad unidad : unidades) {

			numeroUnidad.add(unidad.getId());

		}

		return numeroUnidad;

	}

	public static int extraerIncidenciasTotalesUnidades(List<Unidad> unidades) {

		int i = 0;

		for (Unidad unidad : unidades) {

			i += (unidad.getIncidendiasNumero());

		}

		return i;

	}

}
