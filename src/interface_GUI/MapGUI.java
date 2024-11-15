/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.*;
import mypckg.*;
/**
 *
 * @author user
 */
public class MapGUI extends JFrame{
    /*int x;
    int y;
    int posx;
    int posy;
    int clx;
    int cly;
    int ctr;*/
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
  
    private JLabel  [] lb = new JLabel[2];
    private JLabel lb2 = new JLabel();
    private JLabel t = new JLabel("HIIIII");
    private JLabel bbg = new JLabel();
    private JPanel bg = new JPanel();
    private JLabel[][] blocks;
    private JButton btnMenu[];
    private boolean selection;
    private int currentPlayer;
    private UnitsDetail ud;
    private BuldingDetails bd;
    private buildingGUI BG;
    JButton l = new JButton();
    private myHandler h;
    ImageIcon img;
    ImageIcon img2;
    ImageIcon b;
    boolean p = false;
    private boolean buildMode;
    MouseEvent aq;
    Container c;
    Border blackline;
    private Border blueLine;
    private Border redLine;
    private Border yellowLine;
    private VillagerGUI buildingOptions;
    private boolean isSaved;
    private JLabel v;
    private JLabel GoldCount;
    private TimeDate timeThread;
    private Statistics statWindow;
    private MapGUI mp;
    public MapGUI () throws IOException
    {
        mp=this;
        statWindow = new Statistics();
        v = new JLabel();
        GoldCount = new JLabel();
        v.setFont(new Font("Imprint MT Shadow",Font.BOLD,20));
        v.setForeground(Color.red);
        v.setBounds(0, 0, 100, 30);
        GoldCount.setForeground(Color.yellow);
        GoldCount.setBounds(120, 0, 100, 30);
        timeThread = new TimeDate(v);
        timeThread.start();
        currentPlayer = 0;
        selection = false;
        buildMode = false;
        isSaved = false;
        blocks = new JLabel[20][10];
        ud = new UnitsDetail();
        bd = new BuldingDetails();
        yellowLine = BorderFactory.createLineBorder(Color.yellow);
        buildingOptions = new VillagerGUI();
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<20;j++)
            {
                blocks[j][i] = new JLabel();
            }
        }
        for(int i=0;i<1000;i+=100)
        {
            for(int j=0;j<2000;j+=100)
            {
                blocks[j/100][i/100].setBounds(j,i,100,100);
            }
        }
        btnMenu = new JButton[6];
        for(int i=0;i<6;i++)
            btnMenu[i] = new JButton();
        btnMenu[0].setText("Unit Details");
        btnMenu[1].setText("Building Details");
        btnMenu[2].setText("Statistics");
        btnMenu[3].setText("Save");
        btnMenu[4].setText("Load");
        btnMenu[5].setText("Exit");
        for(int i=0;i<6;i++)
        btnMenu[i].setBounds(1800, i*50, 100, 50);
        for(int i=0;i<6;i++)
            btnMenu[i].setVisible(false);
        blocks[0][0].getInputMap(IFW).put(KeyStroke.getKeyStroke("Z"), "END_TURN");//Key
    	blocks[0][0].getActionMap().put("END_TURN", new endTurn());//Function
    	blocks[0][0].getInputMap(IFW).put(KeyStroke.getKeyStroke("X"), "SAVE_MAP");
    	blocks[0][0].getActionMap().put("SAVE_MAP",new save());
    	blocks[0][0].getInputMap(IFW).put(KeyStroke.getKeyStroke("C"), "LOAD_MAP");
    	blocks[0][0].getActionMap().put("LOAD_MAP", new load());
        blocks[0][0].getInputMap(IFW).put(KeyStroke.getKeyStroke("ESCAPE"),"SHOW_MENU");
        blocks[0][0].getActionMap().put("SHOW_MENU",new showMenu());
        blocks[0][0].getInputMap(IFW).put(KeyStroke.getKeyStroke("B"), "BUILD_MODE");
        blocks[0][0].getActionMap().put("BUILD_MODE", new bm());
        lb[0] = new JLabel();
        lb[1] = new JLabel();
        h = new myHandler();
        
       this.setExtendedState(this.MAXIMIZED_BOTH);
         
        b = new ImageIcon(ImageIO.read(new File("map.jpg")));
        bbg.setIcon(b);
        setContentPane(bbg);
        c = getContentPane();
        c.setLayout(null);
        blackline = BorderFactory.createLineBorder(Color.green);
        redLine = BorderFactory.createLineBorder(Color.red);
        blueLine = BorderFactory.createLineBorder(Color.blue);
        lb[0].setIcon(img);
        lb[1].setIcon(img2);
        lb[0].setBounds(20,70 , 200 , 500);
        lb[1].setBounds(50,250,200,500);
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<20;j++)
            {
                c.add(blocks[j][i]);
            }
        }
        c.add(lb[0]);
        c.add(lb[1]);
         c.add(v);
        for(int i=0;i<6;i++)
            c.add(btnMenu[i]);
        c.addMouseListener(h);
        lb[0].addMouseListener(h);
        lb[1].addMouseListener(h);
        for(int i=0;i<10;i++)
                  {
                      for(int j=0;j<20;j++)
                      {
                          blocks[j][i].addMouseListener(h);
                      }
                  }
        for(int i=0;i<6;i++)
            btnMenu[i].addActionListener(h);
        Main.objectz.setCurrentPlayer(0);
        TownCenter tc = new TownCenter(Civilizations.get(GUIManager.PL[0].getCivName()).get(1));
        tc.setCiv(GUIManager.PL[0].getCivName());
        tc.setPlayerOwn(0);
        tc.setLocation(new Pos(1,1));
        Main.objectz.map.updateTile(tc,new Pos(1,1));
        c.add(GoldCount);
        tc = new TownCenter(Civilizations.get(GUIManager.PL[1].getCivName()).get(1));
        tc.setCiv(GUIManager.PL[1].getCivName());
        tc.setPlayerOwn(1);
        tc.setLocation(new Pos(19,9));
        Main.objectz.map.updateTile(tc,new Pos(18,9));
        
        drawMap();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void move()
    {
        
    }
    public class myHandler extends MouseAdapter implements ActionListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            updateGoldCount();
             if(SwingUtilities.isLeftMouseButton(e))
                  {
                      for(int i=0;i<10;i++)
                  {
                      for(int j=0;j<20;j++)
                      {
                          if(e.getSource().equals(blocks[j][i]) != false)
                          {  
                             try    
                             {
                                   if(!selection)
                                   {
                                       Main.objectz.getSelection().addSelection(j, i);
                                       blocks[j][i].setBorder(blackline);
                                       if(Main.objectz.map.getTile(new Pos(j,i)).getObjectType() == 1 && Main.objectz.map.getTile(new Pos(j,i)).getPlayerOwn() == Main.objectz.getCurrentPlayer())
                                       {
                                           String buildingName = Main.objectz.map.getTile(new Pos(j,i)).getName();
                                           if(buildingName.equals("TownCenter") || buildingName.equals("Barracks") || buildingName.equals("WorkShop") || buildingName.equals("Stables"))
                                             {
                                               switch(buildingName)
                                               {
                                                   case "Stables":
                                                       BG = new buildingGUI(Civilizations.get(Main.objectz.getCurrnetPlayerCiv()).get(0));
                                                       BG.setBuildingPos(new Pos(j,i));
                                                       BG.setVisible(true);
                                                       break;
                                                   case "TownCenter":
                                                       BG = new buildingGUI(Civilizations.get(Main.objectz.getCurrnetPlayerCiv()).get(1));
                                                       BG.setBuildingPos(new Pos(j,i));
                                                       BG.setVisible(true);
                                                       break;
                                                   case "WorkShop":
                                                       BG = new buildingGUI(Civilizations.get(Main.objectz.getCurrnetPlayerCiv()).get(2));
                                                       BG.setBuildingPos(new Pos(j,i));
                                                       BG.setVisible(true);
                                                       break;
                                                   case "Barracks":
                                                       BG = new buildingGUI(Civilizations.get(Main.objectz.getCurrnetPlayerCiv()).get(3));
                                                       BG.setBuildingPos(new Pos(j,i));
                                                       BG.setVisible(true);
                                                       break;
                                               }
                                               
                                               resetSelection();
                                           }
                                           else
                                           {
                                               resetSelection();
                                           }
                                           return;
                                       }
                                       
                                           
                                   }
                                   else
                                   {
                                       Main.objectz.getSelection2().addSelection(j, i);
                                       blocks[j][i].setBorder(yellowLine);
                                   }
                                       
                                   
                             }
                             catch(Exception ez)
                             {
                                 System.out.println(ez.toString());
                             }
                          }
                      }
                  }
                  
                      
                  }
             if(SwingUtilities.isRightMouseButton(e))
                  {
                      if(!buildMode)
                      {
                          if(!selection)
                      	{
                      		selection = true;
                                return;
                                
                      	}             
                      	else if(selection)
                      	{
                            if(Main.objectz.getSelection().getSize() == 0)
                            {
                                resetSelection();
                                JOptionPane.showMessageDialog(null,"Primary Selection Empty");
                                return;
                            }
                            else if(Main.objectz.getSelection2().getSize() == 0)
                            {
                                resetSelection();
                                JOptionPane.showMessageDialog(null,"Secondary Selection Empty");
                                return;
                            }
                            	   if(Main.objectz.compareSelection())
                            	   {
                                       isSaved = false;
                            		   Main.objectz.simulateDefense();
                                       resetSelection();
                            		   return;
                            	   }
                                   if(Main.objectz.selection2HasEnemy() && Main.objectz.getSelection2().getSize() != 0)
                                   {
                                           isSaved = false;
                                	   Main.objectz.simulateAttack();
                                	   System.out.println(Main.objectz.getErrorString());
                                           resetSelection();
                                   }
                                   else
                                   {
                                	   if(!Main.objectz.simulateMovement(true))
                                	   {
                                		   resetSelection();
                                		   return;
                                	   }
                                       isSaved = false;    
                                       System.out.println(Main.objectz.getErrorString());
                                       resetSelection();
                                   }
                      	}
                      }
                      else
                      {
                          if(buildingOptions.getBuildingName() != null)
                          {
                              for(int i=0;i<10;i++)
                                  for(int j=0;j<20;j++)
                                      if(e.getSource().equals(blocks[j][i]))
                                      {
                                          if(Main.objectz.reqBuildBuilding(new Pos(j,i), buildingOptions.getBuildingName()))
                              {
                                  isSaved = false;
                                  Main.objectz.sendToTurnEndUnit(((baseUnit)Main.objectz.map.getTile(Main.objectz.getSelection().getPos(0))));
                                  ((baseUnit)Main.objectz.map.getTile(Main.objectz.getSelection().getPos(0))).setTurnEnd(true);
                                  resetSelection();
                                  drawMap();
                                  buildMode = false;
                                  updateGoldCount();
                              }
                              else
                              {
                                  resetSelection();
                                  JOptionPane.showMessageDialog(null, Main.objectz.getErrorString());
                                  
                              }
                                      }                              
                          }
                          else
                          {
                              JOptionPane.showMessageDialog(null, "Invalid Selection");
                              resetSelection();
                              
                          }
                      }	
                        
                      
                  }
                 /*
                 if(ctr > 4){
                     lb[posx].setBounds(clx,cly,120,120);
                     lb[posy].setBounds(clx, cly, 120, 120);
                     break;
                 }
                 */
                /* boolean x=false;
            if ( Group.isSelected() == true )
            {
               x=true;
            }
             if(x==true)
             {
                for(int m=0;i<2;i++)
                {
                    if(aq.getSource().equals(lb[m]))
                        jls.add(m);
                }
             }*/
                 
                /* if(Group.isSelected() == true )
                 {System.out.println("hello");
                     for(int m=0;m<2;m++)
                     {
//                         if(e.getSource().equals(lb[m]))
////                             jls.add(m);
                     }
                     System.out.println("hello");
                     return;
                 }
                 if (e.getSource().equals(lb[1]))
                 {
                    p = true;
                    posx = 1;
                    posy = 1;
                 }
                 */
                /* if ( !jls.isEmpty() )
                  {
                  clx = e.getX();
                  cly = e.getY();
                  }
                  for ( int i =0; i<2; i++)
                  {
                  lb[jls.get(i)].setBounds(clx, cly, 120, 120);
                  lb[jls.get(i)].setBounds(clx , cly , 120, 120);
                  
                  ctr++;
                  
                     
                  }*/
             }
        
        public void actionPerformed (ActionEvent ae)
        {
            if(ae.getSource().equals(btnMenu[0]))
            {
                ud.setVisible(true);
            }
            else if(ae.getSource().equals(btnMenu[1]))
            {
                bd.setVisible(true);
            }
            else if(ae.getSource().equals(btnMenu[2]))
            {
                statWindow.setVisible(true);
            }
            else if(ae.getSource().equals(btnMenu[3]))
            {
                if(!isSaved)
                {
                    JOptionPane.showMessageDialog(null, "Saving...");
                    save();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Game Already Saved");
                }
            }
            else if(ae.getSource().equals(btnMenu[4]))
            {
                if(!isSaved)
                {
                    int choice = JOptionPane.showConfirmDialog(null, "Save First ?");
                    if(choice == JOptionPane.YES_OPTION)
                    {
                        save();
                        mypckg.FileManger.load();
                        drawMap();
                        resetSelection();
                    }
                    else
                    {
                        mypckg.FileManger.load();
                        drawMap();
                        resetSelection();
                    }
                }
                else
                {
                     mypckg.FileManger.load();
                     drawMap();
                     resetSelection();
                }
            }
            else if(ae.getSource().equals(btnMenu[5]))
            {
                if(!isSaved)
                {
                    int choice = JOptionPane.showConfirmDialog(null, "Save First ?");
                    if(choice == JOptionPane.YES_OPTION)
                    {
                        save();
                        System.exit(1);
                    }
                    else
                    {
                        System.exit(1);
                    }
                }
                else
                {
                     System.exit(1);
                }
            }
        }
       
        
    }
    public void drawMap()
        {
            for(int i=0;i<10;i++)
            {
                for(int j=0;j<20;j++)
                {      
                    if(Main.objectz.map.getTile(new Pos(j,i)) != null)
                    {
                    	blocks[j][i].setIcon(new ImageIcon((Main.objectz.map.getTile(new Pos(j,i)).getImage()).getScaledInstance(blocks[j][i].getWidth(), blocks[j][i].getHeight(), Image.SCALE_SMOOTH)));
                    	if(Main.objectz.map.getTile(new Pos(j,i)).getPlayerOwn() == 0)
                    		blocks[j][i].setBorder(redLine);
                    	else
                    		blocks[j][i].setBorder(blueLine);
                    }
                    else
                    {
                    	blocks[j][i].setIcon(null);
                    	blocks[j][i].setBorder(null);
                    }
                        
                }
            }
        }
    public void resetSelection()
    {
        drawMap();
        Main.objectz.getSelection().resetSelection();
        Main.objectz.getSelection2().resetSelection();
        selection = false;
    }
    private class endTurn extends AbstractAction
    {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(currentPlayer == 0)
			{
				currentPlayer = 1;
				Main.objectz.setCurrentPlayer(currentPlayer);
				Main.objectz.newTurn();
                                drawMap();
				JOptionPane.showMessageDialog(null, "Player's " + (currentPlayer+1) + " turn");
                                updateGoldCount();
			}
			else
			{
				currentPlayer = 0;
				Main.objectz.setCurrentPlayer(currentPlayer);
				Main.objectz.newTurn();
                                drawMap();
				JOptionPane.showMessageDialog(null, "Player's " + (currentPlayer+1) + " turn");
                                updateGoldCount();
			}
		}
    }
    private class save extends AbstractAction
    {

		@Override
		public void actionPerformed(ActionEvent e) {
			mypckg.FileManger.save();
		}
    }
    private class load extends AbstractAction
    {

		@Override
		public void actionPerformed(ActionEvent e) {
			mypckg.FileManger.load();
			drawMap();
			resetSelection();
		}
    }
    private class showMenu extends AbstractAction
    {
        private boolean menuShown;
        public showMenu()
        {
            menuShown = false;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!menuShown)
            {
                for(int i=0;i<3;i++)
                    blocks[18][i].removeMouseListener(h);
                for(int i=0;i<6;i++)
                    btnMenu[i].setVisible(true);
                for(int i=0;i<6;i++)
                    btnMenu[i].requestFocusInWindow();
                menuShown = true;
                //mp.setVisible(false);
            }
            else
            {
                for(int i=0;i<3;i++)
                    blocks[18][i].addMouseListener(h);
                for(int i=0;i<6;i++)
                    btnMenu[i].setVisible(false);
                    menuShown = false;
            }
                
                     
        }
        
    }
    public void save()
    {
        isSaved = true;
        mypckg.FileManger.save();
    }
    private class bm extends AbstractAction
    {
        
        @Override
        public void actionPerformed(ActionEvent e) {
           if(Main.objectz.getSelection().getSize() == 1 && Main.objectz.map.getTile(Main.objectz.getSelection().getPos(0)).getName().equals("Villager") && !((baseUnit)Main.objectz.map.getTile(Main.objectz.getSelection().getPos(0))).getTurnEnd())
           {
               buildingOptions.setVisible(true);
               buildMode = true;
           }
           else
           {
               resetSelection();
               buildMode = false;
           }
        }
    }
    public void updateGoldCount()
    {
        GoldCount.setText(""+
                Main.objectz.requestResource().getGold());
    }
}               
                  
                  
                          
                  
                  
               
               
               
           
               
               
               
               
           
       
              
//                clx = e.getX();
//                cly = e.getY();
//                t.setBounds(clx,cly,150,100);
//                l.setBounds(100,400,150,150);
//                l.setText("LLLLLLLLLL");
//                  try {
//                      MapGUI();
//                  } catch (InterruptedException ex) {
//                      Logger.getLogger(MapGUI.class.getName()).log(Level.SEVERE, null, ex);
//                  }
              
                
            
              
       

       
    
    
//    public void MapGUI() throws InterruptedException
//   {
//            
//      Thread gameThread;
//        gameThread = new Thread() {
//            public void run() {
//                
//                    x=clx;
//                    y=cly;
//                    
//                    repaint();
//                    try
//                    {
//                        Thread.sleep(0);
//                    }
//                    catch (InterruptedException z){}
//                }
//            };
//         
//            
//        gameThread.start();
//   }
//    /**
//     *
//     * @param g
//     */
//    public void paint(Graphics g)
//    {
//        
//        
//        
//         lb.setBounds(clx, cly, 150, 150);
//            
//        
//        
//    }
//    

