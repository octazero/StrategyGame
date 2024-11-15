package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Hoplite extends baseUnit{
private static boolean upgrade = false;
	public Hoplite()
	{
		name = "Hoplite";
		objectType = 0;
		health = 200;
		maxHealth = 200;
		level = 0;
		experience = 0;
		buildTime = 3;
		cost = new Resource(0,150,0,150);
		movement = 2;
		range = 1;
		power = 150;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\Hoplite.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public boolean Atk(baseUnit attackedUnit)
	{
		if(turnEnd == true)
			return false;
		if(attackedUnit.name.equals("Knight"))
		{
			Knightenemy(attackedUnit);
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
        private void Knightenemy(baseUnit attackedUnit)
        {
           attackedUnit.health-=power+50; 
        }
        public boolean Upgradable() 
	{
		if(upgrade == true)
			return false;
		else
		{
			upgrade = true;
			cost = new Resource(0,100,0,100);
		}
		return true;
	}
}
