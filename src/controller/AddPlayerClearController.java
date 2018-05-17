package controller;

import view.AddPlayer;

public class AddPlayerClearController 
{
	AddPlayer ap = new AddPlayer();
	
	public AddPlayerClearController(AddPlayer ap) 
	{
		ap.jBClear.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
	            	ap.jTFName.setText("");
	            	ap.jTFIP.setText("");
            }
        });
	}
}
