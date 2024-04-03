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

public class question_python extends JFrame{
	private JPanel contentPane;
	private JButton[] answerButtons;
    private int currentQuestion;
    private JTextField score;
    private JTextField lives_text;
    private JTextArea questionsTextArea;
    public static int lives, scores;
    private Random random_ans;
	
	String[][] questions = 	{
			{"i = 1\r\n _______ i < 4;\r\ni + = 1\r\n\r\nprint(i)",  "while", "print", "for", "include"},
			{"def greet(name):\r\n    return \"Hello, _______!\"\r\n\r\nprint(greet(\"Alice\"))\r\nprint(greet(\"Bob\"))\r\n", "name", "greet","\"name\"", "'name'"},
			{"\nnumbers = [1, 2, 3, 4, 5]\r\n\r\nfor _______ in numbers:\r\n    print(number)\r\n\r\n\r\n","element", "number", "value", "i"},
			{"How do you access the first\n element of a tuple in Python?\n", "tuple[0]", "tuple[1]", "tuple(1)", "tuple.first()"},
			{"How do you remove the last\n element from a list in Python\n and return it?\r", "list.pop()", "list.remove()", "list.delete()", "list.extract()"},
			{"x = 5\r\ny = 10\r\n\r\nif x _______ y:\r\n    print(\"x is smaller than y\")\r\nelse:\r\n    print(\"x is greater than or equal to y\")\r\n", "<", ">", "=>", "=<"},
			{"def add(a, b):\r\n    return a _______ b\r\n\r\nresult = add(5, 10)\r\nprint(result)\r\n", "+", "-", "*", "/"},
			{"names = [\"Alice\", \"Bob\", \"Charlie\"]\r\n\r\nif \"Alice\" _______ names:\r\n    print(\"Alice is in the list\")\r\nelse:\r\n    print(\"Alice is not in the list\")\r\n", "in", "within", "of", "contains"},
			{"word1 = \"Hello\"\r\nword2 = \"World\"\r\n\r\nsentence = word1 + \" \" + word2\r\nprint(sentence)\r\n", "Hello World","HelloWorld", "\"Hello\" \"World\"", "'Hello' 'World'"},
			{"numbers = [1, 2, 3, 4, 5]\r\ntotal = _______\r\n\r\nfor number in numbers:\r\n    total _______ number\r\n\r\nprint(total)\r\n", "0, +=", "0, +", "0, =+", "0, ="},
			{"How do you create a dictionary in Python?\\r\\n", "{key1: value1, key2: value2}", "dict(key1=value1, key2=value2)", "(key1=value1, key2=value2)", "[key1: value1, key2: value2]"},
			{"numbers = [1, 2, 3, 4, 5]\r\n\r\nprint(numbers[1:3])\r\nprint(numbers[:2])\r\nprint(numbers[3:])\r\n", "[2, 3], [1, 2], [4, 5]", "[2, 3], [1, 2], [4, 5]", "[2, 3], [1, 2], [4, 5]", "2, 1, 4"},
			{"word = \"Hello\"\r\n\r\nprint(word[0])\r\nprint(word[2])\r\nprint(word[4])\r\n", "H, l, o", "0, 2, 4", "e, l, o", "1, 3, 5"},
			{"How do you remove a key-value\n pair from a dictionary in Python?\r\n", "del dictionary[key]","dictionary.remove(key)", "dictionary.pop(key)", "dictionary.delete(key)"},
			{"How do you iterate over the\n key-value pairs in a dictionary\n in Python using a for loop?\r\n", "for key, value in dictionary:", "for (key, value) in dictionary:", "for each key, value in dictionary:", "for each (key, value) in dictionary:"}
			
			
			
		};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					question_python frame = new question_python();
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
	public question_python() {
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
		questionsTextArea.setBounds(135, 210, 185, 96);
		contentPane.add(questionsTextArea);
		
		JLabel label_1 = new JLabel();
		label_1.setIcon(new ImageIcon(question_python.class.getResource("/images/cplusbg.png")));
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
            	Result_python showResult = new Result_python();
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
            Result_python showResult = new Result_python();
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
