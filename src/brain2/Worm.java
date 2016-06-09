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
class Worm implements NextStateComputable {
    double x = 300, nextX;
    double y = 250, nextY;
    
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

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)(x-5), (int)(y-5), 10, 10);
//        g.drawLine((int)x, (int)y, (int)((5 + v)*dirXY()[0]+x), (int)((5+v)*dirXY()[1]+y));
    }
    
}
