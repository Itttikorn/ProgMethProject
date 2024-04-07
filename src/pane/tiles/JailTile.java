package pane.tiles;

import javafx.geometry.Pos;
import javafx.scene.text.Text;

public class JailTile extends Tile{
    public JailTile(int tileNumber) {
        super(tileNumber, "Corner");
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(new Text("Food Break"));
        this.getChildren().add(getPlayerBox());
    }
}
