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
public class Mina extends Elementos {

    protected boolean sentido;
    protected int z;
    public Mina(int posX, int posY, int z) {
        super(posX, posY);
        this.posY = posY;
        this.posX = posX;
        this.sentido = false;
        this.z = z;
    }

    @Override
    public void movimiento() {

        if (posY >= z + 20) {
            sentido = true;
        } else if (posY <= 0) {
            sentido = false;
        }

        if (sentido == true) {
            posY += -10;
        } else {
            posY += 10;
        }

    }

   


}
