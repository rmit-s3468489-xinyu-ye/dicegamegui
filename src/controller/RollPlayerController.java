package controller;

import javax.swing.JOptionPane;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;
import view.MainFrame;

/**
*
* @author Xinyu YE s3468489
*/
public class RollPlayerController 
{
	String name = "";
	
	public RollPlayerController(GameEngine ge, MainFrame mf)
	{
		mf.jBRollPlayer.addActionListener(new java.awt.event.ActionListener() 
		{
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
	            	String message = "";   	
	
	            	if(mf.table.getSelectedRow() < 0)
	            	{
	            		message = "Please select a player to roll !";
	            		JOptionPane.showMessageDialog(null, message ,"Message", JOptionPane.ERROR_MESSAGE);
	            		return;
	            	}
	            	
	            	//Validate the player is rolling through the MainFrame
	            mf.GUIrolling = true;
	            	
	            mf.currentPlayer = mf.table.getValueAt(mf.table.getSelectedRow(), 1).toString();

	            String id = (mf.table.getValueAt(mf.table.getSelectedRow(), 0).toString());
	
	            	Player player = ge.getPlayer(id);
	            	
	            	if(player.getBet() == 0)
	            	{
	            		System.out.println("Please place your bet first !");
	            		return;
	            	}
	            
	            	new Thread()
	            	{
	            		public void run()
	            		{
	            			ge.rollPlayer(player, 300, 400, 1);
	            		}
	            	}.start();
            }
        });
	}
}
