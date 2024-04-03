package quizgame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.*;


public class Results extends JFrame {

	private JPanel contentPane;
	private JTextField per_accuracy;
	private JTextArea rating;
	private JTextField resultfield;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Results frame = new Results();
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
	public Results() {
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
		
		resultfield = new JTextField();
		
		resultfield.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resultfield.setText("0");
		
		resultfield.setEditable(false);
		resultfield.setForeground(Color.WHITE);
		resultfield.setBorder(new LineBorder(new Color(0, 0, 51)));
		resultfield.setOpaque(false);
		resultfield.setBounds(253, 217, 42, 30);
		contentPane.add(resultfield);
		
		rating = new JTextArea();
		rating.setBorder(new LineBorder(new Color(0, 0, 51)));
		rating.setBackground(new Color(0, 0, 51));
		rating.setOpaque(false);
		rating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rating.setBounds(125, 287, 199, 58);
		rating.setForeground(Color.WHITE);
		rating.setEditable(false);
		contentPane.add(rating);
		
		JPanel panel_1 = new RoundedPanel(40);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(125, 458, 199, 59);
		contentPane.add(panel_1);
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
		
		JButton exitBtn = new JButton();
		exitBtn.setBorder(new LineBorder(Color.WHITE));
		exitBtn.setIcon(new ImageIcon(Results.class.getResource("/images/exit1.png")));
		exitBtn.setBounds(10, 8, 179, 43);
		panel_1.add(exitBtn);
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitBtn.setIcon(new ImageIcon(Results.class.getResource("/images/exit1_hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitBtn.setIcon(new ImageIcon(Results.class.getResource("/images/exit1.png")));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			System.exit(0);
			}
		});
		
		
		JPanel panel_2 = new RoundedPanel(40);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(125, 382, 199, 59);
		contentPane.add(panel_2);
		panel_2.setOpaque(false);
		panel_2.setLayout(null);
		
		JButton playAgainBtn = new JButton();
		playAgainBtn.setBorder(new LineBorder(Color.WHITE));
		playAgainBtn.setIcon(new ImageIcon(Results.class.getResource("/images/playagain.png")));
		playAgainBtn.setBounds(10, 8, 179, 43);
		panel_2.add(playAgainBtn);
		playAgainBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playAgainBtn.setIcon(new ImageIcon(Results.class.getResource("/images/playagain_hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				playAgainBtn.setIcon(new ImageIcon(Results.class.getResource("/images/playagain.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			Menu categ = new Menu();
			setVisible(false);
			categ.setVisible(true);
			LoadingPage.clip.setFramePosition(0);
			LoadingPage.clip.start();
			}
		});
		
		JLabel score_label = new JLabel("SCORE:");
		score_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		score_label.setForeground(Color.WHITE);
		score_label.setBounds(177, 221, 66, 22);
		contentPane.add(score_label);
		
		double score = question_c_plus.scores;
		
		int whole_score = (int) score ;
		
		String final_score = Integer.toString(whole_score);
		
		resultfield.setText(final_score);
		
		double accuracy = ((score/15)*100);
		DecimalFormat df = new DecimalFormat("#.#");
		if (whole_score>=14) {
			rating.setText("           Excellent!");
			
		} else if(whole_score<=13 && whole_score>=10){
			rating.setText("          Keep up the \n          good work!");
		}
		else if(whole_score<=9 && whole_score>=6){
			rating.setText("          You have to \n          study more..");
		}
		else {
			rating.setText("   It's okay...Study more,\n        you can do it!");
		}
				
		JLabel accuracy_label = new JLabel("ACCURACY:");
		accuracy_label.setForeground(Color.WHITE);
		accuracy_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		accuracy_label.setBounds(144, 254, 99, 22);
		contentPane.add(accuracy_label);
		
		per_accuracy = new JTextField();
		per_accuracy.setOpaque(false);
		String accuracytext = df.format(accuracy);
		per_accuracy.setText(accuracytext + "%");
		per_accuracy.setForeground(Color.WHITE);
		per_accuracy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		per_accuracy.setEditable(false);
		per_accuracy.setBorder(new LineBorder(new Color(0, 0, 51)));
		per_accuracy.setBounds(253, 250, 66, 30);
		contentPane.add(per_accuracy);
	
		JLabel label_1 = new JLabel();
		label_1.setIcon(new ImageIcon(Results.class.getResource("/images/resultbg.png")));
		label_1.setBounds(0, 0, 449, 541);
		contentPane.add(label_1);
	
	}
	
}
