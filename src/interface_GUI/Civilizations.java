package interface_GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import mypckg.Main;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Civilizations extends JFrame{
	JButton Egypt = new JButton();
	JButton Rome = new JButton();
	JButton England = new JButton();
	
	JLabel bg = new JLabel();
	JLabel choose = new JLabel("Choose Your Civilization");
	JLabel egyptl = new JLabel("Rome");
	JLabel romel = new JLabel("Egypt");
	JLabel englandl = new JLabel("England");
	
	ImageIcon egypt = new ImageIcon("pics\\Animated-Flag-Italy.gif");
	ImageIcon rome = new ImageIcon("pics\\Animated-Flag-Egypt.gif");
	ImageIcon england = new ImageIcon("pics\\Animated-Flag-United-Kingdom.gif");
	private MapGUI mp;
	private static ArrayList <ArrayList<String>> CivEngland = new ArrayList<ArrayList<String>>();
	private static ArrayList <ArrayList<String>> CivRome = new ArrayList<ArrayList<String>>();
	private static ArrayList <ArrayList<String>> CivEgypt = new ArrayList<ArrayList<String>>();
	private ArrayList <String> CivSE = new ArrayList<String>();
	private ArrayList <String> CivTE = new ArrayList<String>();
	private ArrayList <String> CivWE = new ArrayList<String>();
	private ArrayList <String> CivBE = new ArrayList<String>();
	private ArrayList <String> CivSR = new ArrayList<String>();
	private ArrayList <String> CivTR = new ArrayList<String>();
	private ArrayList <String> CivWR = new ArrayList<String>();
	private ArrayList <String> CivBR = new ArrayList<String>();
	private ArrayList <String> CivSEg = new ArrayList<String>();
	private ArrayList <String> CivTEg = new ArrayList<String>();
	private ArrayList <String> CivWEg = new ArrayList<String>();
	private ArrayList <String> CivBEg = new ArrayList<String>();
	private boolean isSelected;
	
	public Civilizations()
	{
		isSelected = false;
		CivSEg.add("Knight");
		CivSEg.add("WarElephant");
		CivSEg.add("ElephantArcher");
		CivSEg.add("ArcherChariot");
		
		CivTEg.add("Villager");
		
		CivWEg.add("Ballista");
		CivWEg.add("Catapult");
		
		CivBEg.add("Soldier");
		CivBEg.add("Archer");
		CivBEg.add("AxeMan");
		
		CivEgypt.add(CivSEg);
		CivEgypt.add(CivTEg);
		CivEgypt.add(CivWEg);
		CivEgypt.add(CivBEg);
		
		CivSR.add("Stables");
		CivSR.add("WarElephant");
		CivSR.add("ElephantArcher");
		
		CivTR.add("Villager");
		
		CivWR.add("Catapult");
		
		CivBR.add("Soldier");
		CivBR.add("Archer");
		CivBR.add("Hoplites");
		CivBR.add("AxeMan");
		CivBR.add("ClubMan");
		
		CivRome.add(CivSR);
		CivRome.add(CivTR);
		CivRome.add(CivWR);
		CivRome.add(CivBR);
		
		CivSE.add("Knight");
		CivSE.add("ArcherChariot");
		
		CivTE.add("Villager");
		
		CivWE.add("Ballista");
		
		CivBE.add("Soldier");
		CivBE.add("Archer");
		CivBE.add("Priest");
		CivBE.add("ClubMan");
		
		CivEngland.add(CivSE);
		CivEngland.add(CivTE);
		CivEngland.add(CivWE);
		CivEngland.add(CivBE);
		
		this.setExtendedState(this.MAXIMIZED_BOTH);
	      
		setTitle("Civilizations");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try
		{
		ImageIcon background = new ImageIcon(ImageIO.read(new File("pics\\8279355445_df81d4a2d2_h.jpg")).getScaledInstance(2000, 1000, 0));
		bg.setIcon(background);
		setContentPane(bg);
		}catch(IOException e)
		{}
		
		Container cp = getContentPane();
		
		cp.setLayout(null);
		
		Egypt.setBounds(200, 300, 278, 183);
		Rome.setBounds(800, 300, 278, 183);
		England.setBounds(1400, 300, 278, 183);
		
		choose.setBounds(600, 50, 900, 200);
		
		egyptl.setBounds(850, 600, 500, 100);
		romel.setBounds(850, 600, 500, 100);
		englandl.setBounds(850, 600, 500, 100);
		
		egyptl.setFont(new Font("Imprint MT Shadow", Font.BOLD, 45));
		romel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 45));
		englandl.setFont(new Font("Imprint MT Shadow", Font.BOLD, 45));
		choose.setFont(new Font("Imprint MT Shadow", Font.BOLD, 65));
		
		egyptl.setForeground(Color.red);
		romel.setForeground(Color.red);
		englandl.setForeground(Color.red);
		choose.setForeground(Color.red);
		
		Egypt.setIcon(egypt);
		Rome.setIcon(rome);
		England.setIcon(england);
		
		cp.add(Egypt);
		cp.add(Rome);
		cp.add(England);
		
		cp.add(egyptl);
		cp.add(englandl);
		cp.add(romel);
		cp.add(choose);
		
		egyptl.setVisible(false);
		romel.setVisible(false);
		englandl.setVisible(false);
		
		myHandler2 handler2 = new myHandler2();
		myHandler handler = new myHandler();
		
		Egypt.addMouseListener(handler2);
		Rome.addMouseListener(handler2);
		England.addMouseListener(handler2);
		
		Egypt.addActionListener(handler);
		Rome.addActionListener(handler);
		England.addActionListener(handler);
		
	}
	
	private class myHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object x = e.getSource();
			if(x.equals(Egypt))
			{
				if(!isSelected)
				{
					Main.objectz.setCurrentPlayer(0);
					GUIManager.PL[0].setCivName("CivEgypt");
					isSelected = true;
				}
				else
				{
					Main.objectz.setCurrentPlayer(1);
					GUIManager.PL[1].setCivName("CivEgypt");
                                        Main.objectz.setCurrentPlayer(0);
                                    /*try {
                                        mp=new MapGUI();
                                    } catch (IOException ex) {
                                        Logger.getLogger(Civilizations.class.getName()).log(Level.SEVERE, null, ex);
                                    }*/
					mp.drawMap();
					mp.setVisible(true);
					setVisible(false);
					
				}
						
			}
			if(x.equals(Rome))
			{
				if(!isSelected)
				{
					Main.objectz.setCurrentPlayer(0);
					GUIManager.PL[0].setCivName("CivRome");
					isSelected = true;
				}
				else
				{
					Main.objectz.setCurrentPlayer(1);
					GUIManager.PL[1].setCivName("CivRome");
					mp.drawMap();
					mp.setVisible(true);
                                        Main.objectz.setCurrentPlayer(0);
					setVisible(false);
				}
						
			}
			if(x.equals(England))
			{
				if(!isSelected)
				{
					Main.objectz.setCurrentPlayer(0);
					GUIManager.PL[0].setCivName("CivEngland");
					isSelected = true;
				}
				else
				{
					Main.objectz.setCurrentPlayer(1);
					GUIManager.PL[1].setCivName("CivEngland");
					mp.drawMap();
					mp.setVisible(true);
					setVisible(false);
                                        Main.objectz.setCurrentPlayer(0);
				}		
			}
		}
	}	
	public static ArrayList<ArrayList<String>> get(String st)
	{
		if(st=="CivEgypt")
			return CivEgypt;
		else if(st=="CivRome")
			return CivRome;
		else 
			return CivEngland;	
	}
	
	private class myHandler2 extends MouseAdapter{

		@Override
		public void mouseEntered(MouseEvent e) {
			if(e.getSource().equals(Egypt))
			{
				egyptl.setVisible(true);
			}
			
			if(e.getSource().equals(Rome)){
				romel.setVisible(true);
			}
			
			if(e.getSource().equals(England)){
				englandl.setVisible(true);
			}
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource().equals(Egypt)){
				egyptl.setVisible(false);
			}
			
			if(e.getSource().equals(Rome)){
				romel.setVisible(false);
			}
			
			if(e.getSource().equals(England)){
				englandl.setVisible(false);
			}
			
		}
		}
        public void setMapGUI(MapGUI x)
	{
		mp = x;
	}

}
