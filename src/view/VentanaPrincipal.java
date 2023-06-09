package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 6, true));


		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.WEST);
		
		JButton btnGestionJuegos = new JButton("New button");
		btnGestionJuegos.setAlignmentY(2.0f);
		btnGestionJuegos.setText("Juegos   ");
		
		btnGestionJuegos.setVerticalAlignment(SwingConstants.BOTTOM);
		btnGestionJuegos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/58f36427a4fa116215a923cf (1).png")));
		toolBar.add(btnGestionJuegos);
		
		btnGestionJuegos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGestionJuegos.setBorder(new LineBorder(new Color(97, 19, 175), 2, true));
		
		JButton btnGestionUsuarios = new JButton("Usuarios");
		btnGestionUsuarios.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/2849121.png")));
		toolBar.add(btnGestionUsuarios);
		btnGestionUsuarios.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGestionUsuarios.setBorder(new LineBorder(new Color(97, 19, 175), 2, true));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(new Rectangle(0, 0, 800, 811));
		lblNewLabel.setMaximumSize(new Dimension(800, 811));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/KT56LZC53FCB5MJPOOON3YARWA (2).jpg")));
		panel.add(lblNewLabel);
		




	}
}
