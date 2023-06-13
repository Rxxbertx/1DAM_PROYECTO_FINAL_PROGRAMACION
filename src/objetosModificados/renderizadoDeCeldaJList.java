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
import model.Videojuego;
import utilidades.utilidades;

public class renderizadoDeCeldaJList extends JLabel implements ListCellRenderer<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6328457360576448181L;

	public renderizadoDeCeldaJList() {

		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		setHorizontalTextPosition(SwingConstants.RIGHT);
		setVerticalTextPosition(SwingConstants.CENTER);
		setOpaque(true);
		setBorder(new EmptyBorder(5, 10, 5, 10));

	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// Get the selected index. (The index param isn't
		// always valid, so just use the value.)

		if (isSelected) {
			setBackground(new Color(128, 0, 0));
			setForeground(Color.white);
		} else {
			setBackground(list.getBackground());
			setForeground(Color.black);
		}

		Juego selectedIndex = (Juego) value;

		// Set the icon and text. If icon was null, say so.

		if (selectedIndex != null) {
			ImageIcon icon = new ImageIcon(
					selectedIndex instanceof Videojuego ? ((Videojuego) (selectedIndex)).getImagen()
							: "src/images/default.png");

			String nombre = selectedIndex.getNombre();
			String plataforma = ((Videojuego) (selectedIndex)).getPlatSelecciona();

			setIcon(utilidades.resizeIcon(icon, 100, 100));
			setText(nombre + " [Plataforma: " + plataforma + "] UNIDADES UTILIZADAS: "
					+ selectedIndex.getUdsUtilizadas());
			setFont(new Font("Arial", Font.BOLD, 15));
			setBorder(new EmptyBorder(0, 0, 0, 0));
		} else {
			setIcon(null);
			setText(null);
		}

		return this;
	}

}
