package com.example.workshop1_ziyangwang;

public class Main {
    public static void main(String[] args) {
        //Create a new product
        Product product1 = new Product(1, "Pears", "Perfect blend of sweetness and crunch", 5, 20);
        Product product2 = new Product(2, "iphone 15", "The iPhone 15 sets a new standard for smartphones", 999, 5);

        //Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        //Add product to shopping cart
        cart.addProduct(product1);
        cart.addProduct(product2);
        double cartTotal = cart.calculateTotal();
        System.out.println("Cart total is:" + cartTotal);

        //Remove product to shopping cart
        cart.removeProduct(product2);
        cartTotal = cart.calculateTotal();
        System.out.println("Cart total is:" + cartTotal);

        //Create Guest User
        GuestUser newGuestUser = new GuestUser(1,"Kevin","222 Will Blvd");
        System.out.println(newGuestUser.getName()+" Has been successfully added");
        newGuestUser.getShoppingCart().addProduct(product1);
        newGuestUser.getShoppingCart().displayItems();

        //Create Register User
        RegisteredUser newRegisteredUser = new RegisteredUser(2,"Calvin","2550 Eglinton Ave West");
        System.out.println(newRegisteredUser.getName()+" Has been successfully added");
        newRegisteredUser.getShoppingCart().addProduct(product2);
        newGuestUser.getShoppingCart().displayItems();

    }
}
