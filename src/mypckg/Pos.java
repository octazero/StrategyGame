package mypckg;

import java.io.Serializable;

public class Pos implements Serializable{
	private int x,y;
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setPoint(int newValX,int newValY)
	{
		x = newValX;
		y = newValY;
	}
        public void setPoint(Pos p)
        {
            this.x = p.x;
            this.y = p.y;
        }
	public Pos(Pos p)
	{
		x = p.getX();
		y = p.getY();
	}
	public Pos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public Pos()
	{
		x = 0;
		y = 0;
	}
	public boolean compare(Pos p)
	{
		if(this.x == p.x && this.y == p.y)
			return true;
		return false;
	}
	public int getDistance(Pos p)
	{
		return (int)Math.sqrt(Math.pow(p.x-x, 2)+Math.pow(p.y-y, 2));
	}
	public String toString()
	{
		String rt = new String("");
		rt+="X: ";
		rt+=x;
		rt+=" Y: ";
		rt+=y;
		return rt;
	}
}
