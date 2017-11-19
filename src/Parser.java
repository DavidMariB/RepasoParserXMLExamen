import java.io.IOException;
import java.util.ArrayList;

import javax.security.sasl.SaslException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {
	
	private Document doc = null;
	private ArrayList<Accion> acciones = new ArrayList<Accion>();
	
	public Parser() {
		
	}
	
	public void parseXMLDocument(String fichero) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			doc = db.parse(fichero);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void parseDocument() {
		
		Element docEle = doc.getDocumentElement();
		
		NodeList nl = docEle.getElementsByTagName("accion");
		if(nl !=null && nl.getLength()>0) {
			for(int i = 0; i < nl.getLength() ;i++) {
				
				Element elAccion = (Element) nl.item(i);
				
				Accion accion = new Accion();
				
				String nombre = elAccion.getAttribute("nombre");
				accion.setNombre(nombre);
				System.out.println("Nombre: "+nombre);
				
				NodeList nl2 = docEle.getElementsByTagName("operaciones");
				if(nl2 != null && nl2.getLength()>0) {
			
					Element elOperaciones = (Element) nl2.item(0);
					
					NodeList nl3 = elOperaciones.getElementsByTagName("operacion");
					if(nl3 != null && nl3.getLength()>0) {
						for(int x = 0; x < nl3.getLength(); x++) {
							
							Element elOperacion = (Element) nl3.item(x);
							
							Operacion op = new Operacion();
							
							NodeList nl4 = elOperacion.getElementsByTagName("tipo");
							
							if(nl4 != null && nl4.getLength()>0) {
								
								Element elTipo = (Element) nl4.item(0);
								String tipo = elTipo.getFirstChild().getNodeValue();
								System.out.println("Tipo: "+tipo);
								op.setTipo(tipo);
							}
							
							NodeList nl5 = elOperacion.getElementsByTagName("cantidad");
							
							if(nl5 != null && nl5.getLength()>0) {
								
								Element elCantidad = (Element) nl5.item(0);
								String cantidad = elCantidad.getFirstChild().getNodeValue();
								System.out.println("Cantidad: "+cantidad);
								op.setCantidad(cantidad);
							}
							
							NodeList nl6 = elOperacion.getElementsByTagName("precio");
							
							if(nl6 != null && nl5.getLength()>0) {
								
								Element elPrecio = (Element) nl6.item(0);
								String precio = elPrecio.getFirstChild().getNodeValue();
								System.out.println("Precio: "+precio);
								op.setPrecio(precio);
							}
							
							accion.getOperacion().add(op);
						}
					}
				}
				
				acciones.add(accion);
			}
		}
	}

}
