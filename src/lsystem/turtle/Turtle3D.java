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
 * @author sid
 */
public interface Turtle3D {

    /**
     * 
     */
    public final String VERSION = "1.1.0";

    /**
     * Any implementing classes should move forward by distance without drawing
     * @param distance float
     */
    void forward(float distance);
    
    
    /**
     *
     * @param distance float
     * @param r1 float
     * @param r2 float
     * @param level int
     
     
     */
    void drawRod(float distance, float r1, float r2, int level);
    /**
     * Any implementing classes should draw something eg. line rod box etc
     * @param distance float
     * @param level int level of detail for cone/cylinder sphere
     */
    void draw(float distance, int level);

    /**
     * Any implementing classes should draw something eg. line rod box etc
     * @param distance float
     */
    void draw(float distance);

    /**
     * Up and Down to non aeronautical
     * @param angle float degrees/radians int/float
     */
    void pitch(int angle);

    /**
     * 
     * @param angle float
     */
    void pitch(float angle);

    /**
     * Rotate about the axis (of the direction we are moving in)
     * @param angle float degrees/radians int/float
     */
    void roll(int angle);

    /**
     * 
     * @param angle float
     */
    void roll(float angle);

    /**
     * Left and Right turn to non aeronautical
     * @param angle float degrees/radians int/float
     */
    void yaw(int angle);

    /**
     * 
     * @param angle float
     */
    void yaw(float angle);
}
