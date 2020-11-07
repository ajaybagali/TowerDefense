package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
/**
 * Starts a gamestate which controls the other classes 
 * Calls other classes to build the game path and different objects that run on the path
*   @author Ajay Bagali and Gurpurtap Bhatti
 *   Professor Jensen
 *
 */
public class GameState {
	private BufferedImage backdrop; // the background image
	private BufferedImage enemy; //enemy image
	private Path gardenPath ; //path
	private double percentage;
	//private Point center = new Point (0,0);
	//private ImageObserver observer;
	private int credits,lives;
	//private mouse.x, mouse.y;
	private boolean isGameOver, isPlaying,isNotStarted;
	private boolean buttonActionPending;
	ArrayList<Animatable> active;
	ArrayList<Animatable> expired;
	ArrayList<Animatable> pending;
	private GameState state;
	private ResourceLoader loader;
	private Point mouseLocation;
	private boolean noTowerMoving ;
	private int score;

public GameState()
{
	isNotStarted = true; //making a boolean to make a string that gives instructions before the game starts
	noTowerMoving=true;
	score =0;
	lives =5;
	credits =200;
	active = new ArrayList<Animatable>();
	pending = new ArrayList<Animatable>();
	expired = new ArrayList<Animatable>();

	 loader = ResourceLoader.getLoader();
	backdrop = loader.getImage("Tower DefensePath.jpg");    // Returns the image from resources/snail.png
	enemy = loader.getImage("BeeTowerDefense.png");
	

	gardenPath = loader.getPath("Tower DefensePath.txt");    // Builds a path object from resources/path_2.txt
	
	//state = new GameState();
	
	active.add(new EnemyBee(gardenPath, loader, this));
	active.add(new EnemyButterfly(gardenPath, loader, this));
	active.add(new BugCatcherMenuItem(this,new Point(700,200))); //adding the tower to the active list
	active.add(new HunterMenuItem(this,new Point(700,500))); //adding the tower to the active list

		// Assume the circle has traveled 0% along the path.
		//percentage = 0;
		
		
}

public int getCredits()
{
	return credits;
}
public void update()

{
	isNotStarted = false; //im settiing this boolean to false because the game is running at this point
	double number = Math.random();
	
	if(number< 0.05)
		if(number< 0.01)
		addAnimatable(new EnemyButterfly(gardenPath, loader, this)); //making the rare amount of enemies as butterflies
	else 
		addAnimatable(new EnemyBee(gardenPath, loader, this));//making the bees as the most amount of enemies
	

	
	for(Animatable a : active)
	{
		if(a instanceof Enemy && ((Enemy)a).percentage  > 1)
		{removeAnimatable(a);
			adjustLives(-1);
			
		}
		a.update();
	}
	active.addAll(pending); //im adding the pending lists to the active lists so it can get drawn on the map
	active.removeAll(expired);
	expired.removeAll(expired);// im removing all the lists so the game doesnt lag
	pending.removeAll(pending);
	buttonActionPending = false; 
}



public void removeAnimatable(Animatable e)
{
	if( e instanceof BugCatcherMoving || e instanceof HunterMoving) //if there is a tower near by, then set the boolean to true
	{
		noTowerMoving = true;
	}
	this.expired.add(e);  //adding it to the expired list
}
public void addAnimatable(Animatable n)
{

	this.active.add(n); //adding the animatable to the list
	
}
public boolean getTowerMoving()
{
	return noTowerMoving; 
	
}
public void addPending(Animatable n)
{
	if( n instanceof BugCatcherMoving || n instanceof HunterMoving)
	{
		noTowerMoving = false;
	}
	this.pending.add(n); //adding it to the pending list
}


public void draw (Graphics g)
{
	
	// Draw the background.
		
		
		g.drawImage(backdrop,  0, 0, null);    
		g.setColor(Color.CYAN);
		g.fillRect(600, 0, 200, 600);
		BufferedImage image = ResourceLoader.getLoader().getImage("gameover.png"); //giving the game a game over image
		if(!hasLives()) //if the user gets to zero lives, then display the game over png
		{
			g.drawImage(image,300,300,300,300,null);
			active.clear();
		}
		
		g.setColor(Color.BLACK);
		g.drawString("Score:" + score, 650, 60);
		g.drawString("Credits:" + credits, 650, 80);
		g.drawString("Lives:" + lives, 650, 100);
		
		if(isNotStarted) //if the game has not started yet, im giving instructions on as to how to start the game
		{
			g.setColor(Color.RED);
			g.drawString("Click to Start",280,280);
			
		}
		
		for(Animatable a : active)
		a.draw(g); //drawing all the animatables in the active list
		
		
		
}
public boolean hasLives()
{
	if(lives == 0) //getting this boolean to check if the game should be over or not depending on the amount of lives the user has
		return false;
		else
			return true;
}

public void adjustLives(int amount)
{

	lives += amount; //decreasing lives as the enemies reach end of the path
	if(lives<0)
			lives =0;

}
public void adjustScore(int amount)
{

	score += amount; //decreasing lives as the enemies reach end of the path
	

}
public void adjustCredits(int amount)
{
	
	credits += amount; //incrementing credits as they select a tower
	if(credits<0)
			credits =0;
}

public void  setMousePos      (Point p)       // Records the current mouse position
{
	this.mouseLocation = p;
	
}
public Point getMousePos      ()              // Returns the current mouse position
{
	return this.mouseLocation;
	
}
public void  setMousePressed  ()              // Sets a boolean flag to true (to indicate a mouse press)
{
	buttonActionPending = true;
}
public void  clearButtonActionPending ()             // Clears the mouse press boolean flag
{
	buttonActionPending = false;
}
public boolean getButtonActionPending ()             // Returns the value of the mouse press flag
{
	return buttonActionPending;
	
}



public Enemy findNearestEnemy (Point p)       // Finds the active enemy nearest to point p, returns it
{
	Enemy closest =null;
	for(Animatable a:active) //in the animatable list
	{
		if(a instanceof Enemy) 
		{
			Enemy e = (Enemy) a; //im using polymorphism to compare the two enemies
		
		if (closest == null)
			closest = e;
		else if (e.getLocation().distance(p) < closest.getLocation().distance(p)) //if its near the closest object then return the closes object
			closest =e;
	}
	
	}
	
	return closest; //im returning the points of the closest enemy
	
}
                                            
}
