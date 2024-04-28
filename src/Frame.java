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

    private final ImageIcon imageIcon= new ImageIcon("LOBBY-LOGO.png");

    public Frame() {

        gameOpener = new JButton[3];
        titlePanel = new JPanel();

        gamePanel = new GamePanel();

        this.add(gamePanel);

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
        textField = new JLabel();

        textField.setBackground(new Color(57, 57, 57));
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Times new roman",Font.PLAIN,60));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Pick game");
        textField.setOpaque(true);

        titlePanel.add(textField);
    }

    public void hideGameOButtons(){
        for(int i = 0; i < gameOpener.length; i++){
            gameOpener[i].setVisible(false);
        }
    }

    public void startGame(){
        gamePanel.setVisible(true);
        hideGameOButtons();
    }

    public void startTicTacToe(){
        gamePanel.setVisible(true);
        gamePanel.startTicTacToe();
        hideGameOButtons();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOpener[0].equals(e.getSource())) {
            System.out.println("tictactoe");
            setTitle("TicTacToe");
            startTicTacToe();

        } else if(gameOpener[1].equals(e.getSource())){
            System.out.println("mastermind");
            setTitle("Mastermind");
            startGame();

        } else if(gameOpener[2].equals(e.getSource())){
            System.out.println("quoridors");
            setTitle("Quoridor");
            startGame();

        }
    }

}
