package pane.tiles;

import javafx.geometry.Pos;
import javafx.scene.text.Text;

public class CardTile extends Tile{
    public CardTile(int tileNumber,String tileAlignment) {
        super(tileNumber, tileAlignment);
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(new Text("Card"));
        this.getChildren().add(getPlayerBox());
    }
}
