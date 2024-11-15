package interface_GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class NowLoading extends JFrame{
	
	private JLabel jl = new JLabel();
	public NowLoading()
	{
		Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)sc.getWidth(),(int)sc.getHeight());
		this.setLayout(null);
		
		Container cp = getContentPane();
		cp.setBackground(Color.BLACK);
		ImageIcon backimg = new ImageIcon("Age of Empires\\3061oeX.gif");
		int lw = 500;
		int lh = 500;
		jl.setBounds((int)(sc.getWidth()-lw)/2,(int)(sc.getHeight()-lh)/2,lw,lh);
		jl.setIcon(backimg);
		cp.add(jl);
		
	}
    }

