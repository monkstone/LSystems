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
 *
 * @author Martin Prout
 */
public interface PenInterface extends TurtleInterface{


    /**
     * line color getter
     * @return length int
     */
    int getColor();

    /**
     * Line color getter
     * @return length float
     */
    float getLength();

    /**
     * Line width getter
     * @return width float
     */
    float getWidth();

    /**
     * line color setter
     * @param col int
     */
    void setColor(int col);

    /**
     * Length setter
     * @param len
     */
    void setLength(float len);

    /**
     * Line width setter
     * @param width float
     */
    void setWidth(float width);

    /**
     *  terminal action of rule
     */
    void drawLine();

    /**
     *
     * @param increment
     */
    void incrementGreen(int increment);
    /**
     *
     * @param repeats
     */
    void turnLeft(int repeats);
    /**
     *
     * @param repeats
     */
    void turnRight(int repeats);
    /**
     *
     * @param adj
     */
    void resizeLength(float adj);

}
