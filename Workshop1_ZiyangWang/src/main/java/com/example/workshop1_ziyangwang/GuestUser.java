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

public class GuestUser extends User {
    private final ShoppingCart guestCart;

    //Constructor
    public GuestUser(int userId, String name, String address) {
        super(userId, name, address);
        this.guestCart = new ShoppingCart();
    }

    //Getter
    public ShoppingCart getShoppingCart(){
        return guestCart;
    }
}
