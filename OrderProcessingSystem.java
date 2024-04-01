package warehouse;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderProcessingSystem extends warehouseSort {
	
    private List<Warehouse> warehouses;


    public OrderProcessingSystem(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public boolean fulfillOrder(Order order) {
    	

      
    	warehouseSort sorter = new warehouseSort();


        sorter.solve(warehouses);
        

        
        int totalStock=0;
        for(Warehouse w: warehouses) {
        	totalStock += w.getStock();
        }
        
        int temp=order.getQuantity();
        
        if(totalStock>=temp) {
        	
        	totalStock -= temp;
        	
        	for(Warehouse  house: warehouses) {
        		int cur=house.getStock();
        		
        		if(cur>=temp) {
        			house.decreaseStock(temp);
        			break;
        		}
        		else {
        			house.decreaseStock(cur);
        			temp=temp-cur;
        		}
        	}
        	
        	System.out.println("Fulfilled"+" "+order.getItemId());
        	return true;
        	
        	
        }
        else {
        	
        	System.out.println("not Fulfilled"+" "+order.getItemId());
        	return false;
        }
        
        
    }


	

}
