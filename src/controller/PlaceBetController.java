package controller;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import view.GameEngineCallbackGUI;

/**
*
* @author Xinyu YE s3468489
*/
public class PlaceBetController 
{
	public PlaceBetController(GameEngine ge,GameEngineCallbackGUI gecg) 
	{
		 gecg.jBBet.addActionListener(new java.awt.event.ActionListener() 
		 {
	            public void actionPerformed(java.awt.event.ActionEvent evt) 
	            {
	            	 String message = "";
	                 
	                 if(gecg.table.getSelectedRow()<0)
	                 {
	                     message = "Please select a player to place bet !";
	                     JOptionPane.showMessageDialog(null, message ,"Message", JOptionPane.ERROR_MESSAGE);
	                     return;
	                 }
	                 
	                 String id = (gecg.table.getValueAt(gecg.table.getSelectedRow(), 0).toString());
	                 
	                 int bet = Integer.parseInt(gecg.jTFBet.getText());
	                 
	                 ge.getPlayer(id).placeBet(bet);
	                 
	                 gecg.doRefTable();
	            }
	        });
	}
}
