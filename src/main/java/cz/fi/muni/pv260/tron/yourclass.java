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

	public void init() {
		super.init();

		Window w = sm.getFullScreenWindow();
		w.addKeyListener(this);
		w.addMouseListener(this);
		w.addMouseMotionListener(this);

		Player player1 = initPlayer1();
		Player player2 = initPlayer2();
		Player player3 = initPlayer3();

		players.add(player1);
		players.add(player2);
//		players.add(player3);
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
				movement
		);
	}

	private Player initPlayer2() {
		Point position = new Point(600, 440);
		Map<Integer, Player.Direction> movement = new HashMap<>();

		movement.put(KeyEvent.VK_W, Player.Direction.UP);
		movement.put(KeyEvent.VK_S, Player.Direction.DOWN);
		movement.put(KeyEvent.VK_A, Player.Direction.LEFT);
		movement.put(KeyEvent.VK_D, Player.Direction.RIGHT);

		return new Player(
				position,
				Player.Direction.LEFT,
				Color.red,
				movement
		);
	}

	private Player initPlayer3() {
		Point position = new Point(300, 300);
		Map<Integer, Player.Direction> movement = new HashMap<>();

		movement.put(KeyEvent.VK_I, Player.Direction.UP);
		movement.put(KeyEvent.VK_K, Player.Direction.DOWN);
		movement.put(KeyEvent.VK_J, Player.Direction.LEFT);
		movement.put(KeyEvent.VK_L, Player.Direction.RIGHT);

		return new Player(
				position,
				Player.Direction.DOWN,
				Color.blue,
				movement
		);
	}


	public static void main(String[] args) {
		new yourclass().run();
	}

	public void draw(Graphics2D g) {
		players.forEach(player -> player.move(sm.getWidth(), sm.getHeight()));
	    detectCollisions();
		clearGraphics(g);
		players.forEach(player -> drawPath(g, player));
	}

	public void keyPressed(KeyEvent e) {
		players.forEach(player -> player.keyPressed(e));
	}

	private void clearGraphics(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
	}

	private void detectCollisions() {
		players.forEach(player1 -> {
			if (player1.isAlive()) {
				players.forEach(player2 -> {
					player2.getPath().forEach(pathPosition -> {
						if (player1.getPosition().equals(pathPosition)) {
							player1.collide();
						}
					});
				});
			}
		});
		if (players.stream().filter(Player::isAlive).count() == 1) {
			System.exit(0);
		}
	}

	private void drawPath(Graphics2D g, Player player) {
		player.getPath().forEach(point -> {
			g.setColor(player.getColor());
			g.fillRect(point.x, point.y, 10, 10);
		});
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
