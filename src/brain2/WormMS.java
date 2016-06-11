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
public class WormMS {
    
}


class LowBloodSugarSensor extends Sensor<Worm> {
    
    LowBloodSugarSensor(Worm obj) {
        super(obj);
    }
            
    public void computeNextState() {
        super.computeNextState();

        if(this.obj.bloodSugar < 30)
            this.stimOnNextAssumeState(2);        
    }
    
    public String toString() {
        return "LowBloodSugarSensor: " + super.toString();
    }    
}




class HighBloodSugarSensor extends Sensor<Worm> {
    
    HighBloodSugarSensor(Worm obj) {
        super(obj);
    }
            
    public void computeNextState() {
        super.computeNextState();

        if(this.obj.bloodSugar > 32)
            this.stimOnNextAssumeState(2); 
    }
    
    public String toString() {
        return "HighBloodSugarSensor: " + super.toString();
    }    
}





class FoodSensor extends Sensor<Worm> {

    Room room;
    
    FoodSensor(Worm obj, Room room) {
        super(obj);
        this.room=room;
    }
            
    public void computeNextState() {
        super.computeNextState();

        if(room.foodArea.contains(this.obj.x, this.obj.y))
            this.stimOnNextAssumeState(2);
    }
    
    public String toString() {
        return "FoodSensor: " + super.toString();
    }    
}


class HitWallSensor extends Sensor<Worm> {

    Room room;
    
    HitWallSensor(Worm obj, Room room) {
        super(obj);
        this.room=room;
    }
            
    public void computeNextState() {
        super.computeNextState();

        if(room.crossesWall(obj.getPath())) {
            this.stimOnNextAssumeState(2);
        }
    }
    
    public String toString() {
        return "HitWallSensor: " + super.toString();
    }    
}



class Forward extends Motor<Worm> {
    Forward(Worm obj) {
        super(obj);
    }
    
    public void computeNextState() {
        super.computeNextState();
        
        if(this.isOpen())
            this.obj.nextY +=2;
    }

    public String toString() {
        return "Forward: " + super.toString();
    }    

}


class TryToEatFood extends Motor<Worm> {
    Room room;
    
    TryToEatFood(Worm obj, Room room) {
        super(obj);
        this.room=room;
    }
    
    public void computeNextState() {
        super.computeNextState();
        
        if(this.isOpen()) {
            if(room.foodArea.contains(this.obj.x, this.obj.y)){
                this.obj.nextBloodSugar+=.2;
            }
            else
                System.err.println("cannot eat food on assumeNextState");
        }
        
    }

    public String toString() {
        return "EatFood: " + super.toString();
    }    

}