/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comportement;

import java.util.ArrayList;
import java.util.List;
import z.army.Personnage;

/**
 *
 * @author DanyL
 */
public class Resurrect implements GodPower {

    // Fonction qui ressucite tout les personnages lorsqu'il sont tous mort
    public List<Personnage> resurrectAllPersonnage(List<Personnage> lesPersonnagesMorts, Cimetiere cimetiere) {
        List<Personnage> lesPersonnagesRessucite = new ArrayList(); //creer une liste (juste une listes) des personnage ressucité

        for (Personnage unPersonnage : lesPersonnagesMorts) {
            unPersonnage.setVie(unPersonnage.getMaxLife()); // Met la valeur maximal de vie a chacun des personnages
            lesPersonnagesRessucite.add(unPersonnage);
        }

        cimetiere.setLesPersonnagesInPeaceToNone(); // Je supprime la liste des personnages morts

        return lesPersonnagesRessucite;
    }
}
