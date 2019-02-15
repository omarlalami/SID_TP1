package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import gestion.Banque;

public class Client {
	
	public Client() {
		
	}
	public static void main(String[] args) {
		
		Registry registre;
		
		try {
			
			registre = LocateRegistry.getRegistry();
			// on recupere le registre
/*
			Banque instance_adapte = (Banque) registre.lookup("AccesBanqueDistance");
			System.out.println("creation 1er compte : " + instance_adapte.creerCompte("nom_1", "prenom_1", 2000));
			System.out.println("solde actuel : " + instance_adapte.getSolde(1));
			instance_adapte.depot(1, 200);
			System.out.println("solde actuel : " + instance_adapte.getSolde(1));
*/
			
			
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
}
