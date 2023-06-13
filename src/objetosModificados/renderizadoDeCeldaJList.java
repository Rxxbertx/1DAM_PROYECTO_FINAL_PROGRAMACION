package objetosModificados;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

public class renderizadoDeCeldaJList extends DefaultListCellRenderer {

	private static final long serialVersionUID = -6328457360576448181L;

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.RIGHT);
		label.setVerticalTextPosition(SwingConstants.CENTER);
		label.setOpaque(true);

		if (isSelected) {
			label.setBackground(new Color(128, 0, 0));
			label.setForeground(Color.white);
		} else {
			label.setBackground(list.getBackground());
			label.setForeground(Color.black);
		}

		Juego selectedIndex = (Juego) value;

		if (selectedIndex != null) {
			ImageIcon icon = ((Videojuego) (selectedIndex)).getImagen();

			String nombre = selectedIndex.getNombre();
			String plataforma = ((Videojuego) (selectedIndex)).getPlatSelecciona();

			label.setIcon(utilidades.resizeIcon(icon, 100, 100));
			label.setText(nombre + " [Plataforma: " + plataforma + "] UNIDADES UTILIZADAS: "
					+ selectedIndex.getUdsUtilizadas());
			label.setFont(new Font("Arial", Font.BOLD, 15));

		} else {
			label.setIcon(null);
			label.setText(null);
		}

		if (list instanceof JList<?> && list.getParent() instanceof JScrollPane) {
			JScrollPane scrollPane = (JScrollPane) list.getParent().getParent();
			scrollPane.revalidate();
			scrollPane.repaint();
		}

		return label;
	}
}
