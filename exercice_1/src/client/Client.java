package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import calcul.CalculMathInterface;

public class Client {

	public Client() {
		
	}
	
	public static void main(String[] args) {
		
		Registry registre;
		
		try {
			
			registre = LocateRegistry.getRegistry();
			// on recupere le registre
			
			CalculMathInterface instance_adapte = (CalculMathInterface) registre.lookup("CalculMathObject");
			//on recupere notre objet distant, mais il est pas en local, on le recupere mais a distance ...
			
			System.out.println("l'addition de 3 & 4 donne : " + instance_adapte.additionner(3, 4));
			System.out.println("la division de 5 & 2 donne : " + instance_adapte.diviser(5, 2));
			System.out.println("la division de 5 & 0 donne : " + instance_adapte.diviser(5, 0));

		}
		catch(Exception e){
			e.getStackTrace();
		}
	}

}
