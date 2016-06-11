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


abstract class UniverseObject implements NextStateComputable {

    double  x;
    double  y;
    double  dir; //dir is 0 1 2 3 clockwise from top
    double v;
    Color color;

    /**
     *
     * @return 0-3 starting up going clockwise
     */
    public double[] dirXY() {
        double[] o = {Math.cos(dir*2*Math.PI/360),Math.sin(dir*2*Math.PI/360)};
        return o;
    }

}

class Path extends UniverseObject {

    //not really "UniverseObject" just want the methods

    double  x2;
    double  y2;

    public Path(double  x1, double  y1, double  x2, double  y2) {
        this.x = x1;
        this.y = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = Color.RED;
    }
    
    public Path(double  x1, double  y1, double  x2, double  y2, double  dir) {
        this.x = x1;
        this.y = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.dir = dir;
        this.color = Color.RED;
    }

    public boolean crosses(Path w) {
        return Line2D.linesIntersect(x, y, x2, y2, w.x, w.y, w.x2, w.y2);
//        
//        //assuming rectilinear now
//        //System.out.println("dir" + Arrays.toString(dirXY())+Arrays.toString(w.dirXY()));
//        if (dirXY()[0] != 0) {
//            //this is horiz path
//            if (w.dirXY()[1] != 0) {
//                if (w.x >= Math.min(this.x, this.x2) && w.x <= Math.max(this.x, this.x2)) {
//                    if (this.y >= Math.min(w.y, w.y2) && this.y <= Math.max(w.y, w.y2)) {
//                        return true;
//                    } else {
//                        return false;
//                    }
//                } else {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        } else if (dirXY()[1] != 0) {
//            //this is vert path
//            if (w.dirXY()[0] != 0) {
//                if (w.y >= Math.min(this.y, this.y2) && w.y <= Math.max(this.y, this.y2)) {
//                    if (this.x >= Math.min(w.x, w.x2) && this.x <= Math.max(w.x, w.x2)) {
//                        return true;
//                    } else {
//                        return false;
//                    }
//                } else {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        }
//        return true;
//        //           else {
//        //                throw new RuntimeException("Wall not rectilinear");
//        //            }
//        // old:
//        //y=m1 x + b1
//        // y=m2 x + b2
//        // -(b1-b2)/(m1-m2) = x
    }

    public void paintComponent(Graphics g) {
        g.setColor(this.color);
        g.drawLine((int)x, (int)y, (int)x2, (int)y2);
    }

    public String toString() {
        return "((" + x + "," + y + "),(" + x2 + "," + y2 + "))";
    }

    @Override
    public void assumeNextState() {
    }

    @Override
    public void computeNextState() {
    }

}


/**
 *
 * @author Jacob-MTech
 */
class Wall extends Path {

    double  len;

    public Wall(double  x, double  y, double  dir, double  len) {
        super(x, y, 0, 0, dir); //#hack
        this.len = len;
        this.x2 = x + dirXY()[0] * len;
        this.y2 = y + dirXY()[1] * len;
        this.color = Color.BLACK;
    }

}