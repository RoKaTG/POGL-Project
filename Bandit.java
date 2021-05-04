package core;

import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;

public class Bandit extends Character{
	private String name;
	private ArrayList<Integer> pocket; //c'est un arraylist car c'est un tableau dynamique auquel on ajoute ou on retire des entiers
	private ArrayList<Action> actions;
	private final int maxLoot = 4;
	private int nb_actions_max;
	private int ID;
	private Color color;
	private int nbBullets;

	/**
	 * Constructor to create a new Bandit in the game, at the top left corner of the train
	 * @param name their name
	 * @param ID their ID
	 * @param nb_actions_max the maximum number of actions they can perform each round
	 */

	public Bandit(String name, int ID, int nb_actions_max, Color c) {
		super(0,0);
		this.ID = ID;
		this.name = name;
		this.color = c;
		this.pocket = new ArrayList<Integer>(); //on initialise le tableau a zero case et on l'agrandira plus tard
		this.actions = new ArrayList<Action>();
		this.nb_actions_max = nb_actions_max;
		this.nbBullets = 7;
	}
	
	/*
	 * GETTERS
	 */
	
	public ArrayList<Integer> getPocket() {
		return this.pocket;
	}
	/**
	 * Method to get the name of the Bandit
	 * @return the name of the Bandit
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Method to get the ID of the Bandit
	 * @return the ID of the Bandit
	 */
	public int getID() {
		return this.ID;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Action> getActionList(){
		return this.actions;
	}
	
	public boolean getFullAction() {
		return (this.actions.size() == this.nb_actions_max-1);
	}
	

	public int getNbBullets() {	
		return this.nbBullets;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public ArrayList<Integer> getLoot(){
		return this.pocket;
	}
	
	
	/*
	 * METHODS
	 */
	
	/**
	 * Moves the bandit of 1 Case in the direction
	 * @param d
	 * @param t
	 */
	public boolean move(Direction d, Train t) {
		switch (d) {
		case UP: 
			if (this.getCoord()[1] - 1>=0) { 
				this.setY( this.getCoord()[1]-1);
				System.out.println(this.name +" grimpe sur le toit.");
				return true;
			} else {
				System.out.println(this.name + " est déjà sur le toit.");
				return false;
			}
		case DOWN:
			if (this.getCoord()[1]+1<=1) {
				this.setY( this.getCoord()[1]+1);
				System.out.println(this.name + " descend dans le wagon.");
				return true;
			} else {
				System.out.println(this.name + " est déjà dans le wagon.");
				return false;
			}
		case LEFT:
			if (this.getCoord()[0]-1 >= 0) {
				this.setX( this.getCoord()[0]-1);
				System.out.println(this.name + " se déplace vers l'arrière du train.");
				return true;
			} else {
				System.out.println(this.name + " est déjà dans le dernier wagon.");
				return false;
			}
		case RIGHT:
			if (this.getCoord()[0]+1 < t.getNB_WAGONS()) {
				this.setX( this.getCoord()[0]+1);
				System.out.println(this.name + " se déplace vers l'avant du train.");
				return true;
			} else {
				System.out.println(this.name + " est déjà dans la locomotive.");
				return false;
			}
		}
		return false;
	}

	
	/**
	 *Moves the bandit from the wagon to the roof while dropping a loot
	 */
	
	public boolean escapeRoof(Train t) {
		if (this.getCoord()[1] - 1>=0) { 
			this.dropLoot(t);
			this.setY( this.getCoord()[1]-1);
			System.out.println(this.name + " s'échappe sur le toit.");
			return true;
		}
		return false;
	}


	/**
	 * Method which returns the index of the passenger/loot the bandit will rob
	 * @param t the train
	 * @return passengerChosen the index of the passenger/loot if the number of passengers is not 0
	 */
	public int choosePassenger(Train t) {
		Random R = new Random();
		Case[][] tab = t.getTrain();
		if(tab[this.getCoord()[0]][this.getCoord()[1]].getNB_PASSENGERS().size() > 0) {
			int passengerChosen = R.nextInt(tab[this.getCoord()[0]][this.getCoord()[1]].getNB_PASSENGERS().size());
			return passengerChosen;
		}
		return 0;
	}


	/**
	 * Method which returns the amount that the bandit will earn
	 * @param t the train
	 * @param passenger the index of the passenger we will rob
	 * @return loot the amount of money the bandit will earn
	 */
	public int takeLoot(Train t) {
		int passenger = this.choosePassenger(t);
		Case[][] tab = t.getTrain();
		int loot = tab[this.getCoord()[0]][this.getCoord()[1]].getNB_PASSENGERS().get(passenger);
		tab[this.getCoord()[0]][this.getCoord()[1]].removePassenger(passenger);
		return loot;
	}
	
	
	/**
	 * Method which will give the money to the bandit and add a case to his pocket array and remove it from the train case
	 * @param t the train
	 */
	public void holdUp(Train t) {
		if (this.pocket.size()<this.maxLoot) {
			Case[][] tab = t.getTrain();
			if(tab[this.getCoord()[0]][this.getCoord()[1]].getNB_PASSENGERS().size() > 0) {
				//il faut verifier si la case sur laquelle se trouve le bandit contient du butin
				int passenger = this.choosePassenger(t);
				int loot = this.takeLoot(t);
				this.pocket.add(passenger);
				System.out.println(this.name + " braque un passager et recupere " + Integer.toString(loot));
			}
		}
	}

	/**
	 * Method which randomly chooses a loot index from the bandit's pocket
	 * @return the loot index randomly chosen
	 */
	public int chooseRandomLoot() {
		Random R = new Random();
		int lootChosen = R.nextInt(pocket.size());
		return lootChosen;
	}
	
	/**
	 * Method which removes the loot from the bandit's pocket and leaves it on the case where the bandit dropped it
	 * @param t the Train on which the action happens
	 */
	public void dropLoot(Train t) {
		if(this.getPocket().size() != 0) {
			int lootChosen = this.chooseRandomLoot();
			Case[][] tab = t.getTrain();
			tab[this.getCoord()[0]][this.getCoord()[1]].addLoot(lootChosen);//on ajoute le loot a celui de la case sur laquelle le bandit est
			this.pocket.remove(lootChosen);//on retire de la pocket l'element qui correspond a l'entier passe en param
		}
		
	}
	
	/**
	 * Method which simulates the action of shooting, made by a bandit
	 * @param t the Train where the bandits are
	 * @param d the direction in which the bandit shoots
	 */
	public void shoot(Direction d, Train t) {
		Case[][] tab = t.getTrain();
		int[] caseShot = new int[2];;
		int[] Bcoord = this.getCoord();
		switch(d) {
		case UP:
			if(this.getCoord()[1] != 0) {
				caseShot[0] = Bcoord[0];
				caseShot[1]= Bcoord[1]-1;
			}else {
				caseShot[0] = Bcoord[0];
				caseShot[1] = Bcoord[1];
			}
		case DOWN:
			if(this.getCoord()[1] != 1) {
				caseShot[0] = Bcoord[0];
				caseShot[1] = Bcoord[1]+1;
			}else {
				caseShot[0] = Bcoord[0];
				caseShot[1] = Bcoord[1];
			}
		case LEFT:
			if(this.getCoord()[0] - 1 >= 0) {
				caseShot[0] = Bcoord[0] - 1;
				caseShot[1] = Bcoord[1];
			}else {
				caseShot[0] = Bcoord[0];
				caseShot[1] = Bcoord[1];
			}
		case RIGHT:
			if(this.getCoord()[0] + 1 < t.getNB_WAGONS()) {
				caseShot[0] = Bcoord[0] + 1;
				caseShot[1] = Bcoord[1];
			}else {
				caseShot[0] = Bcoord[0];
				caseShot[1] = Bcoord[1];
			}
		}
		if(tab[caseShot[0]][caseShot[1]].getBandits().size() != 0) {
			
			Bandit banditShot = tab[caseShot[0]][caseShot[1]].chooseRandomBandit();
			
			if(tab[caseShot[0]][caseShot[1]] == tab[this.getCoord()[0]][this.getCoord()[1]]) {
				
				banditShot = tab[caseShot[0]][caseShot[1]].chooseRandomBandit();
				
				while(banditShot == this) {
					
					banditShot = tab[caseShot[0]][caseShot[1]].chooseRandomBandit();
				}
			}
			
			banditShot.dropLoot(t);
			
			if(tab[caseShot[0]][caseShot[1]] == tab[this.getCoord()[0]][this.getCoord()[1]]) {
				System.out.println(this.name + " tire sur sa propore position et touche " + banditShot.name);
			}else {
				System.out.println(this.name + " tire sur la position " + caseShot + " et touche " + banditShot.name);
	
			}
		}else {
		
			System.out.println(this.name + " tire ... MAIS IL RATE!");
		}
		this.nbBullets -= 1;//le bandit a tire, on lui retire une balle
		
}

	
	public boolean addAction(Action action) {
		if (this.actions.size() < this.nb_actions_max) {
			this.actions.add(action);
			return true;
		}
		return false;
	}
	
	public boolean removeAction(Action action) {
		if(this.actions.size()-1 >= 0) {
			this.actions.remove(action);
			return true;
		}
		return false;
	}
}
