package utilidades;

import java.awt.Image;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;

import model.Juego;
import model.Juego.Unidad;
import model.Prestamo;

public class utilidades {

	public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}

	public static String obtenerFecha(LocalDateTime localDateTime) {

		if (localDateTime != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
			return new String(localDateTime.format(formatter));
		} else {
			return "";
		}

	}

	public static String generarIdJuego(String nombre, String plataforma, int jugadores) {

		String[] var = nombre.split(" ");
		String[] var2 = plataforma.split(" ");
		String id = "";

		for (int i = 0; i < nombre.split(" ").length; i++) {
			id += var[i].charAt(0);
			id += var[i].length();
		}

		for (String element : var2) {
			id += element;
		}

		return id + jugadores;
	}

	public static Juego obtenerElementoJuegoComboBox(JComboBox<Juego> combo) {

		return ((Juego) combo.getSelectedItem());

	}

	public static Juego obtenerElementoJuegoJList(JList<Juego> lista) {

		return (lista.getSelectedValue());

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

	public static int extraerUnidadPrestada(Juego juego, Prestamo prestamo) {

		juego.setUdsUtilizadas(-1);

		int j = -1;

		for (int i = 0; i < juego.getUnidades().size(); i++) {

			Unidad unidad = juego.obtenerUnidad(i);
			if (unidad.getId() == prestamo.getUnidad()) {
				unidad.setPrestamo(null);
				j = i;
			}

		}
		return j;

	}

	public static Prestamo

			buscarPrestamo(ArrayList<Prestamo> listaPrestamos, Prestamo prestamoBuscado) {
		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.getUsuario().equals(prestamoBuscado.getUsuario())
					&& prestamo.getIdJuego().equals(prestamoBuscado.getIdJuego())
					&& prestamo.getUnidad() == prestamoBuscado.getUnidad()
					&& prestamo.getFechaInicio().equals(prestamoBuscado.getFechaInicio())
					&& prestamo.getFechaFin() == null && prestamoBuscado.getFechaFin() == null) {
				return prestamo;
			}
		}
		return null; // Si no se encuentra el préstamo, se devuelve null
	}

}
