package quizgame;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
import javax.sound.sampled.*;
import java.io.File;

public class question_c_plus extends JFrame{
	private JPanel contentPane;
	private JButton[] answerButtons;
    private int currentQuestion;
    private JTextField score;
    private JTextField lives_text;
    private JTextArea questionsTextArea;
    public static int lives, scores;
    private Random random_ans;
	
	String[][] questions = 	{
			{"\nWhat is a correct syntax to output \n\"Hello World\" in C++?",  "cout << “Hello World”;",
			"System.out.println(“Hello World”);", "Console.WriteLine(Hello World);", "print(“Hello World”);"},
			{"\nHow do you create a variable with\n the numeric value 5?", "int x = 5;", "x = 5;", "double x = 5;", "num x = 5"},
			{"\nYou can concatenate the strings \nwith which function?","append()","auto_ptr()","appends()","assign()"},
			{"Assuming outFile is a file stream object\n"
					+ "and number is a variable, which statement \n"
					+ "writes the contents of number to the file "
					+ "\nassociated with outFile?", "outFile << number;","write(outFile, number);",
					"outFile >> number;","number >> outFile;"},
			{"\nWhich of the following is \na valid C++ array definition?","int array[10];",
					"int array[0]","float $payments[10];","void numbers[5];"},
			{"\nWhich statement correctly uses C++ 11\nto initialize a vector of\n"
					+ "ints named n with the values 10 and 20?","vector<int> n { 10, 20 };",
						"vector n<int>(10, 20);","vector<int> n = {10, 20};","int vector n ({10}, {20});"},
			{"What will the following code do?\nconst int SIZE = 5;\ndouble x[SIZE];\n"
					+ "for(int i = 2; i <= SIZE; i++){\nx[i] = 0.0;}",
					"An error will occur when the code runs", "Each element in the array is initialized\n to 0.0",
					"except the first, is initialized to 0.0", "except the first and the last, is initialized\n to 0.0"},
			{"\nWhat will the following code display?\nint number = 6;\nnumber++;\n"
					+ "cout << number << endl;","7","5","6","0"},
			{"What will the following loop display?\nint x = 0;\nwhile (x < 5){\ncout << x << endl;\nx++;}",
					"01234","012345","01 2 3 4","The loop will display numbers starting at 0, for infinity."},
			{"What is the output of the following code \nsegment?\nn = 1;\nwhile (n <= 5)\ncout << n << ' ';\n"
					+ "n++;", "1 1 1... and on forever", "1 2 3 4 5", "2 3 4 5 6", "1 2 3 4"},
			{"What is the output of the following program?\n#include<iostream>\nusing namespace std;\nmain() {"
					+ "char s[] = \"Fine\";\n*s = 'N';\ncout<<s<<endl;}", "Nine", "Fine", "Compile error", "Runtime error"},
			{"Which of the following in Object \nOriented Programming is"
					+ "supported by\n Function overloading and default\n"
					+ "arguments features of C++.", "Polymorphism", "Inheritance", "Encapsulation", "None of the above"},
			{"#include<iostream>\nusing namespace std;\nint fun(int x = 0, int y = 0, int z)\n{  return (x + y + z); }"
					+ "\nint main(){\ncout << fun(10);return 0;}", "Compile error", "10", "0", "20"},
			{"A member function can always access\nthe data in __________ , (in C++).",
						"the class of which it is member", "the object of which it is a member", "the public part of its class",
						"the private part of its class"},
			{"What is the return value of f(p, p)\n if the value of p is initialized\n to 5 before the call?\n"
					+ "int f(int &x, int c) {c  = c - 1;\nif (c == 0) return 1; "
					+ "x = x + 1;\nreturn f(x, c) * x;}","6561", "3024", "55440","161051"}
		};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					question_c_plus frame = new question_c_plus();
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
	public question_c_plus() {
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
		label_1.setIcon(new ImageIcon(question_c_plus.class.getResource("/images/cplusbg.png")));
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
	public void checkAnswer(JButton button) {
        if (button.getText().equals(questions[currentQuestion][1])) {
            playSound("correct -sound.wav");
            JOptionPane.showMessageDialog(null, "Correct!", "Answer", JOptionPane.PLAIN_MESSAGE);
            currentQuestion++;
            scores++;
            String scoresaddedString = Integer.toString(scores);
            score.setText(scoresaddedString);
            if (currentQuestion >= questions.length) {
            	Results showResult = new Results();
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
            Results showResult = new Results();
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
