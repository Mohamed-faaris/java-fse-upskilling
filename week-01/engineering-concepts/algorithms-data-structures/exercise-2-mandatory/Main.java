/*
 * ## Exercise 2: E-commerce Platform Search Function
 * Scenario:
 * You are working on the search functionality of an e-commerce platform. The search needs to be
 * optimized for fast performance.
 * ## Steps:
 * Understand Asymptotic Notation:
 * Explain Big O notation and how it helps in analyzing algorithms.
 * Describe the best, average, and worst-case scenarios for search operations.
 * Setup:
 * Create a class Product with attributes for searching, such as productId, productName, and category.
 * Implementation:
 * Implement linear search and binary search algorithms.
 * Store products in an array for linear search and a sorted array for binary search.
 * Analysis:
 * Compare the time complexity of linear and binary search algorithms.
 * Discuss which algorithm is more suitable for your platform and why.
 */

import java.util.ArrayList;

 class Product {
    int id;
    String name;
    String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Smartphone", "Electronics"));
        products.add(new Product(3, "Shoes", "Fashion"));
        products.add(new Product(4, "Watch", "Accessories"));
        products.add(new Product(5, "Backpack", "Fashion"));
        products.add(new Product(6, "Headphones", "Electronics"));
        products.add(new Product(7, "Sunglasses", "Accessories"));
        products.add(new Product(8, "Jacket", "Fashion"));
        products.add(new Product(9, "Tablet", "Electronics"));
        products.add(new Product(10, "Camera", "Electronics"));
        products.add(new Product(11, "Belt", "Accessories"));
        products.add(new Product(12, "Dress", "Fashion"));
        products.add(new Product(13, "Shoes", "Fashion"));
        products.add(new Product(14, "Smartwatch", "Electronics"));
        products.add(new Product(15, "Wallet", "Accessories"));
        products.add(new Product(16, "Jeans", "Fashion"));

        // Linear Search
        int serchId = 13;

        Long startTimeLinear = System.currentTimeMillis();
        Product foundProductLinear = linearSearch(products, serchId);
        long endTimeLinear = System.currentTimeMillis();


        products.sort((p1, p2) -> Integer.compare(p1.id, p2.id));
        Long startTimeBinary = System.currentTimeMillis();
        Product foundProductBinary = binarySearch(products, serchId);
        Long endTimeBinary = System.currentTimeMillis();

        System.out.println("Linear Search Result: " + foundProductLinear==null ? "Product not found" : foundProductLinear);
        System.out.println("Binary Search Result: " + foundProductBinary==null ? "Product not found" : foundProductBinary);

        System.out.println("Linear Search Time: " + (endTimeLinear - startTimeLinear) + " ms");
        System.out.println("Binary Search Time: " + (endTimeBinary - startTimeBinary) + " ms");
    }

    static Product linearSearch(ArrayList<Product> products, int id) {
        for (Product product : products) {
            if (product.id == id) {
                return product;
            }
        }
        return null;
    }

    static Product binarySearch(ArrayList<Product> products, int id) {
        
        int left = 0;
        int right = products.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products.get(mid);

            if (midProduct.id == id) {
                return midProduct;
            } else if (midProduct.id < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

// ❯ javac Main.java && java Main
// Product{id=13, name='Shoes', category='Fashion'}
// Product{id=13, name='Shoes', category='Fashion'}
// Linear Search Time: 0 ms
// Binary Search Time: 0 ms