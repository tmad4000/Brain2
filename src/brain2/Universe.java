/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;

/**
 *
 * @author Jacob-MTech
 */
class Universe {

    NextStateComputable[] uOs;
    int time = 0;

    
    //default universe
    public Universe() {
        Room r=new Room();
        r.temp=62;
        
        Worm w = new Worm(r);
//        Brain2 wormBrain = new WormBrain(w, r);
        
        NextStateComputable[] uOs = { r, w };
        this.uOs = uOs;
    }

    void next() throws InterruptedException {
        Thread.sleep(30);
        
        
        System.out.println(this);

        System.out.println("------------------------------------");

        
        for (NextStateComputable o : uOs) {
            o.computeNextState();
        }
        for (NextStateComputable o : uOs) {
            o.assumeNextState();
        }
        
        
        

        time++;
        if (time > 50) {
//            s.x = 250;
//            s.y = 60;
//            s.dir = 2;
//            time = 0;
//            System.out.println("Restart");
//            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        
        for (NextStateComputable uO : uOs) {
            if (uO != null) {
                uO.paintComponent(g);
            }
        }
    }
    
    // print current state of all objects, not open Gestalts
    public String toString() {
        StringBuffer s = new StringBuffer();
        
        for (NextStateComputable o : uOs) {
            s.append(o + "\n");
        }
        return s.toString();
    }
    
}
