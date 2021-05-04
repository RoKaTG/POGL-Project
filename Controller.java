package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import core.*;

public class Controller implements ActionListener{
	
	private Train train;
	private ArrayList<Bandit> bandits;
	
	public Controller(Train train, ArrayList<Bandit> bandits) {
		this.train = train;
		this.bandits = bandits;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int IDcurrentBandit = -1;
		for (int i = 0; i<this.bandits.size(); i++) {
			if(!this.bandits.get(i).getFullAction()) {
				IDcurrentBandit = i;
				break;
			}
		}
		if (IDcurrentBandit != -1) {
			if ("UP".equals(e.getActionCommand())){
				System.out.println("UP");
				this.bandits.get(IDcurrentBandit).addAction(Action.MOVEUP);
			} else if ("DOWN".equals(e.getActionCommand())){
				System.out.println("DOWN");
				this.bandits.get(IDcurrentBandit).addAction(Action.MOVEDOWN);
			} else if ("LEFT".equals(e.getActionCommand())){
				System.out.println("LEFT");
				this.bandits.get(IDcurrentBandit).addAction(Action.MOVELEFT);
			} else if ("RIGHT".equals(e.getActionCommand())){
				System.out.println("RIGHT");
				this.bandits.get(IDcurrentBandit).addAction(Action.MOVERIGHT);
			} else if ("SHOOT UP".equals(e.getActionCommand())){
				System.out.println("SHOOT UP");
				this.bandits.get(IDcurrentBandit).addAction(Action.SHOOTUP);
			} else if ("SHOOT DOWN".equals(e.getActionCommand())){
				System.out.println("SHOOT DOWN");
				this.bandits.get(IDcurrentBandit).addAction(Action.SHOOTDOWN);
			} else if ("SHOOT LEFT".equals(e.getActionCommand())){
				System.out.println("SHOOT LEFT");
				this.bandits.get(IDcurrentBandit).addAction(Action.SHOOTLEFT);
			} else if ("SHOOT RIGHT".equals(e.getActionCommand())){
				System.out.println("SHOOT RIGHT");
				this.bandits.get(IDcurrentBandit).addAction(Action.SHOOTRIGHT);
			} else if ("ROB".equals(e.getActionCommand())){
				System.out.println("ROB");
				this.bandits.get(IDcurrentBandit).addAction(Action.ROB);
			} 
			else if("DELETE".equals(e.getActionCommand())) {
				System.out.println("Annulation de la planification de l'action");
				Bandit b = this.bandits.get(IDcurrentBandit);
				ArrayList<Action> actions = b.getActionList();
				actions.remove(this.bandits.get(IDcurrentBandit).getActionList().size()-1);
			}
		} else if ("ACTION".equals(e.getActionCommand())){
			System.out.println("ACTION");
			this.train.nextAction();
		}
	}
}
