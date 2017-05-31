/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class Main1 extends JFrame {

    Panel2 panel2;

    public Main1() throws Exception {
        initUI();
        panel2 = new Panel2();
    }

    private void initUI() throws Exception {
        add(new PanelSwap());
        setResizable(true);
        pack();

        setTitle("TrueSurvivor");
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        setIconImage(icon);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws Exception {
        JFrame ex = new Main1();

        ex.setVisible(true);
//        Test frame = new Test();
//        frame.setTitle("TruSurvivor");
//        frame.setSize(1024, 768);
//        frame.setLocationRelativeTo(null); //Center the frame
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
    }

}
