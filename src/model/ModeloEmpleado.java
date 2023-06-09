package model;

import java.util.HashMap;
import java.util.Map.Entry;

public class ModeloEmpleado {

	private HashMap<Integer, Empleado> empleados = new HashMap<Integer, Empleado>();

	/**
	 * @param empleados
	 */
	public ModeloEmpleado() {
		empleados = new HashMap<Integer, Empleado>();
	}

	public void añadirEmpleado(Empleado empleado) {
		empleados.put(empleado.getIdEmpleado(), empleado);
	}

	public void eliminarEmpleado(Empleado empleado) {
		empleados.remove(empleado);
	}

	public static void gestionarPrestamo() {

	}

	public static void gestionarIncidencia() {

	}

	

}
