package server;

import java.rmi.registry.*;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import java.rmi.RemoteException;
import java.io.IOException;

public class Server {
	
    static Registry registry;
	
/**
   * @param args
 * @throws ParserConfigurationException 
 * @throws IOException 
 * @throws SAXException 
   */
  public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
    int port = 1099;
    registry = null;
    
    // recuperation des arguments
    if (args.length >= 1){
    	try  {
	      port = Integer.parseInt(args[0]);
	    }catch(Exception e) {
	      System.out.println("Exception: " + e.getMessage());
	      System.out.println("Server [port]");
	      System.exit(1);
	    }
    }
    // installation d'un securityManager
    // A COMPLETER : INSTALLATION D'UN SECURITYMANAGER
//    if(System.getSecurityManager()==null){
    	//System.setSecurityManager(new SecurityManager());
  //  }
   
    // A COMPLETER : MISE EN PLACE DU REGISTRY
    try {
		registry = LocateRegistry.createRegistry(port);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	
    try {
      	// A COMPLETER : CONSTRUCTION ET EXPORTATION DES OBJETS DISTANTS
    	for(int i = 0; i < DataStore.NUM_CHAINES; i++){
    		Chaine chaine = new Chaine(DataStore.FILES[i + 1]);
        	registry.rebind("Chaine" + i, chaine);
    	}
    	Annuaire annuaire = new Annuaire(DataStore.FILES[0]);
		registry.rebind("Annuaire", annuaire);
    	System.out.println("Tous les objets sont enregistrés dans le serveur d'objets distants");
    } catch (Exception e) {
      System.out.println("Server err: " + e);
    }
  }
}
