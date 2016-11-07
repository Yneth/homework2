package ua.abond.oop.payment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Payment {
    private Cart cart;
    private List<String> products;

    public Payment() {
        this.cart = new Cart();
        this.products = Collections.unmodifiableList(new ArrayList<>());
    }

    public Cart getCart() {
        return cart;
    }

    public List<String> getProducts() {
        return products;
    }

    public class Cart {
        private boolean confirmed = false;
        private List<String> chosenProducts = new ArrayList<>();

        public void addProduct(String product) {
            if (confirmed)
                return;
            chosenProducts.add(product);
        }

        public void removeProduct(String product) {
            if (confirmed)
                return;
            chosenProducts.remove(product);
        }

        public void discard() {
            if (confirmed)
                return;
            chosenProducts.clear();
        }

        public void confirm() {
            confirmed = true;
            products = Collections.unmodifiableList(chosenProducts);
        }
    }
}
