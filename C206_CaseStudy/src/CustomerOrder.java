
// Hui Ting

public class CustomerOrder extends FoodItem {
	private int orderID;
	private int orderQty;

	public CustomerOrder(int orderID, String foodItemName, int foodItemSellingPrice, int orderQty) {
		super(foodItemName, foodItemSellingPrice);
		this.orderID = orderID;
		this.orderQty = orderQty;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public String printInfo() {
		String output = String.format("%-5s %-10s $%-10d %-10d\n", getOrderID(), getFoodItemName(), getFoodItemSellingPrice(), getOrderQty());
		return output;
	}

}
