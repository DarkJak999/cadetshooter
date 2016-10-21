package org.academiadecodigo.cadetshooter.gameobjects;

import org.academiadecodigo.cadetshooter.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.cadetshooter.position.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 19/10/16.
 */
public class Padawan extends GameObject implements Movable{

    //This class should move and the moving code is done right here. It isn't inherited from it's parent >:3

    public Padawan(Rectangle target, int points, SimpleGfxGrid grid, int speed, int time, int distance) {

        super(target, points, grid, speed, time, distance);
    }

    public void moveInDirection(GridDirection direction, int distance) {

        int iCol = super.getPos().getCol();
        int iRow = super.getPos().getRow();

        getPos().moveInDirection(direction, distance);

        int dx = super.getPos().getCol() - iCol;
        int dy = super.getPos().getRow() - iRow;

        getTarget().translate(dx, dy);
    }

    @Override
    public void move(GridDirection direction, int distance) {

    }

    public void myMove(GridDirection direction, int distance){

        int count = 0;

        int iX = getTarget().getX();
        int iY = getTarget().getY();

        while(count < distance){

            getPos().moveInDirection(direction, 5);

            int dx = getTarget().getX() - iX;
            int dy = getTarget().getY() - iY;

            getTarget().translate(dx, dy);

            iX = getTarget().getX();
            iY = getTarget().getY();

            count++;
        }
    }


}
