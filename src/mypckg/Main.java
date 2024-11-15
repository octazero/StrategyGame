package mypckg;
import interface_GUI.*;
import java.io.IOException;
public class Main {
        public static gameHandler objectz = new gameHandler(new Pos(20,10));
	public static void main(String[] args) throws IOException {
		GUIManager object = new GUIManager();
                Main.objectz.map.updateTile(new Villager(), new Pos(5,5));
                Music m = new Music();
                m.start();
                /*for(int i=0;i<10;i++)
                {
                    Knight x = new Knight();
                    Main.objectz.map.updateTile(x, new Pos(i,5));
                        
                }
                for(int i=0;i<10;i++)
                {
                    Knight x = new Knight();
                    x.setPlayerOwn(1);
                    Main.objectz.map.updateTile(x, new Pos(i,6));
                   
                }    */
	}

}
