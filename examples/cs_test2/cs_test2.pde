import lsystem.turtle.Pen; 
import lsystem.CSGrammar; 
import lsystem.collection.PenStack; 
import java.text.CharacterIterator; 

/**
 * cs_test2.pde by Martin Prout
 * Demonstrates a simple (1L) context sensitive grammar with ignored
 * symbols. Makes use of Pen and PenStack from LSystem utilities, avoids
 * use of processing affine transforms and matrix operations.
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

CSGrammar grammar;
float distance = 30;
float THETA = radians(30);
int startColor = color(255, 0, 0);
int endColor = color(0, 255, 0);
float drawLength = 30;

void setup() {
  size(350, 180);
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

void render(float xpos, float ypos) {
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

void iterateGrammar() {
  for (int i = 0; i < 6; i++) {  
    grammar.generateGrammar(i);
    float xpos = 40 + (i * 50);
    float ypos = height * 0.9f;
    render(xpos, ypos);
  }
}

void drawLine(Pen pen) { // draws line and sets new pen position
  float x_temp = pen.getX(); 
  float y_temp = pen.getY();
  pen.setX(x_temp + pen.getLength() * cos(pen.getTheta()));
  pen.setY(y_temp + pen.getLength() * sin(pen.getTheta())); 
  stroke(pen.getColor());
  line(x_temp, y_temp, pen.getX(), pen.getY());
}