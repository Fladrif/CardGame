import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class SwingUi{
	JFrame frame;
	JButton hit, stay, deal;
	JPanel dealPane, handPane, butPane;
	JSpinner wageSpinner;
	SpinnerNumberModel wageModel;
	JLabel messageLab, pot;
	JLabel[] pHand, dHand;
	int wage = 5;
	CardImages image;
	public SwingUi(){
		image = new CardImages();
		frame = new JFrame("BlackJack");
		frame.setSize(700,500);
		frame.setLayout(new GridLayout(4,0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		messageLab = new JLabel("Welcome to BlackJack!");
		hit = new JButton("Hit");
		hit.setEnabled(false);
		hit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				SwingUtilities.invokeLater(new Runnable(){
					public void run(){
						frame.validate();
						frame.repaint();
					}
				});
				hit.setEnabled(false);
			}
		});
		stay = new JButton("Stay");
		stay.setEnabled(false);
		stay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				stay.setEnabled(false);
			}
		});
		wageModel = new SpinnerNumberModel(5,1,25,1);
		wageSpinner = new JSpinner(wageModel); 
		wageSpinner.setEnabled(false);
		wageSpinner.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				wage = (int)wageSpinner.getValue();
			}
		});
		pot = new JLabel("0");
		butPane = new JPanel(new GridLayout(0,4,50,50));
		butPane.add(hit);
		butPane.add(stay);
		butPane.add(wageSpinner);
		butPane.add(pot);
		dealPane = new JPanel();
		dealPane.setLayout(new FlowLayout());
		handPane = new JPanel();
		handPane.setLayout(new FlowLayout());
		frame.add(dealPane);
		frame.add(handPane);
		frame.add(messageLab);
		frame.add(butPane);
	}
	public void setMessage(String message){
	}
	public String getResponse(){
		String resp = null;
		return resp;
	}
	public void displayHand(String name, Card[] hand, int value){
	}
	public int getWager(){
		int wager = 0;

		return wager;
	}
	public void displayPot(int pot){
		frame.validate();
		frame.repaint();
	}
}
