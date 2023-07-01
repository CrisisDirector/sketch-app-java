package sketchpad;

import buttons.*;
import tools.*;

public class SketchPad {
    private final Screen screen = new Screen();
    private final MouseInfo mouseInfo = new MouseInfo();
    private final PaintingTool paint = new PaintingTool();

    public void initialLaunch() {
      // the code here runs when the program is first started up
      screen.setBackgroundColor(new Color(127, 255, 127));

      paint.setFillColor(Color.BLUE);
      paint.drawCircle(0, 40, 20);
      paint.drawCircle(0, 360, 20);
      paint.drawCircle(600, 40, 20);
      paint.drawCircle(600, 360, 20);

      paint.setFillColor(Color.RED);
      paint.drawCircle(40, 0, 20);
      paint.drawCircle(40, 400, 20);
      paint.drawCircle(560, 0, 20);
      paint.drawCircle(560, 400, 20);

      paint.setFillColor(Color.WHITE);
      paint.drawRect(30, 30, 540, 340);
    }

    public void update() {
      // the code here runs whenever the program's state changes
    }
}
