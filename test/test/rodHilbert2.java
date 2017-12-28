package test;

import java.text.CharacterIterator;
import lsystem.Grammar;
import lsystem.SimpleGrammar;
import lsystem.turtle.RodTurtle;
import lsystem.util.ArcBall;
import lsystem.util.LUT;
import processing.core.PApplet;

/**
 * 
*
 */
public class rodHilbert2 extends PApplet {

    /**
     * A 3D LSystem example with a SimpleGrammar Features use of a my new
     * Turtle3D interface (RodTurtle is currently only implementing class) There
     * is a fixed precision of 1 degree in my lookup tables(note degree rather
     * than radian input for lookup tables) so makes sense to set number of
     * sides of "cylinder" accordingly This LSystem library is available at
     * Kenai version 0.8.0
     * http://kenai.com/projects/l-system-utilities/downloads works best with
     * new opengl (formerly opengl2, else there is clipping)
     */

    /* 
     * Copyright (c) 2011-17 Martin Prout
     * 
     * This demo and library is free software; you can redistribute it and/or
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
    ArcBall arcball;
    Grammar grammar;
    RodTurtle turtle;
    float distance = 300;  // reduce size or increase depth for old opengl (see above)
    int depth = 3;
// adjust centre of hilbert
    float[] adjust = {
        0.0f, 0.5f, 1.5f, 3.5f, 7.5f
    };
// adjust resolution with depth (ie decrease)
    int[] detail = {
        36, 24, 18, 15, 12
    };
    int THETA = 90;   // use int for angle in degrees or float for radians
    int PHI = 90;
    String production = "";
    
    @Override
    public void settings() {
        size(800, 600, P3D);
    }

    /**
     * 
     */
    @Override
    public void setup() {
        turtle = new RodTurtle(this);
        arcball = new ArcBall(this);
        // arcball.constrain(Constrain.YAXIS);
        LUT.initialize();
        setupGrammar();
        noStroke();   
    }

    /**
     * Encapulates the lsystem rules, and calls the grammar to create the
     * production rules depth is number of repeats, and distance is adjusted
     * according to the number of repeats
     */
    public void setupGrammar() {
        grammar = new SimpleGrammar(this, "A");   // this only required to allow applet to call dispose()
        grammar.addRule('A', "B>F<CFC<F>D+F-D>F<1+CFC<F<B1^");
        grammar.addRule('B', "A+F-CFB-F-D1->F>D-1>F-B1>FC-F-A1^");
        grammar.addRule('C', "1>D-1>F-B>F<C-F-A1+FA+F-C<F<B-F-D1^");
        grammar.addRule('D', "1>CFB>F<B1>FA+F-A1+FB>F<B1>FC1^");
        grammar.generateGrammar(depth);
        if (depth > 0) {
            distance *= 1 / (pow(2, depth) - 1);
        }
    }

    /**
     * 
     */
    @Override
    public void draw() {
        background(20, 20, 200);
        lights();   
        render();
    }

    /**
     * Render wraps the drawing logic; draws a sphere at origin, followed by
     * successive turtle.draw(distance) as a capped cylinder to complete the
     * hilbert according to lsystem rules (ie whenever there is an 'F').
     */
   
    public void render() {
        int repeats = 1;
        fill(191, 191, 191);
        ambientLight(80, 80, 80);
        directionalLight(100, 100, 100, -1, -1, 1);
        ambient(122, 122, 122);
        lightSpecular(30, 30, 30);
        specular(122, 122, 122);
        shininess(0.7f);
        translate(-distance * adjust[depth], distance  * adjust[depth], -distance * adjust[depth]);
        CharacterIterator it = grammar.getIterator();
        for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
            switch (ch) {
                case 'F':
                    turtle.draw(distance, depth);
                    break;
                case '+':
                    turtle.yaw(THETA * repeats);
                    repeats = 1;
                    break;
                case '-':
                    turtle.yaw(-THETA * repeats);
                    repeats = 1;
                    break;
                case '>':
                    turtle.pitch(THETA * repeats);
                    repeats = 1;
                    break;
                case '<':
                    turtle.pitch(-THETA * repeats);
                    repeats = 1;
                    break;
                case '^':
                    turtle.roll(PHI * repeats);
                    repeats = 1;
                    break;
                case '1':
                    repeats += 1;
                    break;
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                    break;
                default:
                    System.err.println("character " + ch + " not in grammar");
            }
        }
    }

    /**
     * 
     */
    @Override
    public void keyReleased() {
        switch (key) {
            case '+':
                if (depth <= 3) { // guard against a depth we can't handle
                    depth++;
                    distance = 300;
                    setupGrammar();
                }
                break;
            case '-':
                if (depth >= 2) {
                    depth--;
                    distance = 300;
                    setupGrammar();
                }
                break;
        }
    }

    /**
     * 
     * @param args
     */
    static public void main(String args[]) {
        PApplet.main(new String[]{"--bgcolor=#DFDFDF", "test.rodHilbert2"});
    }
}
