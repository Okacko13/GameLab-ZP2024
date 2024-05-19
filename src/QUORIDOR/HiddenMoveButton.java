package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HiddenMoveButton extends JPanel implements ActionListener {

    private JButton hiddenButton;
    public HiddenMoveButton() {
        createButton();
    }

    public void createButton() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new GridBagLayout());
        this.setBorder(null);
        this.setFocusable(false);
        this.setVisible(false);

        initializeButton();

        add(hiddenButton,getGBC());
    }
    public void initializeButton(){
        hiddenButton = new JButton();
        hiddenButton.addActionListener(this);
        hiddenButton.setSize(15,15);
        hiddenButton.setBorder(null);
        hiddenButton.setFocusable(false);
        hiddenButton.setBackground(new Color(119, 173, 196));
    }
    public GridBagConstraints getGBC(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        return gbc;
    }


    public void setVisibleButton(boolean bool){
        setVisible(bool);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
