package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import model.Videojuego;

import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;

public class GestionJuegos extends JFrame {

	private JPanel contentPane;
	private JTextField tUnidadesAñadir;
	private JTextField tNombreAñadir;
	private JTextField tNombreEliminar;
	private JTextField tUnidadesEliminar;
	private JTextField tNombreModificar;
	private JTextField tUnidadesModificar;
	private JButton btnEliminarJuego;
	public JPanel getPanelSelccionJuego() {
		return panelSelccionJuego;
	}

	public JPanel getPanelCard1() {
		return panelCard1;
	}

	public JPanel getPanelSinSeleccion() {
		return panelSinSeleccion;
	}

	public JLabel getLblMensajeSinSeleccionar() {
		return lblMensajeSinSeleccionar;
	}

	public JPanel getPanelConSeleccion() {
		return panelConSeleccion;
	}

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public JLabel getLblNombreRellenar() {
		return lblNombreRellenar;
	}

	public JLabel getLblNumJugadoresRellenar() {
		return lblNumJugadoresRellenar;
	}

	public JLabel getLblUnidadesRellenar() {
		return lblUnidadesRellenar;
	}

	public JLabel getLblUdsUtilizadasRellenar() {
		return lblUdsUtilizadasRellenar;
	}

	public JLabel getLblIncidenciasRellenar() {
		return lblIncidenciasRellenar;
	}

	public JLabel getLblCompañiaRellenar() {
		return lblCompañiaRellenar;
	}

	public JLabel getLblPlataformaRellenar() {
		return lblPlataformaRellenar;
	}

	private JButton btnVerJuego;
	private JButton btnModificarJuego;
	private JButton btnAñadirJuego;
	private JButton btnEliminar;
	private JComboBox cPlataformaEliminar;
	private JComboBox cPlataformaModificar;

	public JTextField gettUnidadesAñadir() {
		return tUnidadesAñadir;
	}

	public JTextField gettNombreAñadir() {
		return tNombreAñadir;
	}

	public JTextField gettNombreEliminar() {
		return tNombreEliminar;
	}

	public JTextField gettUnidadesEliminar() {
		return tUnidadesEliminar;
	}

	public JTextField gettNombreModificar() {
		return tNombreModificar;
	}

	public JTextField gettUnidadesModificar() {
		return tUnidadesModificar;
	}

	public JButton getBtnEliminarJuego() {
		return btnEliminarJuego;
	}

	public JButton getBtnVerJuego() {
		return btnVerJuego;
	}

	public JButton getBtnModificarJuego() {
		return btnModificarJuego;
	}

	public JButton getBtnAñadirJuego() {
		return btnAñadirJuego;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JComboBox getcPlataformaEliminar() {
		return cPlataformaEliminar;
	}

	public JComboBox getcPlataformaModificar() {
		return cPlataformaModificar;
	}

	public JComboBox getcPlataformaAñadir() {
		return cPlataformaAñadir;
	}

	public JSpinner getSpNumJugadoresModificar() {
		return spNumJugadoresModificar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnAñadir() {
		return btnAñadir;
	}

	private JComboBox cPlataformaAñadir;
	private JSpinner spNumJugadoresModificar;
	private JButton btnModificar;
	private JButton btnAñadir;
	private JPanel panelSelccionJuego;
	private JPanel panelCard1;
	private JPanel panelSinSeleccion;
	private JLabel lblMensajeSinSeleccionar;
	private JPanel panelConSeleccion;
	private JButton btnSeleccionar;
	private JLabel lblNombreRellenar;
	private JLabel lblNumJugadoresRellenar;
	private JLabel lblUnidadesRellenar;
	private JLabel lblUdsUtilizadasRellenar;
	private JLabel lblIncidenciasRellenar;
	private JLabel lblCompañiaRellenar;
	private JLabel lblPlataformaRellenar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionJuegos frame = new GestionJuegos();
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
	public GestionJuegos() {
		
		Border innerBorder1 = BorderFactory.createLineBorder(Color.WHITE, 3);
		Border outerBorder1 = BorderFactory.createLineBorder(new Color(128, 0, 0), 10);

		Border compoundBorder1 = BorderFactory.createCompoundBorder(innerBorder1, outerBorder1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		panel.setBounds(10, 11, 1015, 114);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 4, 0, 3));
		Border innerBorder = BorderFactory.createLineBorder(Color.WHITE, 3);
		Border outerBorder = BorderFactory.createLineBorder(new Color(128, 0, 0), 10);

		Border compoundBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);

		panel.setBorder(compoundBorder);
		
				btnAñadirJuego = new JButton("");
				btnAñadirJuego.setToolTipText("Añadir Juego");
				btnAñadirJuego.setBounds(new Rectangle(0, 0, 0, 40));
				btnAñadirJuego.setIcon(new ImageIcon(GestionJuegos.class.getResource("/images/icons8-más-64.png")));
				btnAñadirJuego.setContentAreaFilled(false);
				btnAñadirJuego.setBorderPainted(false);
				panel.add(btnAñadirJuego);

		btnEliminarJuego = new JButton("");
		btnEliminarJuego.setToolTipText("Eliminar Juego");
		btnEliminarJuego.setBorderPainted(false);
		btnEliminarJuego.setContentAreaFilled(false);
		btnEliminarJuego.setIcon(new ImageIcon(GestionJuegos.class.getResource("/images/icons8-menos-64.png")));
		panel.add(btnEliminarJuego);

		btnVerJuego = new JButton("");
		btnVerJuego.setToolTipText("Ver Juegos");
		btnVerJuego.setBorderPainted(false);
		btnVerJuego.setContentAreaFilled(false);
		btnVerJuego.setIcon(new ImageIcon(GestionJuegos.class.getResource("/images/icons8-surprise-64.png")));
		panel.add(btnVerJuego);

		btnModificarJuego = new JButton("");
		btnModificarJuego.setToolTipText("Editar Juegos");
		btnModificarJuego.setContentAreaFilled(false);
		btnModificarJuego.setIcon(new ImageIcon(GestionJuegos.class.getResource("/images/icons8-edit-64.png")));
		panel.add(btnModificarJuego);
		btnModificarJuego.setBorderPainted(false);
		panel.setBackground(new Color(128, 0, 0, 255));
		panel.setOpaque(true);

		JPanel panelCard = new JPanel();
		panelCard.setBounds(10, 136, 1015, 553);
		contentPane.add(panelCard, BorderLayout.CENTER);
		panelCard.setBorder(new LineBorder(new Color(128, 0, 0), 4, true));
		panelCard.setLayout(new CardLayout(0, 0));

		JPanel panelEliminar = new JPanel();
		panelCard.add(panelEliminar, "eliminar");
		panelEliminar.setLayout(null);
		panelEliminar.setBorder(compoundBorder1);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBackground(new Color(128, 0, 0));
		btnEliminar.setBounds(321, 326, 271, 77);
		panelEliminar.add(btnEliminar);

		JLabel lblNombreEliminar = new JLabel("Nombre");
		lblNombreEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNombreEliminar.setBounds(171, 103, 146, 31);
		panelEliminar.add(lblNombreEliminar);

		tNombreEliminar = new JTextField();
		tNombreEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		tNombreEliminar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
		tNombreEliminar.setBackground(Color.WHITE);
		tNombreEliminar.setBounds(535, 104, 302, 31);
		panelEliminar.add(tNombreEliminar);

		JLabel lblPlataformaEliminar = new JLabel("Plataforma");
		lblPlataformaEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblPlataformaEliminar.setBounds(171, 172, 146, 31);
		panelEliminar.add(lblPlataformaEliminar);

		cPlataformaEliminar = new JComboBox();
		cPlataformaEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		cPlataformaEliminar.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		cPlataformaEliminar.setBounds(535, 172, 302, 31);
		panelEliminar.add(cPlataformaEliminar);

		JLabel lblUnidadesEliminar = new JLabel("Unidades");
		lblUnidadesEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblUnidadesEliminar.setBounds(171, 242, 146, 31);
		panelEliminar.add(lblUnidadesEliminar);

		tUnidadesEliminar = new JTextField();
		tUnidadesEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		tUnidadesEliminar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
		tUnidadesEliminar.setBackground(Color.WHITE);
		tUnidadesEliminar.setBounds(535, 242, 302, 31);
		panelEliminar.add(tUnidadesEliminar);

		JPanel panelAñadir = new JPanel();
		panelCard.add(panelAñadir, "añadir");
		panelAñadir.setLayout(null);
		panelAñadir.setBorder(compoundBorder1);


		JPanel panelModificar = new JPanel();
		panelCard.add(panelModificar, "modificar");
		panelModificar.setLayout(null);
		panelModificar.setBorder(compoundBorder1);


		JLabel lblNombreModificar = new JLabel("Nombre");
		lblNombreModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNombreModificar.setBounds(172, 74, 146, 31);
		panelModificar.add(lblNombreModificar);

		tNombreModificar = new JTextField();
		tNombreModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		tNombreModificar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
		tNombreModificar.setBackground(Color.WHITE);
		tNombreModificar.setBounds(536, 75, 302, 31);
		panelModificar.add(tNombreModificar);

		JLabel lblPlataformaModificar = new JLabel("Plataforma");
		lblPlataformaModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblPlataformaModificar.setBounds(172, 143, 146, 31);
		panelModificar.add(lblPlataformaModificar);

		cPlataformaModificar = new JComboBox();
		cPlataformaModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		cPlataformaModificar.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		cPlataformaModificar.setBounds(536, 143, 302, 31);
		panelModificar.add(cPlataformaModificar);

		JLabel lblUnidadesModificar = new JLabel("Unidades");
		lblUnidadesModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblUnidadesModificar.setBounds(172, 213, 146, 31);
		panelModificar.add(lblUnidadesModificar);

		tUnidadesModificar = new JTextField();
		tUnidadesModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		tUnidadesModificar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
		tUnidadesModificar.setBackground(Color.WHITE);
		tUnidadesModificar.setBounds(536, 213, 302, 31);
		panelModificar.add(tUnidadesModificar);

		JLabel lblNumJugadoresModificar = new JLabel("Nº Jugadores");
		lblNumJugadoresModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNumJugadoresModificar.setBounds(172, 278, 189, 31);
		panelModificar.add(lblNumJugadoresModificar);

		JPanel panelVer = new JPanel();
		panelCard.add(panelVer, "ver");
		panelVer.setLayout(new BorderLayout(0, 0));
		
		panelSelccionJuego = new JPanel();
		panelSelccionJuego.setPreferredSize(new Dimension(320, 10));
		panelVer.add(panelSelccionJuego, BorderLayout.WEST);
		panelSelccionJuego.setLayout(null);
		
		JComboBox comboJuegos = new JComboBox();
		comboJuegos.setBounds(29, 55, 265, 138);
		panelSelccionJuego.add(comboJuegos);

     
		btnSeleccionar = new JButton("SELECCIONAR");
		btnSeleccionar.setForeground(Color.WHITE);
		btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSeleccionar.setBorderPainted(false);
		btnSeleccionar.setBackground(new Color(128, 0, 0));
		btnSeleccionar.setBounds(41, 240, 240, 46);
		panelSelccionJuego.add(btnSeleccionar);
		
		panelCard1 = new JPanel();
		panelVer.add(panelCard1);
		panelCard1.setLayout(new CardLayout(0, 0));
		
		
		
		panelCard1.setBorder(compoundBorder1);
		panelSelccionJuego.setBorder(compoundBorder1);

		
		panelSinSeleccion = new JPanel();
		panelCard1.add(panelSinSeleccion, "sin seleccion");
		panelSinSeleccion.setLayout(new BorderLayout(0, 0));
		
		panelConSeleccion = new JPanel();
		panelCard1.add(panelConSeleccion, "con seleccion");
		panelConSeleccion.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInformacion = new JPanel();
		panelConSeleccion.add(panelInformacion, BorderLayout.CENTER);
		panelInformacion.setLayout(null);
		
		JLabel lblNombreInfo = new JLabel("Nombre: ");
		lblNombreInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreInfo.setBounds(111, 102, 85, 14);
		panelInformacion.add(lblNombreInfo);
		
		lblNombreRellenar = new JLabel("");
		lblNombreRellenar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreRellenar.setBounds(267, 102, 340, 14);
		panelInformacion.add(lblNombreRellenar);
		
		JLabel lblNumJugadoresInfo = new JLabel("Num jugadores:");
		lblNumJugadoresInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumJugadoresInfo.setBounds(111, 138, 114, 14);
		panelInformacion.add(lblNumJugadoresInfo);
		
		JLabel lblUnidadesInfo = new JLabel("Unidades:");
		lblUnidadesInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnidadesInfo.setBounds(111, 174, 114, 14);
		panelInformacion.add(lblUnidadesInfo);
		
		JLabel lblUdsUtilizadasInfo = new JLabel("Uds Utilizadas: ");
		lblUdsUtilizadasInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUdsUtilizadasInfo.setBounds(111, 214, 114, 14);
		panelInformacion.add(lblUdsUtilizadasInfo);
		
		JLabel lblIncidenciasInfo = new JLabel("Incidencias:");
		lblIncidenciasInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIncidenciasInfo.setBounds(111, 250, 114, 14);
		panelInformacion.add(lblIncidenciasInfo);
		
		JLabel lblCompañiaInfo = new JLabel("Compañía: ");
		lblCompañiaInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompañiaInfo.setBounds(111, 285, 114, 14);
		panelInformacion.add(lblCompañiaInfo);
		
		JLabel lblPlataformaInfo = new JLabel("Plataforma: ");
		lblPlataformaInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlataformaInfo.setBounds(111, 318, 114, 14);
		panelInformacion.add(lblPlataformaInfo);
		
		lblNumJugadoresRellenar = new JLabel("");
		lblNumJugadoresRellenar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumJugadoresRellenar.setBounds(267, 140, 340, 14);
		panelInformacion.add(lblNumJugadoresRellenar);
		
		lblUnidadesRellenar = new JLabel("");
		lblUnidadesRellenar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnidadesRellenar.setBounds(267, 176, 340, 14);
		panelInformacion.add(lblUnidadesRellenar);
		
		lblUdsUtilizadasRellenar = new JLabel("");
		lblUdsUtilizadasRellenar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUdsUtilizadasRellenar.setBounds(267, 216, 340, 14);
		panelInformacion.add(lblUdsUtilizadasRellenar);
		
		lblIncidenciasRellenar = new JLabel("");
		lblIncidenciasRellenar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIncidenciasRellenar.setBounds(267, 252, 340, 14);
		panelInformacion.add(lblIncidenciasRellenar);
		
		lblCompañiaRellenar = new JLabel("");
		lblCompañiaRellenar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCompañiaRellenar.setBounds(267, 287, 340, 14);
		panelInformacion.add(lblCompañiaRellenar);
		
		lblPlataformaRellenar = new JLabel("");
		lblPlataformaRellenar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlataformaRellenar.setBounds(267, 318, 340, 14);
		panelInformacion.add(lblPlataformaRellenar);
		
		
		
		lblMensajeSinSeleccionar = new JLabel("<html><center>No ha seleccionado ningún juego, por favor elija uno<br>del desplegable y presione el botón <font color='black'><b>\"Seleccionar\"</b></font><br></center></html>");
		lblMensajeSinSeleccionar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMensajeSinSeleccionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeSinSeleccionar.setForeground(new Color(139, 0, 0));
		lblMensajeSinSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelSinSeleccion.add(lblMensajeSinSeleccionar);

		JLabel lblNombreAñadir = new JLabel("Nombre");
		lblNombreAñadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNombreAñadir.setBounds(174, 88, 146, 31);
		panelAñadir.add(lblNombreAñadir);

		JLabel lblUnidadewsAñadir = new JLabel("Unidades");
		lblUnidadewsAñadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblUnidadewsAñadir.setBounds(174, 227, 146, 31);
		panelAñadir.add(lblUnidadewsAñadir);

		JLabel lblPlatafomaAñadir = new JLabel("Plataforma");
		lblPlatafomaAñadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblPlatafomaAñadir.setBounds(174, 157, 146, 31);
		panelAñadir.add(lblPlatafomaAñadir);

		cPlataformaAñadir = new JComboBox();
		cPlataformaAñadir.setBounds(538, 157, 302, 31);
		cPlataformaAñadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		cPlataformaAñadir.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		panelAñadir.add(cPlataformaAñadir);

		tUnidadesAñadir = new JTextField();
		tUnidadesAñadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		tUnidadesAñadir.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
		tUnidadesAñadir.setBackground(Color.white);
		tUnidadesAñadir.setBounds(538, 227, 302, 31);
		panelAñadir.add(tUnidadesAñadir);

		btnAñadir = new JButton("AÑADIR");
		btnAñadir.setForeground(Color.WHITE);
		btnAñadir.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnAñadir.setBorderPainted(false);
		btnAñadir.setBackground(new Color(128, 0, 0));
		btnAñadir.setBounds(321, 314, 271, 77);
		panelAñadir.add(btnAñadir);

		tNombreAñadir = new JTextField();
		tNombreAñadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		tNombreAñadir.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
		tNombreAñadir.setBackground(Color.WHITE);
		tNombreAñadir.setBounds(538, 89, 302, 31);
		panelAñadir.add(tNombreAñadir);

		spNumJugadoresModificar = new JSpinner();
		spNumJugadoresModificar.setBounds(536, 278, 302, 31);
		panelModificar.add(spNumJugadoresModificar);
		spNumJugadoresModificar.setBorder(new MatteBorder(2, 2, 2, 0, new Color(128, 0, 0)));

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnModificar.setBorderPainted(false);
		btnModificar.setBackground(new Color(128, 0, 0));
		btnModificar.setBounds(321, 346, 271, 77);
		panelModificar.add(btnModificar);
	}
}
