package product;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;
public class OrderApplication  {

	private Customer newCustomer = new Customer();
	private ProductCatalogue catalg = new ProductCatalogue();
	private CorporateCustomer x1 = new CorporateCustomer();
	private PersonalCustomer x2 = new PersonalCustomer();
	// methods required
	public boolean createOrder(Order cart) {
		Scanner cin = new Scanner(System.in); // scanner to read from the user
		boolean chk = false;
		char discountQuestion;
		chk = importCatalogue();
		double discount = 0;
		double totalPrice = 0.0;
		if (chk == true) {
			totalPrice = cart.calculatePrice(catalg);
			System.out.println("Do you have discount (if yes press y, and if not press any other key");
			discountQuestion = cin.next().charAt(0);
			if (discountQuestion == 'y') {
				System.out.println("Enter the % of the discount :");
				discount = cin.nextDouble();
				discount = (discount / 100) * totalPrice;
			} 
			String name;
			String address;
			String contactName;
			int creditNumber;
			cin.nextLine();
			System.out.println("Enter your name: ");
			name = cin.nextLine();
			newCustomer.set_Name(name);
			System.out.println("Enter address: ");
			address = cin.nextLine();
			newCustomer.set_Address(address);
			System.out.println("Enter Credit Card number: ");
			creditNumber = cin.nextInt();
			x2.set_creditCardNumber(creditNumber);
			cin.nextLine();
			System.out.println("Enter contact name: ");
			contactName = cin.nextLine();
			x1.set_contactName(contactName);
			
			System.out.println("Check out info:" );
			
			System.out.println("Buyer name:" + newCustomer.getName());
			System.out.println("Buyer contact name:" + x1.get_contactName());
			System.out.println("Buyer Address:" + newCustomer.getAddress());
			System.out.println("Total price is $" + totalPrice);
			if(discount > 0) {
				System.out.println("Total price after discount is $" + (totalPrice - discount));
			}
		} else {
			System.out.println("Error importing catalogue!");
		}
		
		return chk;
	}
	
	private boolean importCatalogue() {
		


		boolean chk = false;
		int counter = 0; // counter for the objects
		
		Pattern p = Pattern.compile(","); // regular expression to divide the line of the excel file
		
		try { // try and catch method in case there is an error
			
			Scanner fileIn = new Scanner(Paths.get("products.csv")); // get the file 
			
			fileIn.nextLine(); // get rid of the first line which has the headers
			// totalPrice = 
			
			// loop to go through the lines
			while (fileIn.hasNextLine()) { // if it has next line go to the loop
				String line = fileIn.nextLine(); // read the line
				
				String[] items = p.split(line); // split the line with the regular expression
				
				
				// assign the values
				String productName = items[0]; 
				double productPrice = Double.parseDouble(items[1]); // cast to double
				int productID = Integer.parseInt(items[2]); 
				
				
				// set the variables in the object
				catalg.getProducts()[counter] = new Product(productName, productPrice, productID);
				

				
				counter++; // counter increment 
				
				
			}
			
			
			fileIn.close(); // close the file
			
		} // end of try
		catch (IOException e) { // catch the error
			e.printStackTrace();
		} // end of catch
		
		if (counter == 10) { // check if all items are imported
			chk = true;
		}
		return chk;
	}
	
	
}
