 /* 
 * Copyright (c) 2011-18 Martin Prout
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
 * along with this program.  If not, see @see <a href="http://www.gnu.org/licenses">http://www.gnu.org/licenses</a>.
 */

package lsystem.turtle;

/**
 *
*
 * @author Martin Prout
 */
public interface TurtleInterface{

    /**
     *
     */
    public final String VERSION = "1.1.0";

    /**
     *
     * @return copy
     */
    Object clone();

    /**
     * Angle getter
     * @return angle float
     */
    float getTheta();

    /**
     * X position getter
     * @return x position float
     */
    float getX();

    /**
     * Y position getter
     * @return y position float
     */
    float getY();

    /**
     * Angle setter
     * @param theta float
     */
    void setTheta(float theta);

    /**
     * X position setter
     * @param x position float
     */
    void setX(float x);

    /**
     * Y position setter
     * @param y position float
     */
    void setY(float y);

}
