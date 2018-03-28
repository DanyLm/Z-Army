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
public class Cimetiere {

    private List<Personnage> lesPersonnagesInPeace;

    public Cimetiere() {
        this.lesPersonnagesInPeace = new ArrayList(); //Ma liste des personnages en paix
    }

    public List<Personnage> getLesPersonnagesInPeace() {
        return lesPersonnagesInPeace;
    }
 
    public void setLesPersonnagesInPeaceToNone() {
        this.lesPersonnagesInPeace.removeAll(lesPersonnagesInPeace); //Supprime tous les personnages de la liste
    }
}
