package calcul;

import java.rmi.*;

public interface CalculMathInterface extends Remote {
	public int additionner(int a, int b) throws RemoteException;
	public double diviser(int a, int b) throws RemoteException;
}
