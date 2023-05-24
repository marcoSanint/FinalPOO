/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Marco Sanint
 */
public class Key extends Sprite {

    public Key(int x, int y) {
        super(x, y);
    }

    public static List<Key> generateKeys(int[][] dungeon) {
        List<Key> keys = new ArrayList<>();
        Random random = new Random();
        int count = 0;

        while (count < 4) {
            int x = random.nextInt(dungeon.length);
            int y = random.nextInt(dungeon[0].length);

            if (dungeon[x][y] == 0) {
                Key key = new Key(x, y);
                keys.add(key);
                dungeon[x][y] = 2; // Mark the position as occupied by a key
                count++;
            }
        }

        return keys;
    }
    
    

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
