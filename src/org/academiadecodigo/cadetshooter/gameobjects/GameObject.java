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
    private boolean clicked;
    private int points;
    private SimpleGridPosition pos;
    private SimpleGfxGrid grid;
    GridDirection currentDirection;
    private int speed;
    private int time;
    private int distance;

    public GameObject(Rectangle target, int points, SimpleGfxGrid grid, int speed, int time, int distance) {
        this.target = target;
        this.pos = new SimpleGridPosition(target.getX(), target.getY(), grid);
        this.points = points;
        this.currentDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];
        this.time = time;
        this.speed = speed;
        this.distance = distance;
    }

    public SimpleGridPosition getPos() {
        return pos;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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
