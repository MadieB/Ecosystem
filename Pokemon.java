/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Madison B
 */
public abstract class Pokemon {
    
    //Fields
    protected int x;
    protected int y;
    protected int vx;
    protected int vy;
   

    //Constructor
    public Pokemon(int x, int y) {
        this.x = x;
        this.y = y;
        this.vx = (int)(Math.random()*10);
        this.vy = (int)(Math.random()*10);
       
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void draw(Graphics g);
    
    public void update() {
        move();
       
    }
    
    public void move() {
        x += vx;
        y += vy;
    }
    
    public void die(){
        x = 2000;
        y = 2000;
        vx = 0;
        vy = 0;
        
    }
    
    
    public void reverseX(){
        
        vx = - vx;
       
    }
    
    public void reverseY(){
        
         vy *= -1;
         
    }
}
