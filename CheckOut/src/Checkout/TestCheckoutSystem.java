package Checkout;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Checkout.CheckoutPrice.Offer;

public class TestCheckoutSystem {

    @Test
    public void testCalculateTotalNoOffer() {
        Map<Character, Integer> cart = new HashMap<>();
        cart.put('A', 2);
        cart.put('B', 1);
        int expectedTotal = 130 + 30;
        assertEquals(expectedTotal, CheckoutPrice.calculateTotal(cart));
    }

    @Test
    public void testCalculateTotalWithOffer() {
        Map<Character, Integer> cart = new HashMap<>();
        cart.put('A', 3);
        cart.put('B', 2);
        int expectedTotal = 130 + 45 + 50;
        assertEquals(expectedTotal, CheckoutPrice.calculateTotal(cart));
    }

    @Test
    public void testCalculateTotalWithInvalidItem() {
        Map<Character, Integer> cart = new HashMap<>();
        cart.put('A', 2);
        cart.put('X', 1);
        int expectedTotal = 100;
        assertEquals(expectedTotal, CheckoutPrice.calculateTotal(cart));
    }
    @Test
    public void testSpecialOffer() {
        int expectedQuantity = 3;
        int expectedPrice = 130;
        Offer specialOffer = new Offer(expectedQuantity, expectedPrice);
        assertEquals(expectedQuantity, specialOffer.quantity);
        assertEquals(expectedPrice, specialOffer.price);
    }

}