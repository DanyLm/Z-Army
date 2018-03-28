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
public interface EspritCombatif {
    int estAttaquer(Personnage unAttaquant, Personnage unDefenseur);
}
