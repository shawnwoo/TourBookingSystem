package util;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {

	public static void crateXML(String fileName) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Reservation");
			doc.appendChild(rootElement);

			
			
			// write the content into xml file
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer = transformerFactory.newTransformer();
						DOMSource source = new DOMSource(doc);
						StreamResult result = new StreamResult(new File(fileName));
						transformer.transform(source, result);
				 
						System.out.println("Done");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void updateXML(String fileName, String tourName,
			String airline, String hotel, String localTrans,
			String touristName, String touristEmail,String touristAddress) {
		try {
			
			String filepath=fileName;
			DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder=docFactory.newDocumentBuilder();
			Document doc=docBuilder.parse(filepath);
			
			Node tour=doc.getFirstChild(); 
			
			
			tour.appendChild(generateNewElement(doc,"tourName",tourName));
			
			tour.appendChild(generateNewElement(doc,"airline",airline));
			tour.appendChild(generateNewElement(doc,"hotel",hotel));
			tour.appendChild(generateNewElement(doc,"localTrans",localTrans));
			tour.appendChild(generateNewElement(doc,"tourist",touristName));
			tour.appendChild(generateNewElement(doc,"Email",touristEmail));
			tour.appendChild(generateNewElement(doc,"Address",touristAddress));
	//		tour.appendChild(generateNewElement(doc,"price",price));
		
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
	 
			System.out.println("Done");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static ArrayList<> readXMLtoLine(String fileName){
//		try{
//			File xmlFile=new File(fileName);
//			DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
//			DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
//			Document doc=dBuilder.parse(xmlFile);
//			doc.getDocumentElement().normalize();
//			
//			NodeList nList=doc.getElementsByTagName("Reservation");
//			
//			
//			
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		
//		
//		return null;}
	
	private static String getTagValue(String sTag, Element element){
		NodeList nList=element.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue=(Node)nList.item(0);
		return nValue.getNodeValue();
	}
	private static Element generateNewElement(Document doc,String name, String value){
		Element element=doc.createElement(name);
		element.appendChild(doc.createTextNode(value));
		return element;
	}
}
