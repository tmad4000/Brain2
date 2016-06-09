/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author jacobcole
 */
public class Brain2 implements NextStateComputable {
    
    ArrayList<Gestalt> gestalts=new ArrayList<Gestalt>();
    

    Brain2() {}
    
    public void nextTurn() {
        for(Gestalt g: gestalts) {
            g.computeNextState();
        }
    
        for(Gestalt g: gestalts) {
            g.assumeNextState();
        }
    }
 
    @Override
    public void computeNextState() {
        for(Gestalt g: gestalts) {
            g.computeNextState();
        }
    }
       
     @Override
    public void assumeNextState() {
        for(Gestalt g: gestalts) {
            g.assumeNextState();
        }
    }

    public void printOpenGestalts() {
        System.out.println(this);

    }
    
    public Gestalt[] getOpenGestalts() {
        
        ArrayList<Gestalt> oGs=new ArrayList<Gestalt>();

        
         for(Gestalt g: gestalts) {
            if(g.isOpen())
                oGs.add(g);

        }
        
        return oGs.toArray(new Gestalt[0]);
    }    
    
    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("\n" + getClass().getSimpleName() + " Gestalts: \n");
        
        
         for(Gestalt g: gestalts) {
            if(g.isOpen())
                s.append("    " + g + "\n");

        }
        
        
        return s.toString();
    }

            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
//        
        Universe u = new Universe();
        
//        Room r=new Room();
//        r.temp=62;
        
//        Brain2 thermostat = new ThermostatBrain(r);


//
//        for(int i=0;i<91 ;i++) {
//
//
//            System.out.println("Room: " + r);
//            System.out.println();
//
//            thermostat.printOpenGestalts();
//
//            System.out.println("------------------------------------");
//            
//            thermostat.nextTurn();
//            r.computeNextState();
//            r.assumeNextState();
//
//
//        }

        
//                
//        Worm w = new Worm();
//        Brain2 wormBrain = new WormBrain(w, r);
        
        
//      
        for(int i=0;i<50 ;i++) {
            u.next();

//            System.out.println("Worm: " + w);
//            System.out.println("Room: " + r);
//            System.out.println();
//
//            wormBrain.printOpenGestalts();
//
//            System.out.println("------------------------------------");
//            
//            wormBrain.computeNextState();
//            w.computeNextState();
//            r.computeNextState();
//            
//            wormBrain.assumeNextState();
//            w.assumeNextState();
//            r.assumeNextState();

        }


//        heater.open();
//        System.out.println(r);

        // TODO code application logic here
//        Scanner reader = new Scanner(System.in);  // Reading from System.in
//        System.out.println("Enter a number: ");
//        String n = reader.nextLine(); 
//        System.out.println(n);
        
        
    }

    @Override
    public void paintComponent(Graphics g) {
    }


    
}
