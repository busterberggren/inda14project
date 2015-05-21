import org.newdawn.slick.GameContainer;

public class Camera {
	
	// Current coordinates 
	private int x, y;
	private static int width, height;
	private final int minDistanceToEdgeY = 200;
	private final int minDistanceToEdgeX = 500;
	
	public Player player;
	
	public Camera(int x, int y, Player player) {
		this.x = x;
		this.y = y;
		this.player = player;
	}
	
	/*
	 *  Initializes camera dimensions to match game window's.
	 */
	public static void init(GameContainer container) {
		width = container.getWidth();
		height = container.getHeight();
	}
	
	/**
	 * Updates this object's state.
	 * Checks if player has gone outside set up bounds and adjusts
	 * position accordingly.
	 * 
	 * @param container Obtain input from this
	 * @param delta Time
	 */
	public void update() {
		if (player.getX() < this.x + minDistanceToEdgeX) {
			increaseX(player.getX() - (x + minDistanceToEdgeX));
		} else { 
			if (player.getX() + player.getWidth() > x + width - minDistanceToEdgeX) {
				increaseX(player.getX() + player.getWidth() - (x + width - minDistanceToEdgeX));
			}
		}
		
		if (player.getY() < this.y + minDistanceToEdgeY) {
			increaseY(player.getY() - (y + minDistanceToEdgeY));
		} else { 
			if (player.getY() + player.getHeight() > y + height - minDistanceToEdgeY) {
				increaseY(player.getY() + player.getHeight() - (y + height - minDistanceToEdgeY));
			}
		}
			
	}
	
	/*
	 * Increases X by increment
	 * 
	 * @param increment Increment
	 */
	
	public void increaseX(float increment) {
		x += increment;
	}
	
	/*
	 * Increases Y by increment
	 * 
	 * @param increment Increment
	 */
	public void increaseY(float increment) {
		y += increment;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	/*
	 * Checks i e is on screen
	 * 
	 * @param e Checked entity object
	 */
	public boolean isEntityOnScreen(Entity e) {
		return 	(e.getX() < x + width && e.getX() + e.getWidth() > x) ||
				(e.getY() < y + height && e.getY() + e.getHeight() > y);

	}
}
