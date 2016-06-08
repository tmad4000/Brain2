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
class Room implements NextStateComputable {
    double temp = 68, nextTemp;
    
    public String toString() {
        return String.valueOf(temp);
    }


    @Override
    public void computeNextState() {
        nextTemp= temp > 58 ? temp-.1 : temp+.1;
    }
    
    @Override
    public void assumeNextState() {
        temp=nextTemp;
    }

    
    
}
