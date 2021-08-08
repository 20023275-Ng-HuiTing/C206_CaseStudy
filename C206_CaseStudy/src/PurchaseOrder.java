
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20009455, 4 Aug 2021 12:25:37 pm
 */
//austin

public class PurchaseOrder {


	private String PONum;
	private String PODate;
	private String ingredientsDesc;
	private int ingredientsQty;

	public PurchaseOrder(String PONum, String PODate, String ingredientsDesc, int ingredientsQty) {
		super();
		this.PONum = PONum;
		this.PODate = PODate;
		this.ingredientsDesc = ingredientsDesc;
		this.ingredientsQty = ingredientsQty;
	}

	public String getPONum() {
		return PONum;
	}

	public void setPONum(String pONum) {
		PONum = pONum;
	}

	public String getPODate() {
		return PODate;
	}

	public void setPODate(String pODate) {
		PODate = pODate;
	}
	public String getIngredientsDesc() {
		return ingredientsDesc;
	}

	public void setIngredientsDesc(String ingredientsDesc) {
		this.ingredientsDesc = ingredientsDesc;
	}

	public int getIngredientsQty() {
		return ingredientsQty;
	}

	public void setIngredientsQty(int ingredientsQty) {
		this.ingredientsQty = ingredientsQty;
	}


	
}
