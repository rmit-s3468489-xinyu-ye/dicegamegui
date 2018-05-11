package client;

import view.GameEngineCallbackImpl;
import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;

public class MyTestClient
{
    
	public static void main(String args[])
	{
		// instantiate the GameEngine so we can make calls
		final GameEngine gameEngine = new GameEngineImpl();

		// create two test players (NOTE: you will need to implement the 3 arg contructor in SimplePlayer)
		Player[] players = new Player[]
				{ new SimplePlayer("1", "The Roller1", 10000), new SimplePlayer("2", "The Roller2", 10000),
					new SimplePlayer("3", "The Roller3", 10000), new SimplePlayer("4", "The Roller4", 10000)
				};

		// register the callback for notifications (all logging output is done by GameEngineCallbackImpl)
		// see provided skeleton class GameEngineCallbackImpl.java
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(gameEngine));
		// main loop to add players place a bet and roll
		for (Player player : players)
		{
			gameEngine.placeBet(player, 500);
			gameEngine.addPlayer(player);
			gameEngine.rollPlayer(player, 100, 1000, 20);
		}

		// all players have rolled so now house rolls (GameEngineCallBack is
		// called) and results are calculated
		gameEngine.rollHouse(1, 100, 20);

	}
}

