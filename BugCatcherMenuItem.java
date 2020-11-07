package game;
/**
 * Tower on the meny item that can be clicked and placed on the map

*   @author Ajay Bagali and Gurpartap Bhatti
*   Professor Jensen
 */
import java.awt.Graphics;
import java.awt.Point;

public class BugCatcherMenuItem extends Effect {
	public BugCatcherMenuItem(GameState game, Point position)
	{
		super(game,position); //calling the tower superclass constructor
		
		image = ResourceLoader.getLoader().getImage("bugcatcher.png"); //giving it an image
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
	
		if(game.getButtonActionPending() && game.getMousePos().distance(position)<50&&game.getCredits()>=50 && game.getTowerMoving()) //if the mouse is clicked and is near the object image on the menu
		{

			game.addPending(new BugCatcherMoving(game,position)); //send in a new tower at the same position
			game.adjustCredits(-50); //when the tower is clicked lower credits
			game.clearButtonActionPending();
			//game.removeAnimatable(this);
		
		}
				
			
				
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, position.x, position.y,50,50, null); //drawing the tower whenever the draw method is called
	}

}
