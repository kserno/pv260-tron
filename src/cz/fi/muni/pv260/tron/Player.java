package cz.fi.muni.pv260.tron;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Player {

    private static final int MOVE_AMOUNT = 5;

    private Point position;
    private  Direction currentDirection;

    private static Direction mouseDirection=Direction.RIGHT;
    public boolean mouseFlag =false;
    private Color color;

    private Map<Integer, Direction> moveAction;

    private boolean alive = true;

    private List<Point> path = new ArrayList<>();

    public Player(Point position, Direction currentDirection, Color color, Map<Integer, Direction> moveAction) {
        this.position = position;
        this.currentDirection = currentDirection;
        this.color = color;
        this.moveAction = moveAction;
    }



    public void keyPressed(KeyEvent event) {
        if (moveAction.containsKey(event.getKeyCode())) {
            Direction direction = moveAction.get(event.getKeyCode());
            if (currentDirection != direction.getOpposite()) {
                currentDirection = direction;



            }
        }
    }


    public static void mouseClick(MouseEvent e) {


        if (e.getModifiersEx() == InputEvent.BUTTON1_DOWN_MASK) {
            if (mouseDirection == Direction.UP){ mouseDirection = Direction.LEFT;	}
            else if (mouseDirection == Direction.LEFT){ mouseDirection = Direction.DOWN;	}
            else if (mouseDirection == Direction.DOWN){ mouseDirection = Direction.RIGHT;	}
            else if (mouseDirection == Direction.RIGHT){ mouseDirection = Direction.UP;	}
        }

        else if(e.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK)
        {
            if (mouseDirection == Direction.UP){ mouseDirection = Direction.RIGHT;	}
            else if (mouseDirection == Direction.RIGHT){ mouseDirection = Direction.DOWN;	}
            else if (mouseDirection == Direction.DOWN){ mouseDirection = Direction.LEFT;	}
            else if (mouseDirection == Direction.LEFT){ mouseDirection = Direction.UP;	}
        }



    }



    public void move(int width, int height) {
        if (!isAlive()) return;

        path.add((Point) position.clone());

       if(mouseFlag==true){

           mouseDirection.move(position, width, height);
          return;
       }

       else{
           currentDirection.move(position, width, height);
       }

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

    public void collide() {
        alive = false;
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
