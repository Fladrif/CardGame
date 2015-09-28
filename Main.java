import javax.swing.*;

public class Main {
	
	public static void main(String[] args){
		if(args[0].equals("cli")){
			CommandUi run = new CommandUi();
		} else if (args[0].equals("gui")){
			new SwingUi();
		}
	}

}
