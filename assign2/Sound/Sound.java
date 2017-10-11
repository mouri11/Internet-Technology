import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Sound extends Applet implements ActionListener 
{
   Button play;
   AudioClip audioClip;
   
   public void init() {
      play = new Button(" Play ");
      add(play);
      play.addActionListener(this);
      audioClip = getAudioClip(getCodeBase(), "sirenpolice.wav");
   }
   public void actionPerformed(ActionEvent ae) {
      Button source = (Button)ae.getSource();
      audioClip.play();
   }
}