package cz.fi.muni.pv260.tron;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class yourclass extends Core implements KeyListener, MouseListener,
		MouseMotionListener {

	private List<Player> players = new ArrayList<>();

	int currentDirection1 = 1;
	int currentDirection2 = 3;
	int moveAmount = 5;
	ArrayList<Integer> pathx1 = new ArrayList();
	ArrayList<Integer> pathy1 = new ArrayList();
	ArrayList<Integer> pathx2 = new ArrayList();
	ArrayList<Integer> pathy2 = new ArrayList();

	public void init() {
		super.init();

		Window w = sm.getFullScreenWindow();
		w.addKeyListener(this);
		w.addMouseListener(this);
		w.addMouseMotionListener(this);

		Player player1 = initPlayer1();
		Player player2 = initPlayer2();

		players.add(player1);
		players.add(player2);
	}

	private Player initPlayer1() {
		Point position = new Point(40, 40);
		Map<Integer, Player.Direction> movement = new HashMap<>();

		movement.put(KeyEvent.VK_UP, Player.Direction.UP);
		movement.put(KeyEvent.VK_DOWN, Player.Direction.DOWN);
		movement.put(KeyEvent.VK_RIGHT, Player.Direction.RIGHT);
		movement.put(KeyEvent.VK_LEFT, Player.Direction.LEFT);

		return new Player(
				position,
				Player.Direction.RIGHT,
				Color.green,
				movement,
				sm.getWidth(),
				sm.getHeight()
		);
	}

	private Player initPlayer2() {
		Point position = new Point(600, 440);
		Map<Integer, Player.Direction> movement = new HashMap<>();

		movement.put(KeyEvent.VK_W, Player.Direction.UP);
		movement.put(KeyEvent.VK_S, Player.Direction.DOWN);
		movement.put(KeyEvent.VK_A, Player.Direction.RIGHT);
		movement.put(KeyEvent.VK_D, Player.Direction.LEFT);

		return new Player(
				position,
				Player.Direction.LEFT,
				Color.red,
				movement,
				sm.getWidth(),
				sm.getHeight()
		);
	}

	public static void main(String[] args) {
		new yourclass().run();
	}

	public void draw(Graphics2D g) {

	    for (int x = 0;x<pathx1.size();x++){
	    	if (((centrex1 == pathx1.get(x)) && (centrey1 == pathy1.get(x))) || ((centrex2 == pathx2.get(x)) && (centrey2 == pathy2.get(x))) || ((centrex1 == pathx2.get(x)) && (centrey1 == pathy2.get(x))) || ((centrex2 == pathx1.get(x)) && (centrey2 == pathy1.get(x)))){
	    		System.exit(0);
	    	}
	    }

		clearGraphics(g);
		for (Player player : players) {
			drawPath(g, player);
		}
	}

	private void detectCollisions() {
		players.for


	}

	private void clearGraphics(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
	}

	private void drawPath(Graphics2D g, Player player) {
		player.getPath().forEach(point -> {
			g.setColor(player.getColor());
			g.fillRect(point.x, point.y, 10, 10);
		});
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (currentDirection1 != 2){
			currentDirection1 = 0;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (currentDirection1 != 0){
				currentDirection1 = 2;
				}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (currentDirection1 != 3){
				currentDirection1 = 1;
				}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (currentDirection1 != 1){
				currentDirection1 = 3;
				}
		}
		if (e.getKeyCode() == KeyEvent.VK_W){
			if (currentDirection2 != 2){
			currentDirection2 = 0;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			if (currentDirection2 != 0){
				currentDirection2 = 2;
				}
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			if (currentDirection2 != 3){
				currentDirection2 = 1;
				}
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			if (currentDirection2 != 1){
				currentDirection2 = 3;
				}
		}
	}


	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}
}
