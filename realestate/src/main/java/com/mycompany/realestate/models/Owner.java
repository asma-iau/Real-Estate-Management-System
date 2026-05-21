// represents a owner in the system 
package com.mycompany.realestate.models;

public class Owner {
    
    private int ownerId;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String ownerName;
    
        // constructore used to initilaize  information

    public Owner(int ownerId,String email,String firstName, String lastName,String phoneNumber, String ownerName) {
        this.ownerId = ownerId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.ownerName = ownerName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
