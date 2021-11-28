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
 * along with this program.  If not, see @see <a href="http://www.gnu.org/licenses">http://www.gnu.org/licenses</a>.
 */

package lsystem.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import lsystem.turtle.Turtle;
import processing.core.PApplet;


/**
 * A turtle tuned stack with minimal interface
*
 */
public class TurtleStack implements StackInterface {

    private Deque<Turtle> stack;

    /**
     * Stack constructor
     * allows stack instance to be registered with PApplet
     * @param parent PApplet
     */
    public TurtleStack(PApplet parent) {
        parent.registerMethod("dispose", this);
        stack = new ArrayDeque<>();
    }
    // default constructor for testing

    /**
     *
     */
    public TurtleStack() {
        stack = new ArrayDeque<>();
    }

    /**
     * Turtle push
     * @param turtle Turtle
     */
    public void push(Turtle turtle) {
        if (turtle != null) {
            stack.push(turtle);
        }
    }

    /**
     * Turtle push
     * @param turtle Object
     */
    @Override
    public void push(Object turtle) {
        if (turtle != null) {
            stack.push((Turtle)turtle);
        }
    }


    /**
     * Turtle pop
     * @return turtle Turtle
     */
    @Override
    public Turtle pop() {
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
        /**
     * return the version of the library.
     *
     * @return String
     */
    public String version() {
        return VERSION;
    }
}
