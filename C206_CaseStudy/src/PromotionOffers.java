
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20046729, 1 Aug 2021 3:13:49 pm
 */
public class PromotionOffers extends FoodItem {
	private int foodItemPromotionPrice;
	private String startDate;
	private String endDate;
	
	public PromotionOffers(String foodItemName, int foodItemSellingPrice, int foodItemPromotionPrice, 
			String startDate, 
			String endDate) {
		super(foodItemName, foodItemSellingPrice);
		this.foodItemPromotionPrice = foodItemPromotionPrice;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getFoodItemPromotionPrice() {
		return foodItemPromotionPrice;
	}

	public void setFoodItemPromotionPrice(int foodItemPromotionPrice) {
		this.foodItemPromotionPrice = foodItemPromotionPrice;
	}
}
