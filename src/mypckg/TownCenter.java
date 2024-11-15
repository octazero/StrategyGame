package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class TownCenter extends baseBuilding{
	
	public TownCenter(ArrayList<String> Civ)
	{
		name = "TownCenter";
		objectType = 1;
                buildTime = 4;
                health = 3000;
                maxHealth = 3000;
		canBuild = new ArrayList<String>();
		for(int i = 0 ; i < Civ.size() ; i++)
		{
			canBuild.add(Civ.get(i));
		}
		cost = new Resource(100,0,100,0);
                try {
            unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\TownCenter.gif")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
        public TownCenter()
	{
		name = "TownCenter";
		objectType = 1;
                buildTime = 4;
                health = 3000;
                maxHealth = 3000;
		cost = new Resource(100,0,100,0);
                try {
            unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\TownCenter.gif")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}