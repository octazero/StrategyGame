package mypckg;

import java.util.ArrayList;

public abstract class baseBuilding extends baseObject {
	protected Resource resource ;
	protected ArrayList<String> canBuild ;
	protected Pos location;
	public baseBuilding()
	{
	}
	public ArrayList<String> getCanBuild()
	{
		return canBuild;
	}
	public boolean isBuildable(String input)
	{
		boolean found = false;
		for(int i = 0 ; i < canBuild.size() ; i++)
		{
			if(canBuild.get(i).equals(input))
			{
				found = true;
				break;
			}
				
		}
		if(found)
			return true;
		
			return false;
	}
	public void setLocation(Pos newLocation)
	{
		location = newLocation;
	}
	public Pos getLocation()
	{
		return location;
	}
	public baseUnit buildUnit(String name) 
	{
		try
		{
			if(isBuildable(name))
			{
				String cl = new String("mypckg.");
				cl+=(name);
				baseUnit temp = (baseUnit)(Class.forName(cl).newInstance());
				//set new Unit playerOwnership like the building it's trained from
				temp.setPlayerOwn(playerOwn);
				return temp;
			}
		}
		catch(ClassNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}