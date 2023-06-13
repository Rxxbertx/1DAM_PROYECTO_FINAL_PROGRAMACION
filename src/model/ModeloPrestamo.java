package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.Juego.Unidad;

public class ModeloPrestamo {

	private static ArrayList<Prestamo> prestamos = new ArrayList<>();

	public void añadir(Prestamo e) {

		prestamos.add(e);

	}

	public void eliminar(int i) {
		prestamos.remove(i);
	}

	public HashMap<Integer, Prestamo> obtenerPrestamosJuego(Juego juego) {

		HashMap<Integer, Prestamo> prestamos = new HashMap<>();

		for (Unidad u : juego.getUnidades()) {

			prestamos.put(u.getId(), u.getPrestamo());

		}

		return prestamos;

	}

	public Prestamo obtenerPrestamoUnidad(Juego temp, int selectedIndex) {

		return temp.obtenerUnidad(selectedIndex).getPrestamo();

	}

	public Prestamo obtenerPrestamoActivoUsuario(Usuario usuario) {

		for (Prestamo prestamo : getPrestamos()) {

			if (prestamo.getUsuario().equals(usuario.getNomUsuario())) {

				if (prestamo.getFechaFin() != null) {

				} else {
					return prestamo;
				}
			}

		}
		return null;

	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		ModeloPrestamo.prestamos = prestamos;
	}

}
