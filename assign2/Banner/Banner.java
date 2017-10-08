import java.awt.*;
import java.applet.*;

public class Banner extends Applet implements Runnable
{
	String msg;
	char ch;
	boolean stop;
	Thread t;

	public void init () {
		msg = "Maulana Abul Kalam Azad University of Technology. ";
		setFont(new Font("TimesRoman",Font.BOLD + Font.ITALIC, 20));
		setBackground(Color.cyan);
		setForeground(Color.red);
		stop = true;
		t = null;
	}

	public void start () {
		t = new Thread (this);
		stop = false;
		t.start();
	}

	public void run () {
		for (;;) {
			try {
				repaint();
				Thread.sleep(100);
				ch = msg.charAt(0);
				msg = msg.substring(1,msg.length());
				msg = msg + ch;
				if(stop) break;
			}
			catch (InterruptedException e) {}
		}
	}

	public void stop () {
		stop = true;
		t = null;
	}

	public void paint (Graphics g) {
		g.drawString(msg, 150, 150);
	}
}