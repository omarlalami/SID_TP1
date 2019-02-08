package gestion;

public interface Banque {
	
	public int creerCompte(String nom, String prenom, double soldeInitial);
	public Boolean depot(int idCompte, double montant);
	public Boolean retrait(int idCompte, double montant);
	public Boolean virement(int idCompte, int idCompte2, double montant);
	public double getSolde(int idCompte);
	
}
