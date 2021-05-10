package Modele;

import Controleur.Action;
import Controleur.Direction;


public class Action2 {
    private void Vole(Bandit bandit) {
        if(bandit.actionList.size() < Train.NB_ACTION)
            bandit.actionList.add(Action.Vole);
    }

    private void TireHaut(Bandit bandit) {
        if(bandit.actionList.size() < Train.NB_ACTION)
            bandit.actionList.add(Action.TireHaut);
    }

    private void TireBas(Bandit bandit) {
        if(bandit.actionList.size() < Train.NB_ACTION)
            bandit.actionList.add(Action.TireBas);
    }

    private void TireDroite(Bandit bandit) {
        if(bandit.actionList.size() < Train.NB_ACTION)
            bandit.actionList.add(Action.TireDroite);
    }

    private void TireGauche(Bandit bandit) {
        if(bandit.actionList.size() < Train.NB_ACTION)
            bandit.actionList.add(Action.TireGauche);
    }

    private void VaHaut(Bandit bandit) {
        if(bandit.actionList.size() < Train.NB_ACTION)
            bandit.actionList.add(Action.VaHaut);
    }

    private void VaBas(Bandit bandit) {
        if(bandit.actionList.size() < Train.NB_ACTION)
            bandit.actionList.add(Action.VaBas);
    }

    private void VaGauche(Bandit bandit) {
        if(bandit.actionList.size() < Train.NB_ACTION)
            bandit.actionList.add(Action.VaGauche);
    }

    private void VaDroite(Bandit bandit) {
        if(bandit.actionList.size() < Train.NB_ACTION)
            bandit.actionList.add(Action.VaDroite);
    }

    private void actionsListsReset() {
        for(int i = 0 ; i < Train.NB_BANDIT ; i++)
            Train.banditList.get(i).actionList.clear();
    }

    public void execute(Action ation, int numB) {


        if(numB < Train.NB_BANDIT) { // Pour ne pas activer un bouton d'un onglet vide
            switch(ation) {

                case Vole:
                    Train.infoJeu("Le bandit " + (numB+1) + " ( " + Train.banditList.get(numB).nom + " ) veut voler" );
                    Train.banditList.get(numB).vole();
                    break;

                case TireHaut:
                    Train.infoJeu("Le bandit " + (numB+1) + " ( " + Train.banditList.get(numB).nom + " ) veut tirer en haut" );
                    Train.banditList.get(numB).tir(Direction.HAUT);
                    break;

                case TireBas:
                    Train.infoJeu("Le bandit " + (numB+1) + " ( " + Train.banditList.get(numB).nom + " ) veut tirer en bas" );
                    Train.banditList.get(numB).tir(Direction.BAS);
                    break;

                case TireGauche:
                    Train.infoJeu("Le bandit " + (numB+1) + " ( " + Train.banditList.get(numB).nom + " ) veut tirer à gauche" );
                    Train.banditList.get(numB).tir(Direction.ARRIERE);
                    break;

                case TireDroite:
                    Train.infoJeu("Le bandit " + (numB+1) + " ( " + Train.banditList.get(numB).nom + " ) veut tirer à droite" );
                    Train.banditList.get(numB).tir(Direction.AVANT);

                    break;

                case VaHaut:		Train.banditList.get(numB).deplacement(Direction.HAUT); Train.infoJeu(Train.banditList.get(numB).nom + " : Mouvement haut\n"); break;

                case VaBas:		Train.banditList.get(numB).deplacement(Direction.BAS); Train.infoJeu(Train.banditList.get(numB).nom + " : Mouvement Bas \n"); break;

                case VaGauche:	Train.banditList.get(numB).deplacement(Direction.ARRIERE); Train.infoJeu(Train.banditList.get(numB).nom + " : Mouvement Gauche \n"); break;

                case VaDroite:	Train.banditList.get(numB).deplacement(Direction.AVANT); Train.infoJeu(Train.banditList.get(numB).nom + " : Movement droite \n"); break;

                default:
                    break;
            }
        }


    }
    public Action2(Action ation, int numBandit) {
        numBandit--;

        if(numBandit < Train.NB_BANDIT) {
            switch(ation) {

                case TireHaut:
                    TireHaut(Train.banditList.get(numBandit) );
                    break;

                case TireBas:
                    TireBas(Train.banditList.get(numBandit) );
                    break;

                case TireGauche:
                    TireGauche(Train.banditList.get(numBandit) );
                    break;

                case TireDroite:
                    TireDroite(Train.banditList.get(numBandit) );
                    break;

                case VaHaut:
                    VaHaut( Train.banditList.get(numBandit) );
                    break;

                case VaBas:
                    VaBas( Train.banditList.get(numBandit) );
                    break;

                case VaGauche:
                    VaGauche( Train.banditList.get(numBandit) );
                    break;

                case VaDroite:
                    VaDroite( Train.banditList.get(numBandit) );
                    break;

                case Vole :
                    Vole( Train.banditList.get(numBandit) );
                    break;

                default:
                    break;
            }
        }

        // Exécuter les actions quand tout le monde a fini de tout rentrer
        int nbTotalActions = 0;
        for(int i = 0 ; i < Train.NB_BANDIT ; i++)
            nbTotalActions += Train.banditList.get(i).actionList.size();


        if(nbTotalActions == Train.NB_ACTION * Train.NB_BANDIT ) {
            Train.newsReset();
            for(int i = 0 ; i < Train.NB_ACTION ; i++){
                for(int j = 0 ; j < Train.NB_BANDIT ; j++) {
                    execute(Train.banditList.get(j).actionList.get(i),j);
                }
            }
            Train.NB_MANCHE++;
            actionsListsReset();
        }
    }


}
