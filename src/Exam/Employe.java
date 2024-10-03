
package Exam;

public class Employe implements Comparable<Employe> { 
	// Les Attributs de la classe Employe :
    private String nom;
    private String prenom;
    private int numeroIdentification;
    private double salaire;
    private String ville;
    private boolean[] disponibilites = new boolean[7]; // Disponibilités pour chaque jour de la semaine
    private Chalet[] chalets = new Chalet[5]; // Maximum de 5 chalets que l'employé peut entretenir

    // Le Constructeur :
    public Employe(String nom, String prenom, int numeroIdentification, double salaire, String ville) {
    	this.nom = nom;
    	this.prenom = prenom;
    	this.numeroIdentification = numeroIdentification;
    	this.salaire = salaire;
    	this.ville = ville;
      // Initialisation par défaut non disponible pour chaque jour 
    	for (int i = 0; i < disponibilites.length; i++) {
    		disponibilites[i] = false; 
    	}
    }

  // Getters et setters
    public String getNom() {
    	return nom;
    }

    public void setNom(String nom) {
    	this.nom = nom;
    }

    public String getPrenom() {
    	return prenom;
    }

    public void setPrenom(String prenom) {
    	this.prenom = prenom;
    }

    public int getNumeroIdentification() {
    	return numeroIdentification;
    }

    public void setNumeroIdentification(int numeroIdentification) {	
    	this.numeroIdentification = numeroIdentification;
    }

    public double getSalaire() {
    	return salaire;
    }

    public void setSalaire(double salaire) {
    	this.salaire = salaire;
    }

    public String getVille() {
    	return ville;
    }

    public void setVille(String ville) {
    	this.ville = ville;
    }

    public boolean[] getDisponibilites() {
    	return disponibilites;
    }

    public void setDisponibilite(int jour, boolean disponibilite) {
    	if (jour >= 0 && jour < 7) {
    		disponibilites[jour] = disponibilite;
    	}
    }

    public Chalet[] getChalets() {
    	return chalets;
    }

  // Méthode pour assigner un chalet à l'employé
    public void assigneChalet(Chalet chalet) {
    	for (int i = 0; i < chalets.length; i++) {
    		if (chalets[i] == null) {
    			chalets[i] = chalet;
    			break;
    		}
    	}
    }

  // Méthode pour afficher les informations de l'employé
    public void afficherEmploye() {
    	System.out.println("Nom: " + nom + " " + prenom);
    	System.out.println("Numéro d'identification: " + numeroIdentification);
      	System.out.println("Salaire: " + salaire);
      	System.out.println("Ville: " + ville);
      	System.out.println("Disponibilités:");
      	String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
      	for (int i = 0; i < disponibilites.length; i++) {
          	System.out.println(jours[i] + ": " + (disponibilites[i] ? "Disponible" : "Non disponible"));
      	}
  	}

  // la méthode compareTo pour comparer les employés selon leur salaire
  	public int compareTo(Employe autreEmploye) {
      	return Double.compare(this.salaire, autreEmploye.salaire);
  	}
}
