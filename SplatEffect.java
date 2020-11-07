package game;
/**
 * This object extends effect and leaves a splat image when the enemy dies
*   @author Ajay Bagali and Gurpartap Bhatti
*   Professor Jensen
 */
import java.awt.Graphics;
import java.awt.Point;

public class SplatEffect extends Effect { 
		private int frameCounter;

		public SplatEffect(GameState game, Point position)
		{
			super(game,position); //calling the tower superclass constructor
			
			image = ResourceLoader.getLoader().getImage("bluesplat.png"); //giving it an image
			this.frameCounter=0;
		}

		@Override
		public void draw(Graphics g) {
			// TODO Auto-generated method stub
			g.drawImage(image, position.x-25, position.y-25,50,50, null); 
		}

		@Override
		public void update() {
			// TODO Auto-generated method stub
		this.frameCounter++;
		if(frameCounter ==30) //making sure i draw the effect at a reasonable rate and removing it soon
		{
			game.removeAnimatable(this);
		}
		}
}
