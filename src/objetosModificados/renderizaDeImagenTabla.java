package objetosModificados;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class renderizaDeImagenTabla extends DefaultTableCellRenderer {
	/**
	 *
	 */
	private static final long serialVersionUID = 8092159505535455867L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JLabel label = new JLabel();

		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);

		return label;
	}
}