package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import model.Juego;
import java.awt.Toolkit;

public class GestionJuegos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5535435754318042085L;
	/**
	 *
	 */

	private JPanel contentPane;
	private JTextField tNombreAñadir;
	private JTextField tNombreEliminar;
	private JTextField tPlataformaEliminar;
	private JTextField tNombreModificar;
	private JTextField tUnidadesModificar;
	private JButton btnEliminarJuego;
	private DefaultComboBoxModel<Juego> modeloComboJuegos = new DefaultComboBoxModel<>();
	private JComboBox<String> cPlataformaAñadir;
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
	private JPanel panelCard;
	private JComboBox<Juego> comboJuegos;
	private JButton btnVerJuego;
	private JButton btnModificarJuego;
	private JButton btnAñadirJuego;
	private JButton btnEliminar;
	private JComboBox<String> cPlataformaModificar;
	private JTextField compañiaAlta;
	private JTextField tEstadoPrestamo;
	private JButton btnVerIncidencias;
	private JButton btnEliminarTodos;
	private JComboBox<Juego> comboJuegos_1;
	private JComboBox<Integer> comboBoxUnidades;
	private JSpinner numJugadoresAlta;
	private JSpinner numUnidadesAlta;
	private JButton btnSeleccionarImagen;
	private JLabel lblImagenAñadir;
	private JLabel lblNombreEliminar;
	private JLabel lblPlataformaEliminar;
	private JPanel panelAñadir;
	private JPanel panelModificar;
	private JPanel panelVer;
	private JPanel panelInformacion;

	public GestionJuegos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionJuegos.class.getResource("/images/icons8-play-games-96.png")));

		Border innerBorder1 = BorderFactory.createLineBorder(Color.WHITE, 3);
		Border outerBorder1 = BorderFactory.createLineBorder(new Color(128, 0, 0), 10);

		Border compoundBorder1 = BorderFactory.createCompoundBorder(innerBorder1, outerBorder1);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

		panelCard = new JPanel();
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
		btnEliminar.setBounds(446, 341, 271, 77);
		panelEliminar.add(btnEliminar);

		lblNombreEliminar = new JLabel("Nombre");
		lblNombreEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNombreEliminar.setBounds(377, 71, 146, 31);
		panelEliminar.add(lblNombreEliminar);

		tNombreEliminar = new JTextField();
		tNombreEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		tNombreEliminar.setEditable(false);
		tNombreEliminar.setFont(new Font("Tahoma", Font.BOLD, 20));
		tNombreEliminar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
		tNombreEliminar.setBackground(new Color(214, 217, 223));
		tNombreEliminar.setBounds(535, 72, 302, 31);
		panelEliminar.add(tNombreEliminar);

		lblPlataformaEliminar = new JLabel("Plataforma");
		lblPlataformaEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblPlataformaEliminar.setBounds(377, 148, 146, 31);
		panelEliminar.add(lblPlataformaEliminar);

		JLabel lblUnidadesEliminar = new JLabel("Unidad");
		lblUnidadesEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblUnidadesEliminar.setBounds(141, 214, 99, 31);
		panelEliminar.add(lblUnidadesEliminar);

		tPlataformaEliminar = new JTextField();
		tPlataformaEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		tPlataformaEliminar.setEditable(false);
		tPlataformaEliminar.setFont(new Font("Tahoma", Font.BOLD, 20));
		tPlataformaEliminar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
		tPlataformaEliminar.setBackground(new Color(214, 217, 223));
		tPlataformaEliminar.setBounds(535, 149, 302, 31);
		panelEliminar.add(tPlataformaEliminar);

		comboJuegos_1 = new JComboBox<>(modeloComboJuegos);
		comboJuegos_1.setMaximumRowCount(3);
		comboJuegos_1.setBounds(58, 40, 265, 138);
		panelEliminar.add(comboJuegos_1);

		comboBoxUnidades = new JComboBox<>();
		comboBoxUnidades.setMaximumRowCount(5);
		comboBoxUnidades.setFont(new Font("SansSerif", Font.PLAIN, 20));
		comboBoxUnidades.setBounds(151, 257, 64, 42);
		panelEliminar.add(comboBoxUnidades);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblEstado.setBounds(377, 232, 146, 31);
		panelEliminar.add(lblEstado);

		tEstadoPrestamo = new JTextField();
		tEstadoPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
		tEstadoPrestamo.setFont(new Font("Tahoma", Font.BOLD, 20));
		tEstadoPrestamo.setEditable(false);
		tEstadoPrestamo.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
		tEstadoPrestamo.setBackground(new Color(214, 217, 223));
		tEstadoPrestamo.setBounds(535, 232, 302, 31);
		panelEliminar.add(tEstadoPrestamo);

		btnEliminarTodos = new JButton("ELIMINAR TODOS");
		btnEliminarTodos.setActionCommand("ELIMINAR TODOS");
		btnEliminarTodos.setForeground(Color.WHITE);
		btnEliminarTodos.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEliminarTodos.setBorderPainted(false);
		btnEliminarTodos.setBackground(new Color(128, 0, 0));
		btnEliminarTodos.setBounds(72, 362, 236, 42);
		panelEliminar.add(btnEliminarTodos);

		panelAñadir = new JPanel();
		panelCard.add(panelAñadir, "añadir");
		panelAñadir.setLayout(null);
		panelAñadir.setBorder(compoundBorder1);

		panelModificar = new JPanel();
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

		cPlataformaModificar = new JComboBox<>();
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

		panelVer = new JPanel();
		panelCard.add(panelVer, "ver");
		panelVer.setLayout(new BorderLayout(0, 0));

		panelSelccionJuego = new JPanel();
		panelSelccionJuego.setPreferredSize(new Dimension(320, 10));
		panelVer.add(panelSelccionJuego, BorderLayout.WEST);
		panelSelccionJuego.setLayout(null);

		comboJuegos = new JComboBox<>(modeloComboJuegos);
		comboJuegos.setMaximumRowCount(3);
		comboJuegos.setBackground(new Color(255, 255, 255));

		// render.setPreferredSize(new Dimension(200, 130));

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
		panelCard1.add(panelSinSeleccion, "sinSeleccion");
		panelSinSeleccion.setLayout(new BorderLayout(0, 0));

		panelConSeleccion = new JPanel();
		panelCard1.add(panelConSeleccion, "conSeleccion");
		panelConSeleccion.setLayout(new BorderLayout(0, 0));

		panelInformacion = new JPanel();
		panelConSeleccion.add(panelInformacion, BorderLayout.CENTER);
		panelInformacion.setLayout(null);

		JLabel lblNombreInfo = new JLabel("Nombre: ");
		lblNombreInfo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNombreInfo.setBounds(43, 23, 212, 34);
		panelInformacion.add(lblNombreInfo);

		lblNombreRellenar = new JLabel("");
		lblNombreRellenar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNombreRellenar.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreRellenar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreRellenar.setBounds(267, 23, 276, 34);
		panelInformacion.add(lblNombreRellenar);

		JLabel lblNumJugadoresInfo = new JLabel("Num jugadores:");
		lblNumJugadoresInfo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNumJugadoresInfo.setBounds(43, 80, 212, 34);
		panelInformacion.add(lblNumJugadoresInfo);

		JLabel lblUnidadesInfo = new JLabel("Unidades:");
		lblUnidadesInfo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUnidadesInfo.setBounds(43, 137, 212, 34);
		panelInformacion.add(lblUnidadesInfo);

		JLabel lblUdsUtilizadasInfo = new JLabel("Uds Utilizadas: ");
		lblUdsUtilizadasInfo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUdsUtilizadasInfo.setBounds(43, 194, 212, 34);
		panelInformacion.add(lblUdsUtilizadasInfo);

		JLabel lblIncidenciasInfo = new JLabel("Incidencias:");
		lblIncidenciasInfo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblIncidenciasInfo.setBounds(43, 251, 212, 34);
		panelInformacion.add(lblIncidenciasInfo);

		JLabel lblCompañiaInfo = new JLabel("Compañía: ");
		lblCompañiaInfo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCompañiaInfo.setBounds(43, 308, 212, 34);
		panelInformacion.add(lblCompañiaInfo);

		JLabel lblPlataformaInfo = new JLabel("Plataforma: ");
		lblPlataformaInfo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPlataformaInfo.setBounds(43, 365, 212, 34);
		panelInformacion.add(lblPlataformaInfo);

		lblNumJugadoresRellenar = new JLabel("");
		lblNumJugadoresRellenar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNumJugadoresRellenar.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumJugadoresRellenar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumJugadoresRellenar.setBounds(267, 80, 212, 34);
		panelInformacion.add(lblNumJugadoresRellenar);

		lblUnidadesRellenar = new JLabel("");
		lblUnidadesRellenar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUnidadesRellenar.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnidadesRellenar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUnidadesRellenar.setBounds(267, 137, 212, 34);
		panelInformacion.add(lblUnidadesRellenar);

		lblUdsUtilizadasRellenar = new JLabel("");
		lblUdsUtilizadasRellenar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUdsUtilizadasRellenar.setHorizontalAlignment(SwingConstants.CENTER);
		lblUdsUtilizadasRellenar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUdsUtilizadasRellenar.setBounds(267, 194, 212, 34);
		panelInformacion.add(lblUdsUtilizadasRellenar);

		lblIncidenciasRellenar = new JLabel("");
		lblIncidenciasRellenar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIncidenciasRellenar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncidenciasRellenar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIncidenciasRellenar.setBounds(267, 251, 105, 34);
		panelInformacion.add(lblIncidenciasRellenar);

		lblCompañiaRellenar = new JLabel("");
		lblCompañiaRellenar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCompañiaRellenar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompañiaRellenar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCompañiaRellenar.setBounds(267, 308, 212, 34);
		panelInformacion.add(lblCompañiaRellenar);

		lblPlataformaRellenar = new JLabel("");
		lblPlataformaRellenar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlataformaRellenar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlataformaRellenar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPlataformaRellenar.setBounds(267, 365, 212, 34);
		panelInformacion.add(lblPlataformaRellenar);

		btnVerIncidencias = new JButton("VER");
		btnVerIncidencias.setForeground(new Color(255, 255, 255));
		btnVerIncidencias.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVerIncidencias.setBackground(new Color(128, 0, 0));
		btnVerIncidencias.setBorderPainted(false);
		btnVerIncidencias.setBounds(374, 251, 105, 34);
		panelInformacion.add(btnVerIncidencias);

		lblMensajeSinSeleccionar = new JLabel(
				"<html><center>No ha seleccionado ningún juego, por favor elija uno<br>del desplegable y presione el botón <font color='black'><b>\"Seleccionar\"</b></font><br></center></html>");
		lblMensajeSinSeleccionar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMensajeSinSeleccionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeSinSeleccionar.setForeground(new Color(139, 0, 0));
		lblMensajeSinSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelSinSeleccion.add(lblMensajeSinSeleccionar);

		JLabel lblNombreAñadir = new JLabel("Nombre");
		lblNombreAñadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNombreAñadir.setBounds(339, 49, 146, 31);
		panelAñadir.add(lblNombreAñadir);

		JLabel lblUnidadewsAñadir = new JLabel("Compañia");
		lblUnidadewsAñadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblUnidadewsAñadir.setBounds(339, 369, 146, 31);
		panelAñadir.add(lblUnidadewsAñadir);

		JLabel lblPlataformaAñadir = new JLabel("Plataforma");
		lblPlataformaAñadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblPlataformaAñadir.setBounds(339, 289, 146, 31);
		panelAñadir.add(lblPlataformaAñadir);

		cPlataformaAñadir = new JComboBox<>();
		cPlataformaAñadir.setBounds(538, 289, 302, 31);
		cPlataformaAñadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		cPlataformaAñadir.setBorder(null);
		panelAñadir.add(cPlataformaAñadir);

		btnAñadir = new JButton("AÑADIR");
		btnAñadir.setForeground(Color.WHITE);
		btnAñadir.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnAñadir.setBorderPainted(false);
		btnAñadir.setBackground(new Color(128, 0, 0));
		btnAñadir.setBounds(32, 344, 271, 77);
		panelAñadir.add(btnAñadir);

		tNombreAñadir = new JTextField();
		tNombreAñadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		tNombreAñadir.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
		tNombreAñadir.setBackground(new Color(214, 217, 223));
		tNombreAñadir.setBounds(538, 49, 302, 31);
		panelAñadir.add(tNombreAñadir);

		lblImagenAñadir = new JLabel("");
		lblImagenAñadir.setHorizontalTextPosition(SwingConstants.CENTER);
		lblImagenAñadir.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenAñadir.setBorder(new TitledBorder(new LineBorder(new Color(128, 0, 0), 4, true), "Imagen",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		lblImagenAñadir.setBounds(92, 44, 150, 150);
		panelAñadir.add(lblImagenAñadir);

		btnSeleccionarImagen = new JButton("Seleccionar Imagen");
		btnSeleccionarImagen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSeleccionarImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSeleccionarImagen.setBorder(null);
		btnSeleccionarImagen.setBounds(81, 204, 172, 36);
		panelAñadir.add(btnSeleccionarImagen);

		JLabel lblJugadores = new JLabel("Jugadores");
		lblJugadores.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblJugadores.setBounds(339, 129, 146, 31);
		panelAñadir.add(lblJugadores);

		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblUnidades.setBounds(339, 209, 146, 31);
		panelAñadir.add(lblUnidades);

		compañiaAlta = new JTextField();
		compañiaAlta.setDisabledTextColor(new Color(214, 227, 223));
		compañiaAlta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		compañiaAlta.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
		compañiaAlta.setBackground(new Color(214, 217, 223));
		compañiaAlta.setBounds(538, 369, 302, 31);
		panelAñadir.add(compañiaAlta);

		numJugadoresAlta = new JSpinner();
		numJugadoresAlta.setBackground(new Color(214, 227, 223));
		numJugadoresAlta.setModel(new SpinnerNumberModel(0, null, 999, 1));
		numJugadoresAlta.setBounds(538, 129, 302, 31);
		panelAñadir.add(numJugadoresAlta);

		numUnidadesAlta = new JSpinner();
		numUnidadesAlta.setBounds(538, 209, 302, 31);
		panelAñadir.add(numUnidadesAlta);

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

	public JPanel getPanelAñadir() {
		return panelAñadir;
	}

	public JPanel getPanelModificar() {
		return panelModificar;
	}

	public JPanel getPanelVer() {
		return panelVer;
	}

	public JPanel getPanelInformacion() {
		return panelInformacion;
	}

	/**
	 * @return the panelCard
	 */
	public JPanel getPanelCard() {
		return panelCard;
	}

	/**
	 * @param panelCard the panelCard to set
	 */
	public void setPanelCard(JPanel panelCard) {
		this.panelCard = panelCard;
	}

	public DefaultComboBoxModel<Juego> getModeloComboJuegos() {
		return modeloComboJuegos;
	}

	public void setModeloComboBox(DefaultComboBoxModel<Juego> modeloComboJuegos) {
		this.modeloComboJuegos = modeloComboJuegos;
	}

	/**
	 * @return the comboJuegos
	 */
	public JComboBox<Juego> getComboJuegos() {
		return comboJuegos;
	}

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

	public JTextField gettNombreAñadir() {
		return tNombreAñadir;
	}

	public JTextField gettNombreEliminar() {
		return tNombreEliminar;
	}

	public JTextField gettUnidadesEliminar() {
		return tPlataformaEliminar;
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

	public JComboBox<String> getcPlataformaModificar() {
		return cPlataformaModificar;
	}

	public JComboBox<String> getcPlataformaAñadir() {
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

	/**
	 * @return the comboJuegos_1
	 */
	public JComboBox<Juego> getComboJuegos_1() {
		return comboJuegos_1;
	}

	/**
	 * @return the comboBoxUnidades
	 */
	public JComboBox<Integer> getComboBoxUnidades() {
		return comboBoxUnidades;
	}

	/**
	 * @return the compañiaAlta
	 */
	public JTextField getCompañiaAlta() {
		return compañiaAlta;
	}

	/**
	 * @return the numJugadoresAlta
	 */
	public JSpinner getNumJugadoresAlta() {
		return numJugadoresAlta;
	}

	/**
	 * @return the numUnidadesAlta
	 */
	public JSpinner getNumUnidadesAlta() {
		return numUnidadesAlta;
	}

	/**
	 * @return the lblImagenAñadir
	 */
	public JLabel getLblImagenAñadir() {
		return lblImagenAñadir;
	}

	/**
	 * @return the btnSeleccionarImagen
	 */
	public JButton getBtnSeleccionarImagen() {
		return btnSeleccionarImagen;
	}

	/**
	 * @return the btnVerIncidencias
	 */
	public JButton getBtnVerIncidencias() {
		return btnVerIncidencias;
	}

	/**
	 * @return the tPlataformaEliminar
	 */
	public JTextField gettPlataformaEliminar() {
		return tPlataformaEliminar;
	}

	/**
	 * @return the tEstadoPrestamo
	 */
	public JTextField gettEstadoPrestamo() {
		return tEstadoPrestamo;
	}

	/**
	 * @return the btnEliminarTodos
	 */
	public JButton getBtnEliminarTodos() {
		return btnEliminarTodos;
	}
}
