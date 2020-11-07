package game;
/**
 * Enemy superclass that gets called by other enemy classes
 *   @author Ajay Bagali and Gurpurtap Bhatti
 *   Professor Jensen
 */
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public abstract class Enemy implements Animatable {
	protected BufferedImage image;
	protected double percentage;
	protected GameState gameState;
	protected Path path;
	protected Point center;// = new Point(0,0);
	


	public Enemy()
	{
		
	}
	public void update()
	{
		if(percentage > 1) //to restart it, i change the percentage back to 0
			percentage =0;

		percentage +=.001; //im incrementing the percentage by .001
		center = path.getPathPosition(percentage);
	}

	public void draw (Graphics g)
	{
		Point center = getLocation();
		g.drawImage(image, center.x-25, center.y-25, 50, 50, null); //drawing the enemy picture on the path
	}
	public Point getLocation()
	{
		return path.getPathPosition(percentage); //getting the percentage of the enemy on the path
	}


}
