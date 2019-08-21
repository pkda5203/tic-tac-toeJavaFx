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
   
    //static boolean variable to keep track of whoose turn it is
   public static boolean xTurn;
   
   public checkTurn()
   {
       
   }
   
   //getter
   public boolean getTurn()
   {
       return xTurn;
   }
    
   //setter
   protected void setTurn(boolean x)
   {
       xTurn=x;
   }
   
}
