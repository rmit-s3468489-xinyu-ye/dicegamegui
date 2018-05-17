package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

/**
 *
 * @author Xinyu YE s3468489
 *
 */
public class SimplePlayer implements Player,Cloneable
{
    private String playerName, playerId;
    
    private int points, bet;
    
    private DicePair rollResult;
    
    public SimplePlayer(String playerId, String playerName, int initialPoints)
    {
        this.playerId = playerId;
        this.playerName = playerName;
        this.points = initialPoints;
    }
    
    @Override
    public String getPlayerName()
    {
        return playerName;
    }
    
    @Override
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }
    
    @Override
    public int getPoints()
    {
        return points;
    }
    
    @Override
    public void setPoints(int points)
    {
        this.points = points;
    }
    
    @Override
    public String getPlayerId()
    {
        return playerId;
    }
    
    /**
     * Check whether the player has
     * enough points for placing a bet, and
     * whether the player placed a valid bet
     * i.e., more than zero point
     * If the player has enough points,
     * i.e., the bet that the player placed
     * is greater or equal than zero and
     * smaller than or equal to the points it has,
     * then assign the parameter that
     * passed into this method to
     * the current player's bet field.
     *
     * 
     * After the above assignment operation,
     * minus the bet from the current player's
     * points field, and return true
     *
     * Else, return false
     */
    @Override
    public boolean placeBet(int bet) 
    {
        /**
         * In this assignment, due to the constraint to
         * clear the bet that a particular player has placed
         * after the House rolled the dices, the bet is allowed    
         * to be placed as zero. Plus, according to the real world's   
         * casino practice, I assume that some players might not 
         * want to place a bet but just want to experience how the game
         * works
         */
    		if (bet > 0 && points >= bet)
    		{
    			this.bet = bet;
    			points -= bet;
    			return true;
    		}

    		return false;    
    }
    
    @Override
    public int getBet()
    {
        return bet;
    }
    
    public void resetBet()
    {
        this.bet = 0;
    }
    
    @Override
    public DicePair getRollResult()
    {
        return rollResult;
    }
    
    @Override
    public void setRollResult(DicePair rollResult)
    {
        this.rollResult = rollResult;
    }
    
    public void resetRollResult()
    {
        this.rollResult = null;
    }
    
    /**
     * Customizing the printed out information
     * of the current player object
     */
    @Override
    public String toString()
    {
        String playerInfo = "";
        
        playerInfo = "Player: id = " + this.playerId +
                ", name = " + this.playerName  + ", points = " + this.points;
        
        return playerInfo;
    }
    
    @Override  
    public Object clone() 
    {  
        Player p = null;  
        try
        {  
            p = (Player)super.clone();  
        }
        catch(CloneNotSupportedException e) 
        {  
            e.printStackTrace();  
        }  
        return p;  
    }  
    
}
