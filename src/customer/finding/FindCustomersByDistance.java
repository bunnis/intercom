package customer.finding;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import com.google.gson.Gson;

import customer.Customer;

public class FindCustomersByDistance {

	private LinkedList<Customer> listOfCustomers;
	private LinkedList<Customer> listOfCustomersMeetingRequirements;

	public static void main(String[] args) {
		String customersFileLocation= "https://gist.githubusercontent.com/brianw/19896c50afa89ad4dec3/raw/6c11047887a03483c50017c1d451667fd62a53ca/gistfile1.txt";
        int distance_for_customer_finding = 100; //100km
		
		FindCustomersByDistance findCustomers = new FindCustomersByDistance(customersFileLocation);
		LinkedList<Customer> customerListParsed = findCustomers.findCustomerWithinSortID(distance_for_customer_finding);
		
		
		System.out.println("found "+customerListParsed.size() + " customers" );
	}

	private LinkedList<Customer> findCustomerWithinSortID(int distance_for_customer_finding) {
		listOfCustomersMeetingRequirements = new LinkedList<Customer>();
		DistanceCalculator dc = new DistanceCalculator();
		
		//find customers by distance
		for(Customer c : listOfCustomers){
			if(dc.distance(dc.getLatitude(), dc.getLongitude(), c.getLatitude(), c.getLongitude(), "K") <= distance_for_customer_finding){
				listOfCustomersMeetingRequirements.add(c);
			}
		}
		
		//sort by id
		Collections.sort(listOfCustomersMeetingRequirements);
		
		return listOfCustomersMeetingRequirements;
	}

	//create list of customers
	public FindCustomersByDistance(String customersFileLocation){
		listOfCustomers = new LinkedList<Customer>();
		readJson(customersFileLocation);

		try {
			if(listOfCustomers.size() == 0){
				throw new Exception("Problem parsing json, no records");
			}
		} catch (Exception e) {
			System.err.println("Problem parsing json, no records");
			e.printStackTrace();
		}

	}

	private void readJson(String customersFileLocation) {
		try {
			URL url = new URL(customersFileLocation);
			Scanner s = new Scanner(url.openStream());
			Gson gson = new Gson();

			while(s.hasNextLine()){
				Customer c = gson.fromJson(s.nextLine(),Customer.class);
				listOfCustomers.add(c);
			}

		} catch (MalformedURLException e) {
			System.err.println("Failed to open given url");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Failed to open file stream");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error with JSON formatting");
			e.printStackTrace();
		}
	}



}
