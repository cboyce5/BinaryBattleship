package BattleshipGame;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class HumanShipSetUp extends JDialog{
	private ArrayList<Ship> ships;
	
	private JButton submitButton;
	
	public HumanShipSetUp() {
		setTitle("Set your ships");
		setSize(400, 450);
		setLayout(new GridLayout(5,1));
		setUp();
	}
	public void setUp(){
		ships = new ArrayList<Ship>();
		JPanel ship1 = new JPanel();
		JPanel ship2 = new JPanel();
		JPanel ship3 = new JPanel();
		JPanel ship4 = new JPanel();
		JLabel lr1 = new JLabel("Row (in 3-bit Binary):");
		JLabel lr2 = new JLabel("Row (in 3-bit Binary):");
		JLabel lr3 = new JLabel("Row (in 3-bit Binary):");
		JLabel lr4 = new JLabel("Row (in 3-bit Binary):");
		JTextField tfr1 = new JTextField(4);
		JTextField tfr2 = new JTextField(4);
		JTextField tfr3 = new JTextField(4);
		JTextField tfr4 = new JTextField(4);
		JLabel lc1 = new JLabel("Column (in 3-bit Binary):");
		JLabel lc2 = new JLabel("Column (in 3-bit Binary):");
		JLabel lc3 = new JLabel("Column (in 3-bit Binary):");
		JLabel lc4 = new JLabel("Column (in 3-bit Binary):");
		JTextField tfc1 = new JTextField(4);
		JTextField tfc2 = new JTextField(4);
		JTextField tfc3 = new JTextField(4);
		JTextField tfc4 = new JTextField(4);
		ship1.setBorder(new TitledBorder(new EtchedBorder(), "Ship #1 - Length 2"));
		ship2.setBorder(new TitledBorder(new EtchedBorder(), "Ship #2 - Length 3"));
		ship3.setBorder(new TitledBorder(new EtchedBorder(), "Ship #3 - Length 4"));
		ship4.setBorder(new TitledBorder(new EtchedBorder(), "Ship #4 - Length 5"));
		JLabel d1l = new JLabel("Direction:");
		JLabel d2l = new JLabel("Direction:");
		JLabel d3l = new JLabel("Direction:");
		JLabel d4l = new JLabel("Direction:");
		JComboBox<Direction> d1 = setDirectionComboBox();
		JComboBox<Direction> d2 = setDirectionComboBox();
		JComboBox<Direction> d3 = setDirectionComboBox();
		JComboBox<Direction> d4 = setDirectionComboBox();
		ship1.add(d1l);
		ship1.add(d1);
		ship1.add(lr1);
		ship1.add(tfr1);
		ship1.add(lc1);
		ship1.add(tfc1);
		
		ship2.add(d2l);
		ship2.add(d2);
		ship2.add(lr2);
		ship2.add(tfr2);
		ship2.add(lc2);
		ship2.add(tfc2);
		
		ship3.add(d3l);
		ship3.add(d3);
		ship3.add(lr3);
		ship3.add(tfr3);
		ship3.add(lc3);
		ship3.add(tfc3);
		
		ship4.add(d4l);
		ship4.add(d4);
		ship4.add(lr4);
		ship4.add(tfr4);
		ship4.add(lc4);
		ship4.add(tfc4);
		
		submitButton = new JButton("Submit your ships");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateEntries(tfr1.getText()) && validateEntries(tfr2.getText()) && validateEntries(tfr3.getText()) && validateEntries(tfr4.getText()) && validateEntries(tfc1.getText()) && validateEntries(tfc2.getText()) && validateEntries(tfc3.getText()) && validateEntries(tfc4.getText())) {
					ships.clear();
					ships.add(new Ship(BattleshipGame.convertToDecimal(tfr1.getText()),BattleshipGame.convertToDecimal(tfc1.getText()),(Direction)d1.getSelectedItem(),2));
					ships.add(new Ship(BattleshipGame.convertToDecimal(tfr2.getText()),BattleshipGame.convertToDecimal(tfc2.getText()),(Direction)d2.getSelectedItem(),3));
					ships.add(new Ship(BattleshipGame.convertToDecimal(tfr3.getText()),BattleshipGame.convertToDecimal(tfc3.getText()),(Direction)d3.getSelectedItem(),4));
					ships.add(new Ship(BattleshipGame.convertToDecimal(tfr4.getText()),BattleshipGame.convertToDecimal(tfc4.getText()),(Direction)d4.getSelectedItem(),5));
					if (checkShips()) {
						
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"One or more of your ship locations are invalid.");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Please enter a valid binary number.");
				}
			}
		});
		add(ship1);
		add(ship2);
		add(ship3);
		add(ship4);
		add(submitButton);
	}
	
	public boolean checkShips() {
		//This portion checks to make sure that both the start point and the end point are within the board
		for(Ship s : ships){
			if(!(s.getStartRow() >= 0 && s.getStartRow() < 8 && s.getStartColumn() >= 0 && s.getStartColumn() < 8)){
				return false;
			}
			Ship newShip = calcEndPoint(s);
			if(!(newShip.getStartRow() >= 0 && newShip.getStartRow() < 8 && newShip.getStartColumn() >= 0 && newShip.getStartColumn() < 8)){
				return false;
			}
		}
		//This portion checks to make sure that no two ships overlap with each other.
		ArrayList<Point> points = new ArrayList<Point>();
		for(Ship s : ships){
			if(s.getShipDirection() == Direction.UP){
				for(int i = 0; i < s.getShipLength(); i++){
					Point p = new Point(s.getStartColumn(),s.getStartRow()-i);
					if(!points.contains(p)){
					points.add(p);
					}
					else{
						return false;
					}
				}
			}
			else if(s.getShipDirection() == Direction.RIGHT){
				for(int i = 0; i < s.getShipLength(); i++){
					Point p = new Point(s.getStartColumn() + i,s.getStartRow());
					if(!points.contains(p)){
						points.add(p);
					}
					else{
						return false;
					}
				}
			}
			else if(s.getShipDirection() == Direction.DOWN){
				for(int i = 0; i < s.getShipLength(); i++){
					Point p = new Point(s.getStartColumn(),s.getStartRow()+i);
					if(!points.contains(p)){
						points.add(p);
					}
					else{
						return false;
					}
				}
			}
			else if(s.getShipDirection() == Direction.LEFT){
				for(int i = 0; i < s.getShipLength(); i++){
					Point p = new Point(s.getStartColumn()-i,s.getStartRow());
					if(!points.contains(p)){
					points.add(p);
					}
					else{
						return false;
					}
				}
			}
		}
		
		return true;
	}
	public Ship calcEndPoint(Ship s){
		
		int x = s.getStartColumn();
		int y = s.getStartRow();
		if(s.getShipDirection() == Direction.UP){
			y -= s.getShipLength();
		}
		else if(s.getShipDirection() == Direction.RIGHT){
			x += s.getShipLength();
		}
		else if(s.getShipDirection() == Direction.DOWN){
			y += s.getShipLength();
		}
		else if(s.getShipDirection() == Direction.LEFT){
			x -= s.getShipLength();
		}
		Ship newShip = new Ship(y, x, s.getShipDirection(), s.getShipLength());
		return newShip;
	}
	public JComboBox<Direction> setDirectionComboBox(){
		JComboBox<Direction> jcb = new JComboBox<Direction>();
		jcb.addItem(Direction.UP);
		jcb.addItem(Direction.DOWN);
		jcb.addItem(Direction.LEFT);
		jcb.addItem(Direction.RIGHT);
		return jcb;
	}
	public ArrayList<Ship> getShips() {
		return ships;
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
