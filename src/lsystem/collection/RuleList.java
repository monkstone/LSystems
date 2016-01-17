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

package lsystem.collection;

/**
 * RuleList interface to a Collection of L-System rules
 * @author Martin Prout
 */
public interface RuleList {

    /**
     *
     */
    public final String VERSION = "1.1.0";
    /**
     * 
     * @param pre
     * @param rule
     * @throws RuntimeException
     */
    public void addRule(char pre, String rule) throws RuntimeException;
    /**
     *
     * @param pre
     * @param rule
     * @param weight
     * @throws RuntimeException
     */
    public void addRule(char pre, String rule, float weight) throws RuntimeException;
    /**
     *
     * @param pre
     * @return rule
     */
    public String getRule(char pre);
    /**
     *
     * @param pre
     * @return true
     */
    public boolean hasRule(char pre);

    /**
     *
     */
    public void clear();

    /**
     *
     * @return
     */
    public StringBuilder toStringBuilder();
}


