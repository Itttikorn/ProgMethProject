package pane.tiles;

import javafx.geometry.Pos;
import javafx.scene.text.Text;

public class FestivalTile extends Tile{
    public FestivalTile(int tileNumber) {
        super(tileNumber, "Corner");
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(new Text("Festival"));
        this.getChildren().add(getPlayerBox());
    }
}
