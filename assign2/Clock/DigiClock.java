import java.awt.*;
import java.applet.*;
import java.util.*;
import java.text.*;

public class DigiClock extends Applet implements Runnable
{
	Thread t = null;
	String time = "";

	public void init () {
		setFont(new Font("Helvetica",Font.BOLD, 50));
		setBackground(Color.red);
	}

	public void start () {
		t = new Thread(this);
		t.start();
	}

	public void run () {
		try {
			while (true) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat formatting = new SimpleDateFormat("hh:mm:ss");
				Date date = cal.getTime();
				time = formatting.format(date);

				repaint();

				t.sleep(1000);//time in milliseconds
			}
		}
		catch (Exception e) { }
	}

	public void paint (Graphics g) {
		g.setColor(Color.yellow);
		g.drawString(time, 125, 250);
	}
}