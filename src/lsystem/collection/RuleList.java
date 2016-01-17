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

package lsystem.collection;

/**
 * RuleList interface to a Collection of L-System rules
 * @author Martin Prout
 */
public interface RuleList {

    /**
     *
     */
    public final String VERSION = "1.0.0";
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


