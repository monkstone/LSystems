package runtest;

import processing.core.*; 

import lsystem.turtle.Pen; 
import lsystem.CSGrammar; 
import lsystem.collection.PenStack; 
import java.text.CharacterIterator; 

public class cs_test2 extends PApplet {

/**
 * cs_test2.pde by Martin Prout
 * Demonstrates a simple (1L) context sensitive grammar with ignored
 * symbols. Makes use of Pen and PenStack from LSystem utilities, avoids
 * use of processing affine transforms and matrix operations.
 */
 
 /* 
 * Copyright (c) 2012 Martin Prout
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

CSGrammar grammar;
float distance = 30;
float THETA = radians(30);
int startColor = color(255, 0, 0);
int endColor = color(0, 255, 0);
float drawLength = 30;

@Override
public void settings() {
  size(350, 180);
}

@Override
public void setup() {
  createGrammar();  
  strokeWeight(4);
  iterateGrammar();
  print(grammar.toString());
}

public void createGrammar() {
  String axiom = "G[+F]F[-F][+F]F";  
  grammar = new CSGrammar(this, axiom); // initialize library
  grammar.addRule("G<F", "G");          // add cs replacement rule
  grammar.setIgnoreList("-+[]");
}

public void render(float xpos, float ypos) {
  PenStack stack = new PenStack(this); // initialize local stack
  float theta = -PI/2; // this way is up in the processing environment
  Pen pen = new Pen(this, xpos, ypos, theta, drawLength, startColor); 
  CharacterIterator it = grammar.getIterator();
  for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
    switch (ch) {
    case 'F': 
      pen.setColor(startColor);    
      drawLine(pen);
      break;
    case 'G': 
      pen.setColor(endColor);    
      drawLine(pen);
      break;  
    case '-':
      pen.setTheta(pen.getTheta() - THETA);
      break;
    case '+':
      pen.setTheta(pen.getTheta() + THETA);
      break;
    case '[':
      stack.push(new Pen(pen));
      break;
    case ']':
      pen = stack.pop();
      break;     
    default:
      System.err.println("character " + ch + " not in grammar");
    }
  }
}

public void iterateGrammar() {
  for (int i = 0; i < 6; i++) {  
    grammar.generateGrammar(i);
    float xpos = 40 + (i * 50);
    float ypos = height * 0.9f;
    render(xpos, ypos);
  }
}

public void drawLine(Pen pen) { // draws line and sets new pen position
  float x_temp = pen.getX(); 
  float y_temp = pen.getY();
  pen.setX(x_temp + pen.getLength() * cos(pen.getTheta()));
  pen.setY(y_temp + pen.getLength() * sin(pen.getTheta())); 
  stroke(pen.getColor());
  line(x_temp, y_temp, pen.getX(), pen.getY());
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "runtest.cs_test2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
