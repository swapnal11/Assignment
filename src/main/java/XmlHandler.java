import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.event.ListDataListener;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlHandler extends DefaultHandler {

	Employee employee;
	Address address;
	boolean zipcode = false;
	boolean city = false;
	boolean street = false;
	boolean role = false;
	boolean cities = false;
	boolean permanent= false;
	boolean name= false;
	boolean id= false;
	boolean salary= false;
	boolean age= false;
	boolean phoneNumbers= false;


	List<String> citiesList=new ArrayList<String>();
	List<String> phonenumberList=new ArrayList<String>();
	Map<String, String> properties=new HashMap<String, String>();



	public void startElement(String uri, String localName,String qName, 
			Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("ZIPCODE")) {
			zipcode = true;
		}

		if (qName.equalsIgnoreCase("CITY")) {
			city = true;
		}

		if (qName.equalsIgnoreCase("STREET")) {
			street = true;
		}

		if (qName.equalsIgnoreCase("ROLE")) {
			role = true;
		}
		if (qName.equalsIgnoreCase("CITIES")) {
			cities = true;
		}
		if (qName.equalsIgnoreCase("PERMANENT")) {
			permanent = true;
		}
		if (qName.equalsIgnoreCase("NAME")) {
			name = true;
		}
		if (qName.equalsIgnoreCase("ID")) {
			id = true;
		}
		if (qName.equalsIgnoreCase("SALARY")) {
			salary = true;
		}
		if (qName.equalsIgnoreCase("AGE")) {
			age = true;
		}
		if (qName.equalsIgnoreCase("PHONENUMBERS")) {
			phoneNumbers = true;
		}

	}

	public void endElement(String uri, String localName,
			String qName) throws SAXException {
	}

	public void characters(char ch[], int start, int length) throws SAXException {

		if(this.employee==null)
		{
			this.employee=new Employee();

		}

		if(this.address==null)
		{
			this.address=new Address();

		}

		if (zipcode) {
			address.setZipcode(new String(ch, start, length));
			this.employee.setAddress(address);
			zipcode = false;
		}

		if (city) {
			address.setCity(new String(ch, start, length));
			this.employee.setAddress(address);
			city = false;
		}

		if (street) {
			address.setStreet(new String(ch, start, length));
			this.employee.setAddress(address);
			street = false;
		}

		if (role) {
			this.employee.setRole( new String(ch, start, length));
			role = false;
		}
		if (cities) {
			citiesList.add( new String(ch, start, length));
			this.employee.setCities(citiesList);
			cities = false;
		}
		if (permanent) {
			this.employee.setPermanent(Boolean.getBoolean(new String(ch, start, length)));
			permanent = false;
		}
		if (name) {
			this.employee.setName( new String(ch, start, length));
			name = false;
		}
		if (id) {
			this.employee.setId(new String(ch, start, length));
			id = false;
		}
		if (salary) {
			properties.put("salary", new String(ch, start, length));
			this.employee.setProperties(properties);
			salary = false;
		}
		if (age) {
			properties.put("age", new String(ch, start, length));
			this.employee.setProperties(properties);
			age = false;
		}
		if (phoneNumbers) {
			phonenumberList.add(new String(ch, start, length));
			this.employee.setPhoneNumbers(phonenumberList);
			phoneNumbers = false;
		}


	}

	public Employee getEmployee()
	{
		return this.employee;

	}

}
