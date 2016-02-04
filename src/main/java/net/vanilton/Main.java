package net.vanilton;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon logoCaboquinho = new ImageIcon(getClass().getResource(
			"/pictures/logo.jpg"));
	private final Action acaoSair = new Sair();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
							"ico.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(46, 44, 260, 252);
		contentPane.add(logo);
		logo.setIcon(logoCaboquinho);
		setTitle("Aplicação de Testes - Ferramenta Sikuli");
		setSize(352, 400);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu MenuFile = new JMenu("File");
		menuBar.add(MenuFile);
		
		JMenu funcoes = new JMenu("Funções");
		menuBar.add(funcoes);

		JMenuItem fbasicas = new JMenuItem("Find e Click");
		JMenuItem fsimilaridade = new JMenuItem("Similaridade");

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setAction(acaoSair);
		MenuFile.add(mntmSair);

		fbasicas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RadioButton rb = new RadioButton();
				rb.setVisible(true);
			}
		});

		fsimilaridade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Similarity sim = new Similarity();
				sim.setVisible(true);

			}
		});

		funcoes.add(fbasicas);
		funcoes.add(fsimilaridade);
	}

	@SuppressWarnings("serial")
	private class Sair extends AbstractAction {
		public Sair() {
			putValue(NAME, "Sair");
			putValue(SHORT_DESCRIPTION, "Fechar a aplicação");
		}

		public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(null, "Deseja realmente sair?",
					"Operação", 0) == 0) {
				System.exit(0);
			}
		}
	}
}
