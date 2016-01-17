 /* 
 * Copyright (c) 2012-16 Martin Prout
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

import java.text.CharacterIterator;
import lsystem.Grammar;
import lsystem.StochasticGrammar;
import lsystem.turtle.Turtle;
import lsystem.collection.TurtleStack;

/**
*  plant.pde
*  A simple example that demonstrates the use of a weighted StochasticGrammar
*  bracketed syntax (for branching). As results are random, it is probably worth
*  running the sketch several times.
*/

ArrayList<float[]> pts;
final float DELTA = PI/10; // 18 degrees
Grammar grammar; 
String axiom;
String rule;
float startLength;
float drawLength;
float theta;
float xpos;
float ypos;
TurtleStack ts;


void setup() {
  size(500, 600);
  createLSystem();
  pts = new ArrayList<float[]>();
  ts = new TurtleStack(this);
  stroke(0, 255, 0);
  strokeWeight(2);
  noFill();
  smooth();
  translateRules();
  background(0);
  noLoop();
}

void createLSystem(){
  int generations = 5;                 // set no of recursions
  String axiom = "F";  
  grammar = new StochasticGrammar(this, axiom);  // initialize library
  grammar.addRule('F', "F[+F]F[-F]F", 0.1); // add rule, and weight
  grammar.addRule('F', "F[+F]F", 0.45);
  grammar.addRule('F', "F[-F]F", 0.45);
  float startLength = 40;
  grammar.generateGrammar(generations);
  drawLength = startLength * pow(0.7, generations); 
}

void translateRules() {
  float x_temp, y_temp;
  Turtle turtle = new Turtle(0.4 * height, 0.98 * width, HALF_PI);
  CharacterIterator it = grammar.getIterator();
  for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
    switch (ch) {
    case 'F':
      x_temp = turtle.getX();
      y_temp = turtle.getY();
      turtle.setX(x_temp + drawLength * cos(turtle.getTheta()));
      turtle.setY(y_temp - drawLength * sin(turtle.getTheta()));
      float[] temp = {x_temp, y_temp, turtle.getX(), turtle.getY()};
      pts.add(temp);
      break;
    case '+':
      turtle.setTheta(turtle.getTheta() + DELTA);
      break;
    case '-':
      turtle.setTheta(turtle.getTheta() - DELTA);
      break;
    case '[':
      ts.push(turtle.clone()); // shallow copy is OK here really if you are worried use copy constructor
      // ts.push(new Turtle(turtle)); // Uncomment this (and comment previous line to avoid using clone) 
      break;
    case ']':
      turtle = ts.pop();
      break;
    default:
      System.err.println("character " + ch + " not in grammar");
    }
  }
}

void draw() {  
  for (float[] pt : pts) {
    line(pt[0], pt[1], pt[2], pt[3]);
  }
}