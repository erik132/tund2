package engine;


import java.util.List;
import java.util.Timer;

import gamecomponents.Gameboard;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class GameEngine implements GLEventListener{
	
	private Gameboard gameboard;
	
	private Timer timer;
	
	private int gameTickTime = 100;
	
	
	
	public GameEngine(Gameboard gameboard){
		this.gameboard = gameboard;
		this.timer = new Timer();
		
		this.timer.scheduleAtFixedRate(new GameboardTicker(this.gameboard, this), this.gameTickTime, this.gameTickTime);
		
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
	
	



}
