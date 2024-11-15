package interface_GUI;

import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mypckg.Main;

public class MainMenu extends JFrame{
    private JButton StartNewGame = new JButton("Start New Game");
    private JButton LoadGame = new JButton("Load Game");
    private JButton Options = new JButton("Options");
    private JButton SignOut = new JButton("Sign Out");
    private JButton ExitToWindows = new JButton("Exit To Windows");
    private JButton player1 = new JButton("Player 1");
    private JButton player2 = new JButton("Player 2");
    private JCheckBox P1 = new JCheckBox("Player 1");
    private JCheckBox P2 = new JCheckBox("Player 2");
    private FirstScreen fs;
    private options op;
    private MapGUI mp;
    private Civilizations civil;
     JLabel point = new JLabel();
     JLabel sparta = new JLabel();
     JLabel option = new JLabel();
     JLabel loading = new JLabel();
     JLabel out = new JLabel();
     JLabel exit = new JLabel();
     
    
    ImageIcon img = new ImageIcon("pics\\MainMenu.jpg");
    ImageIcon spartaimg = new ImageIcon("pics\\Startnew.jpg");
    ImageIcon optionimg = new ImageIcon("pics\\Optionsbutton.jpg");
    ImageIcon loadingimg = new ImageIcon("pics\\A_018_Kneeling.jpg");
    ImageIcon outimg = new ImageIcon("pics\\signout.jpg");
    ImageIcon exitimg = new ImageIcon("pics\\exit.jpg");
    //"D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\pics\\loading.png"
    
    public MainMenu()
    {
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setTitle("Main Menu");
        op = new options();
        civil = new Civilizations();
        op.setFirstScreen(this);
        try {
			mp = new MapGUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        point.setIcon(img);
        setContentPane(point);
        
        Container cp = getContentPane();
        myHandler handler = new myHandler();
        
        StartNewGame.setBounds(800, 250, 300, 50);
        LoadGame.setBounds(800, 350, 300, 50);
        Options.setBounds(800, 450, 300, 50);
        SignOut.setBounds(800, 550, 300, 50);
        ExitToWindows.setBounds(800, 650, 300, 50);
        player1.setBounds(1150, 550, 150, 50);
        player2.setBounds(1350, 550, 150, 50);
        cp.setLayout(null);
        
        sparta.setBounds(200, 300, 400, 300);
        sparta.setIcon(spartaimg);
        cp.add(sparta);
        sparta.setVisible(false);
        
        option.setBounds(200, 300, 400, 300);
        option.setIcon(optionimg);
        cp.add(option);
        option.setVisible(false);
        
        loading.setBounds(300, 300, 400, 300);
        loading.setIcon(loadingimg);
        cp.add(loading);
        loading.setVisible(false);
        
        out.setBounds(200, 300, 400, 300);
        out.setIcon(outimg);
        cp.add(out);
        out.setVisible(false);
        
        exit.setBounds(200, 300, 500, 315);
        exit.setIcon(exitimg);
        cp.add(exit);
        exit.setVisible(false);
        
        cp.add(StartNewGame);
        cp.add(LoadGame);
        cp.add(Options);
        cp.add(SignOut);
        cp.add(ExitToWindows);
        cp.add(P1);
        cp.add(P2);
        cp.add(player1);
        cp.add(player2);
        
        player1.setVisible(false);
        player2.setVisible(false);
        
        myHandler2 handler2 = new myHandler2();
        
        SignOut.addMouseListener(handler2);
        ExitToWindows.addMouseListener(handler2);
        StartNewGame.addMouseListener(handler2);
        Options.addMouseListener(handler2);
        LoadGame.addActionListener(handler);
        SignOut.addActionListener(handler);
        ExitToWindows.addActionListener(handler);
        Options.addActionListener(handler);
        player1.addActionListener(handler);
        player2.addActionListener(handler);
        StartNewGame.addActionListener(handler);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public class myHandler implements ActionListener{
        public void actionPerformed (ActionEvent e){
            
            Object x = e.getSource();
            if(x.equals(LoadGame))
            {
                try {
                                        mypckg.FileManger.load();
					mp = new MapGUI();
					mp.setVisible(true);
					setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            if ( x.equals(ExitToWindows))
            { 
                int choice = JOptionPane.showConfirmDialog(ExitToWindows, "Are you sure you want to exit ?");
                if ( choice == JOptionPane.YES_OPTION)
                {
                    setVisible(false);
                    System.exit(1);
                }
                
                
            }
            if (x.equals(Options))
            {
                op.setVisible(true);
                setVisible(false);
                       
            }
            if ( x.equals(SignOut))
            {
                 
                player1.setVisible(true);
                player2.setVisible(true);
            }
            if ( x.equals(player1))
                {
                   int choice =  JOptionPane.showConfirmDialog(SignOut, "Are You sure you want Player 1 to Sign out ??"); 
                    if(choice == JOptionPane.YES_OPTION)
                    {
                        fs.setLogged(0);
                        fs.setVisible(true);
                        setVisible(false);
                    }
                }
            if(x.equals(player2))
                {
                  int choice =  JOptionPane.showConfirmDialog(SignOut, "Are You sure you want Player 2 to Sign out ??"); 
                   if(choice == JOptionPane.YES_OPTION)
                    {
                	   fs.setLogged(1);
                	   fs.setVisible(true);
                	   setVisible(false);
                    } 
                }
            if(x.equals(StartNewGame))
            {
                civil.setMapGUI(mp);
            	civil.setVisible(true);
                Main.objectz.setCurrentPlayer(0);
            	setVisible(false);
            }
                
                }
            }
    
    private class myHandler2 implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
			if(e.getSource().equals(StartNewGame)){
					sparta.setVisible(true);
				}	
			if(e.getSource().equals(Options)){
				option.setVisible(true);
			}
			
			if(e.getSource().equals(SignOut)){
				out.setVisible(true);
			}
			if(e.getSource().equals(ExitToWindows)){
				exit.setVisible(true);
			}
			if(e.getSource().equals(LoadGame)){
				loading.setVisible(true);
			}
			
			}

		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource().equals(StartNewGame)){
				sparta.setVisible(false);
				}
			if(e.getSource().equals(Options)){
				option.setVisible(false);
			}
			
			if(e.getSource().equals(SignOut)){
				out.setVisible(false);
			}
			if(e.getSource().equals(ExitToWindows)){
				exit.setVisible(false);
			}
			if(e.getSource().equals(LoadGame)){
				loading.setVisible(false);
			}
			
		}
		}
public void setFirstScreen(FirstScreen fx)
    	{
    		fs = fx;
    	}
		

        }
    
    
