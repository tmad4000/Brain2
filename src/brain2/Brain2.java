/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

import java.awt.Graphics;
import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author jacobcole
 */
public class Brain2 implements NextStateComputable {
    
    ArrayList<Gestalt> gestalts=new ArrayList<Gestalt>();
//    ArrayList<Gestalt> abilities=new ArrayList<Gestalt>();
    
    /*
    Brain's Contents
    
    lowBloodSugar Gestalt
        goForward
    
    highBloodSugarGestalt
        -5 tryToEatFood
    
    Food Sensor
        tryToEatFood
    
    tryToEatFood 
        -5 forward

    HitWallSensor
        turnLeft
        turnRight
    */
    

    Brain2() {}
     
    @Override
    public void computeNextState() {
        
        for(Gestalt g: gestalts) {
            g.computeNextState();
        }
        
        getOpenGestalts().stream().forEach(g -> {
                List<Edge> possibleSolutionsWeighted = brainstormHowToClose(g);
                
                if(possibleSolutionsWeighted.size()==0) {
                        
                }
                else {
//                    Edge bestSol = possibleSolutionsWeighted.get(0);
//                
//                    for(Edge e: possibleSolutionsWeighted) {
//                        if(e.weight>bestSol.weight)
//                            bestSol=e;
//                    }


                    possibleSolutionsWeighted.stream()
                        .forEach( edge -> edge.target.stimOnNextAssumeState(edge.weight));
                    
                }
                
            } 
        );
                
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
    
    public List<Gestalt> getOpenGestalts() {
        return gestalts.stream()
                .filter(g -> g.isOpen()).collect(Collectors.toList());
    }    
    
    public List<Edge> brainstormHowToClose(Gestalt g) {
        
//        return connections.entrySet().stream()
//                .filter(connectionEntry -> connectionEntry.getKey() == g && 
//                        connectionEntry.getValue().weight > 0)
//                .map(connectionEntry -> connectionEntry.getValue())
//                .collect(Collectors.toList());

        return g.outgoing.entrySet().stream().map(entry -> new Edge(entry.getValue(), entry.getKey())).collect(Collectors.toList());
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
