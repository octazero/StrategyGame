package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ArcherChariot extends baseUnit{
private static boolean upgrade = false;
	public ArcherChariot()
	{
		name = "ArcherChariot";	
		objectType = 0;
		health = 250;
		maxHealth = 250;
		level = 0;
		experience = 0;
		buildTime = 2;
		cost = new Resource(0,100,0,75);
		movement = 4;
		range = 3;
		power = 125;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\Chariot1.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public boolean Atk(baseUnit attackedUnit)
	{
		if(turnEnd == true)
			return false;
		if("Knight".equals(attackedUnit.name))
		{
			KnightDestroyer(attackedUnit);
		}
		else
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
            if(turnEnd == true)
			return false;
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
        private void KnightDestroyer(baseUnit attackedUnit)
        {
            attackedUnit.health-=(power*2);
        }
        public boolean Upgradable() 
	{
		if(upgrade == true)
			return false;
		else
		{
			upgrade = true;
			range+=2;
		}
		return true;
	}
}
