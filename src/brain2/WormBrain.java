package brain2;

import java.util.HashMap;

/**
 *
 * @author jacobcole
 */
public class WormBrain extends Brain2 {
    
    
    
//    WormBrain(Worm w) {
//                
//        Sensor lowBloodSugarSensor = new LowBloodSugarSensor(w);
//                
//        Motor goForward = new Forward(w);
//        
//        Motor eatFood = new TryToEatFood(w,r);
//        
//        
//        {
//            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
//            conn.put(eatFood, 2.);
//            lowBloodSugarSensor.setClosedBy(conn);
//        }
//        
//        
//        gestalts.add(lowBloodSugarSensor);
//        gestalts.add(goForward);
//        gestalts.add(eatFood);
//        
//    }    

    WormBrain(Worm w, Room r) {
                
        Sensor lowBloodSugarSensor = new LowBloodSugarSensor(w);
        Sensor highBloodSugarSensor = new HighBloodSugarSensor(w);
        Sensor foodSensor = new FoodSensor(w,r);
        Sensor hitWallSensor = new HitWallSensor(w,r);
        
        
         
                
        Motor goForward = new Forward(w);
        Motor turnLeft = new TurnLeft(w);
        Motor turnRight = new TurnRight(w);
        Motor eatFood = new TryToEatFood(w,r);

                
                
        Gestalt turnGestalt = new TurnGestalt();
        
        
        
        // Motors like forward that can produce actions that can fail (all of them?)
        // and have the capacity to stimulate sensors detecting that failure like
        // hitWall need to be processed first before sensors #hack #refactor #TODO
        gestalts.add(goForward);
        gestalts.add(turnGestalt);
        gestalts.add(turnLeft);
        gestalts.add(turnRight);
        gestalts.add(eatFood);
        
//        abilities.add(goForward);
//        abilities.add(turnGestalt);
//        abilities.add(turnLeft);
//        abilities.add(turnRight);
//        abilities.add(eatFood);
       
        
        
        
        gestalts.add(lowBloodSugarSensor);
        gestalts.add(highBloodSugarSensor);
        gestalts.add(foodSensor);
        gestalts.add(hitWallSensor);

        
        
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(goForward, 2.);
            lowBloodSugarSensor.setClosedBy(conn);
        }
        
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(eatFood, -5.);
            highBloodSugarSensor.setClosedBy(conn);
        }
        
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(eatFood, 2.);
            foodSensor.setClosedBy(conn);
        }     
        
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(goForward, -5.);
            eatFood.setClosedBy(conn);
        }     
        
                
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(turnGestalt, 2.);
//            conn.put(goForward, -5.);

            hitWallSensor.setClosedBy(conn);
        }
               
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(turnRight, 2.);
            conn.put(turnLeft, 3.);

            turnGestalt.setClosedBy(conn);
        }
        
      /*  
        // Convergent thinking 
        // Input: 
//        allOpenGestalts
//        PotentialPlans
            Plan A:
                - Forward 10 ticks
                - turnLeft 6 ticks
            Plan B:
                - Forward 10 ticks
                - turnRight 6 ticks
            Plan C:
                - turnRight 6 ticks
                - Forward 10 ticks
//        PotentialActions
        // 
        // Input: [turnRightGestalt, turnLeftGestalt], brainState 
        // Output: Decision
       
        
        */
     
    }
    
        

}
