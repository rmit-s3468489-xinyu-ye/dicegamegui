package view;

import javax.swing.SwingUtilities;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
/**
*
* @author Xinyu YE s3468489
*/
public class GameEngineCallbackGUI implements GameEngineCallback
{
    MainFrame mf;

//    public String currentPlayer;
//    public boolean GUIrolling = false; 
    
    public GameEngineCallbackGUI(MainFrame mf)
    {
        this.mf = mf;
    }

    @Override
    public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) 
    {   //If it is the console rolling
    		if(!mf.GUIrolling)
    		{//assign the currently passed in player's name to currentPlayer
    			mf.currentPlayer = player.getPlayerName();
    		}
    		
	    	SwingUtilities.invokeLater(new Runnable()
	    	{
	    		public void run()
	    		{
	    			//Only one player will roll at a time
	    			//the player who is rolling is the current player	
	    			if(player.getPlayerName().equals(mf.currentPlayer))
	    			{//Display the change of the dicePair 
		    			mf.doRefDices(dicePair);
		    		//Display the name of the current player
		    			mf.doRefName(player.getPlayerName(),dicePair);
	    			}
	    		}
	    	});  
    }

    @Override
    public void result(Player player, DicePair result, GameEngine gameEngine) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                mf.doRefTable();
            }
        });
    }

    @Override
    public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) 
    {
       SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                mf.doRefDices(dicePair);
                mf.doRefName("House",dicePair);
            }
        });
    }

    @Override
    public void houseResult(DicePair result, GameEngine gameEngine) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                mf.doRefTable();
                mf.doRefTextArea(result,gameEngine);
            }
        });
    }
}
