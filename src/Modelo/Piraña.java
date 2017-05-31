/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.event.ActionEvent;

/**
 *
 * @author USUARIO
 */
public class Piraña extends Elementos {

    boolean sentido;

    public Piraña(int posX, int posY) {
        super(posX, posY);
        this.sentido = false;
    }

    @Override
    public void movimiento() {
        if (posX >= 800) {
            sentido = true;
        } else if (posX <= 0) {
            sentido = false;
        }

        if (sentido == true) {
            posX += -20;
        } else {
            posX += 20;
        }
    }

   
    
    


}
