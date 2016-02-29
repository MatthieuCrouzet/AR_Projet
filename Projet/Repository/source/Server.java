
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.rmi.RemoteException;
import java.io.File;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;


public class Server {
  /**
   * @param args
 * @throws ParserConfigurationException 
 * @throws IOException 
 * @throws SAXException 
   */
  public static void main(final String args[]) throws ParserConfigurationException, SAXException, IOException {
    int port = 1099;
    String name = "";
    String localisation = "";
    List<Hotel> hotels = new ArrayList<Hotel>();
    Registry registry=null;
    // récupération des arguments
    if (args.length!=1){
      System.out.println("Server <port du registry> <nom générique du fichier xml>");
      System.exit(1);
    }
    try  {
      port = Integer.parseInt(args[0]);
      name = args[1];
    }catch(Exception e) {
      System.out.println("Server <port du registry> <nom générique du fichier xml>");
      System.exit(1);
    }
    // installation d'un securityManager
    // A COMPLETER : INSTALLATION D'UN SECURITYMANAGER
//    if(System.getSecurityManager()==null){
    	System.setSecurityManager(new SecurityManager());
  //  }
   
    // A COMPLETER : MISE EN PLACE DU REGISTRY
    try {
		registry = LocateRegistry.createRegistry(port);
	} catch (RemoteException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	
    try {
      	// A COMPLETER : CONSTRUCTION ET EXPORTATION DES OBJETS DISTANTS
    	
    	
	    System.out.println("Tous les objets sont enregistrés dans le serveur d'objets distants");
    } catch (Exception e) {
      System.out.println("Server err: " + e);
    }
  }
}
