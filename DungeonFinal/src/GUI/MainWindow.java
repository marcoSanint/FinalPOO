/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
 
import Modelos.Dimensionable;
import Modelos.Drawable;
import Modelos.Dungeon;
import java.awt.Graphics;

/**
 *
 * @author Marco Sanint
 */
public class MainWindow extends javax.swing.JFrame implements Drawable, Dimensionable {

    private Dungeon dungeon;
    
    /**
     * Creates new form GameWindow
     */
    public MainWindow() {
        initComponents();
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
        dungeon.setDrawable(this);
    }
    
    @Override
    public void paint(Graphics g)
    {
        dungeon.draw(g);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MainWindow window = new MainWindow();
        Dungeon dungeon = new Dungeon();
        
        window.setDungeon(dungeon);
//        garden.setWidth(window.getWidth());
//        garden.setHeight(window.getHeight());
        
        window.setTitle("Dungeon");
        window.setVisible(true);
    }

    @Override
    public void redraw() {
        repaint();
    }
    
    @Override
    public void redraw(int x, int y, int width, int height)
    {
        repaint(x, y, width, height);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
