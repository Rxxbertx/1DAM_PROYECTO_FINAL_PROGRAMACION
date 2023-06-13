package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.CardLayout;
import javax.swing.SwingConstants;

public class VentanaInfoIncidencias extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInfoIncidencias frame = new VentanaInfoIncidencias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInfoIncidencias() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInfoIncidencias.class.getResource("/images/icons8-play-games-96.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 945, 609);
		contentPane = new JPanel();
		
		Border innerBorder = BorderFactory.createLineBorder(Color.WHITE, 3);
		Border outerBorder = BorderFactory.createLineBorder(new Color(128, 0, 0), 6);

		Border compoundBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
		contentPane.setBorder(compoundBorder);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.WEST);
		
		JList list = new JList();
		list.setBorder(new MatteBorder(0, 0, 0, 4, (Color) new Color(128, 0, 0)));
		scrollPane.setViewportView(list);
		
		JPanel panelCard = new JPanel();
		contentPane.add(panelCard, BorderLayout.CENTER);
		panelCard.setLayout(new CardLayout(0, 0));
		
		JPanel panelSinIncidencias = new JPanel();
		panelCard.add(panelSinIncidencias, "name_243871446300900");
		panelSinIncidencias.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 200));
		panelSinIncidencias.add(panel_4, BorderLayout.SOUTH);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);
		
		JButton btnEliminarSinInc = new JButton("ELIMINAR");
		sl_panel_4.putConstraint(SpringLayout.NORTH, btnEliminarSinInc, 77, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, btnEliminarSinInc, 232, SpringLayout.WEST, panel_4);
		btnEliminarSinInc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminarSinInc.setForeground(Color.WHITE);
		btnEliminarSinInc.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEliminarSinInc.setBorderPainted(false);
		btnEliminarSinInc.setBackground(new Color(128, 0, 0));
		panel_4.add(btnEliminarSinInc);
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(10, 200));
		panelSinIncidencias.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("CREAR NUEVA INCIDENCIA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_5.add(lblNewLabel, BorderLayout.CENTER);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panelSinIncidencias.add(scrollPane_2, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
		
		JPanel panelConIncidencias = new JPanel();
		panelCard.add(panelConIncidencias, "name_243871457462200");
		panelConIncidencias.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 90));
		panelConIncidencias.add(panel, BorderLayout.NORTH);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JComboBox comboJuego = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboJuego, 17, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, comboJuego, 169, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboJuego, 72, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboJuego, -170, SpringLayout.EAST, panel);
		panel.add(comboJuego);
		
		JLabel Imagen1 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, Imagen1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, Imagen1, 62, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, Imagen1, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, Imagen1, -43, SpringLayout.WEST, comboJuego);
		Imagen1.setIcon(new ImageIcon(VentanaInfoIncidencias.class.getResource("/images/icons8-error-64.png")));
		panel.add(Imagen1);
		
		JLabel Imagen2 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, Imagen2, 9, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, Imagen2, 43, SpringLayout.EAST, comboJuego);
		sl_panel.putConstraint(SpringLayout.SOUTH, Imagen2, 0, SpringLayout.SOUTH, Imagen1);
		sl_panel.putConstraint(SpringLayout.EAST, Imagen2, 107, SpringLayout.EAST, comboJuego);
		Imagen2.setIcon(new ImageIcon(VentanaInfoIncidencias.class.getResource("/images/icons8-error-64.png")));
		panel.add(Imagen2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panelConIncidencias.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 90));
		panel_1.add(panel_2, BorderLayout.SOUTH);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JButton btnModificar = new JButton("MODIFICAR");
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnModificar, 14, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, btnModificar, 197, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnModificar, -14, SpringLayout.SOUTH, panel_2);
		btnModificar.setPreferredSize(new Dimension(81, 21));
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnModificar.setBorderPainted(false);
		btnModificar.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnModificar.setBackground(new Color(128, 0, 0));
		panel_2.add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		sl_panel_2.putConstraint(SpringLayout.WEST, btnEliminar, 450, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnModificar, -17, SpringLayout.WEST, btnEliminar);
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnEliminar, 14, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnEliminar, -14, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnEliminar, -25, SpringLayout.EAST, panel_2);
		btnEliminar.setPreferredSize(new Dimension(81, 21));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnEliminar.setBackground(new Color(128, 0, 0));
		panel_2.add(btnEliminar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1, 112, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -10, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_1, -21, SpringLayout.WEST, btnModificar);
		lblNewLabel_1.setIcon(new ImageIcon(VentanaInfoIncidencias.class.getResource("/images/icons8-más-64.png")));
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 150));
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(null);
		
		JLabel lblImagenRellenar = new JLabel("");
		lblImagenRellenar.setBounds(29, 25, 166, 104);
		panel_3.add(lblImagenRellenar);
		
		JLabel lblNombreJuegoRellenar = new JLabel("");
		lblNombreJuegoRellenar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNombreJuegoRellenar.setBounds(248, 58, 158, 34);
		panel_3.add(lblNombreJuegoRellenar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		JTextArea tIncidencia = new JTextArea();
		scrollPane_1.setViewportView(tIncidencia);
		
		
	}
}
