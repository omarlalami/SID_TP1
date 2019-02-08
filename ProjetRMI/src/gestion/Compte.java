package gestion;

public class Compte {

	private static String nom;
	private static String prenom;
	private static int idCompte;
	private static double solde;
	
	public static String getNom() {
		return nom;
	}
	public static String getPrenom() {
		return prenom;
	}
	public static int getIdCompte() {
		return idCompte;
	}
	public static double getSolde() {
		return solde;
	}
	public static void setSolde(double solde) {
		Compte.solde = solde;
	}
	
	public Boolean depot(int idCompte, double montant) {
		
		if (getIdCompte()==idCompte)
			setSolde(getSolde()+montant);
		
		return true;		
	}

	public Boolean retrait(int idCompte, double montant) {
		
		if (getIdCompte()==idCompte)
			setSolde(getSolde()-montant);
		if(getSolde()<-100)
			return false;
		else
			return true;
		
	}
	
}
