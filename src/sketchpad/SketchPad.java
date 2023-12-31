package sketchpad;

import buttons.*;
import tools.*;

public class SketchPad {
    // set up screen, mouse tracker, and painting tools
    private final Screen screen = new Screen();
    private final MouseInfo mouseInfo = new MouseInfo();
    private final PaintingTool paint = new PaintingTool();

    // Declare variables that store the previous mouse coordinates
    private int prevMouseX;
    private int prevMouseY;

    // Declare a button to clear the sketchpad
    private ClearButton cb = new ClearButton(5, 5, 20, Color.WHITE);

    // Declare two pen colour buttons - one red and one blue
    private PenColorButton pen1 = new PenColorButton(50, 5, 20, Color.RED);
    private PenColorButton pen2 = new PenColorButton(70, 5, 20, Color.BLUE);

    public void initialLaunch() {
        // Set the background color to a light green
        screen.setBackgroundColor(new Color(127, 255, 127));;

        // Generate many random circles for a colorful backdground for the sketch pad
        for (int circleNumber = 0; circleNumber < 200; circleNumber++) {
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

        // draw the clear button
        cb.drawSelf();

        // draw the two pen colour buttons
        pen1.drawSelf();
        pen2.drawSelf();
    }

    public void update() {
        // Setting the pen color to a random number
        paint.setLineColor(
               Generator.randomInt(256),
               Generator.randomInt(256),
               Generator.randomInt(256)
        );

        // The clear button checks all the time if it's pressed
        cb.update();

        // As do the two pen colour buttons
        pen1.update();
        pen2.update();
      
        // If the mouse was just clicked, update it's last known coordinates
        if (mouseInfo.isMousePressed()) {
            prevMouseX = mouseInfo.getX();
            prevMouseY = mouseInfo.getY();
        }

        // Only draw lines if the mouse is dragged inside the white sketch canvas
        if (mouseInfo.isMouseDragged() &&
            mouseInfo.getX() >= 30 &&
            mouseInfo.getX() <= 570 &&
            mouseInfo.getY() >= 30 &&
            mouseInfo.getY() <= 370) {

            paint.drawLine(mouseInfo.getX(), mouseInfo.getY(), prevMouseX, prevMouseY);
            prevMouseX = mouseInfo.getX();
            prevMouseY = mouseInfo.getY();
        }

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
