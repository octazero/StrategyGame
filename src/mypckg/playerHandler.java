package mypckg;

public class playerHandler {
	private Player[] player;
	private int currentPlayer;
	public playerHandler()
	{
		player = new Player[2];
		for(int i=0;i<2;i++)
			player[i] = new Player();
	}
	public int getCurrentPlayerOwn()
	{
		return player[currentPlayer].getPlayerOwn();
	}
	public void subtractFromPlayer(Resource cost)
	{
		player[currentPlayer].subtractResource(cost);
	}
	public void addToPlayer(Resource extra,int playerNum)
	{
		player[playerNum].addResource(extra);
	}
	public void setPlayerName(int playerNum,String name)
	{
		player[playerNum].setName(name);
	}
	public void setCurrentPlayer(int newValue)
	{
		currentPlayer = newValue;
	}
	public void incrementUnitNum()
	{
		player[currentPlayer].setUnitNum(player[currentPlayer].getUnitNum()+1);
	}
	public void incrementBuildingNum()
	{
		player[currentPlayer].setBuildingNum(player[currentPlayer].getBuildingNum()+1);
	}
	public void decrementUnitNum()
	{
		player[currentPlayer].setUnitNum(player[currentPlayer].getUnitNum()-1);
	}
	public void decrementBuildingNum()
	{
		player[currentPlayer].setBuildingNum(player[currentPlayer].getBuildingNum()-1);
	}
	public Player getPlayer()
	{
		return player[currentPlayer];
	}
	public void setPlayer(Player x,int num)
	{
		player[num] = x;
	}
}
