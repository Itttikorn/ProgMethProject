package pane.tiles;

import javafx.geometry.Pos;
import javafx.scene.text.Text;

public class StartTile extends Tile{
    public StartTile(int tileNumber) {
        super(tileNumber, "Corner");
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(new Text("Start"));
        this.getChildren().add(getPlayerBox());
    }
}
