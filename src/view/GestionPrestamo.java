package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

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

public class GestionPrestamo extends JFrame {

	private JPanel contentPane;
	private JButton btnHistorico;
	private JButton btnSalir;
	private JList listPrestamo;
	private JButton btnVer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GestionPrestamo frame = new GestionPrestamo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JButton getBtnHistorico() {
		return btnHistorico;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JList getListPrestamo() {
		return listPrestamo;
	}

	public JButton getBtnVer() {
		return btnVer;
	}

	/**
	 * Create the frame.
	 */
	public GestionPrestamo() {
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

		panelSeleccion.setPreferredSize(new Dimension(180, 10));
		contentPane.add(panelSeleccion, BorderLayout.WEST);

		btnHistorico = new JButton("Histórico");
		btnHistorico.setBorderPainted(false);
		btnHistorico.setBorder(null);
		btnHistorico.setContentAreaFilled(false);
		btnHistorico.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHistorico.setIcon(new ImageIcon(GestionPrestamo.class.getResource("/images/Reloj arena80.png")));
		panelSeleccion.add(btnHistorico);

		btnSalir = new JButton("Salir");
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setIcon(new ImageIcon(GestionPrestamo.class.getResource("/images/icons8-exit-96(1).png")));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelSeleccion.add(btnSalir);

		JPanel panelGestionPrestamo = new JPanel();
		contentPane.add(panelGestionPrestamo, BorderLayout.CENTER);
		panelGestionPrestamo.setBorder(compoundBorder1);
		panelGestionPrestamo.setLayout(new BorderLayout(0, 0));

		listPrestamo = new JList();
		listPrestamo.setPreferredSize(new Dimension(100, 100));
		panelGestionPrestamo.add(listPrestamo, BorderLayout.CENTER);
		Border innerBorder3 = BorderFactory.createLineBorder(Color.WHITE, 1);

		Border outerBorder3 = BorderFactory.createLineBorder(new Color(128, 0, 0), 1);
		Border compoundBorder3 = BorderFactory.createCompoundBorder(innerBorder3, outerBorder3);

		listPrestamo.setBorder(compoundBorder3);

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

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setPreferredSize(new Dimension(20, 48));
		panelGestionPrestamo.add(scrollBar, BorderLayout.EAST);
	}
}
