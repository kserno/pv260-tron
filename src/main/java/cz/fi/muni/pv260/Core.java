package cz.fi.muni.pv260;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public abstract class Core implements KeyListener, MouseListener,
		MouseMotionListener {

	private static final DisplayMode modes[] = 
		{

		new DisplayMode(1680,1050,32,0),
		new DisplayMode(800,600,32,0),
		new DisplayMode(800,600,24,0),
		new DisplayMode(800,600,16,0),
		new DisplayMode(640,480,32,0),
		new DisplayMode(640,480,24,0),
		new DisplayMode(640,480,16,0),
		};
	private boolean running;
	protected ScreenManager sm;
	
	public void stop(){
		running = false;
	}
	
	public void start(){
		try{
			init();
			gameLoop();
		}finally{
			sm.restoreScreen();
		}
	}
	
	public void init(){
		Window w = getWindowScreen();
		setWindowScreen(w);
		addListeners(w);
		running = true;
	}

	private void addListeners(Window w) {
		w.addKeyListener(this);
		w.addMouseListener(this);
		w.addMouseMotionListener(this);
	}

	private void setWindowScreen(Window w) {
		w.setFont(new Font("Arial",Font.PLAIN,20));
		w.setBackground(Color.WHITE);
		w.setForeground(Color.RED);
		w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),"null"));
	}

	private Window getWindowScreen() {
		sm = new ScreenManager();
		DisplayMode dm = sm.findFirstCompatibaleMode(modes);
		sm.setFullScreen(dm);
		return sm.getFullScreenWindow();
	}

	public void gameLoop(){
		long startTime = System.currentTimeMillis();
		long cumTime = startTime;

		updateGame(cumTime);
	}

	private void updateGame(long cumTime) {
		while (running){
			long timePassed = System.currentTimeMillis()-cumTime;
			cumTime+= timePassed;
			update(timePassed);
			Graphics2D g = sm.getGraphics();
			draw(g);
			g.dispose();
			sm.update();

			delayTime();
		}
	}

	private void delayTime() {
		try{
			Thread.sleep(20);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	protected void clearGraphics(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
	}


	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}



	public abstract void update(long timePassed);
	
	public abstract void draw(Graphics2D g);


	
}
