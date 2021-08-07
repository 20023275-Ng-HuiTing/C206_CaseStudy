import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//HuiTing
	private CustomerOrder co1;
	private CustomerOrder co2;

	
	private ArrayList<CustomerOrder> orderList;
	
	@Before
	public void setUp() throws Exception {
		// prepare test data - Hui Ting
		co1 = new CustomerOrder(1, "Cupcake", 1, 2);
		co2 = new CustomerOrder(2, "Cake", 3, 5);
		
		orderList = new ArrayList<CustomerOrder>();
	}

	@After
	public void tearDown() throws Exception {
		co1 = null;
		co2 = null;
		orderList = null;
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

}
