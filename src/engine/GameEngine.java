package engine;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import gamecomponents.Gameboard;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class GameEngine implements GLEventListener, KeyListener, MouseListener, MouseMotionListener{
	
	private Gameboard gameboard;
	
	private Timer timer;
	
	private int gameTickTime = 10;
	
	private List<InputListener> listeners = new ArrayList<>();
	
	public GameEngine(Gameboard gameboard){
		this.gameboard = gameboard;
		this.timer = new Timer();
		
		this.timer.scheduleAtFixedRate(new GameboardTicker(this.gameboard, this), this.gameTickTime, this.gameTickTime);
		
	}
	
	public void addInputListener(InputListener inputListener){
		this.listeners.add(inputListener);
	}
	
	public void endGame(String message){
		System.out.println(message);
		System.exit(0);
		
		
	}
	
	private void drawVisuals(List<VisualElement> elements, GL2 gl){
		for(VisualElement element : elements){
			element.drawElement(gl);
		}
	}
	
	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(gl.GL_COLOR_BUFFER_BIT);
		gl.glLoadIdentity();
		
		this.drawVisuals(this.gameboard.getVisuals(),gl);
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		for(InputListener inputListener : this.listeners){
			inputListener.receiverInput(arg0.getKeyCode());
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	



}
