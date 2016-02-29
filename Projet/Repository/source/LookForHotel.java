import java.util.HashMap;

/**
 * J<i>ava</i> U<i>tilities</i> for S<i>tudents</i>
 */
import java.util.*;
/**
 * Représente un client effectuant une requête lui permettant d'obtenir les numéros de téléphone des hÃ´tels répondant Ã  son critère de choix.
 * @author  Morat
 */
public class LookForHotel{
	/** le critère de localisaton choisi */
	private String localisation;
	private AbstractList<Numero> ListeNum;
	// ...
	/**
	 * Définition de l'objet représentant l'interrogation.
	 * @param args les arguments n'en comportant qu'un seul qui indique le critère
	 *          de localisation
	 */
	public LookForHotel(String... args){
		localisation = args[0];
	}
	/**
	 * réalise une interrogation
	 * @return la durée de l'interrogation
	 * @throws RemoteException
	 */
	public long call() {
		long time = System.currentTimeMillis();
		// ...
		return System.currentTimeMillis()-time;
	}

	// ...
}
