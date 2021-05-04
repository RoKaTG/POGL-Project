
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
	
public static void main(String[] args) {
		EventQueue.invokeLater(() ->  {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Nombre de Joueurs :");
			int nb_bandits = Integer.parseInt(userInput.nextLine());
			System.out.println("Nombre de Wagon : ");
			int nb_wagons = Integer.parseInt(userInput.nextLine());
			int nb_actions = 5;
			
			
			Marshall MARSHALL = new Marshall(nb_wagons, 1, "Marshall Marshall", 0.3, 0);
			ArrayList<Marshall> marshalls = new ArrayList<Marshall>();
			marshalls.add(0, MARSHALL);
			ArrayList<Bandit> bandits = new ArrayList<Bandit>();
			Color[] temp = new Color[] {Color.RED, Color.BLUE, Color.BLACK, Color.GREEN};
			for (int i = 0; i<nb_bandits; i++) {
				System.out.println("Joueur "+ Integer.toString(i+1) + " entrez votre nom :");
				String name = userInput.nextLine();
				Bandit PLAYER = new Bandit(name, i, nb_actions, temp[i]);
				bandits.add(i,PLAYER);
			}
	
			
				Train game = new Train(nb_wagons, bandits, marshalls);
				@SuppressWarnings("unused")
				Window test = new Window(game, bandits);
				userInput.close();
		});

		
	}

}

