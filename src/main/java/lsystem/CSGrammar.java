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
 * along with this program.  If not, see <a href="http://www.gnu.org/licenses">http://www.gnu.org/licenses</a>.
 */
package lsystem;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import lsystem.collection.CSList;
import processing.core.PApplet;

/**
 * Implements Grammar interface CSGrammar class that provides convenience method
 * for working with l-systems in particular context sensitive grammars where
 * expected input is a context string. There is ability to ignore certain
 * characters (eg []0-9) when determining context.
 *
*
 */
public class CSGrammar implements Grammar {

    private PApplet parent;
    private String axiom;
    private String production;
    private final CSList rules;
    private StringCharacterIterator lIterator;
    static boolean init = false;

    /**
     * Preferred constructor for processing
     *
     * @param parent PApplet
     * @param axiom String
     */
    public CSGrammar(PApplet parent, String axiom) {
        this.parent = parent;
        setActive();
        this.axiom = axiom;
        rules = new CSList();
        if (init == false) {
            System.err.println("info: CSGrammar LSystem v" + version());
            System.err.println("info: Target " + target());
            init = true;
        }
    }

    /**
     * Default constructor for testing
     *
     * @param axiom String
     */
    public CSGrammar(String axiom) {
        this.axiom = axiom;
        rules = new CSList();
    }

    /**
     * Add non context sensitive rule
     *
     * @param premise char
     * @param rule String
     */
    @Override
    public void addRule(char premise, String rule) {
        rules.addRule(premise, rule);
    }

    /**
     * Add context sensitive rule
     *
     * @param premise String
     * @param rule String
     */
    public void addRule(String premise, String rule) {
        rules.addRule(premise, rule);
    }

    /**
     * Add stochastic rule (not supported here)
     *
     * @param premise char
     * @param rule String
     * @param weight float
     */
    @Override
    public void addRule(char premise, String rule, float weight) {
        throw new RuntimeException("Use StochasticGrammar for weighted rules");
    }

    /**
     * This is the method that returns the appropriate rule according to context
     *
     * @param premise char
     * @param production String
     * @param count int
     * @return rule as StringBuilder
     */
    public StringBuilder getRule(char premise, String production, int count) {
        return rules.getCSRule(premise, production, count);
    }

    /**
     * Using hasKey (to access CSList hasRule)
     *
     * @param premise char
     * @return boolean true if premise is associated with a rule
     */
    @Override
    public boolean hasKey(char premise) {
        return rules.hasRule(premise);
    }

    /**
     * Set the character ignore list
     *
     * @param str ignore list as a String
     */
    public void setIgnoreList(String str) {
        rules.setIgnoreList(str);
    }

    /**
     * Set the character ignore list
     *
     * @param str ignore list as a char[]
     */
    public void setIgnoreList(char[] str) {
   //     rules.setIgnoreList(str);
    }

    /**
     * Private parseRules helper function
     * @param production String
     * @return production String
     */
    private String parseRules(String production) {
        StringBuilder newProduction = new StringBuilder("");
        int count = 0;
        CharacterIterator it = getIterator(production);
        for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
            newProduction.append((hasKey(ch)) ? getRule(ch, production, count) : ch);
            ++count;
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

    private CharacterIterator getIterator(String production) {
        if (lIterator == null) {
            lIterator = new StringCharacterIterator(production);
        } else {
            lIterator.setText(production);
        }
        return lIterator;
    }

    /**
     * Dispose is called on exit clear collections
     */
    @Override
    public void dispose() {
        rules.clear();
        axiom = null;
    }

    /**
     * Return the Grammar as a formatted string Format = Axiom: / Ignored: /
     * Rules:
     *
     * @return description String
     */
    @Override
    public String toString() {
        StringBuilder description = new StringBuilder("Axiom:\n\t");
        description.append(axiom);
        description.append("\n");
        description.append(rules.toStringBuilder());
        return description.toString();
    }

    /**
     * Return the version of the library.
     *
     * @return String
     */
    @Override
    public final String version() {
        return VERSION;
    }

    /**
     * Use "StringBuilder getRule(char premise, String production, int count)"
     *
     * @param premise char
     * @return String
     */
    @Override
    public String getRule(char premise) {
        throw new RuntimeException("Not supported yet. Use StringBuilder"
                + " getRule(char premise, String production, int count)");
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
