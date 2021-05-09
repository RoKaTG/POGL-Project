package Modele;

import java.util.ArrayList;


public class Train {
    public static int NB_WAGON;
    public static int NB_BANDIT = 1;
    public static final int NB_ACTION = 4;
    public static int NB_MANCHE;
    public static Marshall marshall;
    private String N;
    static ArrayList<Butin> wagonList = new ArrayList<Butin>();
    ArrayList<Bandit> banditList = new ArrayList<Bandit>();

    public Train(int nWagon) {
        Train.NB_WAGON = nWagon;
        Train.NB_MANCHE = 1;
        Train.marshall = new Marshall(0.3);
    }

    public static void infoJeu(String info) {

    }
}
