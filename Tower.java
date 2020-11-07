package game;
/**
 * This superclass is extended from other classes that store it as an animatable
*   @author Ajay Bagali and Gurpartap Bhatti
*   Professor Jensen
 */
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Tower implements Animatable 
	{
	protected BufferedImage image;
	protected Point position;
	protected GameState game;
	
	
	public Tower(GameState game, Point position)
	{
		this.game = game; //sending it parameters for the other accessor methods
		this.position = position;
	}
	public void draw (Graphics g)
	{
		Point center = position;
		g.drawImage(image, center.x-25, center.y-25, 50, 50, null); //drawing the enemy picture on the path
	}
	
	public void update()
	{
		if(game.getMousePos().distance(position)<50) //if the mouse gets near the tower object, clear the boolean
			game.clearButtonActionPending();
	}
	
}
