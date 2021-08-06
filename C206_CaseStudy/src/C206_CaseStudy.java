import java.time.LocalDate;
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		ArrayList<FoodItem> foodItemList = new ArrayList<FoodItem>();
		//for testing

		foodItemList.add(new FoodItem("Cupcake", 3));
		foodItemList.add(new FoodItem("Chicken", 4));
		
		ArrayList<PromotionOffers> promoList = new ArrayList<PromotionOffers>();
//		promoList.add(new PromotionOffers("food", 2, 1, "5/8/2021", "6/8/2021"));
		
		ArrayList<CustomerOrder> orderList = new ArrayList<CustomerOrder>();
		//for testing
		orderList.add(new CustomerOrder(0, "-", 0, 0));

		ArrayList<Stall> StallList = new ArrayList<Stall>();

		int option = 0;
		int optionCA = 0;
		int optionSS = 0;
		int optionCus = 0;
		int optionCAS = 0;
		int optionCAFI = 0; 
		int optionCusO = 0;
		int optionSSPO = 0;
		
		while (option != 4) { // users select which role they are
			C206_CaseStudy.menuRole();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) { // for canteen admin
				while (optionCA != 6) {
					C206_CaseStudy.menuCA();
					optionCA = Helper.readInt("Enter an option > ");
					
					if (optionCA == 1) { // Manage stalls
						C206_CaseStudy.menuCAS();
						optionCAS = Helper.readInt("Enter an option > ");
						
						while (optionCAS != 5){
						
							if (optionCAS == 1) {// Add new Stall
								 Stall ns = inputStall();
								 C206_CaseStudy.addStall(StallList, ns);
								 
							} else if (optionCAS == 2) {// view new stall
								C206_CaseStudy.retrieveAllStall(StallList);
								C206_CaseStudy.viewAllStall(StallList);
								C206_CaseStudy.retrieveAllStall1(StallList);
								
							} else if( optionCAS == 3) {// delete stall
								C206_CaseStudy.deleteStall(StallList);
								
							} else if (optionCAS == 4) {// update stall
								C206_CaseStudy.UpdateStall(StallList, null );
								
							} else if (optionCAS == 5) {// QUIT
								System.out.println("Quit.");
							} else {
								System.out.println("invalid option");
							}
							C206_CaseStudy.menuCAS();
							optionCAS = Helper.readInt("Enter an option > ");
						}
					} else if (optionCA == 2) { // Manage food items
						C206_CaseStudy.menuCAFI();
						optionCAFI = Helper.readInt("Enter an option > ");
						
						while (optionCAFI != 5) {

							if (optionCAFI == 1) { // Add new food item
								FoodItem food = inputFoodItem(foodItemList);
								C206_CaseStudy.addFoodItem(foodItemList, food);

							} else if (optionCAFI == 2) { // View food items
								C206_CaseStudy.viewAllFoodItem(foodItemList);

							} else if( optionCAFI == 3) { // Change food item
								C206_CaseStudy.UpdateFood(foodItemList);

							} else if (optionCAFI == 4) {// Delete food item
								C206_CaseStudy.removeFoodItem(foodItemList);

							} else if (optionCAFI == 5) {
								System.out.println("Quit...");

							} else {
								System.out.println("invalid option");
							}
							C206_CaseStudy.menuCAFI();
							optionCAFI = Helper.readInt("Enter an option > ");
						}
					} else if (optionCA == 3) { // View Promotion Offers
						C206_CaseStudy.viewPromotionOffers(promoList);
						break;
						
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
						C206_CaseStudy.menuSSPO();
						optionSSPO = Helper.readInt("Enter an option > ");
						
						while (optionSSPO != 5) {
							
							if (optionSSPO == 1) {
								PromotionOffers po = inputPromotion(foodItemList, promoList);
								C206_CaseStudy.addPromo(promoList, po);
								break;
								
							} else if (optionSSPO == 2) {
								C206_CaseStudy.viewPromotionOffers(promoList);
								break;
								
							} else if (optionSSPO == 3) {
								C206_CaseStudy.changePromo(promoList);
								
							} else if (optionSSPO == 4) {
								C206_CaseStudy.removePromo(promoList);
								break;
								
							} else if (optionSSPO == 5) {
								System.out.println("Quit...");
								
								
							} else {
								System.out.println("Invalid Option");
							}
						}
						
					} else if (optionSS == 4) {
						System.out.println("Return back to Role Selection...");
						
					} else {
						System.out.println("Invalid option");
					}
				}
			} else if (option == 3) { // for Customer
				while (optionCus != 3) {
					C206_CaseStudy.menuCus();
					optionCus = Helper.readInt("Enter an option > ");
					if (optionCus == 1) { // View Menu Items
						C206_CaseStudy.viewAllFoodItem(foodItemList);
						
					} else if (optionCus == 2) { // Manage Orders
						C206_CaseStudy.menuCusO();
						optionCusO = Helper.readInt("Enter an option > ");
						
						while (optionCusO != 5) {
							if (optionCusO == 1) { // Add order
								CustomerOrder co = inputOrder(orderList, foodItemList);
								C206_CaseStudy.addOrder(orderList, co);
								
							} else if (optionCusO == 2) { // View order
								C206_CaseStudy.viewAllOrders(orderList);
								
							} else if( optionCusO == 3) { // Change order
								int input = Helper.readInt("Enter an existing Order ID > ");
								C206_CaseStudy.updateOrder(orderList, input);
								
							} else if (optionCusO == 4) {// Delete order
								C206_CaseStudy.removeOrder(orderList);
								
							} else if (optionCusO == 5) {
								System.out.println("Quit...");
								
							} else {
								System.out.println("Invalid option");
							}
							C206_CaseStudy.menuCusO();
							optionCusO = Helper.readInt("Enter an option > ");
						}
					} else if (optionCus == 3) {
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
		System.out.println("1.Add New Stall\n2.View Stall\n3.Remove Stall\n4.Update Stall\n5.Quit");
	}
	
	public static void menuCAFI() {
		C206_CaseStudy.setHeader();
		System.out.println("Manage Food Items");
		Helper.line(80, "-");
		System.out.println("1.Add Food Items\n2.View Food Items\n3.Change Food Items\n4.Remove Food Items\n5. Quit");
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
		System.out.println("1. View Menu Items\n2. Manage Orders\n3. Quit");
	}

	public static void menuCusO() {
		C206_CaseStudy.setHeader();
		System.out.println("Manage Orders");
		Helper.line(80, "-");
		System.out.println("1.Add Orders\n2.View Orders\n3.Change Orders\n4.Remove Orders\n5. Quit");
	}
	
	public static void setHeader() {
		Helper.line(80, "=");
		System.out.println("Canteen Automation System (CAS)");
		Helper.line(80, "=");
	}

	public static void menuSSPO() {
		C206_CaseStudy.setHeader();
		System.out.println("Manage Promotion Offers");
		Helper.line(80, "-");
		System.out.println("1.Add Promotion Offers\n2.View Promotion Offers\n3.Change Promotion Offers"
				+ "\n4.Remove Promotion Offers\n5. Quit");
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

	// ================================= Option 1.2.1 - Add food Items   =================================
	// Charlene			
	public static FoodItem inputFoodItem(ArrayList<FoodItem> FoodItemList) {
		String foodName = Helper.readString("Enter Food Name > ");
		int foodPrice = Helper.readInt("Enter Food Price > ");

		FoodItem food = new FoodItem(foodName, foodPrice);
		return food;
	}

	public static void addFoodItem(ArrayList<FoodItem> FoodItemList, FoodItem food) {
		FoodItemList.add(food);
		System.out.println("new food added");
	}

	// ================================= Option 1.2.2 - View food Items   =================================
	//charlene
	public static String retrieveAllFoodItem(ArrayList<FoodItem> FoodItemList) {
		String output = "";

		for (int i = 0; i < FoodItemList.size(); i++) {
			output += String.format("%-10s %40d\n", FoodItemList.get(i).getFoodItemName(), FoodItemList.get(i).getFoodItemSellingPrice());
		}
		return output;
	}

	public static void viewAllFoodItem(ArrayList<FoodItem> FoodItemList) {
		String output = "";
		if (FoodItemList.isEmpty()) {
			output = "You have no existing food item.";
		}
		else {
			output = String.format("%-10s %40s\n", "FOOD ITEM", "SELLING PRICE");
			output += retrieveAllFoodItem(FoodItemList);
			System.out.println(output);
		}
	}

	// ================================= Option 1.2.3 - Change food Items   =================================
	// Charlene	
	public static boolean UpdateFood(ArrayList<FoodItem> FoodItemList) {
		String foodName = Helper.readString("Enter Food Name > ");

		boolean isUpdated = false;

		for (int i = 0; i < FoodItemList.size(); i++) {
			if (foodName.equals(FoodItemList.get(i).getFoodItemName())) {
				int price = Helper.readInt("Enter new price > ");
				
				FoodItemList.get(i).setFoodItemSellingPrice(price);
				System.out.println("Price for " + foodName + " is updated.");
				
				isUpdated = true;
			} 
		}
		if (isUpdated = false) {
			System.out.println("Update fail.");
		}
		return isUpdated;
	}

	// ================================= Option 1.2.4 - Remove food Items   =================================
	// Charlene
	public static void removeFoodItem(ArrayList<FoodItem> FoodItemList) {
		boolean isDeleted = false;
		String foodName = Helper.readString("Enter Food Name > ");

		for (int i = 0; i < FoodItemList.size(); i ++) {
			if (foodName.equals(FoodItemList.get(i).getFoodItemName())) {
				char confirmation = Helper.readChar("Are you sure? (Y/N) > ");
				if (confirmation == 'y' || confirmation == 'Y') {
					FoodItemList.remove(i);
					isDeleted = true;
					System.out.println("Food is deleted succesfully");
				} else if (confirmation == 'n' || confirmation == 'N') {
					System.out.println("Transaction cancelled.");
				} else {
					System.out.println("Invalid input.");
				}
			}
		}
		if (isDeleted == false) {
			System.out.println("Food is not deleted succesfully.");
		}
	}

	// Option 1.3 - View Promotion Offers (Done at Stall Staff)

	// Option 1.4 - Receive purchase orders (Same as View purchase orders) (Done at Stall Staff)

	// ================================= Option 1.5 - Generate sales report =================================

	// ================================= Option 2 - Stall Staff =================================
	// ================================= Option 2.1 - View orders and update status  =================================
	
	// ================================= Option 2.2.1 - Add purchase orders   =================================
	// ================================= Option 2.2.2 - View purchase orders   =================================
	// ================================= Option 2.2.3 - Change purchase orders   =================================
	// ================================= Option 2.2.4 - Remove purchase orders   =================================
	
	
	
	
	// ================================= Option 2.3.1 - Add Promotion Offers   =================================
	public static PromotionOffers inputPromotion(ArrayList<FoodItem> foodItemList, ArrayList<PromotionOffers> promoList) {
		int promoprice = 0;
		String startDate = "";
		String endDate = "";
		boolean isValid = false;
		PromotionOffers po = null;
		int foodItemPrice = 0;
		String foodName = Helper.readString("Enter food item's name > ");
		for (FoodItem i : foodItemList) {
			if (foodName.equalsIgnoreCase(i.getFoodItemName())) {
				foodItemPrice = i.getFoodItemSellingPrice();
				promoprice = Helper.readInt("Enter Promotion price for item > ");
				startDate = Helper.readString("Enter start date for promo > ");
				endDate = Helper.readString("Enter end date for promo > ");
				isValid = true;
			}
		}
		for (PromotionOffers p: promoList) {
			if (foodName.equalsIgnoreCase(p.getFoodItemName())) {
				p.setFoodItemPromotionPrice(promoprice);
				p.setStartDate(startDate);
				p.setEndDate(endDate);
				isValid = true;
			}
		}
		if (isValid == true) {
			po = new PromotionOffers(foodName, foodItemPrice, promoprice, startDate, endDate);

		}
		else if (isValid == false) {
			po = null;
		}
		return po;
	}
	public static void addPromo(ArrayList<PromotionOffers> promoList, PromotionOffers po) {
		if (po != null) {
			promoList.add(po);
			System.out.println("Promotion succesfully added!");
		} else {
			System.out.println("Promotion unsuccessfully added!");
		}
		
	}
	
	
	
	// ================================= Option 2.3.2 - View Promotion Offers   =================================
	
	public static void viewPromotionOffers(ArrayList<PromotionOffers> promoList) {
		
		String output = "";
		output += String.format("%-10s %-10s %-20s %-19s %-15s\n", "Food Name", "Food Price", 
				"Promotion Price", "Start Date", "End Date");
		
		for (PromotionOffers p : promoList) {
			output += String.format("%-10s $%-9d $%-19d %-19s %-15s\n", p.getFoodItemName(), 
					p.getFoodItemSellingPrice(), p.getFoodItemPromotionPrice(), p.getStartDate()
					, p.getEndDate());
		} 
		System.out.println(output);
	}
	
	// ================================= Option 2.3.3 - Change Promotion Offers   =================================
	public static void changePromo(ArrayList<PromotionOffers> promoList) {
		
	}
	
	
	// ================================= Option 2.3.4 - Remove Promotion Offers   =================================
	public static void removePromo(ArrayList<PromotionOffers> promoList) {
		
		boolean isValid = false;
		String itemName = Helper.readString("Enter an existing Item name > ");
		
		for (PromotionOffers p : promoList) {
			
			if (itemName.equalsIgnoreCase(p.getFoodItemName())) {
				
				char cfm = Helper.readChar("Confirm removal of Promotion? (Y/N) > ");
				if (cfm == 'Y' || cfm == 'y') {
					
					promoList.remove(p);
					System.out.println("Item removed successfully!");
					
				} else {
					System.out.println("Removal of Promotion Offer cancelled.");
				}
			}
			isValid = true;
			break;
		}
		if (isValid == false) {
			System.out.println("Item Name does not Exist!");
		}
	}
	
	
	// ================================= Option 3 - Customer =================================

	// ================================= Option 3.2(1) - Place Order =================================
	//Hui Ting
	public static CustomerOrder inputOrder(ArrayList<CustomerOrder> orderList, ArrayList<FoodItem> foodItemList) {
		int foodItemQty = 0;
		int sellingprice = 0;
		String foodName = "";
		CustomerOrder co = null;
		
		int orderid = Helper.readInt("Enter order ID > ");
		
		for (CustomerOrder o : orderList) {
			if (orderid != o.getOrderID()) {
				foodName = Helper.readString("Enter food item's name > ");
				for (FoodItem i : foodItemList) {
					if (foodName.equals(i.getFoodItemName())) {
						sellingprice = i.getFoodItemSellingPrice();
						foodItemQty = Helper.readInt("Enter food item's quantity > ");
						if (foodItemQty <= 5) {
							co = new CustomerOrder(orderid, foodName, sellingprice, foodItemQty);
							break;
						} else {
							System.out.println("Order quantity exceeded. (Max: 5)");
							break;
						}
					} else {
						System.out.println("Invalid food item name\nPlease order again!");
						break;
					}
				}
			} else {
				System.out.println("Invalid Order ID\nPlease order again!");
				break;
			}
		} 
		return co;
	}
	
	// ================================= Option 3.2(2) - Calculate total =================================
	//Hui Ting
	public static int getOrderTotalAmount(ArrayList<CustomerOrder> orderList) {
		int total = 0;
		for (CustomerOrder i : orderList) {
			total += i.getOrderQty() * i.getFoodItemSellingPrice();
		}
		return total;
	}

	// ================================= Option 3.3.1 - Add Orders =================================
	public static void addOrder(ArrayList<CustomerOrder> orderList, CustomerOrder co) {
		if (co != null) {
			orderList.add(co);
			System.out.println("Order added");
		} else {
			System.out.println("Order adding failed");
		}
	}
	
	// ================================= Option 3.3.2 - View Orders =================================
	public static String getOrder(ArrayList<CustomerOrder> orderList) {
		String output = "";

		for (CustomerOrder o : orderList) {
			output += o.printInfo();
		}
		output += "Order Total Amount: $" + Integer.toString(getOrderTotalAmount(orderList)) + "\n";
		return output;
	}
	
	public static String getOrderDate() {
		LocalDate orderDate = LocalDate.now();
		String orderdate = orderDate.toString();
		return orderdate;
	}
	
	public static void viewAllOrders(ArrayList<CustomerOrder> orderList) {
		System.out.println("ALL ORDERS");
		Helper.line(50, "-");
		String output = "Order Date: " + getOrderDate() + "\n";
		output += String.format("%-5s %-10s %-10s %-10s\n", "ID",  "Food Name", "Food Price", "Quantity");
		output += getOrder(orderList);
		System.out.println(output);
	}
	
	// ================================= Option 3.3.3 - Update Orders =================================
	// Hui Ting
	public static void updateOrder(ArrayList<CustomerOrder> orderList, int input) {
		boolean isValid = false;
		
		for (CustomerOrder o : orderList) {
			if (input == o.getOrderID()) {
				isValid = true;
				int newOrderQty = o.getOrderQty() + 1;
				if (newOrderQty < 5 ) {
					o.setOrderQty(newOrderQty);
					System.out.println("You have updated your order.\nPlease view orders for more information");
					break;
				} else {
					System.out.println("Order quantity exceeded. (Max: 5)");
				}
			}
		}
		if (isValid == false) {
			System.out.println("Order ID does not exist.");
		}
	}
	
	// ================================= Option 3.3.4 - Remove Orders =================================
	// Hui Ting
	public static void removeOrder(ArrayList<CustomerOrder> orderList) {
		boolean isValid = false;
		int input = Helper.readInt("Enter an existing Order ID > ");
		
		for (CustomerOrder o : orderList) {
			if (input == o.getOrderID()) {
				isValid = true;
				char cfm = Helper.readChar("Are you sure? (Y/N) > ");
				if (cfm == 'Y' || cfm == 'y') {
					orderList.remove(o);
					System.out.println("You have successfully deleted your order");
					break;
				} else {
					System.out.println("Removal of Order cancelled...");
					break;
				
				}
			}
		}
		if (isValid == false) {
			System.out.println("Order ID does not exist.");
		}
	}
}
