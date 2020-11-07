package game;
/**
* Tower subclass that is drawn when and it shoots when there is a nearby enemy
* author@ Ajay Bagali and Gurpartap Bhatti 
* Professor Jensen
*/
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.text.Position;

public class BugCatcher extends Tower {


private int frameCounter;
public BugCatcher( GameState state, Point position)
{
	super(state,position); //sending it to the tower constructor
	this.image = ResourceLoader.getLoader().getImage("bugcatcher.png"); //giving it an image
	this.frameCounter = 0;
}

	@Override
	public void update() 
	{
		// TODO Auto-generated method stub
		frameCounter++;
		Enemy c = game.findNearestEnemy(position); //finding the nearest enemy to the tower
		if(c==null)
			return;
		if(c.getLocation().distance(position)<60&&frameCounter %20 ==0) //if the location of the enemy is less than 60 then fire the flying net effect
		{
			Effect e = new FlyingNet(game,new Point(position),c.getLocation().x-position.x,c.getLocation().y-position.y); 
			game.addPending(e); //this adds the effect to a pending listwhich later gets cleared
		}
		
		
		
	}
	public void draw(Graphics g)
	{
		super.draw(g); //using the tower class's draw method
	}
	

}
