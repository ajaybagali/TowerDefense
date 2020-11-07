package game;
/**
 * This object focuses on the actual tower placed on the map and it fires at enemies
*   @author Ajay Bagali and Gurpartap Bhatti
*   Professor Jensen
 */
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class BugCatcherMoving extends Effect{
	
		public BugCatcherMoving(GameState state, Point position)
		{
			super(state,position); //calling the effect constructor
	
			image = ResourceLoader.getLoader().getImage("bugcatcher.png");
		}
	
	
	public void update() {
		// TODO Auto-generated method stub
		position = game.getMousePos(); //giving the current mouse position 
		BufferedImage temp= ResourceLoader.getLoader().getImage("Tower DefensePath.jpg");
		if (game.getButtonActionPending()&&game.getMousePos().x<600
			&&temp.getRGB(position.x, position.y)<-6000000 //if the tower is near the range of the path color, then it cant be placed in the general area
			&&temp.getRGB(position.x, position.y)>-10000000)
		{
			
		
		
		

			game.clearButtonActionPending();
			game.addPending(new BugCatcher(game,position));

			game.removeAnimatable(this);//removing the tower of this object instance
			
			
		}
		if (game.getButtonActionPending()&&game.getMousePos().x>600 ) //if the mouse is pressed and if its position is in the menu, clear the tower and return credits
		{
			game.clearButtonActionPending();
			game.adjustCredits(50); //incrementing credits once a enemy is hit
			game.removeAnimatable(this);
		}
}


	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, position.x-25, position.y-25,50,50, null); //drawing the tower 
	}
}

