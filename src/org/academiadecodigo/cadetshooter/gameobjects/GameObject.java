package org.academiadecodigo.cadetshooter.gameobjects;


import org.academiadecodigo.cadetshooter.Game;
import org.academiadecodigo.cadetshooter.RNG;
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
    GridDirection currentDirection;

    public GameObject(Rectangle target, int points, SimpleGfxGrid grid) {
        this.target = target;
        this.pos = new SimpleGridPosition(target.getX(), target.getY(), grid);
        this.points = points;
        this.currentDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];
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

    public abstract void move(GridDirection direction, int distance);

    public GridDirection getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(GridDirection currentDirection) {
        this.currentDirection = currentDirection;
    }

    public abstract void myMove(GridDirection direction, int distance);

    public GridDirection chooseDirection() {

        // Let's move in the same direction by default

        GridDirection newDirection = currentDirection;

        // Sometimes, we want to change direction...

        int randomDir = RNG.getRandom(0,100);

        if ( randomDir > 80){

            newDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];

            // but we do not want to perform U turns..
            if (newDirection.isOpposite(currentDirection)) {
                return chooseDirection();
            }
        }

        return newDirection;

    }
}
