package pane.tiles;

import javafx.geometry.Pos;
import javafx.scene.text.Text;

public class BusTile extends Tile{
    public BusTile(int tileNumber) {
        super(tileNumber, "Corner");
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(new Text("POP BUS"));
        this.getChildren().add(getPlayerBox());
    }
}
