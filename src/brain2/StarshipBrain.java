package brain2;

import java.util.HashMap;

/**
 *
 * @author jacobcole
 */
public class StarshipBrain extends Brain2 {
    
//    StarshipBrain(Starship w) {
//                
//        Sensor lowFuelSensor = new LowFuelSensor(w);
//                
//        Motor goForward = new Forward(w);
//        
//        Motor eatFood = new TryToHarvestFuel(w,r);
//        
//        
//        {
//            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
//            conn.put(eatFood, 2.);
//            lowFuelSensor.setOutgoing(conn);
//        }
//        
//        
//        gestalts.add(lowFuelSensor);
//        gestalts.add(goForward);
//        gestalts.add(eatFood);
//        
//    }    

    StarshipBrain(Starship w, AsteroidField r) {
                
        Sensor lowFuelSensor = new LowFuelSensor(w);
        Sensor highFuelSensor = new HighFuelSensor(w);
        Sensor foodSensor = new HarvestableFuelSensor(w,r);
        Sensor hitWallSensor = new HitWallSensor(w,r);
                
        Motor goForward = new Forward(w);
        Motor turnLeft = new TurnLeft(w);
        Motor turnRight = new TurnRight(w);
        Motor eatFood = new TryToHarvestFuel(w,r);
        
        Gestalt turnGestalt = new TurnGestalt();
        
        // Motors like forward that can produce actions that can fail (all of them?)
        // and have the capacity to stimulate sensors detecting that failure like
        // hitWall need to be processed first before sensors #hack #refactor #TODO
        gestalts.add(goForward);
        gestalts.add(turnGestalt);
        gestalts.add(turnLeft);
        gestalts.add(turnRight);
        gestalts.add(eatFood);
        
        
        gestalts.add(lowFuelSensor);
        gestalts.add(highFuelSensor);
        gestalts.add(foodSensor);
        gestalts.add(hitWallSensor);

        
        
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(goForward, 2.);
            lowFuelSensor.setOutgoing(conn);
        }
        
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(eatFood, -5.);
            highFuelSensor.setOutgoing(conn);
        }
        
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(eatFood, 2.);
            conn.put(goForward, -5.);

            foodSensor.setOutgoing(conn);
        }     
        
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(turnGestalt, 2.);
//            conn.put(goForward, -5.);

            hitWallSensor.setOutgoing(conn);
        }
               
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
//            conn.put(turnRight, 2.);
            conn.put(turnLeft, 2.);

            turnGestalt.setOutgoing(conn);
        }
        
        
     
    }
    
        

}
