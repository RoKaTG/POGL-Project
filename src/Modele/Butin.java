package Modele;

import java.util.HashMap;
import java.util.Random;

public class Wagon {

    
    public int nbWagon;
    private HashMap<String,Integer> items;


    
    public Wagon(int nbW) {
        this.nbWagon = nbW;
        this.items = new HashMap<String,Integer>();
        this.items.put("Bourse",0);
        this.items.put("Bijoux",0);
        this.items.put("Magot",0);
    }
