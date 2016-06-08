package brain2;

import java.util.HashMap;

/**
 *
 * @author jacobcole
 */
public class WormBrain extends Brain2 {
    
    WormBrain(Worm w) {
                
        Sensor lowBloodSugarSensor = new LowBloodSugarSensor(w);
        
                
        Motor goForward = new Forward(w);
        
        Motor eatFood = new EatFood(w);
        
        
        {
            HashMap<Gestalt,Double> conn = new HashMap<Gestalt,Double>();
            conn.put(eatFood, 2.);
            lowBloodSugarSensor.setOutgoing(conn);
        }
        
        
        gestalts.add(lowBloodSugarSensor);
        gestalts.add(goForward);
        gestalts.add(eatFood);
        
    }
}
