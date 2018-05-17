package controller;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import view.GameEngineCallbackGUI;
import view.MainFrame;

/**
*
* @author Xinyu YE s3468489
*/
public class PlaceBetController 
{
	public PlaceBetController(GameEngine ge, MainFrame mf) 
	{
		 mf.jBBet.addActionListener(new java.awt.event.ActionListener() 
		 {
	            public void actionPerformed(java.awt.event.ActionEvent evt) 
	            {
	            	 String message = "";
	                 
	                 if(mf.table.getSelectedRow()<0)
	                 {
	                     message = "Please select a player to place bet !";
	                     JOptionPane.showMessageDialog(null, message ,"Message", JOptionPane.ERROR_MESSAGE);
	                     return;
	                 }
	                 
	                 String id = (mf.table.getValueAt(mf.table.getSelectedRow(), 0).toString());
	                 
	                 if(isInteger(mf.jTFBet.getText()))
	                 {
	                	 	int bet = Integer.parseInt(mf.jTFBet.getText());
	                	 	ge.getPlayer(id).placeBet(bet);
	                 }
	                 else 
	                 {
                	 	 	message = "Please enter an interger !";
	                	 	
	                	 	JOptionPane.showMessageDialog(null, message ,"Message", JOptionPane.ERROR_MESSAGE);
	                 }
	                 mf.doRefTable();
	            }
	        });
	}
	
    //Validate the name field that has been input
	public static boolean isInteger(String str)
	{
		Pattern pattern = Pattern.compile("^-?[0-9]+");

		if(pattern.matcher(str).matches())
		{  
			return true;
		} 
		else 
		{
			return false;
		}  
	}
}
