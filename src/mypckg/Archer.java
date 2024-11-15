package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Archer extends baseUnit{
private static boolean upgrade = false;
	public Archer()
	{
		name = "Archer";
		objectType = 0;
		health = 75;
		maxHealth = 75;
		level = 0;
		experience = 0;
		buildTime = 3;
		cost = new Resource(0,150,0,100);
		movement = 2;
		range = 2;
		power = 75;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\Archer.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public boolean Atk(baseUnit attackedUnit)
	{
		if(turnEnd == true)
			return false;
		if(!"Archer".equals(attackedUnit.name))
		{
			antiTroops(attackedUnit);
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
        private void antiTroops(baseUnit attackedUnit)
        {
            attackedUnit.health-=(int)power*2.5;
        }
        public boolean Upgradable()
	{
		if(upgrade == true)
			return false;
		else
		{
			upgrade = true;
			range++;
		}
		return true;
	}
}
