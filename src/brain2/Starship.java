/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jacobcole
 */
class Starship extends UniverseObject implements NextStateComputable {
    double x = 300, nextX;
    double y = 350, nextY;
    
    double fuel = 27.1, nextFuel;
    
    Brain2 wormBrain;
    AsteroidField room;
    
    Starship(AsteroidField room) {
         this.room = room;
         this.wormBrain = new StarshipBrain(this, room);
         this.dir=90;
         this.v=5;
    }
    
    public Path getPath() {
        return new Path(x,y,nextX,nextY);
    }
    
    @Override
    public void computeNextState() {
        nextFuel=fuel-.05;
        
        // Default, nextX and nextY can get overridden subsequently
        nextX = x;
        nextY = y;
        
        wormBrain.computeNextState();
        
            
    }
        
    @Override
    public void assumeNextState() {
        if(room.crossesWall(this.getPath())) {
            //can't move forward
            nextX = x;
            nextY = y;
        }
                
        fuel=nextFuel;
        x = nextX;
        y = nextY;
        
        wormBrain.assumeNextState();
    }
    
    public String toString() {
        return getClass().getSimpleName() + ": (" + String.format("%.2f",x) + ", " + String.format("%.2f",y) + ") Fuel: " + String.format("%.2f",fuel) + wormBrain;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)(x-5), (int)(y-5), 10, 10);
        
        g.setColor(Color.BLACK);

        
        g.drawLine((int)x, (int)y, (int)((10 + v)*dirXY()[0]+x), (int)((10+v)*dirXY()[1]+y));
    }
    
}
