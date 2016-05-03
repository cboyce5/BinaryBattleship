package BattleshipGame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BinaryQuestionDialog extends JDialog {
	private GameBoard gb;
	private String q1 = "Convert the following binary number to its base ten decimal counterpart, 101: ";
	private String q2 = "Convert the following binary number to its base ten decimal counterpart, 1111: ";
	private String q3 = "Convert the following binary number to its base ten decimal counterpart, 10011: ";
	private String q4 = "Convert the following binary number to its base ten decimal counterpart, 111001: ";
	private int a1 = 5;
	private int a2 = 15;
	private int a3 = 19;
	private int a4 = 57;
	
	ArrayList<String> questions;
	ArrayList<Integer> answers;
	private JTextField answerText;
	
	static int questionCount = 0;


	
	public BinaryQuestionDialog(GameBoard gb){
		this.gb = gb;
		setTitle("Binary Question");
		setSize(500, 200);
		setLayout(new GridLayout(3, 1));
		questions = new ArrayList<String>();
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		answers = new ArrayList<Integer>();
		answers.add(a1);
		answers.add(a2);
		answers.add(a3);
		answers.add(a4);
		setUp();
	}
	public void setUp(){
		JPanel questionPanel = new JPanel();
		JPanel answerPanel = new JPanel();
		JLabel question = new JLabel(questions.get(questionCount));
		JLabel answer = new JLabel("Answer: ");
		answerText = new JTextField(5);
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkAnswer()){
					JOptionPane.showMessageDialog(null,"Correct.");
					gb.setCorrectAnswer(true);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect.");
					gb.board[gb.getLastRow()][gb.getLastCol()].setCellState(CellState.NONE);
					gb.repaint();
					gb.setCorrectAnswer(false);
					setVisible(false);
				}
			}
		});
		questionPanel.add(question);
		answerPanel.add(answer);
		answerPanel.add(answerText);
		add(questionPanel);
		add(answerPanel);
		add(submit);
		
	}
	public boolean checkAnswer(){
		if (answerText.getText().equals(Integer.toString(answers.get(questionCount)))) {
			questionCount++;
			return true;
		}
		else {
			return false;
		}
	}
}
