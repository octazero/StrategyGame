package mypckg;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import javax.swing.ImageIcon;

public abstract class baseObject implements Serializable{
	protected int health;
	protected int objectType;
	protected int buildTime;
	protected int playerOwn;
	protected int maxHealth;
	protected Resource cost;
	protected String name;
	protected String civ;
	protected ImagenPerso unitImage;
	public baseObject()
	{
		//So child classes are not forced to call super
	}
	public void setHealth(int newVal)
	{
		health = newVal;
	}
	public int getHealth()
	{
		return health;
	}
	public Resource getCost()
	{
		return cost;
	}
	public int getObjectType()
	{
		return objectType;
	}
	public int getBuildTime()
	{
		return buildTime;
	}
	public String getName()
	{
		return name;
	}
	public int getPlayerOwn()
	{
		return playerOwn;
	}
	public void setPlayerOwn(int newVal)
	{
		playerOwn = newVal;
	}
    public BufferedImage getImage()
    {
        return unitImage.getImage();
    }
    public void setCiv(String x)
    {
        civ = x;
    }
    public String getCiv()
    {
        return civ;
    }
}
