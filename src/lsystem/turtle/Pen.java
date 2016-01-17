/* 
 * Copyright (c) 2011-14 Martin Prout
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * http://creativecommons.org/licenses/LGPL/2.1/
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */


package lsystem.turtle;

/**
 * Pen class extends Turtle to include width, length and color parameters
 * includes a drawLine function that calls on PApplet line(x, y, x1, y2);
 * @author Martin Prout
 */

import processing.core.PApplet;

/**
 *
 * @author Martin Prout
 */
public class Pen extends Turtle implements PenInterface {

    float len, width;
    int col;
    PApplet parent;
    /**
     * Copy Constructor for pen
     * @param pen
     */
    public Pen(Pen pen) {
        super(pen.getX(), pen.getY(), pen.getTheta());
        this.parent = pen.getParent();
        this.len = pen.getLength();
        this.col = pen.getColor();
        this.width = pen.getWidth();
    }

    /**
     * Constructor
     * @param parent
     * @param xpos
     * @param ypos
     * @param direction
     * @param len
     * @param col
     * @param width
     */
    public Pen(PApplet parent, float xpos, float ypos, float direction, float len, int col, float width) {
        super(xpos, ypos, direction);
        this.parent = parent;
        this.len = len;
        this.col = col;
        this.width = width;
    }

    /**
     *
     * @param parent
     * @param xpos
     * @param ypos
     * @param direction
     * @param len
     * @param col
     */
    public Pen(PApplet parent, float xpos, float ypos, float direction, float len, int col) {
        super(xpos, ypos, direction);
        this.parent = parent;
        this.len = len;
        this.col = col;
        this.width = 1.0f;
    }

    /**
     *
     * @param parent
     * @param xpos
     * @param ypos
     * @param direction
     * @param len
     */
    public Pen(PApplet parent, float xpos, float ypos, float direction, float len) {
        super(xpos, ypos, direction);
        this.parent = parent;
        this.len = len;
        this.col = 0;  // default color black (white -1)
        this.width = 1.0f;
    }

    private PApplet getParent(){
        return this.parent;
    }

    /**
     * Line color getter
     * @return length float
     */
    @Override
    public float getLength() {
        return len;
    }

     /**
     * line color getter
     * @return length int
     */
    @Override
    public int getColor() {
        return col;
    }

    /**
     * Line width getter
     * @return width float
     */
    @Override
    public float getWidth() {
        return width;
    }

    /**
     * Line width setter
     * @param width float
     */
    @Override
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * line color setter
     * @param col int
     */
    @Override
    public void setColor(int col) {
        this.col = col;
    }

    /**
     * Length setter
     * @param len
     */
    @Override
    public void setLength(float len) {
        this.len = len;
    }

    /**
     * Facility to change element length
     * @param factor
     */
    @Override
    public void resizeLength(float factor){
        this.len *= factor;
    }

    /**
     * With plants in mind using bit shift to increment green
     * @param increment
     */
    @Override
    public void incrementGreen(int increment){
        int green = this.col  >> 8 & 0xFF;
        green += increment;
        this.col |= green << 8;
    }

    /**
     * Evaluate number of repeats and change value of theta
     * @param repeats
     */
    @Override
    public void turnLeft(int repeats){
        setTheta(getTheta() + (float)Math.PI/180 * 34.9f * repeats);
    }
    /**
     *  Evaluate number of repeats and change value of theta
     * @param repeats
     */
    @Override
    public void turnRight(int repeats){
        setTheta(getTheta() - (float)Math.PI/180 * 34.9f * repeats);

    }


    /**
     *  Object orientated way of drawing a line, side effect is to
     *  update the current position
     **/
    @Override
    public void drawLine(){
       // parent.strokeWeight(getWidth());
        parent.stroke(this.col);
        float x0 = getX();
        float y0 = getY();
        float x1 = (float)(x0 - getLength()*Math.cos(getTheta()));
        float y1 = (float)(y0 - getLength()*Math.sin(getTheta()));
        parent.line(x0, y0, x1, y1);
        this.setX(x1);
        this.setY(y1);
    }
}
