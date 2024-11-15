package interface_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mypckg.Resource;

public class options extends JFrame{
	JLabel gold = new JLabel("Set Initial Gold");
	JLabel food = new JLabel("Set Initial Food");
	JLabel stone = new JLabel("Set Initial Stone");
	JLabel wood = new JLabel("Set Initial Wood");
	JLabel back = new JLabel();
        JLabel guide = new JLabel("KeyBoard Guide:");
        JLabel z = new JLabel("Z = End Turn");
        JLabel x = new JLabel("X = Save Game");
        JLabel c = new JLabel("C = Load Game");
        
	
	JTextField setgold = new JTextField();
	JTextField setfood = new JTextField();
	JTextField setstone = new JTextField();
	JTextField setwood = new JTextField();
	
	
	
	JButton goldb = new JButton("Set Gold");
	JButton foodb = new JButton("Set Food");
	JButton stonesb = new JButton("Set Stones");
	JButton woodb = new JButton("Set Wood");
	
    JButton Ok = new JButton("OK");
    private MainMenu mm;
    ImageIcon backimg = new ImageIcon("pics\\Options.jpg");
	
	public options(){
            
        myHandler handler = new myHandler();
		this.setExtendedState(this.MAXIMIZED_BOTH);
		setTitle("Options");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		back.setIcon(backimg);
        setContentPane(back);
		
		Container cp = getContentPane();
		
		cp.setLayout(null);
                
		
		gold.setBounds(600, 300, 250, 50);
		food.setBounds(600, 350, 250, 50);
		stone.setBounds(600, 400, 250, 50);
		wood.setBounds(600, 450, 250, 50);
                guide.setBounds(300, 550, 300, 50);	
                z.setBounds(700, 550, 300, 50);
                x.setBounds(1000, 550, 300, 50);
                c.setBounds(1250, 550, 300, 50);
		
		
		food.setForeground(Color.red);
		gold.setForeground(Color.red);
		stone.setForeground(Color.red);
		wood.setForeground(Color.red);
		guide.setForeground(Color.red);
                z.setForeground(Color.red);
                x.setForeground(Color.red);
                c.setForeground(Color.red);
                
         
         gold.setFont(new Font("Broadway", Font.BOLD, 24));
         food.setFont(new Font("Broadway", Font.BOLD, 24));
         stone.setFont(new Font("Broadway", Font.BOLD, 24));
         wood.setFont(new Font("Broadway", Font.BOLD, 24));
         guide.setFont(new Font("Broadway", Font.BOLD, 24));
	 z.setFont(new Font("Broadway", Font.BOLD, 24));
         x.setFont(new Font("Broadway", Font.BOLD, 24));
         c.setFont(new Font("Broadway", Font.BOLD, 24));
         
		
		cp.add(gold);
		cp.add(food);
		cp.add(stone);
		cp.add(wood);
		cp.add(guide);
                cp.add(z);
                cp.add(x);
                cp.add(c);
		
		
		setgold.setBounds(900, 300, 50, 50);
		setfood.setBounds(900, 350, 50, 50);
		setstone.setBounds(900, 400, 50, 50);
		setwood.setBounds(900, 450, 50, 50);
		
		
		
		goldb.setBounds(1100, 300, 150, 50);
		foodb.setBounds(1100, 350, 150, 50);
		stonesb.setBounds(1100, 400, 150, 50);
		woodb.setBounds(1100, 450, 150, 50);
                Ok.setBounds(800, 650, 300, 50);
                Ok.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
		
		cp.add(setgold);
		cp.add(setfood);
		cp.add(setstone);
		cp.add(setwood);
		cp.add(foodb);
		cp.add(goldb);
		cp.add(stonesb);
		cp.add(woodb);
                cp.add(Ok);
		
                Ok.addActionListener(handler);
		
		
	}
        public class myHandler implements ActionListener{
            public void actionPerformed (ActionEvent e){
                
                Object x = e.getSource();
                if ( x.equals(Ok))
                {
                    if(!setwood.getText().equals("") && !setgold.getText().equals("") && !setstone.equals("") && !setfood.getText().equals(""))
                	{
                		if(numOnly(setwood.getText()) && numOnly(setgold.getText()) && numOnly(setstone.getText()) && numOnly(setfood.getText()))
                		{
                			GUIManager.PL[0].setResource(new Resource(Integer.valueOf(setwood.getText()),Integer.valueOf(setfood.getText()),Integer.valueOf(setstone.getText()),Integer.valueOf(setgold.getText())));
                        	GUIManager.PL[1].setResource(new Resource(Integer.valueOf(setwood.getText()),Integer.valueOf(setfood.getText()),Integer.valueOf(setstone.getText()),Integer.valueOf(setgold.getText())));
                		}
                		else
                			JOptionPane.showMessageDialog(null, "Failed");
                	}	
                    mm.setVisible(true);
                    setVisible(false);
                }
                }
                
            }
        public void setFirstScreen(MainMenu fx)
        {
        	mm = fx;
        }
        private boolean numOnly(String x)
        {
        	for(int i=0;i<x.length();i++)
        		if(x.charAt(i) < 48 || x.charAt(i) > 57)
        			return false;
        	return true;
        }
        }
        
