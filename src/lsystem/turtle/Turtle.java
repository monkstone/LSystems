 /* 
 * Copyright (c) 2011-16 Martin Prout
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package lsystem.turtle;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * A turtle to store position and direction
 * @author Martin Prout
 */
public class Turtle implements Cloneable, TurtleInterface {

    private float x, y, angle;

    /**
     * Copy Constructor
     * @param turtle
     */
    public Turtle(Turtle turtle) {
        this.x = turtle.getX();
        this.y = turtle.getY();
        this.angle = turtle.getTheta();
    }


    /**
     * Constructor
     * @param x
     * @param y
     * @param angle
     */
    public Turtle(float x, float y, float angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    @Override
    @SuppressWarnings("CloneDeclaresCloneNotSupported")
    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Turtle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * X position getter
     * @return x position float
     */
    @Override
    public float getX() {
        return x;
    }

    /**
     * Y position getter
     * @return y position float
     */
    @Override
    public float getY() {
        return y;
    }

    /**
     * Angle getter
     * @return angle float
     */
    @Override
    public float getTheta() {
        return angle;
    }

    /**
     * X position setter
     * @param x position float
     */
    @Override
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Y position setter
     * @param y position float
     */
    @Override
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Angle setter
     * @param theta
     */
    @Override
    public void setTheta(float theta) {
        this.angle = theta;
    }
}
