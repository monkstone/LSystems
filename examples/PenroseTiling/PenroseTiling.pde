/** 
 * penroseTiling.pde
 * Loosely based on a processing PenroseTiling
 * processing sketch by Geraldine Sarmiento 
 * https://github.com/monkstone/LSystems
 */

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

import lsystem.turtle.Turtle;    
import lsystem.collection.TurtleStack;
import lsystem.Grammar;
import lsystem.SimpleGrammar;
import processing.pdf.*;
import java.text.CharacterIterator;



ArrayList<float[]> pts;
final float DELTA = PI/5; // 36 degrees
Grammar grammar; 
String axiom;
String rule;
String production;
float startLength;
float drawLength;
float theta;
float xpos;
float ypos;
TurtleStack ts;
PFont myFont; 

void setup() {
  size(700,  900);
  createLSystem();
  pts = new ArrayList<float[]>();
  ts = new TurtleStack(this);
  stroke(0);
  strokeWeight(3);
  noFill();
  smooth();
  translateRules();
  background(255);
  myFont = createFont("DejaVuSans", 18); // for the benefit linux users
  // myFont = createFont("any suitable ttf font", 18);
  renderToPDF();
}

void createLSystem() {
  int generations = 4;                 // set no of recursions
  String axiom = "[X]2+[X]2+[X]2+[X]2+[X]";  
  grammar = new SimpleGrammar(this,  axiom);  // initialize custom library
  grammar.addRule('F',  "");                 // add char substitution rules
  grammar.addRule('W',  "YF2+ZF4-XF[-YF4-WF]2+");
  grammar.addRule('X',  "+YF2-ZF[3-WF2-XF]+");
  grammar.addRule('Y',  "-WF2+XF[3+YF2+ZF]-");
  grammar.addRule('Z',  "2-YF4+WF[+ZF4+XF]2-XF");

  float startLength = 500;
  grammar.generateGrammar(generations);
  drawLength = startLength * pow(0.5,  generations);
}

void translateRules() {
  float x_temp,  y_temp;
  int repeat = 1;
  Turtle turtle = new Turtle(width/2,  height/3,  0);
  CharacterIterator it = grammar.getIterator();
  for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
    switch (ch) {
    case 'F':
      x_temp = turtle.getX();
      y_temp = turtle.getY();
      turtle.setX(x_temp - drawLength * cos(turtle.getTheta()));
      turtle.setY(y_temp - drawLength * sin(turtle.getTheta()));
      float[] temp = {
        x_temp,  y_temp,  turtle.getX(),  turtle.getY()
        };
        pts.add(temp);
      break;
    case '+':
      turtle.setTheta(turtle.getTheta() + DELTA * repeat);
      repeat = 1;
      break;
    case '-':
      turtle.setTheta(turtle.getTheta() - DELTA * repeat);
      repeat = 1;
      break;
    case '[':
      ts.push(new Turtle(turtle)); 
      break;
    case ']':
      turtle = ts.pop();
      break;
    case 'W':   // do nothing other than
    case 'X':   // confirm W,X,Y&Z as valid grammar
    case 'Y':
    case 'Z':
      break;
    case '2':   // set repeat using char ascii code 
    case '3':   // 48 = ascii '0'
    case '4':
      repeat = (int)ch - 48;
      break;  
    default:
      System.err.println("character " + ch + " not in grammar");
      break;
    }
  }
}

void renderToPDF() {
  beginRecord(PDF, "penrose.pdf");
  for (float[] pt : pts) {
    line(pt[0],  pt[1],  pt[2],  pt[3]);
  }
  fill(0);
  textFont(myFont, 18);
  text("Penrose Tiling", 300, 50);
  text(grammar.toString(), 100, 600);
  endRecord();
}