package View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NngMainPanel extends JPanel
{
	private NngFrame mainFrame;
	private JPanel menuPanel; // menu panel (NORTH border)
	private JPanel centerPanel; // CENTER panel with centerButtonPanel, northTextFiledPanel, westTextFieldPanel;
	
	public NngMainPanel(NngFrame mainFrame)
	{
		this.mainFrame = mainFrame;
		setLayout(new BorderLayout()); // диспетчер граничной компоновки

		menuPanel = new JPanel(new BorderLayout());
		centerPanel = new JPanel();
		
		//adding menu to sub panel
		menuPanel.add(new NngMenuBar(this));
		centerPanel.add(new NngCenterPanel());
		
		add(menuPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
	}
	
	public void flush() {
		removeAll();
		menuPanel = new JPanel(new BorderLayout());
		centerPanel = new JPanel();
		
		//adding menu to sub panel
		menuPanel.add(new NngMenuBar(this));
		centerPanel.add(new NngCenterPanel());
		
		add(menuPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		
		mainFrame.flush();
		revalidate();
	}
}