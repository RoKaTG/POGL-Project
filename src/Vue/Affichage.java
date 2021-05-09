package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.FlowLayout;

import Modele.Action2;
import Modele.Train;
import Vue.VueTrain;
import Controleur.Action;
import Modele.Bandit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Affichage extends JFrame {
    private final Color title = new Color(255,255,255);
    private final Color infoT = Color.white;
    private final Color infoG = Color.black;
    private final Color infoBandit = Color.white;
    private final Color info = Color.black;

    private final int infoTitle = 15;
    private final int infoGr = 10;
    private final int infoB = 13;
    private final int titleT = 30;
    private final int newss = 12;

    private final Color b_title = new Color(9,50,80);
    private final Color b_commands = new Color(100,80,170);
    private final Color b_commandTab = new Color(3,74,100);
    private final Color b_commandButton = new Color(200, 252, 200);
    private final Color b_commandBName = new Color(21, 119, 132);
    private final Color b_InfoBPanel = Color.PINK ;
    private final Color b_InfoGPanel = new Color(113, 171, 237);
    private final Color b_infoTitle = new Color(44, 58, 94);
    private final Color b_infoBCell = new Color(76, 33, 39);
    private final Color b_news = new Color(100,90,170);

    private final int c_infoTitle = 150;
    private final int cy_infoTitle = 50;
    private final int c_infoG = 150 ;
    private final int cy_infoG = 45 ;
    private final int c_infoB = 115;
    private final int cy_infoB = 45;

    private final int sy_title = 60;

    private final int s_frame = 1300;
    private final int sy_frame = 760;

    private JLabel mainTitle;
    private JTabbedPane commands;
    private JLabel visual;
    private JPanel infos;
    private JScrollPane news;

    private void initialiseWindows() {
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(s_frame, sy_frame);
        this.setLocationRelativeTo(null);
    }

    private JLabel maintTitle() {
        JLabel titleLabel = new JLabel("Colt Express",SwingConstants.CENTER);
        titleLabel.setPreferredSize(new Dimension(s_frame,sy_title));
        titleLabel.setFont(new Font("Verdana",1,sy_title));
        titleLabel.setBackground(b_title);
        titleLabel.setForeground( title );
        titleLabel.setOpaque(true);
        return titleLabel;
    }

    private JLabel visualBeta() {
        JLabel lab = new JLabel();
        lab.setText( "<html>" + stringToJText(VueTrain.CreationTrain()) + "</html>");
        lab.setHorizontalAlignment(SwingConstants.CENTER);
        lab.setFont(new Font("Monospaced",1,drawVisualFontSizer() ));
        lab.setForeground(new Color(239, 228, 11));
        lab.setPreferredSize(new Dimension(720,500));
        lab.setBackground(new Color(71, 46, 9));
        lab.setOpaque(true);
        return lab;
    }

    private String stringToJText(String s) {
        String outputString = "";

        for(char c : s.toCharArray() ) {
            if(c != ' ')
                outputString += c;
            else
                outputString += ' ';
        }
        return outputString;
    }

    private int drawVisualFontSizer() {
        switch(Train.NB_WAGON) {
            case 2: return 30;
            case 3: return 25;
            case 4: return 20;
            case 5: return 16;
            case 6: return 14;
        }

        return 5;
    }

   
