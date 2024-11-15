package mypckg;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import customExceptions.*;
import interface_GUI.Civilizations;

import java.util.logging.Level;
import java.util.logging.Logger;
public class gameHandler{
	public static Map map;
	private int currentPlayer;
	private String errorString;
	private playerHandler playerH;
	private turnHandler turnH;
	private Selection currentSelection;
	private Selection currentSelection2;
	public gameHandler(Pos size)
	{
		map = new Map(size) ;
		playerH = new playerHandler();
		turnH = new turnHandler();
		currentSelection = new Selection();
		currentSelection2 = new Selection();
        errorString = new String("");
	}
	public boolean eventMove(Pos originalPosition,Pos newPosition)
	{	
		try
		{
			
			baseUnit temp = (baseUnit) map.getTile(originalPosition);
			checkSelection(originalPosition);
			isOwnedByPlayer(originalPosition);
			checkMovement(originalPosition,newPosition);
			if(temp.Move())
			{
				CountActions.countNumofUnitMoves(currentPlayer);
				map.removeTile(originalPosition);
				map.updateTile(temp, newPosition);
				turnH.addToTurnEndUnit(temp);
				return true;
			}
		}
		catch(InvalidMoveLocationException e)
		{
			errorString = e.toString();
			return false;
		}
		catch(NoSelectionException e1)
		{
			errorString = e1.toString();
			return false;
		}
		catch(NotOwnedByPlayerException e2)
		{
			errorString = e2.toString();
			return false;
		}
		errorString = "Unit turn has already ended";
		return false;
	}
	public boolean eventAttack(Pos attackingUnitPos,Pos attackedUnitPos)
	{
		try
		{
			checkSelection(attackingUnitPos);
			isOwnedByPlayer(attackingUnitPos);
			baseUnit temp = (baseUnit) map.getTile(attackingUnitPos);
			checkAttack(attackingUnitPos,attackedUnitPos);
			//If attacked object is a unit
			if(map.getTile(attackedUnitPos).getObjectType() == 0)
			{
				baseUnit temp1 = (baseUnit) map.getTile(attackedUnitPos);
				//If attack is successful
				if(temp.Atk(temp1))
				{
					CountActions.countNumofUnitAttacks(currentPlayer);
					//Add attacking unit to turnEndUnit
					turnH.addToTurnEndUnit(temp);
					//If unit died
					if(temp1.getHealth() <= 0)
					{
						//If unit's turn has already ended this means that it's still stored in turnEndUnits
						if(temp1.getTurnEnd())
						{
							//Remove it
							CountActions.countNumofUnitsKilled(currentPlayer);
							turnH.removeFromTurnEndUnit(temp1);
							playerH.setCurrentPlayer(temp1.getPlayerOwn());
							playerH.decrementUnitNum();
							playerH.setCurrentPlayer(currentPlayer);
						}
						//Remove it from the map
						map.removeTile(attackedUnitPos);
					}
					return true;
				}
			}
			//If attacked Object is a building
			else if(map.getTile(attackedUnitPos).getObjectType() == 1)
			{
				baseBuilding temp1 = (baseBuilding) map.getTile(attackedUnitPos);
				//If Attack is successful
				if(temp.Atk(temp1))
				{
					CountActions.countNumofUnitAttacks(currentPlayer);
					//Add attacking unit to turnEndUnit
					turnH.addToTurnEndUnit(temp);
					//If building was destroyed
					if(temp1.getHealth() <= 0)
					{
						//if it was a resource building remove it from resourceBuildings in turnHandler
						CountActions.countNumofBuildingsDestroyed(currentPlayer);
						switch(temp.getName())
						{
						case "LumberJack":
						case "Farm":
						case "StoneMine":
						case "GoldMine":
							turnH.removeResourceBuilding(temp1);
						}
						playerH.setCurrentPlayer(temp1.getPlayerOwn());
						playerH.decrementBuildingNum();
						playerH.setCurrentPlayer(currentPlayer);
						//remove it from map
						map.removeTile(attackedUnitPos);
					}
					return true;
				}
			}
		}
		catch(NoSelectionException e)
		{
			errorString = e.toString();
			return false;
		}
		catch(InvalidAttackException e1)
		{
			errorString = e1.toString();
			return false;
		}
		catch(NotOwnedByPlayerException e2)
		{
			errorString = e2.toString();
			return false;
		}
		errorString = "Unit turn has already ended";
		return false;
	}
	public boolean eventBuildUnit(Pos buildingPos,String unitType)
	{
		baseBuilding temp ;		
		temp = (baseBuilding) map.getTile(buildingPos);
		//placing algorithm below
		baseBuilding buildy = (baseBuilding)map.getTile(buildingPos);
			//Loop on all positions around the building and try to build the new unit in them
			Pos temp3;
			for(int i=-1;i<2;i++)
			{
				for(int j=-1;j<2;j++)
				{
					temp3 = new Pos(buildy.getLocation().getX()+j,buildy.getLocation().getY()+i);
					if(!map.isOutOfBounds(temp3) && ! map.isOccupied(temp3))
					{
						CountActions.countNumofUnitsBuilt(playerH.getCurrentPlayerOwn());
						map.updateTile(buildy.buildUnit(unitType), temp3);
						playerH.incrementUnitNum();
						return true;
					}
				}
			}
			errorString = "No Place to build unit";
			return false;
	}
	public boolean eventBuildBuilding(Pos buildingPos,String buildingName)
	{
		try {
			int x = 5;
			if(buildingName == "Stables")
				x = 0;
			else if(buildingName == "TownCenter")
				x = 1;
			else if(buildingName == "WorkShop")
				x = 2;
			else if(buildingName == "Barracks")
				x = 3;
			String k = playerH.getPlayer().getCivName();
			CountActions.countNumofBuildingsBuilt(playerH.getCurrentPlayerOwn());
			baseBuilding temp = null;
			if(x >= 5)
			temp = (baseBuilding)Class.forName("mypckg."+buildingName).newInstance();
			else
			temp = (baseBuilding)Class.forName("mypckg."+buildingName).getConstructor(java.util.ArrayList.class).newInstance(Civilizations.get(k).get(x));
			playerH.incrementBuildingNum();
			//Check if temp is a resource building and add it to turnHandler if true
			if(temp.getName().equals("Farm") || temp.getName().equals("LumberJack") || temp.getName().equals("GoldMine") || temp.getName().equals("StoneMine"))
			{
				turnH.addresourceBuilding(temp);
			}
                        temp.setLocation(buildingPos);
                        temp.setCiv(playerH.getPlayer().getCivName());
                        temp.setPlayerOwn(map.getTile(buildingPos).getPlayerOwn());
			map.updateTile(temp, buildingPos);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
	}
	public String getErrorString()
	{
		return errorString;
	}
	public boolean parseCommand(String command)
	{
		Pos p = null ;
		Pos q = null ;
		if(command.indexOf("Attack") != -1)
		{
			String tokens[] = new String[4];
			int x = 0;
			for(int i = 0 ; i < 4 ; i++)
			tokens[i] = new String("");
			for(int i = 7 ; i < command.length() ; i++)
			{
				if(command.charAt(i) != ' ')
					tokens[x] += "" + command.charAt(i);
				else
					x++;
			}
			p.setPoint(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]));
			q.setPoint(Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]));
			eventAttack(p,q);			
		}
		if(command.indexOf("Move") != -1)
		{
			String tokens[] = new String[4];
			int x = 0;
			for(int i = 0 ; i < 4 ; i++)
			tokens[i] = new String("");
			for(int i = 5 ; i < command.length() ; i++)
			{
				if(command.charAt(i) != ' ')
					tokens[x] += "" + command.charAt(i);
				else
					x++;
			}
			p.setPoint(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]));
			q.setPoint(Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]));
			eventMove(p,q);			
		}
		if(command.indexOf("BuildUnit") != -1)
		{
			String tokens[] = new String[4];
			int x = 0;
			for(int i = 0 ; i < 4 ; i++)
			tokens[i] = new String("");
			for(int i = 10 ; i < command.length() ; i++)
			{
				if(command.charAt(i) != ' ')
					tokens[x] += "" + command.charAt(i);
				else
					x++;
			}
			p.setPoint(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]));		
			eventBuildUnit(p,command.substring(14, command.length()-1));
		}
		return true;
	}
	public void isOwnedByPlayer(Pos position) throws NotOwnedByPlayerException
	{
		if(!(map.getTile(position).getPlayerOwn() == currentPlayer))
			throw new NotOwnedByPlayerException("The unit being selected is not owned by you");
	}
	public void checkMovement(Pos originalPosition,Pos newPosition) throws InvalidMoveLocationException
	{
		if(map.getTile(originalPosition).getObjectType() != 0)
			throw new InvalidMoveLocationException("Object trying to move is not a unit");
		if(map.isOccupied(newPosition))
			throw new InvalidMoveLocationException("Position unit is trying to move to is already occupied");
		if(originalPosition.getDistance(newPosition) > ((baseUnit)map.getTile(originalPosition)).getMovement())
			throw new InvalidMoveLocationException("Unit is trying to move more tiles than its permitted movement speed");
		
	}
	public void checkSelection(Pos selecPos) throws NoSelectionException
	{
		if(!map.isOccupied(selecPos))
			throw new NoSelectionException("No Selected Unit/Building");
	}
	public void checkAttack(Pos attackingUnit,Pos attackedUnit) throws InvalidAttackException
	{
		if(map.getTile(attackingUnit).getObjectType() != 0)
			throw new InvalidAttackException("Selected object is not a unit, it cannot attack");
		if(attackingUnit.getDistance(attackedUnit) > ((baseUnit)map.getTile(attackingUnit)).getRange())
			throw new InvalidAttackException("Unit is trying to attack further than its permitted range");
		if(map.getTile(attackingUnit).getPlayerOwn() == map.getTile(attackedUnit).getPlayerOwn())
			throw new InvalidAttackException("Unit is trying to attack a friendly target");
	}
	public void setCurrentPlayer(int newValue)
	{
		currentPlayer = newValue;
		playerH.setCurrentPlayer(newValue);
	}
	
	public void newTurn()
	{
		ObjectInfoRequester req = new ObjectInfoRequester();
		turnH.newTurn();
		playerH.addToPlayer(turnH.addResourcesToPlayer(0), 0);
		playerH.addToPlayer(turnH.addResourcesToPlayer(1), 1);
		for(int i=0;i<turnH.getBQ().size();i++)
		{
			if(turnH.getBQ().get(0).getTurnsLeft() == 0)
			{
				if(req.requestObjectType(turnH.getBQ().get(0).getName()) == 0)
				{
					eventBuildUnit(turnH.getBQ().get(0).getPos(),turnH.getBQ().get(0).getName());
				}
                                else if(req.requestObjectType(turnH.getBQ().get(0).getName()) == 1)
                                {
                                        eventBuildBuilding(turnH.getBQ().get(0).getPos(),turnH.getBQ().get(0).getName());
                                }
				turnH.getBQ().remove(0);
			}
		}
	}
	public void simulateAttack()
	{
		//currentSelection are attacking units and currentSelection2 are attacked units
		//A general function that supports single and group unit attacks
		baseUnit attacker;
		for(int i=0;i<currentSelection2.getSize();i++)
		{
			if(!map.isOccupied(currentSelection2.getPos(i)))
				currentSelection2.RemoveFromSelection(currentSelection2.getPos(i));
		}
		//Loop on all selection
		for(int i=0;i<currentSelection.getSize() && currentSelection2.getSize() != 0;i++)
		{
			try
			{
				checkSelection(currentSelection.getPos(i)); //Check that selection isn't empty
				isOwnedByPlayer(currentSelection.getPos(i)); //Check that unit selection is owned by player
				checkAttack(currentSelection.getPos(i),currentSelection2.findClosest(currentSelection.getPos(i))); //Check that unit can attack
			}
			catch(NoSelectionException | NotOwnedByPlayerException | InvalidAttackException e)
			{
				//If an error was caught continue
				continue;
			}
			attacker = (baseUnit)map.getTile(currentSelection.getPos(i)); //Get Attacker
			//If attacked object is a unit
			Pos closest = currentSelection2.findClosest(currentSelection.getPos(i));
			if(map.getTile(closest).getObjectType() == 0)
			{
				//Get attacked unit using the findClosest function in selection
				baseUnit attacked = (baseUnit)map.getTile(closest);
				//if attack is successful
				if(attacker.Atk(attacked))
				{
					//Add attacking unit to turnEndUnit
					turnH.addToTurnEndUnit(attacker);
					//If attacked Unit died
					if(attacked.getHealth() <= 0)
					{
						//If attacked unit turn has already ended
						if(attacked.getTurnEnd())
						{
							//Remove it from turnEndUnit
							turnH.removeFromTurnEndUnit(attacked);
						}
						//Remove it from the map
						map.removeTile(closest);
						//Remove killed unit from currentSelection2
						currentSelection2.RemoveFromSelection(closest);
					}
				}
			}
			else if(map.getTile(closest).getObjectType() == 1)
			{
				baseBuilding attacked = (baseBuilding) map.getTile(closest);
				//If Attack is successful
				if(attacker.Atk(attacked))
				{
					//Add attacking unit to turnEndUnit
					turnH.addToTurnEndUnit(attacker);
					//If building was destroyed
					if(attacked.getHealth() <= 0)
					{
						//if it was a resource building remove it from resourceBuildings in turnHandler
						switch(attacked.getName())
						{
						case "LumberJack":
						case "Farm":
						case "StoneMine":
						case "GoldMine":
							turnH.removeResourceBuilding(attacked);
						}
						try {
							if(attacked.getName().getClass() == Class.forName("FakeBuilding"))
							{
								turnH.removeFrombQ(attacked.getLocation());
							}
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//remove it from map
						map.removeTile(closest);
						currentSelection2.RemoveFromSelection(closest);
					}
				}
			}
		}
	}
	public boolean simulateMovement(boolean formation)
	{
		//This function only supports main directions N S E W
		//This function keeps units in formation if they're not able to move in formation
		//The function will not move them at all
		//currentSelection will be the moving army and currentSelection2 the place to move to
		//currentSelection 2 can be multiple points or 1 point but it  will only serve to determien the direction
		Pos topLeft = new Pos(),bottomRight = new Pos();
		//Get topLeft and bottomRight vertices of selection
		currentSelection.getVertices(topLeft, bottomRight);
            try {
                checkSelection(currentSelection.getPos(0));
            } catch (NoSelectionException ex) {
                errorString = ex.toString();
		return false;
            }
		int minimumSpeed = ((baseUnit)map.getTile(currentSelection.getPos(0))).getMovement();
		//If direction is east
		if(currentSelection2.getPos(0).getX() > bottomRight.getX())
		{
                    int incrementLoc = currentSelection2.getPos(0).getX()-bottomRight.getX();
			try
			{
				//Loop on selection and find minimumSpeed of the whole army
				for(int i=1;i<currentSelection.getSize();i++)
				{
					checkSelection(currentSelection.getPos(i));
					//If a unit in the selection is not owned by the player
					isOwnedByPlayer(currentSelection.getPos(i));
					if(((baseUnit)map.getTile(currentSelection.getPos(i))).getMovement() < minimumSpeed)
					{
						minimumSpeed = ((baseUnit)map.getTile(currentSelection.getPos(i))).getMovement();
						if(minimumSpeed == 1)
							break;
					}
				}
				//Check that the place being moved to is empty
				for(int x = incrementLoc;x>0;x--)
				{
					for(int y = bottomRight.getY();y>=topLeft.getY();y--)
					{
						checkMovement(new Pos(bottomRight.getX(),y),new Pos(bottomRight.getX()+x,y));
					}
				}
				//Check that all units have not ended their turn
				for(int x = bottomRight.getX();x>=topLeft.getX();x--)
				{
					for(int y = bottomRight.getY();y>=topLeft.getY();y--)
					{
                        if(withinSelection(new Pos(x,y)))
                        	if(((baseUnit)map.getTile(new Pos(x,y))).getTurnEnd())
                        		return false;
					}
				}
				//Move units east equal to the minimumSpeed of whole army
				for(int x = bottomRight.getX();x>=topLeft.getX();x--)
				{
					for(int y = bottomRight.getY();y>=topLeft.getY();y--)
					{ 
                                                if(withinSelection(new Pos(x,y)))
                                                {
                                                    ((baseUnit)map.getTile(new Pos(x,y))).Move();
                                                    turnH.addToTurnEndUnit((baseUnit)map.getTile(new Pos(x,y)));
                                                    map.updateTile(map.getTile(new Pos(x,y)), new Pos(x+incrementLoc,y));
                                                    map.removeTile(new Pos(x,y));
                                                }
						
					}
				}
			}
			catch(InvalidMoveLocationException | NotOwnedByPlayerException  | NoSelectionException e)
			{
				//If errors were caught cease the move function
				errorString = e.toString();
				return false;
			}
		}
		//If south
		else if(currentSelection2.getPos(0).getY() > bottomRight.getY())
		{
                    int incrementLoc = currentSelection2.getPos(0).getY() - bottomRight.getY();
			try
			{
				for(int i=1;i<currentSelection.getSize();i++)
				{
					checkSelection(currentSelection.getPos(i));
					isOwnedByPlayer(currentSelection.getPos(i));
					if(((baseUnit)map.getTile(currentSelection.getPos(i))).getMovement() < minimumSpeed)
					{
						minimumSpeed = ((baseUnit)map.getTile(currentSelection.getPos(i))).getMovement();
						if(minimumSpeed == 1)
							break;
					}
				}
				for(int y = incrementLoc;y>0;y--)
				{
					for(int x = bottomRight.getX();x>=topLeft.getX();x--)
					{
						checkMovement(new Pos(x,bottomRight.getY()),new Pos(x,bottomRight.getY()+y));
					}
				}
				for(int x = bottomRight.getX();x>=topLeft.getX();x--)
				{
					for(int y = bottomRight.getY();y>=topLeft.getY();y--)
					{
                        if(withinSelection(new Pos(x,y)))
                        	if(((baseUnit)map.getTile(new Pos(x,y))).getTurnEnd())
                               return false;
					}
				}
				for(int y = bottomRight.getY();y>=topLeft.getY();y--)
				{
					for(int x = bottomRight.getX();x>=topLeft.getX();x--)
					{
						if(withinSelection(new Pos(x,y)))
                        	{
                            	((baseUnit)map.getTile(new Pos(x,y))).Move();
                                turnH.addToTurnEndUnit((baseUnit)map.getTile(new Pos(x,y)));
                                map.updateTile(map.getTile(new Pos(x,y)), new Pos(x,y+incrementLoc));
                                map.removeTile(new Pos(x,y));
                            }
						
					}
				}
			}
			catch(InvalidMoveLocationException | NotOwnedByPlayerException | NoSelectionException e)
			{
				errorString = e.toString();
				return false;
			}
		}
		//If west
		else if(currentSelection2.getPos(0).getX() < topLeft.getX())
		{
                    int incrementLoc = topLeft.getX() - currentSelection2.getPos(0).getX();
			try
			{
				for(int i=1;i<currentSelection.getSize();i++)
				{
					checkSelection(currentSelection.getPos(i));
					isOwnedByPlayer(currentSelection.getPos(i));
					if(((baseUnit)map.getTile(currentSelection.getPos(i))).getMovement() < minimumSpeed)
					{
						minimumSpeed = ((baseUnit)map.getTile(currentSelection.getPos(i))).getMovement();
						if(minimumSpeed == 1)
							break;
					}
				}
				for(int x = incrementLoc;x>0;x--)
				{
					for(int y = bottomRight.getY();y>=topLeft.getY();y--)
					{
						checkMovement(new Pos(bottomRight.getX(),y),new Pos(bottomRight.getX()+x,y));
					}
				}
				for(int x = bottomRight.getX();x>=topLeft.getX();x--)
				{
					for(int y = bottomRight.getY();y>=topLeft.getY();y--)
					{
                        if(withinSelection(new Pos(x,y)))
                        	if(((baseUnit)map.getTile(new Pos(x,y))).getTurnEnd())
                               return false;;
					}
				}
				for(int x = topLeft.getX();x<=bottomRight.getX();x++)
				{
					for(int y = topLeft.getY();y<=bottomRight.getY();y++)
					{
                                                if(withinSelection(new Pos(x,y)))
                                                {
                                                    ((baseUnit)map.getTile(new Pos(x,y))).Move();
                                                    turnH.addToTurnEndUnit((baseUnit)map.getTile(new Pos(x,y)));
                                                    map.updateTile(map.getTile(new Pos(x,y)), new Pos(x-incrementLoc,y));
                                                    map.removeTile(new Pos(x,y));
                                                }
						
					}
				}
			}
			catch(InvalidMoveLocationException | NotOwnedByPlayerException | NoSelectionException e)
			{
				errorString = e.toString();
				return false;
			}
		}
		//If north
		else if(currentSelection2.getPos(0).getY() < topLeft.getY())
		{
            int incrementLoc = topLeft.getY() - currentSelection2.getPos(0).getY();
			try
			{
				for(int i=1;i<currentSelection.getSize();i++)
				{
					checkSelection(currentSelection.getPos(i));
					isOwnedByPlayer(currentSelection.getPos(i));
					if(((baseUnit)map.getTile(currentSelection.getPos(i))).getMovement() < minimumSpeed)
					{
						minimumSpeed = ((baseUnit)map.getTile(currentSelection.getPos(i))).getMovement();
						if(minimumSpeed == 1)
							break;
					}
				}
				for(int y = incrementLoc;y>0;y--)
				{
					for(int x = bottomRight.getX();x>=topLeft.getX();x--)
					{
						checkMovement(new Pos(x,bottomRight.getY()),new Pos(x,bottomRight.getY()-y));
					}
				}
				for(int x = bottomRight.getX();x>=topLeft.getX();x--)
				{
					for(int y = bottomRight.getY();y>=topLeft.getY();y--)
					{
                        if(withinSelection(new Pos(x,y)))
                        	if(((baseUnit)map.getTile(new Pos(x,y))).getTurnEnd())
                               return false;
					}
				}
				for(int y = topLeft.getY();y<=bottomRight.getY();y++)
				{
					for(int x = topLeft.getX();x<=bottomRight.getX();x++)
					{
	                    if(withinSelection(new Pos(x,y)))
	                    {
	                        ((baseUnit)map.getTile(new Pos(x,y))).Move();
	                        turnH.addToTurnEndUnit((baseUnit)map.getTile(new Pos(x,y)));
	                        map.updateTile(map.getTile(new Pos(x,y)), new Pos(x,y-incrementLoc));
	                        map.removeTile(new Pos(x,y));
	                    }
						
					}
				}
			}
			catch(InvalidMoveLocationException | NotOwnedByPlayerException | NoSelectionException e)
			{
				errorString = e.toString();
				return false;
			}
		}
	return true;
	}
	public void simulateDefense()
	{
		//Sets all unit to defending mode
		//Loop on all selection
		for(int i=0;i<currentSelection.getSize();i++)
		{
			try {
			checkSelection(currentSelection.getPos(i));
			isOwnedByPlayer(currentSelection.getPos(i));
			if(((baseUnit)map.getTile(currentSelection.getPos(i))).Defend())
				turnH.addToTurnEndUnit((baseUnit)map.getTile(currentSelection.getPos(i)));
			} catch (NotOwnedByPlayerException | NoSelectionException e) {
				//If error was caught continue
				continue;
			}
		}
	}
	public void reqBuildUnit(Pos buildingPos,String unitType)
	{
		//check if the player selected anything ... Function throws exception if no unit is selected
		try {
			checkSelection(buildingPos);
			if(!((baseBuilding)map.getTile(buildingPos)).isBuildable(unitType))
			{
				errorString = "Building does not build this type of unit";
				return;
			}
			ObjectInfoRequester temp = new ObjectInfoRequester();
			//Request unit cost and subtract it from player
			if(temp.requestCost(unitType) != null)
			playerH.subtractFromPlayer(temp.requestCost(unitType));
			turnH.addToBuildingQueue(new buildingQueue(unitType,temp.requestBuildTime(unitType),buildingPos));
		} catch (NoSelectionException e) {
			errorString  = e.toString();
			return;
		}
	}
	public boolean reqBuildBuilding(Pos buildingPos,String buildingName)
	{
		if(map.isOccupied(buildingPos))
                {
                    errorString = "BuildingPos already occupied";
                    return false;
                }
			
		ObjectInfoRequester info = new ObjectInfoRequester();
                
		//Request Building Cost and Increment building num
		if(info.requestCost(buildingName) != null)
		{
                    
                        baseObject temp = new FakeBuilding(buildingName);
                        temp.setPlayerOwn(currentPlayer);
			playerH.subtractFromPlayer(info.requestCost(buildingName));
			map.updateTile(temp, buildingPos);
			turnH.addToBuildingQueue(new buildingQueue(buildingName,info.requestBuildTime(buildingName),buildingPos));
		}
                return true;
	}
        public Selection getSelection()
        {
            return currentSelection;
        }
        public Selection getSelection2()
        {
            return currentSelection2;
        }
        public boolean withinSelection(Pos p)
        {
            for(int i=0;i<currentSelection.getSize();i++)
            {
                if(currentSelection.getPos(i).compare(p))
                    return true;
            }
            return false;
        }
        public boolean selection2HasEnemy()
        {
        	for(int i=0;i<currentSelection2.getSize();i++)
        	{
        		if(map.isOccupied(currentSelection2.getPos(i)))
        			if(map.getTile(currentSelection2.getPos(i)).getPlayerOwn() != currentPlayer)
        				return true;
        	}
        	return false;
        }
        public void setPlayer(Player x,int num)
    	{
    		playerH.setPlayer(x, num);
    	}
        public boolean compareSelection()
        {
        	if(currentSelection.getSize() == currentSelection2.getSize())
        	{
        		for(int i=0;i<currentSelection.getSize();i++)
        			if(!currentSelection.getPos(i).compare(currentSelection2.getPos(i)))
        				return false;
        	}
        	else
        		return false;
        	return true;
        }
        public int getCurrentPlayer()
        {
            return currentPlayer;
        }
        public void sendToTurnEndUnit(baseUnit x)
        {
            turnH.addToTurnEndUnit(x);
        }
        public String getCurrnetPlayerCiv()
        {
            return playerH.getPlayer().getCivName();
        }
        public Resource requestResource()
        {
           return playerH.getPlayer().getPlayerR();
        }
}
