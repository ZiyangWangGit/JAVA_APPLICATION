package com.example.workshop3;

public class EmailBuddy {
    private String name, address;
    private boolean onHotList;
    // Here are some constructors
    public EmailBuddy() { name = ""; address = ""; onHotList = false; }
    public EmailBuddy(String aName, String anAddress) {
        name = aName; address = anAddress; onHotList = false; }
    // Here are the get methods
    public String getName() { return name; }
    public String getAddress() { return address; }
    public boolean onHotList() { return onHotList; }
    // Here are the set methods
    public void setName(String newName) { name = newName; }
    public void setAddress(String newAddress) { address = newAddress; }
    public void onHotList(boolean onList) { onHotList = onList; }
    // The appearance of the buddy
    public String toString() { return(name); }
}

