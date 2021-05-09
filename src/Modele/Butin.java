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

    public void wagonInitialise() {
        this.wagonReset();
        int NB_BUTIN = new Random().nextInt(5);
        int NB_BOURSE = 0;
        for (int i = 0; i < NB_BUTIN ; i++)
            NB_BOURSE = new Random().nextInt(NB_BUTIN + 1);
        this.addBourse(NB_BOURSE);
        this.addBijoux(NB_BUTIN - NB_BOURSE);
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
        if (this.stuff.get("Bijoux") < 1)
            return false;
        else
            this.stuff.put("Bijoux", this.stuff.get("Bijoux") - 1);
        return true;
    }
    public boolean removeMagot() {
        if (this.stuff.get("Magot") == 1) {
            this.stuff.put("Magot", 0);
            return true;
        }
        return false;
    }

    public int etatStuff() {
        int bijoux = getBijoux();
        int bourse = getBourse();
        int magot = getMagot();

        if (getnStuff() == 0)
            return 0;
        if (bijoux + bourse == 0 || bijoux + magot == 0 || bourse + magot == 0)
            return 1;
        if (bijoux == 0 && bourse != 0 && magot != 0)
            return 2;
        if (bijoux != 0 && bourse == 0 && magot != 0)
            return 3;
        if (bijoux !=0 && bourse !=0 && magot == 0)
            return 4;
        if (bijoux != 0 && bourse != 0 && magot != 0)
            return 5;

        return 6;
    }

    public int removeStuffInt() {
        switch( etatStuff() ) {

            case 0:
                return 0;

            case 1:
                if (getBijoux() > 0) {
                    removeBijoux();
                    return 1;
                }
                if (getBourse() > 0) {
                    removeBourse();
                    return 2;
                }
                if (getMagot()  > 0) {
                    removeMagot();
                    return 3;
                }

            case 2:
                if (new Random().nextBoolean()) {
                    removeBourse();
                    return 2;
                }
                else {
                    removeMagot();
                    return 3;
                }

            case 3:
                if (new Random().nextBoolean()) {
                    removeBijoux();
                    return 1;
                }
                else {
                    removeMagot();
                    return 3;
                }

            case 4:
                if (new Random().nextBoolean()) {
                    removeBijoux();
                    return 1;
                }
                else {
                    removeBourse();
                    return 2;
                }

            case 5:
                int rand = new Random().nextInt(3);
                if (rand == 0) {
                    removeBijoux();
                    return 1;
                } else if (rand == 1) {
                    removeBourse();
                    return 2;
                } else if (rand == 2) {
                    removeMagot();
                    return 3;
                }
                break;

        }
        System.out.println("Error, No Magot Avalaible");
        return 0;
    }
public int removeStuff(String nom) {
        int i = removeStuffInt();
        switch(i) {

            case 0:
                Train.infoJeu(nom + " a volé des bijoux.");
                this.removeBijoux();
                break;

            case 1:
                Train.infoJeu(nom + " a volé de la bourse.");
                this.removeBourse();
                break;

            case 2:
                Train.infoJeu(nom + " a trouvé le jackpot !");
                this.removeMagot();
                break;

            case 3:
                Train.infoJeu(nom + " a trouvé un wagon vide :/");
                break;
        }
        return i;
    }
}
