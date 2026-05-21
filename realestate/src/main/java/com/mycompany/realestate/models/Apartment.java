
package com.mycompany.realestate.models;

public class Apartment extends Property {
 
    public Apartment(int propertyID, String location,String status, int ownerID, int agentID, double price) {

        super(
                propertyID,location, status,"Apartment",  ownerID,  agentID, price
        );
    }
}
