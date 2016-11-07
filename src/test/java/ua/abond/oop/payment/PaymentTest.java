package ua.abond.oop.payment;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PaymentTest {
    @Test
    public void testCartAddProducts() throws Exception {
        Payment payment = create();
        Payment.Cart cart = payment.getCart();
        cart.addProduct("test1");
        cart.addProduct("test2");
        cart.addProduct("test3");
        cart.confirm();
        cart.addProduct("test4");
        assertEquals(3, payment.getProducts().size());
    }

    @Test
    public void testCartDiscard() throws Exception {
        Payment payment = create();
        Payment.Cart cart = payment.getCart();
        cart.addProduct("test1");
        cart.discard();
        cart.confirm();
        cart.addProduct("test4");
        assertEquals(0, payment.getProducts().size());
    }

    public Payment create() {
        return new Payment();
    }
}