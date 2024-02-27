package Tile;

import javafx.scene.image.Image;

public class Tile {
    public Image image;
    public boolean collision = false;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
}
