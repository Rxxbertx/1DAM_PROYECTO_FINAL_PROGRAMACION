package objetosModificados;

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

public class renderizadoDeCeldaComboBox extends JLabel implements ListCellRenderer<Object> {

	public renderizadoDeCeldaComboBox() {

		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.BOTTOM);

	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// Get the selected index. (The index param isn't
		// always valid, so just use the value.)

		Juego selectedIndex = (Juego) value;

		// Set the icon and text. If icon was null, say so.

		if (selectedIndex != null) {
			ImageIcon icon = new ImageIcon(
					selectedIndex instanceof Videojuego ? ((Videojuego) (selectedIndex)).getImagen()
							: "src/images/default.png");
			String nombre = selectedIndex.getNombre();

			setIcon(utilidades.resizeIcon(icon, 100, 100));
			setText(nombre);
			setFont(new Font("Arial", Font.BOLD, 20));
			setBorder(new EmptyBorder(0, 0, 0, 0));
		} else {
			setIcon(null);
			setText(null);
		}

		return this;
	}

}
