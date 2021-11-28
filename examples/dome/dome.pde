
/**
 * A 3D LSystem example with a SimpleGrammar 
 * This LSystem library is available at Github
 * https://github.com/monkstone/LSystems
 */
 
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.text.*;
import lsystem.util.ArcBall;
import lsystem.*;

Grammar grammar;
ArcBall arcball; 
float distance = 50;
int depth = 1;
float theta = radians(45);
float phi = radians(45);

void setup() { 
  size(500, 500, P3D);
  setupGrammar();
  arcball = new ArcBall(this);
}
 
void setupGrammar() {
  grammar = new SimpleGrammar(this, "A+A+A+A+A+A+A+A");  
  grammar.addRule('A', "F[&F+F+F+F+F+F+F+F+][A+]");
  iterate();
}
 
void iterate() {
  grammar.generateGrammar(depth);
  distance *= pow(0.97, depth);
}
 
void draw() {
  background(0);
  lights();
  render();
}
 
void render() {
  translate(-30, 30, -30);  // center the dome empirically set looks good to me
  fill(0, 75, 152);
  lightSpecular(204, 204, 204);
  specular(255, 255, 255);
  shininess(1.0);
  CharacterIterator it = grammar.getIterator();
  for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
    switch (ch) {
    case 'F':
      translate(0, distance/-2, 0);
      box(distance/9, distance, distance/9);
      translate(0, distance/-2, 0);
      break;
    case '-':
      rotateX(theta);
      break;
    case '+':
      rotateX(-theta);
      break;
    case '[':
      pushMatrix();
      break;
    case ']':
      popMatrix();
      break;
    case '&':
      rotateZ(-phi);
      break;
    case 'A':
      break; 
    default:
      System.err.println("character " + ch + " not in grammar");
    }
  }
}
 
void keyPressed() {
  switch(key) {
    case('+'):
    depth++;
    break;
    case('-'):
    depth--;
    distance *= 1.1;
    break;
    case(' '): // restore to original
    distance = 50;
    depth = 1;
    default:
    break;
  }
  iterate();
}