import java.util.ArrayList;

public class Train {
	private int NB_WAGONS; 
	private ArrayList<Bandit> BANDITS;
	private ArrayList<Marshall> MARSHALLS;
	private Case[][] train;
	private ArrayList<Tuple<Action,Integer>> todo;
  
  public Train(int nb_wagons, ArrayList<Bandit> bandits, ArrayList<Marshall> marshalls) {
  }
