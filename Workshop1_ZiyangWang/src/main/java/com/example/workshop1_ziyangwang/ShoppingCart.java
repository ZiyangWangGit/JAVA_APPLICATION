/**********************************************
 Workshop #1
 Course:APD545 - Semester 5
 Last Name:Wang
 First Name:Ziyang
 ID:15429622
 Section:APD545
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date:2024.09.20
 **********************************************/
package com.example.workshop1_ziyangwang;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> shoppingCart;

    //Constructor
    ShoppingCart(){
        this.shoppingCart = new ArrayList<>();
    }

    //Add product
    public void addProduct(Product product){
        shoppingCart.add(product);
        System.out.println(product.getName() + " is added");
    }

    //Remove product
    public void removeProduct(Product product){
        shoppingCart.remove(product);
        System.out.println(product.getName() + " is removed");
    }

    //Calculate total cost of items
    public double calculateTotal() {
        double total = 0;
        for (Product product : shoppingCart) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    //Display items in the cart
    public void displayItems(){
        System.out.println("Products in the cart:");
        for (Product product : shoppingCart) {
            System.out.println(product.getName());
        }
    }

}
