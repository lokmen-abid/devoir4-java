/*Devoir 4 OOP 
 * Lokmen Abid  */
package Exam;

import java.util.Scanner;

public class MenuProprietaire {
	 private final GestionChalets gestionChalets;// Instance de la classe GestionChalets
	 private Scanner scanner= new Scanner(System.in);
     private final String correct_mot_passe="chaletsTroisRivieres24";

    // Le Constructeur
	public MenuProprietaire(GestionChalets gestionChalets) {
		this.gestionChalets = gestionChalets;
	} 
	 
	// methode pour afficher le sous-menu d'employe et les choix qui peut l'utilisateur saisie 
	public void afficherSousMenuProp() {
        System.out.print("Veuillez entrer le mot de passe : ");
        String mot_passe = scanner.nextLine();
        
        if (!mot_passe.equals(correct_mot_passe) ) {
            System.out.println("Vous n'avez pas le droit d'acceder !");
            return;
        }

        boolean continuer = true;
        while (continuer) {
            System.out.println("\nSous-menu Proprietaire - Choisissez une option:");
            System.out.println("1. Afficher la liste de ses employés avec leurs caractéristiques");
            System.out.println("2. Afficher la liste de ses chalets avec leurs caractéristiques");
            System.out.println("3. Afficher le nombre d’employés");
            System.out.println("4. Afficher le nombre de chalets ");
            System.out.println("5. Gérer les employés (ajout)");
            System.out.println("6. Gérer les employés (suppression)");
            System.out.println("7. Gérer les chalets (ajout) ");
            System.out.println("8. Gérer les chalets (suppression) ");
            System.out.println("9. Modifier le salaire d’un employé  ");
            System.out.println("10. Comparer deux employés selon leurs salaires ");
            System.out.println("11. Afficher les disponibilités d’un employé ");
            System.out.println("12. Afficher les chalets associés à un employé  ");
            System.out.println("13. Gérer les chalets associés aux employés (ajout et suppression)");
            System.out.println("14. Mettre un chalet en location ou libre pour la location");
            System.out.println("15. Sortie (retour au menu précédent)");

            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
            		gestionChalets.afficherEmployes();
                    break;
                case 2:
            		gestionChalets.afficherChalets();
                    break;
                case 3:
                    gestionChalets.getNombreDEmployes();   
                    break;
                case 4:
                	gestionChalets.getNombreDeChalets();
                    break;
                case 5:
                    gestionChalets.ajouterEmploye();
                    break;
                case 6:
                	supprimerEmploye();
                	break;
                case 7:
                    gestionChalets.afficherChalets();;
                    break;
                case 8:
                	supprimerChalet();
                    break;
                case 9:
                	modifierSalaireEmploye();
                    break;
                case 10:
                	comparerSalaireEmploye();
                    break;
                case 11:
                    afficherDispoEmploye();
                    break;
                case 12:
                	chaletAssocieEmploye();
                    break;
                case 13:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        }
    }
	

	//methode pour supprimer employe 
	private void supprimerEmploye() {
		System.out.println("Veuillez entrer votre numéro unique d'identification : ");
		int id = scanner.nextInt();
		gestionChalets.supprimerEmploye(id);
	}
	
	//methode pour supprimer chalet 
	private void supprimerChalet() {
		System.out.println("Veuillez entrer votre Le Nom de chalet : ");
		String nom = scanner.nextLine();
		gestionChalets.supprimerChalet(nom);
	}
	
	// methode pour modifier le salaire d'employe 
	private void modifierSalaireEmploye() {
		// on demande de proprietaire de saisie le numero d'idientifcation d'employe qui veut modifier son salaire 
		System.out.println("Veuillez entrer votre numéro unique d'identification : ");
		int id = scanner.nextInt();
		Employe emp = gestionChalets.trouverEmployeParID(id);
		System.out.println("Saisie le nouveau salaire pour ce employe: ");
		Double salaire = scanner.nextDouble(); 
		emp.setSalaire(salaire);
	}
	
	
	// methode pour comparer salaire de deux employe 
	// on demande de proprietaire de saisie 2 numero d'identification pour les employes qui veut le comparer 
	private void comparerSalaireEmploye() {
		System.out.println("Veuillez entrer votre numéro unique d'identification pour employe 1 : ");
		int id1 = scanner.nextInt();
		System.out.println("Veuillez entrer votre numéro unique d'identification pour employe 2 : ");
		int id2 = scanner.nextInt();
		
		Employe emp1 = gestionChalets.trouverEmployeParID(id1);
		Employe emp2 = gestionChalets.trouverEmployeParID(id2);
		
		if(emp1.getSalaire()>emp2.getSalaire())
			System.out.println("l'employe "+emp1.getNom()+"a un salaire elevée que le employe "+emp2.getNom());
		else 
			System.out.println("l'employe "+emp2.getNom()+"a un salaire elevée que le employe "+emp1.getNom());

	}
	
	//methode pour afficher le disponibilite d'un employe selon son numero d'identification 
	private void afficherDispoEmploye() {
		System.out.println("Veuillez entrer votre numéro unique d'identification : ");
		int id = scanner.nextInt();
		Employe emp = gestionChalets.trouverEmployeParID(id);
		System.out.println("Ses disponibilités :");
	    String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
	    for (int i = 0; i < jours.length; i++) {
	       System.out.println(jours[i] + ": " + (emp.getDisponibilites()[i] ? "Disponible" : "Non disponible"));
	    }
		
	}
	
	// methode pour afficher les chalets associees pour un employe
	private void chaletAssocieEmploye () {
		System.out.println("Veuillez entrer votre numéro unique d'identification : ");
		int id = scanner.nextInt();
		Employe emp = gestionChalets.trouverEmployeParID(id);
		System.out.println("Les chalets qui ils ont été associés :");
    	boolean hasChalets = false;
    	for (Chalet chalet : emp.getChalets()) {
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
