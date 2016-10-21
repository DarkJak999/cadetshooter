package org.academiadecodigo.cadetshooter.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.cadetshooter.position.*;

/**
 * Created by codecadet on 20/10/16.
 */
public class SimpleGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGridPosition(SimpleGfxGrid grid){
        this((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        this.simpleGfxGrid = grid;
        rectangle = new Rectangle(grid.columnToX(col) + grid.getX(), grid.rowToY(row) + grid.getY(), grid.getCellSize(), grid.getCellSize());
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int iCol = getCol();
        int iRow = getRow();

        super.moveInDirection(direction, distance);

        int dx = getCol() - iCol;
        int dy = getRow() - iRow;

        //System.out.println("moving in direction" + " dx: " + dx  + "  dy: " + dy);

        rectangle.translate(dx, dy);
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {

        super.setColor(color);
        rectangle.setColor(SimpleGfxColor.getColor(color));
    }
}

