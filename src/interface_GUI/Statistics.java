package interface_GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Statistics extends JFrame {
	JButton back = new JButton("Back To Map");
	int constcontx, constconty;
	public Statistics(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 pack();
	      setBounds(0,0,screenSize.width, screenSize.height);
	      
		setTitle("Statistics");
		
	
		Container cp = getContentPane();
		cp.setLayout(null);
		
		back.setBounds(800, 1000, 100, 50);
		cp.add(back);
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		constcontx = 50;
		g.drawString("Units Killed", constcontx, 100);
		
		g.setColor(Color.red);
		
		
		
		g.drawLine(constcontx, constconty, constcontx, 100); 
		g.setColor(Color.black);
		
		constcontx += 300;
		g.drawString("Units Gained", constcontx, 300);
		g.setColor(Color.red);
		constconty = 900;
		
		g.drawLine(constcontx, constconty, constcontx, 300); 
		
		
	}
	
	

}
