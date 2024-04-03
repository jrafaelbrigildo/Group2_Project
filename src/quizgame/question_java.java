package quizgame;

import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;

public class question_java extends JFrame{
	private JPanel contentPane;
	private JButton[] answerButtons;
    private int currentQuestion;
    private JTextField score;
    private JTextField lives_text;
    private JTextArea questionsTextArea;
    public static int lives, scores;
    private Random random_ans;
	
	String[][] questions = 	{
			
			//EASY
			//1
			{"\nWhich of these is returned by \noperator \'&\' ?",  "Character",
			"Integer", "Boolean", "Float"},
			//2
			{"\nWhat Scanner class method would you \nuse to read a string as input?", "nextLine", "nextString", "readString", "getLine"},
			//3
			{"\nData type long literals are appended \nby _____","Both Uppercase L and Lowercase L", "Uppercase L","Lowercase L","Long"},
			//4
			{"Which statement transfer execution to \ndifferent parts of your code \nbased on the value of an expression?"
					, "Switch","If",
					"Nested-if","if-else-if"},
			//5
			{"\nWhich of the following are \nnot Java modifiers?","friendly",
					"public","private","transient"},
			//Average
			//1
			{"What would display from the following\n statements? int [ ] "
					+ "nums = {1,2,3,4,5,6};\n System.out.println((nums[1] + nums[3]));"
					,"6","2+4","1+3", "4"},
			//2
			{"Which of the following is not an \nOOPS concept in Java?",
					"Encapsulations", "Polymorphism",
					"Inheritance", "Compilation"},
			//3
			{"\nWhich of the following is a \nsuperclass of every class in Java?"
						,"Object class","ArrayList","Abstract class","String"},
			//4
			{"\nWhich one of the following is \nnot an access modifier?",
					"Void","Protected","Public","Private"},
			//5
			{"Will this code compile successfully?\\n\r\n"
					+ "class One{public void process(){\\n\r\n"
					+ "\\tSystem.out.println(\"Parent\");}}\\n\r\n"
					+ "public abstract class Test extends One{\\n\r\n"
					+ "\\tpublic abstract void process();}", 
					"Yes",
					"No", "Maybe", "Runtime error"},
			//Difficult
			//1
			{"What is the correct way to create\n an object called myObj of MyClass?", "MyClass myObj = new MyClass(); ",
						"class MyClass = new myObj();", "class myObj = new MyClass();", "new myObj = MyClass();"},
			//2
			{"What will be the output of the \nfollowing Java program?\n"
					+ "class increment {public static void\\n \r\n"
					+ "main(String args[]) {        \r\n"
					+ "int g = 3;\\nSystem.out.print(++g * 8);}}\r\n"
					, "32", "33", "24", "25"},
			//3
			{"What will be the output of the \\nfollowing Java program?\\n\r\n"
					+ "class output {public static void \\nmain(String args[]){\\n \r\n"
					+ "StringBuffer s1 = new StringBuffer(\"Quiz\");\\n\r\n"
					+ "StringBuffer s2 = s1.reverse();\\n\r\n"
					+ "System.out.println(s2);}}\r\n"	
					, "ziuQ", "Quiz", "QuizziuQ", "ziuQQuize"},
			//4
			{"Which of the below is valid way \nto instantiate an array in java?",
						"int myArray [] = {1, 3, 5};", " int myArray [] [] = {1,2,3,4};",
						"int [] myArray = (5, 4, 3);","int [] myArray = {“1”, “2”, “3”};"},
			//5
			{"What will be output of below program?\\n\r\n"
					+ "public class Test {\\n \r\n"
					+ "    public void main(String[] args) {\\n\r\n"
					+ "        int x = 10*20-20;\\n\r\n"
					+ "        System.out.println(x);}}"

					,"Runtime Error", "Prints 180", "Prints 0","Compile-time error."}
		};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					question_java frame = new question_java();
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
	public question_java() {
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
		
		JLabel lives_label = new JLabel("LIVES:");
		lives_label.setForeground(Color.WHITE);
		lives_label.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lives_label.setBounds(284, 185, 36, 14);
		contentPane.add(lives_label);
		
		JLabel score_label = new JLabel("SCORE:");
		score_label.setFont(new Font("Tahoma", Font.PLAIN, 9));
		score_label.setForeground(Color.WHITE);
		score_label.setBounds(125, 185, 46, 14);
		contentPane.add(score_label);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		buttonPanel.setBounds(59, 346, 344, 178);
		buttonPanel.setLayout(new GridLayout(4, 1, 6, 15));
		answerButtons = new RoundButton[4];
		for (int i = 0; i < 4; i++) {
            answerButtons[i] = new RoundButton();
            answerButtons[i].setBackground(new Color(0, 0, 51));
            answerButtons[i].setForeground(Color.white);
            buttonPanel.add(answerButtons[i]);
            answerButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    checkAnswer((JButton) e.getSource());
                }
            });
        }
		contentPane.add(buttonPanel);
		
		
		
		score = new JTextField();
		score.setHorizontalAlignment(SwingConstants.TRAILING);
		score.setBorder(new LineBorder(new Color(0, 0, 51)));
		score.setText("0");
		score.setEditable(false);
		score.setForeground(Color.WHITE);
		score.setOpaque(false);
		score.setBounds(169, 182, 36, 20);
		contentPane.add(score);
		score.setColumns(10);
		
		lives_text = new JTextField();
		lives_text.setText("3");
		lives_text.setEditable(false);
		lives_text.setOpaque(false);
		lives_text.setHorizontalAlignment(SwingConstants.TRAILING);
		lives_text.setForeground(Color.WHITE);
		lives_text.setColumns(10);
		lives_text.setBorder(new LineBorder(new Color(0, 0, 51)));
		lives_text.setBounds(329, 182, 36, 20);
		contentPane.add(lives_text);
		
		questionsTextArea = new JTextArea();
		questionsTextArea.setEditable(false);
		questionsTextArea.setForeground(Color.WHITE);
		questionsTextArea.setBorder(new LineBorder(new Color(0, 0, 51)));
		questionsTextArea.setOpaque(false);
		questionsTextArea.setBounds(122, 210, 243, 96);
		contentPane.add(questionsTextArea);
		
		JLabel label_1 = new JLabel();
		label_1.setIcon(new ImageIcon(question_java.class.getResource("/images/cplusbg.png")));
		label_1.setBounds(0, 0, 449, 541);
		contentPane.add(label_1);
		
		
		currentQuestion = 0;
		lives = 3;
		scores = 0;
		random_ans = new Random();
        showQuestion();
        
         
	}
	
	private void showQuestion() {
		questionsTextArea.setText(questions[currentQuestion][0]);
		String[] answers = Arrays.copyOfRange(questions[currentQuestion], 1, 5);
        shuffleAnswers(answers);
        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(answers[i]);
        }    
	}
	     
	private void shuffleAnswers(String[] answers) {
        for (int i = 0; i < answers.length; i++) {
            int j = random_ans.nextInt(answers.length);
            String temp = answers[i];
            answers[i] = answers[j];
            answers[j] = temp;
        }
    }
	private void checkAnswer(JButton button) {
        if (button.getText().equals(questions[currentQuestion][1])) {
        	playSound("correct -sound.wav");
            JOptionPane.showMessageDialog(null, "Correct!", "Answer", JOptionPane.PLAIN_MESSAGE);
            currentQuestion++;
            scores++;
            String scoresaddedString = Integer.toString(scores);
            score.setText(scoresaddedString);
            if (currentQuestion >= questions.length) {
            	Result_java showResult = new Result_java();
    			setVisible(false);
    			showResult.setVisible(true);
    			Menu.clip1.stop();
    			playSound("resultbgmusic.wav");
        } else {
        	showQuestion();
        }
    } else {
    	playSound("error-126627.wav");
        lives--;
        String livesLeft = Integer.toString(lives);
        lives_text.setText(livesLeft);  
        if (lives == 0) {
            JOptionPane.showMessageDialog(null, "You have no lives left! Game over.", "Game Over", JOptionPane.PLAIN_MESSAGE);
            Result_java showResult = new Result_java();
			setVisible(false);
			showResult.setVisible(true);
			Menu.clip1.stop();
			playSound("resultbgmusic.wav");
        } else {
            JOptionPane.showMessageDialog(null, "You have " + lives + " lives left.", "Lives Left", JOptionPane.PLAIN_MESSAGE);
         currentQuestion++;
         showQuestion();
        }
    }
  }
	public static void playSound(String fileName) {
        try {
            File soundFile = new File(fileName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
}
}
