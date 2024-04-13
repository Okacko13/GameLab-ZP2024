import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    private JPanel buttons;
    private JPanel titlePanel;

    private JButton[] gameOpener;

    private ImageIcon imageIcon;

    public Frame() {

        buttons = new JPanel();
        gameOpener = new JButton[3];
        titlePanel = new JPanel();

        settupFrame();

    }

    public void settupFrame(){

        setTitle("Lobby");
        imageIcon = new ImageIcon("LOBBY-LOGO.png");
        setIconImage(imageIcon.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(750,750);
        setResizable(false);

        getContentPane().setBackground(new Color(57, 57, 57));

        this.settupButtons();
        setVisible(true);

    }

    public void settupButtons(){

        for(int i = 0; i < gameOpener.length; i++){

            gameOpener[i] = new JButton();
            gameOpener[i].addActionListener(this);
            gameOpener[i].setFocusable(false);
            gameOpener[i].setBackground(new Color(255, 41, 41, 148));

        }

        gameOpener[0].setBounds(50,375,150,150);
        gameOpener[1].setBounds(300,375,150,150);
        gameOpener[2].setBounds(550,375,150,150);

        this.add(gameOpener[0]);
        this.add(gameOpener[1]);
        this.add(gameOpener[2]);

    }

    public void setTitlePanel(String text){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOpener[0].equals(e.getSource())) {
            System.out.println("tictactoe");

        } else if(gameOpener[1].equals(e.getSource())){
            System.out.println("mastermind");

        } else if(gameOpener[2].equals(e.getSource())){
            System.out.println("quoridors");

        }
    }

}
