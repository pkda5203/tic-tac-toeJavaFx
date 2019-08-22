/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabesh.ticTacToe;
import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 *
 * @author prabeshkhadka
 */
public class ticTacToe_javafx extends Application 
{
    
    private gameTile[][] tiles= new gameTile[3][3];
    private static List<checkWinner> gameState = new ArrayList<>();
    private Pane root = new Pane();
    private Parent newGame()
    
    {
        root.setPrefSize(600,600);
        //create 3*3 tile objects for the tic-tac-toe
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                gameTile tile = new gameTile();
                //space out and place each tile evenly 
                tile.setTranslateX(j*200);
                tile.setTranslateY(i*200);
                root.getChildren().add(tile);
                tiles[j][i]=tile;
            }
        }
        
        // check horizontal
        for (int y = 0; y < 3; y++) {
            gameState.add(new checkWinner(tiles[0][y], tiles[1][y], tiles[2][y]));
        }

        // check vertical
        for (int x = 0; x < 3; x++) {
            gameState.add(new checkWinner(tiles[x][0], tiles[x][1], tiles[x][2]));
        }

        // check diagonals
        gameState.add(new checkWinner(tiles[0][0], tiles[1][1], tiles[2][2]));
        gameState.add(new checkWinner(tiles[2][0], tiles[1][1], tiles[0][2]));
            
        return root;
        
    }
    
    public static void checkState() 
    {
        for (checkWinner pairs : gameState) {
            if (pairs.isComplete()) {
                gameTile.playable = false;
                System.exit(0);
                break;
            }
        }
    }
    
    
    
    public void playGame()
    {
       Stage stage = new Stage();
       checkTurn turn = new checkTurn();
       turn.setTurn(true);
       Scene gameScene = new Scene(newGame());
       gameScene.getStylesheets().add(getClass().getResource("newGame.css").toExternalForm());
       stage.setTitle("NEW GAME");
       stage.setScene(gameScene);
       stage.show();
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        //create buttons for new game and quit option
        Button btn = new Button();
        btn.setText("Play New Game");
        Button close = new Button();
        close.setText("Quit");
       
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) 
            {
                primaryStage.hide();
                playGame();
            }
        });
        
        close.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) 
            {
                System.exit(0);
            }
        });
        VBox root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.setFillWidth(false);
      
        
        
        Scene scene = new Scene(root, 700, 500);
        scene.getStylesheets().add(getClass().getResource("design_css.css").toExternalForm());

          root.getChildren().add(btn);

          root.getChildren().add(close);

          //stage setup and show
        primaryStage.setTitle("TIC-TAC-TOE");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     * main simply launches the application
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
