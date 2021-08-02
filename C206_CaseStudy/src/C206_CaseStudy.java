import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		ArrayList<FoodItem> foodItemList = new ArrayList<FoodItem>();
		foodItemList.add(new FoodItem("food", 1));
		
		ArrayList<CustomerOrder> orderList = new ArrayList<CustomerOrder>();

		ArrayList<Stall> StallList = new ArrayList<Stall>();

		int option = 0;
		int optionCA = 0;
		int optionSS = 0;
		int optionCus = 0;
		int optionCAS =0;

		while (option != 4) { // users select which role they are
			C206_CaseStudy.menuRole();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) { // for canteen admin
				while (optionCA != 6) {
					C206_CaseStudy.menuCA();
					
					optionCA = Helper.readInt("Enter an option > ");
					if (optionCA == 1) { // Manage stalls
						C206_CaseStudy.menuCAS();
						while (optionCA !=6){
						 optionCAS = Helper.readInt("Enter an option > ");
						
							
							if (optionCAS == 1) {// Add new Stall
								 Stall ns = inputStall();
								 C206_CaseStudy.addStall(StallList, ns);
								 
							}else if (optionCAS == 2) {// view new stall
								C206_CaseStudy.retrieveAllStall(StallList);
								C206_CaseStudy.viewAllStall(StallList);
								C206_CaseStudy.retrieveAllStall1(StallList);
								
							}else if( optionCAS == 3) {// delete stall
								C206_CaseStudy.deleteStall(StallList);
							}
							else if (optionCAS == 4) {// update stall
								C206_CaseStudy.UpdateStall(StallList, null );
							}
							else {
								System.out.println("invalid option");
								 
							}
							
						}
					
					
					} else if (optionCA == 2) { // Manage food items
					
					} else if (optionCA == 3) { // View Promotion Offers
						
					} else if (optionCA == 4) { // Receive Purchase Orders
						

						
					} else if (optionCA == 5) { // Generate sales report

					} else if (optionCA == 6) {
						System.out.println("Return back to Role Selection...");
					} else {
						System.out.println("Invalid option");
					}
				}
			} else if (option == 2) { // for Stall Staff
				while (optionSS != 4) {
					C206_CaseStudy.menuSS();
					optionSS = Helper.readInt("Enter an option > ");
					if (optionSS == 1) { // Manage Order Status

					} else if (optionSS == 2) { // Manage Purchase Orders

					} else if (optionSS == 3) { // Manage Promotion Offers

					} else if (optionSS == 4) {
						System.out.println("Return back to Role Selection...");
					} else {
						System.out.println("Invalid option");
					}
				}
			} else if (option == 3) { // for Customer
				while (optionCus != 4) {
					C206_CaseStudy.menuCus();
					optionCus = Helper.readInt("Enter an option > ");
					if (optionCus == 1) { // View Menu Items

					} else if (optionCus == 2) { // Place Order
						C206_CaseStudy.placeOrder(foodItemList);
					} else if (optionCus == 3) { // Manage Orders

					} else if (optionCus == 4) {
						System.out.println("Return back to Role Selection...");
					} else {
						System.out.println("Invalid option");
					}
				}
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}

	}

	public static void menuRole() {
		C206_CaseStudy.setHeader();
		System.out.println("Role Selection");
		Helper.line(80, "-");
		System.out.println("1. Canteen Administrator\n2. Stall Staff\n3. Customer\n4. Quit");
		Helper.line(80, "-");
	}

	public static void menuCA() {
		C206_CaseStudy.setHeader();
		System.out.println("Canteen Administrator");
		Helper.line(80, "-");
		System.out.println(
				"1. Manage Stalls\n2. Manage food items\n3. View Promotion Offers\n4. Receive Purchase Orders\n5. Generate sales report\n6. Quit");
		Helper.line(80, "-");
	}

	public static void menuCAS() {
		C206_CaseStudy.setHeader();
		System.out.println("Manage Canteen Stalls");
		Helper.line(80, "-");
		System.out.println("1.Add New Stall\n2.View Stall\n3.Remove Stall\n4.Update Stall");
	}

	public static void menuSS() {
		C206_CaseStudy.setHeader();
		System.out.println("Stall Staff");
		Helper.line(80, "-");
		System.out.println("1. Manage Order Status\n2. Manage Purchase Orders\n3. Manage Promotion Offers\n4. Quit");
		Helper.line(80, "-");
	}

	public static void menuCus() {
		C206_CaseStudy.setHeader();
		System.out.println("Customer");
		Helper.line(80, "-");
		System.out.println("1. View Menu Items\n2. Place Order\n3. Manage Orders\n4. Quit");
	}

	public static void setHeader() {
		Helper.line(80, "=");
		System.out.println("Canteen Automation System (CAS)");
		Helper.line(80, "=");
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	// ================================= Option 1 - Canteen Admin =================================

	// ================================= Option 1.1.1 - Add stalls =================================
	// gary
	public static Stall inputStall() {
		String sname = Helper.readString("Enter Stall Name > ");
		String doo = Helper.readString("Enter Date of Operation > ");

		Stall ns = new Stall(sname, doo);
		return ns;

	}

	public static void addStall(ArrayList<Stall> StallList, Stall ns) {

		StallList.add(ns);

		System.out.println("new Stall added");

	}

	// ================================= Option 1.1.2 - View stalls =================================
	// gary

	public static String retrieveAllStall(ArrayList<Stall> StallList) {
		String output = "";

		for (int i = 0; i < StallList.size(); i++) {

			output += String.format("%-10s %40s\n", StallList.get(i).getStallName(), StallList.get(i).getDate(),
					StallList.get(i).getStallName(), C206_CaseStudy.showAvailability(StallList.get(i).getStallName()),
					StallList.get(i).getDate());
		}
		return output;
	}

	private static Object showAvailability(String stallName) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void viewAllStall(ArrayList<Stall> StallList) {

		String output = String.format("%-10s %40s\n", "STALL NAME", "DATE OF OPERATION");
		output += retrieveAllStall(StallList);
		System.out.println(output);
	}

	public static String retrieveAllStall1(ArrayList<Stall> StallList) {
		String output = "";

		// write your code here

		for (int i = 0; i < StallList.size(); i++) {

			output += String.format("%-10s %-40s\n", StallList.get(i).getStallName(), StallList.get(i).getDate());

		}
		return output;
	}

	// ================================= Option 1.1.3 - Change stalls =================================
	// gary
	public static boolean UpdateStall(ArrayList<Stall> StallList, String date) {
		String date2 = Helper.readString("Enter date of operation > ");
		String name2 = Helper.readString("Enter Stall name > ");

		boolean isUpdated = false;

		for (int i = 0; i < StallList.size(); i++) {
			if (date2.equals(StallList.get(i).getDate()) || name2.equals(StallList.get(i).getStallName())) {
				String name1 = Helper.readString("Enter new Stall name > ");
				String date1 = Helper.readString("new Date of operation > ");

				StallList.get(i).setDate(date1);
				StallList.get(i).setStallName(name1);
				System.out.println("Stall has been updated");
			} else {
				System.out.println("The Stall name/date or operation is in correct");
				isUpdated = true;
				break;

			}
		}

		return isUpdated;

	}

	// ================================= Option 1.1.4 - Remove stalls =================================
	// gary

	private static void deleteStall(ArrayList<Stall> StallList) {
		System.out.println("1. Name");
		System.out.println("2. Date Of Operation");
		int finderIndex = Helper.readInt("Which method do you wish to search by? > ");

		ArrayList<Stall> findStallItemList = new ArrayList<Stall>();

		if (finderIndex == 1) {
			String StallName = Helper.readString("Enter Stall Name > ");
			for (Stall sa : StallList) {
				if (sa.getStallName().equalsIgnoreCase(StallName)) {
					findStallItemList.add(sa);
				}
			}
		} else if (finderIndex == 2) {
			String doo = Helper.readString("Enter Date Of Operation > ");
			for (Stall sa : StallList) {
				if (sa.getDate().contains(doo)) {
					findStallItemList.add(sa);
				}
			}

			/*
			 * 
			 */

			if (findStallItemList.size() == 0) {
				System.out.println("Nothing is found!");
			} else {
				System.out.println(String.format("Index %-20s %-30s", "Name", "Date OF Operation"));
				for (int i = 0; i < findStallItemList.size(); i++) {
					System.out.println(String.format("%-5d %-20s %-30s  ", i + 1, StallList.get(i).getStallName(),
							StallList.get(i).getDate()));
				}

				int choice = Helper.readInt("Enter the index > ");
				if (choice <= 0 || choice > findStallItemList.size()) {
					System.out.println("Invalid input!");
				} else {
					String name = findStallItemList.get(choice - 1).getStallName();
					String category = findStallItemList.get(choice - 1).getDate();

					for (int x = 0; x < StallList.size(); x++) {
						if (StallList.get(x).getStallName().equals(name) && StallList.get(x).getDate().equals(category))
							StallList.remove(x);
					}

					System.out.println(name + " is removed!");
				}
			}
		}
	}

	// ================================= Option 1.2.1 - Add food Items =================================
	// ================================= Option 1.2.2 - View food Items =================================
	// ================================= Option 1.2.3 - Change food Items =================================
	// ================================= Option 1.2.4 - Remove food Items =================================

	// Option 1.3 - View Promotion Offers (Done at Stall Staff)

	// Option 1.4 - Receive purchase orders (Same as View purchase orders) (Done at Stall Staff)

	// ================================= Option 1.5 - Generate sales report =================================

	// ================================= Option 2 - Stall Staff =================================

	// ================================= Option 2.1 - View orders and update status =================================

	// ================================= Option 2.2.1 - Add purchase orders =================================
	// ================================= Option 2.2.2 - View purchase orders =================================
	// ================================= Option 2.2.3 - Change purchase orders =================================
	// ================================= Option 2.2.4 - Remove purchase orders =================================

	// ================================= Option 2.3.1 - Add Promotion Offers =================================
	// ================================= Option 2.3.2 - View Promotion Offers =================================
	// ================================= Option 2.3.3 - Change Promotion Offers =================================
	// ================================= Option 2.3.4 - Remove Promotion Offers =================================

	// ================================= Option 3 - Customer =================================

	// Option 3.1 - View Menu food Items (Same as View food Items) (Done at Canteen Admin)

	// ================================= Option 3.2(1) - Place Order =================================
	private static void placeOrder(ArrayList<FoodItem> foodItemList) {
		int counter = 0;
		String cont = "";

		while (!(cont.equalsIgnoreCase("N"))) {
			String foodName = Helper.readString("Enter food item's name > ");
			// CustomerOrder(String foodItemName, int foodItemSellingPrice, LocalDate
			// orderDate, int orderQty)
			for (FoodItem i : foodItemList) {
				if (i.getFoodItemName().equals(foodName)) {

					int foodItemQty = Helper.readInt("Enter food item's quantity > ");
					counter = counter + foodItemQty;

					if (counter < 5) {
						String conti = Helper.readString("Continue to add more food items? (Y/N) > ");
						if (conti.equalsIgnoreCase("Y")) {
							cont = "Y";
						} else {
							System.out.println("Automatically submitting order...");
							cont = "N";
						}
					} else if (counter == 5) {
						System.out.println("Order has the maximum number of food items! (Max: 5)");
						System.out.println("Automatically submitting order...");
						cont = "N";
					} else {
						System.out.println("Exceeded maximum number of food items! (Max: 5)");
						System.out.println("Please order again!");
						cont = "N";
					}
				} else {
					System.out.println("Invalid food item name.\nPlease order again!");
					cont = "N";
				}
			}
		}
		System.out.println("Returning back to Main Menu (Customer)");
	}
}
// ================================= Option 3.2(2) - Calculate total =================================

// ================================= Option 3.3.1 - Add Orders =================================
// ================================= Option 3.3.2 - View Orders =================================
// ================================= Option 3.3.3 - Change Orders =================================
// ================================= Option 3.3.4 - Remove Orders =================================
