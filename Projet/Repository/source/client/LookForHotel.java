package client;
/**
 * J<i>ava</i> U<i>tilities</i> for S<i>tudents</i>
 */

import java.rmi.Naming;
import java.util.*;
import server._Annuaire;
import server._Chaine;
import server.DataStore;
import server.Hotel;
import server.Numero;

/**
 * Represente un client effectuant une requete lui permettant d'obtenir les numeros de telephone des hôtels repondant à son crit�re de choix.
 * @author  Morat
 */
public class LookForHotel{
	/** le critere de localisaton choisi */
	private String localisation;
	private List<Numero> ListeNum;
	// ...
	/**
	 * Definition de l'objet representant l'interrogation.
	 * @param args les arguments n'en comportant qu'un seul qui indique le critere
	 *          de localisation
	 */
	public LookForHotel(String localisation){
		this.localisation = localisation;
	}
	/**
	 * realise une interrogation
	 * @return la duree de l'interrogation
	 */
	public long call() {
		long time = System.currentTimeMillis();
		//Registry registry;
		
		ListeNum = new ArrayList<>();
		
		_Annuaire annuaire;
		try {
			//registry = LocateRegistry.getRegistry(1099);
			annuaire = (_Annuaire) Naming.lookup("//localhost:1099/Annuaire");
			for(int i = 0; i < DataStore.NUM_CHAINES; i++){
				List<Hotel> hotels;
				List<String> hotels_name = new ArrayList<String>();
				_Chaine chaine = (_Chaine)Naming.lookup("//localhost:1099/Chaine" + i);
				hotels = chaine.get(localisation);
				for(Hotel hotel : hotels){
					hotels_name.add(hotel.getName());
				}
				for(String str : hotels_name){
					System.out.println("Searching in annuaire: " + str);
					ListeNum.add(annuaire.get(str));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Voici tous les numeros situe a " + localisation);
		for(Numero num : ListeNum){
			System.out.println(num.toString());
		}
		return System.currentTimeMillis()-time;
	}

	// ...
}
