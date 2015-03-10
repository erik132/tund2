package gamecomponents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import common.ArrayListQueue;
import common.Point;
import engine.VisualElement;
import gamecomponents.skins.PlayerSkin;

public class Player extends GameboardElement {
	
	private ArrayListQueue<VisualElement> skins = new ArrayListQueue<>();
	
	
	
	public Player(){
		
	}
	
	@Override
	public void initElement(){
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
	
	
	public int getPlayerSize(){
		return this.skins.size();
	}
	
}
