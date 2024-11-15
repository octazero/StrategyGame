package interface_GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class VillagerGUI extends JFrame{
	private JLabel Barracks  = new JLabel();
	private JLabel Farm  = new JLabel();
	private JLabel LumberJack  = new JLabel();
	private JLabel MinigCamp  = new JLabel();
	private JLabel SeigeWorkShop  = new JLabel();
	private JLabel Stables  = new JLabel();
	private JLabel TownCenter  = new JLabel();
	
	private JLabel lbBarracks  = new JLabel("Barracks");
	private JLabel lbFarm  = new JLabel("Farm");
	private JLabel lbLumberJack  = new JLabel("Lumber Jack");
	private JLabel lbMinigCamp  = new JLabel("Minig Camp");
	private JLabel lbSeigeWorkShop  = new JLabel("Seige Work Shop");
	private JLabel lbStables  = new JLabel("Stables");
	private JLabel lbTownCenter  = new JLabel("Town Center");
	private JLabel previousLabel;
        private String buildingName;
	private Border yellowLine;
        
	ImageIcon IIBarracks;
	ImageIcon IIFarm;
	ImageIcon IILumberJack;
	ImageIcon IIMinigCamp;
	ImageIcon IISeigeWorkShop;
	ImageIcon IIStables;
	ImageIcon IITownCenter;
	
	public VillagerGUI() throws IOException
	{
		Container cp = getContentPane();
                previousLabel = null;
                buildingName = null;
		cp.setLayout(null);
		Handler object = new Handler();
		yellowLine = BorderFactory.createLineBorder(Color.yellow);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0,(int)(screenSize.getHeight()*0.77),(int)(screenSize.getWidth()),(int)(screenSize.getHeight()*0.2));
		IIBarracks = new ImageIcon(ImageIO.read(new File("Age of Empires\\Barrakcs.jpg")).getScaledInstance(150, 120, 0));
		IIFarm = new ImageIcon(ImageIO.read(new File("Age of Empires\\farm1.jpg")).getScaledInstance(150, 120, 0));
		IILumberJack = new ImageIcon(ImageIO.read(new File("Age of Empires\\LumberJack.png")).getScaledInstance(150, 120, 0));
		IIMinigCamp = new ImageIcon(ImageIO.read(new File("Age of Empires\\MiningCampAoEII.png")).getScaledInstance(150, 120, 0));
		IISeigeWorkShop = new ImageIcon(ImageIO.read(new File("Age of Empires\\seigeworkshop2.png")).getScaledInstance(150, 120, 0));
		IIStables = new ImageIcon(ImageIO.read(new File("Age of Empires\\Stables.jpg")).getScaledInstance(150, 120, 0));
		IITownCenter = new ImageIcon(ImageIO.read(new File("Age of Empires\\TownCenter.gif")).getScaledInstance(150, 120, 0));
		
		Barracks.setIcon(IIBarracks);
		Farm.setIcon(IIFarm);
		LumberJack.setIcon(IILumberJack);
		MinigCamp.setIcon(IIMinigCamp);
		SeigeWorkShop.setIcon(IISeigeWorkShop);
		Stables.setIcon(IIStables);
		TownCenter.setIcon(IITownCenter);
		
		Barracks.setBounds((int)(screenSize.getWidth()*0.00), (int)(screenSize.getHeight()*0.01), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
		lbBarracks.setBounds((int)(screenSize.getWidth()*0.00), (int)(screenSize.getHeight()*0.07), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
		
		Farm.setBounds((int)(screenSize.getWidth()*0.15), (int)(screenSize.getHeight()*0.01), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
		lbFarm.setBounds((int)(screenSize.getWidth()*0.15), (int)(screenSize.getHeight()*0.07), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
	
		LumberJack.setBounds((int)(screenSize.getWidth()*0.30), (int)(screenSize.getHeight()*0.01), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
		lbLumberJack.setBounds((int)(screenSize.getWidth()*0.30), (int)(screenSize.getHeight()*0.07), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
		
		MinigCamp.setBounds((int)(screenSize.getWidth()*0.45), (int)(screenSize.getHeight()*0.01), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
		lbMinigCamp.setBounds((int)(screenSize.getWidth()*0.45), (int)(screenSize.getHeight()*0.07), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
	
		SeigeWorkShop.setBounds((int)(screenSize.getWidth()*0.60), (int)(screenSize.getHeight()*0.01), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
		lbSeigeWorkShop.setBounds((int)(screenSize.getWidth()*0.60), (int)(screenSize.getHeight()*0.07), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
		
		Stables.setBounds((int)(screenSize.getWidth()*0.75), (int)(screenSize.getHeight()*0.01), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
		lbStables.setBounds((int)(screenSize.getWidth()*0.75), (int)(screenSize.getHeight()*0.07), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
		
		TownCenter.setBounds((int)(screenSize.getWidth()*0.90), (int)(screenSize.getHeight()*0.01), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
		lbTownCenter.setBounds((int)(screenSize.getWidth()*0.90), (int)(screenSize.getHeight()*0.07), (int)(screenSize.getWidth()*0.08), (int)(screenSize.getHeight()*0.1));
		cp.add(TownCenter);
		cp.add(lbTownCenter);
		cp.add(Stables);
		cp.add(lbStables);
		cp.add(SeigeWorkShop);
		cp.add(lbSeigeWorkShop);
		cp.add(MinigCamp);
		cp.add(lbMinigCamp);
		cp.add(LumberJack);
		cp.add(lbLumberJack);
		cp.add(Farm);
		cp.add(lbFarm);
		cp.add(Barracks);
		cp.add(lbBarracks);
                Barracks.addMouseListener(object);
                TownCenter.addMouseListener(object);
                Stables.addMouseListener(object);
                SeigeWorkShop.addMouseListener(object);
                MinigCamp.addMouseListener(object);
                LumberJack.addMouseListener(object);
                Farm.addMouseListener(object);
	}
        private class Handler implements MouseListener
        {

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource().equals(Barracks))
            {
                if(previousLabel != null)
                {
                    previousLabel.setBorder(null);
                    previousLabel = Barracks;
                    Barracks.setBorder(yellowLine);
                    buildingName = "Barracks";
                }
                else
                {
                    previousLabel = Barracks;
                    Barracks.setBorder(yellowLine);
                    buildingName = "Barracks";
                }
                setVisible(false);
            }
            else if(e.getSource().equals(TownCenter))
            {
                if(previousLabel != null)
                {
                    previousLabel.setBorder(null);
                    previousLabel = TownCenter;
                    TownCenter.setBorder(yellowLine);
                    buildingName = "TownCenter";
                }
                else
                {
                    previousLabel = TownCenter;
                    TownCenter.setBorder(yellowLine);
                    buildingName = "TownCenter";
                }
                setVisible(false);
            }
            else if(e.getSource().equals(Stables))
            {
                if(previousLabel != null)
                {
                    previousLabel.setBorder(null);
                    previousLabel = Stables;
                    Stables.setBorder(yellowLine);
                    buildingName = "Stables";
                }
                else
                {
                    previousLabel = Stables;
                    Stables.setBorder(yellowLine);
                    buildingName = "Stables";
                }
                setVisible(false);
            }
            else if(e.getSource().equals(SeigeWorkShop))
            {
                if(previousLabel != null)
                {
                    previousLabel.setBorder(null);
                    previousLabel = SeigeWorkShop;
                    SeigeWorkShop.setBorder(yellowLine);
                    buildingName = "WorkShop";
                }
                else
                {
                    previousLabel = SeigeWorkShop;
                    Barracks.setBorder(yellowLine);
                    buildingName = "WorkShop";
                }
                setVisible(false);
            }
            else if(e.getSource().equals(MinigCamp))
            {
                if(previousLabel != null)
                {
                    previousLabel.setBorder(null);
                    previousLabel = MinigCamp;
                    MinigCamp.setBorder(yellowLine);
                    int choice = JOptionPane.showConfirmDialog(null, "Ok for Gold Mine and No for Stone Mine?");
                    if(choice == JOptionPane.YES_OPTION)
                    {
                        buildingName = "GoldMine";
                    }
                    else
                    {
                        buildingName = "StoneMine";
                    }
                    setVisible(false);
                }
                else
                {
                    previousLabel = MinigCamp;
                    MinigCamp.setBorder(yellowLine);
                    int choice = JOptionPane.showConfirmDialog(null, "Ok for Gold Mine and No for Stone Mine?");
                    if(choice == JOptionPane.YES_OPTION)
                    {
                        buildingName = "GoldMine";
                    }
                    else
                    {
                        buildingName = "StoneMine";
                    }
                    setVisible(false);
                }
            }
            else if(e.getSource().equals(LumberJack))
            {
                if(previousLabel != null)
                {
                    previousLabel.setBorder(null);
                    previousLabel = LumberJack;
                    LumberJack.setBorder(yellowLine);
                    buildingName = "LumberJack";
                }
                else
                {
                    previousLabel = LumberJack;
                    LumberJack.setBorder(yellowLine);
                    buildingName = "LumberJack";
                }
                setVisible(false);
            }
            else if(e.getSource().equals(Farm))
            {
                if(previousLabel != null)
                {
                    previousLabel.setBorder(null);
                    previousLabel = Farm;
                    Farm.setBorder(yellowLine);
                    buildingName = "Farm";
                }
                else
                {
                    previousLabel = Farm;
                    Farm.setBorder(yellowLine);
                    buildingName = "Farm";
                }
                setVisible(false);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
           
        }

        
            
        }
        public String getBuildingName()
        {
            return buildingName;
        }
}
