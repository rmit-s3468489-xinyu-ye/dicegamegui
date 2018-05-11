package controller;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;

/**
*
* @author Xinyu YE s3468489
*/
public class RollPlayerController 
{
	public RollPlayerController(GameEngine ge,GameEngineCallbackGUI gecg)
	{
		gecg.jBRollPlayer.addActionListener(new java.awt.event.ActionListener() 
		{
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
	            	String message = "";
	
	            	if(gecg.table.getSelectedRow()<0)
	            	{
	            		message = "Please select a player to roll !";
	            		JOptionPane.showMessageDialog(null, message ,"Message", JOptionPane.ERROR_MESSAGE);
	            		return;
	            	}
	
	            	String id = (gecg.table.getValueAt(gecg.table.getSelectedRow(), 0).toString());
	
	            	Player player=ge.getPlayer(id);
	            	if(player.getBet()==0)
	            	{
	            		System.out.println("Please place your bet first !");
	            		return;
	            	}
	            	new Thread()
	            	{
	            		public void run()
	            		{
	
	            			ge.rollPlayer(player, 1, 100, 2);
	
	            		}
	            	}.start();
            }
        });
	}
}
