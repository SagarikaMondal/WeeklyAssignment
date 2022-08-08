/* Develop a java class with a instance variable M1 (HashMap) create a method saveCountryCapital(String CountryName, String capital) , the method should add the passed country and capital as key/value in the map M1 and return the Map (M1).

Key- Country Value - Capital

India Delhi

Japan Tokyo

2. Develop a method getCapital(String CountryName) which returns the capital for the country passed, from the Map M1 created in step 1.

3. Develop a method getCountry(String capitalName) which returns the country for the capital name, passed from the Map M1 created in step 1.

4. Develop a method which iterates through the map M1 and creates another map M2 with Capital as the key and value as Country and returns the Map M2.

Key – Capital Value – Country

Delhi India

Tokyo Japan

5. Develop a method which iterates through the map M1 and creates an ArrayList with all the Country names stored as keys. This method should return the ArrayList.

NOTE: You can test the methods using a main method.

*/

package AssignmentJava;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CountryDetails {
	HashMap<String,String> M1=new HashMap();
	public static void main(String[] args) {
		CountryDetails obj=new CountryDetails();
		//Saving key/value using saveCountryCapital method.
		obj.saveCountryCapital("India","New Delhi");
		obj.saveCountryCapital("United States","Washington D.C.");
		obj.saveCountryCapital("Afghanistan","Kabul");
		obj.saveCountryCapital("Algeria","Algiers");
		
		//Fetching capital using Country name
		System.out.println("Fetching Capital name for India : "+obj.getCapital("India"));
		System.out.println("Fetching Capital name for United States : "+obj.getCapital("United States"));
		System.out.println();
		
		//Fetching Country name using capital
		
		System.out.println("Fetching Country name for New Delhi : "+obj.getCountry("New Delhi"));
		System.out.println("Fetching Country name for Washington D.C. : "+obj.getCountry("Washington D.C."));
		
		
		//Changing key as Capital and value as country
	
	
			Iterator<Map.Entry<String, String>> it = obj.swapCountryCapital().entrySet().iterator();
			System.out.println("key value set of M2");
			while(it.hasNext())
			{
				Map.Entry<String, String> mapIt = it.next();
				System.out.println(mapIt.getValue()+":"+mapIt.getKey());
			}
			System.out.println();
		//Arraylist of key
			System.out.println(obj.returnKeyOfArrayList());
			
		}
	HashMap<String,String> saveCountryCapital(String CountryName, String capital){
		M1.put(CountryName,capital);
		return M1;
	}
	
	String getCapital(String CountryName) {
		return M1.get(CountryName);
	}
	
	String getCountry(String capitalName) {
		   
		Set<String> ks=M1.keySet();
		for(String k:ks) {
			if(M1.get(k)==capitalName)
			{
				return k;
			}
		}
		return "Not Found";
		    
	}
		    
		    
		HashMap<String,String> swapCountryCapital(){
			System.out.println();
			System.out.println("key value set of M1");
			System.out.println(M1);
		Iterator<Map.Entry<String, String>> it = M1.entrySet().iterator();
		HashMap<String,String> M2=new HashMap();
		while(it.hasNext())
		{
			Map.Entry<String, String> mapIt = it.next();
			M2.put(mapIt.getValue(),mapIt.getKey());
		}
		System.out.println();
		return M2;
	}
		
		
		ArrayList<String> returnKeyOfArrayList()
		{
			ArrayList<String> key=new ArrayList<String>();
			Set<String> ks=M1.keySet();
			for(String k:ks) {
					key.add(k);
				}
			return key;
			
		}
}
