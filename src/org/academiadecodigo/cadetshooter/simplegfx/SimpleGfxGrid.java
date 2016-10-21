package org.academiadecodigo.cadetshooter.simplegfx;

import org.academiadecodigo.cadetshooter.position.Grid;
import org.academiadecodigo.cadetshooter.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.cadetshooter.position.*;

/**
 * Created by codecadet on 20/10/16.
 */
public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 10;
    private int cols;
    private int rows;
    private Rectangle display;


    public SimpleGfxGrid(int cols, int rows){

        this.cols = cols;
        this.rows = rows;
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {
        display = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        display.draw();

    }

    public void delete(){

        display.delete();
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return this.cols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return this.rows;
    }

    /**
     * Obtains the width of the grid in pixels
     * @return the width of the grid
     */
    public int getWidth() {
        return cols;
    }

    /**
     * Obtains the height of the grid in pixels
     * @return the height of the grid
     */
    public int getHeight() {
        return rows;
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     * @return the x position of the grid
     */
    public int getX() {

        return PADDING;
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     * @return the y position of the grid
     */
    public int getY() {

        return PADDING;
    }

    /**
     * Obtains the pixel width and height of a grid position
     * @return
     */
    public int getCellSize() {

        return CELL_SIZE;
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition() {

        return new SimpleGridPosition(this);
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {


        return new SimpleGridPosition(col, row, this);
    }

    /**
     * Show a specific grid position on screen
     *
     * @param pos the grid position to show
     */
    public void show(GridPosition pos) {

        Rectangle temp = new Rectangle(pos.getCol(), pos.getRow(), CELL_SIZE, CELL_SIZE);
        temp.setColor(Color.RED);
        temp.fill();
    }



    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {

        return row * CELL_SIZE;
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {

        return column * CELL_SIZE;
    }
}
