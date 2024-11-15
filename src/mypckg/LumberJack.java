package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class LumberJack extends baseBuilding implements IAdd{

	public LumberJack()
	{
		cost = new Resource(100,100,100,100);
                objectType=1;
                name="LumberJack";
                health = 500;
                maxHealth = 500;
                buildTime = 2;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\LumberJack.png")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public void add(Resource r)
	{
		int x = r.getWood();
	    r.setWood(x);
	}
}