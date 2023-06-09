package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JSpinner;

public class GestionJuegos extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1015, 114);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setIcon(new ImageIcon(GestionJuegos.class.getResource("/images/icons8-menos-64.png")));
		btnNewButton_1.setBounds(352, 20, 90, 73);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setIcon(new ImageIcon(GestionJuegos.class.getResource("/images/icons8-surprise-64.png")));
		btnNewButton_1_1.setBounds(573, 20, 90, 73);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setIcon(new ImageIcon(GestionJuegos.class.getResource("/images/icons8-edit-64.png")));
		btnNewButton_2.setBounds(794, 20, 90, 73);
		panel.add(btnNewButton_2);
		btnNewButton_2.setBorderPainted(false);
		panel.setBackground(new Color(128, 0, 0, 255)); 
        panel.setOpaque(true);
        
        JButton btnNewButton_1_2 = new JButton("");
        btnNewButton_1_2.setIcon(new ImageIcon(GestionJuegos.class.getResource("/images/icons8-más-64.png")));
        btnNewButton_1_2.setContentAreaFilled(false);
        btnNewButton_1_2.setBorderPainted(false);
        btnNewButton_1_2.setBounds(131, 20, 90, 73);
        panel.add(btnNewButton_1_2);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 11, 995, 92);
        panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 4, true));
		panel_2.setBackground(new Color(128, 0, 0, 255)); 

        panel.add(panel_2);
        
        JPanel panelCard = new JPanel();
        panelCard.setBounds(10, 136, 1015, 553);
        contentPane.add(panelCard);
        panelCard.setBorder(new LineBorder(new Color(128, 0, 0), 4, true));
        panelCard.setLayout(new CardLayout(0, 0));
        
        JPanel panelEliminar = new JPanel();
        panelCard.add(panelEliminar, "eliminar");
        panelEliminar.setLayout(null);
        
        JButton btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnEliminar.setBorderPainted(false);
        btnEliminar.setBackground(new Color(128, 0, 0));
        btnEliminar.setBounds(368, 402, 271, 77);
        panelEliminar.add(btnEliminar);
        
        JLabel lblNewLabel_2_3 = new JLabel("Nombre");
        lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_2_3.setBounds(171, 136, 146, 31);
        panelEliminar.add(lblNewLabel_2_3);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        textField.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
        textField.setBackground(Color.WHITE);
        textField.setBounds(535, 137, 302, 31);
        panelEliminar.add(textField);
        
        JLabel lblNewLabel_2_2_1 = new JLabel("Plataforma");
        lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_2_2_1.setBounds(171, 205, 146, 31);
        panelEliminar.add(lblNewLabel_2_2_1);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        comboBox_1.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
        comboBox_1.setBounds(535, 205, 302, 31);
        panelEliminar.add(comboBox_1);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("Unidades");
        lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_2_1_1.setBounds(171, 275, 146, 31);
        panelEliminar.add(lblNewLabel_2_1_1);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        textField_3.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
        textField_3.setBackground(Color.WHITE);
        textField_3.setBounds(535, 275, 302, 31);
        panelEliminar.add(textField_3);
        
        JPanel panelAñadir = new JPanel();
        panelCard.add(panelAñadir, "añadir");
        panelAñadir.setLayout(null);
        
        JPanel panelModificar = new JPanel();
        panelCard.add(panelModificar, "modificar");
        panelModificar.setLayout(null);
        
        JLabel lblNewLabel_2_3_1 = new JLabel("Nombre");
        lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_2_3_1.setBounds(172, 121, 146, 31);
        panelModificar.add(lblNewLabel_2_3_1);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        textField_4.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
        textField_4.setBackground(Color.WHITE);
        textField_4.setBounds(536, 122, 302, 31);
        panelModificar.add(textField_4);
        
        JLabel lblNewLabel_2_2_1_1 = new JLabel("Plataforma");
        lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_2_2_1_1.setBounds(172, 190, 146, 31);
        panelModificar.add(lblNewLabel_2_2_1_1);
        
        JComboBox comboBox_1_1 = new JComboBox();
        comboBox_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        comboBox_1_1.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
        comboBox_1_1.setBounds(536, 190, 302, 31);
        panelModificar.add(comboBox_1_1);
        
        JLabel lblNewLabel_2_1_1_1 = new JLabel("Unidades");
        lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_2_1_1_1.setBounds(172, 260, 146, 31);
        panelModificar.add(lblNewLabel_2_1_1_1);
        
        textField_5 = new JTextField();
        textField_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        textField_5.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
        textField_5.setBackground(Color.WHITE);
        textField_5.setBounds(536, 260, 302, 31);
        panelModificar.add(textField_5);
        
        JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Nº Jugadores");
        lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_2_1_1_1_1.setBounds(172, 325, 189, 31);
        panelModificar.add(lblNewLabel_2_1_1_1_1);
        
       
        
        JPanel panelVer = new JPanel();
        panelCard.add(panelVer, "ver");
        panelVer.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Nombre");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_2.setBounds(174, 132, 146, 31);
        panelAñadir.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("Unidades");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_2_1.setBounds(174, 271, 146, 31);
        panelAñadir.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_2 = new JLabel("Plataforma");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_2_2.setBounds(174, 201, 146, 31);
        panelAñadir.add(lblNewLabel_2_2);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(538, 201, 302, 31);
        comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        comboBox.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
        panelAñadir.add(comboBox);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        textField_1.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
        textField_1.setBackground(Color.white);
        textField_1.setBounds(538, 271, 302, 31);
        panelAñadir.add(textField_1);
        
        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnAceptar.setBorderPainted(false);
        btnAceptar.setBackground(new Color(128, 0, 0));
        btnAceptar.setBounds(368, 397, 271, 77);
        panelAñadir.add(btnAceptar);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        textField_2.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 0, 0)));
        textField_2.setBackground(Color.WHITE);
        textField_2.setBounds(538, 133, 302, 31);
        panelAñadir.add(textField_2);
        
        JSpinner spinner = new JSpinner();
        spinner.setBounds(536, 325, 302, 31);
        panelModificar.add(spinner);
        spinner.setBorder(new MatteBorder(2, 2, 2, 0, new Color(128, 0, 0)));
        
        JButton btnModificar = new JButton("MODIFICAR");
        btnModificar.setForeground(Color.WHITE);
        btnModificar.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnModificar.setBorderPainted(false);
        btnModificar.setBackground(new Color(128, 0, 0));
        btnModificar.setBounds(368, 411, 271, 77);
        panelModificar.add(btnModificar);
	}
}
