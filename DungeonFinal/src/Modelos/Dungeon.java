/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Marco Sanint
 */
public final class Dungeon extends Sprite implements Drawable, Dimensionable {
    private int row = 0;
    private int column = 0;
    private int numRows = 15;
    private int numColumns = 25;
    private int Size = 40;
    private int level = 1;
    private int score = 0;
    private Drawable drawable;
    
    private Yellow yellow;
    private List<Monster> monsters;
    private List<Potion> potions;
    private List<Key> keys;
    
    public Dungeon() {
        super(0, 0);
        yellow = new Yellow(2*Size, 2*Size);
        yellow.setArea(this);
        yellow.setDrawable(this);
        monsters = new ArrayList<>();
        //generateRandomKeys(numRows);
    }
    
    public int[][] getDungeon(){
        int dungeon[][] = 
        {   {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,0,1},
            {1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
            {1,0,0,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0,0,1},
            {1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1},
            {1,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
        return dungeon;
    }
    
    public void draw(Graphics g){
        
        int [][]dungeon = getDungeon();
        
        g.setColor(new Color(219, 94, 240, 255));
        g.fillRect(0, 0, getNumColumns()*getSize(), getNumRows()*getSize());
        
        for(row = 0; row < numRows; row++){
            for(column = 0; column < numColumns; column++){
                if (dungeon[row][column] == 1){
//                    g.setColor(Color.BLUE);
//                    g.fillRect(getColumn()*40, getRow()*40, getSize(), getSize());
//                    g.setColor(Color.BLACK);
//                    g.drawRect(getColumn()*40, getRow()*40, getSize(), getSize());
                    ImageIcon imagen=new ImageIcon(getClass().getResource("POO(Wall).png"));         
                    g.setColor(new Color(128,64,0));         
                    g.drawImage(imagen.getImage(), getColumn()*40, getRow()*40, getSize(), getSize(), null);
                }
            }
        }
    }
    
    
    //Repartir de forma aleatoria las llaves en los espacions vacios
//    public void generateRandomKeys(int numKeys) {
//        Random random = new Random();
//        int count = 0;
//        while (count < numKeys) {
//            int x = random.nextInt(getNumColumns());
//            int y = random.nextInt(getNumRows());
//
//            if (getDungeon()[y][x] == 0) {
//                keys.add(new Key(x, y));
//                count++;
//            }
//        }
//
//    }
    
    //Repartir los mosntruos
    public void generateMonsters() {

        monsters.add(new Slime(8*Size, 5*Size, yellow));
        monsters.add(new Spider(12*Size, 10*Size, yellow));
        monsters.add(new Eye(2*Size, 9*Size, yellow));
        monsters.add(new Doc(5*Size, 7*Size, yellow));

    }
    
    //Agregar habilidad al laberinto
    public void addPotionApple(){
        
        int x = (int)(Math.random() * Size) - Size;
        int y = (int)(Math.random() * Size) - Size;
        
        HealPotion pot = new HealPotion(x, y, Size, Size);
        pot.setDrawable(this);
        
        potions.add(pot);
    }

    // Confirmar si se toco con un monstruo
    public void checkForGetDamage(){
        for(int i=0; i<monsters.size(); i++)
        {
            Monster monster = monsters.get(i);
            
            if(yellow.checkCollision(monster))
            {
                yellow.loseLife();
            }
        }
    }
    
    public void checkForGrapKey(){
        for(int i=0; i<keys.size(); i++)
        {
            Key key = keys.get(i);
            
            if(yellow.checkCollision(key))
            {
                yellow.gotKey();
                keys.remove(key);
            }
        }
    }
    
    public void checkForDreankPotion(){
        for(int i=0; i<potions.size(); i++)
        {
            Potion pot = potions.get(i);
            
            if(yellow.checkCollision(pot))
            {
                yellow.drink();
                potions.remove(pot);
            }
        }
    }
    
    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @return the numRows
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * @param numRows the numRows to set
     */
    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    /**
     * @return the numColumns
     */
    public int getNumColumns() {
        return numColumns;
    }

    /**
     * @param numColumns the numColumns to set
     */
    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
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

    /**
     * @return the keys
     */
    public List<Key> getKeys() {
        return keys;
    }

    /**
     * @param keys the keys to set
     */
    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getX() {
        return row;
    }

    @Override
    public int getY() {
        return column;
    }

    @Override
    public int getWidth() {
        return Size;
    }

    @Override
    public int getHeight() {
        return Size;
    }
    
    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void redraw(int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the drawable
     */
    public Drawable getDrawable() {
        return drawable;
    }

    /**
     * @param drawable the drawable to set
     */
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}