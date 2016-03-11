/**
 * J<i>ava</i> U<i>tilities</i> for S<i>tudents</i>
 */
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
/**
 * Représente un client effectuant une requête lui permettant d'obtenir les numéros de téléphone des hÃ´tels répondant Ã  son critère de choix.
 * @author  Morat
 */
public class LookForHotel{
	/** le critère de localisaton choisi */
	private String localisation;
	private String ou;
	private int nb_chaine;
	private AbstractList<Numero> ListeNum;
	// ...
	/**
	 * Définition de l'objet représentant l'interrogation.
	 * @param args les arguments n'en comportant qu'un seul qui indique le critère
	 *          de localisation
	 */
	public LookForHotel(String localisation, int nb_chaine, String ou){
		this.localisation = localisation;
		this.nb_chaine = nb_chaine;
		this.ou = ou;
	}
	/**
	 * réalise une interrogation
	 * @return la durée de l'interrogation
	 * @throws RemoteException
	 */
	public long call() {
		long time = System.currentTimeMillis();
		Registry registry;
		Annuaire annuaire;
		try {
			registry = LocateRegistry.getRegistry(ou);
			annuaire = (Annuaire) registry.lookup("Annuaire");
			for(int i=1; i<=nb_chaine; i++){
				List<Hotel> hotels;
				List<String> hotels_name = null;
				Chaine chaine = (Chaine) registry.lookup("Hotels"+i);
				hotels = chaine.get(localisation);
				for(int i1=0; i1< hotels.size(); i1++){
					hotels_name.add(hotels.get(i1).getName());
				}
				for(int i1=0; i1< hotels_name.size(); i1++){
					ListeNum.add(annuaire.get(hotels_name.get(i1)));
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Voici tous les numéros situé à " + localisation);
		ListeNum.toString();
		return System.currentTimeMillis()-time;
	}

	// ...
}
