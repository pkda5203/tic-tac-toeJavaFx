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
public class checkWinner {
    private gameTile[] tiles;
    
    
    public checkWinner(gameTile... tiles)
    {
        this.tiles = tiles;
    }
    
    
    public boolean isComplete() {
        if (tiles[0].getValue().isEmpty())
            return false;

        return tiles[0].getValue().equals(tiles[1].getValue())
                && tiles[0].getValue().equals(tiles[2].getValue());
    }
}
