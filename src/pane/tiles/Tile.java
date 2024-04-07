package pane.tiles;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.PlayerUtils;

import java.util.ArrayList;
import java.util.List;

public class Tile extends VBox {
    private int tileNumber;
    private String tileAlignment;
    private ArrayList<String> playersInTile = new ArrayList<String>(List.of(new String[]{"1", "2", "3", "4"}));
    public Tile(int tileNumber, String tileAlignment) {
        this.setTileNumber(tileNumber);
        this.setTileAlignment(tileAlignment);
        this.setPrefSize(75,100);
        if(this.tileAlignment.equals("Corner")){
            this.setPrefSize(100,100);
        }else if(this.tileAlignment.equals("Right")) {
            this.setRotate(-90);
        } else if (this.tileAlignment.equals("Left")) {
            this.setRotate(90);
        }
    }

    public Group toGroup() {
        Group group = new Group(this);
        return group;
    }

    public String getTileAlignment() {
        return tileAlignment;
    }

    public void setTileAlignment(String tileAlignment) {
        this.tileAlignment = tileAlignment;
    }

    public int getTileNumber() {
        return tileNumber;
    }

    public void setTileNumber(int tileNumber) {
        this.tileNumber = tileNumber;
    }

    public List<String> getPlayersInTile() {
        return playersInTile;
    }

    public void addPlayerToTile(String playerNumber){
        this.playersInTile.add(playerNumber);
    }

    protected HBox getPlayerBox(){
        HBox playerBox = new HBox();
        playerBox.setAlignment(Pos.CENTER);
        playerBox.setPrefHeight(20);
        playerBox.setPrefWidth(70);
        for (String playerNumber : playersInTile) {
            Circle circle = new Circle(8);
            circle.setFill(PlayerUtils.getPlayerColor(playerNumber));
            Text playerText = new Text(playerNumber);
            playerText.setFont(new Font(10));
            StackPane stack = new StackPane();
            stack.getChildren().addAll(circle, playerText);
            playerBox.getChildren().add(stack);
            HBox.setMargin(circle, new Insets(2));
        }
        return playerBox;
    }

    public void updateTileRender(){
        //TODO: do something
        //Updatable values that need tiles to be re-render
        //1. Player in tile
        //2. Level of tile
        //3. Owner of tile
    }
}
