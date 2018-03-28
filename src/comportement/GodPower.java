/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comportement;

import java.util.List;
import z.army.Personnage;

/**
 *
 * @author DanyL
 */
public interface GodPower {
    public List<Personnage> resurrectAllPersonnage(List<Personnage> lesPersonnagesMorts, Cimetiere cimetiere);
}
