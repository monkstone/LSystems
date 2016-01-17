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

import java.util.ArrayDeque;
import java.util.Deque;
import lsystem.turtle.Turtle;
import processing.core.PApplet;


/**
 * A turtle tuned stack with minimal interface
 * @author Martin Prout
 */
public class TurtleStack implements StackInterface {

    private Deque<Turtle> stack;

    /**
     * Stack constructor
     * allows stack instance to be registered with PApplet
     * @param parent
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
