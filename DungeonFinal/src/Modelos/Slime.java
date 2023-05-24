/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Marco Sanint
 */
public class Slime extends Monster {
    private Dungeon dun = new Dungeon();
    private Image slimeImage;
    
    public Slime(int x, int y, Yellow yellow) {
        super(x, y, yellow);
        slimeImage = new ImageIcon(getClass().getResource("POO(Slime-up-right).png")).getImage();
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
     * @return the slimeImage
     */
    public Image getSlimeImage() {
        return slimeImage;
    }

    /**
     * @param slimeImage the slimeImage to set
     */
    public void setSlimeImage(Image slimeImage) {
        this.slimeImage = slimeImage;
    }

    @Override
    public void move() {
        int[][] dungeon = getYellow().getDun().getDungeon();

        // Generar un movimiento aleatorio para el fantasma verde
        int randomDirection = (int) (Math.random() * 4); // Generar un número aleatorio entre 0 y 3

        int nextX = getX();
        int nextY = getY();

        // Mover el fantasma en la dirección aleatoria
        if (randomDirection == 0) { // Izquierda
            nextX -= getStep();
        } else if (randomDirection == 1) { // Derecha
            nextX += getStep();
        } else if (randomDirection == 2) { // Arriba
            nextY -= getStep();
        } else if (randomDirection == 3) { // Abajo
            nextY += getStep();
        }

        // Verificar si el siguiente movimiento del fantasma es válido (no choca con una pared)
        if (dungeon[nextY / 40][nextX / 40] != 1) {
            setX(nextX);
            setY(nextY);
        }
        if (getX() == getYellow().getX() && getY() == getYellow().getY()) {
            getYellow().loseLife();
        }
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(getSlimeImage(), getX(), getY(), getSize(), getSize(), null);
    }
}

