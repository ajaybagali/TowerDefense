package game;
/**
 * Effect superclass that someclasses extend into and it draws it based on the given position and image 
 * author@ Ajay Bagali and Gurpartap Bhatti 
 * Professor Jensen
 */

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public abstract class Effect implements Animatable  {
	protected BufferedImage image;
	protected Point position;
	protected GameState game;
public Effect(GameState game, Point position)
{
	this.position = position;
	this.game = game;
}
	
	
	
	public abstract void draw (Graphics g); //all classes that extend effect use the draw and update methods
	
	public abstract void update();

	
	public Point getLocation()
	{
		return position;
	}

}
