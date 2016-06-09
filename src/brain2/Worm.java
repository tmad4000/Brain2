/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

/**
 *
 * @author jacobcole
 */
class Worm implements NextStateComputable {
    double x = 5, nextX;
    double y = 5, nextY;
    
    double bloodSugar = 29.1, nextBloodSugar;
    
    Brain2 wormBrain;
    
    Worm(Room r) {
         this.wormBrain = new WormBrain(this, r);
    }

    @Override
    public void computeNextState() {
        nextBloodSugar=bloodSugar-.05;
        nextX = x;
        nextY = y;
        wormBrain.computeNextState();
    }
        
    @Override
    public void assumeNextState() {
        bloodSugar=nextBloodSugar;
        x = nextX;
        y = nextY;
        wormBrain.assumeNextState();
    }
    
    public String toString() {
        return "Worm (" + String.format("%.2f",x) + ", " + String.format("%.2f",y) + ") bloodSugar: " + String.format("%.2f",bloodSugar) + wormBrain;
    }
    
}
