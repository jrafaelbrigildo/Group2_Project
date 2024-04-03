package quizgame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.*;

import quizgame.Menu;

public class CreditPage extends JFrame{
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
					CreditPage frame = new CreditPage();
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
	public CreditPage() {
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
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setText("Main Developer:\r\n- Brigildo, John Rafael H.\r\n\r\nSupporting Developers:\r\n- Beliganio, Arjay S.\r\n- Bihag, Rose Ann T.\r\n- Bolo, Lyza April P.\r\n\r\nDesigners:\r\n- Bihag, Rose Ann T.\r\n- Bolo, Lyza April P.\r\n\r\nEngr. Dean Adrian Nombrefia\r\nInstructor\r\n\r\nBSCpE III-GF\r\nCollege of Engineering\r\nSouthern Luzon State University-Main\r\n\r\nContacts:\r\nasbeliganio@slsu.edu.ph \r\nratbihag@slsu.edu.ph \r\nlapbolo@slsu.edu.ph \r\njrhbrigildo@slsu.edu.ph \r\n\r\nThis application is provided \r\n\"as is\" without warranty of\r\nany kind.");
		textArea.setEditable(false);
		textArea.setForeground(Color.WHITE);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(textArea);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		textArea.setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setOpaque(false);
		scrollPane.setBounds(85, 227, 313, 217);
		contentPane.add(scrollPane);
		
		JPanel panel_4 = new RoundedPanel(60);
		panel_4.setBackground(SystemColor.scrollbar);
		panel_4.setOpaque(false);
		panel_4.setBounds(21, 11, 56, 56);
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
		back_button.setIcon(new ImageIcon(CreditPage.class.getResource("/images/back.png")));
		back_button.setBounds(10, 11, 36, 30);
		panel_4.add(back_button);

		
		labelBg = new JLabel();
		labelBg.setIcon(new ImageIcon(CreditPage.class.getResource("/images/creditBg.png")));
		labelBg.setBounds(0, 0, 449, 541);
		contentPane.add(labelBg);
		
	}
}
