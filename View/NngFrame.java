package View;

import javax.swing.*;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import exceptions.*;

public class NngFrame extends JFrame
{
   public NngFrame()
   {
	      setTitle("Nonogram");
        //  new NngChangeSizeDialog(this);
	      add(new NngMainPanel(this));
	      pack();
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
	      Point newLocation = new Point(middle.x - (this.getWidth() / 2), 
	                                    middle.y - (this.getHeight() / 2));
	      this.setLocation(newLocation);
	}
   
   public void flush() {
	   pack();
   }
   
   
 //  public void update(Observable obs, Object obj) {
//		
//	}
}
