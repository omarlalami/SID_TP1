package objetsDistants;

import java.util.HashMap;

import gestion.Banque;
import gestion.Compte;

public class BanqueImpl implements Banque{

	//private String nom="ma banque";
	private HashMap <Integer,Compte> comptes = new HashMap<Integer,Compte>();
	
	@Override
	public int creerCompte(String nom, String prenom, double soldeInitial) {

		comptes.put(comptes.size()+1,new Compte());
		
		comptes.get(comptes.size()).setSolde(soldeInitial);
		comptes.get(comptes.size()).setNom(nom);
		comptes.get(comptes.size()).setPrenom(prenom);
		comptes.get(comptes.size()).setIdCompte(comptes.size());
		
		return comptes.size();
	}
	
	@Override
	public Boolean depot(int idCompte, double montant) {
		
		return (comptes.get(idCompte)).depot(idCompte, montant);
		
	}
	
	@Override
	public Boolean retrait(int idCompte, double montant) {
		return (comptes.get(idCompte)).retrait(idCompte, montant);
	}
	
	@Override
	public Boolean virement(int idCompte, int idCompte2, double montant) {
		
		(comptes.get(idCompte2)).depot(idCompte2, montant);
		return (comptes.get(idCompte)).retrait(idCompte, montant);
		
	}
	
	@Override
	public double getSolde(int idCompte) {
		
		return (comptes.get(idCompte)).getSolde();
		
	}
	
}
