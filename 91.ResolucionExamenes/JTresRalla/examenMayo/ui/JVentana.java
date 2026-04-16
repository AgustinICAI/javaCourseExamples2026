package examenMayo.ui;

import javax.swing.*;

import java.awt.*;

import examenMayo.dominio.Casilla;
import examenMayo.dominio.Juego;

public class JVentana extends JFrame {
    private Juego juego;
    private Tablero tablero;
    static int VELOCIDAD_FLASH = 500; //ms

    public static void main(String[] args) {
        new JVentana();
    }

    public JVentana() {
        super("Tres En Ralla");
        this.juego = new Juego(this);
        tablero = new Tablero(juego);
        this.setLayout(new BorderLayout());
        init();
    }

    private void init() {
        this.add(tablero);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public Juego getJuego() {
        return juego;
    }


    public void arrancarAnimacion(int[] combinacionGanadora) {
        //**BLOQUE DE CÓDIGO A IMPLEMENTAR POR EL ALUMNO**//
    }
}
