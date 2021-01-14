import javax.xml.parsers.SAXParserFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ConvertXmlUsingSAX {


	public static void main(String argv[]) {
		
		try {
			XmlHandler xmlhandler=new XmlHandler();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse("C:\\Users\\SHNN\\eclipse-workspace\\Assignment4\\src\\main\\java\\JsonToXml.xml", xmlhandler);			
			ReadExcel readExcel=new ReadExcel();
			Employee employee=readExcel.readExcel();			
			System.out.println("Value"+employee.getId());
			System.out.println("Value"+employee.getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
