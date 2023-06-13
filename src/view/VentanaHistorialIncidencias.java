package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaHistorialIncidencias extends JFrame {

	private JPanel contentPane;
	private JTable tablaResuelta;
	private JTable tablaSinResolver;
	private DefaultTableModel modeloResuelto = new DefaultTableModel();
	private DefaultTableModel modeloNoResuelto = new DefaultTableModel();

<<<<<<< HEAD:src/view/VentanaHistorialIncidencias.java
	public VentanaHistorialIncidencias() {
=======
	public VentanaVerHistorialIncidencias() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaVerHistorialIncidencias.class.getResource("/images/icons8-play-games-96.png")));
>>>>>>> roberto:src/view/VentanaVerHistorialIncidencias.java

		String cabecera[] = { "Nombre Juego", "Id Juego", "Num Unidad", "Incidencia", "Estado" };
		modeloNoResuelto.setColumnIdentifiers(cabecera);
		modeloResuelto.setColumnIdentifiers(cabecera);

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 945, 609);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblHistorialIncidencias = new JLabel("HISTORIAL INCIDENCIAS");
		lblHistorialIncidencias.setBorder(null);
		lblHistorialIncidencias.setOpaque(true);
		lblHistorialIncidencias.setBackground(new Color(128, 0, 0));
		lblHistorialIncidencias.setForeground(new Color(255, 255, 255));
		lblHistorialIncidencias.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHistorialIncidencias.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHistorialIncidencias, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		Component verticalGlue = Box.createVerticalGlue();
		panel.add(verticalGlue);

		JLabel lblIncidenciasResueltas = new JLabel("Incidencias Resueltas");
		lblIncidenciasResueltas.setBorder(new EmptyBorder(5, 0, 5, 0));
		lblIncidenciasResueltas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIncidenciasResueltas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIncidenciasResueltas.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncidenciasResueltas.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblIncidenciasResueltas);

		Component verticalGlue_2 = Box.createVerticalGlue();
		panel.add(verticalGlue_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new LineBorder(new Color(128, 0, 0), 5, true)));
		panel.add(scrollPane);

		tablaResuelta = new JTable(modeloResuelto);
		scrollPane.setViewportView(tablaResuelta);

		Component verticalGlue_1 = Box.createVerticalGlue();
		panel.add(verticalGlue_1);

		JLabel lblIncidenciasSinResolver = new JLabel("Incidencias Sin Resolver");
		lblIncidenciasSinResolver.setBorder(new EmptyBorder(5, 0, 5, 0));
		lblIncidenciasSinResolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIncidenciasSinResolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIncidenciasSinResolver.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblIncidenciasSinResolver);

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
