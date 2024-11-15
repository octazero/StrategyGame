package mypckg;

import java.io.Serializable;

public class Map implements Serializable{
	private baseObject[][] map;
	private Pos mapSize;
    Map(Map copyMap)
    {
      
    }
	Map(Pos size)
	{
		mapSize = new Pos(size);
		map = new baseObject[size.getX()][size.getY()];
	}
	public void removeTile(Pos position)
	{
		map[position.getX()][position.getY()] = null;
	}
	public baseObject getTile(Pos position)
	{
		return map[position.getX()][position.getY()];
	}
	public boolean isOccupied(Pos position)
	{
		if(map[position.getX()][position.getY()] != null)
			return true;
		return false;
	}
	public void updateTile(baseObject inputObject,Pos position)
	{
		map[position.getX()][position.getY()] = inputObject;
	}
	public void addTile(Pos newPosition)
	{
		map = new baseObject[newPosition.getX()][newPosition.getY()];
	}
	public boolean isOutOfBounds(Pos position)
	{
		if(position.getX() >= mapSize.getX() || position.getY() >= mapSize.getY() || position.getX() < 0 || position.getY() < 0)
			return true;
		return false;
	}
}
