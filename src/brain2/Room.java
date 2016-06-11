/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

import java.awt.*;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author jacobcole
 */
class Room implements NextStateComputable {
    double temp = 68, nextTemp;
    
    Rectangle2D.Double foodArea = new Rectangle2D.Double(0, 300, 600, 300);
    
    private Wall[] walls = {
        new Wall(200, 0, 90, 200), new Wall(200, 200, 180, 100), new Wall(100, 200, 90, 75),
        new Wall(300, 0, 90, 200), new Wall(300, 200, 0, 100), new Wall(400, 200, 90, 75),
        new Wall(100, 275, 0, 300), //        new Wall(300, 0, 2, 500),
    //        new Wall(100, 200, 1, 300),
    //        new Wall(100, 250, 1, 300),  //horizontal, right
    //        new Wall(200, 0, 2, 200), new Wall(250, 0, 2, 200) //vertical,down
    };
    
    Room() {
        for (Wall w: walls) {
            double transX = 50;
            double transY = 0;
            w.x += transX;
            w.y += transY;
            w.x2 += transX;
            w.y2 += transY;
        }
    }
    
    public String toString() {
        return "Room " + String.format("%.2f",temp);
    }


    @Override
    public void computeNextState() {
        nextTemp= temp > 58 ? temp-.1 : temp+.1;
    }
    
    @Override
    public void assumeNextState() {
        temp=nextTemp;
    }
    
    public boolean crossesWall(Path p) {
        for (Wall w: walls)
            if(p.crosses(w))
                return true;
        
        return false;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.YELLOW);
        g2.fill(foodArea);
        
        for (Wall w: walls) 
            w.paintComponent(g);
    }

    
    
}
