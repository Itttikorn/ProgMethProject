package logic;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import rendering.RenderableHolder;

import java.util.ArrayList;

public class Player extends CollidableEntity {
    private static final int speed = 5;
    private int facing = 0;
    private ArrayList<Image> playerSprite;
    private int spriteNumber = 0;
    private int spriteCounter = 0;

    public Player(double x, double y){
        this.x = x;
        this.y = y;
        this.radius = 16;
        playerSprite = new ArrayList<>();
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                System.out.println(i + " " + j);
                WritableImage croppedImage = new WritableImage(RenderableHolder.playerSprite.getPixelReader(),j*32,i*32,32,32);
                this.playerSprite.add(croppedImage);
            }
        }
    }

    private void forward() {
        if(facing == 2){
            this.x += speed;
        }else if(facing == 0){
            this.y += speed;
        }else if(facing == 1){
            this.x -= speed;
        }else if(facing == 3){
            this.y -= speed;
        }
    }

    public void update() {
        if (InputUtility.getKeyPressed(KeyCode.W)) {
            this.facing = 3;
            forward();
        } else if (InputUtility.getKeyPressed(KeyCode.A)) {
            this.facing = 1;
            forward();
        } else if (InputUtility.getKeyPressed(KeyCode.D)) {
            this.facing = 2;
            forward();
        } else if (InputUtility.getKeyPressed(KeyCode.S)) {
            this.facing = 0;
            forward();
        }
        if(InputUtility.getKeyPressed(KeyCode.W) || InputUtility.getKeyPressed(KeyCode.A) || InputUtility.getKeyPressed(KeyCode.S) || InputUtility.getKeyPressed(KeyCode.D)){
            spriteCounter++;
            if(spriteCounter > 10){
                spriteNumber++;
                if(spriteNumber>=3){
                    spriteNumber = 0;
                }
                spriteCounter = 0;
            }
        }else{
            spriteNumber = 1;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        System.out.println((facing*3)+spriteNumber);
        gc.drawImage(playerSprite.get((facing*3)+spriteNumber),x,y);
        //gc.fillRect(x,y,radius*2,radius*2);
        //gc.translate(x,y);
        //gc.translate(-x,-y);
        //gc.rotate(facing);
    }
}
