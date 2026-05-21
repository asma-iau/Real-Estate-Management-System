// this class store property information
package com.mycompany.realestate.models;

public  abstract class Property {
    
    protected int propertyID;
    protected String location;
    protected String status;
    protected String propertyType;
    protected int ownerID;
    protected int agentID;
    protected double price;

    // constructore used to initilaize property information
    public Property(int propertyID,  String location,String status, String propertyType, int ownerID,  int agentID,double price) {

        this.propertyID = propertyID;
        this.location = location;
        this.status = status;
        this.propertyType = propertyType;
        this.ownerID = ownerID;
        this.agentID = agentID;
        this.price = price;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public int getAgentID() {
        return agentID;
    }

    public double getPrice() {
        return price;
    }
}

    

