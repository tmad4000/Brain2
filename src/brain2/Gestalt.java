/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jacobcole
 */
class Gestalt implements NextStateComputable {
    
    private boolean open;
    
    double actionPotential=0., nextActionPotential=0.;
    
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

    void stimOnNextAssumeState(double amt) {
        this.nextActionPotential+=amt;
    }
    
//    private void updateOpenness() {
//        if(actionPotential>1)
//            this.open();
//        else 
//            this.close();
//    }
    
    public void computeNextState() {
                
        if(isOpen())
            for(Map.Entry<Gestalt,Double> gWeighted : outgoing.entrySet()) {
                gWeighted.getKey().stimOnNextAssumeState(gWeighted.getValue());
            }
        
        
    }
    
        
    public void assumeNextState() {
                
        this.actionPotential=this.nextActionPotential;
        
        
        nextActionPotential=0;
//        if(actionPotential > 0)
//            actionPotential-=.2*(actionPotential-0);
   
    }
        
         
    
    public String toString() {
        return isOpen() + " " + actionPotential;
    }

    /**
     * @return the open
     */
    public boolean isOpen() {
//        return open;
        return actionPotential>1;
    }

    @Override
    public void paintComponent(Graphics g) {
    }
    
}

class Motor<T> extends Gestalt {
    T obj; //eg room
    Motor(T r) {
        super();
        this.obj=r;
    }
    
}





class Sensor<T> extends Gestalt {
    T obj; //eg room

    Sensor(T r) {
        super();
        this.obj=r;
    }   
    
}

