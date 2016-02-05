package net.vanilton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;

public class InputAndPaste {
	private static String ENTER = "Enter";
	static JButton enterButton;
	static JButton close;
	static JButton clear;
	public static JTextArea output;
	public static JTextField input;
	static JFrame frame;
	static JPanel panel;
	public static String testString = "vanilton.net";

	public static void main(String... args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		createFrame();
	}

	public static void createFrame() {
		frame = new JFrame("Teste Input e Paste");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(true);
		ButtonListener buttonListener = new ButtonListener();
		output = new JTextArea(15, 50);
		output.setWrapStyleWord(true);
		output.setEditable(true);
		JScrollPane scroller = new JScrollPane(output);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel inputpanel = new JPanel();
		inputpanel.setLayout(new FlowLayout());
		input = new JTextField(20);
		enterButton = new JButton("Enter");
		close = new JButton("Fechar");
		clear = new JButton("Limpar");

		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);

			}
		});
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				output.setText(null);
			}
		});

		enterButton.setActionCommand(ENTER);
		enterButton.addActionListener(buttonListener);
		input.setActionCommand(ENTER);
		input.addActionListener(buttonListener);
		DefaultCaret caret = (DefaultCaret) output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		panel.add(scroller);
		inputpanel.add(input);
		inputpanel.add(enterButton);
		inputpanel.add(clear);
		inputpanel.add(close);
		panel.add(inputpanel);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.pack();
		frame.setLocationByPlatform(true);
		// Centralizar
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		input.requestFocus();
	}

	public static class ButtonListener implements ActionListener {

		public void actionPerformed(final ActionEvent ev) {
			if (!input.getText().trim().equals("")) {
				String cmd = ev.getActionCommand();
				if (ENTER.equals(cmd)) {
					output.append(input.getText());
					if (input.getText().trim().equals(testString))
						output.append(" = " + testString);
					else
						output.append(" != " + testString);
					output.append("\n");
				}
			}
			input.setText("");
			input.requestFocus();
		}
	}
}