package mypckg;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;

public class TimeDate extends Thread{
	
	private String st;
	private int minute,second,hour;
        private JLabel z;
	public TimeDate(JLabel v)
	{
		minute =0;
		second =0;
		hour=0;
                z = v;
	}
	public void run()
	{
		int x = 0;
		while(true)
		{
			++second;
			if(second < 60 && minute == 0 && hour == 0)
			{
				System.out.println(second);
				if(second == 59)
				{
					minute++;
					second = 0;
				}
			}
                        else if((second <= 60 || minute > 0)&& hour == 0)
			{
				System.out.println(minute+":"+second);
				if(second == 59)
				{
					minute++;
					second = 0;
				}
				if(minute == 59)
				{
					hour++;
					second = 0;
					minute = 0;
				}
			}
			else if(second <= 60 || minute > 0 || hour > 0)
			{
				System.out.println(hour+":"+minute+":"+second);
				if(second == 59)
				{
					minute++;
					second = 0;
				}
				if(minute == 59)
				{
					hour++;
					second = 0;
					minute = 0;
				}
			}
                        z.setText(hour+":"+minute+":"+second);
			//st = Calendar.getInstance().getTime().toString().substring(11, 19);
			//System.out.println(st);
			//System.out.println(hour+":"+minute+":"+second);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
