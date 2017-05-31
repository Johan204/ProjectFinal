/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author Isabel-Fabian
 */
import Vistas.Board;
import Vistas.Panel2;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class PanelSwap extends JPanel implements ActionListener {

    JPanel firstPanel;
    JPanel secondPanel;
    private Timer timer;
    Panel2 panel2;

    public PanelSwap() throws FileNotFoundException {
        this.firstPanel = new Panel2();
        this.secondPanel = new Board();
        timer = new Timer(120, this);
        timer.start();
        add(firstPanel);
        panel2 = new Panel2();
    }

    /**
     * Listens to the buttons and perfomr the swap.
     */
    public void actionPerformed(ActionEvent e) {

        for (Component component : getComponents()) {
            if (firstPanel == component) {
                if (panel2.getZ() == -800) {
                    remove(firstPanel);
                    add(secondPanel);
                }

            }

            repaint();
            revalidate();
        }

    }
}
