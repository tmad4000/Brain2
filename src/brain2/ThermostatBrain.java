/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

import java.util.HashMap;

/**
 *
 * @author jacobcole
 */
public class ThermostatBrain extends Brain2 {
    ThermostatBrain(Room r) {
        
        Sensor tooHotS = new TooHotSensor(r);
        Sensor tooColdS = new TooColdSensor(r);
        
                
        Motor heater = new PulseHeater(r);
        Motor cooler = new PulseAC(r);
        
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

}
