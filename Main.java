package warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		
        Warehouse warehouse1 = new Warehouse(5, 10);
        Warehouse warehouse2 = new Warehouse(3, 20);
        Warehouse warehouse3 = new Warehouse(2, 30);
        Warehouse warehouse4 = new Warehouse(10, 40);
       
        
        List<Warehouse> warehouses = new ArrayList<>();
        warehouses.add(warehouse1);
        warehouses.add(warehouse2);
        warehouses.add(warehouse3);
        warehouses.add(warehouse4);
        

        
        OrderProcessingSystem orderProcessingSystem = new OrderProcessingSystem(warehouses);
        int numOrders = 100000;
        int numThreads = Runtime.getRuntime().availableProcessors(); // Using available processors as threads
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        

        
        //ExecutorService executorService = Executors.newFixedThreadPool(1000); 
        
        for (int i = 0; i < 10000; i++) { 
            int orderId = i + 1; 
            Order order = new Order(orderId, 30);
            System.out.println(orderId+" "+ Thread.currentThread().getName());
                
            boolean orderFulfilled = orderProcessingSystem.fulfillOrder(order);
            if (orderFulfilled) {
            	System.out.println(true + " "+ orderId);
               
            	
            } else {
            	System.out.println(false +" "+orderId);
               
            }

        }
        executorService.shutdown();

        try {
            // Wait for all tasks to complete
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


      
    }
	

}
