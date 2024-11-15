package mypckg;

import java.io.Serializable;

public class Player implements Serializable{
    private String name,country;
    private Resource playerR;
    private int playerOwn,unitNum,buildingNum;
    private boolean loged;
    private int countUnitAttacks;
    private int countUnitsKilled;
    private int countUnitMoves;
    private int countBuildingsBuilt;
    private int countBuildingsDestroyed;
    private int countUnitsBuilt;
    private String Civ;
    
    public String getCivName()
    {
    	return "Civ"+Civ;
    }
    public void setCivName(String st)
    {
    	Civ = st;
    }
    public void setcountUnitAttacks()
    {
    	countUnitAttacks++;
    }
    public void setcountUnitsKilled()
    {
    	countUnitsKilled++;
    }
    public void setcountBuildingsDestroyed()
    {
    	countBuildingsDestroyed++;
    }
    public void setcountBuildingsBuilt()
    {
    	countBuildingsBuilt++;
    }
    public void setcountUnitsBuilt()
    {
    	countUnitsBuilt++;
    }
    public void setcountMoves()
    {
    	countUnitMoves++;
    }
	public Player()
	{
		playerR = new Resource(1000,1000,1000,1000);
        name=new String();
        countUnitAttacks = 0;
        countUnitsKilled = 0;
        countUnitMoves = 0;
        countBuildingsBuilt = 0;
        countBuildingsDestroyed = 0;
        countUnitsBuilt = 0;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String newVal)
	{
		name = newVal;
	}
	public void subtractResource(Resource input)
	{
		playerR.subtract(input);
	}
	public void addResource(Resource input)
	{
		playerR.add(input);
	}
	public Resource getPlayerR()
	{
		return playerR;
	}
	public int getPlayerOwn()
	{
		return playerOwn;
	}
	public void setPlayerOwn(int newVal)
	{
		playerOwn = newVal;
	}
	public void setUnitNum(int newValue)
	{
		unitNum = newValue;
	}
	public void setBuildingNum(int newValue)
	{
		buildingNum = newValue;
	}
	public int getUnitNum()
	{
		return unitNum;
	}
	public int getBuildingNum()
	{
		return buildingNum;
	}
    public boolean getlog()
    {
        return loged;
    }
    public void setlog(boolean is)
    {
        loged = is;
    }
    public void setResource(Resource x)
    {
    	playerR = new Resource(x);
    }
}
