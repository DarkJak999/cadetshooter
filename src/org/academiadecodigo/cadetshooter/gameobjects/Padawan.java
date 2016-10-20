package org.academiadecodigo.cadetshooter.gameobjects;

import org.academiadecodigo.cadetshooter.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.cadetshooter.position.*;

/**
 * Created by codecadet on 19/10/16.
 */
public class Padawan extends GameObject implements Movable{

    //This class should move and the moving code is done right here. It isn't inherited from it's parent >:3

    public Padawan(Rectangle target, int points, SimpleGfxGrid grid) {

        super(target, points, grid);
    }


    public void moveInDirection(GridDirection direction, int distance) {

        int iCol = super.getPos().getCol();
        int iRow = super.getPos().getRow();

        moveInDirection(direction, distance);

        int dx = super.getPos().getCol() - iCol;
        int dy = super.getPos().getRow() -iRow;

        getTarget().translate(dx, dy);
    }

    @Override
    public void move() {

    }
}
