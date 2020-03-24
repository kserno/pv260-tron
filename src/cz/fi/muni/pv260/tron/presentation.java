package cz.fi.muni.pv260.tron;

import java.awt.*;

public class presentation {
    static void drawPath(Graphics2D g, Player player) {
        player.getPath().forEach(point -> {
            g.setColor(player.getColor());
            g.fillRect(point.x, point.y, 10, 10);
        });
    }
}
