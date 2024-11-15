package mypckg;

public abstract class baseUnit extends baseObject{
	protected int movement;
	protected int experience;
	protected int level;
	protected int power;
	protected int range;
	protected boolean defending;
	protected boolean turnEnd;
	public baseUnit()
	{
		movement = 3 ;
		experience = 1 ;
		level = 0 ;
	}
	public int getMovement()
	{
		return movement;
	}
	public void setMovement()
	{
		movement++;
	}
	public int getExperience()
	{
		return experience;
	}
	public void setExperience()
	{
		experience++;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel()
	{
		level++;
	}
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int h)
	{
		health+=h;
	}
	public int getAttackPower()
	{
		return power;
	}
	public void setAttackPower(int a)
	{
		power+=a;
	}
	public boolean Move()
	{
		if(turnEnd == true)
			return false;
		defending = false;
		turnEnd = true;
		return true;
	}
	public boolean setDefending(boolean newVal)
	{
		defending = newVal;
		return newVal;
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
		//If a unit successfully kills another unit it gains experience , if experience > certain value lvlup()
	}
	protected void lvlUp(int Level) //Level 1 gets additional percentage health based on original health
	{			                         //Level 2 gets +1 movement	                                         //Level 3 gets additional perecntage attackPower based on original attackPower
		switch (level)
		{
		case 1:
			setHealth(getHealth()+(getHealth())/2);
			break;
		case 2:
			movement+=1;
			break;
		case 3:
			setAttackPower(getAttackPower()+(getAttackPower())/2);		
			break;
		}	    	     	
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
		turnEnd = true;
		return true;
	}
	public int getRange()
	{
		return range;
	}
	public String toString()
	{
		String rt = new String("");
		rt+="Name: ";
		rt+=name;
		rt+=" Health: ";
		rt+=health;
		return rt;
	}
	public boolean getTurnEnd()
	{
		return turnEnd;
	}
	public void setTurnEnd(boolean newValue)
	{
		turnEnd = newValue;
	}
	public boolean Defend()
	{
		if(turnEnd == true)
			return false;
		defending = true;
		turnEnd = true;
		return true;
	}
        public int getmaxHealth()
        {
            return maxHealth;
        }
        public abstract boolean Upgradable();
}
