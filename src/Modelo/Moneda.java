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
public class Moneda extends Elementos {
    
    
    boolean monctrl = false;
    Image imgctrl;

    public boolean isMonctrl() {
        return monctrl;
    }

    public void setMonctrl(boolean monctrl) {
        this.monctrl = monctrl;
    }

    public Image getImgctrl() {
        return imgctrl;
    }

    public void setImgctrl(Image imgctrl) {
        this.imgctrl = imgctrl;
    }

    public Moneda(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void movimiento() {
        
        
    }


}
