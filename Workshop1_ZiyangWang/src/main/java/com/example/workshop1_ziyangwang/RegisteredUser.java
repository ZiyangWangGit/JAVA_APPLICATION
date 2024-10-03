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

public class RegisteredUser extends User {
    private String accountName;
    private String password;
    private ShoppingCart registeredUserCart;

    //Constructor
    public RegisteredUser(int userId, String name, String address) {
        super(userId, name, address);
        this.registeredUserCart = new ShoppingCart();
    }

    //Setter
    public void getAccountName(String name){
        this.accountName = name;
    }

    public void getPassword(String password){
        this.password = password;
    }

    //Getter
    public ShoppingCart getShoppingCart(){
        return registeredUserCart;
    }

    //Create An Account,Have to work with database
    public void createAccount(String accName,String password){
        getAccountName(accName);
        getPassword(password);
    }

    //Log in,Have to work with database
    public void logIn(String accName,String password){
        //Check if the accName and password matches the information on database
    }

    //Save Cart
    public void saveCart(){
        //save the cart to the database
        return;
    }
}
