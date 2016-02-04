package net.vanilton;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

/**
 * A Swing program that demonstrates how to use JRadioButton component.
 * 
 * @author www.codejava.net
 * 
 */
public class RadioButton extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton buttonOK = new JButton("OK");

	private JRadioButton optionLinux = new JRadioButton("Linux");
	private JRadioButton optionWin = new JRadioButton("Windows");
	private JRadioButton optionMac = new JRadioButton("Macintosh");

	private JLabel labelImage = new JLabel();

	private ImageIcon iconLinux = new ImageIcon(getClass().getResource(
			"/pictures/linux.jpg"));
	private ImageIcon iconWin = new ImageIcon(getClass().getResource(
			"/pictures/windows.jpg"));
	private ImageIcon iconMac = new ImageIcon(getClass().getResource(
			"/pictures/mac.jpg"));

	public RadioButton() {
		super("Radio Buttons");

		ButtonGroup group = new ButtonGroup();
		group.add(optionLinux);
		group.add(optionWin);
		group.add(optionMac);

		optionWin.setSelected(true);
		labelImage.setIcon(iconWin);

		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.insets = new Insets(10, 10, 10, 10);

		add(optionLinux, constraints);
		constraints.gridx = 1;
		add(optionWin, constraints);
		constraints.gridx = 2;
		add(optionMac, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 3;

		add(labelImage, constraints);

		constraints.gridy = 2;
		add(buttonOK, constraints);

		RadioButtonActionListener actionListener = new RadioButtonActionListener();
		optionLinux.addActionListener(actionListener);
		optionWin.addActionListener(actionListener);
		optionMac.addActionListener(actionListener);

		buttonOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				String selectedOption = "";
				if (optionLinux.isSelected()) {
					selectedOption = "Linux";
				} else if (optionWin.isSelected()) {
					selectedOption = "Windows";
				} else if (optionMac.isSelected()) {
					selectedOption = "Macintosh";
				}
				JOptionPane.showMessageDialog(RadioButton.this,
						"Você Selecionou: " + selectedOption);
			}
		});

		pack();
		setLocationRelativeTo(null);
	}

	class RadioButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			JRadioButton button = (JRadioButton) event.getSource();
			if (button == optionLinux) {

				labelImage.setIcon(iconLinux);

			} else if (button == optionWin) {

				labelImage.setIcon(iconWin);

			} else if (button == optionMac) {

				labelImage.setIcon(iconMac);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new RadioButton().setVisible(true);
			}
		});
	}
}