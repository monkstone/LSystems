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

import java.util.ArrayDeque;
import java.util.Deque;
import lsystem.turtle.Pen;
import processing.core.PApplet;

/**
 * A Pen tuned stack with minimal interface
 * @author Martin Prout
 */
public class PenStack implements StackInterface{

    private Deque<Pen> stack;

    /**
     * Stack constructor
     * allows stack instance to be registered with PApplet
     * @param parent
     */
    public PenStack(PApplet parent) {
        parent.registerMethod("dispose", this);
        stack = new ArrayDeque<>();
    }
    // default constructor for testing

    /**
     *
     */
    public PenStack() {
        stack = new ArrayDeque<>();
    }

    /**
     * Pen push
     * @param pen
     */
    public void push(Pen pen) {
        if (pen != null) {
            stack.push(pen);
        }
    }

    @Override
    public void push(Object pen) {
        if (pen != null) {
            stack.push((Pen) pen);
        }
    }

    /**
     * Pen pop
     * @return Pen Pen
     */
    @Override
    public Pen pop() {
        return stack.pop();
    }

    /**
     *
     */
    @Override
    public void dispose() {
        stack.clear();
        stack = null;
    }
}

