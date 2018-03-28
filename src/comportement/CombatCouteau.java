/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comportement;
import z.army.Personnage;

/**
 *
 * @author DanyL
 */
public class CombatCouteau implements EspritCombatif {	
    
    public int estAttaquer(Personnage unAttaquant, Personnage unDefenseur){
        System.out.println(unAttaquant.getNomPersonnage() + " lance des coup de couteau à " + unDefenseur.getNomPersonnage() + "\n");
        int pAtk = unAttaquant.getAtk();
        int newPointVie = unDefenseur.getVie()-pAtk/2;
        unAttaquant.setAtk(pAtk+10);
        System.out.println("Nouveau point d'attaque de " + unAttaquant.getNomPersonnage() + " -> " + unAttaquant.getAtk());
        return newPointVie;
    }

}