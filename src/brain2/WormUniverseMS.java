/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

/**
 * WormUniverseMS = WormUniverse Motors and Sensors
 * @author jacobcole
 */
//public class WormUniverseMS {
//    
//}


class LowBloodSugarSensor extends Sensor<Worm> {
    
    LowBloodSugarSensor(Worm r) {
        super(r);
    }
            
    public void computeNextState() {
        if(this.obj.bloodSugar < 30)
            this.stim(2);
                
        super.computeNextState();
        
    }
    
    public String toString() {
        return "LowBloodSugarSensor: " + super.toString();
    }    
}





class Forward extends Motor<Worm> {
    Forward(Worm r) {
        super(r);
    }
    
    public void computeNextState() {
        super.computeNextState();
        
        if(this.isOpen())
            this.obj.y+=.2;
    }

    public String toString() {
        return "Forward: " + super.toString();
    }    

}


class EatFood extends Motor<Worm> {
    EatFood(Worm r) {
        super(r);
    }
    
    public void computeNextState() {
        super.computeNextState();
        
        if(this.isOpen())
            this.obj.bloodSugar+=.2;
        
    }

    public String toString() {
        return "EatFood: " + super.toString();
    }    

}