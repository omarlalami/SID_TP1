package serveur;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import calcul.CalculMathInterface;

public class ServeurCalcul {

	public ServeurCalcul() {
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			CalculMathInterfaceImpl instance = new CalculMathInterfaceImpl(); // on creer objet
			CalculMathInterface instance_adapte = (CalculMathInterface) UnicastRemoteObject.exportObject(instance,0);	// ici on creer genre lobjet distant

			Registry registre = LocateRegistry.getRegistry();	// on recupere le resgitre
			registre.bind("CalculMathObject",instance_adapte);	// on associe notre instante au nom CalculMathObject dans le registre
			
			System.err.println("serveur pret"); // sa nous met en rouge
			
		}
		catch(Exception e){
			e.getStackTrace();
		}
		
	}

}
