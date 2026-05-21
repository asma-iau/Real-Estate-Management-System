
package com.mycompany.realestate.models;
public class Client {
    
    private int clientID;
    private String name;
    private String phoneNumber;
    private String email;

    public Client(int clientID,
                  String name,
                  String phoneNumber,
                  String email) {

        this.clientID = clientID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getClientID() {
        return clientID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}