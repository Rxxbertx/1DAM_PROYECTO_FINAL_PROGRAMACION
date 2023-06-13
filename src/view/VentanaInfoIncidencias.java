package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class VentanaInfoIncidencias extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JPanel panelCard;
	private JPanel panelSinIncidencias;
	private JButton btnEliminarSinInc;
	private JTextArea textArea;
	private JPanel panelConIncidencias;
	private JComboBox comboJuego;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblImagenRellenar;
	private JLabel lblNombreJuegoRellenar;
	private JTextArea tIncidencia;
	private JScrollPane scrollPaneCrearIncidencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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

	public VentanaInfoIncidencias() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInfoIncidencias.class.getResource("/images/icons8-play-games-96.png")));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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

		list = new JList();
		list.setBorder(new MatteBorder(0, 0, 0, 4, new Color(128, 0, 0)));
		scrollPane.setViewportView(list);

		panelCard = new JPanel();
		contentPane.add(panelCard, BorderLayout.CENTER);
		panelCard.setLayout(new CardLayout(0, 0));

		panelSinIncidencias = new JPanel();
		panelCard.add(panelSinIncidencias, "name_243871446300900");
		panelSinIncidencias.setLayout(new BorderLayout(0, 0));

		JPanel panelConBoton = new JPanel();
		panelConBoton.setPreferredSize(new Dimension(10, 200));
		panelSinIncidencias.add(panelConBoton, BorderLayout.SOUTH);
		SpringLayout sl_panelConBoton = new SpringLayout();
		panelConBoton.setLayout(sl_panelConBoton);

		btnEliminarSinInc = new JButton("ELIMINAR");
		sl_panelConBoton.putConstraint(SpringLayout.NORTH, btnEliminarSinInc, 77, SpringLayout.NORTH, panelConBoton);
		sl_panelConBoton.putConstraint(SpringLayout.WEST, btnEliminarSinInc, 232, SpringLayout.WEST, panelConBoton);
		btnEliminarSinInc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminarSinInc.setForeground(Color.WHITE);
		btnEliminarSinInc.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEliminarSinInc.setBorderPainted(false);
		btnEliminarSinInc.setBackground(new Color(128, 0, 0));
		panelConBoton.add(btnEliminarSinInc);

		JPanel panelConTitulo = new JPanel();
		panelConTitulo.setPreferredSize(new Dimension(10, 200));
		panelSinIncidencias.add(panelConTitulo, BorderLayout.NORTH);
		panelConTitulo.setLayout(new BorderLayout(0, 0));

		JLabel lblCrearIncidencia = new JLabel("CREAR NUEVA INCIDENCIA");
		lblCrearIncidencia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblCrearIncidencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearIncidencia.setHorizontalTextPosition(SwingConstants.CENTER);
		panelConTitulo.add(lblCrearIncidencia, BorderLayout.CENTER);

		JScrollPane scrollPaneIncidencia = new JScrollPane();
		panelSinIncidencias.add(scrollPaneIncidencia, BorderLayout.CENTER);

		textArea = new JTextArea();
		scrollPaneIncidencia.setViewportView(textArea);

		panelConIncidencias = new JPanel();
		panelCard.add(panelConIncidencias, "name_243871457462200");
		panelConIncidencias.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 90));
		panelConIncidencias.add(panel, BorderLayout.NORTH);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		comboJuego = new JComboBox();
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

		JPanel panelGeneral = new JPanel();
		panelConIncidencias.add(panelGeneral, BorderLayout.CENTER);
		panelGeneral.setLayout(new BorderLayout(0, 0));

		JPanel panelBotones = new JPanel();
		panelBotones.setPreferredSize(new Dimension(10, 90));
		panelGeneral.add(panelBotones, BorderLayout.SOUTH);
		SpringLayout sl_panelBotones = new SpringLayout();
		panelBotones.setLayout(sl_panelBotones);

		btnModificar = new JButton("MODIFICAR");
		sl_panelBotones.putConstraint(SpringLayout.NORTH, btnModificar, 14, SpringLayout.NORTH, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.WEST, btnModificar, 197, SpringLayout.WEST, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.SOUTH, btnModificar, -14, SpringLayout.SOUTH, panelBotones);
		btnModificar.setPreferredSize(new Dimension(81, 21));
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnModificar.setBorderPainted(false);
		btnModificar.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnModificar.setBackground(new Color(128, 0, 0));
		panelBotones.add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		sl_panelBotones.putConstraint(SpringLayout.WEST, btnEliminar, 450, SpringLayout.WEST, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.EAST, btnModificar, -17, SpringLayout.WEST, btnEliminar);
		sl_panelBotones.putConstraint(SpringLayout.NORTH, btnEliminar, 14, SpringLayout.NORTH, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.SOUTH, btnEliminar, -14, SpringLayout.SOUTH, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.EAST, btnEliminar, -25, SpringLayout.EAST, panelBotones);
		btnEliminar.setPreferredSize(new Dimension(81, 21));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnEliminar.setBackground(new Color(128, 0, 0));
		panelBotones.add(btnEliminar);

		JLabel lblAñadir = new JLabel("");
		sl_panelBotones.putConstraint(SpringLayout.NORTH, lblAñadir, 10, SpringLayout.NORTH, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.WEST, lblAñadir, 112, SpringLayout.WEST, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.SOUTH, lblAñadir, -10, SpringLayout.SOUTH, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.EAST, lblAñadir, -21, SpringLayout.WEST, btnModificar);
		lblAñadir.setIcon(new ImageIcon(VentanaInfoIncidencias.class.getResource("/images/icons8-más-64.png")));
		panelBotones.add(lblAñadir);

		JPanel panelEspacio = new JPanel();
		panelEspacio.setPreferredSize(new Dimension(10, 150));
		panelGeneral.add(panelEspacio, BorderLayout.NORTH);
		panelEspacio.setLayout(null);

		lblImagenRellenar = new JLabel("");
		lblImagenRellenar.setBounds(29, 25, 166, 104);
		panelEspacio.add(lblImagenRellenar);

		lblNombreJuegoRellenar = new JLabel("");
		lblNombreJuegoRellenar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNombreJuegoRellenar.setBounds(248, 58, 158, 34);
		panelEspacio.add(lblNombreJuegoRellenar);

		scrollPaneCrearIncidencia = new JScrollPane();
		panelGeneral.add(scrollPaneCrearIncidencia, BorderLayout.CENTER);

		tIncidencia = new JTextArea();
		scrollPaneCrearIncidencia.setViewportView(tIncidencia);


	}

	public JList getList() {
		return list;
	}

	public JPanel getPanelCard() {
		return panelCard;
	}

	public JPanel getPanelSinIncidencias() {
		return panelSinIncidencias;
	}

	public JButton getBtnEliminarSinInc() {
		return btnEliminarSinInc;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JPanel getPanelConIncidencias() {
		return panelConIncidencias;
	}

	public JComboBox getComboJuego() {
		return comboJuego;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JLabel getLblImagenRellenar() {
		return lblImagenRellenar;
	}

	public JLabel getLblNombreJuegoRellenar() {
		return lblNombreJuegoRellenar;
	}

	public JTextArea gettIncidencia() {
		return tIncidencia;
	}

	public JScrollPane getScrollPaneCrearIncidencia() {
		return scrollPaneCrearIncidencia;
	}
}
