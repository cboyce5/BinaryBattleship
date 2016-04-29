package BattleshipGame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BinaryQuestionDialog extends JDialog {
	private GameBoard gb;
	private String q1 = "Convert the following binary number to its base ten decimal counterpart, 101: ";
	private String q2 = "Convert the following binary number to its base ten decimal counterpart, 1111: ";
	private String q3 = "Convert the following binary number to its base ten decimal counterpart, 10011: ";
	private String q4 = "Convert the following binary number to its base ten decimal counterpart, 111001: ";
	private int a1 = 3;
	private int a2 = 15;
	private int a3 = 19;
	private int a4 = 57;
	
	private JTextField answerText;
	
	static int questionCount = 0;


	public BinaryQuestionDialog(GameBoard gb){
		this.gb = gb;
		setTitle("Binary Question");
		setSize(400, 400);
		setLayout(new GridLayout(3, 1));
		setUp();
	}
	public void setUp(){
		JPanel questionPanel = new JPanel();
		JPanel answerPanel = new JPanel();
		JLabel question = new JLabel();
		JLabel answer = new JLabel();
		answerText = new JTextField(5);
		JButton submit = new JButton();
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkAnswer()){
					JOptionPane.showMessageDialog(null,"Correct.");
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect.");
					gb.board[gb.lastRow][gb.lastCol].setCellState(CellState.NONE);
					setVisible(false);
				}
			}
		});
	}
	public boolean checkAnswer(){
		switch(questionCount) {
		case 0:
			if (answerText.getText().equals(Integer.toString(a1))) {
				questionCount++;
				return true;
			}
			else {
				return false;
			}
		case 1:
			if (answerText.getText().equals(Integer.toString(a2))) {
				questionCount++;
				return true;
			}
			else {
				return false;
			}
		case 2:
			if (answerText.getText().equals(Integer.toString(a3))) {
				questionCount++;
				return true;
			}
			else {
				return false;
			}
		case 3:
			if (answerText.getText().equals(Integer.toString(a4))) {
				questionCount++;
				return true;
			}
			else {
				return false;
			}
		default:
				return false;
		}
	}
}
