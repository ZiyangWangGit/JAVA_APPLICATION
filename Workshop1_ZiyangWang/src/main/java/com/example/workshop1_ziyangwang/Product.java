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

public class Product {
    private final int productId;
    private String name;
    private String description;
    private double price;
    private int quantity;

    //Product constructor
    Product(int id, String name, String desc, double price, int quantity) {
        this.productId = id;
        this.name = name;
        this.description = desc;
        setPrice(price);
        setQuantity(quantity);
    }

    //Setter for attributes
    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.description = description;
    }

    public void setPrice(double price){
        if (price <= 0){
            System.out.println("Price must be positive");
        }else{
            this.price = price;
        }
    }

    public void setQuantity(int quantity){
        if (quantity <= 0){
            System.out.println("Quantity must be positive");
        }else{
            this.quantity = quantity;
        }
    }

    //Getter for attributes
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}
