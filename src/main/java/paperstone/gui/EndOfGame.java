package paperstone.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndOfGame extends JFrame implements ActionListener {

    private JLabel conclusion;
    private JButton play, exit;

    public EndOfGame(Game game) {

        setSize(400, 400);
        setTitle("End of game");
        setLayout(null);

        conclusion = new JLabel(game.resultsOfGame());
        conclusion.setBounds(10, 50, 350, 20);
        add(conclusion);

        play = new JButton("Play again");
        play.setBounds(50, 150, 100, 20);
        add(play);
        play.addActionListener(this);

        exit = new JButton("Exit");
        exit.setBounds(200, 150, 100, 20);
        add(exit);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == play) {
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        } else if (source == exit) {
            dispose();
        }
    }
}
