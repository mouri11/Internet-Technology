// Shapes.java
import java.awt.*;
import java.applet.*;
import java.util.*;

public class Shapes extends Applet
{
	int width,height;

	public void init () {
		height = getSize().height;	width = getSize().width;

		setBackground(Color.gray);
		setFont(new Font("TimesRoman",Font.BOLD,20));
	}

	public void paint (Graphics g) {
		int x1[] = {10,20,30,40};	int y1[] = {50,60,70,80};
		g.drawString("Shapes without colour!!",width / 2 - 100, 20);

		g.drawLine(0,0,width/2, height / 2);
		g.drawOval(width/3, height/3, 70, 80);
		g.drawOval(width/3, height/3, 100, 100);
		g.drawRect(width/2, height/2, 150, 200);	g.drawPolygon(x1,y1,4);
		g.drawArc(0,0,200,300,270,60);
	}
}