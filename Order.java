package warehouse;

public class Order {
	private Integer itemId;
    private int quantity;

    
    public Order(Integer itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Integer getItemId() {
        return itemId;
    }


    public int getQuantity() {
        return quantity;
    }
	
	

}
