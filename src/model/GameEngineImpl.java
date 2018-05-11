package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
import model.SimplePlayer;
import model.interfaces.DicePair;
import view.GameEngineCallbackGUI;

/**
 *
 * @author Xinyu YE s3468489
 *
 */
public class GameEngineImpl implements GameEngine
{
    private List<Player> players;
    
    private List<GameEngineCallback> gameEngineCallbacks;
    
    private final int MIN_DIE_NUM = 1;
    
    public GameEngineImpl()
    {
        players = new ArrayList<Player>();
        gameEngineCallbacks=new ArrayList();
    }
    
    //Generates a random interger from 1 to 6 for
    //both dices in a DicePair Object named rollResult
    public int roll(int NUM_FACES)
    {  
        Random rand = new Random();
        //DicePairImpl rollResult = new DicePairImpl();
//        int dice1 = (int) rand.nextInt(rollResult.getNumFaces()) + MIN_DIE_NUM;
//        int dice2 = (int) rand.nextInt(rollResult.getNumFaces()) + MIN_DIE_NUM;
//        rollResult.setDice1(dice1);
//        rollResult.setDice2(dice2);
//        
        return (int) rand.nextInt(NUM_FACES) + MIN_DIE_NUM;
    }
    
    @Override
    public boolean placeBet(Player player, int bet)
    {
        //Invoking the current player's placeBet(int bet) method
        return player.placeBet(bet);
    }
    
    @Override
    public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement)
    {
        
        int initDel = initialDelay;
        
        if(!players.contains(player))
            return;
        
        if(player.getBet() > 0)
        {
            DicePairImpl dp=null;
            
            for (int i = initialDelay; i < finalDelay; i += delayIncrement)
            {
                dp = new DicePairImpl(roll(NUM_FACES),roll(NUM_FACES),NUM_FACES);
                
                
                
                //Invoking the intermediateResult method in GameEngineCallBackImpl
                //for the current player, for displaying the player's temporary
                //rolling result
                for(GameEngineCallback gecb: gameEngineCallbacks)
                {
                    gecb.intermediateResult(player, dp, this);
                }
                
                //To display the change of the dice's value
                try
                {
                    Thread.sleep(initialDelay);
                }
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }      
        }
           player.setRollResult(dp);
          /**
             * Invoking the result method in GameEngineCallBackImpl
             * for the player, for displaying the player's final
             * rolling result
             */
          
          for(GameEngineCallback gecb: gameEngineCallbacks)
          {
              gecb.result(player, player.getRollResult(), this);
          }
        }
    }
    
    @Override
    public void rollHouse(int initialDelay, int finalDelay, int delayIncrement)
    {
        DicePairImpl dp = null;
        
        for (int i = initialDelay; i < finalDelay; i += delayIncrement)
        {
            dp = new DicePairImpl(roll(NUM_FACES),roll(NUM_FACES),NUM_FACES);
            
            //Invoking the intermediateResult method in GameEngineCallBackImpl
            //for the House, for displaying the House's temporary
            //rolling result
            for(GameEngineCallback gecb: gameEngineCallbacks)
            {
                gecb.intermediateHouseResult(dp, this);
            }

            //To display the change of the dice's value
            try
            {
                Thread.sleep(initialDelay);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(GameEngineImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Comparing whether the House or the player wins
        for (Player player : players)
        {
            /**
             * If the sum of player's number on both dice's resting faces is larger
             * than the House's, then the player will get the points equal
             * to twice its bet, i.e., getting back the bet that it has placed earlier.
             * plus the points equal to its bet(as the bonus)
             */
            if ((player.getRollResult().getDice1() + player.getRollResult().getDice2())
                    > (dp.getDice1() + dp.getDice2()))
            {
                player.setPoints(player.getPoints() + player.getBet() * 2);
            }
            /**
             * If the sum of player's number on both dice's resting faces is smaller
             * than the House's, then the player will lose its bet,
             * i.e., it will not be able to get back the bet it placed earlier
             */
            else if ((player.getRollResult().getDice1() + player.getRollResult().getDice2())
                    < (dp.getDice1() + dp.getDice2()))
            {
                player.setPoints(player.getPoints());
            }
            else//If a draw occurs, the bet will be returned to the drawing player
            {
                player.setPoints(player.getPoints() + player.getBet());
            }
            //After the house rolled the dice, players' result for the
            //current round should be reset to null and
            //their bets placed should be reset to zero
            ((SimplePlayer)player).resetBet();
            ((SimplePlayer)player).resetRollResult();
        }
        
        /**
         * Invoking the houseResult method in GameEngineCallBackImpl
         * for the House, for displaying the House's final
         * rolling result
         */
        
        for(GameEngineCallback gecb: gameEngineCallbacks)
        {
            gecb.houseResult(dp, this);
        }
        
    }
  
    //Add a player into the Player List
    @Override
    public void addPlayer(Player newPlayer)
    {
        players.add(newPlayer);
    }
    
    @Override
    public Player getPlayer(String id)
    {
        
        for (Player player : players)
        {
            if(player.getPlayerId().equals(id))
                return player;
        }
        return null;
    }
    
    @Override
    public boolean removePlayer(Player player)
    {
        return players.remove(player);
    }
    
    @Override
    public void addGameEngineCallback(GameEngineCallback gameEngineCallback)
    {
        this.gameEngineCallbacks.add(gameEngineCallback);
    }
    
    @Override
    public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback)
    {
        return this.gameEngineCallbacks.remove(gameEngineCallback);
    }
    
    //Get all players
    @Override
    public Collection<Player> getAllPlayers()
    {
        
        return Collections.unmodifiableList(this.players);
    }

    public List<Player> getPlayers() 
    {
        return players;
    }
    public List<GameEngineCallback> getGameEngineCallback() 
    {
        return gameEngineCallbacks;
    }
    
}