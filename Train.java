import java.util.ArrayList;

public class Train {
	private int NB_WAGONS; 
	private ArrayList<Bandit> BANDITS;
	private ArrayList<Marshall> MARSHALLS;
	private Case[][] train;
	private ArrayList<Tuple<Action,Integer>> todo;
  
  public Train(int nb_wagons, ArrayList<Bandit> bandits, ArrayList<Marshall> marshalls) {
	  this.NB_WAGONS = nb_wagons;
	  this.BANDITS = bandits;
	  this.MARSHALLS = marshalls;
	  /* ?????*/
	 	 
  }
	
	
  public int getNB_WAGONS() {
	  return this.NB_WAGONS;
  }
	
	
  public int getNB_BANDITS() {
	  return this.BANDITS.size();
  }
	
	
  public int getNB_MARSHALLS() {
	  return this.MARSHALLS.size();
  }
