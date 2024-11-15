/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypckg;
import java.io.*;
import java.util.HashMap;
import interface_GUI.*;
import javax.swing.*;


/**
 *
 * @author Amr
 */
public class FileManger implements Serializable{
    private static HashMap <String,String> encryptTable = new HashMap<String,String> ();
    private FileManger()
    {
    	
                encryptTable.put("a", "2$");
		encryptTable.put("b", "&*");
		encryptTable.put("c", ")*");
		encryptTable.put("d", "(%");
		encryptTable.put("e", "@#");
		encryptTable.put("f", "%%");
		encryptTable.put("g", "$%^");
		encryptTable.put("h", "$$%^");
		encryptTable.put("i", "^^&*");
		encryptTable.put("j", "^**");
		encryptTable.put("k", "(&)");
		encryptTable.put("l", "#$&(");
		encryptTable.put("m", "^%#%");
		encryptTable.put("n", "%*%(");
		encryptTable.put("o", "*(@");
		encryptTable.put("p", "#*(#");
		encryptTable.put("q", "(##*)");
		encryptTable.put("r", "@@#");
		encryptTable.put("s", ")@*");
		encryptTable.put("t", "8$%");
		encryptTable.put("u", "(68");
		encryptTable.put("v", "$%2");
		encryptTable.put("w", "8#($");
		encryptTable.put("x", "#&^)2");
		encryptTable.put("y", "@*&");
		encryptTable.put("z", "9$%#1");

    }
    public static boolean login(String user,String pass)
    {
        FileManger f=new FileManger();
        user =f.Enc(user);
        pass=f.Enc(pass);
                
				try {
					HashMap<String,String> map=new HashMap<>();
	                ObjectInputStream read;
					read = new ObjectInputStream(new FileInputStream(new File("accounts.bin")));
					map=(HashMap)read.readObject();
	                String k= map.get(user);
	                if(k!=null)
	                	if(pass.equals(k))
		                	return true;
	                else
	                	return false;
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         return false;
                
               /* if(k!=null)
                {
                    if(k.equals(pass)&&!set.equals(GUIManager.PL[0].getName())&&!set.equals(GUIManager.PL[1].getName())) 
                    {
                        if(GUIManager.PL[0].getlog()==false)
                        {
                            GUIManager.PL[0].setlog(true);
                            GUIManager.PL[0].setName(set);  
                            if(GUIManager.PL[1].getlog()==true)
                            {
                            MM.setVisible(true);
                            main.setVisible(false);
                            }
                            else{
                            Labels[0].setText("Username2: ");
                            Labels[1] .setText("Password2: ");
                            Txt.setText("");
                            Pas.setText("");}
                        }
                        else if(GUIManager.PL[1].getlog()==false){
                            GUIManager.PL[1].setlog(true);
                            GUIManager.PL[1].setName(set);
                            MM.setVisible(true);
                            main.setVisible(false);
                        }
                    }
                    else
                    {
                        if(!set.equals(GUIManager.PL[0].getName())&&!set.equals(GUIManager.PL[1].getName()))
                        {
                            JOptionPane.showMessageDialog(null,"wrong username or password");
                        }
                        else  if(k.equals(pass)==true)
                        {
                            JOptionPane.showMessageDialog(null,"already loged in");
                        }
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,"wrong username or password");
                read.close();
        }
        catch(  IOException | ClassNotFoundException IO){}*/
    }
    private static String Enc(String K)
    {
        String enc=new String();
        for(int i=0;i<K.length();i++)
            enc+=encryptTable.get(""+K.charAt(i));
        return enc;
    }
    public static void save()
    {
        JFileChooser saveFile = new JFileChooser();
                saveFile.showSaveDialog(null);
                String path=""+saveFile.getSelectedFile()+".OOP";
        try{
            ObjectOutputStream write=new ObjectOutputStream(new FileOutputStream(path));
            write.writeObject("Game "+GUIManager.PL[0].getName()+" "+GUIManager.PL[1].getName());
            write.writeObject(GUIManager.PL[0]);
            write.writeObject(GUIManager.PL[1]);
            write.writeObject(mypckg.gameHandler.map);
            write.close();
        }
        catch(IOException e){}
    }
    public static void load()
    {
        Map m;//this function will be change base on how we wil make map whether a static variale or no
        JFileChooser openFile = new JFileChooser();
                openFile.showOpenDialog(null);
                String path=""+openFile.getSelectedFile();
                String first ="Game "+GUIManager.PL[0].getName()+" "+GUIManager.PL[1].getName();
                String second="Game "+GUIManager.PL[1].getName()+" "+GUIManager.PL[0].getName();
                String check=new String();
                if(path.length()>=4){
                    for(int i=0;i<4;i++)
                    {
                       check+=path.charAt(path.length()-4+i);
                    }
                    if(!check.equals(".OOP"))
                    {
                        JOptionPane.showMessageDialog(null, "this file is not a saved game");
                        return ;
                    }
                }
                else{
                        JOptionPane.showMessageDialog(null, "this file is not a saved game");
                        return ;
                    }
        try{
            String reader=new String();
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(path));
            reader=(String)read.readObject();
            System.out.println(reader);
            if(reader.equals(first)||reader.equals(second))
            {
            GUIManager.PL[0]=(Player)read.readObject();
            GUIManager.PL[1]=(Player)read.readObject();
            m=(Map)read.readObject();
            read.close();
            mypckg.gameHandler.map=m;
            }
            else
            {
                read.close();
                JOptionPane.showMessageDialog(null, "this saved file is not for this accounts");
                return ;
            }
        }
        catch(IOException|ClassNotFoundException e){}
        
    }
    public static void createprofile(String user,String pass)
    {
 
        user = Enc(user);
        pass= Enc(pass);
        try{ 
            HashMap<String,String> map;
            ObjectInputStream read=new ObjectInputStream(new FileInputStream("accounts.bin"));
            map=(HashMap)read.readObject();
            read.close();
            if(!map.containsKey(user))
            {
                Network n=new Network();
                n.start();
                Thread.sleep(1000);
                int Check=0;
                System.out.println(n.getCode());
                String c=JOptionPane.showInputDialog("Registeration code :");
                if(JOptionPane.OK_OPTION==0)
                {
                    if(!c.equals("")){
                        try{
                            Check=Integer.parseInt(c);
                            if(Check==n.getCode())
                            {
                                
                                JOptionPane.showMessageDialog(null, "Created Account");
                                map.put(user, pass);
                                ObjectOutputStream write=new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                write.writeObject(map);
                                write.close();
                            }
                            else{
                              
                                JOptionPane.showMessageDialog(null, "Wrong Code");
                            }
                                
                        }
                        catch(NumberFormatException e)
                        {
                            JOptionPane.showMessageDialog(null, "Thats not a number");
                        }
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "accout already exist");
            }
        }
        catch(  IOException | ClassNotFoundException | InterruptedException IO){
        	File x = new File("accounts.bin");
        	try {
				x.createNewFile();
				 HashMap<String,String> map = new HashMap<String,String>();
				 Network n=new Network();
	                n.start();
    	                Thread.sleep(1000);
	                int Check=0;
	                System.out.println(n.getCode());
	                String c=JOptionPane.showInputDialog("Registeration code :"); 
	                if(JOptionPane.OK_OPTION==0)
	                {
	                    if(!c.equals("")){
	                        try{
	                            Check=Integer.parseInt(c);
	                            if(Check==n.getCode())
	                            {
	                                JOptionPane.showMessageDialog(null, "Created Account");
	                                map.put(user, pass);
	                                ObjectOutputStream write=new ObjectOutputStream(new FileOutputStream("accounts.bin"));
	                                write.writeObject(map);
	                                write.close();
	                            }
	                            else
	                                JOptionPane.showMessageDialog(null, "Wrong Code");
	                        }
	                        catch(NumberFormatException e)
	                        {
	                            JOptionPane.showMessageDialog(null, "Thats not a number");
	                        }
	                    }
			}
        	}catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
        }
             
    }
    public static void logout(int x,JButton SignOut,MainMenu that)
    {
        int choice =  JOptionPane.showConfirmDialog(SignOut, "Are You sure you want Player "+GUIManager.PL[x].getName()+" to Sign out ??"); 
        if(choice == JOptionPane.YES_OPTION)
         { 
             GUIManager.PL[x].setlog(false);
             GUIManager.PL[x]=new Player();
             FirstScreen A = new FirstScreen();
             A.setVisible(true);
             that.setVisible(false);
         }    
    }
    
}
