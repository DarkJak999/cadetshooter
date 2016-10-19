package org.academiadecodigo.cadetshooter.gameobjects;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 18/10/16.
 */
public class GameObject {

    Rectangle target;
    boolean flag;

    public GameObject(Rectangle target) {
        this.target = target;
    }

    public Rectangle getTarget() {
        return target;
    }

    public void setTarget(Rectangle target) {
        this.target = target;
    }

    public boolean used() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
