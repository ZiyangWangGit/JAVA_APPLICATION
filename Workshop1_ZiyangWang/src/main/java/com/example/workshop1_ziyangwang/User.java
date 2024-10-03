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

public abstract class User {
    private final int userId;
    private String name;
    private String address;

    // User Class Constructor
    User(int userId, String name, String address) {
        this.userId = userId;
        this.name = name;
        this.address = address;
    }

    // Setter for attributes
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for attributes
    public int getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

}
