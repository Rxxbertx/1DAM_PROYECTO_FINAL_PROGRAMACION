package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import model.Juego;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class GestionPrestamo extends JFrame {

	private JPanel contentPane;
	private JButton btnHistorico;
	private JButton btnSalir;
	private JList<Juego> listPrestamo;
	private JButton btnVer;
	private Component verticalGlue;
	private Component verticalGlue_2;
	private Component verticalGlue_1;
	private JScrollPane scrollPane;
	private JLabel lblTituloPrestamo;

	public JButton getBtnHistorico() {
		return btnHistorico;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JList<Juego> getListPrestamo() {
		return listPrestamo;
	}

	public JButton getBtnVer() {
		return btnVer;
	}

	/**
	 * Create the frame.
	 */
	public GestionPrestamo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionPrestamo.class.getResource("/images/icons8-play-games-96.png")));
		Border innerBorder1 = BorderFactory.createLineBorder(Color.WHITE, 2);
		Border outerBorder2 = BorderFactory.createLineBorder(new Color(128, 0, 0), 8);

		Border outerBorder1 = BorderFactory.createLineBorder(new Color(128, 0, 0), 3);

		Border compoundBorder1 = BorderFactory.createCompoundBorder(innerBorder1, outerBorder1);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 609);
		contentPane = new JPanel();
		contentPane.setBorder(outerBorder2);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelSeleccion = new JPanel();
		panelSeleccion.setBorder(compoundBorder1);
		contentPane.add(panelSeleccion, BorderLayout.WEST);
		panelSeleccion.setLayout(new BoxLayout(panelSeleccion, BoxLayout.Y_AXIS));

		verticalGlue = Box.createVerticalGlue();
		panelSeleccion.add(verticalGlue);

		btnHistorico = new JButton("Histórico");
		btnHistorico.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHistorico.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHistorico.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnHistorico.setBorderPainted(false);
		btnHistorico.setBorder(null);
		btnHistorico.setContentAreaFilled(false);
		btnHistorico.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHistorico.setIcon(new ImageIcon(GestionPrestamo.class.getResource("/images/Reloj arena80.png")));
		panelSeleccion.add(btnHistorico);

		verticalGlue_1 = Box.createVerticalGlue();
		panelSeleccion.add(verticalGlue_1);

		btnSalir = new JButton("Salir");
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setIcon(new ImageIcon(GestionPrestamo.class.getResource("/images/icons8-exit-96(1).png")));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelSeleccion.add(btnSalir);

		verticalGlue_2 = Box.createVerticalGlue();
		panelSeleccion.add(verticalGlue_2);

		JPanel panelGestionPrestamo = new JPanel();
		contentPane.add(panelGestionPrestamo, BorderLayout.CENTER);
		panelGestionPrestamo.setBorder(compoundBorder1);
		panelGestionPrestamo.setLayout(new BorderLayout(0, 0));

		listPrestamo = new JList();
		listPrestamo.setPreferredSize(new Dimension(100, 100));

		Border innerBorder3 = BorderFactory.createLineBorder(Color.WHITE, 1);

		Border outerBorder3 = BorderFactory.createLineBorder(new Color(128, 0, 0), 1);
		Border compoundBorder3 = BorderFactory.createCompoundBorder(innerBorder3, outerBorder3);

		listPrestamo.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 75));
		panel.setMinimumSize(new Dimension(10, 40));
		panelGestionPrestamo.add(panel, BorderLayout.SOUTH);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		btnVer = new JButton("VER");
		sl_panel.putConstraint(SpringLayout.WEST, btnVer, -126, SpringLayout.EAST, panel);
		btnVer.setPreferredSize(new Dimension(81, 21));
		sl_panel.putConstraint(SpringLayout.NORTH, btnVer, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnVer, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnVer, -22, SpringLayout.EAST, panel);
		btnVer.setForeground(Color.WHITE);
		btnVer.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnVer.setBorderPainted(false);
		btnVer.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnVer.setBackground(new Color(128, 0, 0));
		panel.add(btnVer);

		scrollPane = new JScrollPane(listPrestamo);
		panelGestionPrestamo.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		lblTituloPrestamo = new JLabel("PRESTAMOS");
		lblTituloPrestamo.setOpaque(true);
		lblTituloPrestamo.setBackground(new Color(128, 0, 0));
		lblTituloPrestamo.setForeground(new Color(255, 255, 255));
		lblTituloPrestamo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTituloPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTituloPrestamo, BorderLayout.NORTH);

	}
}
