package objetosModificados;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Juego;
import model.Juego.Unidad;
import model.Prestamo;
import model.Videojuego;
import utilidades.utilidades;

public class renderizadoDeCeldaJListUnidadCentrado extends JLabel implements ListCellRenderer<Object> {

	private static final Color COLOR_TEXTO_VERDE = Color.GREEN;
	private static final Color COLOR_TEXTO_ROJO = Color.RED;
	/**
	 * 
	 */
	private static final long serialVersionUID = -6328457360576448181L;

	public renderizadoDeCeldaJListUnidadCentrado() {

		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		setHorizontalTextPosition(SwingConstants.RIGHT);
		setVerticalTextPosition(SwingConstants.CENTER);
		setOpaque(true);
		setBackground(null);

	}

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		Juego.Unidad unidad = (Juego.Unidad) value;
	

		if (isSelected) {
			setBackground(new Color(128, 0, 0)); // Color de fondo para celda seleccionada
		} else {
			setBackground(null);
		}

		if (unidad.getPrestamo() != null) {
			setForeground(list.getForeground()); // Restablecer el color de primer plano predeterminado para celdas con
													// prestamo
		} else {
			setForeground(new Color(0, 128, 0));
		}

		setBorder(new EmptyBorder(5, 10, 5, 10));
		setText(String.valueOf(unidad.getId()));
		setFont(new Font("Tahoma", Font.BOLD, 24));

		return this;
	}

}
