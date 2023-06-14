package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaHistorialPrestamos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3037956809427151976L;
	private DefaultTableModel datos = new DefaultTableModel();
	private JTable table;

	public VentanaHistorialPrestamos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaHistorialPrestamos.class.getResource("/images/icons8-play-games-96.png")));

		setBounds(100, 100, 900, 300);

		datos.setColumnIdentifiers(
				new String[] { "Nombre Juego", "ID Juego", "ID Unidad", "Usuario", "Fecha de Inicio", "Fecha de Fin" });

		getContentPane().setLayout(new BorderLayout());

		JLabel lblHistorialPrestamos = new JLabel("Historial Prestamos");
		lblHistorialPrestamos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHistorialPrestamos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHistorialPrestamos.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistorialPrestamos.setAlignmentX(Component.CENTER_ALIGNMENT);
		getContentPane().add(lblHistorialPrestamos, BorderLayout.NORTH);

		table = new JTable();

		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setModel(datos);

		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 15));

		scrollPane.setBorder(
				new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new LineBorder(new Color(128, 0, 0), 10, true)));

		getContentPane().add(scrollPane);

	}

	public DefaultTableModel getDatos() {
		return datos;
	}

	public void setDatos(DefaultTableModel datos) {
		this.datos = datos;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

}
