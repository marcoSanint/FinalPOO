/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.awt.Graphics;

/**
 *
 * @author Marco Sanint
 */
public abstract class Sprite {
    protected int x;
    protected int y;
    protected int Size;
    protected int step = 40;
    
    protected Dimensionable area;
    protected Drawable drawable;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
        public boolean checkCollision(Sprite sprite)
    {
        if(this.getX() < sprite.getX() + sprite.getSize() &&
           this.getX() + this.getSize() > sprite.getX() &&
           this.getY() < sprite.getY() + sprite.getSize() &&
           this.getSize() + this.getY() > sprite.getY())
            return true;
        
        return false;
    }

    public abstract void draw(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    /**
     * @return the step
     */
    public int getStep() {
        return step;
    }
    
    public void setArea(Dimensionable area) {
        this.area = area;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
    
    /**
     * @param step the step to set
     */
    public void setStep(int step) {
        this.step = step;
    }

    /**
     * @return the area
     */
    public Dimensionable getArea() {
        return area;
    }

    /**
     * @return the drawable
     */
    public Drawable getDrawable() {
        return drawable;
    }

    /**
     * @return the Size
     */
    public int getSize() {
        return Size;
    }

    /**
     * @param Size the Size to set
     */
    public void setSize(int Size) {
        this.Size = Size;
    }
}