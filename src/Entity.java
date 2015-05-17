import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * All objects in the game world are represented by Entity.
 * The shared properties allow for easily implemented updating, rendering and collision detection.
 */
public class Entity {
	
	private int x,y;
	private int width,height;
	private Image img;
	private int dx,dy;
	private boolean solid;
	private Shape hitbox;
	private int xOffset,yOffset;
	
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
		dx = 0;
		dy = 0;
		this.solid = solid;
		setHitbox(new Rectangle(x,y,img.getWidth(),img.getHeight()),0,0);
	}
	
	/**
	 * Set the hitbox.
	 */
	public void setHitbox(Shape shape, int xOffset, int yOffset) {
		hitbox = shape;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void increaseX(int increment) {
		x += increment;
	}
	
	public void increaseY(int increment) {
		y += increment;
	}
	
	public Image getImage() {
		return img;
	}
	
	public int getDX() {
		return dx;
	}
	
	public int getDY() {
		return dy;
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public Shape getHitbox(){
		return hitbox;
	}
	
	/**
	 * Update this object, taking the time delta into account.
	 * 
	 * @param delta Time
	 */
	public void update(int delta) {}
	
	/**
	 * Render image at (x,y).
	 */
	public void render(int x, int y) {
		img.draw(x,y);
	}
	
	/**
	 * Return whether this and e are colliding.
	 * Returns false if either of these are non-solid.
	 * 
	 * @return Are this and e colliding?
	 */
	public boolean isColliding(Entity e) {
		if (!solid || !e.solid)return false;
		return hitbox.contains(e.hitbox);
	}
	
}
