package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class GestionIncidencias extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionIncidencias frame = new GestionIncidencias();
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
	public GestionIncidencias() {
		
		Border innerBorder1 = BorderFactory.createLineBorder(Color.WHITE, 2);
		Border outerBorder1 = BorderFactory.createLineBorder(new Color(128, 0, 0), 6);

		Border compoundBorder1 = BorderFactory.createCompoundBorder(innerBorder1, outerBorder1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 609);
		contentPane = new JPanel();
		contentPane.setBorder(compoundBorder1);
		

		Border innerBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
		Border outerBorder = BorderFactory.createLineBorder(new Color(128, 0, 0), 4);

		Border compoundBorder = BorderFactory.createCompoundBorder(innerBorder, outerBorder);
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInfo = new JPanel();
		panelInfo.setPreferredSize(new Dimension(220, 10));
		panelInfo.setBorder(compoundBorder);
		contentPane.add(panelInfo, BorderLayout.WEST);
		
		JPanel panelCombo = new JPanel();
		panelCombo.setPreferredSize(new Dimension(10, 220));
		panelCombo.setBorder(compoundBorder);
		contentPane.add(panelCombo, BorderLayout.NORTH);
		
		JPanel panelEstado = new JPanel();
		panelEstado.setBorder(compoundBorder);

		contentPane.add(panelEstado, BorderLayout.CENTER);
	}

}
