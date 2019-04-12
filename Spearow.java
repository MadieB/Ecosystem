/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Madison B
 */
public class Spearow extends Pokemon {
    private int size;
    private int health;
    private int attack;
    private Color color;
    private ImageIcon ii;
    private Image img;
    
    public Spearow (int size) {
        super((int)(Math.random()*1000),(int)(Math.random()*500));
        this.size = size;
        this.health = 40;
        this.attack = 10;
        this.color = new Color(225, 0, 100, 100);
        this.ii = new ImageIcon(getClass().getResource("/images/Spearow.gif"));
        this.img = ii.getImage();
        
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
    
    public Spearow() {
        this(200);
    }
    
    public void draw(Graphics g) {
        g.drawImage(img, x, y, size, size, null);
    }
}
