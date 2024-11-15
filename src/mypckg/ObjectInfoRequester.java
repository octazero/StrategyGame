package mypckg;

import java.awt.image.BufferedImage;

public class ObjectInfoRequester {
	public ObjectInfoRequester(){}
	//Makes a quick object of any building or unit to get any info out of it such a cost, buildTime etc ... 
	public Resource requestCost(String name)
	{
		try {
			String cl = new String("mypckg."+name);
			return ((baseObject)(Class.forName(cl).newInstance())).getCost();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public int requestBuildTime(String name)
	{
		try {
			String cl = new String("mypckg."+name);
			return ((baseObject)(Class.forName(cl).newInstance())).getBuildTime();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return -1;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	public int requestObjectType(String name)
	{
		try {
			String cl = new String("mypckg."+name);
			return ((baseObject)(Class.forName(cl).newInstance())).getObjectType();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return -1;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
        public BufferedImage requestImage(String name)
        {
            try {
			String cl = new String("mypckg."+name);
			return ((baseObject)(Class.forName(cl).newInstance())).getImage();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        }
}

