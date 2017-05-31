/*
 * Welcome Master.
 */
package Vistas;

import Modelo.Burbuja;
import Modelo.Medusa;
import Modelo.Mina;
import Modelo.Moneda;
import Modelo.Persona;
import Modelo.Piraña;
import Modelo.Puntaje;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Johan
 */
public class Board extends JPanel implements ActionListener {

    String name = JOptionPane.showInputDialog(null, "Ingrese su nombre: ", "TrueSurvivor", JOptionPane.QUESTION_MESSAGE);

    Persona marinero2;
    ArrayList<Medusa> medusas;
    ArrayList<Piraña> peces;
    ArrayList<Burbuja> burbujas;
    ArrayList<Moneda> monedas;
    ArrayList<Mina> minas;
    private JLabel label1;
    private JLabel label2;
    Puntaje test;

    private Timer timer;
    int x;
    int y;
    int secuencia;
    int sec;
    int a;
    int b;
    int z = 0;
    boolean mensaje = false;

    int control = 0;

    public Board() throws FileNotFoundException {

        initBoard();

    }

    public void initBoard() throws FileNotFoundException {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(1024, 500));

        label1 = new JLabel("Nombre:       " + name + "                                        ");
        
//        label1.setBounds(0,0,0,0);
//        label2.setBounds(0,0,0,0);
        label1.setForeground(Color.white);
        
        label1.setLocation(20, 0);
        
        add(label1);
        
        this.marinero2 = new Persona(0, 600, name);
        
        test = new Puntaje(z, marinero2);
        
        this.medusas = new ArrayList<>();
        this.peces = new ArrayList<>();
        this.burbujas = new ArrayList<>();
        this.monedas = new ArrayList<>();
        this.minas = new ArrayList<>();
        this.medusas.add(new Medusa(200, 0));
        this.medusas.add(new Medusa(600, 0));
        this.medusas.add(new Medusa(900, 0));
        this.peces.add(new Piraña(100, 0));
        this.peces.add(new Piraña(500, 0));
        this.peces.add(new Piraña(800, 0));
        this.burbujas.add(new Burbuja(30, 0, z));
        this.burbujas.add(new Burbuja(850, 0, z));
        this.burbujas.add(new Burbuja(100, 0, z));
        this.burbujas.add(new Burbuja(700, 0, z));
        this.burbujas.add(new Burbuja(500, 0, z));
        this.monedas.add(new Moneda(400, 0));
        this.monedas.add(new Moneda(200, 0));
        this.monedas.add(new Moneda(380, 0));
        this.monedas.add(new Moneda(100, 0));
        this.monedas.add(new Moneda(300, 0));
        this.monedas.add(new Moneda(700, 0));
        this.monedas.add(new Moneda(550, 0));
        this.monedas.add(new Moneda(600, 0));
        this.monedas.add(new Moneda(750, 0));
        this.monedas.add(new Moneda(468, 0));
        this.minas.add(new Mina(250, 0, z));
        this.minas.add(new Mina(850, 0, z));
        this.minas.add(new Mina(600, 0, z));

        timer = new Timer(120, this);
        timer.start();
        
        if (mensaje == true) {
            JOptionPane.showMessageDialog(this, "Su puntaje fue:" + test.getScore() + "Revise el archivo de texto Integrado.");
        }

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        label2 = new JLabel("Puntaje: " + z);
        label2.setForeground(Color.white);
        label2.setLocation(40, 0);
        add(label2);
        remove(label2);
        Image fondo = loadImage("underwater tileable.png");
        g.drawImage(fondo, x, z - 500, x + 1024, z + 1000, this);
        Image nubes = loadImage("sky1.png");
        g.drawImage(nubes, x, z - 700, x + 1024, z - 300, this);
        Image pez = loadImage("fish-big.png");
        g.drawImage(pez, this.peces.get(0).getPosX(), z + 200, this.peces.get(0).getPosX() + 54, z + 249, (this.a * 54), 0, (this.a * 54) + 54, 49, this);
        //g.drawRect(this.peces.get(0).getPosX(), z + 200, 50,42);
        g.drawImage(pez, this.peces.get(1).getPosX(), z - 75, this.peces.get(1).getPosX() + 54, z - 26, (this.a * 54), 0, (this.a * 54) + 54, 49, this);
        //g.drawRect(this.peces.get(1).getPosX(), z - 75, 50,42);
        g.drawImage(pez, this.peces.get(2).getPosX(), z - 200, this.peces.get(2).getPosX() + 54, z - 151, (this.a * 54), 0, (this.a * 54) + 54, 49, this);
        //g.drawRect(this.peces.get(2).getPosX(), z - 200, 50,42);
        Image medusa = loadImage("attack.scml__000.png");
        g.drawImage(medusa, this.medusas.get(0).getPosX() + 50, z - 300, this.medusas.get(0).getPosX() + 170, z - 180, (this.sec * 50), 0, (this.sec * 50) + 50, 50, this);
        //g.drawRect(this.medusas.get(0).getPosX() + 50, z - 300, 60,55);
        g.drawImage(medusa, this.medusas.get(1).getPosX() + 50, z + 100, this.medusas.get(1).getPosX() + 170, z + 220, (this.sec * 50), 0, (this.sec * 50) + 50, 50, this);
        //g.drawRect(this.medusas.get(1).getPosX() + 50, z + 100, 60,55);
        g.drawImage(medusa, this.medusas.get(2).getPosX() + 50, z, this.medusas.get(2).getPosX() + 170, z + 120, (this.sec * 50), 0, (this.sec * 50) + 50, 50, this);
        //g.drawRect(this.medusas.get(2).getPosX() + 50, z, 60,55);
        Image marinero = loadImage("pirate_m1.png");
        g.drawImage(marinero, marinero2.getX() + 350, y + 350, marinero2.getX() + 414, y + 446, (a * 32), 144, (this.a * 32) + 32, 192, this);
        //g.drawRect(marinero2.getX()+350, y + 350, 60,90);
        Image mina = loadImage("mine.png");
        g.drawImage(mina, this.minas.get(0).getPosX(), this.minas.get(0).getPosY() + z + 122, 45, 45, this);
        //g.drawRect(this.minas.get(0).getPosX(), this.minas.get(0).getPosY() + z + 122, 40,40);
        g.drawImage(mina, this.minas.get(1).getPosX(), this.minas.get(1).getPosY() + z - 5, 45, 45, this);
        //g.drawRect(this.minas.get(1).getPosX(), this.minas.get(1).getPosY() + z -5, 40,40);
        g.drawImage(mina, this.minas.get(2).getPosX(), this.minas.get(2).getPosY() + z - 273, 45, 45, this);
        //g.drawRect(this.minas.get(2).getPosX(), this.minas.get(2).getPosY() + z - 273, 40,40);
        Image moneda = loadImage("FullCoins.png");
        for (int i = 0; i < 10; i++) {
            this.monedas.get(i).setImgctrl(moneda);
        }
        if (this.monedas.get(0).isMonctrl() == true) {

            test.setScore(20);
            this.monedas.get(0).setImgctrl(null);
        }
        g.drawImage(this.monedas.get(0).getImgctrl(), this.monedas.get(0).getPosX(), z, this.monedas.get(0).getPosX() + 30, z + 30, (this.secuencia * 16), 0, (this.secuencia * 16) + 16, 16, this);
        //g.drawRect(this.monedas.get(0).getPosX(), z, 27,30);
        if (this.monedas.get(1).isMonctrl() == true) {

            test.setScore(20);
            this.monedas.get(1).setImgctrl(null);
        }
        g.drawImage(this.monedas.get(1).getImgctrl(), this.monedas.get(1).getPosX(), z + 100, this.monedas.get(1).getPosX() + 30, z + 130, (this.secuencia * 16), 0, (this.secuencia * 16) + 16, 16, this);
        //g.drawRect(this.monedas.get(1).getPosX(), z+100, 27,30);
        if (this.monedas.get(2).isMonctrl() == true) {

            test.setScore(20);
            this.monedas.get(2).setImgctrl(null);
        }
        g.drawImage(this.monedas.get(2).getImgctrl(), this.monedas.get(2).getPosX(), z + 200, this.monedas.get(2).getPosX() + 30, z + 230, (this.secuencia * 16), 0, (this.secuencia * 16) + 16, 16, this);
        //g.drawRect(this.monedas.get(2).getPosX(), z+200, 27,30);
        if (this.monedas.get(3).isMonctrl() == true) {

            test.setScore(20);
            this.monedas.get(3).setImgctrl(null);
        }
        g.drawImage(this.monedas.get(3).getImgctrl(), this.monedas.get(3).getPosX(), z - 200, this.monedas.get(3).getPosX() + 30, z - 170, (this.secuencia * 16), 0, (this.secuencia * 16) + 16, 16, this);
        //g.drawRect(this.monedas.get(3).getPosX(), z-200, 27,30);
        if (this.monedas.get(4).isMonctrl() == true) {

            test.setScore(20);
            this.monedas.get(4).setImgctrl(null);
        }
        g.drawImage(this.monedas.get(4).getImgctrl(), this.monedas.get(4).getPosX(), z - 175, this.monedas.get(4).getPosX() + 30, z - 145, (this.secuencia * 16), 0, (this.secuencia * 16) + 16, 16, this);
        //g.drawRect(this.monedas.get(4).getPosX(), z-175, 27,30);
        if (this.monedas.get(5).isMonctrl() == true) {

            test.setScore(20);
            this.monedas.get(5).setImgctrl(null);
        }
        g.drawImage(this.monedas.get(5).getImgctrl(), this.monedas.get(5).getPosX(), z - 125, this.monedas.get(5).getPosX() + 30, z - 95, (this.secuencia * 16), 0, (this.secuencia * 16) + 16, 16, this);
        //g.drawRect(this.monedas.get(5).getPosX(), z-125, 27,30);
        if (this.monedas.get(6).isMonctrl() == true) {

            test.setScore(20);
            this.monedas.get(6).setImgctrl(null);
        }
        g.drawImage(this.monedas.get(6).getImgctrl(), this.monedas.get(6).getPosX(), z + 150, this.monedas.get(6).getPosX() + 30, z + 180, (this.secuencia * 16), 0, (this.secuencia * 16) + 16, 16, this);
        //g.drawRect(this.monedas.get(6).getPosX(), z+150, 27,30);
        if (this.monedas.get(7).isMonctrl() == true) {

            test.setScore(20);
            this.monedas.get(7).setImgctrl(null);
        }
        g.drawImage(this.monedas.get(7).getImgctrl(), this.monedas.get(7).getPosX(), z - 50, this.monedas.get(7).getPosX() + 30, z - 20, (this.secuencia * 16), 0, (this.secuencia * 16) + 16, 16, this);
        //g.drawRect(this.monedas.get(7).getPosX(), z-50, 27,30);
        if (this.monedas.get(8).isMonctrl() == true) {

            test.setScore(20);
            this.monedas.get(8).setImgctrl(null);
        }
        g.drawImage(this.monedas.get(8).getImgctrl(), this.monedas.get(8).getPosX(), z - 100, this.monedas.get(8).getPosX() + 30, z - 70, (this.secuencia * 16), 0, (this.secuencia * 16) + 16, 16, this);
        //g.drawRect(this.monedas.get(8).getPosX(), z-100, 27,30);
        if (this.monedas.get(9).isMonctrl() == true) {

            test.setScore(20);
            this.monedas.get(9).setImgctrl(null);
        }
        g.drawImage(this.monedas.get(9).getImgctrl(), this.monedas.get(9).getPosX(), z + 300, this.monedas.get(9).getPosX() + 30, z + 330, (this.secuencia * 16), 0, (this.secuencia * 16) + 16, 16, this);
        //g.drawRect(this.monedas.get(9).getPosX(), z+300, 27,30);
        Image burbuja = loadImage("BubbleSimple.png");
        for (int i = 0; i < 5; i++) {
            this.burbujas.get(i).setImgctrl(burbuja);
        }
        if (this.burbujas.get(0).isBurbjctrl() == true) {

            test.setScore(5);
            this.burbujas.get(0).setImgctrl(null);
        }
        g.drawImage(this.burbujas.get(0).getImgctrl(), this.burbujas.get(0).getPosX(), this.burbujas.get(0).getPosY() + z - 300, 30, 30, this);
        //g.drawRect(this.burbujas.get(0).getPosX(), this.burbujas.get(0).getPosY() + z - 300, 32,32);
        if (this.burbujas.get(1).isBurbjctrl() == true) {

            test.setScore(5);
            this.burbujas.get(1).setImgctrl(null);
        }
        g.drawImage(this.burbujas.get(1).getImgctrl(), this.burbujas.get(1).getPosX(), this.burbujas.get(1).getPosY() + z - 330, 30, 30, this);
        //g.drawRect(this.burbujas.get(1).getPosX(), this.burbujas.get(1).getPosY() + z - 330, 32,32);
        if (this.burbujas.get(2).isBurbjctrl() == true) {

            test.setScore(5);
            this.burbujas.get(2).setImgctrl(null);
        }
        g.drawImage(this.burbujas.get(2).getImgctrl(), this.burbujas.get(2).getPosX(), this.burbujas.get(2).getPosY() + z + 115, 30, 30, this);
        //g.drawRect(this.burbujas.get(2).getPosX(), this.burbujas.get(2).getPosY() + z + 115, 32,32);
        if (this.burbujas.get(3).isBurbjctrl() == true) {

            test.setScore(5);
            this.burbujas.get(3).setImgctrl(null);
        }
        g.drawImage(this.burbujas.get(3).getImgctrl(), this.burbujas.get(3).getPosX(), this.burbujas.get(3).getPosY() + z, 30, 30, this);
        //g.drawRect(this.burbujas.get(3).getPosX(), this.burbujas.get(3).getPosY() + z, 32,32);
        if (this.burbujas.get(4).isBurbjctrl() == true) {

            test.setScore(5);
            this.burbujas.get(4).setImgctrl(null);
        }
        g.drawImage(this.burbujas.get(4).getImgctrl(), this.burbujas.get(4).getPosX(), this.burbujas.get(4).getPosY() + z - 100, 30, 30, this);
        //g.drawRect(this.burbujas.get(4).getPosX(), this.burbujas.get(4).getPosY() + z - 100, 32,32);
        Image vida = loadImage("heart_darker.png");
        Image corazon1 = vida;
        Image corazon2 = vida;
        Image corazon3 = vida;
        if (this.checkCollisions() == true) {

            control += 1;
            
           
        }
        
        if (control >=1) {
            corazon3 = null;
        }
        if (control >= 6) {
            corazon2 = null;
        }
        if (control >= 3) {
            corazon1 = null;
        }
        
        if(control >= 7){
            Image perder = loadImage("perdiste.jpg");
            g.drawImage(perder, 0, 0, 1024, 500, this);
            mensaje = true;            
            try {
                test.escribir();
            } catch (IOException ex) {
                System.out.println("Arcivho no encontrado");
            }
        }

        g.drawImage(corazon1, 0, 0, 22, 18, this);
        g.drawImage(corazon2, 25, 0, 22, 18, this);
        g.drawImage(corazon3, 50, 0, 22, 18, this);

        
        if (z >= 700) {

            Image ganar = loadImage("winner.jpg");
            g.drawImage(ganar, 0, 0, 1024, 500, this);
            mensaje = true;
            try {
                test.escribir();
            } catch (IOException ex) {
                System.out.println("Arcivho no encontrado");
            }

        }
        

    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }


    public void sencuencias() {
        if (this.secuencia == 7) {
            this.secuencia = 0;
        } else {
            this.secuencia++;
        }
        if (this.sec == 29) {
            this.sec = 0;
        } else {
            this.sec++;
        }
        if (this.a == 3) {
            this.a = 1;
        } else {
            this.a++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 3; i++) {
            this.medusas.get(i).movimiento();
            this.peces.get(i).movimiento();
            this.minas.get(i).movimiento();
        }
        for (int i = 0; i < 5; i++) {
            this.burbujas.get(i).movimiento();
        }
        this.sencuencias();

        checkCollisions();
        repaint();
    }

    public Rectangle pez0chk() {
        return new Rectangle(this.peces.get(0).getPosX(), z + 200, 50, 42);
    }

    public Rectangle pez1chk() {
        return new Rectangle(this.peces.get(1).getPosX(), z - 75, 50, 42);
    }

    public Rectangle pez2chk() {
        return new Rectangle(this.peces.get(2).getPosX(), z - 200, 50, 42);
    }

    public Rectangle meduza0chk() {
        return new Rectangle(this.medusas.get(0).getPosX() + 50, z - 300, 60, 55);
    }

    public Rectangle meduza1chk() {
        return new Rectangle(this.medusas.get(1).getPosX() + 50, z + 100, 60, 55);
    }

    public Rectangle meduza2chk() {
        return new Rectangle(this.medusas.get(2).getPosX() + 50, z, 60, 55);
    }

    public Rectangle minas0chk() {
        return new Rectangle(this.minas.get(0).getPosX(), this.minas.get(0).getPosY() + z + 122, 40, 40);
    }

    public Rectangle minas1chk() {
        return new Rectangle(this.minas.get(1).getPosX(), this.minas.get(1).getPosY() + z - 5, 40, 40);
    }

    public Rectangle minas3chk() {
        return new Rectangle(this.minas.get(2).getPosX(), this.minas.get(2).getPosY() + z - 273, 40, 40);
    }

    public Rectangle marinerochk() {
        return new Rectangle(marinero2.getX() + 350, y + 350, 60, 90);
    }

    public Rectangle moneda0chk() {
        return new Rectangle(this.monedas.get(0).getPosX(), z, 27, 30);
    }

    public Rectangle moneda1chk() {
        return new Rectangle(this.monedas.get(1).getPosX(), z + 100, 27, 30);
    }

    public Rectangle moneda2chk() {
        return new Rectangle(this.monedas.get(2).getPosX(), z + 200, 27, 30);
    }

    public Rectangle moneda3chk() {
        return new Rectangle(this.monedas.get(3).getPosX(), z - 200, 27, 30);
    }

    public Rectangle moneda4chk() {
        return new Rectangle(this.monedas.get(4).getPosX(), z - 175, 27, 30);
    }

    public Rectangle moneda5chk() {
        return new Rectangle(this.monedas.get(5).getPosX(), z - 125, 27, 30);
    }

    public Rectangle moneda6chk() {
        return new Rectangle(this.monedas.get(6).getPosX(), z + 150, 27, 30);
    }

    public Rectangle moneda7chk() {
        return new Rectangle(this.monedas.get(7).getPosX(), z - 50, 27, 30);
    }

    public Rectangle moneda8chk() {
        return new Rectangle(this.monedas.get(8).getPosX(), z - 100, 27, 30);
    }

    public Rectangle moneda9chk() {
        return new Rectangle(this.monedas.get(9).getPosX(), z + 300, 27, 30);
    }

    public Rectangle burbuja0chk() {
        return new Rectangle(this.burbujas.get(0).getPosX(), this.burbujas.get(0).getPosY() + z - 300, 32, 32);
    }

    public Rectangle burbuja1chk() {
        return new Rectangle(this.burbujas.get(1).getPosX(), this.burbujas.get(1).getPosY() + z - 330, 32, 32);
    }

    public Rectangle burbuja2chk() {
        return new Rectangle(this.burbujas.get(2).getPosX(), this.burbujas.get(2).getPosY() + z + 115, 32, 32);
    }

    public Rectangle burbuja3chk() {
        return new Rectangle(this.burbujas.get(3).getPosX(), this.burbujas.get(3).getPosY() + z, 32, 32);
    }

    public Rectangle burbuja4chk() {
        return new Rectangle(this.burbujas.get(4).getPosX(), this.burbujas.get(4).getPosY() + z - 100, 32, 32);
    }

    public boolean checkCollisions() {
        boolean check = false;
        Rectangle pez0 = pez0chk();
        Rectangle pez1 = pez1chk();
        Rectangle pez2 = pez2chk();
        Rectangle meduza0 = meduza0chk();
        Rectangle meduza1 = meduza1chk();
        Rectangle meduza2 = meduza2chk();
        Rectangle mina0 = minas0chk();
        Rectangle mina1 = minas1chk();
        Rectangle mina2 = minas3chk();
        Rectangle marinero = marinerochk();
        Rectangle moneda0 = moneda0chk();
        Rectangle moneda1 = moneda1chk();
        Rectangle moneda2 = moneda2chk();
        Rectangle moneda3 = moneda3chk();
        Rectangle moneda4 = moneda4chk();
        Rectangle moneda5 = moneda5chk();
        Rectangle moneda6 = moneda6chk();
        Rectangle moneda7 = moneda7chk();
        Rectangle moneda8 = moneda8chk();
        Rectangle moneda9 = moneda9chk();
        Rectangle burbuja0 = burbuja0chk();
        Rectangle burbuja1 = burbuja1chk();
        Rectangle burbuja2 = burbuja2chk();
        Rectangle burbuja3 = burbuja3chk();
        Rectangle burbuja4 = burbuja4chk();
        if (pez0.intersects(marinero)) {
            check = true;
        } else if (pez1.intersects(marinero)) {

            check = true;
        } else if (pez2.intersects(marinero)) {
            check = true;
        } else if (meduza0.intersects(marinero)) {
            check = true;
        } else if (meduza1.intersects(marinero)) {
            check = true;
        } else if (meduza2.intersects(marinero)) {
            check = true;
        } else if (mina0.intersects(marinero)) {
            check = true;
        } else if (mina1.intersects(marinero)) {
            check = true;
        } else if (mina2.intersects(marinero)) {
            check = true;
        } else if (moneda0.intersects(marinero)) {
            this.monedas.get(0).setMonctrl(true);
        }
        if (moneda1.intersects(marinero)) {
            this.monedas.get(1).setMonctrl(true);
        }
        if (moneda2.intersects(marinero)) {
            this.monedas.get(2).setMonctrl(true);
        }
        if (moneda3.intersects(marinero)) {
            this.monedas.get(3).setMonctrl(true);
        }
        if (moneda4.intersects(marinero)) {
            this.monedas.get(4).setMonctrl(true);
        }
        if (moneda5.intersects(marinero)) {
            this.monedas.get(5).setMonctrl(true);
        }
        if (moneda6.intersects(marinero)) {
            this.monedas.get(6).setMonctrl(true);
        }
        if (moneda7.intersects(marinero)) {
            this.monedas.get(7).setMonctrl(true);
        }
        if (moneda8.intersects(marinero)) {
            this.monedas.get(8).setMonctrl(true);
        }
        if (moneda9.intersects(marinero)) {
            this.monedas.get(9).setMonctrl(true);
        }
        if (burbuja0.intersects(marinero)) {
            this.burbujas.get(0).setBurbjctrl(true);
            control = 0;
        }
        if (burbuja1.intersects(marinero)) {
            this.burbujas.get(1).setBurbjctrl(true);
            control = 0;
        }
        if (burbuja2.intersects(marinero)) {
            this.burbujas.get(2).setBurbjctrl(true);
            control = 0;
        }
        if (burbuja3.intersects(marinero)) {
            this.burbujas.get(3).setBurbjctrl(true);
            control = 0;
        }
        if (burbuja4.intersects(marinero)) {
            this.burbujas.get(4).setBurbjctrl(true);
            control = 0;
        }
        return check;
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            marinero2.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_UP) {
                if (z < 700 && z >= -1) {
                    z += 3;
                }
            }
            if (key == KeyEvent.VK_DOWN) {
                if (z < 700 && z > -1) {
                    z -= 3;
                }
            }
            marinero2.keyPressed(e);
        }
    }

}
