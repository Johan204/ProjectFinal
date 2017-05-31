package Vistas;

import Modelo.Persona;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * // * @author USUARIO //
 */
public class Panel2 extends JPanel implements ActionListener {

    private Timer timer;
    int x;
    int z;
    int a;
    int x1,z1;
    int secuencia;
    Persona marinero;

    public Panel2() {
        setPreferredSize(new Dimension(1024, 500));
        this.marinero = new Persona(0, 5, "");
        setFocusable(true);
        timer = new Timer(120, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Image fondo = loadImage("underwater tileable.png");
        g.drawImage(fondo, 0, 300 + z, 1024, 1000, this);
        Image nubes = loadImage("sky1.png");
        g.drawImage(nubes, 0, z, 1024, 300, this);
        Image barco = loadImage("Pirate Ship (Idle) PREVIEW.png");
        g.drawImage(barco, x - 100, z + 150, 320, 150, this);
        Image marineroi = loadImage("pirate_m1.png");
        g.drawImage(marineroi, x1 + 130, 210+z1, x1 + 160, 245+z1, (2 * 32), 96, (2 * 32) + 32, 144, this);
        Image pirata = loadImage("pirate_m2.png");
        g.drawImage(pirata, x1 + 115, z + 210, x1 + 145, z + 245, (a * 32), 96, (this.a * 32) + 32, 144, this);
        Image ancla = loadImage("ancla.png");
        g.drawImage(ancla, x1 + 125, z1+225, 26, 30, this);

    }

    public void sencuencias() {
        if (this.secuencia == 7) {
            this.secuencia = 0;
        } else {
            this.secuencia++;
        }
        if (this.a == 3) {
            this.a = 0;
        } else {
            this.a++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x < 150) {
            x += 5;
        }
        if (x1 < 230) {
            x1 += 5;
        } else if (230 == x1) {
            if (z > -800) {
                z -= 10;
            }else if(z == -800){
                if(z1<150){
                    z1 += 10;
                }
                
            }
        }
        this.sencuencias();
        repaint();
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    public int getZ() {
        return this.z;
    }

}
