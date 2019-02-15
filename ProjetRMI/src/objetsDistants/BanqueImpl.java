package objetsDistants;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Random;

import gestion.AccessToken;
import gestion.Banque;
import gestion.Compte;

public class BanqueImpl implements Banque{

	private int idToken_class=1;
	
	//private String nom="ma banque";
	private HashMap <Integer,Compte> comptes = new HashMap<Integer,Compte>();
	
	// dans register il faudra ensuite suprimer des 2 hasmap suivante les references
	
	
	private HashMap <Integer,Integer> token_compte = new HashMap<Integer,Integer>();
	private HashMap <Integer,Integer> token_banque = new HashMap<Integer,Integer>();

	
	@Override
	public AccessToken creerCompte(String nom, String prenom, double soldeInitial) {

		comptes.put(comptes.size()+1,new Compte());
		
		comptes.get(comptes.size()).setSolde(soldeInitial);
		comptes.get(comptes.size()).setNom(nom);
		comptes.get(comptes.size()).setPrenom(prenom);
		int compte_id = comptes.size();
		comptes.get(comptes.size()).setIdCompte(compte_id);
		

		Random rn = new Random();
		Integer banque_id = rn.nextInt();
		
		token_compte.put(idToken_class, compte_id);
		token_banque.put(idToken_class, banque_id);
		
		
		AccessToken a = new AccessToken(idToken_class, comptes.size(), banque_id);
		
		idToken_class++;
		
		return a;
	}
	
	@Override
	public Boolean depot(int idCompte, double montant, AccessToken token) {
		
		return (comptes.get(idCompte)).depot(idCompte, montant);
		
	}
	
	@Override
	public Boolean retrait(int idCompte, double montant, AccessToken token) {
		return (comptes.get(idCompte)).retrait(idCompte, montant);
	}
	
	@Override
	public Boolean virement(int idCompte, int idCompte2, double montant, AccessToken token) {
		
		(comptes.get(idCompte2)).depot(idCompte2, montant);
		return (comptes.get(idCompte)).retrait(idCompte, montant);
		
	}
	
	@Override
	public double getSolde(int idCompte, AccessToken token) {
		
		return (comptes.get(idCompte)).getSolde();
		
	}
	
	@Override
	public int registerToken(AccessToken token) {
		return token.getIdToken();
	}

}
