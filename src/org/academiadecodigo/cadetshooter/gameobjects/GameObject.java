package org.academiadecodigo.cadetshooter.gameobjects;


import org.academiadecodigo.cadetshooter.Game;
import org.academiadecodigo.cadetshooter.position.*;
import org.academiadecodigo.cadetshooter.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.cadetshooter.simplegfx.SimpleGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


/**
 * Created by codecadet on 18/10/16.
 */
abstract public class GameObject {

    //This needs to be changed to host a picture instead of a rectangle. The rectangle version is debug only

    private Rectangle target;
    private boolean flag;
    private int points;
    private SimpleGridPosition pos;
    private SimpleGfxGrid grid;

    public GameObject(Rectangle target, int points, SimpleGfxGrid grid) {
        this.target = target;
        this.pos = new SimpleGridPosition(target.getX(), target.getY(), grid);
        this.points = points;
    }

    public SimpleGridPosition getPos() {
        return pos;
    }

    public void setPos(SimpleGridPosition pos) {
        this.pos = pos;
    }

    public SimpleGfxGrid getGrid() {
        return grid;
    }

    public void setGrid(SimpleGfxGrid grid) {
        this.grid = grid;
    }

    public Rectangle getTarget() {
        return target;
    }

    public void setTarget(Rectangle target) {
        this.target = target;
    }

    public boolean isUsed() {
        return flag;
    }

    public void setUsed(boolean flag) {
        this.flag = flag;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public abstract void moveInDirection(GridDirection direction, int distance);
}
