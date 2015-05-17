import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Camera {
	
	// Current coordinates 
	private int x, y;
	private int width, height;
	// Maximum allowed coordinates
	private int maxX, maxY;
	// Minimum allowed coordinates
	private int minX, minY;
	private final int minDistanceToEdge = 200;
	
	public Entity player;
	
	public Camera(int x, int y, Entity player) {
		this.x = x;
		this.y = y;
		this.player = player;
		width = 1280;
		height = 720;
	}
	
	public static void init() {
		// TODO
	}
	
	public void update() {
		if (player.getX() < this.x + minDistanceToEdge) {
			increaseX(player.getX() - (x + minDistanceToEdge));
		} else { 
			if (player.getX() + player.getWidth() > x + width - minDistanceToEdge) {
				increaseX(player.getX() + player.getWidth() - (x + width - minDistanceToEdge));
			}
		if (player.getY() < this.y + minDistanceToEdge) {
			increaseY(player.getY() - (y + minDistanceToEdge));
		} else { 
			if (player.getY() + player.getHeight() > y + height - minDistanceToEdge) {
				increaseY(player.getY() + player.getHeight() - (y + height - minDistanceToEdge));
			}
		}
			
		}
	}
	
	public void increaseX(int increment) {
		x += increment;
	}
	
	public void increaseY(int increment) {
		y += increment;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isEntityOnScreen(Entity e) {
		return 	(e.getX() < x + width && e.getX() + e.getWidth() > x) ||
				(e.getY() < y + height && e.getY() + e.getHeight() > y);

	}
}