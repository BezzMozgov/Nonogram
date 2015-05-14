package View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import exceptions.SizeInputException;
import Logic.TestClass;

public class NngChangeSizeDialog extends JDialog implements ActionListener {
	NngFrame parent;
	JPanel panel;
	JButton button;
	JTextField textFieldRows;
	JTextField textFieldCols;

	public NngChangeSizeDialog(NngFrame parent) 
	{
		this.parent = parent;
        JLabel label = new JLabel(" X "); 
        TitledBorder title = BorderFactory.createTitledBorder("Input number of ROWS X COLUMNS");
        
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(title);

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
        	if (e.getSource() == button) {
        		try {
	        		TestClass.setRows(Integer.parseInt(textFieldRows.getText()));
	        		TestClass.setCols(Integer.parseInt(textFieldCols.getText()));
	        		parent.flush();
	        		dispose();
        		} catch (NumberFormatException err) {
        			JOptionPane.showMessageDialog(this, "Numbers should be integer\n" + err.getMessage());
        		} 
    		}
        }
}
