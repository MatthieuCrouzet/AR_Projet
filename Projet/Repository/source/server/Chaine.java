package server;
import java.io.File;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Chaine extends UnicastRemoteObject implements _Chaine {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5811513675724676398L;
	private String name;
	private List<Hotel> hotels;
	
	public Chaine(String filename) throws SAXException, IOException, ParserConfigurationException {
		this.name = filename;
		String path = "Repository/DataStore/" + filename;
		
		/* récupération des hôtels de la chaîne dans le fichier xml passé en 1er argument */
		DocumentBuilder docBuilder = null;
		Document doc = null;
		docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		doc = docBuilder.parse(new File(path));
		
		hotels = new ArrayList<Hotel>();
		
		String name, localisation;
		NodeList list = doc.getElementsByTagName("Hotel");
		NamedNodeMap attrs;
		/* acquisition de toutes les entrées de la base d'hôtels */
		for(int i = 0; i < list.getLength();i++) {
			attrs = list.item(i).getAttributes();
			name = attrs.getNamedItem("name").getNodeValue();
			localisation = attrs.getNamedItem("localisation").getNodeValue();
			this.hotels.add(new Hotel(name, localisation));
		}
	}

	public String name() {
		return this.name;
	}

	@Override
	public List<Hotel> get(String localisation) {
		// TODO Auto-generated method stub
		List<Hotel> list = new ArrayList<Hotel>();
		for(Hotel hotel : this.hotels){
			if(hotel.getLocalisation().equals(localisation)){
				list.add(hotel);
			}
		}		
		return list;
	}
	
}
