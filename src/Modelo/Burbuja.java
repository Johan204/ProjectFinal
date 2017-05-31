/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;
import java.awt.event.ActionEvent;

/**
 *
 * @author USUARIO
 */
public class Burbuja extends Elementos{
    
    boolean burbjctrl = false;
    Image imgctrl;

    public boolean isBurbjctrl() {
        return burbjctrl;
    }

    public void setBurbjctrl(boolean burbjctrl) {
        this.burbjctrl = burbjctrl;
    }

    public Image getImgctrl() {
        return imgctrl;
    }

    public void setImgctrl(Image imgctrl) {
        this.imgctrl = imgctrl;
    }
    
    boolean sentido;
    int z;
    public Burbuja(int posX, int posY, int z) {
        super(posX, posY);
        this.posX = posX;
        this.posY = posY;
        this.sentido = false;
        this.z = z;
    }

    @Override
    public void movimiento() {
        if (posY >= z + 300) {
            sentido = true;
        } else if (posY <= 200) {
            sentido = false;
        }

        if (sentido == true) {
            posY += -10;
        } else {
            posY += 10;
        }
    }
    
    
    
    


    
}
