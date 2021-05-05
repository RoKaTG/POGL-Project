import java.util.Random;

public class Marshall {       //J'ai besoin d'une nouvelle classe pour les cara des persnnages svp.

  private String name;
	private final double Nervo_Marshall;
	private Random rand;
	private int ID;
}

public Marshall(int x, int y, String name, double nervosite,int ID) {
	super(x,y);
	this.name = name;
	this.Nervo_Marshall = nervosite;
	this.ID = ID;
	this.rand = new Random();
}


/*/Besoin de methods de deplacement ?/*/
