package BattleshipGame;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class HumanShipSetUp extends JDialog{
	
	public HumanShipSetUp() {
		setTitle("Set your ships");
		setSize(400, 400);
		setLayout(new GridLayout(4,1));
		setUp();
	}
	public void setUp(){
		JPanel ship1 = new JPanel();
		JPanel ship2 = new JPanel();
		JPanel ship3 = new JPanel();
		JPanel ship4 = new JPanel();
		JLabel lr1 = new JLabel("Row (in 4-bit Binary):");
		JLabel lr2 = new JLabel("Row (in 4-bit Binary):");
		JLabel lr3 = new JLabel("Row (in 4-bit Binary):");
		JLabel lr4 = new JLabel("Row (in 4-bit Binary):");
		JTextField tfr1 = new JTextField(4);
		JTextField tfr2 = new JTextField(4);
		JTextField tfr3 = new JTextField(4);
		JTextField tfr4 = new JTextField(4);
		JLabel lc1 = new JLabel("Column (in 4-bit Binary):");
		JLabel lc2 = new JLabel("Column (in 4-bit Binary):");
		JLabel lc3 = new JLabel("Column (in 4-bit Binary):");
		JLabel lc4 = new JLabel("Column (in 4-bit Binary):");
		JTextField tfc1 = new JTextField(4);
		JTextField tfc2 = new JTextField(4);
		JTextField tfc3 = new JTextField(4);
		JTextField tfc4 = new JTextField(4);
		ship1.setBorder(new TitledBorder(new EtchedBorder(), "Ship #1"));
		ship2.setBorder(new TitledBorder(new EtchedBorder(), "Ship #2"));
		ship3.setBorder(new TitledBorder(new EtchedBorder(), "Ship #3"));
		ship4.setBorder(new TitledBorder(new EtchedBorder(), "Ship #4"));
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
		
		add(ship1);
		add(ship2);
		add(ship3);
		add(ship4);
	}
	public JComboBox<Direction> setDirectionComboBox(){
		JComboBox<Direction> jcb = new JComboBox<Direction>();
		jcb.addItem(Direction.UP);
		jcb.addItem(Direction.DOWN);
		jcb.addItem(Direction.LEFT);
		jcb.addItem(Direction.RIGHT);
		return jcb;
	}
}
