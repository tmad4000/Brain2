/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

/**
 * WormUniverseMS = WormUniverse Motors and Sensors file
 * @author jacobcole
 */
public class WormUniverseMS {
    
}


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




class HighBloodSugarSensor extends Sensor<Worm> {
    
    HighBloodSugarSensor(Worm r) {
        super(r);
    }
            
    public void computeNextState() {
        if(this.obj.bloodSugar > 32)
            this.stim(2);
                
        super.computeNextState();
        
    }
    
    public String toString() {
        return "HighBloodSugarSensor: " + super.toString();
    }    
}





class FoodSensor extends Sensor<Worm> {

    Room room;
    
    FoodSensor(Worm w, Room r) {
        super(w);
        this.room=r;
    }
            
    public void computeNextState() {
        if(room.foodArea.contains(this.obj.x, this.obj.y))
            this.stim(2);
                
        super.computeNextState();
    }
    
    public String toString() {
        return "FoodSensor: " + super.toString();
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


class TryToEatFood extends Motor<Worm> {
    Room room;
    
    TryToEatFood(Worm w, Room r) {
        super(w);
        this.room=r;
    }
    
    public void computeNextState() {
        super.computeNextState();
        
        if(this.isOpen()) {
            if(room.foodArea.contains(this.obj.x, this.obj.y))
                this.obj.bloodSugar+=.2;
            else
                System.err.println("cannot eat food on assumeNextState");
        }
        
    }

    public String toString() {
        return "EatFood: " + super.toString();
    }    

}