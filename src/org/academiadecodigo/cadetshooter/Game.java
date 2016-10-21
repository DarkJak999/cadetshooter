package org.academiadecodigo.cadetshooter;

import org.academiadecodigo.cadetshooter.gameobjects.Direction;
import org.academiadecodigo.cadetshooter.gameobjects.GameObject;
import org.academiadecodigo.cadetshooter.gameobjects.Padawan;
import org.academiadecodigo.cadetshooter.position.Grid;
import org.academiadecodigo.cadetshooter.position.GridDirection;
import org.academiadecodigo.cadetshooter.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by codecadet on 18/10/16.
 */
public class Game implements MouseHandler {

    private static final int FIX = 25; //This is the pedreiro fix to the simple graphics Y coordinate bug
    private static final int SIZE = 100;
    GameObject[] gameObjects;
    GameObject target;
    SimpleGfxGrid display;
    int score;


    public void init() {

        gameObjects = new GameObject[10];
        Rectangle rect;
        this.score = 0;

        display = new SimpleGfxGrid(1280, 760);
        display.init();

        for (int i = 0; i < gameObjects.length; i++) {
            int randX = RNG.getRandom(0, display.getCols() - SIZE);
            int randY = RNG.getRandom(0, display.getRows() - SIZE);
            rect = new Rectangle(randX, randY, SIZE, SIZE);
            gameObjects[i] = new Padawan(rect, 100, display);
        }
    }

    public void start() throws InterruptedException {

        Mouse m = new Mouse(this);
        int count = 0;
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);


        target = gameObjects[0];
        target.getTarget().fill();

        while(true)
            target.moveInDirection(GridDirection.DOWN, 1);

        /*

        for (int i = 0; i < gameObjects.length; i++) {

            count = 0;
            target = gameObjects[i];
            target.getTarget().fill();

            target.moveInDirection(GridDirection.RIGHT,5);

            System.out.println(count);
            Thread.sleep(2000);
            target.getTarget().delete();


            System.out.println(score);
        }

        */
    }

    public void mouseClicked(MouseEvent e) {


        //se mouse dentro quadrado imprime cenas fixes

        //dentro do quadrado significa que o x do rato está entre o x do quadrado

        if (e.getX() > target.getTarget().getX() && e.getX() < (target.getTarget().getX() + target.getTarget().getWidth())

                && e.getY()+FIX > target.getTarget().getY() + FIX && e.getY() + FIX < (target.getTarget().getY() + FIX + target.getTarget().getHeight())) {
            increaseScore();
            target.setUsed(true);

            target.getTarget().delete();
            System.out.println("Clicked on target");
        } else {
            System.out.println("Clicked out of target");


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

    public SimpleGfxGrid getDisplay() {
        return display;
    }

    public void setDisplay(SimpleGfxGrid display) {
        this.display = display;
    }
}
