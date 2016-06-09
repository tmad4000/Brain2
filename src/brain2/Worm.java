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
    double x = 5;
    double y = 5;
    
    double bloodSugar = 27.1, nextBloodSugar;
    
    @Override
    public void computeNextState() {
        nextBloodSugar=bloodSugar-.05;
    }
        
    @Override
    public void assumeNextState() {
        bloodSugar=nextBloodSugar;
    }
    
    public String toString() {
        return "Worm (" + String.format("%.2f",x) + ", " + String.format("%.2f",y) + ") bloodSugar: " + String.format("%.2f",bloodSugar)  ;
    }
    
}
