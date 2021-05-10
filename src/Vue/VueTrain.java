package Vue;

import Modele.Bandit;
import Modele.Train;

public class VueTrain {
    public void Affichage() {
        System.out.println(this.toString());
    }
    public static String CreationTrain() {
        String string = "";


        for (Bandit b : Train.banditList) {
            if (b.getNiveau()) {
                for (int i = 0; i < b.getnWagon(); i++)
                    string += "        ";
                string += b.nom;
                string += "(" + (Train.NB_ACTION - b.actionList.size()) + ")";
            }
            string += "\n<br/>";
        }


        for (int i = 0; i < Train.NB_WAGON - 1; i++)
            string += " ____   ";
        string += " U__ _  " + "\n<br/>";


        for (int i = 0; i < Train.NB_WAGON - 1; i++) {
            if (Train.wagonList.get(i).getnStuff() < 10)
                string += "/    " + Train.wagonList.get(i).getnStuff() + "    \\  ";
            else
                string += "/    " + Train.wagonList.get(i).getnStuff() + "   \\  ";
        }
        string += "/    " + Train.wagonList.get(Train.NB_WAGON - 1).getnStuff() + "   L\\";
        string += "\n<br/>";
        for (int i = 0; i < Train.NB_WAGON - 1; i++)
            string += "--O---O--OO  ";
        string += " -OO----O--O ";
        string += "\n<br/>";
        for (Bandit b : Train.banditList) {
            if (!b.getNiveau()) {
                for (int i = 0; i < b.getnWagon(); i++)
                    string += "             ";
                string += "  " + b.nom;
                string += "(" + (Train.NB_ACTION - b.actionList.size() ) + ")";
            }
            string += "\n<br/>";
        }
        return string;
    }
}
