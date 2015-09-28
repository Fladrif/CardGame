import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class SwingUi implements Ui{
	JFrame frame;
	JButton hit, stay, deal;
	JPanel dealPane, handPane, butPane;
	JSpinner wageSpinner;
	SpinnerNumberModel wageModel;
	JLabel messageLab, potLab;
	JLabel pHand, dHand;
	volatile int wage = 5;
	CardImages image;
	ImageIcon dealHand, playHand;
	volatile String resp;
	volatile boolean wageFlag;

	public SwingUi(){
		image = new CardImages();
		resp = null;
		wageFlag = false;

		//initialize frame
		frame = new JFrame("BlackJack");
		frame.setSize(700,500);
		frame.setLayout(new GridLayout(4,0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		messageLab = new JLabel("Welcome to BlackJack!");

		//make hit button and add functionality
		hit = new JButton("Hit");
		hit.setEnabled(false);
		hit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				hit.setEnabled(false);
				stay.setEnabled(false);
				resp = "hit";
			}
		});

		//make stay button and add functionality
		stay = new JButton("Stay");
		stay.setEnabled(false);
		stay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				stay.setEnabled(false);
				hit.setEnabled(false);
				resp = "stay";
			}
		});

		//make wager prompt for bet
		wageModel = new SpinnerNumberModel(5,1,25,1);
		wageSpinner = new JSpinner(wageModel); 
		wageSpinner.setEnabled(false);

		//make deal button and functionality
		deal = new JButton("Deal");
		deal.setEnabled(false);
		deal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				wage = (int)wageSpinner.getValue();
				wageSpinner.setEnabled(false);
				deal.setEnabled(false);
				wageFlag = true;
			}
		});
		potLab = new JLabel("Wallet: 0");

		//Make and populate bottom pane
		butPane = new JPanel(new GridLayout(0,5,50,50));
		butPane.add(hit);
		butPane.add(stay);
		butPane.add(wageSpinner);
		butPane.add(deal);
		butPane.add(potLab);

		//make dealer's hand pane
		dealPane = new JPanel();
		dealPane.setLayout(new FlowLayout());
		dealPane.add(dHand = new JLabel(image.getIconVar("d4")));

		//make player's hand pane
		handPane = new JPanel();
		handPane.setLayout(new FlowLayout());
		handPane.add(pHand = new JLabel(image.getIconVar("s8")));

		//Populate main frame with panes
		frame.add(dealPane);
		//frame.add(new JSeparator(JSeparator.HORIZONTAL));
		frame.add(handPane);
		//frame.add(new JSeparator(JSeparator.HORIZONTAL));
		frame.add(messageLab);
		frame.add(butPane);
		frame.setVisible(true);
		frame.revalidate();
		frame.repaint();
		GameLogic logic = new GameLogic(this);
	}
	public void setMessage(String message){
		messageLab.setText(message);
		frame.validate();
		frame.repaint();
	}
	public String getResponse(){
		stay.setEnabled(true);
		hit.setEnabled(true);
		while(true){
			if(resp != null) break;
		}
		String temp = resp;
		resp = null;
		return temp;
	}
	public void displayHand(String name, Card[] hand, int value){
		if(name.equals("Player")){
			handPane.removeAll();
			for(Card card : hand){
		    	handPane.add(pHand = new JLabel(image.getIconVar(card.print())));
			}
		}
		if(name.equals("Dealer")){
			dealPane.removeAll();
			for(Card card : hand){
		    	dealPane.add(dHand = new JLabel(image.getIconVar(card.print())));
			}
		}
		frame.validate();
		frame.repaint();
	}
	public int getWager(){
		deal.setEnabled(true);
		wageSpinner.setEnabled(true);
		frame.validate();
		frame.repaint();
		while(true){
			if(wageFlag) break;
		}
		wageFlag = false;
		return wage;
	}
	public void displayPot(int pot){
		potLab.setText("Wallet: " + String.valueOf(pot));
		frame.validate();
		frame.repaint();
	}
}
