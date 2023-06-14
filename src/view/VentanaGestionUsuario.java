package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class VentanaGestionUsuario extends JFrame {

	private JPanel contentPane;
	private JButton btnEliminar;
	private JPanel panelCard;
	private JPanel panelAñadir;
	private JTextField tNombreRellenar;
	private JTextField tApellidosRellenar;
	private JTextField tNomUsuarioRellenar;
	private JTextField tContraseñaRellenar;
	private JCheckBox chckbxSerEmpleado;
	private JButton btnAñadir;
	private JPanel panelEliminar;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaGestionUsuario frame = new VentanaGestionUsuario();
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
	public VentanaGestionUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaGestionUsuario.class.getResource("/images/icons8-play-games-96.png")));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(4, 4, 4, 4, new Color(128, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelSeleccion = new JPanel();
		panelSeleccion.setBackground(new Color(128, 0, 0));
		panelSeleccion.setPreferredSize(new Dimension(200, 10));
		contentPane.add(panelSeleccion, BorderLayout.WEST);
		panelSeleccion.setLayout(new BoxLayout(panelSeleccion, BoxLayout.Y_AXIS));

		Component verticalGlue = Box.createVerticalGlue();
		panelSeleccion.add(verticalGlue);

		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAñadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAñadir.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAñadir.setBorderPainted(false);
		btnAñadir.setBorder(null);
		btnAñadir.setContentAreaFilled(false);
		btnAñadir.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAñadir.setIcon(new ImageIcon(VentanaGestionUsuario.class.getResource("/images/icons8-más-64.png")));
		panelSeleccion.add(btnAñadir);

		Component verticalGlue_1 = Box.createVerticalGlue();
		panelSeleccion.add(verticalGlue_1);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBorder(null);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEliminar.setIcon(new ImageIcon(VentanaGestionUsuario.class.getResource("/images/icons8-menos-64.png")));
		panelSeleccion.add(btnEliminar);

		Component verticalGlue_2 = Box.createVerticalGlue();
		panelSeleccion.add(verticalGlue_2);

		panelCard = new JPanel();
		contentPane.add(panelCard, BorderLayout.CENTER);
		panelCard.setLayout(new CardLayout(0, 0));

		panelAñadir = new JPanel();
		panelCard.add(panelAñadir, "añadir");
		panelAñadir.setLayout(null);

		JLabel lblCreacionUsuario = new JLabel("<html><u>CREACIÓN DE USUARIO</u></html>");
		lblCreacionUsuario.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCreacionUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreacionUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCreacionUsuario.setBounds(181, 54, 361, 55);
		panelAñadir.add(lblCreacionUsuario);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombre.setBounds(86, 151, 211, 25);
		panelAñadir.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblApellidos.setBounds(86, 207, 211, 25);
		panelAñadir.add(lblApellidos);

		JLabel lblNomUsuario = new JLabel("Nombre Usuario");
		lblNomUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNomUsuario.setBounds(86, 269, 211, 25);
		panelAñadir.add(lblNomUsuario);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblContraseña.setBounds(86, 329, 211, 25);
		panelAñadir.add(lblContraseña);

		tNombreRellenar = new JTextField("");
		tNombreRellenar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tNombreRellenar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
		tNombreRellenar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tNombreRellenar.setBounds(363, 151, 211, 25);
		panelAñadir.add(tNombreRellenar);

		tApellidosRellenar = new JTextField("");
		tApellidosRellenar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tApellidosRellenar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
		tApellidosRellenar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tApellidosRellenar.setBounds(363, 207, 211, 25);
		panelAñadir.add(tApellidosRellenar);

		tNomUsuarioRellenar = new JTextField("");
		tNomUsuarioRellenar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tNomUsuarioRellenar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
		tNomUsuarioRellenar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tNomUsuarioRellenar.setBounds(363, 269, 211, 25);
		panelAñadir.add(tNomUsuarioRellenar);

		tContraseñaRellenar = new JTextField("");
		tContraseñaRellenar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tContraseñaRellenar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
		tContraseñaRellenar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tContraseñaRellenar.setBounds(363, 329, 211, 25);
		panelAñadir.add(tContraseñaRellenar);

		chckbxSerEmpleado = new JCheckBox("Es empleado");
		chckbxSerEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxSerEmpleado.setBounds(286, 415, 151, 21);
		panelAñadir.add(chckbxSerEmpleado);

		btnAñadir = new JButton("AÑADIR");
		btnAñadir.setPreferredSize(new Dimension(81, 21));
		btnAñadir.setForeground(Color.WHITE);
		btnAñadir.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnAñadir.setBorderPainted(false);
		btnAñadir.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnAñadir.setBackground(new Color(128, 0, 0));
		btnAñadir.setBounds(278, 464, 166, 55);
		panelAñadir.add(btnAñadir);

		panelEliminar = new JPanel();
		panelCard.add(panelEliminar, "eliminar");
		panelEliminar.setLayout(new BorderLayout(0, 0));

		JPanel panelRelleno2 = new JPanel();
		panelRelleno2.setPreferredSize(new Dimension(150, 10));
		panelRelleno2.setMinimumSize(new Dimension(150, 150));
		panelEliminar.add(panelRelleno2, BorderLayout.WEST);

		JPanel panelRelleno1 = new JPanel();
		panelRelleno1.setPreferredSize(new Dimension(150, 10));
		panelEliminar.add(panelRelleno1, BorderLayout.EAST);

		JPanel panelTituloEliminar = new JPanel();
		panelTituloEliminar.setPreferredSize(new Dimension(10, 100));
		panelEliminar.add(panelTituloEliminar, BorderLayout.NORTH);
		panelTituloEliminar.setLayout(null);

		JLabel lblEliminacinDeUsuario = new JLabel("<html><u>ELIMINACIÓN DE USUARIO</u></html>");
		lblEliminacinDeUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEliminacinDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminacinDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEliminacinDeUsuario.setBounds(181, 22, 361, 55);
		panelTituloEliminar.add(lblEliminacinDeUsuario);

		JPanel panelBotonEliminar = new JPanel();
		panelBotonEliminar.setPreferredSize(new Dimension(10, 100));
		panelEliminar.add(panelBotonEliminar, BorderLayout.SOUTH);
		panelBotonEliminar.setLayout(null);

		JButton btnEliminarEliminacion = new JButton("ELIMINAR");
		btnEliminarEliminacion.setPreferredSize(new Dimension(81, 21));
		btnEliminarEliminacion.setForeground(Color.WHITE);
		btnEliminarEliminacion.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEliminarEliminacion.setBorderPainted(false);
		btnEliminarEliminacion.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnEliminarEliminacion.setBackground(new Color(128, 0, 0));
		btnEliminarEliminacion.setBounds(264, 22, 195, 55);
		panelBotonEliminar.add(btnEliminarEliminacion);

		JScrollPane scrollPane = new JScrollPane();
		panelEliminar.add(scrollPane, BorderLayout.CENTER);

		list = new JList();
		scrollPane.setViewportView(list);
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JPanel getPanelCard() {
		return panelCard;
	}

	public JPanel getPanelAñadir() {
		return panelAñadir;
	}

	public JTextField gettNombreRellenar() {
		return tNombreRellenar;
	}

	public JTextField gettApellidosRellenar() {
		return tApellidosRellenar;
	}

	public JTextField gettNomUsuarioRellenar() {
		return tNomUsuarioRellenar;
	}

	public JTextField gettContraseñaRellenar() {
		return tContraseñaRellenar;
	}

	public JCheckBox getChckbxSerEmpleado() {
		return chckbxSerEmpleado;
	}

	public JButton getBtnAñadir() {
		return btnAñadir;
	}

	public JPanel getPanelEliminar() {
		return panelEliminar;
	}

	public JList getList() {
		return list;
	}
}
