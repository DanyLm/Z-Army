/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comportement;

/**
 *
 * @author DanyL
 */
public class AucunSoin implements Soin {
    
    public void soigne() {
        System.out.println("Je ne donne AUCUN soin !");
    }
    
    public int soigne(int vie, int maxLife){
        throw new UnsupportedOperationException("Ce personnage ne donne aucun soins");
    }
    
    public int opere(int vie, int maxLife){
        throw new UnsupportedOperationException("Ce personnage ne donne aucun soins intensif");
    }
}
