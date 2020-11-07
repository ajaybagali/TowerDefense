package game;
/**
* Tower subclass that is drawn when and it shoots when there is a nearby enemy
* author@ Ajay Bagali and Gurpartap Bhatti 
* Professor Jensen
*/
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.text.Position;

public class Hunter extends Tower {


private int frameCounter;
public Hunter( GameState state, Point position)
{
	super(state,position);
	this.image = ResourceLoader.getLoader().getImage("hunter.png"); //giving it an image
	this.frameCounter = 0;
}

	@Override
	public void update() 
	{
		// TODO Auto-generated method stub
		frameCounter++;
		Enemy c = game.findNearestEnemy(position); //im finding the nearest enemy to the tower
		if(c==null)
			return;
		if(c.getLocation().distance(position)<60&&frameCounter % 20 ==0)//im gving the tower a range and a speed for which it shoots an arrow
		{
			Effect e = new FlyingArrow(game,new Point(position),c.getLocation().x-position.x,c.getLocation().y-position.y);
			game.addPending(e); //after it fires, i send it to the pending list
		}
		
		
		
	}
	public void draw(Graphics g)
	{
		super.draw(g); //using the tower class's draw method
	}
	

}

