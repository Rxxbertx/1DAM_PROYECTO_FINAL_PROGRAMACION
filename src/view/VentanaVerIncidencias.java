package view;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class VentanaVerIncidencias extends JDialog {
	private JTable table;

	private final String[] CABECERA = { "UNIDAD", "ESTADO", "INCIDENCIA" };

	private DefaultTableModel datos = new DefaultTableModel();

	/**
	 * Create the dialog.
	 */
	public VentanaVerIncidencias() {
		setBounds(100, 100, 945, 609);
		getContentPane().setLayout(new BorderLayout(0, 0));

		datos.setColumnIdentifiers(CABECERA);

		JLabel lblNewLabel = new JLabel("INCIDENCIAS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setIconTextGap(10);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5),
				new MatteBorder(4, 4, 4, 3, (Color) new Color(128, 0, 0))));
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setSelectionBackground(new Color(128, 0, 0));
		scrollPane.setViewportView(table);

	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @return the datos
	 */
	public DefaultTableModel getDatos() {
		return datos;
	}

}
