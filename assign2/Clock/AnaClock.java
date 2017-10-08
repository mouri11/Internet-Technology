import java.awt.*;
import java.applet.*;
import java.util.*;
import java.text.*;

public class AnaClock extends Applet implements Runnable
{
	int width, height;
	int h = 0, min = 0, s = 0;
	Thread t = null;
	boolean tSuspend;
	String time="";

	public void init () {
		width = getSize().width;
		height = getSize().height;
		setBackground(Color.black);
		setFont(new Font("Courier",Font.BOLD,15));
	}

	public void start () {
		if (t == null) {
			t = new Thread(this);
			t.setPriority(Thread.MIN_PRIORITY);
			tSuspend = false;
			t.start();
		}
		else {
			if (tSuspend) {
				tSuspend = false;
				synchronized(this){
					notify();
				}
			}
		}
	}

	public void stop () {
		tSuspend = true;
	}

	public void run () {
		try {
			while (true) {
				Calendar cal = Calendar.getInstance();	

				h = cal.get( Calendar.HOUR_OF_DAY );
	            if ( h > 12 ) h -= 12;
    	        min = cal.get( Calendar.MINUTE );
        	    s = cal.get( Calendar.SECOND );

				SimpleDateFormat formatting = new SimpleDateFormat("hh:mm:ss", Locale.getDefault());
				Date date = cal.getTime();
				time = formatting.format(date);

				//thread checks to see if it should suspend itself
				if (tSuspend) {
					synchronized(this){
						while (tSuspend) {
							wait();
						}
					}
				}
				repaint();
				t.sleep(1000);//time in milliseconds
			}
		}
		catch (Exception e) { }
	}

	void drawHand( double angle, int radius, Graphics g ) {  
      angle -= 0.5 * Math.PI;  
      int x = (int)( radius*Math.cos(angle) );  
      int y = (int)( radius*Math.sin(angle) );  
      g.drawLine( width/2, height/2, width/2 + x, height/2 + y );  
   	}  
  
   	void drawWedge( double angle, int radius, Graphics g ) {  
      angle -= 0.5 * Math.PI;  
      int x = (int)( radius*Math.cos(angle) );  
      int y = (int)( radius*Math.sin(angle) );  
      angle += 2*Math.PI/3;  
      int x2 = (int)( 5*Math.cos(angle) );  
      int y2 = (int)( 5*Math.sin(angle) );  
      angle += 2*Math.PI/3;  
      int x3 = (int)( 5*Math.cos(angle) );  
      int y3 = (int)( 5*Math.sin(angle) );  
      g.drawLine( width/2+x2, height/2+y2, width/2 + x, height/2 + y );  
      g.drawLine( width/2+x3, height/2+y3, width/2 + x, height/2 + y );  
      g.drawLine( width/2+x2, height/2+y2, width/2 + x3, height/2 + y3 );  
   	}  
  
   	public void paint( Graphics g ) {  
      g.setColor( Color.gray );  
      drawWedge( 2*Math.PI * h / 12, width/5, g );  
      drawWedge( 2*Math.PI * min / 60, width/3, g );  
      drawHand( 2*Math.PI * s / 60, width/2, g );  
      g.setColor( Color.white );  
      g.drawString( time, 10, height-10 );  
   	}  
}