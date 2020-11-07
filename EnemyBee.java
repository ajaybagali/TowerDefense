package game;

  /**
 * Enemy subclass that follows a path
 * author@ Ajay Bagali and Gurpartap Bhatti 
 * Professor Jensen
 */
 
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EnemyBee extends Enemy {
	//protected BufferedImage beeimage;
	//protected double percentage;
	//protected GameState gameState;
	//protected Path path;
	
	public EnemyBee (Path path, ResourceLoader loader , GameState state)
	{
		//System.out.println("EnemyBee");
		this.percentage = 0;
		this.path= path;
		image = loader.getImage("BeeTowerDefense.png");
		//.out.println("EnemyBee");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
	}
	public void draw(Graphics g)
	{
		super.draw(g);//calling the draw method from the enemy class
	}

	

}
