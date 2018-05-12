package view;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

/**
 *
 * Skeleton example implementation of GameEngineCallback showing Java logging behaviour
 *
 * @author Caspar Ryan
 * @see model.interfaces.GameEngineCallback
 *
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
    private Logger logger  = Logger.getLogger("assignment1");
    
    public GameEngineCallbackImpl()
    {
        //FINE shows rolling output, INFO only shows result
        logger.setLevel(Level.FINE);
        //Create a ConsoleHandler object
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //Set level of the ConsoleHandler object to FINER
        consoleHandler.setLevel(Level.FINER);
        //Stop the logger object from using the parent handler
        logger.setUseParentHandlers(false);
        //Add the ConsoleHandler object to the logger object to use
        logger.addHandler(consoleHandler);;
    }
    
    @Override
    public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine)
    {
        String playerInfo = "";
        
        playerInfo = player.getPlayerName() + " : ROLLING Dice 1: " + dicePair.getDice1() +
                ",  Dice 2: " + dicePair.getDice2()  + " .. Total: " + (dicePair.getDice1() + dicePair.getDice2());
        
        logger.log(Level.FINE, playerInfo);
    }
    
    @Override
    public void result(Player player, DicePair result, GameEngine gameEngine)
    {
        String playerInfo = "";
        
        playerInfo = player.getPlayerName() + ":" + " *RESULT* Dice 1: " + result.getDice1() +
                "  Dice 2: " + result.getDice2()  + " ..Total: " + (result.getDice1() + result.getDice2());
        
        logger.log(Level.INFO, playerInfo);
    }
    
    @Override
    public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine)
    {
        String houseInfo = "";
        
        houseInfo = "HOUSE" + " : ROLLING Dice 1: " + dicePair.getDice1() +
                " Dice 2: " + dicePair.getDice2()  + " ..Total: " + (dicePair.getDice1() + dicePair.getDice2());
        
        logger.log(Level.FINE, houseInfo);
    }
    
    @Override
    public void houseResult(DicePair result, GameEngine gameEngine)
    {
        String houseInfo = "";
        
        houseInfo = "HOUSE:" + " *RESULT* Dice 1: " + result.getDice1() +
                "  Dice 2: " + result.getDice2()  + " ..Total: " + (result.getDice1() + result.getDice2());
        
        logger.log(Level.INFO, houseInfo);
        
        for(Player p:gameEngine.getAllPlayers())
        {
            logger.log(Level.INFO, p.toString());
        }
        
    }
}
