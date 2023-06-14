package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Juego;
import model.Juego.Incidencia;
import model.Juego.Unidad;
import model.ModeloGenerico;
import model.ModeloPrestamo;
import model.Prestamo;
import model.Usuario;
import model.Videojuego;
import objetosModificados.renderizadoDeCeldaJListUnidadCentrado;
import utilidades.utilidades;
import view.VentanaInfoPrestamos;
import view.VentanaPrinicipalSocio;
public class ControladorVentanaInfoJuegoSocio implements ActionListener, ListSelectionListener {

	// Atributos
	
	private VentanaInfoPrestamos ventana;                   // Ventana de información de préstamos
	private ModeloGenerico<Juego> juegos;                    // Modelo de juegos
	private Videojuego videojuego;                           // Videojuego actual
	private ModeloPrestamo prestamos;                        // Modelo de préstamos
	private Usuario usuario;                                 // Usuario actual

	/**
	 * Constructor de la clase ControladorVentanaInfoJuegoSocio.
	 * 
	 * @param usuario       Usuario actual
	 * @param temp          Videojuego actual
	 * @param root          Ventana principal del socio
	 * @param juegosModel   Modelo de juegos
	 * @param prestamos     Modelo de préstamos
	 */
	public ControladorVentanaInfoJuegoSocio(Usuario usuario, Videojuego temp, VentanaPrinicipalSocio root,
			ModeloGenerico<Juego> juegosModel, ModeloPrestamo prestamos) {
		// Inicializar los atributos con los parámetros proporcionados
		this.juegos = juegosModel;
		this.videojuego = temp;
		this.usuario = usuario;
		this.prestamos = prestamos;

		// Crear una instancia de la ventana de información de préstamos
		this.ventana = new VentanaInfoPrestamos();
		this.ventana.setLocationRelativeTo(root);

		// Configurar la ventana y mostrarla
		configuracionGeneral();
		ventana.setVisible(true);
	}

	/**
	 * Configuración general de la ventana de información de préstamos.
	 */
	private void configuracionGeneral() {
		// Establecer la imagen del juego en la ventana
		ventana.getLbImagenJuego().setIcon(utilidades.resizeIcon(videojuego.getImagen(), 150, 150));
		// Mostrar la compañía, nombre y plataforma del videojuego
		ventana.getLblCompañiaRellenar().setText(videojuego.getCompañia());
		ventana.getLblNombreRellenar().setText(videojuego.getNombre());
		ventana.getLblPlataformaRellenar().setText(videojuego.getPlatSelecciona());

		// Verificar si el usuario tiene un préstamo activo para este juego
		Prestamo prestamo = prestamos.obtenerPrestamoActivoUsuario(usuario);
		if (prestamo == null) {
			// Si no tiene un préstamo activo, deshabilitar el botón de préstamo
			ventana.getBtnPrestar().setEnabled(false);
		} else {
			// Si tiene un préstamo activo, ocultar el botón de préstamo
			ventana.getBtnPrestar().setVisible(false);
			ventana.getBtnPrestar().setEnabled(false);
		}

		// Ocultar el botón de devolución
		ventana.getBtnDevolver().setVisible(false);

		// Agregar el controlador de eventos al botón de préstamo
		ventana.getBtnPrestar().addActionListener(this);
		// Agregar el controlador de eventos al componente de lista de juegos
		ventana.getListJuegos().addListSelectionListener(this);
		// Configurar el renderizado de las celdas de la lista de juegos
		ventana.getListJuegos().setCellRenderer(new renderizadoDeCeldaJListUnidadCentrado());

		// Crear un modelo de lista y agregar las unidades del videojuego
		DefaultListModel<Juego.Unidad> unidades = new DefaultListModel<>();
		unidades.addAll(videojuego.getUnidades());
		ventana.getListJuegos().setModel(unidades);

		// Establecer el comportamiento de cierre de la ventana
		ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	/**
	 * Manejador de eventos para el botón de préstamo.
	 * 
	 * @param e     Evento de acción
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnPrestar())) {
			// Obtener la unidad seleccionada en la lista de juegos
			Juego.Unidad unidad = videojuego.obtenerUnidad(ventana.getListJuegos().getSelectedIndex());

			// Crear un objeto Prestamo con la información del préstamo
			Prestamo prestamo = new Prestamo(videojuego.getId(), unidad.getId(), usuario.getNomUsuario(),
					LocalDateTime.now(), null);

			// Establecer el préstamo en la unidad
			unidad.setPrestamo(prestamo);

			// Agregar el préstamo al modelo de préstamos
			prestamos.añadir(prestamo);

			// Incrementar la cantidad de unidades utilizadas del videojuego
			videojuego.setUdsUtilizadas(1);

			// Actualizar el modelo de juegos
			juegos.añadir(videojuego.getId(), videojuego);

			// Guardar los cambios en el archivo
			ControladorEscrituraElementos.ModificacionArchivo(juegos);

			// Crear un controlador para escribir el préstamo en un archivo
			new ControladorEscrituraPrestamo(prestamo);

			// Ocultar el botón de préstamo
			ventana.getBtnPrestar().setVisible(false);

			// Mostrar un mensaje de éxito al realizar el préstamo
			JOptionPane.showMessageDialog(ventana, "PRESTAMO REALIZADO, DISFRUTE DE SU JUEGO");

			// Limpiar la selección en la lista de juegos
			ventana.getListJuegos().clearSelection();
		}
	}

	/**
	 * Manejador de eventos para la selección de elementos en la lista de juegos.
	 * 
	 * @param e     Evento de selección
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			if (ventana.getListJuegos().isSelectionEmpty()) {
				// Si no se selecciona ninguna unidad, mostrar información vacía
				ventana.gettInformacion().setText("");
			} else {
				// Obtener la unidad seleccionada
				Unidad selectedValue = ventana.getListJuegos().getSelectedValue();

				// Construir el texto de información de la unidad seleccionada
				int j = 1;
				StringBuilder incidencias = new StringBuilder();
				for (Incidencia incidencia : selectedValue.obtenerIncidencias()) {
					if (!incidencia.isResuelta()) {
						incidencias.append(j).append("- ").append(incidencia.getDescripcion()).append("\n");
						j++;
					}
				}

				// Construir el texto de estado y incidencias
				String estado = "";
				if (selectedValue.getPrestamo() != null) {
					estado = " Prestado";
					ventana.getBtnPrestar().setEnabled(false);
				} else {
					estado += " Sin Prestar";
					ventana.getBtnPrestar().setEnabled(true);
				}

				StringBuilder texto = new StringBuilder();
				texto.append("Estado: ").append(estado).append("\n")
				     .append("Incidencias: ").append(incidencias);

				// Establecer el texto en el componente de información
				ventana.gettInformacion().setText(texto.toString());
			}
		}
	}
}

