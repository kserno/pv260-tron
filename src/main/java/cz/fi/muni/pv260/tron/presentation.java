package main.java.cz.fi.muni.pv260.tron;

import java.awt.*;
import java.util.ArrayList;

public class presentation {
    static void drawOnScreen(int centrex1, int centrex2, int centrey1, int centrey2, ArrayList<Integer> pathx1, ArrayList<Integer> pathx2, ArrayList<Integer> pathy1, ArrayList<Integer> pathy2, ScreenManager sm, Graphics2D g) {
        pathx1.add(centrex1);
        pathy1.add(centrey1);
        pathx2.add(centrex2);
        pathy2.add(centrey2);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
        for (int x = 0; x< pathx1.size(); x++){
        g.setColor(Color.green);
        g.fillRect(pathx1.get(x), pathy1.get(x), 10, 10);
        g.setColor(Color.red);
        g.fillRect(pathx2.get(x), pathy2.get(x), 10, 10);
        }
    }
}
