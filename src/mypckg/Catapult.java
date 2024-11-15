package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Catapult extends baseUnit{
private static boolean upgrade = false;
	public Catapult()
	{
		name = "Catapult";	
		objectType = 0;
		health = 350;
		maxHealth = 350;
		level = 0;
		experience = 0;
		buildTime = 2;
		cost = new Resource(0,100,0,75);
		movement = 1;
		range = 2;
		power = 200;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\Catapult.png")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public boolean Atk(baseUnit attackedUnit)
	{
		if(turnEnd == true)
			return false;
		unitDestroyer(attackedUnit);
		if(attackedUnit.getHealth() <= 0)
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
		buildingDestroyer(attackedBuilding);
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
        private void buildingDestroyer(baseBuilding attackedBuilding)
        {
            attackedBuilding.health-=(power*3);
        }
        private void unitDestroyer(baseUnit attackedUnit)
        {
            attackedUnit.health-=(power*3);
        }
        public boolean Upgradable() 
	{
		if(upgrade == true)
			return false;
		else
		{
			upgrade = true;
			buildTime--;
		}
		return true;
        }
        
}
