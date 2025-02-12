package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class GoldMine extends baseBuilding implements IAdd{

	public GoldMine()
	{
		cost = new Resource(100,100,100,100);
                objectType=1;
                name="GoldMine";
                health = 500;
                maxHealth = 500;
                buildTime = 2;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\MiningCampAoEII.png")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	public void add(Resource r)
	{
		int x = r.getFood();
	    r.setFood(x);
	}
}