package objetsDistants;

import java.util.HashMap;
import java.util.Random;

import gestion.AccessToken;
import gestion.AuthentificationServeur;
import gestion.Banque;
import gestion.Compte;

public class BanqueImpl implements Banque{

	private int idToken_class=1;
	private AuthentificationServeur authServeur;
	
	//private String nom="ma banque";
	private HashMap <Integer,Compte> comptes = new HashMap<Integer,Compte>();
	
	// dans register il faudra ensuite suprimer des 2 hasmap suivante les references	
	private HashMap <Integer,Integer> token_compte = new HashMap<Integer,Integer>();
	private HashMap <Integer,Integer> token_banque = new HashMap<Integer,Integer>();

	
	@Override
	public AccessToken creerCompte(String nom, String prenom, double soldeInitial) {
		
		int compte_id = comptes.size()+1;

		comptes.put(comptes.size(),new Compte());
		
		comptes.get(compte_id).setSolde(soldeInitial);
		comptes.get(compte_id).setNom(nom);
		comptes.get(compte_id).setPrenom(prenom);
		comptes.get(compte_id).setIdCompte(compte_id);
		

		Random rn = new Random();
		Integer banque_id = rn.nextInt();
		
		token_compte.put(idToken_class, compte_id);
		token_banque.put(idToken_class, banque_id);
		
		
		AccessToken a = new AccessToken(idToken_class, compte_id, banque_id);
		
		idToken_class++;
		
		authServeur = new AuthentificationServeurImpl();
		
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
		
		int id_token = token.getIdToken();
		int id_compte;
		 // on verifie que ce token existe
		if(token_compte.get(id_token)!=null && token_banque.get(id_token)!=null)
		{
			// on verifie que c'est le bon id_banque
			if ( token.validateCleBanque(token_banque.get(id_token)))
			{
				try {// on enregistre sur authServeur et on vide nos hashmap !
					id_compte=token_compte.get(token);
					authServeur.link(id_compte,token);
					token_compte.remove(id_token);
					token_banque.remove(id_token);
				}catch(Exception e){
					e.printStackTrace();
				}

			}
			
		}
		else
		{
			System.out.println("tentative de hack ! on quitte le serveur");
			System.exit(-1);

		}
		
		return id_compte;
		//return token.getIdToken();
	}

}
