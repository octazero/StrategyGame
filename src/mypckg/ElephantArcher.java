package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ElephantArcher extends baseUnit{
private int killNum;
private static boolean upgrade = false;
	public ElephantArcher()
	{
		name = "ElephantArcher";	
		objectType = 0;
		health = 350;
		maxHealth = 350;
		level = 0;
		experience = 0;
		buildTime = 2;
		cost = new Resource(0,100,0,100);
		movement = 3;
		range = 6;
		power = 200;
		killNum = 0;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\Elephant_archer_2.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public boolean Atk(baseUnit attackedUnit)
	{
		if(turnEnd == true)
			return false;
		if(killNum == 3)
		{
			instantKill(attackedUnit);
		}
		else
		attackedUnit.health-=power;
		if(attackedUnit.getHealth() <= 0)
		{	
			++killNum;
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
        private void instantKill(baseUnit attackedUnit)
        {
            attackedUnit.health-= 0;
			killNum = 0;
        }
        public boolean Upgradable() 
	{
		if(upgrade == true)
			return false;
		else
		{
			upgrade = true;
			power*=2;
			maxHealth = 400;
		}
		return true;
	}
}
        