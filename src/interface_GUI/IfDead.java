package interface_GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IfDead extends JFrame{
	
	private JLabel jl = new JLabel();
	public IfDead()
	{
		Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)sc.getWidth(),(int)sc.getHeight());
		this.setLayout(null);
		Container cp = getContentPane();
		cp.setBackground(Color.BLACK);
		ImageIcon backimg = new ImageIcon("C:\\Users\\aliessam\\Desktop\\Animations\\End.gif");
		int lw = 500;
		int lh = 500;
		jl.setBounds((int)(sc.getWidth()-lw)/2,(int)(sc.getHeight()-lh)/2,lw,lh);
		jl.setIcon(backimg);
		cp.add(jl);	
	}
	public static void main(String[]args)
	{
		IfDead id = new IfDead();
		id.setVisible(true);
	}
}
