package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class HopliteChariot extends baseUnit{
private static boolean upgrade = false;
	public HopliteChariot()
	{
		name = "HopliteChariot";	
		objectType = 0;
		health = 250;
		maxHealth = 250;
		level = 0;
		experience = 0;
		buildTime = 3;
		cost = new Resource(0,200,0,150);
		movement = 4;
		range = 1;
		power = 200;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\Chariot.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public boolean Atk(baseUnit attackedUnit)
	{
		if(turnEnd == true)
			return false;
		if(attackedUnit.name.equals("Hoplite") || attackedUnit.name.equals("Soldier"))
		{
			hasty(attackedUnit);
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
        private void hasty(baseUnit attackedUnit)
        {
            attackedUnit.health=0;
        }
        public boolean Upgradable() 
	{
		if(upgrade == true)
			return false;
		else
		{
			upgrade = true;
			movement+=2;
		}
		return true;
	}
}
