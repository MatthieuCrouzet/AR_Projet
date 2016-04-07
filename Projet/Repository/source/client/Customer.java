package client;

public class Customer {
	/**
	 * @param args
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 */
	public static void main(String args[]) {
		//System.setSecurityManager(new SecurityManager());
		LookForHotel lfh = new LookForHotel(args[0]); //args[0] == localisation
		long duree = lfh.call();		
		System.out.println("Temps total de communication : " + duree + " ms");		
	}
}
