package mypckg;

import interface_GUI.GUIManager;

public interface CountActions {

	public static void countNumofUnitAttacks(int playerOwn)
	{
		GUIManager.PL[playerOwn].setcountUnitAttacks();
	}
	public static void countNumofUnitsKilled(int playerOwn)
	{
		GUIManager.PL[playerOwn].setcountUnitsKilled();
	}
	public static void countNumofUnitsBuilt(int playerOwn)
	{
		GUIManager.PL[playerOwn].setcountUnitsBuilt();
	}
	public static void countNumofBuildingsDestroyed(int playerOwn)
	{
		GUIManager.PL[playerOwn].setcountBuildingsDestroyed();
	}
	public static void countNumofBuildingsBuilt(int playerOwn)
	{
		GUIManager.PL[playerOwn].setcountBuildingsBuilt();
	}
	public static void countNumofUnitMoves(int playerOwn)
	{
		GUIManager.PL[playerOwn].setcountMoves();
	}	
	
}
