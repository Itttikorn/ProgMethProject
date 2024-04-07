package pane.tiles;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.PlayerUtils;

import java.util.ArrayList;
import java.util.List;

public class LocationTile extends Tile{
    private int tileLevel = 3;
    private String locationName;
    private String ownedPlayer = "1";
    public LocationTile(int tileNumber, String tileAlignment) {
        super(tileNumber, tileAlignment);

        if(tileAlignment.equals("Top")){
            this.setAlignment(Pos.BOTTOM_CENTER);
            this.getChildren().add(getPlayerBox());
            this.getChildren().add(new Text("Location"));
            this.getChildren().add(getLevelBox());
        }else{
            this.setAlignment(Pos.TOP_CENTER);
            this.getChildren().add(getLevelBox());
            this.getChildren().add(new Text("Location"));
            this.getChildren().add(getPlayerBox());
        }


    }
    public int getTileLevel() {
        return this.tileLevel;
    }

    public void setTileLevel(int tileLevel) {
        this.tileLevel = tileLevel;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    private HBox getLevelBox(){
        HBox levelBox = new HBox();
        levelBox.setAlignment(Pos.CENTER);
        levelBox.setPrefHeight(20);
        levelBox.setPrefWidth(70);
        levelBox.setBackground(new Background(new BackgroundFill(PlayerUtils.getPlayerColor(ownedPlayer), null, null)));
        if(this.tileLevel < 4){
            for (int i = 0; i < tileLevel; i++) {
                Rectangle square = new Rectangle(10, 10, Color.WHITE);
                levelBox.getChildren().add(square);
                HBox.setMargin(square, new Insets(2));
            }
        }else{
            Rectangle landmark = new Rectangle(50,10, Color.WHITE);
            levelBox.getChildren().add(landmark);
        }
        return levelBox;
    }
}
