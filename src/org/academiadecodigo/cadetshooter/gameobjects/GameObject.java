package org.academiadecodigo.cadetshooter.gameobjects;


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

    public void moveInDirection(){

        //we need to move the target in a given direction for a few cycles (the cycles aren't defined here)



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
}
