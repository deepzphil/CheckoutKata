package Checkout;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckoutPrice {
	 public static Map<String, Integer> itemPrices = new HashMap<>();
	 public static Map<String, Offer> offerItems = new HashMap<>();

	 static {
		itemPrices.put("A", 50);
		itemPrices.put("B", 30);
		itemPrices.put("C", 20);
		itemPrices.put("D", 15);

		offerItems.put("A", new Offer(3, 130));
		offerItems.put("B", new Offer(2, 45));
	  }
	 
	  public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);

		  try {
	        System.out.println("Enter the item name:");
	        Map<String, Integer> cart = new HashMap<>();

	        while (true) {
	            String item = scanner.nextLine();

	            if (item.equalsIgnoreCase("done")) {
	                break;
	            }
	            
	            if (!itemPrices.containsKey(item)) {
	                System.out.println("Invalid item! Please try again.");
	                continue;
	            }

	            // Adds item to cart
	            cart.put(item, cart.getOrDefault(item, 0) + 1);
	            int total = calculateTotal(cart);
	            System.out.println("Current total: " + total + " pence.");
	        }

	        int finalPrice = calculateTotal(cart);
	        System.out.println("Final total: " + finalPrice + " pence. Thank you for shopping with us!");
		  } catch(Exception ex) {
			  // TODO: add error logging to text file			  
	          System.out.println("There was an error during the process. Exception details: " + ex.getMessage());
		  } finally {
			  scanner.close();
		  }
	  }
	  
	  static int calculateTotal(Map<String, Integer> cart) {
	    int total = 0;
	
	    for (Map.Entry<String, Integer> entry : cart.entrySet()) {
	        String item = entry.getKey();
	        int cartIndex = entry.getValue();
	        int price = itemPrices.get(item);
	        
	        Offer specialOffer = offerItems.get(item);
	        
	        if (specialOffer != null && cartIndex >= specialOffer.quantity) {
	            int specialPriceCount = cartIndex / specialOffer.quantity;
	            int regularPriceCount = cartIndex % specialOffer.quantity;
	            
	            total += (specialPriceCount * specialOffer.price) + (regularPriceCount * price);
	            System.out.println("A special price has been given for item " + item);
	        } else {
	            total += cartIndex * price;
	        }
	    }
	
	    return total;
	}
	
	public static class Offer {
		int quantity;
		int price;

        public Offer(int quantity, int price) {
            this.quantity = quantity;
            this.price = price;
        }
	}
}
	        

	    
	    

