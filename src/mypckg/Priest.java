package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Priest extends baseUnit{
private static boolean upgrade = false;
	public Priest()
	{
		name = "Priest";
		objectType = 0;
		health = 75;
		maxHealth = 75;
		level = 0;
		experience = 0;
		buildTime = 4;
		cost = new Resource(0,150,0,200);
		movement = 2;
		range = 1;
		power = 50;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\Priest.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public boolean Atk(baseUnit attackedUnit)
	{
		if(turnEnd == true)
			return false;
		heal(attackedUnit);
		if(attackedUnit.getHealth() == attackedUnit.getmaxHealth())
		{		
			this.setExperience();
			if(this.getExperience() > experience)
			{
				setLevel();
				lvlUp(getLevel());
			}
		}
		return true;
	}
	public boolean Atk(baseBuilding attackedBuilding)
	{		
            if(turnEnd == true)
			return false;
		if(attackedBuilding.getHealth() <= 0)
		{		
			this.setExperience();
			if(this.getExperience() > experience)
			{
				setLevel();
				lvlUp(getLevel());
			}
		}
		return true;
	}
        private void heal(baseUnit HealedUnit)
        {
            HealedUnit.health+=power;
        }
        public boolean Upgradable() 
	{
		if(upgrade == true)
			return false;
		else
		{
			upgrade = true;
			experience++;
		}
		return true;
	}
}
