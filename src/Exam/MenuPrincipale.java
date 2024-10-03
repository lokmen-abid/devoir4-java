
package Exam;

import java.util.Scanner;

public class MenuPrincipale {
	
     private final GestionChalets gestionChalets ;// Instance de la classe GestionChalets
     private final MenuEmploye menuEmploye; // Instance de la classe MenuEmploye
     private final MenuProprietaire menuProp ;// Instance de la classe MenuProprietaire 
	 private Scanner scanner= new Scanner(System.in);
	 
	 // Le constructeur 
	 public MenuPrincipale() {
		 this.gestionChalets = new GestionChalets() ;
		 this.menuEmploye  = new MenuEmploye(gestionChalets) ;
		 this.menuProp = new MenuProprietaire(gestionChalets); 
	 }


	// methode pour afficher le menuPrincipale de tout le programme 
	   public void afficherMenuPrincipal() {
	        while (true) {
	            System.out.println("\nMenu Principal");
	            System.out.println("1. Menu employé");
	            System.out.println("2. Menu propriétaire");
	            System.out.println("3. Quitter");
	            System.out.print("Veuillez entrer votre choix : ");

	            int choix = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (choix) {
	                case 1:
	                    menuEmploye.afficherSousMenuEmploye();
	                    break;
	                case 2:
	                	menuProp.afficherSousMenuProp();
	                	break;
	                case 3:
	                    System.out.println("Au revoir !");
	                    return; 
	                default:
	                    System.out.println("Choix invalide, veuillez réessayer.");
	                    break;
	            }
	        }
	    }



	public static void main(String[] args) {
	
		MenuPrincipale menu = new MenuPrincipale();
	    menu.afficherMenuPrincipal();

	}

}
