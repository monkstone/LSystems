/* 
 * Copyright (c) 2011/13 Martin Prout
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

package lsystem;
import java.text.CharacterIterator;
/**
 * Grammar interface for Lindenmayer Systems
 * @author Martin Prout
 */
public interface Grammar {
    
    /**
     * 
     */
    public final String VERSION = "1.0.0";
    
    /**
     * 
     */
    public final String TARGET = "processing-2.1";
    
    

    /**
     * add unweighted rule
     * @param premise
     * @param rule
     */
    void addRule(char premise, String rule);

    /**
     * add weighted rule for stochastic L-System
     * @param premise
     * @param rule
     * @param weight
     */
    void addRule(char premise, String rule, float weight);
    
    /**
     * Creates production from axiom, rules and no of
     * generations
     * @param repeats
     */
    void generateGrammar(int repeats);

    /**
     * Useful for testing no generations
     */
    void generateGrammar();
    
 /**
  * 
  * Makes the CharacterIterator available internally/externally
  * Create a new instance if none exists otherwise re-use existing instance
  * @return lIterator the grammar CharacterIterator
  */
    
    CharacterIterator getIterator();

    /**
     *
     */
    void dispose();

    /**
     *
     * @param premise
     * @return rule
     */
    String getRule(char premise);

    /**
     *
     * @param premise
     * @return true
     */
    boolean hasKey(char premise);

    /**
     * return the version of the library.
     *
     * @return String
     */
    String version();
    
    /**
     * return the target processing version of the library.
     *
     * @return String
     */
    String target();
}
