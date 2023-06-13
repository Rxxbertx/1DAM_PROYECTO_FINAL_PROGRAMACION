package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;

public class VentanaHistorialIncidencias extends JFrame {

	private JPanel contentPane;
	private JTable tablaResuelta;
	private JTable tablaSinResolver;
	private DefaultTableModel modeloResuelto = new DefaultTableModel();
	private DefaultTableModel modeloNoResuelto = new DefaultTableModel();

	public VentanaHistorialIncidencias() {

		String cabecera[] = { "Nombre Juego", "Id Juego", "Num Unidad", "Incidencia", "Estado" };
		modeloNoResuelto.setColumnIdentifiers(cabecera);
		modeloResuelto.setColumnIdentifiers(cabecera);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 945, 609);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("HISTORIAL INCIDENCIAS");
		lblNewLabel.setBorder(null);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		Component verticalGlue = Box.createVerticalGlue();
		panel.add(verticalGlue);

		JLabel lblNewLabel_1 = new JLabel("Incidencias Resueltas");
		lblNewLabel_1.setBorder(new EmptyBorder(5, 0, 5, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblNewLabel_1);

		Component verticalGlue_2 = Box.createVerticalGlue();
		panel.add(verticalGlue_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new LineBorder(new Color(128, 0, 0), 5, true)));
		panel.add(scrollPane);

		tablaResuelta = new JTable(modeloResuelto);
		scrollPane.setViewportView(tablaResuelta);

		Component verticalGlue_1 = Box.createVerticalGlue();
		panel.add(verticalGlue_1);

		JLabel lblNewLabel_2 = new JLabel("Incidencias Sin Resolver");
		lblNewLabel_2.setBorder(new EmptyBorder(5, 0, 5, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);

		Component verticalGlue_3 = Box.createVerticalGlue();
		panel.add(verticalGlue_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new LineBorder(new Color(128, 0, 0), 5, true)));
		panel.add(scrollPane_1);

		tablaSinResolver = new JTable(modeloNoResuelto);
		scrollPane_1.setViewportView(tablaSinResolver);

		Component verticalGlue_4 = Box.createVerticalGlue();
		panel.add(verticalGlue_4);
	}

	public DefaultTableModel getModeloResuelto() {
		return modeloResuelto;
	}

	public void setModeloResuelto(DefaultTableModel modeloResuelto) {
		this.modeloResuelto = modeloResuelto;
	}

	public DefaultTableModel getModeloNoResuelto() {
		return modeloNoResuelto;
	}

	public void setModeloNoResuelto(DefaultTableModel modeloNoResuelto) {
		this.modeloNoResuelto = modeloNoResuelto;
	}

}
