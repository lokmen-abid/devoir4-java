
package Exam;

public class Chalet {
    // Les Attributs de la classe Chalet :
    private String nom;
    private String ville;
    private String adresse;
    private int nombreDeChambres;
    private boolean estLoue;
    private Employe employeEntretien; 

    // Le Constructeur : 
    public Chalet(String nom, String ville, String adresse, int nombreDeChambres) {
        this.nom = nom;
        this.ville = ville;
        this.adresse = adresse;
        this.nombreDeChambres = nombreDeChambres;
        this.estLoue = false; // Valeur initiale, le chalet n'est pas loué lors de sa création
        this.employeEntretien = null; // Valeur initiale, aucun employé d'entretien n'est assigné
    }

    // Getters et setters pour chaque attribut : 
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNombreDeChambres() {
        return nombreDeChambres;
    }

    public void setNombreDeChambres(int nombreDeChambres) {
        this.nombreDeChambres = nombreDeChambres;
    }

    public boolean isEstLoue() {
        return estLoue;
    }

    public void setEstLoue(boolean estLoue) {
        this.estLoue = estLoue;
    }

    public Employe getEmployeEntretien() {
        return employeEntretien;
    }

    public void setEmployeEntretien(Employe employeEntretien) {
        this.employeEntretien = employeEntretien;
    }

    // Méthode pour afficher les informations du chalet
    public void afficherChalet() {
        System.out.println("Nom du chalet: " + nom);
        System.out.println("La Ville: " + ville);
        System.out.println("L'Adresse: " + adresse);
        System.out.println("Nombre de chambres: " + nombreDeChambres);
        System.out.println("Loué: " + (estLoue ? "Oui" : "Non"));
        if(employeEntretien != null) {
            System.out.println("L'Employé d'entretien assigné est : " + employeEntretien.getNom());
        } else {
            System.out.println("Aucun employé d'entretien assigné.");
        }
    }
}

