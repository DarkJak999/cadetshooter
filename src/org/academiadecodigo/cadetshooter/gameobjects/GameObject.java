package org.academiadecodigo.cadetshooter.gameobjects;


import org.academiadecodigo.cadetshooter.Game;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


/**
 * Created by codecadet on 18/10/16.
 */
public class GameObject {

    Rectangle target;
    boolean flag;
    int points;

    public GameObject(Rectangle target, int points) {
        this.target = target;
        this.points = points;
    }

    public void moveInDirection(Direction direction, int distance){

        //we need to move the target in a given direction for a few cycles (the cycles aren't defined here)
        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }


    }

    public void moveUp(int dist) {

        int maxRowsUp = dist <  ? dist : getRow();
        setPos(getCol(), getRow() - maxRowsUp);

    }

    /**
     * Moves the position down
     *
     * @param dist the number of positions to move
     */
    public void moveDown(int dist) {

        int maxRowsDown = dist > getGrid().getRows() - (getRow() + 1) ? getGrid().getRows() - (getRow() + 1) : dist;
        setPos(getCol(), getRow() + maxRowsDown);

    }

    /**
     * Moves the position left
     *
     * @param dist the number of positions to move
     */
    public void moveLeft(int dist) {

        int maxRowsLeft = dist < getCol() ? dist : getCol();
        setPos(getCol() - maxRowsLeft, getRow());

    }

    /**
     * Moves the position right
     *
     * @param dist the number of positions to move
     */
    public void moveRight(int dist) {
        int maxRowsRight = dist > getGrid().getCols() - (getCol() + 1) ? getGrid().getCols() - (getCol() + 1) : dist;
        setPos(getCol() + maxRowsRight, getRow());

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
}
