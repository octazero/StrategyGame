package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ClubMan extends baseUnit{
private static int x;
private static boolean upgrade = false;
	public ClubMan()
	{
                x=0;
		name = "ClubMan";
		objectType = 0;
		health = 50;
		maxHealth = 50;
		level = 0;
		experience = 0;
		buildTime = 2;
		cost = new Resource(0,75,0,75);
		movement = 2;
		range = 1;
		power = 25;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\ClubMan.png")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public boolean Atk(baseUnit attackedUnit)
	{
		if(turnEnd == true)
			return false;
                if(x%5==0)
                    nailattack(attackedUnit);
                else{
                    x++;
		attackedUnit.health-=power;
                }
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
        private void nailattack(baseUnit attackedUnit)
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
			power*=2;
		}
		return true;
	}
}
