package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import model.Juego.Unidad;

public class VentanaInfoIncidencias extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 398709682491876209L;
	private JPanel contentPane;
	private JList<Unidad> list;
	private JPanel panelCard;
	private JPanel panelSinIncidencias;
	private JTextArea textArea;
	private JPanel panelConIncidencias;
	private JComboBox<Integer> comboJuego;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblImagenRellenar;
	private JLabel lblPlataformaRelleno;
	private JTextArea tIncidencia;
	private JScrollPane scrollPaneCrearIncidencia;
	private JButton btnAbrir;
	private JButton btnAñadir;
	private JLabel lblCrearIncidencia;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private JPanel panel_1;
	private JLabel lblNumJugaRelleno;
	private JLabel lbNombreRelleno;
	private JLabel lblImagenRellenar2;
	private JLabel lblNumJugaRelleno2;
	private JLabel lblPlataformaRelleno2;
	private JLabel lbNombreRelleno2;

	public VentanaInfoIncidencias() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaInfoIncidencias.class.getResource("/images/icons8-play-games-96.png")));
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
		scrollPane.setPreferredSize(new Dimension(100, 2));
		scrollPane.setBorder(null);
		contentPane.add(scrollPane, BorderLayout.WEST);

		list = new JList<Unidad>();
		list.setBackground(new Color(192, 192, 192));
		list.setMaximumSize(new Dimension(300000, 3000000));
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list.setBorder(new MatteBorder(0, 0, 0, 4, new Color(128, 0, 0)));
		scrollPane.setViewportView(list);

		panelCard = new JPanel();
		contentPane.add(panelCard, BorderLayout.CENTER);
		panelCard.setLayout(new CardLayout(0, 0));

		panelSinIncidencias = new JPanel();
		panelCard.add(panelSinIncidencias, "sinIncidencias");
		panelSinIncidencias.setLayout(new BoxLayout(panelSinIncidencias, BoxLayout.Y_AXIS));

		verticalGlue = Box.createVerticalGlue();
		panelSinIncidencias.add(verticalGlue);

		lblCrearIncidencia = new JLabel("CREAR NUEVA INCIDENCIA");
		lblCrearIncidencia.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCrearIncidencia.setMaximumSize(new Dimension(444, 20));
		lblCrearIncidencia.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCrearIncidencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearIncidencia.setFont(new Font("Tahoma", Font.BOLD, 24));
		panelSinIncidencias.add(lblCrearIncidencia);

		verticalGlue_1 = Box.createVerticalGlue();
		panelSinIncidencias.add(verticalGlue_1);

		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 100));
		panelSinIncidencias.add(panel_1);
		panel_1.setLayout(null);

		lbNombreRelleno2 = new JLabel("");
		lbNombreRelleno2.setFont(new Font("Dialog", Font.BOLD, 15));
		lbNombreRelleno2.setBounds(381, 16, 250, 26);
		panel_1.add(lbNombreRelleno2);

		lblPlataformaRelleno2 = new JLabel("");
		lblPlataformaRelleno2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPlataformaRelleno2.setBounds(381, 58, 250, 26);
		panel_1.add(lblPlataformaRelleno2);

		lblNumJugaRelleno2 = new JLabel("");
		lblNumJugaRelleno2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNumJugaRelleno2.setBounds(381, 100, 250, 26);
		panel_1.add(lblNumJugaRelleno2);

		lblImagenRellenar2 = new JLabel("");
		lblImagenRellenar2.setBounds(188, 10, 166, 125);
		panel_1.add(lblImagenRellenar2);

		JScrollPane scrollPaneIncidencia = new JScrollPane();
		scrollPaneIncidencia.setPreferredSize(new Dimension(2, 150));
		scrollPaneIncidencia.setBorder(
				new CompoundBorder(new EmptyBorder(22, 22, 0, 22), new LineBorder(new Color(128, 0, 0), 4, true)));
		panelSinIncidencias.add(scrollPaneIncidencia);

		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 20));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBorder(new EmptyBorder(22, 22, 22, 22));
		scrollPaneIncidencia.setViewportView(textArea);

		Component verticalGlue_3 = Box.createVerticalGlue();
		panelSinIncidencias.add(verticalGlue_3);

		btnAñadir = new JButton("AÑADIR");
		btnAñadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAñadir.setForeground(Color.WHITE);
		btnAñadir.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnAñadir.setBorderPainted(false);
		btnAñadir.setBackground(new Color(128, 0, 0));
		btnAñadir.setAlignmentX(0.5f);
		panelSinIncidencias.add(btnAñadir);

		panelConIncidencias = new JPanel();
		panelCard.add(panelConIncidencias, "conIncidencias");
		panelConIncidencias.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 90));
		panelConIncidencias.add(panel, BorderLayout.NORTH);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		comboJuego = new JComboBox<Integer>();
		comboJuego.setFont(new Font("Tahoma", Font.BOLD, 20));
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

		btnEliminar = new JButton("RESOLVER");
		btnEliminar.setActionCommand("RESOLVER");
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
		btnEliminar.setBackground(new Color(255, 215, 0));
		panelBotones.add(btnEliminar);

		btnAbrir = new JButton("");
		btnAbrir.setBorder(null);
		btnAbrir.setBorderPainted(false);
		btnAbrir.setContentAreaFilled(false);
		sl_panelBotones.putConstraint(SpringLayout.NORTH, btnAbrir, 10, SpringLayout.NORTH, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.WEST, btnAbrir, 10, SpringLayout.WEST, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.SOUTH, btnAbrir, -10, SpringLayout.SOUTH, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.EAST, btnAbrir, -123, SpringLayout.WEST, btnModificar);
		btnAbrir.setIcon(new ImageIcon(VentanaInfoIncidencias.class.getResource("/images/icons8-más-64.png")));
		panelBotones.add(btnAbrir);

		JPanel panelEspacio = new JPanel();
		panelEspacio.setPreferredSize(new Dimension(10, 150));
		panelGeneral.add(panelEspacio, BorderLayout.NORTH);
		panelEspacio.setLayout(null);

		lblImagenRellenar = new JLabel("");
		lblImagenRellenar.setBounds(174, 14, 166, 122);
		panelEspacio.add(lblImagenRellenar);

		lblPlataformaRelleno = new JLabel("");
		lblPlataformaRelleno.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPlataformaRelleno.setBounds(379, 62, 250, 26);
		panelEspacio.add(lblPlataformaRelleno);

		lbNombreRelleno = new JLabel("");
		lbNombreRelleno.setFont(new Font("Dialog", Font.BOLD, 15));
		lbNombreRelleno.setBounds(379, 18, 250, 26);
		panelEspacio.add(lbNombreRelleno);

		lblNumJugaRelleno = new JLabel("");
		lblNumJugaRelleno.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNumJugaRelleno.setBounds(379, 106, 250, 26);
		panelEspacio.add(lblNumJugaRelleno);

		scrollPaneCrearIncidencia = new JScrollPane();
		scrollPaneCrearIncidencia.setBorder(
				new CompoundBorder(new EmptyBorder(22, 22, 22, 22), new LineBorder(new Color(128, 0, 0), 4, true)));
		panelGeneral.add(scrollPaneCrearIncidencia, BorderLayout.CENTER);

		tIncidencia = new JTextArea();
		tIncidencia.setLineWrap(true);
		tIncidencia.setWrapStyleWord(true);
		tIncidencia.setFont(new Font("Tahoma", Font.BOLD, 20));
		tIncidencia.setCaretColor(new Color(128, 0, 0));
		tIncidencia.setBorder(new EmptyBorder(11, 11, 11, 11));
		scrollPaneCrearIncidencia.setViewportView(tIncidencia);

	}

	public JList<Unidad> getList() {
		return list;
	}

	public JPanel getPanelCard() {
		return panelCard;
	}

	public JPanel getPanelSinIncidencias() {
		return panelSinIncidencias;
	}

	public JButton getBtnAñadir() {
		return btnAñadir;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JPanel getPanelConIncidencias() {
		return panelConIncidencias;
	}

	public JComboBox<Integer> getComboJuego() {
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
		return lblPlataformaRelleno;
	}

	public JTextArea gettIncidencia() {
		return tIncidencia;
	}

	public JScrollPane getScrollPaneCrearIncidencia() {
		return scrollPaneCrearIncidencia;
	}

	/**
	 * @return the btnAbrir
	 */
	public JButton getBtnAbrir() {
		return btnAbrir;
	}

	/**
	 * @return the lblPlataformaRelleno
	 */
	public JLabel getLblPlataformaRelleno() {
		return lblPlataformaRelleno;
	}

	/**
	 * @return the lblNumJugaRelleno
	 */
	public JLabel getLblNumJugaRelleno() {
		return lblNumJugaRelleno;
	}

	/**
	 * @return the lbNombreRelleno
	 */
	public JLabel getLbNombreRelleno() {
		return lbNombreRelleno;
	}

	/**
	 * @return the lblImagenRellenar2
	 */
	public JLabel getLblImagenRellenar2() {
		return lblImagenRellenar2;
	}

	/**
	 * @return the lblNumJugaRelleno2
	 */
	public JLabel getLblNumJugaRelleno2() {
		return lblNumJugaRelleno2;
	}

	/**
	 * @return the lblPlataformaRelleno2
	 */
	public JLabel getLblPlataformaRelleno2() {
		return lblPlataformaRelleno2;
	}

	/**
	 * @return the lbNombreRelleno2
	 */
	public JLabel getLbNombreRelleno2() {
		return lbNombreRelleno2;
	}
}
