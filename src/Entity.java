import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * All objects in the game world are represented by Entity.
 * The shared properties allow for easily implemented updating, rendering and collision detection.
 */
public class Entity {
	
	private float x,y;
	private int width,height;
	private Image img;
	private boolean solid;
	public Shape hitbox;
	private int xOffset, yOffset;
	
	/**
	 * Create a new Entity.
	 * Automatically sets up a rectangular hitbox lining up with img.
	 * 
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param img Image
	 * @param solid Can Entity objects pass through this object?
	 */
	public Entity(int x, int y, Image img, boolean solid) {
		this.x = x;
		this.y = y;
		this.img = img;
		width = img.getWidth();
		height = img.getHeight();
		this.solid = solid;
		setHitbox(new Rectangle(x,y,img.getWidth(),img.getHeight()),0,0);
	}
	
	public Entity(int x, int y, String path, boolean solid) throws SlickException {
		this(x,y,new Image(path), solid);
	}
	
	/**
	 * Set the hitbox used for collision detection. If an entity has an hitbox,
	 * it is collidable against other entities.
	 * @param xOffset
	 *            The offset of the hitbox on the x axis. Relative to the top
	 *            left point of the entity.
	 * @param yOffset
	 *            The offset of the hitbox on the y axis. Relative to the top
	 *            left point of the entity.
	 */
	public void setHitbox(Shape shape, int xOffset, int yOffset) {
		hitbox = shape;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.solid = true;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
		hitbox.setX(x);
	}
	
	public void setY(float y) {
		this.y = y;
		hitbox.setY(y);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void increaseX(float increment) {
		x += increment;
		hitbox.setX(x);
	}
	
	public void increaseY(float increment) {
		y += increment;
		hitbox.setY(y);
	}
	
	public Image getImage() {
		return img;
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public Shape getHitbox(){
		return hitbox;
	}
	
	public void setImg(Image img) {
		this.img = img;
	}
	
	/**
	 * Update this object, taking the time delta into account.
	 * 
	 * @param delta Time
	 */
	public void update(GameContainer container, int delta) {
		
	}
	
	/**
	 * Render image at (x,y).
	 */
	public void render(float x, float y) {
		img.draw(Math.round(x),Math.round(y));
	}
	
}
