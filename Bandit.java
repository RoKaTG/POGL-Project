

import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;

public class Bandit extends Character{
	private String name;
	private ArrayList<Integer> pocket; 
	private ArrayList<Action> actions;
	private final int maxLoot = 4;
	private int nb_actions_max;
	private int ID;
	private Color color;
	private int nbBullets;

	

	public Bandit(String name, int ID, int nb_actions_max, Color c) {
		super(0,0);
		this.ID = ID;
		this.name = name;
		this.color = c;
		this.pocket = new ArrayList<Integer>(); 
		this.actions = new ArrayList<Action>();
		this.nb_actions_max = nb_actions_max;
		this.nbBullets = 7;
	}
	
	
	
	public ArrayList<Integer> getPocket() {
		return this.pocket;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public int getID() {
		return this.ID;
	}
	
	
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
	public boolean move(Direction d, Train t) {
		
	}
	*/
	
	
	public boolean escapeRoof(Train t) {
		if (this.getCoord()[1] - 1 >= 0) {
			this.dropLoot(t);
			this.setY(this.getCoord()[1]-1);
			System.out.println(this.name + " s'échappe sur le toit.");
			return true;
		} else {
			return false
		}
	}


	/*
	public int choosePassenger(Train t) {
	}


	

	public int takeLoot(Train t) {
	}
	
	
	
	public void holdUp(Train t) {
	}*/

	
	public int chooseRandomLoot() {
		Random R = new Random();
		int lootChosen = R.nextInt(pocket.size());
		return lootChosen;
	}
	
	/*
	public void dropLoot(Train t) {
	}
	
	
	public void shoot(Direction d, Train t) {
		
}*/

	
	public boolean addAction(Action action) {
		if (this.actions.size() < this.nb_actions_max) {
			this.actions.add(action);
			return true;
		} else {
		return false;
		}
	}
	
	public boolean removeAction(Action action) {
		if(this.actions.size()-1 >= 0) {
			this.actions.remove(action);
			return true;
		} else {
		return false;
		}
	}
}
	
