/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain2;

import java.awt.Graphics;

/**
 *
 * @author jacobcole
 */
public interface NextStateComputable {

    public void assumeNextState();

    public void computeNextState();
    
    public void paintComponent(Graphics g);

    
}
