package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.Juego.Unidad;

public class ModeloPrestamo {

	private static ArrayList<Prestamo> prestamos = new ArrayList<>();

	/**
	 * Añade un préstamo al modelo.
	 * 
	 * @param e  el préstamo a añadir
	 */
	public void añadir(Prestamo e) {
		prestamos.add(e);
	}

	/**
	 * Elimina un préstamo del modelo.
	 * 
	 * @param i  el índice del préstamo a eliminar
	 */
	public void eliminar(int i) {
		prestamos.remove(i);
	}

	/**
	 * Obtiene un HashMap con los préstamos de cada unidad en un juego.
	 * 
	 * @param juego  el juego del cual se obtienen los préstamos
	 * @return       un HashMap que mapea el ID de cada unidad con su préstamo
	 */
	public HashMap<Integer, Prestamo> obtenerPrestamosJuego(Juego juego) {
		HashMap<Integer, Prestamo> prestamos = new HashMap<>();

		for (Unidad u : juego.getUnidades()) {
			prestamos.put(u.getId(), u.getPrestamo());
		}

		return prestamos;
	}

	/**
	 * Obtiene el préstamo de una unidad en un juego.
	 * 
	 * @param temp           el juego del cual se obtiene el préstamo
	 * @param selectedIndex  el índice de la unidad seleccionada
	 * @return               el préstamo de la unidad seleccionada
	 */
	public Prestamo obtenerPrestamoUnidad(Juego temp, int selectedIndex) {
		return temp.obtenerUnidad(selectedIndex).getPrestamo();
	}

	/**
	 * Obtiene el préstamo activo de un usuario.
	 * 
	 * @param usuario  el usuario del cual se obtiene el préstamo activo
	 * @return         el préstamo activo del usuario, o null si no tiene uno
	 */
	public Prestamo obtenerPrestamoActivoUsuario(Usuario usuario) {
		for (Prestamo prestamo : getPrestamos()) {
			if (prestamo.getUsuario().equals(usuario.getNomUsuario()) && prestamo.getFechaFin() == null) {
				return prestamo;
			}
		}
		return null;
	}

	/**
	 * Obtiene la lista de todos los préstamos.
	 * 
	 * @return la lista de préstamos
	 */
	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	/**
	 * Establece la lista de préstamos.
	 * 
	 * @param prestamos la lista de préstamos a establecer
	 */
	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		ModeloPrestamo.prestamos = prestamos;
	}
}

