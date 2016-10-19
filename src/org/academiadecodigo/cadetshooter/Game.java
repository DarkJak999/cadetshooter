package org.academiadecodigo.cadetshooter;

import org.academiadecodigo.cadetshooter.gameobjects.GameObject;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by codecadet on 18/10/16.
 */
public class Game implements MouseHandler {

    private static final int SIZE = 100;
    GameObject[] gameObjects;
    GameObject target;
    Rectangle display;
    int score;


    public void init() {

        gameObjects = new GameObject[10];
        Rectangle rect;
        this.score = 0;

        display = new Rectangle(0, 0, 1280, 760);

        for (int i = 0; i < gameObjects.length; i++) {
            int randX = RNG.getRandom(0, display.getWidth() - SIZE);
            int randY = RNG.getRandom(0, display.getHeight() - SIZE);
            rect = new Rectangle(randX, randY, SIZE, SIZE);
            gameObjects[i] = new GameObject(rect, 100);
        }
    }

    public void start() throws InterruptedException {

        Mouse m = new Mouse(this);
        int count = 0;
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        display.draw();

        for (int i = 0; i < gameObjects.length; i++) {

            count = 0;
            target = gameObjects[i];
            target.getTarget().fill();
            while (count < 50) {
                target.moveInDirection();
                Thread.sleep(100);
                count++;
            }
            //Thread.sleep(2000);
            target.getTarget().delete();


            System.out.println(score);
        }
    }

    public void mouseClicked(MouseEvent e) {


        //se mouse dentro quadrado imprime cenas fixes

        //dentro do quadrado significa que o x do rato está entre o x do quadrado

        if (e.getX() > target.getTarget().getX() && e.getX() < (target.getTarget().getX() + target.getTarget().getWidth())

                && e.getY() > target.getTarget().getY() && e.getY() < (target.getTarget().getY() + target.getTarget().getHeight())) {
            increaseScore();
            target.setUsed(true);

            target.getTarget().delete();
            System.out.println("Very nice");
        } else {
            System.out.println("Fuck this shit");


        }
    }

    public void increaseScore() {
        if (!target.isUsed()) {
            this.score += target.getPoints();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        //System.out.println(e);

    }

    public Rectangle getDisplay() {
        return display;
    }

    public void setDisplay(Rectangle display) {
        this.display = display;
    }
}
