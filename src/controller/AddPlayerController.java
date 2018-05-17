/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AddPlayer;
import view.GameEngineCallbackGUI;

/**
 *
 * @author Xinyu YE s3468489
 */
public class AddPlayerController 
{
	AddPlayer ap = new AddPlayer();
	
	public AddPlayerController(GameEngine ge, AddPlayer ap) 
	{
		ap.jBAdd.addActionListener(new java.awt.event.ActionListener()
		{
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
	            	String message = "";
	
	            addPlayer(ap.jTFName.getText(), Integer.parseInt(ap.jTFIP.getText()), ge);
	
	            	message = "Successfully added this player !";
	
	            	JOptionPane.showMessageDialog(null, message ,"Message", JOptionPane.ERROR_MESSAGE); 
            }

        });
	}

	public void addPlayer(String name,int points,GameEngine ge)
    {
        int id = ge.getAllPlayers().size() + 1;
        
        Player p = new SimplePlayer(String.valueOf(id),name,points);
        
        ge.addPlayer(p);
    }
}
