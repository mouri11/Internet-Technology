import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class Linker extends Applet implements ActionListener 
{
	public void init () {
		String link = "google";
		Button b = new Button(link);
		b.addActionListener(this);
		add(b);
	}

	public void actionPerformed(ActionEvent ae) {
		Button source = (Button)ae.getSource();
		String link = "https://www." + source.getLabel() + ".com";

		try {
			AppletContext a = getAppletContext();
			URL url = new URL(link);
			a.showDocument(url,"_self");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}