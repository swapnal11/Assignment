import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	int name=-1;
	int id=-1;
	int permanent=-1;
	int street=-1;
	int city=-1;
	int zipcode=-1;
	int role=-1;
	int cities=-1;
	int phoneNumbers=-1;
	int age=-1;
	int salary=-1;


	public Employee readExcel()
	{ 
		Employee employee=new Employee();
		Address address=new Address();

		Map<String, String> map=new HashedMap<String, String>();
		try { 
			FileInputStream file = new FileInputStream(new File("C:\\Users\\SHNN\\eclipse-workspace\\Assignment4\\src\\main\\java\\JSONInfo.xls")); 

			// Create Workbook instance holding reference to .xlsx file 
			XSSFWorkbook workbook = new XSSFWorkbook(file); 

			// Get first/desired sheet from the workbook 
			XSSFSheet sheet = workbook.getSheetAt(0); 


			boolean flag=false;

			// Iterate through each rows one by one 
			Iterator<Row> rowIterator = sheet.iterator(); 
			while (rowIterator.hasNext()) { 
				Row row = rowIterator.next();
				// For each row, iterate through all the columns 
				Iterator<Cell> cellIterator = row.cellIterator(); 
				while (cellIterator.hasNext()) { 
					Cell cell = cellIterator.next(); 
					switch (cell.getCellType()) { 
					case Cell.CELL_TYPE_NUMERIC: 
						break; 
					case Cell.CELL_TYPE_STRING: 
						System.out.println(cell.getStringCellValue());
						if(id!=-1 && flag)
						{
							employee.setId(cell.getStringCellValue());	
							id=-1;

						}
						if(cell.getStringCellValue().equals("id"))
						{
							id=cell.getColumnIndex();					

						}
						if(name!=-1 && flag)
						{
							employee.setName(cell.getStringCellValue());	
							name=-1;

						}
						if(cell.getStringCellValue().equals("name"))
						{
							name=cell.getColumnIndex();
						}
						if(permanent!=-1 && flag)
						{
							employee.setName(cell.getStringCellValue());	
							permanent=-1;

						}	
						if(cell.getStringCellValue().equals("permanent"))
						{
							permanent=cell.getColumnIndex();
						}

						if(street!=-1 && flag)
						{
							employee.setName(cell.getStringCellValue());	
							street=-1;

						}	
						if(cell.getStringCellValue().equals("street"))
						{
							street=cell.getColumnIndex();
						}
						if(city!=-1 && flag)
						{
							employee.setName(cell.getStringCellValue());	
							city=-1;

						}	

						if(cell.getStringCellValue().equals("city"))
						{
							city=cell.getColumnIndex();
						}
						if(zipcode!=-1 && flag)
						{
							employee.setName(cell.getStringCellValue());	
							zipcode=-1;

						}	
						if(cell.getStringCellValue().equals("zipcode"))
						{
							zipcode=cell.getColumnIndex();
						}
						if(role!=-1 && flag)
						{
							employee.setName(cell.getStringCellValue());	
							role=-1;

						}	
						if(cell.getStringCellValue().equals("role"))
						{
							role=cell.getColumnIndex();
						}
						if(cities!=-1 && flag)
						{
							employee.setName(cell.getStringCellValue());	
							cities=-1;

						}
						if(cell.getStringCellValue().equals("cities"))
						{
							cities=cell.getColumnIndex();
						}
						if(phoneNumbers!=-1 && flag)
						{
							employee.setName(cell.getStringCellValue());	
							phoneNumbers=-1;

						}
						if(cell.getStringCellValue().equals("phoneNumbers"))
						{
							phoneNumbers=cell.getColumnIndex();
						}
						if(age!=-1 && flag)
						{
							employee.setName(cell.getStringCellValue());	
							age=-1;

						}
						if(cell.getStringCellValue().equals("age"))
						{
							age=cell.getColumnIndex();
						}
						if(salary!=-1 && flag)
						{
							employee.setName(cell.getStringCellValue());	
							salary=-1;

						}
						if(cell.getStringCellValue().equals("salary"))
						{
							salary=cell.getColumnIndex();
							flag=true;
						}
						break; 
					} 
				} 
				//				employee.setName(sheet.getRow(1).getCell(name).getStringCellValue());
				//			y	address.setStreet(sheet.getRow(1).getCell(street).getStringCellValue());
				//				address.setCity(sheet.getRow(1).getCell(city).getStringCellValue());
				//				address.setZipcode(sheet.getRow(1).getCell(zipcode).getStringCellValue());
				//
				//				employee.setAddress(address);
				//				employee.setRole(sheet.getRow(1).getCell(role).getStringCellValue());
				//
				//				employee.setCities(Arrays.asList(sheet.getRow(1).getCell(cities).getStringCellValue().split(",")));
				//				employee.setPhoneNumbers(Arrays.asList(sheet.getRow(1).getCell(phoneNumbers).getStringCellValue().split(",")));
				//
				//				map.put("age", sheet.getRow(1).getCell(age).getStringCellValue());
				//				map.put("salary", sheet.getRow(1).getCell(salary).getStringCellValue());
				//				employee.setProperties(map);


			} 
			file.close(); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
		return employee;
	} 

}
