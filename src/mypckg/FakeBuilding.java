package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class FakeBuilding extends baseBuilding{
	public FakeBuilding(String name)
	{
		this.name = name;
		canBuild = null;
		health = 1000;
		maxHealth = 1000;
		objectType = 1;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\fakeBuilding.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
