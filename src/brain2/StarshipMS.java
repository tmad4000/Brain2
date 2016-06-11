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
public class StarshipMS {
    
}


class LowFuelSensor extends Sensor<Starship> {
    
    LowFuelSensor(Starship obj) {
        super(obj);
    }
            
    public void computeNextState() {
        super.computeNextState();

        if(this.obj.fuel < 30)
            this.stimOnNextAssumeState(2);        
    }
    
}




class HighFuelSensor extends Sensor<Starship> {
    
    HighFuelSensor(Starship obj) {
        super(obj);
    }
            
    public void computeNextState() {
        super.computeNextState();

        if(this.obj.fuel > 32)
            this.stimOnNextAssumeState(2); 
    }
    
}





class HarvestableFuelSensor extends Sensor<Starship> {

    AsteroidField room;
    
    HarvestableFuelSensor(Starship obj, AsteroidField room) {
        super(obj);
        this.room=room;
    }
            
    public void computeNextState() {
        super.computeNextState();

        if(room.foodArea.contains(this.obj.x, this.obj.y))
            this.stimOnNextAssumeState(2);
    }
    
}


class HitWallSensor extends Sensor<Starship> {

    AsteroidField room;
    
    HitWallSensor(Starship obj, AsteroidField room) {
        super(obj);
        this.room=room;
    }
            
    public void computeNextState() {
        super.computeNextState();

        if(room.crossesWall(obj.getPath())) {
            this.stimOnNextAssumeState(2);
        }
    }
    
}



class Forward extends Motor<Starship> {
    Forward(Starship obj) {
        super(obj);
    }
    
    public void computeNextState() {
        super.computeNextState();
        
        if(this.isOpen()) {
            this.obj.nextX +=this.obj.dirXY()[0]*this.obj.v;
            this.obj.nextY +=this.obj.dirXY()[1]*this.obj.v;
        }
    }


}


class TurnLeft extends Motor<Starship> {
    TurnLeft(Starship obj) {
        super(obj);
    }
    
    public void computeNextState() {
        super.computeNextState();
        
        if(this.isOpen())
            this.obj.dir = (this.obj.dir - 5)%360 ;

    }


}

class TurnRight extends Motor<Starship> {
    TurnRight(Starship obj) {
        super(obj);
    }
    
    public void computeNextState() {
        super.computeNextState();
        
        if(this.isOpen())
            this.obj.dir = (this.obj.dir + 5)%360 ;

    }


}


class TryToHarvestFuel extends Motor<Starship> {
    AsteroidField room;
    
    TryToHarvestFuel(Starship obj, AsteroidField room) {
        super(obj);
        this.room=room;
    }
    
    public void computeNextState() {
        super.computeNextState();
        
        if(this.isOpen()) {
            if(room.foodArea.contains(this.obj.x, this.obj.y)){
                this.obj.nextFuel+=.2;
            }
            else
                System.err.println("cannot eat food on assumeNextState");
        }
        
    }


}