package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class AxeMan extends baseUnit{
private static boolean upgrade = false;
	public AxeMan()
	{
		name = "AxeMan";	
		objectType = 0;
		health = 100;
		maxHealth = 100;
		level = 0;
		experience = 0;
		buildTime = 2;
		cost = new Resource(0,100,0,75);
		movement = 2;
		range = 1;
		power = 500;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\AxeMan.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public boolean Atk(baseUnit attackedUnit)
	{
		if(turnEnd == true)
			return false;
		attackedUnit.health-=power;
                decreasePower();
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
		attackedBuilding.health-=power;
                decreasePower();
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
        private void decreasePower()
        {
            if(power>50);
            power-=50;
        }
        public boolean Upgradable() 
	{
		if(upgrade == true)
			return false;
		else
		{
			upgrade = true;
			level++;
		}
		return true;
	}
}
