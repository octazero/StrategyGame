package mypckg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Knight extends baseUnit{
    private static boolean upgrade = false;
	public Knight() 
	{
		name = "Knight";	
		objectType = 0;
		health = 400;
		maxHealth = 400;
		level = 0;
		experience = 0;
		buildTime = 4;
		cost = new Resource(0,150,0,150);
		movement = 4;
		range = 1;
		power = 300;
        try {
              unitImage = new ImagenPerso(ImageIO.read(new File("Age of Empires\\imageedit_1_2544114001.gif")));
        } catch (IOException ex) {
            Logger.getLogger(Knight.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public boolean Atk(baseUnit attackedUnit)
	{
		if(turnEnd == true)
			return false;
		if(attackedUnit.name.equals("Archer") || attackedUnit.name.equals("Soldier")||attackedUnit.name.equals("WarElephant"))
		{
			Breserk(attackedUnit);
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
		turnEnd = true;
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
			turnEnd = true;
		return true;
	}
        private void Breserk(baseUnit attackedUnit)
        {
            if(attackedUnit.name.equals("Archer") || attackedUnit.name.equals("Soldier"))
		{
			attackedUnit.health = 0;
		}
		else if(attackedUnit.name.equals("WarElephant"))
		{
			attackedUnit.health-=(power*2);
		}
        }
	public boolean Upgradable() 
	{
		if(upgrade == true)
			return false;
		else
		{
			upgrade = true;
			power*=2;
			maxHealth = 450;
			range++;
		}
		return true;
	}
}
