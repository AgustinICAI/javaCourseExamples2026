package examen.ui;

import javax.swing.*;

public class AirHockey extends JFrame {

    public AirHockey() {
        setTitle("Air Hockey");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        GamePanel panel = new GamePanel();
        add(panel);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

        panel.arrancarGameThread();
    }

    public static void main(String[] args) {
        new AirHockey();
    }
}
