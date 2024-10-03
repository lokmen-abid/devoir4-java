
package Exam;

import java.util.Scanner;

public class MenuEmploye {
    private final GestionChalets gestionChalets; // Instance de la classe GestionChalets
    private Scanner scanner= new Scanner(System.in);

    //Le constructeur
    public MenuEmploye(GestionChalets gestionChalets) {
        this.gestionChalets = gestionChalets;
    }

    // Méthode pour afficher le sous-menu de l'employé
    public void afficherSousMenuEmploye() {
        System.out.print("Veuillez entrer votre numéro unique d'identification : ");
        int numeroID = scanner.nextInt();
        scanner.nextLine(); 

        Employe employe = gestionChalets.trouverEmployeParID(numeroID);
        if (employe == null) {
            System.out.println("Aucun employé trouvé avec ce numéro d'identification.");
            return;
        }

        boolean continuer = true;
        while (continuer) {
            System.out.println("\nSous-menu Employé - Choisissez une option:");
            System.out.println("1. Voir mes disponibilités");
            System.out.println("2. Modifier ma disponibilité pour une journée");
            System.out.println("3. Consulter les chalets qui m'ont été associés");
            System.out.println("4. Voir mon salaire");
            System.out.println("5. Sortie (retour au menu précédent)");

            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    afficherDisponibilites(employe);
                    break;
                case 2:
                    modifierDisponibilite(employe);
                    break;
                case 3:
                    consulterChaletsAssocies(employe);
                    break;
                case 4:
                    System.out.println("Votre salaire est de : " + employe.getSalaire() + "$");
                    break;
                case 5:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        }
    }

   // Méthode privée pour afficher les disponibilités de l'employé
   private void afficherDisponibilites(Employe employe) {
     System.out.println("Vos disponibilités :");
     String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
     for (int i = 0; i < jours.length; i++) {
        System.out.println(jours[i] + ": " + (employe.getDisponibilites()[i] ? "Disponible" : "Non disponible"));
    }
   }

   // Méthode privée pour modifier la disponibilité de l'employé pour une journée
    private void modifierDisponibilite(Employe employe) {
    	System.out.println("Quel jour souhaitez-vous modifier ?");
    	String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
    	for (int i = 0; i < jours.length; i++) {
    		System.out.println((i + 1) + ". " + jours[i]);
    	}
    	int jourChoisi = scanner.nextInt();
    
    	if (jourChoisi < 1 || jourChoisi > 7) {
    		System.out.println("Choix invalide.");
        	return;
    	}
    
    	System.out.println("Entrez votre nouvelle disponibilité pour " + jours[jourChoisi - 1] + " (1 pour disponible, 0 pour non disponible) :");
    	int disponibilite = scanner.nextInt();
    	scanner.nextLine();
    
    	employe.getDisponibilites()[jourChoisi - 1] = disponibilite == 1;
    		System.out.println("Votre disponibilité a été mise à jour.");
    	}

    // Méthode privée pour consulter les chalets associés à l'employé
    private void consulterChaletsAssocies(Employe employe) {
    	System.out.println("Les chalets qui vous ont été associés :");
    	boolean hasChalets = false;
    	for (Chalet chalet : employe.getChalets()) {
    		if (chalet != null) {
    			System.out.println("Chalet : " + chalet.getNom() + ", Adresse : " + chalet.getAdresse());
    			hasChalets = true;
    		}
    	}
    	if (!hasChalets) {
    		System.out.println("Aucun chalet ne vous a été associé.");
    	}
    	}

}
