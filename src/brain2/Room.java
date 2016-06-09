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

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.YELLOW);
        g2.fill(foodArea);
    }

    
    
}
