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
    
    
//    private void open() {
//        this.open=true;
//    }
//    
//    private void close() {
//        this.open=false;
//    }

    void stim(double amt) {
        this.actionPotential+=amt;
    }
    
//    private void updateOpenness() {
//        if(actionPotential>1)
//            this.open();
//        else 
//            this.close();
//    }
    
    void nextTurn() {
                
        if(isOpen())
            for(Map.Entry<Gestalt,Double> gWeighted : outgoing.entrySet()) {
                gWeighted.getKey().stim(gWeighted.getValue());
            }
        
        if(actionPotential > 0)
            actionPotential-=.2*(actionPotential-0);
        
    }
    
    
    public String toString() {
        return String.valueOf(isOpen() + " " + actionPotential);
    }

    /**
     * @return the open
     */
    public boolean isOpen() {
//        return open;
        return actionPotential>1;
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
            this.room.temp+=.2;
        
    }

    public String toString() {
        return "PulseHeater: " + super.toString();
    }    

}

class PulseAC extends Motor {
    PulseAC(Room r) {
        super(r);
    }
    
    void nextTurn() {
        super.nextTurn();
        
        if(this.isOpen()) 
            this.room.temp+=.2;
        
        
    }

    public String toString() {
        return "PulseAC: " + super.toString();
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
        if(this.room.temp > 68)
            this.stim(2);
                
        super.nextTurn();
        
    }
    
    public String toString() {
        return "TooHotSensor: " + super.toString();
    }    
}

class TooColdSensor extends Sensor {
    
    
    TooColdSensor(Room r) {
        super(r);
    }
            
    void nextTurn() {
        
        if(this.room.temp < 68)
            this.stim(2);
        
        super.nextTurn();

    }
    
    
    public String toString() {
        return "TooColdSensor: " + super.toString();
    }    
    
}