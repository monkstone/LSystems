/* 
 * Copyright (c) 2011-18 Martin Prout
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

package lsystem.collection.csrule;

/**
 * A helper class for context sensitive LSystem rules
 * helps to decode the context elements and extracts the premis character
 *
*
 */
public class ContextRule {

    private int idx = 0;       // direction of context -1 = before, 1 = after
    private final String keyHash;   // hash to store rules by
    private final char premis;   // character to replace by rule
    private final char context;  // character that is context

    /**
     * Constructor for ContextRule, holds all the logic so that only relevant data is
     * stored
     * @param context String
     */
    public ContextRule(String context) {
        this.keyHash = context;
        this.idx = ('<' == context.charAt(1)) ? -1 : ('>' == context.charAt(1)) ? 1 : 0;
        this.premis = context.charAt(2);
        this.context = context.charAt(0);
    }

    /**
     * Returns the value of context char.
     * character that determines context
     * @return this.context char
     */
    public char getContextChar() {
        return this.context;
    }

    /**
     * Returns the value of keyHash.
     *
     * @return string to use as key in cs rule hash table
     */
    public String getKeyHash() {
        return keyHash;
    }

    /**
     * Returns the value of premis.
     * @return premis char
     */
    public char getPremis() {
        return premis;
    }

    /**
     * Returns the value of context index.
     * determines the direction to search for context char
     * @return idx int
     */
    public int getIndex() {
        return idx;
    }
    
   /**
    * @return contextRule as String
    */
    @Override
    public String toString(){
        return keyHash;
    }
}
