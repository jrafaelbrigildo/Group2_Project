package quizgame;

import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;



public class LoadingPage extends JFrame {

	
	private JProgressBar progressBar;
	private JLabel perCount;
	private JLabel label_1;
	public static Clip clip;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LoadingPage frame = new LoadingPage();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				frame.setVisible(true);
				}
			});
			
				try {
					for (int i = 0; i <= 100; i++) {
						Thread.sleep(50);
						frame.progressBar.setValue(i);
						frame.perCount.setText(Integer.toString(i) + "%");
					}
					
					playSound("quiz-121408.wav");
			        
				} catch (Exception e) {
					e.printStackTrace();
				}
				MainPage MP = new MainPage();
				frame.setVisible(false);
				MP.setVisible(true);
				
				frame.dispose();
}

	/**
	 * Create the application.
	 */
	public LoadingPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 465, 580);
		 //
		Image icon = Toolkit.getDefaultToolkit().getImage("sketch1673959132047.png");
		setIconImage(icon);
        setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		perCount = new JLabel();
		perCount.setIcon(new ImageIcon(LoadingPage.class.getResource("/images/code buster (4).png")));
		perCount.setForeground(new Color(255, 51, 0));
		perCount.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		perCount.setHorizontalAlignment(SwingConstants.CENTER);
		perCount.setBounds(49, 388, 373, 99);
		getContentPane().add(perCount);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(255, 255, 255,160));
		progressBar.setForeground(new Color(0, 0, 102));
		progressBar.setBounds(38, 388, 373, 99);
		getContentPane().add(progressBar);
		
		JLabel loading_label = new JLabel("LOADING.....");
		loading_label.setFont(new Font("Arial Black", Font.BOLD, 16));
		loading_label.setForeground(new Color(255, 51, 0));
		loading_label.setHorizontalAlignment(SwingConstants.CENTER);
		loading_label.setBounds(172, 489, 129, 23);
		getContentPane().add(loading_label);
		
		label_1 = new JLabel();
		label_1.setIcon(new ImageIcon(LoadingPage.class.getResource("/images/code buster (3).png")));
		label_1.setBounds(0, 0, 449, 541);
		getContentPane().add(label_1);
			
	}
	public static void playSound(String fileName) {
        try {
            File soundFile = new File(fileName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);    
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
}
}
