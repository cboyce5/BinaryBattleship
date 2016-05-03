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

public class CoordinateDialog extends JDialog{
	private GameBoard board;
	
	public CoordinateDialog(GameBoard b) {
		this.board = b;
		setTitle("Enter your guess: (for the Computer Board)");
		setSize(300,300);
		setLayout(new GridLayout(3,1));
		setUp();
	}
	public void setUp() {
		JPanel rowPanel = new JPanel();
		JPanel colPanel = new JPanel();
		JLabel l1 = new JLabel("Enter the row (In 3 bit binary): ");
		JLabel l2 = new JLabel("Enter the column (In 3 bit binary): ");
		JTextField tf1 = new JTextField(4);
		JTextField tf2 = new JTextField(4);
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateEntries(tf1.getText()) && validateEntries(tf2.getText())) {
					int row = BattleshipGame.convertToDecimal(tf1.getText());
					int col = BattleshipGame.convertToDecimal(tf2.getText());
					if(board.handleMove(row, col)){
						
						//close window.
						setVisible(false);
					}
					else{
						JOptionPane.showMessageDialog(null,"The cell you selected has already been guessed.");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Your row and or column entry was invalid");
				}
			}
		});
		rowPanel.add(l1);
		rowPanel.add(tf1);
		colPanel.add(l2);
		colPanel.add(tf2);
		add(rowPanel);
		add(colPanel);
		add(submit);
	}
	public boolean validateEntries(String entry){
		if(entry.length() != 3){
			return false;
		}
		for(int i = 0; i < entry.length(); i++){
			if(entry.charAt(i) != '1' && entry.charAt(i) != '0'){
				return false;
			}
		}
		return true;
	}
	
}
