/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;

/**
 *
 * @author xinyuye
 */
public class GameEngineCallbackController
{
    private GameEngine ge;
    
    public GameEngineCallbackController(GameEngine ge,GameEngineCallbackGUI gecg)
    {
        this.ge = ge;
    }

    public void houseResult(DicePair result)
    {
        result = null;
        GameEngineCallbackImpl gecb = new GameEngineCallbackImpl();
        //gecb.houseResult(result, GameEngineCallbackGUI.gameEngineCallBackGUI.ge);
    }
    
}
