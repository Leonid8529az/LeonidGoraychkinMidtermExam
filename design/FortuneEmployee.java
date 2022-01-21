package design;

import algorithm.Sort;
import com.mysql.cj.util.DnsSrv;

import java.util.List;

public class FortuneEmployee {

	/**
	 * FortuneEmployee class has a main methods where you will be able to create Object from
	 * EmployeeInfo class to use fields and attributes.Demonstrate as many methods as possible 
	 * to use with proper business work flow.Think as a Software Architect, Product Designer and 
	 * as a Software Developer.(employee.info.system) package is given as an outline,you need to elaborate
	 * more to design an application that will meet for fortune 500 Employee Information
	 * Services.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 *
	 **/
	public static void main(String[] args) {

		EmployeeInfo positionPointer = new EmployeeInfo();
		EmployeeInfo connetorReacher = new EmployeeInfo();
		connetorReacher.connectToSqlDB.tableForEmployees(positionPointer.companyName);
		connetorReacher.connectToSqlDB.tableForBonus("employee_bonus");
		EmployeeInfo employee111 = new EmployeeInfo("Alfred", "Nuno","03.09.1992", positionPointer.owner,"Washington","Production", 200000, "alfrednuno@gmail.com", "123-123-1234" );
		EmployeeInfo employee112 = new EmployeeInfo("Paul", "Faedra","09.19.1990", positionPointer.ba,"Washington","Production", 160000, "paulphaedra@gmail.com", "123-777-1234" );
		EmployeeInfo employee113 = new EmployeeInfo("Aegnis", "Maximianus","09.11.1991", positionPointer.director,"Washington","Finance", 160000, "aegnismaximianus@gmail.com", "777-123-1234" );
		EmployeeInfo employee114 = new EmployeeInfo("Cyprianu", "Rakhi","12.17.1987", positionPointer.developer,"Washington","Human Resources", 100000, "cryptianurakhi@gmail.com", "333-555-1234" );
		EmployeeInfo employee115 = new EmployeeInfo("Ufuk", "Andronikos","01.24.1970", positionPointer.developer,"Washington","Human Resources", 100000, "ufukandronikas@gmail.com", "665-177-1234" );
		EmployeeInfo employee116 = new EmployeeInfo("Valeriya", "Dubhgal","04.11.1983", positionPointer.techSupport,"Washington","Customer Service", 80000, "valeriyadubhgal@gmail.com", "1775-998-0009" );
		EmployeeInfo employee117 = new EmployeeInfo("Lupita", "Klavdia","11.01.1986", positionPointer.director,"New York","Finance", 150000, "lupitaklavdia@gmail.com", "651-112-3314" );
		EmployeeInfo employee118 = new EmployeeInfo("Artur", "Iris","09.23.1990", positionPointer.qaTester,"Washington","Human Resources", 90000, "arturiris@gmail.com", "123-433-1234" );
		EmployeeInfo employee119 = new EmployeeInfo("Karolos", "Rachele","11.15.1994", positionPointer.qaTester,"Washington","Human Resources", 90000, "karolosrachele@gmail.com", "123-222-7621" );
		EmployeeInfo employee120 = new EmployeeInfo("Festus", "Laxman","10.03.1981", positionPointer.qaTester,"Washington","Human Resources", 90000, "festuslaxman@gmail.com", "444-524-1221" );
		EmployeeInfo employee121 = new EmployeeInfo("Nadezda", "Nickanor","04.09.1991", positionPointer.qaTester,"Washington","Human Resources", 90000, "nadezdanickanor@gmail.com", "44-234-1141" );
		EmployeeInfo employee122 = new EmployeeInfo("Rafail", "Mamuka","11.20.1976", positionPointer.developer,"Washington","Human Resources", 120000, "rafailmamuka@gmail.com", "443-113-3151" );
		EmployeeInfo employee123 = new EmployeeInfo("Luba", "Silvia","08.08.1988", positionPointer.managerDevTeam,"Washington","Research and development", 125000, "lubasilvia@gmail.com", "444-598-9374" );
		EmployeeInfo employee124 = new EmployeeInfo("Zavier", "Milista","11.23.1980", positionPointer.managerQATeam,"Washington","Research and development", 105000, "zaviermilsta@gmail.com", "444-098-3201" );
		EmployeeInfo employee125 = new EmployeeInfo("Vicente", "Khasan","05.19.1989", positionPointer.customerService,"Washington","Customer Service", 60000, "vicentekhasan@gmail.com", "444-520-9391" );
		EmployeeInfo employee126 = new EmployeeInfo("Kendal", "Lisaiki","07.27.1991", positionPointer.customerService,"Washington","Customer Service", 60000, "kendallisaiki@gmail.com", "412-390-9391" );
		EmployeeInfo employee127 = new EmployeeInfo("Craig", "Alab","10.26.1981", positionPointer.customerService,"Washington","Customer Service", 60000, "craigalab@gmail.com", "448-983-2221" );
		EmployeeInfo employee128 = new EmployeeInfo("Henny", "Ganymede","02.01.1990", positionPointer.managerCustomerService,"Washington","Customer Service", 90000, "hennyganymede@gmail.com", "362-029-9991" );
		EmployeeInfo employee129 = new EmployeeInfo("Aart", "Theo","11.09.1991", positionPointer.developer,"New York","Human Resources", 120000, "aarttheo@gmail.com", "948-220-0234" );
		EmployeeInfo employee130 = new EmployeeInfo("Jesus", "Dalila","07.19.1983", positionPointer.developer,"New York","Human Resources", 120000, "aarttheo@gmail.com", "948-220-9994" );
		EmployeeInfo employee131 = new EmployeeInfo("Fortune", "Sirgewead","06.12.1982", positionPointer.developer,"New York","Human Resources", 120000, "fortunesiergewed@gmail.com", "871-220-0987" );
		EmployeeInfo employee132 = new EmployeeInfo("Imran", "Stacia","04.11.1980", positionPointer.managerDevTeam,"New York","Research and development", 1370000, "imranstacia@gmail.com", "973-441-3234" );
		EmployeeInfo employee133 = new EmployeeInfo("Leopold", "Cherizh","09.19.1990", positionPointer.qaTester,"New York","Human Resources", 100000, "leopoldcherizh@gmail.com", "111-234-9876" );
		EmployeeInfo employee134 = new EmployeeInfo("Gio", "Rebekka","07.20.1996", positionPointer.qaTester,"New York","Human Resources", 100000, "giorebekka@gmail.com", "111-262-9876" );
		EmployeeInfo employee135 = new EmployeeInfo("Nikolai", "Anderson","12.19.1990", positionPointer.qaTester,"New York","Human Resources", 100000, "nikolayanderson@gmail.com", "193-876-0911");
		EmployeeInfo employee136 = new EmployeeInfo("Sujay", "Manjit","03.25.1984", positionPointer.managerQATeam,"New York","Human Resources", 1230000, "sujaymanjit@gmail.com", "449-234-9876" );
		EmployeeInfo employee137 = new EmployeeInfo("Iris", "Dannin","09.11.1990", positionPointer.customerService,"New York","Customer Service", 58000, "irisdannin@gmail.com", "478-999-9391" );
		EmployeeInfo employee138 = new EmployeeInfo("Handoe", "Kritoria","12.03.1987", positionPointer.customerService,"New York","Customer Service", 58000, "handoikritoria@gmail.com", "333-390-9391" );
		EmployeeInfo employee139 = new EmployeeInfo("Aqual", "Wesstman","10.27.1994", positionPointer.customerService,"New York","Customer Service", 58000, "aqualwesstman@gmail.com", "145-983-2991" );
		EmployeeInfo employee140 = new EmployeeInfo("Oddy", "Oklopovskiy","08.17.1991", positionPointer.managerCustomerService,"New York","Customer Service", 84000, "oddyoclopovski@gmail.com", "395-098-9991" );
		try {
			List<String> emails = connetorReacher.connectToSqlDB.readDataBase(positionPointer.companyName,"email_address");
			for(int i = 0; i<emails.size(); i++) {
				System.out.println(emails.get(i));
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}






	}

}
