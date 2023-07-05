package sketchpad;

import buttons.*;
import tools.*;

public class SketchPad {
    // set up screen, mouse tracker, and painting tools
    private final Screen screen = new Screen();
    private final MouseInfo mouseInfo = new MouseInfo();
    private final PaintingTool paint = new PaintingTool();

    // Declare variables for the previous mouse coordinates
    private int prevMouseX;
    private int prevMouseY;

    public void initialLaunch() {
        // the code here runs when the program is first started up

        // set the background colour to a light green
        screen.setBackgroundColor(new Color(127, 255, 127));

        // draw a random assortment of circles in the sketchpad's background
        for (int circleNumber = 0; circleNumber < 80; circleNumber++) {
            drawRandomCircle();
        }

        // draw the blue corners of the sketchpad
        paint.setFillColor(Color.BLUE);
        paint.drawCircle(0, 40, 20);
        paint.drawCircle(0, 360, 20);
        paint.drawCircle(600, 40, 20);
        paint.drawCircle(600, 360, 20);

        // draw the blue corners of the sketchpad
        paint.setFillColor(Color.RED);
        paint.drawCircle(40, 0, 20);
        paint.drawCircle(40, 400, 20);
        paint.drawCircle(560, 0, 20);
        paint.drawCircle(560, 400, 20);

        // draw the white canvas of the sketchpad
        paint.setFillColor(Color.WHITE);
        paint.drawRect(30, 30, 540, 340);
    }

    public void update() {
        // the code here runs whenever the program's state changes
        // currently, this implements an always-on pen tool: the mouse acts like a multi-coloured pen

        // set the pen colour - currently, this is random and everchanging
        paint.setLineColor(
          Generator.randomInt(256),
          Generator.randomInt(256),
          Generator.randomInt(256)
        );

        // only use the pen if the left mouse button is pressed down
        // the pen only works if used inside the white sketch canvas
        if (mouseInfo.isMouseDragged() &&
          mouseInfo.getX() >= 30 &&
          mouseInfo.getX() <= screen.getWidth() - 30 &&
          mouseInfo.getY() >= 30 &&
          mouseInfo.getY() <= screen.getWidth() - 30) {
              // draw a line from the current mouse location to the previous mouse location
              paint.drawLine(prevMouseX, prevMouseY, mouseInfo.getX(), mouseInfo.getY());
            }
        
        // Update the previous location values of the mouse
        prevMouseX = mouseInfo.getX();
        prevMouseY = mouseInfo.getY();
          
    }
    public void drawRandomCircle() {
        // define the center coordinates
        int x = Generator.randomInt(screen.getWidth());
        int y = Generator.randomInt(screen.getHeight());
        
        // fix the radius
        int radius = Generator.randomInt(10, 30);
        
        // pick random RGB values for the fill color
        int r = Generator.randomInt(255);
        int g = Generator.randomInt(255);
        int b = Generator.randomInt(255);
        
        // Set the fill color and draw the circle
        paint.setFillColor(r, g, b);
        paint.drawCircle(x, y, radius);
}
}
