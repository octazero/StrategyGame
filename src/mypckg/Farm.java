package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Farm extends baseBuilding implements IAdd{
	public Farm()
	{
		cost = new Resource(100,100,100,100);
                name="Farm";
                objectType=1;
                health = 500;
                buildTime = 2;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\farm1.jpg")));
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