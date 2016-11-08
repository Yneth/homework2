package ua.abond.oop.payment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Payment {
    private List<Product> products;

    public Payment() {
        this(new ArrayList<>());
    }

    public Payment(List<Product> products) {
        this.products = Collections.unmodifiableList(new ArrayList<>());
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public class Product {
        private final String name;

        public Product(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
