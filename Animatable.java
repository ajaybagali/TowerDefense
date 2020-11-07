package game;
/**
 * interface implemented by other methods
 *   @author Ajay Bagali and Gurpartap Bhatti
 *   Professor Jensen
 */
import java.awt.Graphics;
import java.awt.Point;

public interface Animatable  {
public void update(); //all classes that implements animatable can change their update and draw methods
public void draw (Graphics g);
//public Point getLocation();




}
