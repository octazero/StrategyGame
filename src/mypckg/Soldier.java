package mypckg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Soldier extends baseUnit{
	//Special Ability if Enemy Unit Health less than 50% health this unit deals 150% more damage
    private static boolean upgrade = false;
	public Soldier()
	{
		name = "Soldier";
		objectType = 0;
		health = 150;
		maxHealth = 150;
		level = 0;
		experience = 0;
		buildTime = 2;
		cost = new Resource(0,150,0,75);
		movement = 2;
		range = 1;
		power = 50;
                try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\8028276_orig (1).jpg")));
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
	{	if(turnEnd == true)
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
        public boolean Upgradable() 
	{
		if(upgrade == true)
			return false;
		else
		{
			upgrade = true;
			experience++;
		}
		return true;
	}
}
