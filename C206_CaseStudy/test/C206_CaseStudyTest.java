import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//HuiTing
	private CustomerOrder co1;
	private CustomerOrder co2;
	//Charlene
	private FoodItem FI1;
	private FoodItem FI2;

	
	private ArrayList<CustomerOrder> orderList;
	//Charlene
	private ArrayList<FoodItem> FoodItemList;
	//Gary
	private Stall s1;
	private Stall s2;
	private Stall s3;
	private Stall s4;
	
	private ArrayList<Stall> StallList;
	
	// austin
	private PurchaseOrder PO1;
	private PurchaseOrder PO2;
	
	private ArrayList<PurchaseOrder> PurchaseList;
	
	@Before
	public void setUp() throws Exception {
		// prepare test data - Hui Ting
		co1 = new CustomerOrder(1, "Cupcake", 1, 2);
		co2 = new CustomerOrder(2, "Cake", 3, 5);
		
		orderList = new ArrayList<CustomerOrder>();
		
		// austin
		PO1 = new PurchaseOrder("2231", "25/5/20", "Milo", 8);
		PO2 = new PurchaseOrder("1222", "30/5/20", "Milk", 9);

		PurchaseList = new ArrayList<PurchaseOrder>();
		//prepare test data - Gary
		
		s1 = new Stall("Chicken Rice Shop", "13 June 2020");
		s2 = new Stall("Chinese Noodle Shop", "13 May 2019");
		s3 = new Stall("Prata Shop", "15 February 2015");
		s4 = new Stall("Western Delight", "2 January 2018");
		
		
		
		StallList = new ArrayList<Stall>();

	}

	@After
	public void tearDown() throws Exception {
		co1 = null;
		co2 = null;
		orderList = null;
		
		PO1 = null;
		PO2 = null;
		PurchaseList = null;
		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		StallList = null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	//======================== Order test method - Hui Ting =================================
	@Test
	public void testAddOrder() {
		//Order list is not null (to add new objects)
		assertNotNull("Test if there is a valid CustomerOrder arraylist to add to", orderList);
		
		//Given an empty list, after adding 1 object, size of list will be 1
		C206_CaseStudy.addOrder(orderList, co1);
		assertEquals("Test if the CustomerOrder arraylist size is 1: ", 1, orderList.size());

		//Add another object. Is the size of the list is 2?
		C206_CaseStudy.addOrder(orderList, co2);
		assertEquals("Test if the CustomerOrder arraylist size is 2: ", 2, orderList.size());
	}
	
	@Test
	public void testviewAllOrders() {
		//Test that orderList is not null before viewing orders
		assertNotNull("Test if there is a valid CustomerOrder arraylist to view", orderList);
		
		//test if the list of orders retrieved from the C206_CaseStudy is empty
		String allOrders = C206_CaseStudy.getOrder(orderList);
		String testOutput = "Order Total Amount: $0\n";
		assertEquals("Check that getOrder", testOutput, allOrders);
		
		//test if the expected output string same as the list of orders retrieved from the C206_CaseStudy
		C206_CaseStudy.addOrder(orderList, co1);
		C206_CaseStudy.addOrder(orderList, co2);
		
		allOrders = C206_CaseStudy.getOrder(orderList);
		testOutput = String.format("%-5s %-10s $%-10d %-10d\n", 1, "Cupcake", 1, 2);
		testOutput += String.format("%-5s %-10s $%-10d %-10d\n", 2, "Cake", 3, 5);
		testOutput += "Order Total Amount: $17\n";
		assertEquals("Check that getOrder", testOutput, allOrders);
	}
	
	@Test
	public void testupdateOrder() {
		//Test that orderList is not null before updating orders
		assertNotNull("Test if there is a valid CustomerOrder arraylist to update", orderList);
		
		//Given an empty list, after adding 1 object, size of list will be 1
		C206_CaseStudy.addOrder(orderList, co1);
		assertEquals("Test if the CustomerOrder arraylist size is 1: ", 1, orderList.size());
		
		//Test that after updating, order quantity increases by 1
		C206_CaseStudy.updateOrder(orderList, co1.getOrderID());
		assertEquals("Test if the order quantity increased by 1: ", 3, co1.getOrderQty());
	}
	
	@Test
	public void testremoveOrder() {
		C206_CaseStudy.addOrder(orderList, co1);
		C206_CaseStudy.addOrder(orderList, co2);
		
		//Test that orderList is not null before deleting orders
		assertNotNull("Test if there is a valid CustomerOrder arraylist to delete from", orderList);
		
		//Test that orderList has 1 object after deleting one order
		C206_CaseStudy.removeOrder(orderList, co1.getOrderID(), 'Y');
		assertEquals("Test if CustomerOrder arraylist has 1 object: " , 1, orderList.size());
		
		//Test that orderList is empty after deleting second order
		C206_CaseStudy.removeOrder(orderList, co2.getOrderID(), 'Y');
		assertEquals("Test if CustomerOrder arraylist is empty: " , 0, orderList.size());
	}
//===================================== Food Item test method - Charlene ===========================================
@Test
public void testAddFoodItem() {
  // Food Item List is not null, so that can add a new Food Item
  assertNull("Test if there is valid Food Item arraylist to add to ", FoodItemList);
  
  //Given an empty list, after adding 1 stall, the size of the list is 1
  C206_CaseStudy.addFoodItem(FoodItemList,FI1);
  assertEquals("Test if the Food Item arraylist size is 1?",1,FoodItemList.size());
  
  
  //The Food Item just added is as same as the First Food Item of the list
  assertSame("Test that Food Item is added same as 1st item of the list?", FI1, FoodItemList.get(0));
  
  //Add another Food Item. test that the size of the list is 2?
  C206_CaseStudy.addFoodItem(FoodItemList, FI2);
  assertEquals("Test that Food Item arraylist size is 2?", 2, FoodItemList.size());
  
}
@Test
  public void testRetrieveAllFoodItem() {
  // test if Food Item list is not null but empty, so that can add new Food Item
  assertNotNull("Test if there is valid Food Item arraylist to add to ", FoodItemList);
  
  // test if the list of Food Item retrieved from the FoodItemList is empty
  
  String allFoodItem = C206_CaseStudy.retrieveAllFoodItem(FoodItemList);
  String  testOutput ="";
  assertEquals("Check ViewAllFoodItemList", testOutput, allFoodItem);
  
  //Given an empty list, after adding 2 Food Item , test if the size of the list is 2 
  C206_CaseStudy.addFoodItem(FoodItemList, FI1);
  C206_CaseStudy.addFoodItem(FoodItemList, FI2);
  assertEquals("Test if that FoodItem arraylist size is 2?", 2, FoodItemList.size());
  
  //test if the expected output string same as the list of stalls retrieved from the Stall_test
  allFoodItem = C206_CaseStudy.retrieveAllFoodItem(FoodItemList);
  
}
@Test
public void testviewAllFoodItem() {
  //Test that FoodItemList is not null before viewing orders
  assertNotNull("Test if there is a valid FoodItem arraylist to view", orderList);
  
  //Given an empty list, after adding 2 items, test if the size of the list is 2
  C206_CaseStudy.addFoodItem(FoodItemList, FI1);
  C206_CaseStudy.addFoodItem(FoodItemList, FI2);
  assertEquals("Test if that Stall arraylist size is 2: ", 2, FoodItemList.size());
  
  //test if the expected output string same as the list of orders retrieved from the C206_CaseStudy
  String allFoodItem = C206_CaseStudy.retrieveAllFoodItem(FoodItemList);
  String testOutput = "";
  allFoodItem = C206_CaseStudy.retrieveAllFoodItem(FoodItemList);
  testOutput = String.format("%-5s %-10s\n", 1, "FOOD ITEM", 1, 2);
  testOutput += String.format("%-5s %-10s\n", 2, "FOOD ITEM", 3, 5);
  assertEquals("Check that getFoodItem", testOutput, allFoodItem);
}
@Test
public void testRemoveFoodItem() {
	C206_CaseStudy.addFoodItem(FoodItemList, FI1);
	C206_CaseStudy.addFoodItem(FoodItemList, FI2);
	
	//Test that FoodItemList is not null before deleting Food Item
	assertNotNull("Test if there is a valid Stall arraylist to delete from", FoodItemList);
	
	//Test that FoodItemList has 1 Food Item after deleting one Food Item
	C206_CaseStudy.removeFoodItem(FoodItemList);
	assertEquals("Test if Food Item arraylist has 1 food: " , 1, FoodItemList.size());
	
	//Test that FoodItemList is empty after deleting second Food Item
	C206_CaseStudy.removeFoodItem(FoodItemList);
	assertEquals("Test if Stall arraylist is empty: " , 0, FoodItemList.size());
}
@Test
public void testupdateFoodItem() {
	//Test that FoodItemList is not null before updating Food Item
	assertNotNull("Test if there is a valid Food Item arraylist to update", FoodItemList);
	
	//Given an empty list, after adding 1 object, size of list will be 1
	C206_CaseStudy.addFoodItem(FoodItemList, FI1);
	assertEquals("Test if the Stall arraylist size is 1: ", 1, FoodItemList.size());
	
	//Test that after updating, Stall quantity increases by 1
	C206_CaseStudy.addFoodItem(FoodItemList, FI1.getFoodItemName());
	assertEquals("Test if the Stall increased by 1: ", 3, FI1.getFoodItemName());
}



	
	@Test
	public void TestaddPurchaseOrder() {
		// Purchase list is not null, so that can add new purchase order
		assertNotNull("Check if there is valid PurchaseOrder arraylist to add to", PurchaseList);
		
		//Given an empty purchase list, after adding 1 purchase order, the size of the list is 1
		C206_CaseStudy.addPurchaseOrder(PurchaseList, PO1);		
		assertEquals("Test if that PurchaseOrder arraylist size is 1?", 1, PurchaseList.size());
		
		
		//Add another purchase order. Test the size of the purchase order list is 2?
		C206_CaseStudy.addPurchaseOrder(PurchaseList, PO2);
		assertEquals("Test that PurchaseOrder arraylist size is 2?", 2, PurchaseList.size());
		assertSame("Check that PurchaseOrder is added", PO2, PurchaseList.get(1));
	}
	@Test
public void TestViewAllPurchaseOrder() {
		
//		Test if PurchaseList is not null but empty - boundary
		assertNotNull("Test if there is valid PurchaseOrder arraylist to retrieve purchase order", PurchaseList);
		
//		Test if the list of Purchase order retrieved from the Purchase List is empty - boundary
		
		String allPurchaseOrder = C206_CaseStudy.retrieveAllPurchaseOrder(PurchaseList);
		
		String testOutput = "";
		assertEquals("Check that ViewAllPurchaseOrder", testOutput, allPurchaseOrder);
		
//		Given an empty list, after adding 2 purchase order, test if the size of the purchase list is 2 - normal
		
		C206_CaseStudy.addPurchaseOrder(PurchaseList,PO1);
		C206_CaseStudy.addPurchaseOrder(PurchaseList,PO2);
		
		assertEquals("Test that PurchaseOrder arraylist size is 2", 2, PurchaseList.size());
		
//		Test if the expected output string same as the list of Purchase Order retrieved from PurchaseList
		
		allPurchaseOrder = C206_CaseStudy.retrieveAllPurchaseOrder(PurchaseList);
		testOutput = String.format("%-10s %-20s %-30s %-20s\n", "2231", "25/5/20", "Milo", 8);
		testOutput += String.format("%-10s %-20s %-30s %-20s\n", "1222", "30/5/20", "Milk", 9);

		
		assertEquals("Test that retrieveAllPurchaseOrder", testOutput, allPurchaseOrder);
		
	}
		@Test
		public void deletePurchaseOrder() {
			
//			Test if purchase order list is not null but empty - boundary
			assertNotNull("Test if there is purchase order arraylist to retrieve purchase order", PurchaseList);
			
//			Test if the purchase order retrieved from the user list is empty - boundary
		
			assertEquals("Test that PurchaseOrder arrayList size is 0", 0, PurchaseList.size());
			
//			Test if the purchase order in the purchase list is able to delete 
//			Check if the purchase order is in the array list is not deleted
			C206_CaseStudy.addPurchaseOrder(PurchaseList, PO1);
			C206_CaseStudy.addPurchaseOrder(PurchaseList, PO2);
			PurchaseList.remove(PO1);
			
			assertEquals("Test that PurchaseOrder arraylist is 1 ", 1, PurchaseList.size());
			
		}
	//======================== Stall test method - Gary =================================
	
	@Test
	public void testAddStall() {
		// Stall List is not null, so that can add a new Stall
		assertNull("Test if there is valid Stall arraylist to add to ", StallList);
		
		//Given an empty list, after adding 1 stall, the size of the list is 1
		Stall.addStall(StallList,s1);
		assertEquals("Test if the Stall arraylist size is 1?",1,StallList.size());
		
		
		//The Stall just added is as same as the First Stall of the list
		assertSame("Test that Stall is added same as 1st item of the list?", s1, StallList.get(0));
		
		//Add another stall. test that the size of the list is 2?
		Stall.addStall(StallList, s2);
		assertEquals("Test that Stall arraylist size is 2?", 2, StallList.size());
		
	}
	@Test
		public void testRetrieveAllStall() {
		// test if Stall list is not null but empty, so that can add new Stall
		assertNotNull("Test if there is valid Stall arraylist to add to ", StallList);
		
		// test if the list of Stall retrieved from the StallList is empty
		
		String allStall = C206_CaseStudy.retrieveAllStall(StallList);
		String  testOutput ="";
		assertEquals("Check ViewAllStallList", testOutput, allStall);
		
		//Given an empty list, after adding 2 stalls , test if the size of the list is 2 
		C206_CaseStudy.addStall(StallList, s1);
		C206_CaseStudy.addStall(StallList, s2);
		assertEquals("Test if that Stall arraylist size is 2?", 2, StallList.size());
		
		//test if the expected output string same as the list of stalls retrieved from the Stall_test
		allStall = C206_CaseStudy.retrieveAllStall(StallList);
		
	}
	@Test
	public void testviewAllStall() {
		//Test that StallList is not null before viewing orders
		assertNotNull("Test if there is a valid Stall arraylist to view", StallList);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addStall(StallList, s1);
		C206_CaseStudy.addStall(StallList, s2);
		assertEquals("Test if that Stall arraylist size is 2: ", 2, StallList.size());
		
		//test if the expected output string same as the list of orders retrieved from the C206_CaseStudy
		String allStall = C206_CaseStudy.retrieveAllStall(StallList);
		String testOutput = "";
		allStall = C206_CaseStudy.retrieveAllStall(StallList);
		testOutput = String.format("%-10s %40s\n",   "Chicken Rice Shop", " 13 June 2020");
		testOutput += String.format("%-10s %40s\n", "Chinese Noodle Shop", "13 May 2019");
		assertEquals("Check that getStall", testOutput, allStall);
	}
	@Test
	public void testRemoveStall() {
		C206_CaseStudy.addStall(StallList, s1);
		C206_CaseStudy.addStall(StallList, s2);
		
		//Test that StallList is not null before deleting Stalls
		assertNotNull("Test if there is a valid Stall arraylist to delete from", StallList);
		
		//Test that StallList has 1 Stall after deleting one Stall
		C206_CaseStudy.deleteStall(StallList);
		assertEquals("Test if Stall arraylist has 1 stall: " , 1, StallList.size());
		
		//Test that StallList is empty after deleting second Stall
		C206_CaseStudy.deleteStall(StallList);
		assertEquals("Test if Stall arraylist is empty: " , 0, StallList.size());
	}
	@Test
	public void testupdateStall() {
		//Test that StallList is not null before updating Stalls
		assertNotNull("Test if there is a valid Stall arraylist to update", StallList);
		
		//Given an empty list, after adding 1 object, size of list will be 1
		C206_CaseStudy.addStall(StallList, s1);
		assertEquals("Test if the Stall arraylist size is 1: ", 1, StallList.size());
		
		//Test that after updating, Stall quantity increases by 1
		C206_CaseStudy.UpdateStall(StallList, s1.getStallName());
		assertEquals("Test if the Stall increased by 1: ", 3, s1.getStallName());
	}


}
