package MapPane;

import Util.Block;
import Util.PlayerView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Cell extends StackPane {
    private Block block;
    private boolean transparent;
    private final Color baseColor;

    public Cell(Block block) {
        super();

        //////////////// set value ////////////////
        this.baseColor = Color.WHITE;
        this.setPrefWidth(50);
        this.setPrefHeight(50);
        this.setMinHeight(50);
        this.setMinWidth(50);
        this.setBlock(block);
        this.setTransparent(block.equals(Block.WATER));
        this.setAlignment(Pos.CENTER);

        //////////////// set background and player ////////////////
        initializeCellColor();
        initializeCell(block);
    }

    public void initializeCell(Block block) {
        //////////////// set background ////////////////
        Image image = new Image(ClassLoader.getSystemResource(block +".jpg").toString());
        BackgroundFill bgFill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        BackgroundFill[] bgFillA = {bgFill};
        BackgroundSize bgSize = new BackgroundSize(150, 150, false, false, false, false);
        BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
        BackgroundImage[] bgImgA = {bgImg};

        this.setBackground(new Background(bgFillA, bgImgA));
    }

    public void drawInside(PlayerView playerView) {
        //////////////// draw player ////////////////
        Image image = new Image(ClassLoader.getSystemResource(playerView.toString() + "Hero.png").toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(90);
        imageView.setFitWidth(90);
        this.getChildren().add(imageView);
    }
    public void takeDamage(int damage) {
        return ;
    }

    public void clear() {
        this.getChildren().clear();
    }

    public void initializeCellColor() {
        this.setBackground(Background.fill(this.getBaseColor()));
    }

    public Color getBaseColor() {
        return baseColor;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public boolean isTransparent() {
        return transparent;
    }

    public void setTransparent(boolean transparent) {
        this.transparent = transparent;
    }
}
