package test;
import product.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;
public class main {

	public static void main(String[] args) {
		
		Scanner cin = new Scanner(System.in); // scanner to read from the user
		
		System.out.println("Welcome!");
		
		OrderApplication app = new OrderApplication();
		
		Order wantedOrder = new Order(); // 
		int counter = 0; // counter for the objects
		
		Pattern p = Pattern.compile(","); // regular expression to divide the line of the excel file
		
		try { // try and catch method in case there is an error
			
			Scanner fileIn = new Scanner(Paths.get("tempOrder.csv")); // get the file 
			
			fileIn.nextLine(); // get rid of the first line which has the headers
			// totalPrice = 
			
			// loop to go through the lines
			while (fileIn.hasNextLine()) { // if it has next line go to the loop
				String line = fileIn.nextLine(); // read the line
				
				String[] items = p.split(line); // split the line with the regular expression
				
				
				// assign the values

				int productID = Integer.parseInt(items[0]); 
				int quantity = Integer.parseInt(items[1]); 
				
				
				// set the variables in the object
				wantedOrder.items()[counter].set_ProductID3(productID);
				wantedOrder.quantity()[counter].setQuantiy(quantity);
				
				counter++; // counter increment 
				
				
			}
			
			
			fileIn.close(); // close the file
			
		} // end of try
		catch (IOException e) { // catch the error
			e.printStackTrace();
		} // end of catch
		
		
		app.createOrder(wantedOrder);
		
		
	}
	
}
