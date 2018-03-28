/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z.army;
import comportement.*;

/**
 *
 * @author DanyL
 */
public class Guerrier extends Personnage {	
    public Guerrier(){
        this.espritCombatif = new CombatPistolet();
        this.vie = 120;
        this.maxLife = 120;
        this.atk = 70;
    }
    public Guerrier(EspritCombatif esprit, Soin soin, Deplacement dep, String name, int vie, int atk, int maxLife) {
        super(esprit, soin, dep, name, vie, atk, maxLife);
        
    }
}
