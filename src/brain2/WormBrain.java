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
//            lowBloodSugarSensor.setOutgoing(conn);
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
                
        Motor goForward = new Forward(w);
        Motor eatFood = new TryToEatFood(w,r);
        
        
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(goForward, 2.);
            lowBloodSugarSensor.setOutgoing(conn);
        }
        
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(eatFood, -5.);
            highBloodSugarSensor.setOutgoing(conn);
        }
        
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            
            conn.put(eatFood, 2.);
            conn.put(goForward, -5.);

            foodSensor.setOutgoing(conn);
        }
        
        
        gestalts.add(lowBloodSugarSensor);
        gestalts.add(highBloodSugarSensor);
        gestalts.add(foodSensor);

        gestalts.add(goForward);
        gestalts.add(eatFood);
        
    }
    
        

}
