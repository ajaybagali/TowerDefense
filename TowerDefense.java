package game;
/**
 * This class draws the gui and keeps the gamestate and the mouselisteners in check
*   @author Ajay Bagali and Gurpartap Bhatti
*   Professor Jensen
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * A path test panel is a GUI panel that displays a tower
 * defense path on the screen, and animates a small object
 * moving along the path.
 * 
 * This class won't be part of the final project - we're just
 * using it for testing.
 * 
 * @author Ajay Bagali 
 * @version March 29, 2017  
 */
public class TowerDefense extends JPanel implements Runnable, ActionListener, MouseListener, MouseMotionListener
{
	// This constant avoids an obnoxious warning, but it is totally unused by us.
	//   It would only be relevant if we were using object serialization.

	private static final long serialVersionUID = 42L;


	// Fields (object variables) 

	private boolean clickToSTart = false;
	public GameState state;


	private JMenuItem restartitem;

	private JMenuItem quititem;
	
	 public static void main (String[] args)
	    {
	        // Main runs in the 'main' execution thread, and the GUI
	        //   needs to be built by the GUI execution thread.
	        //   Ask the GUI thread to run our 'run' method (at some
	        //   later time).
	        
	        SwingUtilities.invokeLater(new TowerDefense());

	        // Done.  Let the main thread of execution finish.  All the
	        //   remaining work will be done by the GUI thread.
	    }
	// Students will add a few more fields (object variables) to keep
	//   track of their path object, the circle position (as a percentage),
	//   and possibly a Timer object.

	// Methods


		
	

	/**
	 * Draws the image, path, and the animating ball.
	 * 
	 * (The background is not cleared, it is assumed the backdrop
	 * fills the panel.)
	 * 
	 * @param g the graphics object for drawing on this panel
	 */
	

	/**
	 * The actionPerformed method is called (from the GUI event loop)
	 * whenever an action event occurs that this object is listening to.
	 * 
	 * For our test panel, we assume that the Timer has expired, so
	 * we advance our small sphere along the path.
	 * 
	 * @param e the event object 
	 */
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		clickToSTart= true;
		
	}

		
	@Override
	public void mousePressed(MouseEvent e) {

		// TODO Auto-generated method stub

		//System.out.println(e.getX() + " " + e.getY()); //where ever i click on the picture, i get those x and y coordinates
		state.setMousePressed();

	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		state.clearButtonActionPending();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void paint(Graphics g)
	{
		state.draw(g); //draws the gamestate object
	}

	@Override
	 public void run ()
    {
        JFrame f = new JFrame("Path Tester"); // naming it path tester
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menubar =new JMenuBar();
        JMenu menu = new JMenu("File");
         restartitem = new JMenuItem("Restart");
         quititem = new JMenuItem("Quit");
        
        menu.add(restartitem); //adding options to the menubar 
        menu.add(quititem); 
        menubar.add(menu);
        f.setJMenuBar(menubar);
        restartitem.addActionListener(this);//giving action listeners to the button
        quititem.addActionListener(this);
        
        f.setContentPane(this); //implementing the pathtestpanel onto the content pane
        state = new GameState();
      	//ResourceLoader loader  = ResourceLoader.getLoader();  // Gets the resource loader object


      			// Students will do this.

      			// Set the size of this panel to match the size of the image.

      			Dimension panelSize = new Dimension(800,600);
      			
      			this.setMinimumSize(panelSize);
      			this.setPreferredSize(panelSize);
      			this.setMaximumSize(panelSize);
        f.pack();
        f.setLocationRelativeTo(null);  // Centers window
        f.setVisible(true);
        

			// Create a timer (for animation), have it call our actionPerformed
			//   method 60 times a second.
			Timer t = new Timer(16,this);
			t.start();
			
			// Students will do this.

			// Close the scanner.  (A good idea when working with InputStreams.

			// Students may uncomment this code:

		 this.addMouseListener(this);
		 this.addMouseMotionListener(this);
			
		
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(clickToSTart&&state.hasLives())
		{
		state.update();
		repaint(); //when the action is called it is called 
		}
		if(e.getSource() == quititem) //if they click quit then the program turns off
		{
			System.exit(0);
		}
		if(e.getSource()==restartitem) //when they click restart, the game restarts by starting a new game state
		{
			clickToSTart = true;
			state = new GameState();
		}
	}
	
	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		state.setMousePos(e.getPoint()); //i get that point when they mpve the mouse
	}
}
