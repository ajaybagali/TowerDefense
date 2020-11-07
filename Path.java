package game;

/**
 * Storing the path coordinates and making a line for the path
@author Ajay Bagali
* @version March 21, 2017
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Scanner;

public class Path {
//fields
	private Point [] array;
	private double pathLength;
//methods
/**
 * taking scanner input from the text file and putting those points into a new array as points
 * @param in
 */
	public Path (Scanner in) //taking in the scanner
	{
		
		int size = in.nextInt();
		array = new Point[size];
		for (int i =0; i <size; i ++)
		{
		int x = in.nextInt();
		int y = in.nextInt();
		Point p = new Point(x,y); //setting the texts in the file as points in the array
		array[i] = p;
		
		
		}
		pathLength(); //calling the path length method
		//getPathPosition(.25);
		
	}
/**
 * drawing a line based on the points from the text file
 * @param g
 */
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		for (int i =1; i < array.length; i++) //setting a for loop to draw each points on my points
		{
			g.drawLine(array[i-1].x, array[i-1].y, array[i].x, array[i].y); //drawing it point by point
			
			
		}
		
	}
	/** 
	 * Returns the total length of the path. Since the path
	 * is specified using screen coordinates, the length is
	 * in pixel units (by default).
	 * 
	 * @return the length of the path
	 */
	 public void pathLength ()
	 {
		 double pathLength = 0;
		for(int i =1; i < array.length; i ++ ) 
		{
			pathLength = pathLength  + array[i-1].distance(array[i]);  //using the distance formula for each of the points on my text file
			
		
		}
	
		 //System.out.println(pathLength);
		 this.pathLength = pathLength;
		//return this.pathLength;
		 
	 }
	 /** 
	  * Given a percentage between 0% and 100%, this method calculates
	  * the location along the path that is exactly this percentage
	  * along the path. The location is returned in a Point object
	  * (int x and y), and the location is a screen coordinate.
	  * 
	  * If the percentage is less than 0%, the starting position is
	  * returned. If the percentage is greater than 100%, the final
	  * position is returned.
	  * 
	  * If students don't want to use Point objects, they may 
	  * write or use another object to represent coordinates. 
	  *
	  * Caution: Students should never directly return a Point object
	  * from a path list. It could be changed by the outside caller.
	  * Instead, always create and return new point objects as
	  * the result from this method.
	  * 
	  * @param percentTraveled a distance along the path
	  * @return the screen coordinate of this position along the path
	  */
	  public Point getPathPosition (double percentTraveled)
	  {
		  if (percentTraveled <= 0) //making sure that if a user gives a negative or 0 percentage that it returns the first point
		  
			  return new Point (array[0]);
		  if (percentTraveled >= 1.0)
			  return new Point (array[array.length-1]);
		  
			  
		  
		  double distanceFromStart = 0;
		  int segmentNumberIn =0;
		  double distanceInSegment =0;
		  double distanceTraveled = this.pathLength * percentTraveled; //using the method to take the distance and multiply it with the given percentage
		  for(int i =1; i < array.length; i ++ ) 
			{
				distanceFromStart = distanceFromStart + array[i-1].distance(array[i]);  // distance from start is taking the distance from the two points
				if(distanceFromStart>distanceTraveled)
				{
					segmentNumberIn = i; //once if find the remaining distance, i find which segment it in
					distanceFromStart = distanceFromStart -  array[i-1].distance(array[i]); //i then take its distance in the segment
					break; //i break the code because i have the distance i need
				}
				
			}
		 distanceInSegment = distanceTraveled - distanceFromStart; //take the distance in the segment and subtract it from the starting distance
		 double scalar = distanceInSegment/ (array[segmentNumberIn-1].distance(array[segmentNumberIn])); //i then find its scalar by dividing the distance by the distance in the segment
		 int x = (int)(array[segmentNumberIn-1].x * (1-scalar) + array[segmentNumberIn].x * scalar); //i mulitply it by the scalar to find the x coordinate of that percentage
		 
		 int y = (int)(array[segmentNumberIn-1].y * (1-scalar) + array[segmentNumberIn].y * scalar);//i mulitply it by the scalar to find the y coordinate of that percentage
		
		return new Point(x,y);
		 
	  }
	
	
}
