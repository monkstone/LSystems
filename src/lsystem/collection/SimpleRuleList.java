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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * A storage class for non-stochastic rules
 * @author Martin Prout
 */
public class SimpleRuleList implements RuleList{
    private final Set<Character>premises;
    private final Map<Character, String>rules;
    /**
     * 
     */
    public SimpleRuleList(){
        premises = new TreeSet<>();
        rules = new HashMap<>();
    }

    @Override
    public void addRule(char pre, String rule) throws RuntimeException{
        if (this.hasRule(pre))
        {
          throw new RuntimeException("Use StochasticList to store multiple rules");
        }
        premises.add(pre);
        rules.put(pre, rule);
    }
    @Override
    public void addRule(char pre, String rule, float weight) throws RuntimeException{
        throw new RuntimeException("Use StochasticList to store weighted rules");
    }
    @Override
    public String getRule(char pre){
        return rules.get(pre);
    }

    /**
     *
     * @return sb representing LSystem axiom/rules
     */
    @Override
    public StringBuilder toStringBuilder(){
        StringBuilder sb = new StringBuilder("Rules:\n");
        premises.stream().map((ch) -> {
            sb.append(ch);
            return ch;
        }).map((ch) -> {
            sb.append("=>");
            sb.append(this.getRule(ch));
            return ch;
        }).forEach((Character _item) -> {
            sb.append("\n");
        });
        return sb;
    }

       /**
     *
     * Empty collections on dispose
     */
    @Override
    public void clear() {
        premises.clear();
        rules.clear();
    }

    @Override
    public boolean hasRule(char pre){return premises.contains(pre);}
}
