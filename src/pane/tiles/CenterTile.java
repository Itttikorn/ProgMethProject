package pane.tiles;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CenterTile extends StackPane{
    public CenterTile() {
        this.setPrefSize(450,450);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(0.5))));
    }
}
