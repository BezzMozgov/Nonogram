package View;

import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import exceptions.*;

public class NngView {
	public NngFrame frame;
	
	public NngView() 
	throws SizeInputException
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
						frame = new NngFrame();
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
	          }
	      });
	}
}
