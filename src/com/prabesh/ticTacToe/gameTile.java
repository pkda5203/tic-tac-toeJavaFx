/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabesh.ticTacToe;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author prabeshkhadka
 */
public class gameTile extends StackPane 
{
    
    private Text draw = new Text();
    
    public gameTile(){

                
        Rectangle border =new Rectangle(200,200);
        //change the default black fill to transparent 
        border.setFill(null);
        border.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);
        getChildren().addAll(border, draw);
       checkTurn turn = new checkTurn();
        
        setOnMouseClicked(event -> {
            if (event.getButton()==MouseButton.PRIMARY)
            {   
                //if x turn
                if (turn.getTurn()==true)
                {
                    drawX();
                    //change to o turn
                    turn.setTurn(false);
                }
                //if O turn
                else
                {
                    drawO();
                    //chane to x turn
                    turn.setTurn(true);
                    
                }
            }
        });
    }
    
    //method to draw a X on the tile
    private void drawX()
    {
        draw.setText("X");
        draw.setFont(Font.font(80));
    }
    //method to draw a O on the tile
    private void drawO()
    {
        draw.setText("O");
        draw.setFont(Font.font(80));
    }
        
    
}
