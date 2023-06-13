package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class VentanaLoginWindow extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 3238110608786952114L;
	private JPanel contentPane;
	private JTextField textFieldUsuarioLogin;
	private JPasswordField textFieldContraseñaLogin;
	private JTextField textFieldNombreRegistro;
	private JTextField textFieldApellidosRegistro;
	private JTextField textFieldUsuarioRegistro;
	private JPasswordField textFieldContraseñaRegistro;
	private JPanel panelRegistrar;
	private JButton btnAlta;
	private JButton btnAltaLogin;
	private JButton btnEntrar;
	private JPanel panelLogin;
	private JPanel panelCard;
	private JLabel lblError;
	private JButton btnVolver;

	/**
	 * Create the frame.
	 */
	public VentanaLoginWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLoginWindow.class.getResource("/images/icons8-play-games-96.png")));
		setTitle("App");
		setBackground(new Color(128, 0, 0));
		setFont(new Font("Arial", Font.PLAIN, 15));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 12, true));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(4, 4));

		panelCard = new JPanel();
		contentPane.add(panelCard, BorderLayout.CENTER);
		panelCard.setLayout(new CardLayout(3, 3));

		panelLogin = new JPanel();
		panelLogin.setLayout(null);
		panelCard.add(panelLogin, "panelLogin");

		JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblIniciarSesion.setBorder(new MatteBorder(0, 0, 10, 0, new Color(128, 0, 0)));
		lblIniciarSesion.setBounds(123, 38, 330, 59);
		panelLogin.add(lblIniciarSesion);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblUsuario.setBounds(81, 161, 146, 31);
		panelLogin.add(lblUsuario);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblContraseña.setBounds(81, 271, 146, 37);
		panelLogin.add(lblContraseña);

		textFieldUsuarioLogin = new JTextField();
		textFieldUsuarioLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		textFieldUsuarioLogin.setColumns(10);
		textFieldUsuarioLogin.setBounds(303, 155, 216, 43);
		panelLogin.add(textFieldUsuarioLogin);

		textFieldContraseñaLogin = new JPasswordField();
		textFieldContraseñaLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		textFieldContraseñaLogin.setColumns(10);
		textFieldContraseñaLogin.setBounds(303, 268, 216, 43);
		panelLogin.add(textFieldContraseñaLogin);



		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEntrar.setBorderPainted(false);
		btnEntrar.setBackground(new Color(128, 0, 0));
		btnEntrar.setBounds(152, 353, 271, 77);
		panelLogin.add(btnEntrar);

		JLabel lblInfo = new JLabel("No tienes cuenta? Date de ");
		lblInfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblInfo.setBounds(81, 470, 279, 31);
		panelLogin.add(lblInfo);

		btnAltaLogin = new JButton("ALTA");
		btnAltaLogin.setContentAreaFilled(false);
		btnAltaLogin.setForeground(new Color(128, 0, 0));
		btnAltaLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnAltaLogin.setBorder(new MatteBorder(0, 0, 3, 0, new Color(0, 0, 0)));
		btnAltaLogin.setBounds(356, 463, 89, 43);
		panelLogin.add(btnAltaLogin);

		lblError = new JLabel("Error en el Usuario o Contraseña, si no tienes usuario puedes darte de Alta");
		lblError.setForeground(new Color(128, 0, 0));
		lblError.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblError.setBounds(14, 421, 548, 37);
		panelLogin.add(lblError);
		lblError.setVisible(false);

		panelRegistrar = new JPanel();
		panelCard.add(panelRegistrar, "panelRegistrar");
		panelRegistrar.setLayout(null);

		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblRegistrarse.setBorder(new MatteBorder(0, 0, 10, 0, new Color(128, 0, 0)));
		lblRegistrarse.setBounds(196, 27, 306, 98);
		panelRegistrar.add(lblRegistrarse);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNombre.setBounds(91, 167, 146, 31);
		panelRegistrar.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblApellidos.setBounds(91, 242, 146, 37);
		panelRegistrar.add(lblApellidos);

		textFieldNombreRegistro = new JTextField();
		textFieldNombreRegistro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		textFieldNombreRegistro.setColumns(10);
		textFieldNombreRegistro.setBounds(286, 161, 216, 43);
		panelRegistrar.add(textFieldNombreRegistro);

		textFieldApellidosRegistro = new JTextField();
		textFieldApellidosRegistro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		textFieldApellidosRegistro.setColumns(10);
		textFieldApellidosRegistro.setBounds(286, 239, 216, 43);
		panelRegistrar.add(textFieldApellidosRegistro);

		btnAlta = new JButton("ALTA");
		btnAlta.setForeground(Color.WHITE);
		btnAlta.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnAlta.setBorderPainted(false);
		btnAlta.setBackground(new Color(128, 0, 0));
		btnAlta.setBounds(152, 444, 271, 77);
		panelRegistrar.add(btnAlta);

		JLabel lblUsuarioTit = new JLabel("Usuario");
		lblUsuarioTit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblUsuarioTit.setBounds(91, 314, 146, 31);
		panelRegistrar.add(lblUsuarioTit);

		textFieldUsuarioRegistro = new JTextField();
		textFieldUsuarioRegistro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		textFieldUsuarioRegistro.setColumns(10);
		textFieldUsuarioRegistro.setBounds(286, 308, 216, 43);
		panelRegistrar.add(textFieldUsuarioRegistro);

		JLabel lblContraseñaTit = new JLabel("Contraseña");
		lblContraseñaTit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblContraseñaTit.setBounds(91, 385, 146, 31);
		panelRegistrar.add(lblContraseñaTit);

		textFieldContraseñaRegistro = new JPasswordField();
		textFieldContraseñaRegistro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		textFieldContraseñaRegistro.setColumns(10);
		textFieldContraseñaRegistro.setBounds(286, 379, 216, 43);
		panelRegistrar.add(textFieldContraseñaRegistro);

		btnVolver = new JButton("");
		btnVolver.setBorder(null);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setIcon(new ImageIcon(VentanaLoginWindow.class.getResource("/images/volver.png")));
		btnVolver.setBounds(76, 60, 72, 51);
		panelRegistrar.add(btnVolver);

		JPanel panel = new JPanel();

		panel.setBackground(new Color(128, 0, 0));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel lblImagen = new JLabel(new ImageIcon(VentanaLoginWindow.class.getResource("/images/lateral.png")));
		panel.add(lblImagen);

		// Agregar "pegamento" horizontal para rellenar el espacio sobrante
		panel.add(Box.createVerticalGlue());
		panel.add(lblImagen);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	/**
	 * @return the contentPane
	 */
	@Override
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * @return the textFieldUsuarioLogin
	 */
	public JTextField getTextFieldUsuarioLogin() {
		return textFieldUsuarioLogin;
	}

	/**
	 * @return the textFieldContraseñaLogin
	 */
	public  JPasswordField getTextFieldContraseñaLogin() {
		return textFieldContraseñaLogin;
	}

	/**
	 * @return the textFieldNombreRegistro
	 */
	public JTextField getTextFieldNombreRegistro() {
		return textFieldNombreRegistro;
	}

	/**
	 * @return the textFieldApellidosRegistro
	 */
	public JTextField getTextFieldApellidosRegistro() {
		return textFieldApellidosRegistro;
	}

	/**
	 * @return the textFieldUsuarioRegistro
	 */
	public JTextField getTextFieldUsuarioRegistro() {
		return textFieldUsuarioRegistro;
	}

	/**
	 * @return the textFieldContraseñaRegistro
	 */
	public JPasswordField getTextFieldContraseñaRegistro() {
		return textFieldContraseñaRegistro;
	}

	/**
	 * @return the panelRegistrar
	 */
	public JPanel getPanelRegistrar() {
		return panelRegistrar;
	}

	/**
	 * @return the btnAlta
	 */
	public JButton getBtnAlta() {
		return btnAlta;
	}

	/**
	 * @return the btnAltaLogin
	 */
	public JButton getBtnAltaLogin() {
		return btnAltaLogin;
	}

	/**
	 * @return the btnEntrar
	 */
	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	/**
	 * @return the panelLogin
	 */
	public JPanel getPanelLogin() {
		return panelLogin;
	}

	/**
	 * @return the panelCard
	 */
	public JPanel getPanelCard() {
		return panelCard;
	}

	/**
	 * @return the lblError
	 */
	public JLabel getLblError() {
		return lblError;
	}

	/**
	 * @param lblError the lblError to set
	 */
	public void setLblError(JLabel lblError) {
		this.lblError = lblError;
	}

	/**
	 * @return the btnVolver
	 */
	public JButton getBtnVolver() {
		return btnVolver;
	}

	/**
	 * @param btnVolver the btnVolver to set
	 */
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
}
