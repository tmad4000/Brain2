/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

/**
 * ThermostatMS = Thermostat Motors and Sensors
 * @author jacobcole
 */

//public class ThermostatMS {
//    
//}


class TooHotSensor extends Sensor<Room> {
    
    TooHotSensor(Room r) {
        super(r);
    }
            
    public void computeNextState() {
        super.computeNextState();

        if(this.obj.temp > 69)
            this.stimOnNextAssumeState(2);        
    }
    
    public String toString() {
        return "TooHotSensor: " + super.toString();
    }    
}

class TooColdSensor extends Sensor<Room> {
    
    
    TooColdSensor(Room r) {
        super(r);
    }
            
    public void computeNextState() {
        super.computeNextState();

        if(this.obj.temp < 67)
            this.stimOnNextAssumeState(2);
        
    }
    
    
    public String toString() {
        return "TooColdSensor: " + super.toString();
    }    
    
}



class PulseHeater extends Motor<Room> {
    PulseHeater(Room r) {
        super(r);
    }
    
    public void computeNextState() {
        super.computeNextState();
        
        if(this.isOpen())
            this.obj.temp+=.2;
        
    }

    public String toString() {
        return "PulseHeater: " + super.toString();
    }    

}

class PulseAC extends Motor<Room> {
    PulseAC(Room r) {
        super(r);
    }
    
    public void computeNextState() {
        super.computeNextState();
        
        if(this.isOpen()) 
            this.obj.temp-=.2;
        
        
    }

    public String toString() {
        return "PulseAC: " + super.toString();
    }    

}
