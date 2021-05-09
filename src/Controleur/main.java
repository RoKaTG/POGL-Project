package Controleur;

import Modele.Train;
import Vue.Affichage;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class main {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        Train plateau = new Train(0);
        plateau.trainInitialise();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Affichage f = new Affichage();
                f.setVisible(true);
            }
        });
    }
}
