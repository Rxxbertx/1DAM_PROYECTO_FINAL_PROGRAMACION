package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import utilidades.utilidades;

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
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;

public class VentanaPrincipalEmpleado extends JFrame {

	private JPanel contentPane;
	private JButton btnGestionUsuarios;
	private JLabel lblRellenarUsuario;
	private JButton btnGestionSalir;
	private JButton btnGestionPrestamos;
	private JButton btnGestionIncidencias;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_2;
	private Component verticalGlue_3;
	private Component verticalGlue_4;
	private Component verticalGlue_5;
	private JButton btnGestionJuegos;
	private JPanel panelBienvenida;

	public VentanaPrincipalEmpleado() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaPrincipalEmpleado.class.getResource("/images/icons8-play-games-96.png")));

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
		toolBar.setOpaque(false);
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.WEST);
		toolBar.setBorder(compoundBorder);

		verticalGlue = Box.createVerticalGlue();
		toolBar.add(verticalGlue);

		btnGestionJuegos = new JButton("Juegos");
		btnGestionJuegos
				.setIcon(new ImageIcon(VentanaPrincipalEmpleado.class.getResource("/images/icons8-play-games-96.png")));
		btnGestionJuegos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGestionJuegos.setBorder(null);
		toolBar.add(btnGestionJuegos);

		verticalGlue_1 = Box.createVerticalGlue();
		toolBar.add(verticalGlue_1);

		btnGestionIncidencias = new JButton("Incidencias");
		btnGestionIncidencias
				.setIcon(new ImageIcon(VentanaPrincipalEmpleado.class.getResource("/images/icons8-warning-96.png")));
		btnGestionIncidencias.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGestionIncidencias.setBorder(null);
		toolBar.add(btnGestionIncidencias);

		btnGestionPrestamos = new JButton("Prestamos");
		btnGestionPrestamos.setIcon(
				new ImageIcon(VentanaPrincipalEmpleado.class.getResource("/images/icons8-inbox-settings-96.png")));
		btnGestionPrestamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		verticalGlue_2 = Box.createVerticalGlue();
		toolBar.add(verticalGlue_2);
		btnGestionPrestamos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGestionPrestamos.setBorder(null);
		toolBar.add(btnGestionPrestamos);

		verticalGlue_3 = Box.createVerticalGlue();
		toolBar.add(verticalGlue_3);

		btnGestionUsuarios = new JButton("Usuarios");
		btnGestionUsuarios.setIcon(new ImageIcon(
				VentanaPrincipalEmpleado.class.getResource("/images/icons8-llamada-de-conferencia-96.png")));
		toolBar.add(btnGestionUsuarios);
		btnGestionUsuarios.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGestionUsuarios.setBorder(null);

		verticalGlue_4 = Box.createVerticalGlue();
		toolBar.add(verticalGlue_4);

		btnGestionSalir = new JButton("Salir");
		btnGestionSalir
				.setIcon(new ImageIcon(VentanaPrincipalEmpleado.class.getResource("/images/icons8-exit-96(1).png")));
		btnGestionSalir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGestionSalir.setBorder(null);
		toolBar.add(btnGestionSalir);

		verticalGlue_5 = Box.createVerticalGlue();
		toolBar.add(verticalGlue_5);

		panelBienvenida = new JPanel();
		contentPane.add(panelBienvenida, BorderLayout.CENTER);
		panelBienvenida.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 3), null));
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
		lblNewLabel.setIcon(utilidades.resizeIcon(new ImageIcon("src/images/ventanaPrincipalLogo.png"), 2000, 500));
		lblNewLabel.setBounds(-54, 138, 1057, 619);
		panelBienvenida.add(lblNewLabel);

	}

	public JButton getBtnGestionSalir() {
		return btnGestionSalir;
	}

	public JButton getBtnGestionPrestamos() {
		return btnGestionPrestamos;
	}

	public JButton getBtnGestionIncidencias() {
		return btnGestionIncidencias;
	}

	public JPanel getPanelBienvenida() {
		return panelBienvenida;
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
