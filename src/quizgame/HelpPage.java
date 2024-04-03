package quizgame;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import quizgame.Menu;

import java.awt.event.*;
import java.util.*;

public class HelpPage extends JFrame{
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel labelBg;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpPage frame = new HelpPage();
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
	public HelpPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //
		Image icon = Toolkit.getDefaultToolkit().getImage("sketch1673959132047.png");
		setIconImage(icon);
		setResizable(false);
		setBounds(100, 100, 465, 580);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();
		scrollPane = new JScrollPane();
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setMargin(new Insets(20, 20, 20, 20));
		textArea.setText("Hi! Welcome to Codebusters!\r\n\r\nEnjoy playing while learning \r\nby  testing  your  knowledge \r\nabout  the   three different\r\nprogramming languages.\r\n\r\n1. Press the START button.\r\n2. Choose   and   press the \r\nbutton of  the programming\r\nlanguage you desired to play.\r\nWe   have   C++,   Java,  and \r\nPython.\r\n3. Choose   the  best answer\r\nfrom the four choices.\r\n4. You   have   only   THREE\r\nprecious lives. Once you lost\r\nthem, your GAME IS OVER.\r\n\r\nLET'S START BUSTING CODES!");
		textArea.setEditable(false);
		textArea.setForeground(Color.WHITE);
		
		scrollPane.setViewportView(textArea);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		textArea.setOpaque(false);
		scrollPane.setBounds(85, 227, 313, 217);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setOpaque(false);
		contentPane.add(scrollPane);
		
		JPanel panel_4 = new RoundedPanel(60);
		panel_4.setBackground(SystemColor.scrollbar);
		panel_4.setOpaque(false);
		panel_4.setBounds(22, 23, 52, 50);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		
		JButton back_button = new JButton();
		
		back_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			MainPage fMainPage = new MainPage();
			setVisible(false);
			fMainPage.setVisible(true);
			}
		});
		back_button.setIcon(new ImageIcon(HelpPage.class.getResource("/images/back.png")));
		back_button.setBounds(8, 9, 36, 30);
		panel_4.add(back_button);
		
		labelBg = new JLabel();
		labelBg.setIcon(new ImageIcon(HelpPage.class.getResource("/images/helpBg.png")));
		labelBg.setBounds(0, 0, 449, 541);
		contentPane.add(labelBg);
	}
}
