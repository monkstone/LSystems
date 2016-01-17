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

/**
 * This sketch is a candidate for updating to use my new Turtle3D interface see Hilbert2
 * Features ArcBall rotation constrained to Y axis (and mousewheel zoom)
 */


import lsystem.CSGrammar;
import lsystem.util.*;
import java.text.CharacterIterator;

float DELTA = radians(25); // 25 degrees to radians
float distance = 40;
String production;
float drawLength;
ArcBall arcball;
CSGrammar grammar;

void setup() {
  size(600, 400, P3D);  
  arcball = new ArcBall(this, width/2, height * 0.8, width * 0.8);
  arcball.constrain(Constrain.YAXIS);  
  noStroke();
  fill(0, 152, 75);
  LUT.initialize(); // initialize lookup tables
  iterateRules(5);
}

void iterateRules(int generations) {
  String axiom = "F";  
  grammar = new CSGrammar(this, axiom);           // initialize library
  grammar.addRule('F', "F[-EF[3&A]]E[+F[3^A]]");  // add simple rule
  grammar.addRule("F<E", "F[&F[3+A]][^F[3-A]]");  // add cs rule
  grammar.setIgnoreList("[]+-^&3");
  grammar.generateGrammar(generations);
}

void render() {   
  int repeat = 1;
  CharacterIterator it = grammar.getIterator();
  for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
    switch (ch) {
    case 'F': 
      translate(0, distance/-2, 0);
      box(distance/9, distance, distance/9);
      translate(0, distance/-2, 0);
      break;
    case '-':
      rotateX(DELTA * repeat);
      repeat = 1;
      break;
    case '+':
      rotateX(-DELTA * repeat);
      repeat = 1;
      break;
    case '&':
      rotateZ(-DELTA * repeat);
      repeat = 1;
      break;
    case '^':
      rotateZ(DELTA * repeat);
      repeat = 1;
      break;
    case '[':
      pushMatrix();
      break;  
    case ']':
      popMatrix();      
      break; 
    case '3':
      repeat = 3;
      break;   
    case 'A':
      break;
    case 'E':
      break;   
    default:
      System.err.println("character " + ch + " not in grammar");
    }
  }
}

void pre() {
  translate(width/2, height * 0.9);
}

void draw() {
  background(0);
  render();
}