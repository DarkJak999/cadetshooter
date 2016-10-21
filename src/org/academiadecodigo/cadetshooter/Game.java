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
    private GameObject target;
    private SimpleGfxGrid display;
    private int score;
    private int lives;


    public void init() {

        Rectangle rect;
        this.score = 0;

        display = new SimpleGfxGrid(1280, 760);
        display.init();
        this.lives = 10;

    }

    public void start() throws InterruptedException {

        Mouse m = new Mouse(this);
        int count = 0;
        int howManyLives = lives;
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);


        while(lives > 0) {

            target = createGameObject();


            while(!target.isUsed()){

                count = 0;

                target.getTarget().fill();

                while(count < target.getDistance()){

                    target.moveInDirection(target.getCurrentDirection(), 1);

                    Thread.sleep(target.getTime());

                    if(target.isUsed())
                        break;

                    count++;
                }
                target.getTarget().delete();
                target.setUsed(true);
            }

            if(target.isClicked())
                continue;
            lives--;
            howManyLives--;
            System.out.println("here " + howManyLives);


        }

        System.out.println(score);
        System.out.println("Game Over");
    }


    public void mouseClicked(MouseEvent e) {


        //se mouse dentro quadrado imprime cenas fixes

        //dentro do quadrado significa que o x do rato está entre o x do quadrado

        if (e.getX() > target.getTarget().getX() && e.getX() < (target.getTarget().getX() + target.getTarget().getWidth())

                && e.getY() + FIX > target.getTarget().getY() + FIX && e.getY() + FIX < (target.getTarget().getY() + FIX + target.getTarget().getHeight())) {
            increaseScore();
            target.setUsed(true);
            target.setClicked(true);

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

    public GameObject createGameObject() {


        GameObject gObj;

        int randX = RNG.getRandom(0, display.getCols() - SIZE);
        int randY = RNG.getRandom(0, display.getRows() - SIZE);
        Rectangle rekt = new Rectangle(randX,randY, SIZE, SIZE);

        //randomize a padawan, get it onto gObj and return the damn thing


        if(score < 100){
            //Padawan(target, points, grid, speed, time, distance
            return new Padawan(rekt, 10 ,display,20, 50, 30);
        }
        if(score < 200){
            System.out.println("next level, level 2");
            return new Padawan(rekt, 10, display, 20, 50, 60);
        }
        if(score < 300){
            System.out.println("next level, level 3");
            return new Padawan(rekt, 15, display, 30, 50, 60);
        }
        if(score < 400) {
            System.out.println("next level, level 4");
            return new Padawan(rekt, 15, display, 35, 50, 60);
        }
        if(score < 500){
            System.out.println("next level, level 5");
            return new Padawan(rekt, 20, display, 40, 50, 60);
        }
        if(score < 600){
            System.out.println("next level, level 6");
            return new Padawan(rekt, 20, display, 45, 50, 60);
        }
        if(score < 700){
            System.out.println("next level, level 7");
            return new Padawan(rekt, 25, display, 50, 50, 60);
        }
        if(score < 800){
            System.out.println("next level, level 8");
            return new Padawan(rekt, 25, display, 55, 50, 60);
        }
        if(score < 900){
            System.out.println("next level, level 9");
            return new Padawan(rekt, 30, display, 60, 50, 60);
        }
        if(score < 1000){
            System.out.println("next level, level 10");
            return new Padawan(rekt, 30, display, 65, 50, 60);
        }
        System.out.println("morri");
        return null;
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
