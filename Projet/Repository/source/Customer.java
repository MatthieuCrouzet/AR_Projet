
import java.rmi.RMISecurityManager;


public class Customer {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		System.setSecurityManager(new SecurityManager());
		LookForHotel lfh = new LookForHotel(args[0], Integer.parseInt(args[1]), args[2]);
		long duree = lfh.call();
		System.out.println("l'appel a duré " + duree + " millisecondes");
	}
}
