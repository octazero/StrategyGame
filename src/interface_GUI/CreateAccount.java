package interface_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;


public class CreateAccount extends JFrame{
    private JLabel UserName = new JLabel("Username: ");
    private JLabel Password = new JLabel("Password: ");
    private JLabel back = new JLabel();
    private JLabel nation = new JLabel("Choose Your Country: ");
    private FirstScreen fs;
    private JButton CreateAccount = new JButton("Create Account");
    private JTextField UserNameTF = new JTextField("Type your Username here");
    private JTextField PasswordTF = new JTextField("Type your password name here");
    private ImageIcon backimg = new ImageIcon("Age of Empires\\1431445080632.jpg");
    
    private JComboBox countries = new JComboBox();
    
    private JButton CreateAC = new JButton("Create Account");
 
    public CreateAccount()
    {
       this.setExtendedState(this.MAXIMIZED_BOTH);
        
        myHandler handler = new myHandler();
        
        back.setIcon(backimg);
        setContentPane(back);
        
        Container cp = getContentPane();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        cp.setLayout(null);
        
        UserName.setBounds(650, 400, 300, 50);
        Password.setBounds(650, 500, 300, 50);
        
        UserName.setForeground(Color.red);
        Password.setForeground(Color.red);
        UserName.setFont(new Font("Imprint MT Shadow", Font.BOLD, 36));

        Password.setFont(new Font("Imprint MT Shadow", Font.BOLD, 36));
        
        UserNameTF.setBounds(900, 400, 300, 50);
        PasswordTF.setBounds(900, 500, 300, 50);
        
        CreateAC.setBounds(800, 700, 300, 50);
        CreateAC.addActionListener(handler);
        
        nation.setBounds(450, 600, 400, 50);
        nation.setForeground(Color.red);
        nation.setFont(new Font("Imprint MT Shadow", Font.BOLD, 36));
        
        countries.setBounds(900, 600, 400, 50);
        countries.setForeground(Color.red);
        
		String[] locales = Locale.getISOCountries();
		for (String countryCode : locales) 
		{
			int i = 0;
			Locale obj = new Locale("", countryCode);
			countries.insertItemAt(obj.getDisplayCountry(), i);
		    i++;
		}
        countries.setFont(new Font("Imprint MT Shadow", Font.BOLD, 36));
        
        cp.add(UserName);
        cp.add(Password);
        cp.add(nation);
        
        cp.add(countries);
        
        cp.add(UserNameTF);
        cp.add(PasswordTF);
        
        cp.add(CreateAC); 
    }  
    public class myHandler implements ActionListener{
        public void actionPerformed (ActionEvent e){
            
            Object x = e.getSource();
            if(x.equals(CreateAC))
            {
            	mypckg.FileManger.createprofile(UserNameTF.getText(),PasswordTF.getText());
            	UserNameTF.setText("Type your Username here");
            	PasswordTF.setText("Type your password name here");
                setVisible(false);
                fs.setVisible(true);
            }
        }
    }
    public void setFirstScreen(FirstScreen x)
    {
    	fs = x;
    }
}
