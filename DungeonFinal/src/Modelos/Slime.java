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
public class Slime extends Monster {
    
    public Slime(int x, int y, Yellow yellow) {
        super(x, y, yellow);
       
    }

//   @Override
//    public void move() {
//        int[][] dungeon = getYellow().getDun().getDungeon();
//
//        // Generar un movimiento aleatorio para el fantasma verde
//        int randomDirection = (int) (Math.random() * 4); // Generar un número aleatorio entre 0 y 3
//
//        int nextX = getX();
//        int nextY = getY();
//
//        // Mover el fantasma en la dirección aleatoria
//        if (randomDirection == 0) { // Izquierda
//            nextX -= getStep();
//        } else if (randomDirection == 1) { // Derecha
//            nextX += getStep();
//        } else if (randomDirection == 2) { // Arriba
//            nextY -= getStep();
//        } else if (randomDirection == 3) { // Abajo
//            nextY += getStep();
//        }
//
//        // Verificar si el siguiente movimiento del fantasma es válido (no choca con una pared)
//        if (dungeon[nextY / 40][nextX / 40] != 1) {
//            setX(nextX);
//            setY(nextY);
//        }
//        if (getX() == getYellow().getX() && getY() == getYellow().getY()) {
//            getYellow().loseLife();
//        }
//    }
//    @Override
//    public void draw(Graphics g) {
//        ImageIcon imagen=new ImageIcon(getClass().getResource("POO(Slime-up-right).png"));         
//        g.setColor(new Color(128,64,0));         
//        g.drawImage(imagen.getImage(), getX(), getY(), getSize(), getSize(), null);
//    }

    @Override
    public void move() {
    }

    @Override
    public void draw(Graphics g) {
    }
}

