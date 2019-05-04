package paperstone.gui;

import paperstone.game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Game extends JFrame implements ActionListener {

    private JButton bscissors, bstone, bpaper, endOfGame;
    private JLabel round, usersPoints, computersPoints, randomResult, roundResult, preround, userHello, computer;


    private UserPoints pointsU = new UserPoints(0);
    private int pointsForUser = pointsU.getUserPoints();
    private ComputerPoints pointsC = new ComputerPoints(0);
    private int pointsForComputer = pointsC.getComputerPoints();

    Gestures paper = new Paper("Paper");
    Gestures scissors = new Scissors("Scissors");
    Gestures stone = new Stone("Stone");
    GestureLibrary library = new GestureLibrary();


    public Game(Login login) {

        setSize(400, 600);
        setTitle("Paper, Scissors, Stone");
        setLayout(null);

        bscissors = new JButton("Scissors");
        bscissors.setBounds(50, 400, 100, 20);
        add(bscissors);
        bscissors.addActionListener(this);

        bstone = new JButton("Stone");
        bstone.setBounds(150, 400, 100, 20);
        add(bstone);
        bstone.addActionListener(this);

        bpaper = new JButton("Paper");
        bpaper.setBounds(250, 400, 100, 20);
        add(bpaper);
        bpaper.addActionListener(this);

        endOfGame = new JButton("Exit");
        endOfGame.setBounds(175, 500, 100, 20);
        add(endOfGame);
        endOfGame.addActionListener(this);

        preround = new JLabel("Rounds remain:");
        preround.setBounds(10, 10, 150, 20);
        add(preround);

        round = new JLabel(Integer.toString(login.getRound()));
        round.setBounds(160, 10, 100, 20);
        add(round);

        userHello = new JLabel(login.getUser() + ":");
        userHello.setBounds(10, 270, 300, 20);
        add(userHello);

        usersPoints = new JLabel(String.valueOf(pointsForUser));
        usersPoints.setBounds(10, 300, 350, 20);
        add(usersPoints);

        computer = new JLabel("Computer:");
        computer.setBounds(10, 320, 350, 20);
        add(computer);

        computersPoints = new JLabel(String.valueOf(pointsForComputer));
        computersPoints.setBounds(10, 340, 350, 20);
        add(computersPoints);

        randomResult = new JLabel("");
        randomResult.setBounds(10, 100, 250, 20);
        add(randomResult);

        roundResult = new JLabel("");
        roundResult.setBounds(10, 140, 250, 20);
        roundResult.setForeground(Color.red);
        add(roundResult);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        int roundsInGame = Integer.parseInt(round.getText());

        if (source == bscissors) {
            gameForScissors(roundsInGame);
        } else if (source == bpaper) {
            gameForPaper(roundsInGame);
        } else if (source == bstone) {
            gameForStone(roundsInGame);
        } else if (source == endOfGame) {
            dispose();
        }
    }

    public void gameForScissors(int roundsInGame) {

        Collections.shuffle(library.getListOfGestures());
        Gestures result = library.getListOfGestures().get(0);
        randomResult.setText(result.computersMove());

        if (result.equals(scissors)) {
            roundResult.setText("Draw. Nobody wins");
            roundsInGame--;
            round.setText(Integer.toString(roundsInGame));
        } else if (result.equals(paper)) {
            roundResult.setText("You win!");
            pointsForUser++;
            usersPoints.setText(String.valueOf(pointsForUser));
            roundsInGame--;
            round.setText(Integer.toString(roundsInGame));
        } else if (result.equals(stone)) {
            roundResult.setText("Oh! You loose.");
            pointsForComputer++;
            computersPoints.setText(String.valueOf(pointsForComputer));
            roundsInGame--;
            round.setText(Integer.toString(roundsInGame));
        }

        int check = Integer.parseInt(round.getText().trim());
        if (check == 0) {
            EndOfGame endOfGame = new EndOfGame(this);
            endOfGame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            endOfGame.setVisible(true);
            this.setVisible(false);
        }

    }

    public void gameForStone(int roundsInGame) {
        Collections.shuffle(library.getListOfGestures());
        Gestures result = library.getListOfGestures().get(0);
        randomResult.setText(result.computersMove());
        if (result.equals(stone)) {
            roundResult.setText("Draw. Nobody wins");
            roundsInGame--;
            round.setText(Integer.toString(roundsInGame));
        } else if (result.equals(scissors)) {
            roundResult.setText("You win!");
            pointsForUser++;
            usersPoints.setText(String.valueOf(pointsForUser));
            roundsInGame--;
            round.setText(Integer.toString(roundsInGame));
        } else if (result.equals(paper)) {
            roundResult.setText("Oh! You loose.");
            pointsForComputer++;
            computersPoints.setText(String.valueOf(pointsForComputer));
            roundsInGame--;
            round.setText(Integer.toString(roundsInGame));
        }
        int check = Integer.parseInt(round.getText().trim());
        if (check == 0) {
            EndOfGame endOfGame = new EndOfGame(this);
            endOfGame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            endOfGame.setVisible(true);
            this.setVisible(false);
        }
    }

    public void gameForPaper(int roundsInGame) {
        Collections.shuffle(library.getListOfGestures());
        Gestures result = library.getListOfGestures().get(0);
        randomResult.setText(result.computersMove());
        if (result.equals(paper)) {
            roundResult.setText("Draw. Nobody wins");
            roundsInGame--;
            round.setText(Integer.toString(roundsInGame));
        } else if (result.equals(stone)) {
            roundResult.setText("You win!");
            pointsForUser++;
            usersPoints.setText(String.valueOf(pointsForUser));
            roundsInGame--;
            round.setText(Integer.toString(roundsInGame));
        } else if (result.equals(scissors)) {
            roundResult.setText("Oh! You loose.");
            pointsForComputer++;
            computersPoints.setText(String.valueOf(pointsForComputer));
            roundsInGame--;
            round.setText(Integer.toString(roundsInGame));
        }
        int check = Integer.parseInt(round.getText().trim());
        if (check == 0) {
            EndOfGame endOfGame = new EndOfGame(this);
            endOfGame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            endOfGame.setVisible(true);
            this.setVisible(false);
        }
    }

    public String resultsOfGame(){
        int totalUsersPoints = Integer.parseInt(usersPoints.getText());
        int totalComputersPoints = Integer.parseInt(computersPoints.getText());
        if(totalUsersPoints>totalComputersPoints) {
            return "You: " + totalUsersPoints + ", computer: " + totalComputersPoints + ". You win! Maybe once more game?";
        } else if(totalUsersPoints<totalComputersPoints){
            return "You: " + totalUsersPoints + ", computer: " + totalComputersPoints + ". You loose :(. Try again.";
        } else if(totalUsersPoints==totalComputersPoints) {
            return "You: " + totalUsersPoints + ", computer: " + totalComputersPoints + ". Draw. Try again.";
        } else {
            return "ERROR: I don't know the result :(.";
        }
    }
}
