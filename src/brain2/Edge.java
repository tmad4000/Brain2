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
public class Edge {
    double weight;
    Gestalt target;
    
    public Edge(double weight, Gestalt target) { 
        this.weight = weight;
        this.target = target;
                
    }
    
}
