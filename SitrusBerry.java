/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author 800141
 */
public class SitrusBerry implements Collectable {
    int x;
    int y;
    private int size;
    private ImageIcon ii;
    private Image img;
    
    public SitrusBerry(int size){
        x = (int)(Math.random()*1000);
        y = (int)(Math.random()*700);
        this.size = size;
        this.ii = new ImageIcon(getClass().getResource("/images/sitrusBerry.png"));
        this.img = ii.getImage();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public void draw(Graphics g) {
        g.drawImage(img, x, y, size, size, null);
    } 

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
    
    
    @Override
    public void heal(){
        
    }
}
