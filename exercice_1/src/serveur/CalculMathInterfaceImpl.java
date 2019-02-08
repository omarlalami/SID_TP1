package serveur;

import java.rmi.RemoteException;

import calcul.CalculMathInterface;

public class CalculMathInterfaceImpl implements CalculMathInterface{

	@Override
	public int additionner(int a, int b) throws RemoteException {
		return a+b;
	}

	@Override
	public double diviser(int a, int b) throws RemoteException {
		return b!=0?((double)a)/b:0; // a adapter je pense
	}

}
