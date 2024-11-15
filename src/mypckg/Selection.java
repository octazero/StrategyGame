package mypckg;

import java.util.ArrayList;

public class Selection {
	private ArrayList<Pos> sel;
	private int size;
	
	public Selection()
	{
            try
            {
                size = 0;
                sel = new ArrayList<Pos>();
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
	}
	public void RemoveFromSelection(Pos p)
	{
		for(int i=0;i<sel.size();i++)
		{
			if(sel.get(i).compare(p))
			{
				sel.remove(i);
				--size;
				return;
			}
				
		}
	
	}
	public void resetSelection()
	{
        size = 0;
		sel.clear();
	}
	public void addSelection(int x,int y)
	{
		sel.add(new Pos(x,y));
		++size;
	}
	public void addSelection(Pos p)
	{
		for(int i=0;i<sel.size();i++)
			if(sel.get(i).compare(p))
				return;
		sel.add(p);
		++size;
	}
	public int getSize()
	{
		return size;
	}
	public Pos getPos(int i)
	{
		return sel.get(i);
	}
	public Pos findClosest(Pos y)
	{
		Pos temp = sel.get(0);
		int min = temp.getDistance(y);
		for(int i=1;i<size;i++)
		{
			if(sel.get(i).getDistance(y) < min)
			{
				min = sel.get(i).getDistance(y);
				temp = sel.get(i);
			}	
		}
		return temp;
	}
	public void getVertices(Pos topLeft,Pos bottomRight)
	{
		int minY = sel.get(0).getY() , minX = sel.get(0).getX(), maxX = sel.get(0).getX() , maxY = sel.get(0).getY();
		topLeft.setPoint(sel.get(0));
		bottomRight.setPoint(sel.get(0));
		for(int i=1;i<sel.size();i++)
		{
			if(sel.get(i).getX() <= minX  && sel.get(i).getY() <= minY)
			{
				minX = sel.get(i).getX();
				minY = sel.get(i).getY();
				topLeft.setPoint(minX, minY);
			}
			else if(sel.get(i).getX() >= maxX  && sel.get(i).getY() >= maxY)
			{
				maxX = sel.get(i).getX();
				maxY = sel.get(i).getY();
				bottomRight.setPoint(maxX, maxY);
			}
		}
	}
}
