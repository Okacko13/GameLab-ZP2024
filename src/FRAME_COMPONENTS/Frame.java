package FRAME_COMPONENTS;

import MASTERMIND.Mastermind;
import MASTERMIND.ResetMastermind;
import QUORIDOR.Quoridor;
import QUORIDOR.ResetQuoridorButton;
import TICTACTOE.ResetTicTacToeButton;
import TICTACTOE.TicTacToe;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    private JPanel titlePanel;
    private JLabel textField;
    private JButton[] gameOpener;
    private GamePanel gamePanel;
    private FramePanel framePanel;
    private final ImageIcon imageIcon= new ImageIcon("OK-logo.png");

    public Frame() {

        gameOpener = new JButton[3];
        titlePanel = new JPanel();

        gamePanel = new GamePanel();

        this.add(gamePanel);

        setUpFramePanel();
        settupFrame();
    }

    public void settupFrame(){

        setTitle("Lobby");
        setIconImage(imageIcon.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(750,750);
        setResizable(false);

        getContentPane().setBackground(new Color(57, 57, 57));

        this.settupButtons();
        this.setTitlePanel();
        this.setTextField();

        setVisible(true);

    }
    public void setUpFramePanel(){
        framePanel = new FramePanel(new GamePanel(),new TextPanel(),new ResetTicTacToeButton(),new ResetMastermind(), new ResetQuoridorButton(),new ResetButton(framePanel,this));
        add(framePanel);
    }

    public void settupButtons(){

        for(int i = 0; i < gameOpener.length; i++){

            gameOpener[i] = new JButton();
            gameOpener[i].addActionListener(this);
            gameOpener[i].setFocusable(false);
            gameOpener[i].setBackground(new Color(255, 41, 41, 148));
            gameOpener[i].setForeground(new Color(0, 0, 0));
            gameOpener[i].setFont(new Font("Times New Roman",Font.BOLD,20));
            gameOpener[i].setBorderPainted(true);
            gameOpener[i].setBorder(BorderFactory.createLoweredBevelBorder());

        }

        gameOpener[0].setBounds(50,375,150,150);
        gameOpener[1].setBounds(300,375,150,150);
        gameOpener[2].setBounds(550,375,150,150);

        gameOpener[0].setText("TicTacToe");
        gameOpener[1].setText("Mastermind");
        gameOpener[2].setText("Quoridor");

        this.add(gameOpener[0]);
        this.add(gameOpener[1]);
        this.add(gameOpener[2]);
    }

    public void setTitlePanel(){

        titlePanel = new JPanel();
        titlePanel.setBounds(0,50,750,200);
        titlePanel.setBackground(new Color(57, 57, 57));
        titlePanel.setLayout(new BorderLayout());

        this.add(titlePanel);
    }

    public void setTextField(){
        textField = new JLabel("Pick game");
        textField.setBackground(new Color(57, 57, 57));
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Times new roman",Font.PLAIN,90));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setOpaque(true);

        titlePanel.add(textField);
    }

    public void enableGameOButtons(boolean bool){
        for(int i = 0; i < gameOpener.length; i++){
            gameOpener[i].setVisible(bool);
        }
    }

    public void startTicTacToeFramePanel(){
        framePanel.setVisibility(true);
        framePanel.startTicTacToe(new TicTacToe());
        enableGameOButtons(false);
    }
    public void startMastermind(){
        framePanel.setVisibility(true);
        framePanel.startMastermind(new Mastermind());
        enableGameOButtons(false);
    }

    public void startQuoridor(){
        framePanel.setVisibility(true);
        framePanel.startQuoridor(new Quoridor());
        enableGameOButtons(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOpener[0].equals(e.getSource())) {
            setTitle("TicTacToe");
            startTicTacToeFramePanel();

        } else if(gameOpener[1].equals(e.getSource())){
            setTitle("Mastermind");
            startMastermind();


        } else if(gameOpener[2].equals(e.getSource())){
            setTitle("Quoridor");
            startQuoridor();

        }
    }

}
