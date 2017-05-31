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
public class Medusa extends Elementos {
   
   boolean sentido;
   public Medusa(int posX, int posY) {
        super(posX, posY);
        this.sentido = false;
    }

    @Override
    public void movimiento() {
        
    if(posX >= 800){
       sentido = true;   
    }else if(posX <=0){
      sentido = false;
    }
    
    if(sentido == true){
       posX+=-10;
    }else{
       posX+=10;
    }
     
    
    
    }

   


}
