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
	GameEngine game;
	int wage = 5;
	CardImages image;
	public SwingUi(){
		game = new GameEngine();
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
		pot = new JLabel(Integer.toString(game.getPot()));
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
		while(true){
			game.startGame();
			pHand = new JLabel[game.getPlayerHand().length];
			dHand = new JLabel[game.getDealerHand().length];
			for(int i = 0; i < game.getPlayerHand().length; i++){
				pHand[i] = new JLabel(image.getIconVar(game.getPlayerHand()[i].print()));
				dHand[i] = new JLabel(image.getIconVar(game.getDealerHand()[i].print()));
			}
			
		}
	}
}
