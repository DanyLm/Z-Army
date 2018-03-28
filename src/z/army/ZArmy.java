/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z.army;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DanyL
 */
public class ZArmy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inputText = new Scanner(System.in);
        Menu menu = new Menu();
        God god = new God();
        String nomPersonnage;
        String cible;
        boolean persoExist = false;
        Personnage monPerso = null;

        Personnage sorcier = new Guerrier();
        sorcier.setNomPersonnage("sorcier");
        Personnage mangeMort = new Guerrier();
        mangeMort.setNomPersonnage("mangemort");
        Personnage unMedecin = new Medecin();
        unMedecin.setNomPersonnage("medecin");
        Personnage unMoldu = new Civil();
        unMoldu.setNomPersonnage("moldu");

        List<Personnage> lesPersonnages = new ArrayList();
        lesPersonnages.add(sorcier);
        lesPersonnages.add(mangeMort);
        lesPersonnages.add(unMedecin);
        lesPersonnages.add(unMoldu);

        //choix du personnage
        do {
            menu.menu(lesPersonnages);//Appel de la methode menu dans l'objet menu
            System.out.print("\nQuel personnage voulez-vous êtres ? ");
            nomPersonnage = inputText.nextLine();

            for (Personnage unPersonnage : lesPersonnages) {
                if (nomPersonnage.toLowerCase().equals(unPersonnage.getNomPersonnage())) {
                    monPerso = unPersonnage;
                    persoExist = !persoExist;//Boolean vrai ou faux afin de sortir de la boucle
                }
            }
            if (!persoExist) {
                System.err.println("Ce personnage n'existe pas !");
            }

        } while (!persoExist);

        lesPersonnages.remove(monPerso);//Supprime un personnage de la liste choisi par l'utilisateur 

        while (true) {
            persoExist = true;

            //Si ma liste de personnage est vide = TOUT LES PERSONNAGES SONT MORTS
            if (lesPersonnages.isEmpty()) {
                System.out.print("Tous les personnages sont morts. Voulez-vous les ressucités ? (o/n) ");
                String yes_or_not = inputText.nextLine();

                switch (yes_or_not) {
                    case "o":
                        System.out.println("\nDieu a ressucité tous les personnages !");
                        lesPersonnages = god.resurrectAllPersonnage(god.getCimetiere().getLesPersonnagesInPeace());//Mon personnage Dieu va ressucité tous les personnages
                        //Il peut egalement chercher tous les personnages qui sont dans le cimetiere
                        break;
                    case "n":
                        exit(0);
                    default:
                        System.err.println("Je n'ai pas compris votre réponse.");
                        break;
                }
                
            //Sinon c'est qu'il y a au moins 1 personnage vivant    
            } else {
                menu.menu(lesPersonnages, god);//Menu qui affiche les personnage vivant et mort
                System.out.print("\nQui voulez-vous attaquer ? ");
                cible = inputText.nextLine();
                persoExist = menu.attaquerQuelPersonnage(lesPersonnages, monPerso, cible);//fonction qui permet de determiner quel personnage l'utilisateur a choisi d'attaquer
                // + retourne un boolean afin de savoir si le personnage choisi exist ou non
                lesPersonnages = god.isDeadOrAlive(lesPersonnages);//Me renvoie seulement la liste des personnages vivant et ceux qui sont mort sont jugé
                //par dieu et envoyé dans le cimetiere
            }

            if (!persoExist) {
                System.err.println("\nVeuillez choisir un personnage vivant");
            }
        }
    }
}
