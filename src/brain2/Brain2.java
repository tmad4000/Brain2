/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author jacobcole
 */
public class Brain2 {
    
    ArrayList<Gestalt> gestalts=new ArrayList<Gestalt>();
    
    
    Brain2(Room r) {
        

        
        
        
        Sensor tooHotS = new TooHotSensor(r);
        Sensor tooColdS = new TooColdSensor(r);
        
                
        Motor heater = new TurnOnHeater(r);
        Motor cooler = new TurnOnAC(r);
        
        {
            HashMap<Gestalt,Double> thsMap = new HashMap<Gestalt,Double>();
            thsMap.put(cooler, 2.);
            tooHotS.setOutgoing(thsMap);
        }   
        
        {
            HashMap<Gestalt,Double> tcsMap = new HashMap<Gestalt,Double>();
            tcsMap.put(heater, 2.);
            tooColdS.setOutgoing(tcsMap);
        }
                
        
        
        
        gestalts.add(tooHotS);
        gestalts.add(tooColdS);
        
        gestalts.add(heater);
        gestalts.add(cooler);
        
    }
    
    void nextTurn() {
        for(Gestalt g: gestalts) {
            g.nextTurn();
        }
    }
    
    void printOpenGestalts() {
        System.out.println("Brain gestalts: ");
        
        for(Gestalt g: gestalts) {
            if(g.open)
                System.out.println(g);

        }
    }

            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Room r=new Room();
        Brain2 thermostat = new Brain2(r);
        
       
        
        r.temp=63;

        
        for(int i=0;i<10;i++) {
            thermostat.nextTurn();


            System.out.println("Room: " + r);
            System.out.println();

            thermostat.printOpenGestalts();

            System.out.println("------------------------------------");
        }


//        heater.open();
//        System.out.println(r);

        // TODO code application logic here
//        Scanner reader = new Scanner(System.in);  // Reading from System.in
//        System.out.println("Enter a number: ");
//        String n = reader.nextLine(); 
//        System.out.println(n);
        
        
    }
    
}
