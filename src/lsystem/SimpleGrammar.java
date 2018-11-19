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
package lsystem;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import lsystem.collection.RuleList;
import lsystem.collection.SimpleRuleList;
import processing.core.PApplet;

/**
 * Implements Grammar interface SimpleGrammar class that provides convenience
 * method for working with l-systems
 *
*
 */
public class SimpleGrammar implements Grammar {

    private String axiom;
    private String production;
    private final RuleList rules;
    private StringCharacterIterator lIterator;
    PApplet parent;
    static boolean init = false;

    // preferred constructor?
    /**
     *
     * @param parent PApplet
     * @param axiom String
     */
    public SimpleGrammar(PApplet parent, String axiom) {
        this.parent = parent;
        setActive();
        this.axiom = axiom;
        rules = new SimpleRuleList();
        if (init == false){
        System.err.println("info: SimpleGrammar LSystem v" + version());
        System.err.println("info: Target " + target());
        SimpleGrammar.init = true;
        }
    }

    /**
     * Default constructor for testing
     *
     * @param axiom String
     */
    public SimpleGrammar(String axiom) {
        this.axiom = axiom;
        rules = new SimpleRuleList();
    }

    @Override
    public void addRule(char premise, String rule) {
        rules.addRule(premise, rule);
    }

    @Override
    public void addRule(char premise, String rule, float weight) {
        throw new RuntimeException("Use StochasticGrammar for weighted rules");
    }

    @Override
    public String getRule(char premise) {
        return rules.getRule(premise);
    }

    @Override
    public boolean hasKey(char premise) {
        return rules.hasRule(premise);
    }

    /**
     * Private parseRules helper function
     * @param production String
     * @return production String
     */
    private String parseRules(String production) {
        StringBuilder newProduction = new StringBuilder(production.length() * 4);
        CharacterIterator it = getIterator(production);
        for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
            newProduction.append((hasKey(ch)) ? getRule(ch) : ch);
        }
        return newProduction.toString();
    }

    @Override
    public void generateGrammar(int repeats) {
        String prod = axiom;
        for (int i = 0; i < repeats; i++) {
            prod = parseRules(prod);
        }
        this.production = prod;
    }

    @Override
    public void generateGrammar() {
        generateGrammar(0);
    }

    @Override
    public CharacterIterator getIterator() {
        if (lIterator == null) {
            lIterator = new StringCharacterIterator(production);
        } else {
            lIterator.setText(production);
        }
        return lIterator;
    }



    /**
     * Makes the CharacterIterator available internally/externally Create a new
     * instance if none exists otherwise re-use existing instance
     *
     * @param production String
     * @return lIterator the grammar CharacterIterator
     */
   
    private CharacterIterator getIterator(String production) {
        if (lIterator == null) {
            lIterator = new StringCharacterIterator(production);
        } else {
            lIterator.setText(production);
        }
        return lIterator;
    }

    @Override
    public void dispose() {
        rules.clear();
        axiom = null;
    }

    /**
     *
     * @return grammar as String
     */
    @Override
    public String toString() {
        StringBuilder description = new StringBuilder("Axiom: ");
        description.append(axiom);
        description.append("\n");
        description.append(rules.toStringBuilder());
        return description.toString();
    }

    /**
     * return the version of the library.
     *
     * @return String
     */
    @Override
    public final String version() {
        return VERSION;
    }
    
    /**
     * return the target processing version of the library.
     *
     * @return String
     */
    @Override
    public final String target() {
        return TARGET;
    }
    
    private void setActive() {
        parent.registerMethod("dispose", this);
    }
}
