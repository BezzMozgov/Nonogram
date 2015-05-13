package View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import exceptions.SizeInputException;
import Logic.TestClass;

public class NngChangeSizeDialog extends JDialog implements ActionListener {
	JPanel panel;
	JButton button;
	JTextField textFieldRows;
	JTextField textFieldCols;

	public NngChangeSizeDialog(JFrame parent) 
	{
        JLabel label = new JLabel(" X "); 
        TitledBorder title = BorderFactory.createTitledBorder("Input number of ROWS X COLUMNS");
        
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(title);
        // panel.setBorder(BorderFactory.createLineBorder(Color.black));
        //panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));

        button = new JButton("OK");
        button.addActionListener(this);
        
        textFieldRows = new JTextField("ROWS", 4);
        textFieldCols = new JTextField("COLS", 4);
        
        panel.add(textFieldRows);
        panel.add(label);
        panel.add(textFieldCols);
        panel.add(button);
        
        setTitle("Change Field Size");
        add(panel);
        setSize(250, 120);
        setLocationRelativeTo(parent);
       setModal(true);
        setVisible(true);
       setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
        public void actionPerformed(ActionEvent e) {
             //code needed
        	if (e.getSource() == button) {
        		try {
	        		TestClass.setRows(Integer.parseInt(textFieldRows.getText()));
	        		TestClass.setCols(Integer.parseInt(textFieldCols.getText()));
	        		dispose();
        		} catch (NumberFormatException err) {
        			JOptionPane.showMessageDialog(this, "Numbers of ROWS and COLUMNS should be integer");
        		} 
    		}
        }
}
