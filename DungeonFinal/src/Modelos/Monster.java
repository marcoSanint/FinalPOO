/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;


/**
 *
 * @author Marco Sanint
 */
public abstract class Monster extends Sprite{
    private Yellow yellow;

    public Monster(int x, int y, Yellow yellow) {
        super(x, y);
        this.yellow = yellow;
    }

    public abstract void move();

    /**
     * @return the yellow
     */
    public Yellow getYellow() {
        return yellow;
    }

    /**
     * @param yellow the yellow to set
     */
    public void setYellow(Yellow yellow) {
        this.yellow = yellow;
    }

}