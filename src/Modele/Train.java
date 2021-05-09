package Modele;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Train {
    public static int NB_WAGON;
    public static int NB_BANDIT = 1;
    public static final int NB_ACTION = 4;
    public static int NB_MANCHE;
    public static Marshall marshall;
    private static String N;
    public static ArrayList<Butin> wagonList = new ArrayList<Butin>();
    public static ArrayList<Bandit> banditList = new ArrayList<Bandit>();

    public Train(int nWagon) {
        Train.NB_WAGON = nWagon;
        Train.NB_MANCHE = 1;
        Train.marshall = new Marshall(0.3);
    }

    private String newsInitialise() {
        return	"Les action s'affichent après l'utilisation de tout ces points d'action dans une fênetre. ";

    }


    public void trainInitialise() {

        Train.N = newsInitialise();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre de Wagons souhaités ? : ");
        Train.NB_WAGON = scanner.nextInt();
        while(Train.NB_WAGON > 6) {
            System.out.println("Le nombre de wagon maximum autorisé est depassé :");
            Train.NB_WAGON = scanner.nextInt();
        }

        System.out.println("\n\nNombre de Bandits :");
        Train.NB_BANDIT = scanner.nextInt();
        while(Train.NB_BANDIT < 1 || Train.NB_BANDIT > 4) {
            System.out.println("Le jeu est un jeu se jouant à 4 désolé :");
            Train.NB_BANDIT = scanner.nextInt();
        }

        for (int i = 0; i < Train.NB_WAGON-1; i++) {
            Butin temp = new Butin(i);
            temp.wagonInitialise();
            Train.wagonList.add(temp);
        }
        Butin locomotive = new Butin(Train.NB_WAGON-1);
        locomotive.addMagot();
        Train.wagonList.add(locomotive);

        if(Train.NB_WAGON != wagonList.size() )
            System.out.println("Error");

        for (int i = 0; i < Train.NB_BANDIT; i++) {
            System.out.println("\nNom du bandit " + (i + 1) + " ? :");
            String nom = scanner.next();
            Bandit b_temp = new Bandit(nom);
            banditList.add( b_temp );
        }

        scanner.close();
    }

    public static void infoJeu(String info) {

    }
}