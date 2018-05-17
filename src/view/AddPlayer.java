package view;

import controller.AddPlayerClearController;
import controller.AddPlayerController;
import javax.swing.JOptionPane;
import model.interfaces.GameEngine;

/**
*
* @author Xinyu YE s3468489
*/
public class AddPlayer extends javax.swing.JFrame 
{
    GameEngine ge;
    GameEngineCallbackGUI gegc;
    AddPlayerController apc;
    AddPlayerClearController apcc;
    
    /**
     * Creates new form AddPlayer
     */
    public AddPlayer() 
    {
        initComponents();
    }
    
    public AddPlayer(GameEngine ge)
    {
        initComponents();
        this.ge=ge;
        apc = new AddPlayerController(ge, this);
        apcc = new AddPlayerClearController(this);
    }


    private void initComponents() 
    {

        jLName = new javax.swing.JLabel();
        jLIP = new javax.swing.JLabel();
        jTFName = new javax.swing.JTextField();
        jTFIP = new javax.swing.JTextField();
        jBAdd = new javax.swing.JButton();
        jBClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLName.setText("Name: ");

        jLIP.setText("Initial Points: ");

        jBAdd.setText("Add");

        jBClear.setText("Clear");
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLIP, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addComponent(jLName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jBAdd))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 185, Short.MAX_VALUE)
                        .addComponent(jBClear))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTFName, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                        .addComponent(jTFIP)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLIP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFIP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAdd)
                    .addComponent(jBClear))
                .addContainerGap())
        );

        pack();
    }

    // Variables declaration 
    public javax.swing.JButton jBAdd;
    public javax.swing.JButton jBClear;
    private javax.swing.JLabel jLIP;
    private javax.swing.JLabel jLName;
    public javax.swing.JTextField jTFIP;
    public javax.swing.JTextField jTFName;
}
