package mypckg;

import java.util.ArrayList;

public class turnHandler {
	private int turn;
	private ArrayList<baseUnit> turnEndUnits;
	private ArrayList<baseBuilding> resourceBuildings;
	private ArrayList<buildingQueue> bQ;
	public turnHandler()
	{
		turn = 0;
		turnEndUnits = new ArrayList<baseUnit>();
		resourceBuildings = new ArrayList<baseBuilding>();
		bQ = new ArrayList<buildingQueue>();
	}
	public void newTurn()
	{
		++turn;
		resetTurns();
		resolveBQ();
	}
	public void resetTurns()
	{
		//Reset each unit turn
		for(int i=0;i<turnEndUnits.size();i++)
		{
			turnEndUnits.get(0).setTurnEnd(false);
			turnEndUnits.remove(turnEndUnits.get(0));
		}
		turnEndUnits.trimToSize();
	}
	public void addToTurnEndUnit(baseUnit newUnit)
	{
		turnEndUnits.add(newUnit);
	}
	public void addToBuildingQueue(buildingQueue newVal)
	{
		bQ.add(newVal);
	}
	public ArrayList<buildingQueue> getBQ()
	{
		return bQ;
	}
	public void removeFromTurnEndUnit(baseUnit Unit)
	{
		turnEndUnits.remove(Unit);
	}
	public void removeFrombQ(Pos buildingPos)
	{
		for(int i=0;i<bQ.size();i++)
		{
			if(buildingPos.compare(bQ.get(i).getPos()))
			{
				bQ.remove(bQ.get(i));
				break;
			}
		}
	}
	public void addresourceBuilding(baseBuilding newBuilding)
	{
		resourceBuildings.add(newBuilding);
	}
	public void removeResourceBuilding(baseBuilding Building)
	{
		resourceBuildings.remove(Building);
	}
	public Resource addResourcesToPlayer(int currentPlayer)
	{
		//Return an object of resource to be added to the player according to the buildings in resourceBuildings
		Resource rt = new Resource();
		for(int i=0;i<resourceBuildings.size();i++)
		{
			if(resourceBuildings.get(i).getPlayerOwn() == currentPlayer)
			{
				switch(resourceBuildings.get(i).getName())
				{
				case "LumberJack":
					rt.add(new Resource(100,0,0,0));
					break;
				case "Farm":
					rt.add(new Resource(0,100,0,0));
					break;
				case "StoneMine":
					rt.add(new Resource(0,0,100,0));
					break;
				case "GoldMine":
					rt.add(new Resource(0,0,0,100));
					break;
				}
			}
		}
		return rt;
 	}
	public void resolveBQ()
	{
		for(int i=0;i<bQ.size();i++)
		{
			bQ.get(i).setTurnsLeft(bQ.get(i).getTurnsLeft()-1);
		}
	}
}
