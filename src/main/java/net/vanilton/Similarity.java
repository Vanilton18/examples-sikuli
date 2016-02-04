package net.vanilton;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Similarity extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon iconLinux = new ImageIcon(getClass().getResource(
			"/pictures/linux.jpg"));
	private ImageIcon iconLinuxMaior = new ImageIcon(getClass().getResource(
			"/pictures/linuxMaior.jpg"));
	private ImageIcon iconLinuxDif = new ImageIcon(getClass().getResource(
			"/pictures/linuxDif.jpg"));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Similarity frame = new Similarity();
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
	public Similarity() {
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Brincando de Similaridade");

		JLabel iconeLinuxPeq = new JLabel("");
		iconeLinuxPeq.setToolTipText("Linux Pequeno");
		iconeLinuxPeq.setBounds(333, 21, 71, 86);
		contentPane.add(iconeLinuxPeq);

		iconeLinuxPeq.setIcon(iconLinux);

		JLabel IconeLinuxMaior = new JLabel("");
		IconeLinuxMaior.setToolTipText("Linux Maior Sem Brilho");
		IconeLinuxMaior.setBounds(463, 22, 300, 214);
		contentPane.add(IconeLinuxMaior);

		IconeLinuxMaior.setIcon(iconLinuxMaior);

		JLabel iconeLinuxDif = new JLabel("");
		iconeLinuxDif.setToolTipText("Linux Brilhante");
		iconeLinuxDif.setBounds(81, 108, 334, 310);
		contentPane.add(iconeLinuxDif);
		
		iconeLinuxDif.setIcon(iconLinuxDif);
	}
}
