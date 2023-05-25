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
public class Eye extends Monster {
    private Image eyeImage;

    public Eye(int x, int y, int width, int height, Yellow yellow) {
        super(x, y, width, height);
    }

    // Métodos Getter y Setter para las variables miembro

    public Image getEyeImage() {
        return eyeImage;
    }

    public void setEyeImage(Image eyeImage) {
        this.eyeImage = eyeImage;
    }
    
        @Override
    public void move() {
        //int[][] dungeon = getDun().getDungeon();
        Yellow yellow = getYellow();

        int directionX = 0;
        int directionY = 0;

        int yellowX = yellow.getX();
        int yellowY = yellow.getY();

        // Comprobar si está en la misma columna
        if (getX() == yellowX) {
            directionY = (getY() < yellowY) ? 1 : -1;
        }
        // Comprobar si está en la misma fila
        else if (getY() == yellowY) {
            directionX = (getX() < yellowX) ? 1 : -1;
        }

        int nextX = getX() + directionX * 40;
        int nextY = getY() + directionY * 40;

//        if (dungeon[nextY / 40][nextX / 40] != 1) {
//            setX(nextX);
//            setY(nextY);
//        }

        if (getX() == yellowX && getY() == yellowY) {
            yellow.loseLife();
        }
    }
    
        @Override
    public void draw(Graphics g) {
        ImageIcon imagen=new ImageIcon(getClass().getResource("POO(Eye-down-right).png"));         
        g.setColor(new Color(128,64,0));         
        g.drawImage(imagen.getImage(), getX(), getY(), 40, 40, null);
    }
}