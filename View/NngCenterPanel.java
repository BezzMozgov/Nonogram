package View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Logic.NngPuzzleReader;
import Logic.TestClass;

public class NngCenterPanel extends JPanel implements ActionListener {
	private JButton[][] buttonSet;
	private JTextField[][] textFieldSetRows;
	private JTextField[][] textFieldSetColumns;
	private JPanel northInfoPanel;
	private JPanel northTextFieldPanel;
	private JPanel westTextFieldPanel;
	private JPanel centerButtonPanel;
	
	public NngCenterPanel() {
		GridBagLayout gbLayout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		setLayout(gbLayout);
		
		buttonSet = new JButton[TestClass.getRows()][TestClass.getCols()];
		textFieldSetRows = new JTextField[TestClass.getRows()][NngPuzzleReader.getMax()];
		textFieldSetColumns = new JTextField[TestClass.getCols()][NngPuzzleReader.getMax()];// or vice versa
		
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        northInfoPanel = new infoComponents();
		northTextFieldPanel = new JPanel();
		westTextFieldPanel = new JPanel();
		centerButtonPanel = new JPanel();
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;
		gbLayout.setConstraints(northInfoPanel, constraints);
		add(northInfoPanel);

		// adding a grid of text fields to sub panel(NORTH)
		northTextFieldPanel.setLayout(new GridLayout(NngPuzzleReader.getMax(),TestClass.getCols()));
		for (int i = 0; i < NngPuzzleReader.getMax(); i++) {
			for (int k = 0; k < TestClass.getCols(); k++){
				northTextFieldPanel.add(addTextField(textFieldSetColumns, k, i));
			}
		}
		if (TestClass.getHeaderColumns() != null) {
				for (int i = 0; i < textFieldSetColumns.length; i++) {
					for (int k = 0; k < TestClass.getHeaderColumns().get(i).size(); k++) {
						//may be problems with getMax cos its common for both rows and cols
						
						int textFieldIndex = NngPuzzleReader.getMax()-k-1;
						int puzzleColumnIndex = TestClass.getHeaderColumns().get(i).size()-k-1;
						
						textFieldSetColumns[i][textFieldIndex]
								.setText(""+TestClass.getHeaderColumns().get(i).get(puzzleColumnIndex));
					}
				}
		}
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 2;   //2 columns wide
		gbLayout.setConstraints(northTextFieldPanel, constraints);
		add(northTextFieldPanel);
		
		// adding a grid of text fields to sub panel(WEST)
		westTextFieldPanel.setLayout(new GridLayout(TestClass.getRows(), NngPuzzleReader.getMax()));
		for (int i = 0; i < TestClass.getRows(); i++) {
			for (int k = 0; k < NngPuzzleReader.getMax(); k++){
				westTextFieldPanel.add(addTextField(textFieldSetRows, i, k));
			}
		}
		if (TestClass.getHeaderRows() != null) {
			for (int i = 0; i < textFieldSetRows.length; i++) {
				for (int k = 0; k < TestClass.getHeaderRows().get(i).size(); k++) {
					//may be problems with getMax cos its common for both rows and cols
					
					int textFieldIndex = NngPuzzleReader.getMax()-k-1;
					int puzzleRowIndex = TestClass.getHeaderRows().get(i).size()-k-1;
					
					textFieldSetRows[i][textFieldIndex]
							.setText(""+TestClass.getHeaderRows().get(i).get(puzzleRowIndex));
				}
			}
		}
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.gridx = 0;
		constraints.gridy = 1;
		gbLayout.setConstraints(westTextFieldPanel, constraints);
		add(westTextFieldPanel);
		
		// adding a grid of buttons to subpanel (CENTER)
		centerButtonPanel.setLayout(new GridLayout(TestClass.getRows(),TestClass.getCols()));
		for (int i = 0; i < TestClass.getRows(); i++) {
			for (int k = 0; k < TestClass.getCols(); k++) {
				addButton(i, k);
			}
		}
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 2;   //2 columns wide
		gbLayout.setConstraints(centerButtonPanel, constraints);
		add(centerButtonPanel);
	}
	
	public JButton[][] getButtonSet() {
		return buttonSet;
	}

	private void addButton(int i, int k)
	{
		JButton button = new JButton();
		button.setBackground(Color.WHITE);
		button.setPreferredSize(new Dimension(20,20));
		//button.setFont(new Font("Arial", Font.PLAIN, 10));
		button.addActionListener(this);
		buttonSet[i][k] = button;
		centerButtonPanel.add(button);
	}
	
	private JTextField addTextField(JTextField[][] txtFieldSet, int i, int k)
	{
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(20,20));
		textField.setBackground(Color.LIGHT_GRAY);
		textField.addActionListener(this);
	//	textField.setText(""+i+";"+k);
		txtFieldSet[i][k] = textField;
		return textField;
	}
	
	public void actionPerformed (ActionEvent e) {
		Object source = e.getSource();
        if (source instanceof JButton) {
        	Color background = ((JButton)source).getBackground();
        	String empty = ((JButton)source).getText();
        	       	
        	if ( background.equals(Color.WHITE) && empty == "") {
        		((JButton)source).setBackground(Color.BLACK);
        	} else if ( background.equals(Color.BLACK) ) {
            		((JButton)source).setText(".");
            		((JButton)source).setBackground(Color.WHITE);
        	} else if ( empty != "" ) {
        		((JButton)source).setText("");
        	}
        }
	}
}

class infoComponents extends JPanel {
	public void paintComponent(Graphics g)
	   {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		Dimension endPoint = this.getSize();
		g.setColor(Color.BLACK);  
	    g.drawLine(0,0, (int)endPoint.getHeight(), (int)endPoint.getWidth());  
	    
	    g.setFont(new Font("Serif", Font.BOLD, 16));
	    g.drawString(""+TestClass.getRows(), (int)endPoint.getHeight()/10*2, (int)endPoint.getWidth()/10*8);
	    g.drawString(""+TestClass.getCols(), (int)endPoint.getHeight()/10*7, (int)endPoint.getWidth()/10*3);
	   }
}
