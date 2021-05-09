package Modele;

import java.util.Random;

public class Marshall {
    public double NERVOSITE_MARSHALL;
    protected int nWagon;
    protected boolean niveau;

    public Marshall(double NERVOSITE_MARSHALL) {
        this.NERVOSITE_MARSHALL = NERVOSITE_MARSHALL;
        this.nWagon = Train.NB_WAGON - 1;
        this.niveau = false;
    }
}
