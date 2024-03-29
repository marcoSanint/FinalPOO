/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Marco Sanint
 */
public class Yellow extends Sprite{
    private Dungeon dun = new Dungeon();
    private int lives = 3;
    private int numKeys = 0;
    private Image yellowImage= new ImageIcon(getClass().getResource("POO(Main-up-right).png")).getImage();

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

    /**
     * @return the dun
     */
    public Dungeon getDun() {
        return dun;
    }

    /**
     * @param dun the dun to set
     */
    public void setDun(Dungeon dun) {
        this.dun = dun;
    }

    /**
     * @return the lives
     */
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

    /**
     * @return the yellowImage
     */
    public Image getYellowImage() {
        return yellowImage;
    }

    /**
     * @param yellowImage the yellowImage to set
     */
    public void setYellowImage(Image yellowImage) {
        this.yellowImage = yellowImage;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(yellowImage, getX(), getY(), getSize(), getSize(), null);
    }
}