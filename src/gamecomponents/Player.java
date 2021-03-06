package gamecomponents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import common.ArrayListQueue;
import common.Point;
import engine.InputListener;
import engine.VisualElement;
import gamecomponents.skins.PlayerSkin;

public class Player extends GameboardElement implements InputListener {
	
	private ArrayListQueue<VisualElement> skins = new ArrayListQueue<>();
	
	private int[] allowedKeys = {UP_ARROW, DOWN_ARROW, LEFT_ARROW, RIGHT_ARROW, NO_DIRECTION};
	
	private int direction = NO_DIRECTION;
	
	public Player(){
		
	}
	
	@Override
	public void initElement(){
		this.skins.add(new PlayerSkin(0,0,this.tileSize));
		this.skins.add(new PlayerSkin(0,0,this.tileSize));
		this.skins.add(new PlayerSkin(0,0,this.tileSize));

	}
	
	@Override
	public List<VisualElement> getSkin() {
		return this.extractVisualList();
	}
	
	@Override
	public boolean detectCollision(Point point){
		int i = 0;
		
		List<VisualElement> skins = this.extractVisualList();
		
		for(; i<(skins.size()-1); i++){
			if(skins.get(i).equals(point)){
				return true;
			}
		}
		
		return false;
	}
	

	
	private List<VisualElement> extractVisualList(){
		List<VisualElement> skins = new ArrayList<>();
		Iterator<VisualElement> skinner = this.skins.iterator();
		while(skinner.hasNext()){
			skins.add(skinner.next());
		}
		return skins;
		
	}
	
	
	public void addSnakeTiles(int nrOfTiles){
		Point point = this.skins.peekFirst().getPoint();
		for(int i = 0; i< nrOfTiles; i++){
			this.skins.addFront(new PlayerSkin(point.getX(), point.getY(),this.tileSize));
		}
	}
	
	
	public Point move(){
		
		if(this.skins.isEmpty()){
			return null;
		}
		
		if(this.direction == NO_DIRECTION){
			return null;
		}
		VisualElement snakeTile = this.skins.poll();
		Point firstPoint = this.skins.peekLast().getPoint();
		
		switch(this.direction){
		case UP_ARROW:
			firstPoint.setY(firstPoint.getY() + this.tileSize);
			break;
		case DOWN_ARROW:
			firstPoint.setY(firstPoint.getY() - this.tileSize);
			break;
		case RIGHT_ARROW:
			firstPoint.setX(firstPoint.getX() + this.tileSize);
			break;
		case LEFT_ARROW:
			firstPoint.setX(firstPoint.getX() - this.tileSize);
			break;
			
		}
		
		snakeTile.setPoint(firstPoint);
		this.skins.add(snakeTile);
		return firstPoint;
		
		
		
	}
	
	public int getPlayerSize(){
		return this.skins.size();
	}

	@Override
	public void receiverInput(int keyCode) {
		for(int key: this.allowedKeys){
			if(key == keyCode){
				this.direction = keyCode;
			}
		}
		
	}
	
}
