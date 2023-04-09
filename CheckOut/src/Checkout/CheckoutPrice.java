package Checkout;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckoutPrice {
	 public static Map<Character, Integer> itemPrices = new HashMap<>();
	  public static  Map<Character, Offer> offerItems = new HashMap<>();
	  static {
itemPrices.put('A',50);
itemPrices.put('A', 50);
itemPrices.put('B', 30);
itemPrices.put('C', 20);
itemPrices.put('D', 15);

  offerItems.put('A', new Offer(3, 130));
  offerItems.put('B', new Offer(2, 45));
	  }
	  public static void main(String[] args) {
		  try {
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
	        Map<Character, Integer> cart = new HashMap<>();

	        while (true) {
	            String input = scanner.nextLine();
	            if (input.equalsIgnoreCase("done")) {
	                break;
	            }

	            char item = input.charAt(0);
	            if (!itemPrices.containsKey(item)) {
	                System.out.println("Invalid item! Please try again.");
	                continue;
	            }

	            // add item to cart
	            cart.put(item, cart.getOrDefault(item, 0) + 1);
	            int total = calculateTotal(cart);
	            System.out.println("Current total: " + total + " pence.");
	        }

	        int total = calculateTotal(cart);
	        System.out.println("Final total: " + total + " pence. Thank you for shopping with us!");
	    }catch(Exception ex) {
			ex.printStackTrace();  
		  } 
	  }

	    static int calculateTotal(Map<Character, Integer> cart) {
	        int total = 0;

	        for (Map.Entry<Character, Integer> entry : cart.entrySet()) {
	            char item = entry.getKey();
	            int count = entry.getValue();
	            int price = itemPrices.get(item);
	            Offer specialOffer = offerItems.get(item);

	            if (specialOffer != null && count >= specialOffer.quantity) {
	                int specialPriceCount = count / specialOffer.quantity;
	                int regularPriceCount = count % specialOffer.quantity;
	                total += specialPriceCount * specialOffer.price + regularPriceCount * price;
	            } else {
	                total += count * price;
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
	        

	    
	    

