package warehouse;

import java.util.concurrent.atomic.AtomicInteger;

public class Warehouse {
	
	
    private Integer location;
    private AtomicInteger stock;

    // Constructor 
    public Warehouse(Integer location, Integer initialStock) {
        this.location = location;
        this.stock = new AtomicInteger(initialStock);
    }

   
    public Integer getLocation() {
        return location;
    }

   
    public int getStock() {
        return stock.get();
    }
    
    public int decreaseStock(int quantity) {
        return stock.addAndGet(-quantity);
    }

    public void increaseStock(int quantity) {
        stock.addAndGet(quantity);
    }

	

}
