package objetosModificados;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import utilidades.utilidades;

public class renderizaDeImagenTabla extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8092159505535455867L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JLabel label = new JLabel();

		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		return label;
	}
}