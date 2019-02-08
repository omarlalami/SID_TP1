package objetsDistants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import gestion.Banque;
import gestion.Compte;

public class BanqueImpl implements Banque{

	private String nom;
	private HashMap <Integer,Compte> comptes = new HashMap<Integer,Compte>();
	
	@Override
	public int creerCompte(String nom, String prenom, double soldeInitial) {

		return 0;
	}
	@Override
	public Boolean depot(int idCompte, double montant) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean retrait(int idCompte, double montant) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean virement(int idCompte, int idCompte2, double montant) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getSolde(int idCompte) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
	
	
}
