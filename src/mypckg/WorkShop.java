package mypckg;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class WorkShop extends baseBuilding{
	public WorkShop(ArrayList Civ)
	{
		name = "WorkShop";		
		objectType = 1;
                buildTime = 3;
                health = 2000;
                maxHealth = 2000;
		canBuild = new ArrayList<String>();
		for(int i = 0 ; i < Civ.size() ; i++)
		{
			canBuild.add((String) Civ.get(i));
		}	
		cost = new Resource(100,100,100,100);
                       try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\seigeworkshop2.png")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
        public WorkShop()
	{
		name = "WorkShop";		
		objectType = 1;
                buildTime = 3;
                health = 2000;
                maxHealth = 2000;
		canBuild = new ArrayList<String>();	
		cost = new Resource(100,100,100,100);
                       try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\seigeworkshop2.png")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}