/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z.army;

import comportement.*;
import java.util.List;
import java.util.Random;

/**
 *
 * @author DanyL
 */
public class Menu {

    public void menu(List<Personnage> lesPersonnages) {
        System.out.println("############################");
        for (Personnage unPersonnage : lesPersonnages) {
            System.out.println(unPersonnage.getNomPersonnage() + " - " + unPersonnage.getVie() + " vie" + " | " + unPersonnage.getAtk() + " atk");
        }
        System.out.println("############################");
    }

    public void menu(List<Personnage> lesPersonnages, God god) {
        System.out.println("\n## Liste des perso vivant ##");
        System.out.println("############################");
        for (Personnage unPersonnage : lesPersonnages) {
            System.out.println(unPersonnage.getNomPersonnage() + " - " + unPersonnage.getVie() + " vie" + " | " + unPersonnage.getAtk() + " atk");
        }
        System.out.println("############################");

        System.out.println("## Liste des perso mort ##");
        System.out.println("##########################");

        for (Personnage unPersonnage : god.getCimetiere().getLesPersonnagesInPeace()) {
            System.out.println("## " + unPersonnage.getNomPersonnage());
        }
    }

    public boolean attaquerQuelPersonnage(List<Personnage> lesPersonnages, Personnage monPerso, String cible) {
        boolean persoExist = false;

        for (Personnage unPersonnage : lesPersonnages) {
            if (cible.equals(monPerso.getNomPersonnage())) {
                System.err.println("Vous ne pouvez pas attaquez votre propre personnage");
                persoExist = true;
                break;
            } else if (cible.equals(unPersonnage.getNomPersonnage())) {
                typeAtkunPerso(monPerso);
                monPerso.attaque(unPersonnage);
                persoExist = true;
                break;
            }
        }

        return persoExist;
    }
    
    // Change de maniere dynamique le type d'attaque qu'un personnage GUERRIER peut avoir
    private void typeAtkunPerso(Personnage unPerso) {
        Random rand = new Random();
        if (unPerso instanceof Guerrier) {
            int nb = rand.nextInt(3);
            switch (nb) {
                case (1):
                    unPerso.setEspritCombatif(new CombatCouteau());
                    System.out.println("Votre personnage attaque au COUTEAU");
                    break;
                case (2):
                    unPerso.setEspritCombatif(new CombatPistolet());
                    System.out.println("Votre personnage attaque au PISTOLET");
                    break;
                default:
                    unPerso.setEspritCombatif(new CombatSortilege());
                    System.out.println("Votre personnage lance des SORTILEGE");
                    break;
            }
        }
    } 
}
