package quizgame;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;





public class MainPage extends JFrame {
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LoadingPage mainClass = new LoadingPage();
        mainClass.main(args);
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //
		Image icon = Toolkit.getDefaultToolkit().getImage("sketch1673959132047.png");
		setIconImage(icon);
		setBounds(100, 100, 465, 580);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//panel for start button
		JPanel panel_1 = new RoundedPanel(40);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(125, 140, 199, 75);
		contentPane.add(panel_1);
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
		
		//start button
		JButton startBtn = new JButton();
		
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			startBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/hover_start.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			startBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/start.png")));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			Menu categ = new Menu();
			setVisible(false);
			categ.setVisible(true);
			}
		});
		startBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/start.png")));
		startBtn.setBounds(10, 11, 179, 53);
		startBtn.setBorder(new LineBorder(Color.white));
		panel_1.add(startBtn);
		
		//panel for help button
		JPanel panel_2 = new RoundedPanel(60);
		panel_2.setBounds(125, 63, 59, 56);
		panel_2.setBackground(Color.WHITE);
		panel_2.setOpaque(false);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		//help button
		JButton helpBtn = new JButton();
		helpBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			helpBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/hover_help.png")));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
			helpBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/help.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HelpPage help = new HelpPage();
				setVisible(false);
				help.setVisible(true);
			}
		});
		helpBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/help.png")));
		helpBtn.setBounds(10, 11, 39, 34);
		helpBtn.setBorder(new LineBorder(Color.white));
		panel_2.add(helpBtn);
		
		//panel for exit button
		RoundedPanel panel_3 = new RoundedPanel(60);
		panel_3.setOpaque(false);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(265, 63, 59, 56);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		//exit button
		JButton exitBtn = new JButton();
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			exitBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/hover_exit.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			exitBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/exit.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/exit.png")));
		exitBtn.setBorder(new LineBorder(Color.white));
		exitBtn.setBounds(10, 11, 39, 34);
		panel_3.add(exitBtn);
		
		//panel for credit button
		RoundedPanel panel_4 = new RoundedPanel(60);
		panel_4.setOpaque(false);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(194, 63, 59, 56);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		//credit button
		JButton creditBtn = new JButton();
		creditBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			creditBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/hover_credits.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			creditBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/credits.png")));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				CreditPage credit = new CreditPage();
				setVisible(false);
				credit.setVisible(true);
			}
		});
		creditBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/credits.png")));
		creditBtn.setBorder(new LineBorder(Color.white));
		creditBtn.setBounds(10, 11, 39, 34);
		panel_4.add(creditBtn);
		
		//background image
		JLabel label_1 = new JLabel();
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setIcon(new ImageIcon(MainPage.class.getResource("/images/code buster (2).png")));
		label_1.setBounds(0, 0, 449, 541);
		contentPane.add(label_1);		
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 409, 363, 91);
		contentPane.add(panel);
	
	}
}
