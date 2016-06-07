/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jacobcole
 */
class Gestalt {
    
    boolean open;
    
    double actionPotential=0.;
    
    HashMap<Gestalt,Double> outgoing;
    
    Gestalt() {
        this.outgoing=new HashMap<Gestalt,Double>();
    }    
    
    void setOutgoing(HashMap<Gestalt,Double> outgoing) {
        this.outgoing=outgoing;
    }
    
    
    void open() {
        this.open=true;
    }
    
    void close() {
        this.open=false;
    }
    
    void stim(double amt) {
        this.actionPotential+=amt;
    }
    
    void nextTurn() {
        
        if(actionPotential>1)
            this.open();
        
        
        if(open)
            for(Map.Entry<Gestalt,Double> gWeighted : outgoing.entrySet()) {
                gWeighted.getKey().stim(gWeighted.getValue());
            }
    }
    
    
    public String toString() {
        return String.valueOf(open);
    }
    
}

class Motor extends Gestalt {
    Room room;
    Motor(Room r) {
        super();
        this.room=r;
    }
    
}

class TurnOnHeater extends Motor {
    TurnOnHeater(Room r) {
        super(r);
    }
    
    void nextTurn() {
        super.nextTurn();
        
        if(this.open)
            this.room.temp++;
        
        this.close();
    }

    public String toString() {
        return "TurnOnHeater: " + String.valueOf(open);
    }    

}

class TurnOnAC extends Motor {
    TurnOnAC(Room r) {
        super(r);
    }
    
    void nextTurn() {
        super.nextTurn();
        
        if(this.open) 
            this.room.temp--;
        
        this.close();
        
    }

    public String toString() {
        return "TurnOnAC: " + String.valueOf(open);
    }    

}





class Sensor extends Gestalt {
    Room room;

    Sensor(Room r) {
        super();
        this.room=r;
    }   
    
}


class TooHotSensor extends Sensor {
    
    TooHotSensor(Room r) {
        super(r);
    }
            
    void nextTurn() {
        super.nextTurn();
        
        if(this.room.temp > 72)
            this.open();
        else
            this.close();
    }
    
    public String toString() {
        return "TooHotSensor: " + String.valueOf(open);
    }    
}

class TooColdSensor extends Sensor {
    
    
    TooColdSensor(Room r) {
        super(r);
    }
            
    void nextTurn() {
        super.nextTurn();
        
        if(this.room.temp < 64)
            this.open();
        else
            this.close();
    }
    
    
    public String toString() {
        return "TooColdSensor: " + String.valueOf(open);
    }    
    
}