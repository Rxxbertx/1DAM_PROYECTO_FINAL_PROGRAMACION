package view;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class GestionSocios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionSocios frame = new GestionSocios();
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
	public GestionSocios() {
		
		Border innerBorder1 = BorderFactory.createLineBorder(Color.WHITE, 0);
		Border outerBorder1 = BorderFactory.createLineBorder(new Color(128, 0, 0), 8);

		Border compoundBorder1 = BorderFactory.createCompoundBorder(innerBorder1, outerBorder1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(GestionSocios.class.getResource("/images/icons8-ajustes-de-usuario-100.png")));
		btnNewButton.setBounds(69, 216, 111, 115);
		panelInteraccion.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(GestionSocios.class.getResource("/images/icons8-espionaje-100.png")));
		btnNewButton_1.setBounds(82, 69, 85, 109);
		panelInteraccion.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setIcon(new ImageIcon(GestionSocios.class.getResource("/images/icons8-salir-100.png")));
		btnNewButton_2.setBounds(58, 368, 133, 129);
		panelInteraccion.add(btnNewButton_2);
		
		JPanel panelCompleto = new JPanel();
		contentPane.add(panelCompleto, BorderLayout.CENTER);
		panelCompleto.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setPreferredSize(new Dimension(10, 120));
		panelCompleto.add(panelBienvenida, BorderLayout.NORTH);
		panelBienvenida.setBorder(new MatteBorder(8, 0, 8, 8, (Color) new Color(128, 0, 0)));
		panelBienvenida.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("<html>BIENVENID<font color='black'>@</font></html>");
		lblBienvenido.setForeground(new Color(128, 0, 0));
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBienvenido.setBounds(42, 33, 247, 46);
		panelBienvenida.add(lblBienvenido);
		
		JLabel lblUsuarioRellenar = new JLabel("");
		lblUsuarioRellenar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUsuarioRellenar.setBounds(299, 35, 278, 46);
		panelBienvenida.add(lblUsuarioRellenar);

		
		JPanel panelCard = new JPanel();
		panelCompleto.add(panelCard, BorderLayout.CENTER);
		panelCard.setLayout(new CardLayout(0, 0));
		//panelCard.setBorder(compoundBorder1);
		
		JPanel panel = new JPanel();
		panelCard.add(panel, "name_5432354024500");
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("<html><center><font color='black'><u><b> No tiene ningún juego en préstamo</b></u></font><br><br>Para ver los juegos disponibles pulse el botón de la  <font color='black'><b>lupa</b></font><br>Para cambiar sus datos de usuario pulse en   <font color='black'><b>configuración</b></font><br>Para salir de esta pantalla pulse el botón de  <font color='black'><b>salir</b></font><br></center></html>");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);

	}
}
