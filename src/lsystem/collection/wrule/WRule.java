package lsystem.collection.wrule;

/* 
 * Copyright (c) 2011-14 Martin Prout
 * 
 * This demo & library is free software; you can redistribute it and/or
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
/**
 * 
 * @author Martin Prout
 */
public class WRule implements WeightedRule {

    private float weight;
    private String rule;

    /**
     * Two parameter constructor, explicitly set weighting
     * @param rule
     * @param weight
     */
    public WRule(String rule, float weight) {
        this.rule = rule;
        this.weight = (weight > 0) ? weight : 1.0f;
    }

    /**
     * One parameter constructor, default weighting is 1.0f
     * @param rule
     */
    public WRule(String rule) {
        this(rule, 1.0f);
    }

    /**
     * 
     * @return
     */
    @Override
    public float getWeight() {
        return weight;
    }

    /**
     * 
     * @return
     */
    @Override
    public String getValue() {
        return rule;
    }

    @Override
    public String toString() {
        return String.format("     %s\tWeight [%f]", rule, weight);
    }
}

