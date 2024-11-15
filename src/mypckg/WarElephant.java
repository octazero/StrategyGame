package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class WarElephant extends baseUnit{
private static boolean upgrade = false;
	public WarElephant()
	{
		name = "WarElephant";	
		objectType = 0;
		health = 700;
		maxHealth = 700;
		level = 0;
		experience = 0;
		buildTime = 2;
		cost = new Resource(0,200,0,200);
		movement = 4;
		range = 1;
		power = 500;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\Armoured_Elephant.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public boolean Atk(baseUnit attackedUnit)
	{
		if(turnEnd == true)
			return false;
                angry();
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
                angry();
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
        private void angry()
        {
            if(health<=350)
                power*=2;
            if(health>350&&power>500)
                power=500;
        }
        public boolean Upgradable()
	{
		if(upgrade == true)
			return false;
		else
		{
			upgrade = true;
			range++;
			maxHealth = 800;
		}
		return true;
	}
}
