 /* 
 * Copyright (c) 2011-20 Martin Prout
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

package lsystem.collection;

/**
 * RuleList interface to a Collection of L-System rules
*
 */
public interface RuleList {

    /**
     *
     */
    public final String VERSION = "1.1.0";
    /**
     * 
     * @param pre char
     * @param rule String
     */
    public void addRule(char pre, String rule) throws RuntimeException;
    /**
     *
     * @param pre char
     * @param rule String
     * @param weight float
     */
    public void addRule(char pre, String rule, float weight) throws RuntimeException;
    /**
     *
     * @param pre char
     * @return rule String
     */
    public String getRule(char pre);
    /**
     *
     * @param pre char
     * @return true boolean
     */
    public boolean hasRule(char pre);

    /**
     *
     */
    public void clear();

    /**
     *
     * @return as StringBuilder
     */
    public StringBuilder toStringBuilder();
}


