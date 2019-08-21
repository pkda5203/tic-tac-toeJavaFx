/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabesh.ticTacToe;

/**
 *
 * @author prabeshkhadka
 */
public class checkTurn {
    
   public static boolean xTurn;
   
   public checkTurn(){
       
   }
   
   public boolean getTurn()
   {
       return xTurn;
   }
    
   protected void setTurn(boolean x)
   {
       xTurn=x;
   }
   
}
