package cz.fi.muni.pv260.tron;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Player {

    private static final int MOVE_AMOUNT = 5;

    private Point position;
    private Direction currentDirection;
    private Color color;

    private Map<Integer, Direction> moveAction;

    private boolean alive = true;

    private int width, height;

    private List<Point> path = new ArrayList<>();

    public Player(Point position, Direction currentDirection, Color color, Map<Integer, Direction> moveAction, int width, int height) {
        this.position = position;
        this.currentDirection = currentDirection;
        this.color = color;
        this.moveAction = moveAction;
        this.width = width;
        this.height = height;
    }

    public void keyPressed(KeyEvent event) {
        if (moveAction.containsKey(event.getKeyCode())) {
            Direction direction = moveAction.get(event.getKeyCode());
            if (currentDirection != direction.getOpposite()) {
                currentDirection = direction;
            }
        }
    }

    public void move() {
        path.add((Point) position.clone());
        currentDirection.move(position, width, height);
    }

    public Point getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public List<Point> getPath() {
        return path;
    }

    public boolean isAlive() {
        return alive;
    }


    enum Direction {
        LEFT {
            @Override
            void move(Point point, int width, int height) {
                if (point.x > 0){
                    point.x -= MOVE_AMOUNT;
                } else {
                    point.x = width;
                }
            }

            @Override
            Direction getOpposite() {
                return Direction.RIGHT;
            }
        },
        RIGHT {
            @Override
            void move(Point point, int width, int height) {
                if (point.x < width){
                    point.x += MOVE_AMOUNT;
                } else {
                    point.x = 0;
                }
            }

            @Override
            Direction getOpposite() {
                return Direction.LEFT;
            }
        },
        UP {
            @Override
            void move(Point point, int width, int height) {
                if (point.y > 0){
                    point.y -= MOVE_AMOUNT;
                } else {
                    point.y = height;
                }
            }

            @Override
            Direction getOpposite() {
                return Direction.DOWN;
            }
        },
        DOWN {
            @Override
            void move(Point point, int width, int height) {
                if (point.y < height){
                    point.y += MOVE_AMOUNT;
                } else {
                    point.y = 0;
                }
            }

            @Override
            Direction getOpposite() {
                return Direction.UP;
            }
        };

        abstract void move(Point point, int width, int height);
        abstract Direction getOpposite();
    }

}
