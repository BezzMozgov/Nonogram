package View;

import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;
import Logic.*;

public class NngMenuBar extends JMenuBar implements ActionListener {
	private NngMainPanel mainPanel;
	private JMenuItem itemNew = new JMenuItem("New Game");
	private JMenuItem itemOpen = new JMenuItem("Open");
	private JMenuItem itemExit = new JMenuItem("Exit");
	private JMenuItem itemChangeSize = new JMenuItem("Change Field Size");
	
	public NngMenuBar(NngMainPanel mainPanel) {
		JMenu menuFile = new JMenu("File");
		JMenu menuOptions = new JMenu("Options");
		this.mainPanel = mainPanel;
		
		itemNew.addActionListener(this);
		itemNew.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
		itemOpen.addActionListener(this);
		itemOpen.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		itemExit.addActionListener(this);
		itemExit.setAccelerator(KeyStroke.getKeyStroke("alt F4"));
		
		itemChangeSize.addActionListener(this);
		
		menuFile.add(itemNew);
		menuFile.addSeparator();
		menuFile.add(itemOpen);
		menuFile.addSeparator();
		menuFile.add(itemExit);
		
		menuOptions.add(itemChangeSize);
		
		add(menuFile);
		add(menuOptions);
	}


	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == itemNew) {
			mainPanel.flush();
		}
		if (e.getSource() == itemOpen) {
			JFileChooser fChooser = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter("NNG Puzzle Files","nng");
			
			fChooser.setCurrentDirectory(new File("./src/puzzles"));
			fChooser.setAcceptAllFileFilterUsed(false);
			fChooser.addChoosableFileFilter(filter);
			int ret = fChooser.showOpenDialog(null);
			if (ret == JFileChooser.APPROVE_OPTION) {
			    File file = fChooser.getSelectedFile();
			    new NngPuzzleReader(file).buildHead();
			    mainPanel.flush();
			}
		}
		if (e.getSource() == itemExit) {
			System.exit(0);
		}
		
		if (e.getSource() == itemChangeSize) {
			JFrame parentFrame = (JFrame) this.getParent();
			JDialog dialog = new NngChangeSizeDialog(parentFrame);
		}
	}
}