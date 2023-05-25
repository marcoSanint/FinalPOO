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
    protected int width;
    protected int height;
    
    protected Dimensionable area;
    protected Drawable drawable;
    
    public Sprite(int x, int y, int width, int height)
    {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setArea(Dimensionable area) {
        this.area = area;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public boolean checkCollision(Sprite sprite)
    {
        if(this.getX() < sprite.getX() + sprite.getWidth() &&
           this.getX() + this.getWidth() > sprite.getX() &&
           this.getY() < sprite.getY() + sprite.getHeight() &&
           this.getHeight() + this.getY() > sprite.getY())
            return true;
        
        return false;
    }
}
