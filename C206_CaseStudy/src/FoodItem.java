
public class FoodItem {
	private String foodItemName;
	private int foodItemSellingPrice;

	public FoodItem(String foodItemName, int foodItemSellingPrice) {
		this.foodItemName = foodItemName;
		this.foodItemSellingPrice = foodItemSellingPrice;
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public int getFoodItemSellingPrice() {
		return foodItemSellingPrice;
	}

	public void setFoodItemSellingPrice(int foodItemSellingPrice) {
		this.foodItemSellingPrice = foodItemSellingPrice;
	}

}
