package controller;

import view.MainFrame;

public class WindowController 
{
	public WindowController(MainFrame mf) 
	{
        mf.addWindowListener(new java.awt.event.WindowAdapter() 
        {
            public void windowActivated(java.awt.event.WindowEvent evt) 
            {
                mf.doRefTable();
            }
        });
	}
}
