/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import mypckg.*;

public class UnitsDetail extends JFrame {
    JLabel hp = new JLabel();
    JLabel att = new JLabel();
    JLabel move = new JLabel();
    JLabel time = new JLabel();
    JLabel range = new JLabel();
    JLabel name = new JLabel();
    JLabel background = new JLabel();
    
    
    
    JLabel units[] = new JLabel[14]; 
    
    int ctrx, ctry;
    
    ImageIcon img0 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\14277889158911.jpg");
    ImageIcon img1 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\SwordMan.jpg");
    ImageIcon img2 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\Archer.jpg");
    ImageIcon img3 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\Priest.jpg");
    ImageIcon img4 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\Hoplite.jpg");
    ImageIcon img5 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\Villager.jpg");
    ImageIcon img6 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\ClubMan.jpg");
    ImageIcon img7 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\BallistaWeapon.jpg");
    ImageIcon img8 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\Catapult.jpg");
    ImageIcon img9 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\AxeMan.jpg");
    ImageIcon img10 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\Elephant_archer_2.jpg");
    ImageIcon img11 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\Chariot.jpg");
    ImageIcon img12 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\Chariot1.jpg");
    ImageIcon img13 = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\Armoured_Elephant.jpg");
    
    ImageIcon back = new ImageIcon("D:\\MIU\\Fall 15\\OOP\\Project Startegy Game\\Project V2\\Age of Empires\\paint_texture2163.jpg");
    
    JPanel items;
    public UnitsDetail() throws IOException{
        
         background.setIcon(back);
        setContentPane(background);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setTitle("Unit Details");
        items = new JPanel();
        items.setBackground(Color.LIGHT_GRAY);
        items.setBounds(900, 80, 900, 900);
        add(items);
        items.setLayout(new GridLayout(4,4));
        
        background.setIcon(back);
        setContentPane(background);
        
         img0 = new ImageIcon(ImageIO.read(new File("Age of Empires\\14277889158911.jpg")).getScaledInstance(200, 200, 0));
         img1 = new ImageIcon(ImageIO.read(new File("Age of Empires\\8028276_orig (1).jpg")).getScaledInstance(200, 200, 0));
         img2 = new ImageIcon(ImageIO.read(new File("Age of Empires\\Archer.jpg")).getScaledInstance(200, 200, 0));
         img3 = new ImageIcon(ImageIO.read(new File("Age of Empires\\Priest.jpg")).getScaledInstance(200, 200, 0));
         img4 = new ImageIcon(ImageIO.read(new File("Age of Empires\\Hoplite.jpg")).getScaledInstance(200, 200, 0));
         img5 = new ImageIcon(ImageIO.read(new File("Age of Empires\\Villager.jpg")).getScaledInstance(200, 200, 0));
         img6 = new ImageIcon(ImageIO.read(new File("Age of Empires\\ClubMan.png")).getScaledInstance(200, 200, 0));
         img7 = new ImageIcon(ImageIO.read(new File("Age of Empires\\BallistaWeapon.jpg")).getScaledInstance(200, 200, 0));
         img8 = new ImageIcon(ImageIO.read(new File("Age of Empires\\Catapult.png")).getScaledInstance(200, 200, 0));
         img9 = new ImageIcon(ImageIO.read(new File("Age of Empires\\AxeMan.jpg")).getScaledInstance(200, 200, 0));
         img10 = new ImageIcon((ImageIO.read(new File("Age of Empires\\Elephant_archer_2.jpg"))).getScaledInstance(200, 200, 0));
         img11 = new ImageIcon((ImageIO.read(new File("Age of Empires\\Chariot.jpg"))).getScaledInstance(200, 200, 0));
         img12 = new ImageIcon((ImageIO.read(new File("Age of Empires\\Chariot1.jpg"))).getScaledInstance(200, 200, 0));
         img13 = new ImageIcon((ImageIO.read(new File("Age of Empires\\Armoured_Elephant.jpg"))).getScaledInstance(200, 200, 0));
 
         
        ImageIcon[] arr = {img0,img1,img2,img3,img4,img5,img6,img7,img8, img9, img10, img11, img12,img13};
        Container cp = getContentPane();
        
        cp.setLayout(null);
        
        hp.setBounds(50, 300, 200, 200);
        hp.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
        hp.setForeground(Color.green);
        cp.add(hp);
        hp.setVisible(false);
        
        att.setBounds(50,500,500,200);
        att.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
        att.setForeground(Color.green);
        cp.add(att);
        att.setVisible(false);
        
        move.setBounds(50, 400, 500, 200);
        move.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
        move.setForeground(Color.green);
        cp.add(move);
        move.setVisible(false);
        
        time.setBounds(50, 600, 500, 200);
        time.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
        time.setForeground(Color.green);
        cp.add(time);
        time.setVisible(false);
        
        name.setBounds(50, 200, 500, 200);
        name.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
        name.setForeground(Color.green);
        cp.add(name);
        name.setVisible(false);
        
        range.setBounds(50, 700, 500, 200);
        range.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
        range.setForeground(Color.green);
        cp.add(range);
        range.setVisible(false);
        
        
        
        ctrx = 50;
        int crty = 50;
        
        for(int i = 0 ; i < 14 ; i++)
        {
            units[i] = new JLabel();
            
        }
        for(int i = 0 ; i < 14 ; i++)
        {
            units[i].setText("");
            
            units[i].setIcon(arr[i]);
            items.add(units[i]);
            
            units[i].addMouseListener(new myHandler());
        }
        
    }
    
    public class myHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
             //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
             //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
             //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource().equals(units[0])){
                hp.setText("Health = " + new Knight().getHealth());
                att.setText("Attack Power = " + new Knight().getAttackPower());
                move.setText("Movement = " + new Knight().getMovement());
                time.setText("Bulid Time = " + new Knight().getBuildTime());
                name.setText("Name: " + new Knight().getName());
                range.setText("Range = " + new Knight().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
            
           if(e.getSource().equals(units[1])){
                 hp.setText("Health = " + new Soldier().getHealth());
                att.setText("Attack Power = " + new Soldier().getAttackPower());
                move.setText("Movement = " + new Soldier().getMovement());
                time.setText("Bulid Time = " + new Soldier().getBuildTime());
                name.setText("Name: " + new Soldier().getName());
                range.setText("Range = " + new Soldier().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            } 
                
            if(e.getSource().equals(units[2])){
                hp.setText("Health = " + new Archer().getHealth());
                att.setText("Attack Power = " + new Archer().getAttackPower());
                move.setText("Movement = " + new Archer().getMovement());
                time.setText("Bulid Time = " + new Archer().getBuildTime());
                name.setText("Name: " + new Archer().getName());
                range.setText("Range = " + new Archer().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
            
            if(e.getSource().equals(units[3])){
                 hp.setText("Health = " + new Priest().getHealth());
                att.setText("Attack Power = " + new Priest().getAttackPower());
                move.setText("Movement = " + new Priest().getMovement());
                time.setText("Bulid Time = " + new Priest().getBuildTime());
                name.setText("Name: " + new Priest().getName());
                range.setText("Range = " + new Priest().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
            
            if(e.getSource().equals(units[4])){
                 hp.setText("Health = " + new Hoplite().getHealth());
                att.setText("Attack Power = " + new Hoplite().getAttackPower());
                move.setText("Movement = " + new Hoplite().getMovement());
                time.setText("Bulid Time = " + new Hoplite().getBuildTime());
                name.setText("Name: " + new Hoplite().getName());
                range.setText("Range = " + new Hoplite().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
            
            if(e.getSource().equals(units[5])){
                 hp.setText("Health = " + new Villager().getHealth());
                att.setText("Attack Power = " + new Villager().getAttackPower());
                move.setText("Movement = " + new Villager().getMovement());
                time.setText("Bulid Time = " + new Villager().getBuildTime());
                name.setText("Name: " + new Villager().getName());
                range.setText("Range = " + new Villager().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
            
            if(e.getSource().equals(units[6])){
                 hp.setText("Health = " + new ClubMan().getHealth());
                att.setText("Attack Power = " + new ClubMan().getAttackPower());
                 move.setText("Movement = " + new ClubMan().getMovement());
                time.setText("Bulid Time = " + new ClubMan().getBuildTime());
                name.setText("Name: " + new ClubMan().getName());
                range.setText("Range = " + new ClubMan().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
            
            if(e.getSource().equals(units[7])){
                 hp.setText("Health = " + new Ballista().getHealth());
                att.setText("Attack Power = " + new Ballista().getAttackPower());
                move.setText("Movement = " + new Ballista().getMovement());
                time.setText("Bulid Time = " + new Ballista().getBuildTime());
                name.setText("Name: " + new Ballista().getName());
                range.setText("Range = " + new Ballista().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
            
            if(e.getSource().equals(units[8])){
                 hp.setText("Health = " + new Catapult().getHealth());
                att.setText("Attack Power = " + new Catapult().getAttackPower());
                move.setText("Movement = " + new Catapult().getMovement());
                time.setText("Bulid Time = " + new Catapult().getBuildTime());
                name.setText("Name: " + new Catapult().getName());
                range.setText("Range = " + new Catapult().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
            
            if(e.getSource().equals(units[9])){
                 hp.setText("Health = " + new AxeMan().getHealth());
                att.setText("Attack Power = " + new AxeMan().getAttackPower());
                move.setText("Movement = " + new AxeMan().getMovement());
                time.setText("Bulid Time = " + new AxeMan().getBuildTime());
                name.setText("Name: " + new AxeMan().getName());
                range.setText("Range = " + new AxeMan().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
            
            if(e.getSource().equals(units[10])){
                 hp.setText("Health = " + new ElephantArcher().getHealth());
                att.setText("Attack Power = " + new ElephantArcher().getAttackPower());
                move.setText("Movement = " + new ElephantArcher().getMovement());
                time.setText("Bulid Time = " + new ElephantArcher().getBuildTime());
                name.setText("Name: " + new ElephantArcher().getName());
                range.setText("Range = " + new ElephantArcher().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
            
            if(e.getSource().equals(units[11])){
                 hp.setText("Health = " + new HopliteChariot().getHealth());
                att.setText("Attack Power = " + new HopliteChariot().getAttackPower());
                move.setText("Movement = " + new HopliteChariot().getMovement());
                time.setText("Bulid Time = " + new HopliteChariot().getBuildTime());
                name.setText("Name: " + new HopliteChariot().getName());
                range.setText("Range = " + new HopliteChariot().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
            
             if(e.getSource().equals(units[12])){
                 hp.setText("Health = " + new ArcherChariot().getHealth());
                att.setText("Attack Power = " + new ArcherChariot().getAttackPower());
                move.setText("Movement = " + new ArcherChariot().getMovement());
                time.setText("Bulid Time = " + new ArcherChariot().getBuildTime());
                name.setText("Name: " + new ArcherChariot().getName());
                range.setText("Range = " + new ArcherChariot().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
             
              if(e.getSource().equals(units[13])){
                 hp.setText("Health = " + new WarElephant().getHealth());
                att.setText("Attack Power = " + new WarElephant().getAttackPower());
                move.setText("Movement = " + new WarElephant().getMovement());
                time.setText("Bulid Time = " + new WarElephant().getBuildTime());
                name.setText("Name: " + new WarElephant().getName());
                range.setText("Range = " + new WarElephant().getRange());
                
                hp.setVisible(true);
                att.setVisible(true);
                 move.setVisible(true);
                time.setVisible(true);
                name.setVisible(true);
                range.setVisible(true);
            }
                
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
             if(e.getSource().equals(units[0])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
             
              if(e.getSource().equals(units[1])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
              
            if(e.getSource().equals(units[2])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
            
             if(e.getSource().equals(units[2])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
             
              if(e.getSource().equals(units[3])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
              
               if(e.getSource().equals(units[4])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
               
                if(e.getSource().equals(units[5])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
                
                 if(e.getSource().equals(units[6])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
                 
            if(e.getSource().equals(units[7])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
                  
            if(e.getSource().equals(units[8])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
                   
            if(e.getSource().equals(units[9])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
                    
            if(e.getSource().equals(units[10])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
                
            }
            
            if(e.getSource().equals(units[11 ])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
            
            if(e.getSource().equals(units[12])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
            
            if(e.getSource().equals(units[13])){
                hp.setVisible(false);
                att.setVisible(false);
                move.setVisible(false);
                time.setVisible(false);
                name.setVisible(false);
                range.setVisible(false);
            }
        }
    }
    
}
