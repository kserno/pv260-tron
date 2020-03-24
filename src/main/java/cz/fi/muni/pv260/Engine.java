package cz.fi.muni.pv260;

import java.awt.*;

public interface Engine {

    void start();
    void update(long timePassed);
    void draw(Graphics2D g);
    void stop();

}
