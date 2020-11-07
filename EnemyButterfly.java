package game;
/**
* Enemy subclass that follows a path
* author@ Ajay Bagali and Gurpartap Bhatti 
* Professor Jensen
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EnemyButterfly extends Enemy {
	//protected BufferedImage waspimage;
	//protected double percentage;
	//protected GameState gameState;
//	protected Path path;
	
	
	public EnemyButterfly (Path path,ResourceLoader loader, GameState state)
	{
		this.percentage = 0;
		this.path= path; //giving it the path coordinates
		image = loader.getImage("ButterflyTowerDefense.png"); 
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
	}
	public void draw(Graphics g)
	{
		super.draw(g);
	}

	

}

