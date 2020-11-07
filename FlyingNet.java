package game;
/**
* Effect subclass that is drawm when the specific tower calls it and it removes the animatable once the effect hits it
* author@ Ajay Bagali and Gurpartap Bhatti 
* Professor Jensen
*/
import java.awt.Graphics;
import java.awt.Point;

public class FlyingNet extends Effect{
private int vX;
private int vY;
private int frameCounter;

	public FlyingNet(GameState game, Point position,int vX, int vY) {
		super(game, position);
		this.vX=vX;
		this.vY=vY;
		this.frameCounter =0;
		this.image = ResourceLoader.getLoader().getImage("neteffect.png");
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw (Graphics g)
	{
		Point center = position;
		g.drawImage(image, center.x, center.y, 20, 20, null); //drawing the enemy picture on the path
	}
	

	@Override
	public void update() {
		position.x += vX/10;
		position.y += vX/10;
		frameCounter++;
		if(frameCounter ==10) //i set a frame counter so it doesnt shoot as much
		{
			Enemy c = game.findNearestEnemy(position);
			if(c==null)
				return;
			if(c.getLocation().distance(position)<60) //Im giving the effect a range
			{
				//Effect e = new FlyingNet(game,new Point(position),c.getLocation().x-position.x,c.getLocation().y-position.y);
				game.removeAnimatable(c);
				game.adjustScore(20);
				game.adjustCredits(10);
				game.addPending(new SplatEffect(game,new Point(c.getLocation().x,c.getLocation().y))); //im adding a splat effect to the spot where the enemy died
			}
		
			game.removeAnimatable(this);
		}
		// TODO Auto-generated method stub
		
	}

}
