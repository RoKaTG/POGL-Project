package Modele;

import Controleur.Action;
import Controleur.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Bandit {
    public String nom;
    private int nWagon;
    private int NB_BALLES = 6;
    private boolean niveau;
    private HashMap<String, Integer> stuff;
    public ArrayList<Action> actionList = new ArrayList<Action>();

    public Bandit(String nom) {
        this.nom = nom;
        this.nWagon = new Random().nextInt(Train.NB_WAGON - 1);
        this.niveau = new Random().nextBoolean();
        this.stuff = new HashMap<String, Integer>();
        this.stuff.put("Bourse", 0);
        this.stuff.put("Bijoux", 0);
        this.stuff.put("Magot", 0);
    }

    public boolean getNiveau() {
        return this.niveau;
    }

    public int getnWagon() {
        return nWagon;
    }

    public int getnBalle() {
        return NB_BALLES;
    }
    /* Après 15 00 essais, j'en suis venu à la conclusion que
    je devais remettre ici le code des get/remoove/add dans butin vers bandit
    pour les utilisé :/ (il y a bien sur quelque differences dans le codage
     */
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

    public int getMoney() {
        return this.getBourse() * 500 + this.getBijoux() * 500 + this.getMagot() * 1000;

    }

    public void addBourse(int val) {

        this.stuff.put("Bourse", this.stuff.get("Bourse") + val);
    }

    public void addBijoux(int val) {
        this.stuff.put("Bijoux", this.stuff.get("Bijoux") + val);
    }

    public void addMagot() {
            this.stuff.put("Magot", 1);
    }

    public void removeBourse() {
        this.stuff.put("Bourse", this.stuff.get("Bourse") - 1);
    }

    public void removeBijoux() {
        this.stuff.put("Bijoux", this.stuff.get("Bijoux") - 1);
    }

    public void removeMagot() {
        this.stuff.put("Magot", 0);
    }

    public void vole() {
        int i = Train.wagonList.get(this.getnWagon()).removeStuff(this.nom);
        switch(i) {
            case 0:
                break;

            case 1:
                this.addBourse(1);
                break;
            case 2:
                this.addBijoux(1);
                break;
            case 3:
                this.addMagot();
                break;

        }
    }

    public boolean isDeplacement(Direction dir){
        if(dir == Direction.HAUT && this.niveau) {
            Train.infoJeu(this.nom + " est sur la locomotive");
            return false;
        }
        else if(dir == Direction.BAS && (! this.niveau) ) {
            Train.infoJeu(this.nom + " est dans la locomotive");
            return false;
        }
        else if(dir == Direction.ARRIERE && this.nWagon == 0) {
            Train.infoJeu(this.nom + " est dans le dernier wagon.");
            return false;
        }
        else if (dir == Direction.AVANT && this.nWagon == Train.NB_WAGON-1){
            Train.infoJeu(this.nom + " est dans le premier wagon");
            return false;
        }

        return true;
    }

    public void deplacement(Direction dir) {
        if( this.isDeplacement(dir) ) {
            switch(dir) {
                case HAUT:
                    this.niveau = true;
                    break;
                case BAS:
                    this.niveau = false;
                    break;

                case ARRIERE:
                    this.nWagon--;
                    break;

                case AVANT:
                    this.nWagon++;
                    break;
            }
        }
    }

    public int removeStuff() {
        int i = removeStuffInt();
        switch(i) {

            case 0:
                Train.infoJeu(this.nom + "n'avait rien sur lui, il a de la chance...");
                break;

            case 1:
                Train.infoJeu(this.nom + "a fait tomber de la bourse.");
                Train.wagonList.get(this.nWagon).addBourse(1);
                break;

            case 2:
                Train.infoJeu(this.nom + "a fait tomber des bijoux.");
                Train.wagonList.get(this.nWagon).addBijoux(1);
                break;

            case 3:
                Train.infoJeu(this.nom + "a fait tomber le magot !");
                Train.wagonList.get(this.nWagon).addMagot();
                break;
        }
        return i;
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
        switch(etatStuff()) {
            case 0:
                return 0;

            case 1:
                if(getBijoux() > 0) {
                    removeBijoux();
                    return 1;
                }
                if(getBourse() > 0) {
                    removeBourse();
                    return 2;
                }
                if(getMagot()  > 0) {
                    removeMagot();
                    return 3;
                }
                break;

            case 2:
                if( new Random().nextBoolean() ) {
                    removeBourse();
                    return 2;
                }
                else {
                    removeMagot();
                    return 3;
                }

            case 3:
                if( new Random().nextBoolean() ) {
                    removeBijoux();
                    return 1;
                }
                else {
                    removeMagot();
                    return 3;
                }

            case 4:
                if( new Random().nextBoolean() ) {
                    removeBijoux(); return 1;
                }
                else {
                    removeBourse();
                    return 2; }

            case 5:
                int r = new Random().nextInt(3);
                if(r==0) {
                    removeBijoux();
                    return 1;
                }
                else if(r==1) {
                    removeBourse();
                    return 2;
                }
                else if(r==2) {
                    removeMagot();
                    return 3;
                }
                break;

        }

        System.out.println("Error");
        return 0;

    }


    public void tir(Direction dir) {
        int nWag = this.getnWagon();

        for(Bandit b : Train.banditList) {
            switch(dir) {

                case HAUT:
                    if(b.getNiveau() && b.nom != this.nom && b.getnWagon() == nWag) {
                        Train.infoJeu("Coups dur pour :" + b.nom + "A recus une balle de :" + this.nom); b.removeStuff(); }
                    break;

                case BAS:
                    if(!b.getNiveau() && b.nom != this.nom && b.getnWagon() == nWag) {
                        Train.infoJeu("Coups dur pour :" + b.nom + "A recus une balle de :" + this.nom); b.removeStuff();}
                    break;

                case ARRIERE:
                    if(b.getNiveau()==this.getNiveau() && b.nom != this.nom && ( b.getnWagon() == nWag - 1 || b.getnWagon() == nWag)) {
                        Train.infoJeu("Coups dur pour :" + b.nom + "A recus une balle de :" + this.nom); b.removeStuff(); }
                    break;
                case AVANT:
                    if(b.getNiveau()==this.getNiveau() && b.nom != this.nom && ( b.getnWagon() == nWag + 1 || b.getnWagon() == nWag)) {
                        Train.infoJeu("Coups dur pour :" + b.nom + "A recus une balle de :" + this.nom); b.removeStuff();}
                    break;
            }
        }

        if(this.getnBalle() > 0)
            this.NB_BALLES--;
        Train.infoJeu("Munitions de " + this.nom + " restantes : " + getnBalle()  + "\n");
    }

}
