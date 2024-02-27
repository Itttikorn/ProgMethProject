package Tile;

import javafx.scene.image.Image;
import main.GameScreen;
import rendering.RenderableHolder;

public class TileManager {
    private static final TileManager instance = new TileManager();
    private static Tile[] tiles;

    public TileManager() {
        tiles = new Tile[10];

        tiles[0] = new Tile();
        tiles[0].setImage(new Image(ClassLoader.getSystemResource("grass.png").toString()));
        tiles[0].setCollision(false);

        tiles[1] = new Tile();
        tiles[1].setImage(new Image(ClassLoader.getSystemResource("sand.png").toString()));
        tiles[1].setCollision(false);

        tiles[2] = new Tile();
        tiles[2].setImage(new Image(ClassLoader.getSystemResource("water.png").toString()));
        tiles[2].setCollision(true);
    }

    public static Tile getTile(int i){
        return tiles[i];
    }
}
