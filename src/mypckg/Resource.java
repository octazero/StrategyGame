package mypckg;

import java.io.Serializable;

public class Resource implements Serializable{
	private int wood;
	private int food;
	private int stone;
	private int gold;
	public Resource()
	{
		wood = 0;
		food = 0;
		stone = 0;
		gold = 0;
	}
	public Resource(int w,int f,int s,int g)
	{
		wood = w;
		food = f;
		stone = s;
		gold = g;
	}
	public Resource(Resource x)
	{
		food =  x.food;
		wood = x.wood;
		stone = x.stone;
		gold = x.gold;
	}
	public int getWood()
	{
		return wood;
	}
	public int getFood()
	{
		return food;
	}
	public int getStone()
	{
		return stone;
	}
	public int getGold()
	{
		return gold;
	}
	public void setWood(int newVal)
	{
		wood = newVal;
	}
	public void setFood(int newVal)
	{
		food = newVal;
	}
	public void setStone(int newVal)
	{
		stone = newVal;
	}
	public void setGold(int newVal)
	{
		gold = newVal;
	}
	public void add(Resource toBeAdded)
	{
		wood+=toBeAdded.wood;
		food+=toBeAdded.food;
		stone+=toBeAdded.stone;
		gold+=toBeAdded.gold;
	}
	public void subtract(Resource toBeSubtracted)
	{
		wood-=toBeSubtracted.wood;
		food-=toBeSubtracted.food;
		stone-=toBeSubtracted.stone;
		gold-=toBeSubtracted.gold;
	}
}
