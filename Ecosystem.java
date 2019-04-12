/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Madison B
 */
public class Ecosystem extends JPanel {

    private Timer timer;
    private Eevee[] eevees;
    private Pikachu[] pikachus;
    private Spearow[] spearows;
    private Pidge[] pidges;
    private Rattata[] rattatas;
    private SitrusBerry[] sitrusberries;
    private OranBerry[] oranberries;
   
        
    public Ecosystem() {
        super();
        setSize(1200, 960);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 2000, 1000/20);
        eevees = new Eevee[6];
        pikachus = new Pikachu[6];
        spearows = new Spearow[6];
        pidges = new Pidge[6];
        rattatas = new Rattata[6];
        oranberries = new OranBerry[3];
        sitrusberries = new SitrusBerry[3];
        
        spawnEevee();
        spawnRattata();
        spawnPikachu();
        spawnSpearow();
        spawnPidge();
        spawnOBerry();
        spawnSBerry();
    }
    
    private void spawnEevee() {
        for(int i = 0; i <6; i++){
        eevees[i] = new Eevee();
        }
    }
    private void spawnRattata() {
        for(int i = 0; i <6; i++){
        rattatas[i] = new Rattata();
        }
    }
       
    private void spawnPikachu() {
        for(int i = 0; i <6; i++){
        pikachus[i] = new Pikachu();
        }
    }
    
    private void spawnSpearow() {
        for(int i = 0; i <6; i++){
        spearows[i] = new Spearow();
        }
    }
    
     private void spawnPidge() {
        for(int i = 0; i <6; i++){
        pidges[i] = new Pidge();
        }
   }
    private void spawnOBerry() {
        for(int i = 0; i <3; i++){
        oranberries[i] = new OranBerry(25);
        }
   }
    private void spawnSBerry() {
        for(int i = 0; i <3; i++){
        sitrusberries[i] = new SitrusBerry(30);
        }
   }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Eevee eevee : eevees) {
            eevee.draw(g);
        }
        for (Pikachu pikachu: pikachus){
            pikachu.draw(g);
        }
        for (Spearow spearow: spearows){
            spearow.draw(g);
        }
        for (Pidge pidge: pidges){
            pidge.draw(g);
        }
            
        for (Rattata rattata : rattatas) {
            rattata.draw(g);
        }
        for (OranBerry oranberry: oranberries){
            oranberry.draw(g);
        }
        for (SitrusBerry sitrusberry: sitrusberries){
            sitrusberry.draw(g);
        }
       
        
        this.setBackground(Color.green);
    }
    
    private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            for (Eevee eevee : eevees) {
                wallCollisions(eevee);
                
                eevee.update();  
            }
            for (Pikachu pikachu : pikachus) {
                wallCollisions(pikachu);
                pikachu.update();
            }
            for (Spearow spearow: spearows){
                wallCollisions(spearow);
               spearow.update();
            }
            for (Pidge pidge: pidges){
                wallCollisions(pidge);
               pidge.update();
            }
              
           for (Rattata rattata : rattatas) {
               wallCollisions(rattata);
               rattata.update();
            }
           for (Eevee eevee: eevees){
               for (Rattata rattata: rattatas ){
                   eeveeVsRattata(eevee, rattata);
               }   
           }
            for (Rattata rattata: rattatas){
               for (Pikachu pikachu: pikachus ){
                   rattataVsPikachu(rattata, pikachu);
               }   
           }
            for (Pidge pidge: pidges){
               for (Spearow spearow: spearows ){
                   pidgeVsSpearow(pidge, spearow);
               }   
           }
             for (Spearow spearow: spearows){
               for (Eevee eevee: eevees ){
                   spearowVsEevee(spearow, eevee);
               }   
           }
              for (Pikachu pikachu: pikachus){
               for (Pidge pidge: pidges ){
                   pikachuVsPidge(pikachu, pidge);
               }   
           }
           for (Eevee eevee: eevees){
               for (OranBerry oranberry: oranberries ){
                   eeveeVsOBerry(eevee, oranberry);
               }   
           }
              for (Pikachu pikachu: pikachus){
               for (SitrusBerry sitrusberry: sitrusberries ){
                   pikachuVsSBerry(pikachu, sitrusberry);
               }   
           }
           
            repaint();
        }
    }
    private void eeveeVsRattata(Eevee p1, Rattata p2){
        if (p1.getX() > p2.getX() 
                && p1.getX() < p2.getX() + p2.getSize() 
                && p1.getY() > p2.getY()
                && p1.getY() < p2.getY() + p2.getSize()){

            p2.die();
        }
    }
      private void rattataVsPikachu (Rattata p1, Pikachu p2){
        if (p1.getX() > p2.getX() 
                && p1.getX() < p2.getX() + p2.getSize()
                && p1.getY() > p2.getY()
                && p1.getY() < p2.getY() + p2.getSize()){
            
             p2.die();
        }
    }
        private void pidgeVsSpearow(Pidge p1, Spearow p2){
        if (p1.getX() > p2.getX() 
                && p1.getX() < p2.getX() + p2.getSize()
                && p1.getY() > p2.getY()
                && p1.getY() < p2.getY() + p2.getSize()){
            
           p2.die();
        }
    }
    private void spearowVsEevee(Spearow p1, Eevee p2){
        if (p1.getX() > p2.getX() 
                && p1.getX() < p2.getX() + p2.getSize()
                && p1.getY() > p2.getY()
                && p1.getY() < p2.getY() + p2.getSize()){
         
            p2.die();
        }
    }
     private void pikachuVsPidge(Pikachu p1, Pidge p2){
        if (p1.getX() > p2.getX() 
                && p1.getX() < p2.getX() + p2.getSize()
                && p1.getY() > p2.getY()
                && p1.getY() < p2.getY() + p2.getSize()){
           
           p2.die();
        }
    }
     
      private void eeveeVsOBerry(Eevee p1, OranBerry p2){
        if (p1.getX() > p2.getX() 
                && p1.getX() < p2.getX() + p2.getSize() 
                && p1.getY() > p2.getY()
                && p1.getY() < p2.getY() + p2.getSize()){

            p2.setX(2000);
            p2.setY(2000);
        }
    }
      
       private void pikachuVsSBerry(Pikachu p1, SitrusBerry p2){
        if (p1.getX() > p2.getX() 
                && p1.getX() < p2.getX() + p2.getSize() 
                && p1.getY() > p2.getY()
                && p1.getY() < p2.getY() + p2.getSize()){

            p2.setX(2000);
            p2.setY(2000);
        }
    }
       
    private void eeveeXEevee(Eevee p1, Eevee p2){
        if (p1.getX() > p2.getX() 
                && p1.getX() < p2.getX() + p2.getSize()
                && p1.getY() > p2.getY()
                && p1.getY() < p2.getY() + p2.getSize()){
            
       
      }
    }
     
   private void wallCollisions(Pokemon c) {
        if (c.getX() <= 0 || c.getX() >= this.getWidth()){
            c.reverseX();
        }
        if (c.getY() <= 0 || c.getY() >= this.getHeight()){
            c.reverseY();
        }
    }
    
}