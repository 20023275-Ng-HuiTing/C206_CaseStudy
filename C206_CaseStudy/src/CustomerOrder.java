import java.time.LocalDate;
// Hui Ting

public class CustomerOrder extends FoodItem {
	private LocalDate orderDate;
	private int orderQty;

	public CustomerOrder(String foodItemName, int foodItemSellingPrice, LocalDate orderDate, int orderQty) {
		super(foodItemName, foodItemSellingPrice);
		this.orderDate = orderDate;
		this.orderQty = orderQty;
	}

	public LocalDate getOrderDate() {
		LocalDate orderDate = java.time.LocalDate.now();
		return orderDate;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public int getOrderTotalAmount() {
		int total = getOrderQty() * getFoodItemSellingPrice();
		return total;
	}

	public String printInfo() {
		String output = String.format("%-10s %-10s %-10d %-10d", getOrderDate(), getFoodItemName(), getOrderQty(),
				getOrderTotalAmount());
		return output;
	}

}