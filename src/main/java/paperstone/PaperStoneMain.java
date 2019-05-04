package paperstone;

import paperstone.gui.Login;

import javax.swing.*;

public class PaperStoneMain {

    public static void main(String[] args){
        Login login = new Login();
       login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       login.setVisible(true);
    }

}
