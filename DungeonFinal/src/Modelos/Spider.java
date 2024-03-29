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
public class Spider extends Monster {
    private Image roamerImage;
    private int roamDirection; // Dirección de movimiento del Roamer (0: derecha, 1: abajo, 2: izquierda, 3: arriba)
    private int initialX;
    private int initialY;

    public Spider(int x, int y, int width, int height, Yellow yellow) {
        super(x, y, width, height);
        roamDirection = 0; // Comenzar moviéndose hacia la derecha
        initialX = x;
        initialY = y;
    }

    // Métodos Getter y Setter para las variables miembro

    public Image getRoamerImage() {
        return roamerImage;
    }

    public void setRoamerImage(Image roamerImage) {
        this.roamerImage = roamerImage;
    }

    public int getInitialX() {
        return initialX;
    }

    public void setInitialX(int initialX) {
        this.initialX = initialX;
    }

    public int getInitialY() {
        return initialY;
    }

    public void setInitialY(int initialY) {
        this.initialY = initialY;
    }
    
    @Override
    public void move() {
        //int[][] dungeon = getDun().getDungeon();

        int directionX = 0;
        int directionY = 0;

        // Calcular la siguiente dirección de movimiento basada en la dirección actual del Roamer
        switch (roamDirection) {
            case 0: // Derecha
                directionX = 1;
                break;
            case 1: // Abajo
                directionY = 1;
                break;
            case 2: // Izquierda
                directionX = -1;
                break;
            case 3: // Arriba
                directionY = -1;
                break;
        }

        int nextX = getX() + directionX * 40;
        int nextY = getY() + directionY * 40;

        // Verificar si el siguiente movimiento del monstruo es válido
//        if (dungeon[nextY / 40][nextX / 40] != 1) {
//            setX(nextX);
//            setY(nextY);
//        } else {
//            // Si el siguiente movimiento no es válido, cambiar la dirección de movimiento en sentido horario
//            roamDirection = (roamDirection + 1) % 4;
//        }

        // Si el Roamer ha rodeado todo el mapa y ha vuelto a su posición inicial, el jugador pierde una vida
        if (getX() == initialX && getY() == initialY) {
            getYellow().loseLife();
        }
    }
       
    @Override
    public void draw(Graphics g) {
        ImageIcon imagen=new ImageIcon(getClass().getResource("POO(Spider-up-right).png"));         
        g.setColor(new Color(128,64,0));         
        g.drawImage(imagen.getImage(), getX(), getY(), 40, 40, null);
    }

}