/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author cdpinedao
 */
public class Puntaje {

    protected int score;
    Persona jugador1;

    public Puntaje(int score, Persona marinero) {

        this.jugador1 = marinero;
        this.score = score;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public void escribir() throws FileNotFoundException, IOException {
        PrintWriter output = new PrintWriter("Puntaje.txt");
        output.print("Jugador            Puntaje");
        output.println();
        output.print(jugador1.getNombre() + "                  "
                + "" + this.score);
        

    }
}
