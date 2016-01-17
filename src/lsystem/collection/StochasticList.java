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

import java.util.*;
import lsystem.collection.wrule.WRule;
import lsystem.collection.wrule.WeightedRule;

/**
 * A storage class for weighted rules holds/implements the weighted selection
 * logic (now as inner class since version 0.74 [24 November 2011-14])
 *
 * @author Martin Prout
 */
public class StochasticList implements RuleList {

    private final Set<Character> premises;
    private final Map<Character, List<WeightedRule>> weightedRules;
    private WeightedRuleChooser chooser;

    /**
     * Default Constructor, initialises collections and instance of 
     * stochastic rule chooser
     */
    public StochasticList() {
        premises = new HashSet<>();
        weightedRules = new HashMap<>();
        chooser = new WeightedRuleChooser();
    }

    @Override
    public void addRule(char pre, String rule) {
        addRule(pre, rule, 1.0f);
    }

    @Override
    public void addRule(char pre, String rule, float weight) {
        if (premises.contains(pre)) // we store multiple rules in existing List
        {
            List<WeightedRule> temp = weightedRules.get(pre);
            temp.add(new WRule(rule, weight));
        } else { // we create a new List of weighted rules
            List<WeightedRule> temp = new ArrayList<>();
            temp.add(new WRule(rule, weight));
            weightedRules.put(pre, temp);
        }
        premises.add(pre);
    }
    
    /**
     * Uses inner class chooser instance to handle random choice logic
     * @param weightedRules List of WeightedRule
     * @return rule String
     */
    private String getStochasticRule(List<WeightedRule> weightedRules) {
        WeightedRule rule = chooser.chooseOnWeight(weightedRules);
        return rule.getValue();
    }

    @Override
    public String getRule(char pre) {
        List<WeightedRule> temp = weightedRules.get(pre);
        return getStochasticRule(temp);
    }

    @Override
    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder("Rules:\n");
        premises.stream().map((Character premis) -> {
            sb.append(premis);
            return premis;
        }).forEach((Character premis) -> {
            sb.append("=>\n");
            weightedRules.get(premis).stream().map((rule) -> {
                sb.append(rule.toString());
                return rule;
            }).forEach((_item) -> {
                sb.append('\n');
            });
        });
        return sb;
    }
    
    /**
     * Inner class, to handle chooser logic
     */

    static class WeightedRuleChooser {

        public WeightedRule chooseOnWeight(List<WeightedRule> rules) {
            float total = 0.0f;
            total = rules.stream().map((wr) -> wr.getWeight()).reduce(total, (accumulator, _item) -> accumulator + _item);
            double r = Math.random() * total;
            float cumulative = 0.0f;
            for (WeightedRule wr : rules) {
                cumulative += wr.getWeight();
                if (cumulative >= r) {
                    return wr;
                }
            }
            throw new RuntimeException("Random rule chooser failure");
        }
    }

    /**
     * Dereference chooser and empty the
     * collections, is called by dispose
     */
    @Override
    public void clear() {
        chooser = null;
        premises.clear();
        weightedRules.clear();
    }

    @Override
    /**
     * @param pre key character
     * @return boolean
     */
    public boolean hasRule(char pre) {
        return premises.contains(pre);
    }
}
