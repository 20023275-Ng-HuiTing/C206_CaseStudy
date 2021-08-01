import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		ArrayList<FoodItem> foodItemList = new ArrayList<FoodItem>();

		int option = 0;
		int optionCA = 0;
		int optionSS = 0;
		int optionCus = 0;

		while (option != 4) { // users select which role they are
			C206_CaseStudy.menuRole();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) { // for canteen admin
				while (optionCA != 6) {
					C206_CaseStudy.menuCA();
					optionCA = Helper.readInt("Enter an option > ");
					if (optionCA == 1) { // Manage stalls

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

	// ================================= Option 1 - Canteen Admin =================================
	
	// ================================= Option 1.1.1 - Add stalls   =================================
	// ================================= Option 1.1.2 - View stalls   =================================
	// ================================= Option 1.1.3 - Change stalls   =================================
	// ================================= Option 1.1.4 - Remove stalls   =================================
	
	// ================================= Option 1.2.1 - Add food Items   =================================
	// ================================= Option 1.2.2 - View food Items   =================================
	// ================================= Option 1.2.3 - Change food Items   =================================
	// ================================= Option 1.2.4 - Remove food Items   =================================
	
	// Option 1.3 - View Promotion Offers (Done at Stall Staff)
	
	// Option 1.4 - Receive purchase orders (Same as View purchase orders) (Done at Stall Staff)
	
	// ================================= Option 1.5 - Generate sales report   =================================
	
	// ================================= Option 2 - Stall Staff =================================
	
	// ================================= Option 2.1 - View orders and update status  =================================
	
	// ================================= Option 2.2.1 - Add purchase orders   =================================
	// ================================= Option 2.2.2 - View purchase orders   =================================
	// ================================= Option 2.2.3 - Change purchase orders   =================================
	// ================================= Option 2.2.4 - Remove purchase orders   =================================
	
	// ================================= Option 2.3.1 - Add Promotion Offers   =================================
	// ================================= Option 2.3.2 - View Promotion Offers   =================================
	// ================================= Option 2.3.3 - Change Promotion Offers   =================================
	// ================================= Option 2.3.4 - Remove Promotion Offers   =================================
	
	// ================================= Option 3 - Customer =================================
	
	// Option 3.1 - View Menu food Items (Same as View food Items) (Done at Canteen Admin)
	
	// ================================= Option 3.2.1 - Place Order =================================
	// ================================= Option 3.2.2 - Calculate total =================================
	
	// ================================= Option 3.3.1 - Add Orders =================================
	// ================================= Option 3.3.2 - View Orders =================================
	// ================================= Option 3.3.3 - Change Orders =================================
	// ================================= Option 3.3.4 - Remove Orders =================================
}
