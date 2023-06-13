package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import model.Juego;
import model.Juego.Unidad;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.ListSelectionModel;

public class VentanaInfoPrestamos extends JFrame {

	private JPanel contentPane;
	private JTextArea tInformacion;
	private JList<Juego.Unidad> listUnidades;
	private JLabel lbImagenJuego;
	private JLabel lblNombreRellenar;
	private JLabel lblPlataformaRellenar;
	private JLabel lblCompañiaRellenar;
	private JButton btnDevolver;
	private JButton btnPrestar;

	public VentanaInfoPrestamos() {

		Border innerBorder1 = BorderFactory.createLineBorder(Color.WHITE, 2);

		Border outerBorder1 = BorderFactory.createLineBorder(new Color(128, 0, 0), 8);

		Border compoundBorder1 = BorderFactory.createCompoundBorder(innerBorder1, outerBorder1);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 609);
		contentPane = new JPanel();
		contentPane.setBorder(compoundBorder1);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelList = new JPanel();
		panelList.setPreferredSize(new Dimension(200, 10));
		panelList.setMinimumSize(new Dimension(200, 10));
		contentPane.add(panelList, BorderLayout.WEST);
		panelList.setLayout(new BorderLayout(0, 0));

		listUnidades = new JList();
		listUnidades.setSelectionBackground(new Color(128, 0, 0));
		listUnidades.setSelectionForeground(Color.BLACK);
		listUnidades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUnidades.setBorder(new LineBorder(new Color(128, 0, 0), 4, true));
		listUnidades.setBackground(new Color(192, 192, 192));

		JScrollPane scrollPane = new JScrollPane(listUnidades);
		panelList.add(scrollPane, BorderLayout.CENTER);

		JPanel panelInfoGeneral = new JPanel();
		contentPane.add(panelInfoGeneral, BorderLayout.CENTER);
		panelInfoGeneral.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(null);
		panel_2.setPreferredSize(new Dimension(10, 340));
		panelInfoGeneral.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(null);

		lbImagenJuego = new JLabel("");
		lbImagenJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lbImagenJuego.setBorder(new LineBorder(new Color(128, 0, 0), 3, true));
		lbImagenJuego.setBounds(28, 24, 218, 195);
		panel_2.add(lbImagenJuego);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombre.setBounds(256, 36, 175, 27);
		panel_2.add(lblNombre);

		JLabel lblPlataforma = new JLabel("Plataforma: ");
		lblPlataforma.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPlataforma.setBounds(256, 83, 175, 27);
		panel_2.add(lblPlataforma);

		JLabel lblCompañia = new JLabel("Compañía: ");
		lblCompañia.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCompañia.setBounds(256, 127, 175, 27);
		panel_2.add(lblCompañia);

		lblNombreRellenar = new JLabel("");
		lblNombreRellenar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
		lblNombreRellenar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreRellenar.setBounds(397, 36, 293, 27);
		panel_2.add(lblNombreRellenar);

		lblPlataformaRellenar = new JLabel("");
		lblPlataformaRellenar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
		lblPlataformaRellenar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlataformaRellenar.setBounds(397, 83, 293, 27);
		panel_2.add(lblPlataformaRellenar);

		lblCompañiaRellenar = new JLabel("");
		lblCompañiaRellenar.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
		lblCompañiaRellenar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCompañiaRellenar.setBounds(397, 127, 293, 27);
		panel_2.add(lblCompañiaRellenar);

		JPanel panelInfoPrestamo = new JPanel();
		panelInfoPrestamo.setBorder(new MatteBorder(0, 2, 0, 0, new Color(128, 0, 0)));
		panelInfoGeneral.add(panelInfoPrestamo, BorderLayout.CENTER);
		panelInfoPrestamo.setLayout(new BorderLayout(0, 0));

		tInformacion = new JTextArea();
		tInformacion.setBackground(Color.WHITE);
		tInformacion.setFont(new Font("Monospaced", Font.BOLD, 20));
		tInformacion.setLineWrap(true);
		tInformacion.setWrapStyleWord(true);
		tInformacion.setColumns(10);
		tInformacion.setBorder(new EmptyBorder(10, 10, 10, 10));

		JScrollPane scrollPane_1 = new JScrollPane(tInformacion);
		scrollPane_1.setBorder(new EmptyBorder(5, 11, 5, 11));
		panelInfoPrestamo.add(scrollPane_1, BorderLayout.CENTER);

		JLabel lblInformacion = new JLabel("<html><u>Información</u></html>");
		lblInformacion.setBorder(null);
		lblInformacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacion.setFont(new Font("Tahoma", Font.BOLD, 24));
		panelInfoPrestamo.add(lblInformacion, BorderLayout.NORTH);

		JPanel panelBotones = new JPanel();
		
		panelBotones.setOpaque(false);
		panelBotones.setBorder(null);
		panelBotones.setPreferredSize(new Dimension(10, 60));
		panelInfoPrestamo.add(panelBotones, BorderLayout.SOUTH);
		SpringLayout sl_panelBotones = new SpringLayout();
		panelBotones.setLayout(sl_panelBotones);

		btnDevolver = new JButton("DEVOLVER");
		sl_panelBotones.putConstraint(SpringLayout.NORTH, btnDevolver, 10, SpringLayout.NORTH, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.WEST, btnDevolver, 186, SpringLayout.WEST, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.SOUTH, btnDevolver, -10, SpringLayout.SOUTH, panelBotones);
		btnDevolver.setPreferredSize(new Dimension(61, 21));
		btnDevolver.setForeground(Color.WHITE);
		btnDevolver.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDevolver.setBorderPainted(false);
		btnDevolver.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnDevolver.setBackground(new Color(128, 0, 0));
		panelBotones.add(btnDevolver);

		btnPrestar = new JButton("PRESTAR");
		btnPrestar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		sl_panelBotones.putConstraint(SpringLayout.EAST, btnDevolver, -9, SpringLayout.WEST, btnPrestar);
		sl_panelBotones.putConstraint(SpringLayout.WEST, btnPrestar, 447, SpringLayout.WEST, panelBotones);
		sl_panelBotones.putConstraint(SpringLayout.NORTH, btnPrestar, 0, SpringLayout.NORTH, btnDevolver);
		sl_panelBotones.putConstraint(SpringLayout.SOUTH, btnPrestar, 0, SpringLayout.SOUTH, btnDevolver);
		sl_panelBotones.putConstraint(SpringLayout.EAST, btnPrestar, -10, SpringLayout.EAST, panelBotones);
		btnPrestar.setPreferredSize(new Dimension(61, 21));
		btnPrestar.setForeground(Color.WHITE);
		btnPrestar.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnPrestar.setBorderPainted(false);
		btnPrestar.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnPrestar.setBackground(new Color(128, 0, 0));
		panelBotones.add(btnPrestar);

	}

	public JTextArea gettInformacion() {
		return tInformacion;
	}

	public JList<Unidad> getListJuegos() {
		return listUnidades;
	}

	public JLabel getLbImagenJuego() {
		return lbImagenJuego;
	}

	public JLabel getLblNombreRellenar() {
		return lblNombreRellenar;
	}

	public JLabel getLblPlataformaRellenar() {
		return lblPlataformaRellenar;
	}

	public JLabel getLblCompañiaRellenar() {
		return lblCompañiaRellenar;
	}

	public JButton getBtnDevolver() {
		return btnDevolver;
	}

	public JButton getBtnPrestar() {
		return btnPrestar;
	}
}
