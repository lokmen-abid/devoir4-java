
package Exam;
import java.util.Scanner;
import java.util.ArrayList;

public class GestionChalets {
	// Les Attributs de la classe GestionChalets :
    private Chalet[] chalets;
    private Employe[] employes;
    private int nombreDeChalets;
    private int nombreDEmployes;
    private Scanner scanner;

    // Le Constructeur
    public GestionChalets() {
        chalets = new Chalet[15]; // Taille initiale 15 ( on peut ajouter selon les besoins) 
        employes = new Employe[15]; // Taille initiale 15 ( on peut ajouter selon les besoins) 
        nombreDeChalets = 0;
        nombreDEmployes = 0;
        scanner = new Scanner(System.in);
    }

    public int getNombreDeChalets() {
		return nombreDeChalets;
	}

	public void setNombreDeChalets(int nombreDeChalets) {
		this.nombreDeChalets = nombreDeChalets;
	}


	public int getNombreDEmployes() {
		return nombreDEmployes;
	}

	public void setNombreDEmployes(int nombreDEmployes) {
		this.nombreDEmployes = nombreDEmployes;
	}


	// Ajouter un chalet
    public void ajouterChalet() {
    	// verification sur la taille de liste des chalets 
        if (nombreDeChalets >= chalets.length) {
            System.out.println("Limite de chalets atteinte.");
            return;
        }
        System.out.println("Entrez le nom du chalet:");
        String nom = scanner.nextLine();
        System.out.println("Entrez la ville:");
        String ville = scanner.nextLine();
        System.out.println("Entrez l'adresse:");
        String adresse = scanner.nextLine();
        System.out.println("Entrez le nombre de chambres:");
        int nombreDeChambres = scanner.nextInt();
        scanner.nextLine(); 

        chalets[nombreDeChalets++] = new Chalet(nom, ville, adresse, nombreDeChambres);
        System.out.println("Chalet ajouté avec succès.");
    }

    // Ajouter un employé
    public void ajouterEmploye() {
    	// verification sur la taille de liste des Employes
        if (nombreDEmployes >= employes.length) {
            System.out.println("Limite d'employés atteinte.");
            return;
        }

        System.out.println("Entrez le prénom de l'employé:");
        String prenom = scanner.nextLine();
        System.out.println("Entrez le nom de l'employé:");
        String nom = scanner.nextLine();
        int id;
        do {
            System.out.println("Entrez le numéro d'identification (6 chiffres):");
            id = scanner.nextInt();
        } while (!verifierID(id));
        System.out.println("Entrez le salaire:");
        double salaire = scanner.nextDouble();
        System.out.println("Entrez la ville:");
        scanner.nextLine(); 
        String ville = scanner.nextLine();

        employes[nombreDEmployes++] = new Employe(nom, prenom, id, salaire, ville);
        System.out.println("Employé ajouté avec succès.");
    }
    
    // methode pour verifier que le numéro d'identification a 6 chiffres : 
    public boolean verifierID(int id) {
    	String id_string = String.valueOf(id); 
    	if (id_string.length() != 6) {
    	    System.out.println("Le numéro d'identification doit contenir 6 chiffres.");
    	    return false;
    	}
    	return true;
    }

    // méthode d'affichage des chalets 
    public void afficherChalets() {
        for (int i = 0; i < nombreDeChalets; i++) {
            chalets[i].afficherChalet();
            System.out.println(" ");
        }
    }

    // méthode d'affichage des Employes
    public void afficherEmployes() {
        for (int i = 0; i < nombreDEmployes; i++) {
            employes[i].afficherEmploye();
            System.out.println(" ");
        }
    }

    // méthode pour trouver un employe specifique selon le numero de identification 
    public Employe trouverEmployeParID(int numeroID) {
       for (Employe employe : employes) {
    	   // on vérifie c'est le numerID passer dans paramètres est pour un des employes par 
    	   // parcourir la liste des employes et vérifier un par un 
          if (employe != null && employe.getNumeroIdentification() == numeroID) {
              return employe;
          }
       }
       return null; // Retourner null si aucun employé avec cet ID n'a été trouvé
    }
    
    // methode pour supprimer un employe selon son numero d'identification
    public void supprimerEmploye(int numeroID) {
    	for (Employe employe : employes) {
            if (employe != null && employe.getNumeroIdentification() == numeroID) {
            	employe=null; 
            }
         }
    	System.out.println("ce employe n'existe pas");
    }
    
    // methode pour supprimer un chalet selon son nom 
    public void supprimerChalet(String nom) {
    	for (Chalet chalet : chalets) {
    		if (chalet != null && chalet.getNom()==nom) {
    			chalet =null;
    		}
    	}
    	System.out.println("ce chalet n'existe pas");
    }


}
