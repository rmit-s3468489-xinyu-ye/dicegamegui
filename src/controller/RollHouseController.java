package controller;

import java.util.List;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;
import view.MainFrame;

/**
*
* @author Xinyu YE s3468489
*/
public class RollHouseController 
{
	public RollHouseController(GameEngine ge, MainFrame mf) 
	{
		mf.jBRollHouse.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
				 List<Player> players = (List) ge.getAllPlayers();
			        
				 for(Player p:players)
				 {   
					 if(p.getRollResult() == null)
					 {     
						 System.out.println("Please roll all of the players first !");
						 return;
					 }
				 }
			        
				 new Thread()
				 {
					 public void run()
					 {
						 ge.rollHouse(1, 20, 1);

						 List<Player> players = ((GameEngineImpl)ge).getPlayers();

						 for(Player p:players)
						 {
							 ((SimplePlayer)p).resetBet();
							 ((SimplePlayer)p).resetRollResult();
						 }
					 }

				 }.start();
			        
//                 gecg.doRefTable();
            }
        });
	}
}
