package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Villager extends baseUnit{
private static boolean upgrade = false;
	public Villager()
	{
		name = "Villager";	
		objectType = 0;
		health = 50;
		maxHealth = 50;
		level = 0;
		experience = 0;
		buildTime = 2;
		cost = new Resource(0,50,0,50);
		movement = 4;
		range = 1;
		power = 15;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\imageedit_14_2441530779.gif")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public boolean Atk(baseUnit attackedUnit)
	{
		if(turnEnd == true)
			return false;
		attackedUnit.health-=power;
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
		attackedBuilding.health-=power;
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
        public boolean Upgradable() 
	{
		if(upgrade == true)
			return false;
		else
		{
			upgrade = true;
			maxHealth = 75;
			power*=2;
		}
		return true;
	}
}
