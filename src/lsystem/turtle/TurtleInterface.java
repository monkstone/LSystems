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
public interface TurtleInterface{

    /**
     *
     */
    public final String VERSION = "1.0.0";

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
     * @param theta
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
