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
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class VentanaGestionIncidencias extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4644087587937505449L;

	private JPanel contentPane;
	private JButton btnHistorico;
	private JButton btnSalir;
	private Component verticalGlue;
	private Component verticalGlue_2;
	private Component verticalGlue_1;
	private JScrollPane scrollPane;
	private JPanel panelJuegos;
	private JLabel lblIncidencias;



	/**
	 * Create the frame.
	 */
	public VentanaGestionIncidencias() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaGestionIncidencias.class.getResource("/images/icons8-play-games-96.png")));
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
		btnHistorico.setIcon(new ImageIcon(VentanaGestionIncidencias.class.getResource("/images/Reloj arena80.png")));
		panelSeleccion.add(btnHistorico);

		verticalGlue_1 = Box.createVerticalGlue();
		panelSeleccion.add(verticalGlue_1);

		btnSalir = new JButton("Salir");
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setIcon(new ImageIcon(VentanaGestionIncidencias.class.getResource("/images/icons8-exit-96(1).png")));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelSeleccion.add(btnSalir);

		verticalGlue_2 = Box.createVerticalGlue();
		panelSeleccion.add(verticalGlue_2);

		JPanel panelGestionIncidencias = new JPanel();
		contentPane.add(panelGestionIncidencias, BorderLayout.CENTER);
		panelGestionIncidencias.setBorder(compoundBorder1);
		panelGestionIncidencias.setLayout(new BorderLayout(0, 0));

		Border innerBorder3 = BorderFactory.createLineBorder(Color.WHITE, 1);

		Border outerBorder3 = BorderFactory.createLineBorder(new Color(128, 0, 0), 1);
		Border compoundBorder3 = BorderFactory.createCompoundBorder(innerBorder3, outerBorder3);

		scrollPane = new JScrollPane();
		panelGestionIncidencias.add(scrollPane, BorderLayout.CENTER);

		panelJuegos = new JPanel();
		panelJuegos.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setViewportView(panelJuegos);
		panelJuegos.setLayout(new GridLayout(0, 3, 5, 5));

		lblIncidencias = new JLabel("INCIDENCIAS");
		lblIncidencias.setOpaque(true);
		lblIncidencias.setBackground(new Color(128, 0, 0));
		lblIncidencias.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIncidencias.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncidencias.setForeground(new Color(255, 255, 255));
		lblIncidencias.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIncidencias.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblIncidencias, BorderLayout.NORTH);
	}

	public JPanel getPanelJuegos() {
		return panelJuegos;
	}
	public JButton getBtnHistorico() {
		return btnHistorico;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}
}
