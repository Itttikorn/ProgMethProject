package rendering;

import javafx.scene.image.Image;
import logic.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RenderableHolder {
    private static final RenderableHolder instance = new RenderableHolder();
    private List<Renderable> entities;
    private Comparator<Renderable> comparator;
    public static Image playerSprite;

    static {
        loadResource();
    }
    public RenderableHolder(){
        entities = new ArrayList<Renderable>();
        comparator = (Renderable o1, Renderable o2) -> {
            if (o1.getZ() > o2.getZ())
                return 1;
            return -1;
        };
    }

    public static RenderableHolder getInstance() {
        return instance;
    }

    public void add(Renderable entity) {
        System.out.println("add");
        entities.add(entity);
        Collections.sort(entities, comparator);
    }

    public void update() {
        for (int i = entities.size() - 1; i >= 0; i--) {
            if (entities.get(i).isDestroyed())
                entities.remove(i);
        }
    }

    public List<Renderable> getEntities() {
        return entities;
    }

    public static void loadResource(){
        playerSprite = new Image(ClassLoader.getSystemResource("sprite-sheet.png").toString());
    }
}
