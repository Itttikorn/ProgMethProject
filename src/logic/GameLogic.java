package logic;

import rendering.RenderableHolder;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private List<Entity> gameObjectContainer;
    private Player player;

    public GameLogic(){
        this.gameObjectContainer = new ArrayList<Entity>();

        Map map = new Map();
        RenderableHolder.getInstance().add(map);

        this.player = new Player(100,100);
        addNewObject(player);
    }

    protected void addNewObject(Entity entity){
        gameObjectContainer.add(entity);
        RenderableHolder.getInstance().add(entity);
    }

    public void logicUpdate(){
        player.update();
    }
}
