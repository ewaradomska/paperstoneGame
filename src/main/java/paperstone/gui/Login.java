package paperstone.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    private JLabel getName, getRounds;
    private JTextField inputName, inputRounds;
    private JButton confirm, exit;
    private String user;
    private int round;

    public Login() {
        setSize(400,400);
        setTitle("Login");
        setLayout(null);

        getName = new JLabel("Name: ");
        getName.setBounds(10, 50, 50, 20);
        add(getName);

        inputName = new JTextField(user);
        inputName.setBounds(70, 50, 300, 20);
        add(inputName);
       inputName.addActionListener(this);

        getRounds = new JLabel("Rounds to play");
        getRounds.setBounds(10, 80, 150, 20);
        add(getRounds);

        inputRounds = new JTextField(round);
        inputRounds.setBounds(170, 80, 50, 20);
        add(inputRounds);
        inputRounds.addActionListener(this);

        confirm = new JButton("OK");
        confirm.setBounds(50, 200, 100, 20);
        add(confirm);
        confirm.addActionListener(this);

        exit = new JButton("Exit");
        exit.setBounds(200, 200, 100, 20);
        add(exit);
        exit.addActionListener(this);
    }

        @Override
        public void actionPerformed (ActionEvent e){
        Object source = e.getSource();
        if(source==confirm || source==inputRounds){
            Game game = new Game(this);
            game.setDefaultCloseOperation(EXIT_ON_CLOSE);
            game.setVisible(true);
            this.setVisible(false);
        } else if(source==exit){
            dispose();
        }
    }

    public String getUser(){
        return user = inputName.getText();

    }

    public int getRound(){
        return round = Integer.parseInt(inputRounds.getText().trim());
    }
}
