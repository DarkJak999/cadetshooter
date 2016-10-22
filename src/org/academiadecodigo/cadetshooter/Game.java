package org.academiadecodigo.cadetshooter;

import org.academiadecodigo.cadetshooter.gameobjects.Direction;
import org.academiadecodigo.cadetshooter.gameobjects.GameObject;
import org.academiadecodigo.cadetshooter.gameobjects.Padawan;
import org.academiadecodigo.cadetshooter.position.Grid;
import org.academiadecodigo.cadetshooter.position.GridDirection;
import org.academiadecodigo.cadetshooter.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import java.awt.*;

/**
 * Created by codecadet on 18/10/16.
 */
public class Game implements MouseHandler, KeyboardHandler {




    private static final int FIX = 25; //This is the pedreiro fix to the simple graphics Y coordinate bug
    private static final int SIZE = 100;
    private GameObject target;
    private SimpleGfxGrid display;
    private int score;
    private int lives;


    void init() {

        Rectangle rect;
        this.score = 0;

        display = new SimpleGfxGrid(1280, 760);
        display.init();
        this.lives = 10;



    }

    public void startMenu(){
        Keyboard k = new Keyboard(this);
        KeyboardEvent start = new KeyboardEvent();
        KeyboardEvent end = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_SPACE);
        end.setKey(KeyboardEvent.KEY_ESC);
        start.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        end.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(start);
        k.addEventListener(end);
    }

    public void start() throws InterruptedException {

        Mouse m = new Mouse(this);
        int count = 0;
        int howManyLives = lives;
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);
        Keyboard k = new Keyboard(this);
        KeyboardEvent start = new KeyboardEvent();
        KeyboardEvent end = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_SPACE);
        end.setKey(KeyboardEvent.KEY_ESC);
        start.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        end.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(start);
        k.addEventListener(end);


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


    public void  keyPressed (KeyboardEvent k) throws InterruptedException {




        }

    @Override
    public void keyReleased(KeyboardEvent k) throws InterruptedException {

        switch (k.getKey()){
            case KeyboardEvent.KEY_SPACE:

                System.out.println("space");
                this.start();
                break;

            case KeyboardEvent.KEY_ESC:
                System.out.println("esc");
                System.exit(0);
                // end game
                break;

        }


    }


    public void increaseScore() {
        if (!target.isUsed()) {
            this.score += target.getPoints();
        }

    }

    public GameObject createGameObject() {


        //randomize a padawan, get it onto gObj and return the damn thing

        if(score < 100){
            int randomNumber = RNG.getRandom(0,11);
            System.out.println(randomNumber);
            return randomPadawan(randomNumber, 15);
        }
        if(score < 200){
            System.out.println("next level, level 2");
            int randomNumber = RNG.getRandom(0,11);
            System.out.println(randomNumber);
            return randomPadawan(randomNumber, 25);
        }
        if(score < 300){
            System.out.println("next level, level 3");
            int randomNumber = RNG.getRandom(0,35);
            System.out.println(randomNumber);
            return randomPadawan(randomNumber, 30);
        }
        if(score < 400) {
            System.out.println("next level, level 4");
            int randomNumber = RNG.getRandom(0,35);
            System.out.println(randomNumber);
            return randomPadawan(randomNumber, 35);
        }
        if(score < 500){
            System.out.println("next level, level 5");
            int randomNumber = RNG.getRandom(0,50);
            System.out.println(randomNumber);
            return randomPadawan(randomNumber, 40);
        }
        if(score < 600){
            System.out.println("next level, level 6");
            int randomNumber = RNG.getRandom(0,50);
            System.out.println(randomNumber);
            return randomPadawan(randomNumber, 45);
        }
        if(score < 700){
            System.out.println("next level, level 7");
            int randomNumber = RNG.getRandom(0,90);
            System.out.println(randomNumber);
            return randomPadawan(randomNumber, 50);
        }
        if(score < 800){
            System.out.println("next level, level 8");
            int randomNumber = RNG.getRandom(0,90);
            System.out.println(randomNumber);
            return randomPadawan(randomNumber, 55);
        }
        if(score < 900){
            System.out.println("next level, level 9");
            int randomNumber = RNG.getRandom(0,100);
            System.out.println(randomNumber);
            return randomPadawan(randomNumber, 55);
        }
        else{
            System.out.println("next level, level 10");
            int randomNumber = RNG.getRandom(0,100);
            System.out.println(randomNumber);
            return randomPadawan(randomNumber, 60);
        }
    }

    public GameObject randomPadawan(int random, int speed){

        int randX = RNG.getRandom(0, display.getCols() - SIZE);
        int randY = RNG.getRandom(0, display.getRows() - SIZE);
        Rectangle rekt = new Rectangle(randX,randY, SIZE, SIZE);

        if(random <= 10){
            //padawan (rectange, points, grid, speed, time, distance)
            System.out.println("here 1");
            return new Padawan(rekt, 10 ,display,speed, 50, 30);
        }
        else if(random >= 11 && random <= 34){
            System.out.println("here 2");
            return new Padawan(rekt, 15, display, speed, 50, 60);
        }
        else if(random >= 35 && random <= 49){
            System.out.println("here 3");
            return new Padawan(rekt, 25, display, speed, 50, 60);
        }
        else if(random >= 50 && random <= 89){
            System.out.println("here 4");
            return new Padawan(rekt, 30, display, speed, 50, 60);
        }
        else if(random >= 90 && random < 101){
            System.out.println("here 5 ");
            return new Padawan(rekt, 50, display, 70, 50, 60);
        }

        System.out.println("fuuuuuuuuuuuuuuck");
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
