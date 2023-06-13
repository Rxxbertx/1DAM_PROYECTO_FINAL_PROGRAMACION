package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class VentanaPrinicipalSocio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7103505920094447842L;
	private JPanel contentPane;
	private JButton btnAjustesCuenta;
	private JButton btnVerJuegos;
	private JButton btnSalir;
	private JLabel lblBienvenido;
	private JPanel panelBienvenida;
	private JLabel lblUsuarioRellenar;
	private JPanel panelCard;
	private JLabel lblNewLabel;
	private JPanel panelAjustesCuenta;
	private JScrollPane scrollPane;
	private JLabel lblNombreRellenar;
	private JLabel lblApellidosRellenar;
	private JButton btnSalirSi;
	private JButton btnSalirNo;
	private JPanel panelJuegos;
	private JLabel lblUsuarioRellenar2;
	private JPanel panelConJuego;
	private JButton btnJuegoPrestado;
	private JButton btnDevolver;

	public VentanaPrinicipalSocio() {

		Border innerBorder1 = BorderFactory.createLineBorder(Color.WHITE, 0);
		Border outerBorder1 = BorderFactory.createLineBorder(new Color(128, 0, 0), 8);

		Border compoundBorder1 = BorderFactory.createCompoundBorder(innerBorder1, outerBorder1);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelInteraccion = new JPanel();
		panelInteraccion.setPreferredSize(new Dimension(250, 10));
		contentPane.add(panelInteraccion, BorderLayout.WEST);
		panelInteraccion.setBorder(compoundBorder1);
		panelInteraccion.setLayout(null);

		btnAjustesCuenta = new JButton("");
		btnAjustesCuenta.setContentAreaFilled(false);
		btnAjustesCuenta.setBorderPainted(false);
		btnAjustesCuenta.setIcon(
				new ImageIcon(VentanaPrinicipalSocio.class.getResource("/images/icons8-ajustes-de-usuario-100.png")));
		btnAjustesCuenta.setBounds(69, 216, 111, 115);
		panelInteraccion.add(btnAjustesCuenta);

		btnVerJuegos = new JButton("");
		btnVerJuegos.setContentAreaFilled(false);
		btnVerJuegos.setBorderPainted(false);
		btnVerJuegos
				.setIcon(new ImageIcon(VentanaPrinicipalSocio.class.getResource("/images/icons8-espionaje-100.png")));
		btnVerJuegos.setBounds(82, 69, 85, 109);
		panelInteraccion.add(btnVerJuegos);

		btnSalir = new JButton("");
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setIcon(new ImageIcon(VentanaPrinicipalSocio.class.getResource("/images/icons8-salir-100.png")));
		btnSalir.setBounds(58, 368, 133, 129);
		panelInteraccion.add(btnSalir);

		JPanel panelCompleto = new JPanel();
		contentPane.add(panelCompleto, BorderLayout.CENTER);
		panelCompleto.setLayout(new BorderLayout(0, 0));

		panelBienvenida = new JPanel();
		panelBienvenida.setPreferredSize(new Dimension(10, 120));
		panelCompleto.add(panelBienvenida, BorderLayout.NORTH);
		panelBienvenida.setBorder(new MatteBorder(8, 0, 8, 8, new Color(128, 0, 0)));
		panelBienvenida.setLayout(null);

		lblBienvenido = new JLabel("<html>BIENVENID<font color='black'>@</font></html>");
		lblBienvenido.setForeground(new Color(128, 0, 0));
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBienvenido.setBounds(42, 33, 247, 46);
		panelBienvenida.add(lblBienvenido);

		lblUsuarioRellenar = new JLabel("");
		lblUsuarioRellenar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUsuarioRellenar.setBounds(299, 35, 278, 46);
		panelBienvenida.add(lblUsuarioRellenar);

		panelCard = new JPanel();
		panelCompleto.add(panelCard, BorderLayout.CENTER);
		panelCard.setLayout(new CardLayout(0, 0));
		// panelCard.setBorder(compoundBorder1);

		JPanel panel = new JPanel();
		panelCard.add(panel, "inicio");
		panel.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel(
				"<html><center><font color='black'><u><b> No tiene ningún juego en préstamo</b></u></font><br><br>Para ver los juegos disponibles pulse el botón de la  <font color='black'><b>lupa</b></font><br>Para cambiar sus datos de usuario pulse en   <font color='black'><b>configuración</b></font><br>Para salir de esta pantalla pulse el botón de  <font color='black'><b>salir</b></font><br></center></html>");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);

		panelJuegos = new JPanel();
		panelJuegos.setLayout(new GridLayout(0, 3, 20, 20));

		scrollPane = new JScrollPane(panelJuegos);

		panelCard.add(scrollPane, "ver");

		panelAjustesCuenta = new JPanel();
		panelCard.add(panelAjustesCuenta, "ajustes");
		panelAjustesCuenta.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Apellidos");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(133, 198, 120, 37);
		panelAjustesCuenta.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Usuario");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2.setBounds(133, 314, 120, 37);
		panelAjustesCuenta.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(133, 82, 120, 37);
		panelAjustesCuenta.add(lblNewLabel_1_1_1);

		lblNombreRellenar = new JLabel("");
		lblNombreRellenar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNombreRellenar.setBorder(new MatteBorder(0, 0, 4, 0, new Color(128, 0, 0)));
		lblNombreRellenar.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreRellenar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNombreRellenar.setBounds(305, 82, 266, 37);
		panelAjustesCuenta.add(lblNombreRellenar);

		lblApellidosRellenar = new JLabel("");
		lblApellidosRellenar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblApellidosRellenar.setBorder(new MatteBorder(0, 0, 4, 0, new Color(128, 0, 0)));
		lblApellidosRellenar.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidosRellenar.setBounds(305, 198, 266, 37);
		panelAjustesCuenta.add(lblApellidosRellenar);

		lblUsuarioRellenar2 = new JLabel("");
		lblUsuarioRellenar2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsuarioRellenar2.setBorder(new MatteBorder(0, 0, 4, 0, new Color(128, 0, 0)));
		lblUsuarioRellenar2.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarioRellenar2.setBounds(305, 314, 266, 37);
		panelAjustesCuenta.add(lblUsuarioRellenar2);

		JPanel panelSalir = new JPanel();
		panelCard.add(panelSalir, "salir");
		panelSalir.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Seguro que deseas salir?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(165, 128, 339, 51);
		panelSalir.add(lblNewLabel_1);

		btnSalirSi = new JButton("Si");
		btnSalirSi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalirSi.setForeground(new Color(255, 255, 255));
		btnSalirSi.setBorderPainted(false);
		btnSalirSi.setBackground(new Color(128, 0, 0));
		btnSalirSi.setBounds(182, 217, 117, 49);
		panelSalir.add(btnSalirSi);

		btnSalirNo = new JButton("No, Volver al Menu");
		btnSalirNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalirNo.setForeground(new Color(255, 255, 255));
		btnSalirNo.setBorderPainted(false);
		btnSalirNo.setBackground(new Color(128, 0, 0));
		btnSalirNo.setBounds(336, 218, 152, 48);
		panelSalir.add(btnSalirNo);

		panelConJuego = new JPanel();
		panelCard.add(panelConJuego, "juego");
		panelConJuego.setLayout(new BoxLayout(panelConJuego, BoxLayout.Y_AXIS));

		JLabel lblNewLabel_2 = new JLabel("Prestamos En Curso");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setMaximumSize(new Dimension(260, 20));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_2.setBorder(new EmptyBorder(10, 0, 0, 0));
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelConJuego.add(lblNewLabel_2);

		Component verticalGlue = Box.createVerticalGlue();
		panelConJuego.add(verticalGlue);

		btnJuegoPrestado = new JButton("");
		btnJuegoPrestado.setBackground(Color.GRAY);
		btnJuegoPrestado.setBorderPainted(false);
		btnJuegoPrestado.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnJuegoPrestado.setHorizontalTextPosition(SwingConstants.CENTER);
		btnJuegoPrestado.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnJuegoPrestado.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnJuegoPrestado.setActionCommand("");
		panelConJuego.add(btnJuegoPrestado);

		Component verticalGlue_1 = Box.createVerticalGlue();
		panelConJuego.add(verticalGlue_1);

		btnDevolver = new JButton("DEVOLVER");
		btnDevolver.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnDevolver.setBackground(new Color(128, 0, 0));
		btnDevolver.setForeground(new Color(255, 255, 255));
		btnDevolver.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDevolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelConJuego.add(btnDevolver);

	}

	@Override
	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnAjustesCuenta() {
		return btnAjustesCuenta;
	}

	public JButton getBtnVerJuegos() {
		return btnVerJuegos;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JLabel getLblBienvenido() {
		return lblBienvenido;
	}

	public JPanel getPanelBienvenida() {
		return panelBienvenida;
	}

	public JLabel getLblUsuarioRellenar() {
		return lblUsuarioRellenar;
	}

	public JPanel getPanelCard() {
		return panelCard;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public JPanel getPanelAjustesCuenta() {
		return panelAjustesCuenta;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JLabel getLblNombreRellenar() {
		return lblNombreRellenar;
	}

	public JLabel getLblApellidosRellenar() {
		return lblApellidosRellenar;
	}

	public JButton getBtnSalirSi() {
		return btnSalirSi;
	}

	public JButton getBtnSalirNo() {
		return btnSalirNo;
	}

	public JPanel getPanelJuegos() {
		return panelJuegos;
	}

	public JLabel getLblUsuarioRellenar2() {
		return lblUsuarioRellenar2;
	}

	public JPanel getPanelConJuego() {
		return panelConJuego;
	}

	public JButton getBtnJuegoPrestado() {
		return btnJuegoPrestado;
	}

	public JButton getBtnDevolver() {
		return btnDevolver;
	}
}
