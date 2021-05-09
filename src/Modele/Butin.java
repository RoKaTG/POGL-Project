package Modele;

import java.util.HashMap;
import java.util.Random;

public class Butin {
    public int nbWagon;
    private HashMap<String, Integer> stuff;


    public Butin(int nbW) {
        this.nbWagon = nbW;
        this.stuff = new HashMap<String, Integer>();
        this.stuff.put("Bourse", 0);
        this.stuff.put("Bijoux", 0);
        this.stuff.put("Magot", 0);
    }

    public int getBourse() {
        return stuff.get("Bourse");
    }

    public int getBijoux() {
        return stuff.get("Bijoux");
    }

    public int getMagot() {
        return stuff.get("Magot");
    }

    public int getnStuff() {
        return this.getBourse() + this.getBijoux() + this.getMagot();
    }

    public void wagonReset() {
        this.stuff.put("Bourse", 0);
        this.stuff.put("Bijoux", 0);
        this.stuff.put("Magot", 0);
    }

    public void addBourse(int val) {
        this.stuff.put("Bourse", this.stuff.get("Bourse") + val);
    }

    public void addBijoux(int val) {
        this.stuff.put("Bijoux", this.stuff.get("Bijoux") + val);
    }

    public void addMagot() {
        if (this.stuff.get("Magot") == 0)
            this.stuff.put("Magot", 1);
    }

    public void wagonCrea() {
        this.wagonReset();
        int NB_BUTIN = new Random().nextInt(4);
        int NB_BOURSE = 0;
        for (int i = 0; i < NB_BUTIN; i++)
            NB_BOURSE = new Random().nextInt(NB_BUTIN + 1);
        this.addBourse (NB_BOURSE);
        this.addBijoux (NB_BUTIN - NB_BOURSE);
    }

    public boolean removeBourse() {
        if (this.stuff.get("Bourse") < 1)
            return false;
        else
            this.stuff.put("Bourse", this.stuff.get("Bourse") - 1);
        return true;
    }

    public boolean removeBijoux() {
        if (this.stuff.get("Boijoux") < 1)
            return false;
        else
            this.stuff.put("Bijoux", this.stuff.get("Bijoux") - 1);
        return true;
    }
}
