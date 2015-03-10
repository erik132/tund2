package engine;

public interface InputListener {
	
	public static final int LEFT_ARROW = 37;
	
	public static final int UP_ARROW = 38;
	
	public static final int RIGHT_ARROW = 39;
	
	public static final int DOWN_ARROW = 40;
	
	public static final int NO_DIRECTION = 80;
	
	public void receiverInput(int keyCode);
}
