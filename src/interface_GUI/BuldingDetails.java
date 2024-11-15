package interface_GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class BuldingDetails extends JFrame{
    
        private JLabel[] Lbuilding = new JLabel[12];
        private JPanel[] Pbuilding = new JPanel[5];
        
        private JLabel[] egyb = new JLabel[5];
        private JLabel egyt = new JLabel();
        private JLabel[] egyw = new JLabel[2];
        private JLabel[] egys = new JLabel[4];
        
        private JLabel[] romes = new JLabel[2];
        private JLabel[] romeb = new JLabel[4];
        private JLabel romew = new JLabel();
         private JLabel romet = new JLabel();
         
         private JLabel[] engs = new JLabel[2];
        private JLabel[] engb = new JLabel[5];
        private JLabel engw = new JLabel();
        private JLabel engt = new JLabel();
         
         
        
        
        private JLabel LB = new JLabel("Barracks");
        private JLabel LT = new JLabel("Town Center");
        private JLabel LW = new JLabel("Work Shop");
        private JLabel LS = new JLabel("Stabels");
        
        int ctrx, ctry;
        int j, z ;
	
	ImageIcon IIEgypt;
	ImageIcon IIEngland;
	ImageIcon IIRome;
	
	public BuldingDetails() throws IOException
	{
		
		
		setSize(2000,1000);
		
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(5,4));
		
		
			IIEgypt = new ImageIcon("pics\\Animated-Flag-Egypt.gif");
		
		
		
			IIEngland = new ImageIcon("pics\\Animated-Flag-United-Kingdom.gif");
		
		
			IIRome = new ImageIcon("pics\\Animated-Flag-Italy.gif");
		
                ctrx = 300;
                ctry = 20;
                j = 0;
                z = 0;
                
              
                for(int i = 0; i < 5; i++)
                {
                    Pbuilding[i] = new JPanel();
                    Pbuilding[i].setLayout(null);
                    if( i == 0){
                        LB.setBounds(10,10,300,50);
                        LB.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
                        LB.setForeground(Color.WHITE);
                        Pbuilding[i].add(LB);
                    }
                    else if(i == 1){
                         LW.setBounds(10,10,300,50);
                         LW.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
                        LW.setForeground(Color.WHITE);
                        Pbuilding[i].add(LW);
                    }
                    if( i == 2){
                         LS.setBounds(10,10,300,50);
                         LS.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
                        LS.setForeground(Color.WHITE);
                        Pbuilding[i].add(LS);
                    }
                    if( i == 3){
                         LT.setBounds(10,10,300,50);
                         LT.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
                        LT.setForeground(Color.WHITE);
                        Pbuilding[i].add(LT);
                    }
                    add(Pbuilding[i]);
                   cp.add(Pbuilding[i]);
             
                }
                
                for(int i=0;i<12;i++){
                    
                    if(i >= 0 && i < 4){
                        Lbuilding[i] = new JLabel();
                        Lbuilding[i].setIcon(IIEgypt);
                        Lbuilding[i].setBounds(ctrx, ctry-30, 300, 200);
                        Pbuilding[i].add(Lbuilding[i]);
                    }
                    
                    else if(i >= 4 && i <8){
                        
                        Lbuilding[i] = new JLabel();
                        Lbuilding[i].setIcon(IIRome);
                        Lbuilding[i].setBounds(ctrx + 500, ctry-30, 300, 200);
                        
                        Pbuilding[j].add(Lbuilding[i]);
                        j++;
                    }
                    
                    else if(i >= 8 && i < 12){
                        Lbuilding[i] = new JLabel();
                        Lbuilding[i].setIcon(IIEngland);
                         Lbuilding[i].setBounds(ctrx + 1000, ctry-30, 300, 200);
                        Pbuilding[z].add(Lbuilding[i]);
                        z++;
                    }
                    
                    
                
                }
                ctrx = 90;
                ctry = 60;
                for(int i =0 ;i<5; i++){
                    egyb[i] = new JLabel();
                    egyb[i].setBounds(ctrx, ctry, 200, 100);
                    ctrx += 200;
                    Pbuilding[4].add(egyb[i]);
                    egyb[i].setVisible(false);
                    
                    
                     
                }
                ctrx = 90;
                for(int i=0;i<5;i++){
                    engb[i] = new JLabel();
                    engb[i].setBounds(ctrx, ctry, 200, 100);
                    ctrx += 200;
                    Pbuilding[4].add(engb[i]);
                    engb[i].setVisible(false);
                }
                
               // egyb[0].setIcon(new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\14277889158911.jpg"));
                egyb[1].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\8028276_orig (1).jpg")).getScaledInstance(100, 100, 0)));
                egyb[2].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Archer.jpg")).getScaledInstance(100, 100, 0)));
                egyb[3].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Hoplite.jpg")).getScaledInstance(100, 100, 0)));
                egyb[4].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\AxeMan.jpg")).getScaledInstance(100, 100, 0)));
                egyb[0].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\ClubMan.png")).getScaledInstance(100, 100, 0)));
                
                engb[0].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\ClubMan.png")).getScaledInstance(100, 100, 0)));
                engb[1].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\8028276_orig (1).jpg")).getScaledInstance(100, 100, 0)));
                engb[2].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Archer.jpg")).getScaledInstance(100, 100, 0)));
                engb[3].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Hoplite.jpg")).getScaledInstance(100, 100, 0)));
                engb[4].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\AxeMan.jpg")).getScaledInstance(100, 100, 0)));

                
                
                egyw[0] = new JLabel();
                egyw[1] = new JLabel();
                egyw[0].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\BallistaWeapon.jpg")).getScaledInstance(100, 100, 0)));
                egyw[1].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Catapult.png")).getScaledInstance(100, 100, 0)));
                
                romes[0] = new JLabel();
                romes[1] = new JLabel();
                
                romes[0].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\14277889158911.jpg")).getScaledInstance(100, 100, 0)));
                romes[1].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Chariot1.jpg")).getScaledInstance(100, 100, 0)));
                
                romes[0].setBounds(50,60,200,100);
                romes[1].setBounds(300,60,200,100);
                
                romes[0].setVisible(false);
                romes[1].setVisible(false);
                
                engs[0] = new JLabel();
                engs[1] = new JLabel();
                
                engs[0].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Armoured_Elephant.jpg")).getScaledInstance(100, 100, 0)));
                engs[1].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Elephant_archer_2.jpg")).getScaledInstance(100, 100, 0)));
                
                engs[0].setBounds(50,60,200,100);
                engs[1].setBounds(300,60,200,100);
                
                Pbuilding[4].add(engs[0]);
                 Pbuilding[4].add(engs[1]);
                
                engs[0].setVisible(false);
                engs[1].setVisible(false);
                
                romew.setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\BallistaWeapon.jpg")).getScaledInstance(100, 100, 0)));
                romew.setBounds(90,60,200,100);
                Pbuilding[4].add(romew);
                romew.setVisible(false);
                
                
                
                romet.setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Villager.jpg")).getScaledInstance(100, 100, 0)));
                romet.setBounds(90,60,200,100);
                Pbuilding[4].add(romet);
                romet.setVisible(false);
                
                engt.setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Villager.jpg")).getScaledInstance(100, 100, 0)));
                engt.setBounds(90,60,200,100);
                Pbuilding[4].add(engt);
                engt.setVisible(false);
                
                Pbuilding[4].add(romes[0]);
                Pbuilding[4].add(romes[1]);
                
                engw.setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Catapult.png")).getScaledInstance(100, 100, 0)));
                engw.setBounds(90,60,200,100);
                Pbuilding[4].add(engw);
                engw.setVisible(false);
                
                
                ctrx = 90;
                
                for(int i=0;i<4;i++){
                    egys[i] = new JLabel();
                     egys[i].setBounds(ctrx, ctry, 200, 100);
                    ctrx += 200;
                    Pbuilding[4].add(egys[i]);
                    egys[i].setVisible(false);
                    
                    romeb[i] = new JLabel();
                    romeb[i].setBounds(ctrx, ctry, 200, 100);
                    ctrx += 200;
                    Pbuilding[4].add(romeb[i]);
                    romeb[i].setVisible(false);
                }
                
                romeb[0].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\8028276_orig (1).jpg")).getScaledInstance(100, 100, 0)));
                romeb[1].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Archer.jpg")).getScaledInstance(100, 100, 0)));
                romeb[2].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\ClubMan.png")).getScaledInstance(100, 100, 0)));
                romeb[3].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Priest.jpg")).getScaledInstance(100, 100, 0)));

                
                egys[0].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\14277889158911.jpg")).getScaledInstance(100, 100, 0)));
                egys[1].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Chariot1.jpg")).getScaledInstance(100, 100, 0)));
                egys[2].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Armoured_Elephant.jpg")).getScaledInstance(100, 100, 0)));
                egys[3].setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Elephant_archer_2.jpg")).getScaledInstance(100, 100, 0)));

                
                egyt.setIcon(new ImageIcon(ImageIO.read(new File("Age of Empires\\Villager.jpg")).getScaledInstance(100, 100, 0)));
                
                egyt.setBounds(50,ctry,200,100);
                Pbuilding[4].add(egyt);
                egyt.setVisible(false);
                
                egyw[0].setBounds(50,ctry,200,100);
                egyw[1].setBounds(200,ctry,200,100);
                Pbuilding[4].add(egyw[0]);
                Pbuilding[4].add(egyw[1]);
                egyw[0].setVisible(false);
                egyw[1].setVisible(false);
                
                
		Pbuilding[0].setBackground(Color.red);
                Pbuilding[1].setBackground(Color.black);
                Pbuilding[2].setBackground(Color.blue);
                Pbuilding[3].setBackground(Color.green);
                
                for(int i = 0 ; i < 12; i++){
                       Lbuilding[i].addMouseListener(new myHandler());
                }
                
		
		
		
	}
        
        public class myHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
           }

        @Override
        public void mousePressed(MouseEvent e) {
            }

        @Override
        public void mouseReleased(MouseEvent e) {
            }

        @Override
        public void mouseEntered(MouseEvent e) {
           
               if(e.getSource().equals(Lbuilding[0])){
                   for(int i = 0; i< 5;i++){
                       egyb[i].setVisible(true);
                   }
               }
               
               if(e.getSource().equals(Lbuilding[3])){
                   egyt.setVisible(true);
               }
           
               if(e.getSource().equals(Lbuilding[1])){
                   egyw[0].setVisible(true);
                   egyw[1].setVisible(true);
               }
               if(e.getSource().equals(Lbuilding[2])){
                   for(int i = 0; i< 4;i++){
                       egys[i].setVisible(true);
                   }
               }
               if(e.getSource().equals(Lbuilding[8])){
                   for(int i = 0; i< 4;i++){
                       romeb[i].setVisible(true);
                   }
               }
                if(e.getSource().equals(Lbuilding[10])){
                   romes[0].setVisible(true);
                   romes[1].setVisible(true);
               }
                if(e.getSource().equals(Lbuilding[9])){
                   romew.setVisible(true);
               }
                if(e.getSource().equals(Lbuilding[11])){
                   romet.setVisible(true);
               }
               if(e.getSource().equals(Lbuilding[4])){
                   for(int i = 0; i< 5;i++){
                       engb[i].setVisible(true);
                   }
               }
               
               if(e.getSource().equals(Lbuilding[5])){
                   engw.setVisible(true);
               }
               
               if(e.getSource().equals(Lbuilding[6])){
                   engs[0].setVisible(true);
                   engs[1].setVisible(true);
               }
               
               if(e.getSource().equals(Lbuilding[7])){
                   engt.setVisible(true);
               }
        
        }

        @Override
        public void mouseExited(MouseEvent e) {
             if(e.getSource().equals(Lbuilding[0])){
                   for(int i = 0; i< 5;i++){
                       egyb[i].setVisible(false);
                   }
               }
             if(e.getSource().equals(Lbuilding[3])){
                   egyt.setVisible(false);
               }
             if(e.getSource().equals(Lbuilding[1])){
                   egyw[0].setVisible(false);
                   egyw[1].setVisible(false);
               }
             
              if(e.getSource().equals(Lbuilding[2])){
                   for(int i = 0; i< 4;i++){
                       egys[i].setVisible(false);
                   }
               }
               if(e.getSource().equals(Lbuilding[8])){
                   for(int i = 0; i< 4;i++){
                       romeb[i].setVisible(false);
                   }
               
            }
                if(e.getSource().equals(Lbuilding[10])){
                   romes[0].setVisible(false);
                   romes[1].setVisible(false);
               }
        
                if(e.getSource().equals(Lbuilding[9])){
                   romew.setVisible(false);
                   
               }
                if(e.getSource().equals(Lbuilding[11])){
                   romet.setVisible(false);
               }
        
                if(e.getSource().equals(Lbuilding[4])){
                   for(int i = 0; i< 5;i++){
                       engb[i].setVisible(false);
                   }
               }
                if(e.getSource().equals(Lbuilding[5])){
                   engw.setVisible(false);
               }
                if(e.getSource().equals(Lbuilding[6])){
                   engs[0].setVisible(false);
                   engs[1].setVisible(false);
               }
                if(e.getSource().equals(Lbuilding[7])){
                   engt.setVisible(false);
               }
        }
        

}
}
