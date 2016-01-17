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

