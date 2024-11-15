package mypckg;


public class buildingQueue {
	private String name;
	private int turnsLeft;
	private Pos buildingPos;
	public buildingQueue(String name,int turnsLeft,Pos buildingPos)
	{
		this.name = name;
		this.turnsLeft = turnsLeft;
		this.buildingPos = buildingPos;
	}
	public int getTurnsLeft()
	{
		return turnsLeft;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String newVal)
	{
		name = newVal;
	}
	public void setTurnsLeft(int newVal)
	{
		turnsLeft = newVal;
	}
	public void setPos(Pos newVal)
	{
		buildingPos = new Pos(newVal);
	}
	public Pos getPos()
	{
		return buildingPos;
	}
}
