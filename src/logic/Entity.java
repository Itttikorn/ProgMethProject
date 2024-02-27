package logic;

import rendering.Renderable;

public abstract class Entity implements Renderable {
    protected double x,y;
    protected int z;
    protected boolean visible,destroyed;

    protected Entity(){
        visible = true;
        destroyed = false;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }
}
