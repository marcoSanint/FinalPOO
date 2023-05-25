/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Marco Sanint
 */
public class Yellow extends Sprite{
    private int lives = 3;
    private int numKeys = 0;
    
    public Yellow(int x, int y) {
        super(x, y);
    }
    
    public void drawLives(Graphics g) {
        
    }
    
    public void loseLife() {
        setLives(getLives() - 1);
    }
    
    public void drink(){
        lives += 1;
        if (lives > 3){
            lives = 3;
        }
    }
    
    public void gotKey(){
        setNumKeys(getNumKeys() + 1);
    }
    public int getLives() {
        return lives;
    }

    /**
     * @param lives the lives to set
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * @return the numKeys
     */
    public int getNumKeys() {
        return numKeys;
    }

    /**
     * @param numKeys the numKeys to set
     */
    public void setNumKeys(int numKeys) {
        this.numKeys = numKeys;
    }

    @Override
    public void draw(Graphics g) {
        ImageIcon imagen=new ImageIcon(getClass().getResource("POO(Main-up-right).png"));         
        g.setColor(new Color(128,64,0));         
        g.drawImage(imagen.getImage(), getX(), getY(), getSize(), getSize(), null);
    }
}