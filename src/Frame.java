import javax.swing.*;
import java.awt.*;

public class Frame {

    private JFrame frame;

    public Frame() {

        settupFrame();

    }

    public void settupFrame(){

        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);

    }


}
