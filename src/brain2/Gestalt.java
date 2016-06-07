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
    
    private boolean open;
    
    double actionPotential=0.;
    
    HashMap<Gestalt,Double> outgoing;
    
    Gestalt() {
        this.outgoing=new HashMap<Gestalt,Double>();
    }    
    
    void setOutgoing(HashMap<Gestalt,Double> outgoing) {
        this.outgoing=outgoing;
    }
    
    
    private void open() {
        this.open=true;
    }
    
    private void close() {
        this.open=false;
    }
    
    void stim(double amt) {
        this.actionPotential+=amt;
    }
    
    void nextTurn() {
        
        if(actionPotential>1)
            this.open();
        else 
            this.close();
        
        if(isOpen())
            for(Map.Entry<Gestalt,Double> gWeighted : outgoing.entrySet()) {
                gWeighted.getKey().stim(gWeighted.getValue());
            }
        
        actionPotential=0;
    }
    
    
    public String toString() {
        return String.valueOf(isOpen());
    }

    /**
     * @return the open
     */
    public boolean isOpen() {
        return open;
    }
    
}

class Motor extends Gestalt {
    Room room;
    Motor(Room r) {
        super();
        this.room=r;
    }
    
}

class PulseHeater extends Motor {
    PulseHeater(Room r) {
        super(r);
    }
    
    void nextTurn() {
        super.nextTurn();
        
        if(this.isOpen())
            this.room.temp++;
        
    }

    public String toString() {
        return "PulseHeater: " + String.valueOf(isOpen());
    }    

}

class PulseAC extends Motor {
    PulseAC(Room r) {
        super(r);
    }
    
    void nextTurn() {
        super.nextTurn();
        
        if(this.isOpen()) 
            this.room.temp--;
        
        
    }

    public String toString() {
        return "PulseAC: " + String.valueOf(isOpen());
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
            this.actionPotential=2;
        else
            this.actionPotential=0;
    }
    
    public String toString() {
        return "TooHotSensor: " + String.valueOf(isOpen());
    }    
}

class TooColdSensor extends Sensor {
    
    
    TooColdSensor(Room r) {
        super(r);
    }
            
    void nextTurn() {
        super.nextTurn();
        
        if(this.room.temp < 64)
            this.actionPotential=2;
        else
            this.actionPotential=0;
    }
    
    
    public String toString() {
        return "TooColdSensor: " + String.valueOf(isOpen());
    }    
    
}