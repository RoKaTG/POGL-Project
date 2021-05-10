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
    private final Color b_news = new Color(100,80,170);

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

    private JScrollPane news() {
        JLabel l = new JLabel();
        l.setPreferredSize(new Dimension(150,490));
        l.setBackground(b_news);
        l.setFont(new Font("Verdana",1,newss));
        l.setForeground(info);
        l.setOpaque(true);
        l.setBorder(new EmptyBorder(10,10,10,10));
        l.setVerticalAlignment(JLabel.BOTTOM);
        l.setText(newsStringToHtml());

        JScrollPane scroll = new JScrollPane(l);
        scroll.setPreferredSize(new Dimension(300,500));
        return scroll;
    }

    private String newsStringToHtml() {
        String s = "<html><body><p>";
        s += Train.newsGet() ;
        s += "</p></body></html>";
        return s;
    }

    private JTabbedPane commands() {
        JTabbedPane tabs = new JTabbedPane(); // Ensemble des tabs
        tabs.setPreferredSize(new Dimension(280,500));

        tabs.add(commandsBandit(1),"Bandit 1");

        if(Train.NB_BANDIT >= 2)
            tabs.add(commandsBandit(2),"Bandit 2");
        else
            tabs.add(commandsBanditInexistant(),"Bandit 2");

        if(Train.NB_BANDIT >= 3)
            tabs.add(commandsBandit(3),"Bandit 3");
        else
            tabs.add(commandsBanditInexistant(), "Bandit 3");

        if(Train.NB_BANDIT >= 4)
            tabs.add(commandsBandit(4),"Bandit 4");
        else
            tabs.add(commandsBanditInexistant(), "Bandit 4");
        tabs.setBackground(b_commands);
        tabs.setOpaque(true);
        return tabs;
    }

    private JLabel commandsBanditInexistant() {
        JLabel lab = new JLabel();
        lab.setBounds(0, 0, 280, 400);
        lab.setBackground(b_commandTab);
        lab.setOpaque(true);

        // Nom Joueur
        JLabel nomBandit = new JLabel();
        nomBandit.setLayout(new FlowLayout(FlowLayout.CENTER));
        nomBandit.setBounds(50, 15, 180, 30);
        nomBandit.add(commandsNomBandit("Joueur inexistant"));
        nomBandit.setBackground(b_commandBName);
        nomBandit.setOpaque(true);
        lab.add(nomBandit);

        return lab;
    }

    private JLabel empty() {
        return new JLabel("");
    }

    private JButton commandsButton(String s) {
        JButton b = new JButton(s);
        b.setBackground(b_commandButton);
        b.setOpaque(true);
        return b;
    }

    private JLabel commandsNomBandit(String s) {
        JLabel lab = new JLabel(s);
        lab.setForeground(Color.white);
        lab.setFont(new Font("Verdana",1,15));
        return lab;
    }

    private JLabel commandsBandit(int i) {
        JLabel lab = new JLabel();
        lab.setBounds(0, 0, 280, 400);
        lab.setBackground(b_commandTab);
        lab.setOpaque(true);

        // Nom Joueur
        JLabel nomBandit = new JLabel();
        nomBandit.setLayout(new FlowLayout(FlowLayout.CENTER));
        nomBandit.setBounds(50, 15, 180, 30);
        nomBandit.add(commandsNomBandit(Train.banditList.get(i-1).nom));
        nomBandit.setBackground(b_commandBName);
        nomBandit.setOpaque(true);
        lab.add(nomBandit);

        // TIR
        JLabel tir = new JLabel();
        tir.setLayout(new GridLayout(3,3,10,10) );
        tir.add(empty());

        JButton btnTirHaut = commandsButton(" ^ ");
        btnTirHaut.addActionListener( (e) -> { new Action2(Action.TireHaut,i) ; update(); } );
        tir.add( btnTirHaut );
        tir.add( empty() );
        JButton btnTirGauche = commandsButton(" < ");
        btnTirGauche.addActionListener( (e) -> { new Action2(Action.TireGauche,i) ; update(); } );
        tir.add( btnTirGauche );
        tir.add( new JLabel("Tir !",SwingConstants.CENTER) );
        JButton btnTirDroite = commandsButton(" > ");
        btnTirDroite.addActionListener( (e) -> { new Action2(Action.TireDroite,i) ; update(); } );
        tir.add( btnTirDroite );
        tir.add( empty() );
        JButton btnTirBas = commandsButton(" v ");
        btnTirBas.addActionListener( (e) -> { new Action2(Action.TireBas,i) ; update(); } );
        tir.add( btnTirBas );
        tir.add( empty() );
        tir.setBounds(50, 60, 180, 120);
        lab.add(tir);

        // Move
        JLabel move = new JLabel();
        move.setLayout(new GridLayout(3,3,10,10) );
        move.add( empty() );
        JButton moveHaut = commandsButton(" ^ ");
        moveHaut.addActionListener( (e) -> { new Action2(Action.VaHaut,i) ; update(); } );
        move.add( moveHaut );
        move.add( empty() );
        JButton moveGauche = commandsButton(" < ");
        moveGauche.addActionListener( (e) -> { new Action2(Action.VaGauche,i) ; update(); } );
        move.add( moveGauche );
        move.add( new JLabel("Move",SwingConstants.CENTER) );
        JButton moveDroite = commandsButton(" > ");
        moveDroite.addActionListener( (e) -> { new Action2(Action.VaDroite,i) ; update(); } );
        move.add( moveDroite );
        move.add(empty());
        JButton moveBas = commandsButton(" v ");
        moveBas.addActionListener( (e) -> { new Action2(Action.VaBas,i) ; update(); } );
        move.add( moveBas );
        move.setBounds(50, 205, 180, 120);
        lab.add(move);

        // Pick
        JButton pick = new JButton(" Pick ");
        pick.addActionListener( (e) -> { new Action2(Action.Vole,i) ; update(); } );
        pick.setBackground(b_commandButton);
        pick.setBounds(50, 350, 180, 40);
        pick.setOpaque(true);
        lab.add(pick);

        return lab;
    }

    private JLabel infoTitle(String s) {
        JLabel title = new JLabel(s,SwingConstants.RIGHT);


        title.setBorder(new EmptyBorder(0,0,0,0));
        title.setPreferredSize(new Dimension(c_infoTitle,cy_infoTitle));
        title.setBackground(b_infoTitle);
        title.setForeground( infoT );
        title.setFont( new Font("Verdana",Font.BOLD,infoTitle) );
        title.setOpaque(true); // Pour afficher le background

        return title;
    }

    private JLabel infoCell(double d) {
        JLabel cell = new JLabel(String.valueOf(d),SwingConstants.CENTER);


        cell.setBorder(new EmptyBorder(0,0,0,0));
        cell.setPreferredSize(new Dimension(c_infoG,cy_infoG));
        cell.setForeground(infoG);
        cell.setFont( new Font("Verdana",0,infoGr) );

        return cell;
    }

    private JLabel infoCellBold(String s) {
        JLabel cell = new JLabel(s,SwingConstants.CENTER);


        cell.setBorder(new EmptyBorder(0,0,0,0));
        cell.setPreferredSize(new Dimension(c_infoG,cy_infoG));
        cell.setForeground(infoG);
        cell.setFont( new Font("Verdana",Font.BOLD,infoGr) );

        return cell;
    }

    private JLabel infoBanditCell(int i) {
        JLabel cell = new JLabel(Integer.toString(i),SwingConstants.CENTER);

        cell.setPreferredSize(new Dimension(c_infoB,cy_infoB));
        cell.setForeground( infoBandit );
        cell.setFont( new Font("Verdana",0,infoB) );
        cell.setBackground(b_infoBCell);
        cell.setOpaque(true);


        return cell;
    }

    private JLabel infoBanditCell(String s) {
        JLabel cell = new JLabel(s,SwingConstants.CENTER);

        cell.setPreferredSize(new Dimension(c_infoB,cy_infoB));
        cell.setForeground( infoBandit );
        cell.setFont( new Font("Verdana",0,infoB) );
        cell.setBackground(b_infoBCell);
        cell.setOpaque(true);


        return cell;
    }

    private JLabel infoBanditCellBold(String s) {
        JLabel cell = new JLabel(s,SwingConstants.CENTER);

        cell.setPreferredSize(new Dimension(c_infoB,cy_infoB));
        cell.setForeground( infoBandit );
        cell.setFont( new Font("Verdana",Font.BOLD,infoB) );
        cell.setBackground(b_infoBCell);
        cell.setOpaque(true);

        return cell;
    }

    private JPanel banditFeatures() {
        JPanel feat = new JPanel(new FlowLayout(FlowLayout.LEFT,2,0));

        feat.add(infoBanditCellBold(""));
        feat.add(infoBanditCellBold("Nom"));
        feat.add(infoBanditCellBold("Wagon"));
        feat.add(infoBanditCellBold("Position"));
        feat.add(infoBanditCellBold("MONEY <3"));
        feat.add(infoBanditCellBold("Action ok"));
        feat.add(infoBanditCellBold("Munition"));

        return feat;
    }

    private	JPanel infoBanditLine(int i) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,2,0));
        panel.add(infoBanditCellBold("Bandit " + Integer.toString(i) ) );

        if(Train.NB_BANDIT < i) {
            for(int j = 0 ; j < 6 ; j ++)
                panel.add(infoBanditCellBold(""));
        } else {

            Bandit tmp = Train.banditList.get(i-1);

            panel.add(infoBanditCell( tmp.nom ));
            panel.add(infoBanditCell( tmp.getnWagon() ));
            if(tmp.getNiveau())
                panel.add(infoBanditCell("Toit"));
            else
                panel.add(infoBanditCell("Intérieur"));
            panel.add(infoBanditCell( Integer.toString(tmp.getMoney()) + " $" ));
            panel.add(infoBanditCell( Train.banditList.get(i-1).actionList.size() + " / " + Integer.toString(Train.NB_ACTION) ));
            panel.add(infoBanditCell( Train.banditList.get(i-1).getnBalle() ));





        }
        return panel;
    }

    private JPanel infos() {
        JPanel infoPane = new JPanel( new BorderLayout(0,0) );

        // Création des blocs
        JPanel infoGene = new JPanel( new FlowLayout(FlowLayout.LEFT,0,0));
        infoGene.setPreferredSize(new Dimension(280,200));
        infoGene.setBackground(b_InfoGPanel);
        infoGene.setOpaque(true);
        infoGene.setBorder(new EmptyBorder(0,0,0,0));

        JPanel infoBandits = new JPanel( new FlowLayout(FlowLayout.LEFT,2,2));
        infoBandits.setPreferredSize(new Dimension(720,200));
        infoBandits.setBackground(b_InfoBPanel);
        infoBandits.setOpaque(true);
        infoBandits.setBorder(new EmptyBorder(0,0,0,0));

        infoGene.add(infoTitle("Infos"));
        infoGene.add(infoTitle(""));
        infoGene.add(infoCellBold("Nervosité Mareshall :"));
        infoGene.add(infoCell(Train.marshall.getNervosite()));
        infoGene.add(infoCellBold("Manche en cours"));
        infoGene.add(infoCell(Train.NB_MANCHE));
        infoGene.add(infoCellBold("Nbr de joueurs :"));
        infoGene.add(infoCell(Train.NB_BANDIT));
        infoGene.add(infoCellBold("Nbr de wagons :"));
        infoGene.add(infoCell(Train.NB_WAGON));

        infoBandits.add(banditFeatures());

        infoBandits.add(infoBanditLine(1));
        infoBandits.add(infoBanditLine(2));
        infoBandits.add(infoBanditLine(3));
        infoBandits.add(infoBanditLine(4));



        infoPane.add(infoBandits, BorderLayout.CENTER);
        infoPane.add(infoGene, BorderLayout.WEST);
        return infoPane;
    }

    public Affichage() {
        super("Colt Express");
        this.initialiseWindows();
        JPanel pane = (JPanel) this.getContentPane();
        pane.setLayout( new BorderLayout() );
        mainTitle = maintTitle() ; 	pane.add( mainTitle , BorderLayout.NORTH);
        commands = commands(); 		pane.add( commands , BorderLayout.WEST);
        visual = visualBeta();		pane.add( visual , BorderLayout.CENTER);
        news = news();				pane.add( news , BorderLayout.EAST);
        infos = infos();			pane.add( infos , BorderLayout.SOUTH);
    }

    public void update() {
        this.remove(infos);
        JPanel infoTmp = new JPanel();
        infoTmp = infos();
        this.add(infoTmp, BorderLayout.SOUTH);
        this.visual.setText("<html>" + stringToJText(VueTrain.CreationTrain()) + "</html>");
        this.remove(news);
        JScrollPane newsTmp = new JScrollPane();
        newsTmp = news();
        this.add(newsTmp, BorderLayout.EAST);

    }
}

   
