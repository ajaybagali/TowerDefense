package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * ResourceLoader class
 * author-Ajay Bagali
 * Professor Jensen
 * 4/10/17
 */

public class ResourceLoader {
	
	private Map<String, Object > images = new HashMap<> (); //making a hashmap to store the different images
	private Map<String, Object > paths = new HashMap<> ();//making a hashmap to store the different paths
	
	private ClassLoader myLoader = this.getClass().getClassLoader();
	
	//private BufferedImage backdrop;
	static private ResourceLoader instance; //creating an instance

	private ResourceLoader()
	{
		

	}

	
	
/**
 * takes an image from the resources folder and puts it into the hashmap so it can be used in the game
 * @param imageName
 * @return
 */
	public BufferedImage getImage (String imageName)
	{
		
		BufferedImage result = null;
		try
		{
			if(images.containsKey(imageName))
			{
				return (BufferedImage) images.get(imageName); //making sure that the image stored in the resource folder is called
			}
			else
			{
				
				InputStream imageStream = myLoader.getResourceAsStream("resources/" +  imageName);//contacting it so it becomes easier to load the image
				result = javax.imageio.ImageIO.read(imageStream);  // A handy helper method
				images.put(imageName, result);
				return (BufferedImage) images.get(imageName);
				
			}
				
		}
		catch (IOException e)
		{
			// On error, just print a message and exit.  
			//   (You should make sure the files are in the correct place.)

			System.err.println ("Could not load one of the files.");
			System.exit(0);  // Bail out.
		}        
	
			
		
		
		return result;
	}
	
	
		
	

	static public ResourceLoader getLoader()
    {
        if (instance == null)
          instance = new ResourceLoader ();

        return instance;
    }


/**
 * takes in path and returns the path that the user puts in to make sure the object runs on that path
 * @param string
 * @return
 */
	public Path getPath(String string) {
		Path gardenpath = null;
		if(paths.containsKey("Tower DefensePath.text")) //making sure that the path i want is in the map
		{
			return (Path) paths.get("Tower DefensePath.text"); //making sure i return my path
		}
		
		else
		{
			InputStream pointStream = myLoader.getResourceAsStream("resources/Tower DefensePath.txt");
			Scanner in = new Scanner (pointStream); // A handy helper method
			gardenpath= new Path(in); //giving the scanner the path txt file for the object to follow
			paths.put("Tower DefensePath.txt", gardenpath);
			return (Path) paths.get("Tower DefensePath.txt"); //making sure i return my path
		}
			
		
		
	}




	
}
