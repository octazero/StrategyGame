package interface_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.border.Border;



public class FirstScreen extends JFrame{
    private boolean firstTime;
    private MainMenu mm;
    private CreateAccount CA;
    private JButton[] buttons = new JButton [2];
    private JLabel [] Labels = new JLabel [4];
    private JTextField [] Txt = new JTextField [2];
    private JButton ExitToWindows = new JButton("Exit To Windows");
    private JLabel fire = new JLabel();
    private JLabel currentPlayer = new JLabel("Player 1 Login");
    private JLabel ready = new JLabel();
    private ImageIcon fireimg = new ImageIcon("pics\\First_Screen.jpg");
    private ImageIcon readyimg = new ImageIcon("pics\\First.png");
    private String firstUsername;
    private String firstPassword;
    private boolean x = false;
    private JPasswordField password;
    
    public FirstScreen()
    {   
        mm = new MainMenu();
    	CA = new CreateAccount();
    	firstUsername = new String("");
    	firstPassword = new String("");
    	CA.setFirstScreen(this);
    	mm.setFirstScreen(this);
        myHandler handler = new myHandler();
        firstTime = true;
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setTitle("The Age Of OOP");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        buttons[0] = new JButton("Create Account");
        buttons[1] = new JButton("Login");
        
        
        Labels[0] = new JLabel("Username: ");
        Labels[1] = new JLabel("Password: ");
        Labels[2] = new JLabel("If you don't have an account --> ");
        Labels[3] = new JLabel("THE AGE OF OOP");
        
        Txt[0] = new JTextField("Type Username Here");
        
        password = new JPasswordField("Type Password Here");
        
        fire.setIcon(fireimg);
        setContentPane(fire);
        
        
        Container cp = getContentPane();
        
        cp.setLayout(null);
        
        cp.setBackground(Color.black);
        
        Labels[0].setBounds(700,300,300,50);
        Labels[1].setBounds(700,450,300,50);
        Labels[2].setBounds(600, 650, 500, 50);
        Labels[3].setBounds(650,10,1600,100);
        currentPlayer.setBounds(520,120,500,100);
        currentPlayer.setFont(new Font("Imprint MT Shadow", Font.BOLD, 40));
        cp.add(currentPlayer);
        Labels[0].setForeground(Color.red);
        Labels[1].setForeground(Color.red);
        Labels[2].setForeground(Color.red);
        Labels[3].setForeground(Color.red);
        
        Labels[0].setFont(new Font("Imprint MT Shadow", Font.BOLD, 36));
        Labels[1].setFont(new Font("Imprint MT Shadow", Font.BOLD, 36));
        Labels[2].setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
        Labels[3].setFont(new Font("Imprint MT Shadow", Font.BOLD, 60));
        
        
        Txt[0].setBounds(900,300,300,50);
        password.setBounds(900,450,300,50);
        
        buttons[1].setBounds(800, 550, 300, 50);
        buttons[1].addActionListener(handler);
        
        buttons[0].setBounds(1100, 650, 300, 50);
        buttons[0].addActionListener(handler);
        
        ExitToWindows.setBounds(800, 770, 300, 50);
        ExitToWindows.addActionListener(handler);
        
        ready.setBounds(80,550,500,500);
        ready.setIcon(readyimg);
        cp.add(ready);
        
        for ( int i =0; i<4; i++)
        {
            cp.add(Labels[i]);
            
        }
        for (int i =0; i<2; i++)
        {
            cp.add(buttons[i]);
            
        }
        cp.add(Txt[0]);
        cp.add(ExitToWindows);
        cp.add(password);
        Txt[0].addFocusListener(new myHandlerf());
        password.addFocusListener(new myHandlerf());
        
    }
    
    public class myHandlerf implements FocusListener{

        @Override
		public void focusGained(FocusEvent e) {
                   if(!firstTime)
                   {
                       if ( x == false)
                    {
                        
                        if ( e.getSource().equals(Txt[0]))
                        {
                            Txt[0].setText("");
                            x = true;
                        }
                    }
                    if ( x == true)
                    {
                        
                        if ( e.getSource().equals(password))
                        {
                            password.setText("");
                            x = false;
                        }
                    }
                   }
                   else
                   firstTime = false;
			
			
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			
			
		}

    }
    
    
    public class myHandler implements ActionListener{
        

        @Override
        public void actionPerformed(ActionEvent e) {
             Object myevent = e.getSource();
             if (myevent.equals(buttons[1]))
             {//mm.setVisible(true);
            			//setVisible(false);
                if(!GUIManager.PL[0].getlog())
            	{
            		if(mypckg.FileManger.login(Txt[0].getText(), new String(password.getPassword())))
            		{
            			firstUsername = Txt[0].getText();
            			firstPassword = password.getText();
            			GUIManager.PL[0].setName(firstUsername);
            			GUIManager.PL[0].setlog(true);
            			currentPlayer.setText("Player 2 Login");
                                currentPlayer.setFont(new Font("Imprint MT Shadow", Font.BOLD, 40));
            			Labels[0] .setText("Username2: ");
            		}
            		else
            			JOptionPane.showMessageDialog(null, "WRONG USERNAME OR PASSWORD");
            	}
            	else if(!GUIManager.PL[1].getlog())
            	{
            		if(firstUsername.equals(Txt[0].getText()) && firstPassword.equals(new String(password.getPassword())))
            		{
            			JOptionPane.showMessageDialog(null, "Player already logged in");
            			return;
            		}
            			
            		if(mypckg.FileManger.login(Txt[0].getText(), password.getText()))
            		{
            			GUIManager.PL[1].setName(Txt[0].getText());
            			GUIManager.PL[1].setlog(true);
            			mm.setVisible(true);
            			setVisible(false);
            		}
            		else
            			JOptionPane.showMessageDialog(null, "WRONG USERNAME OR PASSWORD");
            	}
             }
             if(myevent.equals(buttons[0]))
             {
                 CA.setVisible(true);
                 setVisible(false);
             }          
            if ( myevent.equals(ExitToWindows))
            { 
                int choice = JOptionPane.showConfirmDialog(ExitToWindows, "Are you sure you want to exit ?");
                if ( choice == JOptionPane.YES_OPTION)
                {
                    setVisible(false);
                    System.exit(1);
                }
            }
        }   
    }
    public void setLogged(int playerNum)
    {
        if(playerNum == 1)
        {
            GUIManager.PL[1].setlog(false);
        }
        else
        {
            GUIManager.PL[1].setlog(false);
            firstUsername = Txt[0].getText();
            firstPassword = new String(password.getPassword());
        }
            
       
    }
    
}
