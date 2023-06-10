package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btnGestionUsuarios;
	private JButton btnGestionJuegos;
	private JLabel lblRellenarUsuario;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaPrincipal.class.getResource("/images/icons8-play-games-96.png")));

		Border innerBorder = BorderFactory.createLineBorder(Color.WHITE, 3);
		Border outerBorder = BorderFactory.createLineBorder(new Color(128, 0, 0), 10);

		Border compoundBorder = BorderFactory.createCompoundBorder(innerBorder, outerBorder);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 609);
		contentPane = new JPanel();

		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 6, true));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.WEST);
		toolBar.setBorder(compoundBorder);

		btnGestionJuegos = new JButton("New button");
		btnGestionJuegos.setAlignmentY(2.0f);
		btnGestionJuegos.setText("Juegos   ");

		btnGestionJuegos.setVerticalAlignment(SwingConstants.BOTTOM);
		btnGestionJuegos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons8-play-games-96.png")));
		toolBar.add(btnGestionJuegos);

		btnGestionJuegos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGestionJuegos.setBorder(new LineBorder(Color.white, 4, true));

		btnGestionUsuarios = new JButton("Usuarios");
		btnGestionUsuarios.setIcon(
				new ImageIcon(VentanaPrincipal.class.getResource("/images/icons8-llamada-de-conferencia-96.png")));
		toolBar.add(btnGestionUsuarios);
		btnGestionUsuarios.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGestionUsuarios.setBorder(new LineBorder(Color.white, 4, true));

		JPanel panelBienvenida = new JPanel();
		contentPane.add(panelBienvenida, BorderLayout.CENTER);
		panelBienvenida.setBorder(compoundBorder);
		panelBienvenida.setLayout(null);

		JLabel lblBienvenida = new JLabel("<html>BIENVENID<font color='black'>@</font></html>");
		lblBienvenida.setForeground(new Color(128, 0, 0));
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblBienvenida.setBounds(88, 49, 588, 87);
		panelBienvenida.add(lblBienvenida);

		lblRellenarUsuario = new JLabel("");
		lblRellenarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRellenarUsuario.setForeground(new Color(0, 0, 0));
		lblRellenarUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblRellenarUsuario.setBounds(336, 49, 340, 87);
		panelBienvenida.add(lblRellenarUsuario);

	JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/datossCentro.gif")));
		lblNewLabel.setBounds(155, 146, 391, 427);
		panelBienvenida.add(lblNewLabel);

	}

	/**
	 * @return the btnGestionUsuarios
	 */
	public JButton getBtnGestionUsuarios() {
		return btnGestionUsuarios;
	}

	/**
	 * @param btnGestionUsuarios the btnGestionUsuarios to set
	 */
	public void setBtnGestionUsuarios(JButton btnGestionUsuarios) {
		this.btnGestionUsuarios = btnGestionUsuarios;
	}

	/**
	 * @return the btnGestionJuegos
	 */
	public JButton getBtnGestionJuegos() {
		return btnGestionJuegos;
	}

	/**
	 * @param btnGestionJuegos the btnGestionJuegos to set
	 */
	public void setBtnGestionJuegos(JButton btnGestionJuegos) {
		this.btnGestionJuegos = btnGestionJuegos;
	}

	/**
	 * @return the lblRellenarUsuario
	 */
	public JLabel getLblRellenarUsuario() {
		return lblRellenarUsuario;
	}

	/**
	 * @param lblRellenarUsuario the lblRellenarUsuario to set
	 */
	public void setLblRellenarUsuario(JLabel lblRellenarUsuario) {
		this.lblRellenarUsuario = lblRellenarUsuario;
	}
}
