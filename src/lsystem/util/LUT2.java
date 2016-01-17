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

/**
 * A restricted lookup table for fast sine & cosine computations. The table 
 * currently has a fixed precision of 0.25 degrees. Thus might be adequate for 
 * many purposes. There will be errors. Note the reduced lookup up table, 
 * is restricted to the first quadrant of sine. Conditional rules are used to 
 * map to other quadrants and cos. Based on ideas from:-
 * http://en.wikipedia.org/wiki/Lookup_table
 * One annoyance of java is the behaviour of % wrt negative values cf python for 
 * example. A kludge is required to return the complement of 360, which would 
 * not otherwise be required.
 * Use LUT.sin(float deg) & LUT.cos(float deg) for degree entry and 
 * LUT.sinLut(float rad) & LUT.cosLut(float rad) for radians input
 */
package lsystem.util;

/**
 * Lookup table for degree cosine/sine, has a fixed precision ca. 0.25 degrees
 * @author Martin Prout <martin_p@lineone.net>
 */
public final class LUT2 {

    /**
     * LUT for sine values 0.25 degree increments of first quadrant
     */
    static final float[] SIN_LUT = new float[361];
    
    /**
     * 
     */
    public static final String MESSAGE = "Sine/Cosine lookup tables initialized" 
    + " with a fixed\nprecision of ca. 0.25 degrees. NB: degree input.\nor use"+
      " LUT.sinLut(float rad) and or LUT.cosLut(float rad) for radians input\n";
    
    /**
     * 
     */
    private static boolean initialized = false;
    /**
     * 
     */
    public static final float RAD = 57.29578f;
    /**
     * 
     */
    public static final float RAD4 = 229.18312f;
    /**
     * 
     */
    public static final float TAU = 6.2831853f;


    /**
     * Initialise sin table with values (first quadrant only)
     * Save a bit of space by storing as float
     */
    public static void initialize() {
        if (initialized == false){
        for (int i = 0; i <= 360; i++) {
            SIN_LUT[i] = (float) Math.sin(Math.toRadians(i / 4.0));
        }
        initialized = true;
        }
        //System.out.print(message);
    }

    /**
     * Look up sine for the passed angle in degrees.
     * 
     * @param thet degree int
     * @return sine value for theta
     */
    public static float sin(float thet) {
        while (thet < 0) {
            thet += 360; // Needed because negative modulus plays badly in java
        }
        int theta = Math.round(thet * 4) % 1440;
        int y = theta % 360;
        float result = (theta < 360) ? SIN_LUT[y] : (theta < 720)
                ? SIN_LUT[(360 - y)] : (theta < 1080)
                ? -SIN_LUT[y] : -SIN_LUT[(360 - y)];
        return result;
    }

    /**
     * Look up cos for the passed angle in degrees, fixed precision, no better
     * than 0.25 degree with some scope for errors.
     * 
     * @param thet degree float
     * @return sine value for theta
     */
    public static float cos(float thet) {
        while (thet < 0) {
            thet += 360; // Needed because negative modulus plays badly in java
        }
        int theta = Math.round(thet * 4) % 1440;
        int y = theta % 360;
        float result = (theta < 360) ? SIN_LUT[360 - y] : (theta < 720)
                ? -SIN_LUT[y] : (theta < 1080)
                ? -SIN_LUT[360 - y] : SIN_LUT[y];
        return result;
    }
    
        /**
     * Look up sine for the passed angle in radians.
     * 
     * @param thet radians float
     * @return sine value for theta
     */
    public static float sinLut(float thet) {
        while (thet < 0) {
            thet += TAU; // Needed because negative modulus plays badly in java
        }
        int theta = Math.round(thet * RAD4) % 1440;
        int y = theta % 360;
        float result = (theta < 360) ?  SIN_LUT[y] : (theta < 720)
                ? SIN_LUT[(360 - y)] : (theta < 1080)
                ? -SIN_LUT[y] : -SIN_LUT[(360 - y)];
        return result;
    }
    
     /**
     * Look up cos for the passed angle in radians, fixed precision, no better
     * than 0.25 degree with some scope for errors.
     * 
     * @param thet radians float
     * @return sine value for theta
     */
    public static float cosLut(float thet) {
        while (thet < 0) {
            thet += TAU; // Needed because negative modulus plays badly in java
        }
        int theta = Math.round(thet * RAD4) % 1440;
        int y = theta % 360;
        float result = (theta < 360) ? SIN_LUT[360 - y] : (theta < 720)
                ? -SIN_LUT[y] : (theta < 1080)
                ? -SIN_LUT[360 - y] :  SIN_LUT[y];
        return result;
    }
}
