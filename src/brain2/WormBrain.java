package brain2;

import java.util.HashMap;

/**
 *
 * @author jacobcole
 */
public class WormBrain extends Brain2 {
    
    WormBrain(Worm w) {
                
        Sensor lowBloodSugarSensor = new LowBloodSugarSensor(w);
        
                
        Motor eatFood = new EatFood(w);
        
        
        {
            HashMap<Gestalt,Double> tcsMap = new HashMap<Gestalt,Double>();
            tcsMap.put(eatFood, 2.);
            lowBloodSugarSensor.setOutgoing(tcsMap);
        }
        
        
        gestalts.add(lowBloodSugarSensor);
        gestalts.add(eatFood);
        
    }
}
