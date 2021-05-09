package Modele;

import Controleur.Direction;

import java.util.Random;

public class Marshall {
    public double NERVOSITE_MARSHALL;
    protected int nWagon;
    protected boolean niveau;
    public String nomM;

    public Marshall(double NERVOSITE_MARSHALL) {
        this.NERVOSITE_MARSHALL = NERVOSITE_MARSHALL;
        this.nWagon = Train.NB_WAGON - 1;
        this.niveau = false;
        this.nomM = "Joe";
    }

    public double getNervosie() {
        return this.NERVOSITE_MARSHALL;
    }

    public int getnWagon() {
        return this.nWagon;
    }

    public void setNervosite(double nervoN) {
        this.NERVOSITE_MARSHALL = nervoN;
    }

    public boolean isDeplacement(Direction dir) {
        if (dir == Direction.HAUT || dir == Direction.BAS) {
            return false;
        }
        else if (dir == Direction.ARRIERE && this.nWagon == 0) {
            return false;
        }
        else if (dir == Direction.AVANT && this.nWagon == Train.NB_WAGON - 1) {
            return false;
        }
        return true;
    }
}
