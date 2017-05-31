/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

/**
 *
 * @author USUARIO
 */
public class Persona extends Elementos {

    int x, y;
    private String nombre;
    private double velocidadCaida;
    private double gravedadBajoelagua;


    public Persona(int posX, int posY, String nombre) {
        super(posX, posY);
        this.x =  posX;
        this.y =  posY;
        this.nombre = nombre;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getNombre() {
        return nombre;
    }
    
    
 
    

    public void movimientoCaida() {

    }

    public void efecto(Elementos tipo) {

    }

    public int defProfundidad() {
        return 0;
    }

    public int defOxigeno() {
        return 0;
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == e.VK_LEFT) {
            if(x >= -350){
                 x += -5;
            }
             
            
            
            
           
        }
        if (keyCode == e.VK_RIGHT) {
            if(x<=615){
                x += 5;
            }
                

            
        }
    }
  
    
    

    public void keyReleased(KeyEvent e) {
       int keyCode = e.getKeyCode();
//        if (keyCode == e.VK_LEFT) {
//            
//            x -= 0;
//        }
//        if (keyCode == e.VK_RIGHT) {
//            x += 0;
//        }
   
    }



    @Override
    public void movimiento() {

        
//        x += x;
       
        

    }

}
