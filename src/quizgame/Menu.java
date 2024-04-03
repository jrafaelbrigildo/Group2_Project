package quizgame;

import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Menu extends JFrame {

	private JPanel contentPane;
	public static Clip clip1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
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
		
		JPanel panel_1 = new RoundedPanel(40);
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(139, 214, 204, 64);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//button for c++
		JButton button_c_plus = new JButton();
		button_c_plus.setBorder(null);
		button_c_plus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			button_c_plus.setIcon(new ImageIcon(Menu.class.getResource("/images/hoverc++.png")));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			button_c_plus.setIcon(new ImageIcon(Menu.class.getResource("/images/c++.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			question_c_plus ques_c_plus = new question_c_plus();
			setVisible(false);
			ques_c_plus.setVisible(true);
			LoadingPage.clip.stop();
			playSound("quizgamebgmusic.wav");
			}
		});
		button_c_plus.setIcon(new ImageIcon(Menu.class.getResource("/images/c++.png")));
		button_c_plus.setBounds(10, 3, 184, 58);
		panel_1.add(button_c_plus);
		
		JPanel panel_2 = new RoundedPanel(40);
		panel_2.setOpaque(false);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(139, 289, 204, 64);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		//button for java
		JButton button_java = new JButton();
		button_java.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			button_java.setIcon(new ImageIcon(Menu.class.getResource("/images/hoverjava.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button_java.setIcon(new ImageIcon(Menu.class.getResource("/images/java.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			question_java ques_java = new question_java();
			setVisible(false);
			ques_java.setVisible(true);
			LoadingPage.clip.stop();
			playSound("quizgamebgmusic.wav");
			}
		});
		button_java.setBorder(null);
		button_java.setIcon(new ImageIcon(Menu.class.getResource("/images/java.png")));
		button_java.setBounds(10, 3, 184, 58);
		panel_2.add(button_java);
		
		JPanel panel_3 = new RoundedPanel(40);
		panel_3.setOpaque(false);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(139, 363, 204, 64);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		//button for python
		JButton button_python = new JButton();
		button_python.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			button_python.setIcon(new ImageIcon(Menu.class.getResource("/images/hoverpython.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			button_python.setIcon(new ImageIcon(Menu.class.getResource("/images/python.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			question_python ques_python = new question_python();
			setVisible(false);
			ques_python.setVisible(true);
			LoadingPage.clip.stop();
			playSound("quizgamebgmusic.wav");
			}
		});
		button_python.setBorder(null);
		button_python.setIcon(new ImageIcon(Menu.class.getResource("/images/python.png")));
		button_python.setBounds(10, 3, 184, 58);
		panel_3.add(button_python);
		
		JPanel panel_4 = new RoundedPanel(60);
		panel_4.setBackground(SystemColor.scrollbar);
		panel_4.setOpaque(false);
		panel_4.setBounds(22, 23, 52, 50);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		//return button
		JButton back_button = new JButton();
		
		back_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			MainPage fMainPage = new MainPage();
			setVisible(false);
			fMainPage.setVisible(true);
			}
		});
		back_button.setIcon(new ImageIcon(Menu.class.getResource("/images/back.png")));
		back_button.setBounds(8, 9, 36, 30);
		panel_4.add(back_button);
		
		//background image
		JLabel label_1 = new JLabel();
		label_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setIcon(new ImageIcon(Menu.class.getResource("/images/menubg.png")));
		label_1.setBounds(0, -13, 449, 570);
		contentPane.add(label_1);		
					
	}
	public static void playSound(String fileName) {
        try {
            File soundFile = new File(fileName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip1 = AudioSystem.getClip();
            clip1.open(audioInputStream);
            clip1.start();
            clip1.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
}

}
