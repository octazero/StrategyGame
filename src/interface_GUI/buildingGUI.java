package interface_GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import mypckg.Main;
import mypckg.ObjectInfoRequester;
import mypckg.Pos;

public class buildingGUI extends JFrame{
    private JLabel iLabels[];
    private Pos buildingPos;
    
	public buildingGUI(ArrayList<String> avUnits) throws IOException
	{
                myListener listen = new myListener();
                ObjectInfoRequester req = new ObjectInfoRequester();
		Container cp = getContentPane();
		cp.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0,(int)(screenSize.getHeight()*0.77),(int)(screenSize.getWidth()),(int)(screenSize.getHeight()*0.2));
		iLabels = new JLabel[12];
                for(int i=0;i<12;i++)
                    iLabels[i] = new JLabel();
                for(int i=0;i<avUnits.size();i++)
                {
                    iLabels[i].setBounds(i*200, 0, 200, 200);
                    iLabels[i].setIcon(new ImageIcon(req.requestImage(avUnits.get(i)).getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
                 
                }
                for(int i=0;i<avUnits.size();i++)
                {
                    iLabels[i].addMouseListener(listen);
                }
                for(int i=6;i<avUnits.size()+6;i++)
                {
                    iLabels[i].setBounds(i%6*200, 210, 200, 30);
                    iLabels[i].setText(avUnits.get(i-6));
                }
                    
                for(int i=0;i<12;i++)
                    cp.add(iLabels[i]);
                
	}
        private class myListener implements MouseListener
        {

        @Override
        public void mouseClicked(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           for(int i=0;i<6;i++)
           {
               if(e.getSource().equals(iLabels[i]))
               {
                   
                   Main.objectz.eventBuildUnit(buildingPos, iLabels[i+6].getText());
                   dispose();
                   setVisible(false);
               }
           } 
        }

        @Override
        public void mousePressed(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        }
        public void setBuildingPos(Pos x)
        {
            buildingPos = x;
        }
        
}
