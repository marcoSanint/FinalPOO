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
public class Doc extends Monster {
    
    public Doc(int x, int y, Yellow yellow) {
        super(x, y, yellow);
    }  


    @Override
    public void move() {
        //int[][] dungeon = getDun().getDungeon();

        // Calcular la dirección hacia la posición actual de Yellow
        int directionX = 0;
        int directionY = 0;

        int yellowX = getYellow().getX();
        int yellowY = getYellow().getY();

        if (getX() < yellowX) {
            directionX = 1;
        } else if (getX() > yellowX) {
            directionX = -1;
        } else if (getY() < yellowY) {
            directionY = 1;
        } else if (getY() > yellowY) {
            directionY = -1;
        }

        // Calcular las coordenadas del siguiente movimiento del fantasma
        int nextX = getX() + directionX * getStep();
        int nextY = getY() + directionY * getStep();

        // Verificar si el siguiente movimiento del fantasma es válido (no choca con una pared)
//        if (dungeon[nextY / 40][nextX / 40] != 1) {
//            setX(nextX);
//            setY(nextY);
//        }
        if (getX() == getYellow().getX() && getY() == getYellow().getY()) {
            getYellow().loseLife();
        }
    }

    @Override
    public void draw(Graphics g) {
        ImageIcon imagen=new ImageIcon(getClass().getResource("POO(Doc-U-R).png"));         
        g.setColor(new Color(128,64,0));         
        g.drawImage(imagen.getImage(), getX(), getY(), getSize(), getSize(), null);
    }
}
