// represents a Transaction in the system 
package com.mycompany.realestate.models;

public class Transaction {
    private int id;
    private String date;
    private double finalPrice;
    private int clientId;
    private int agentId;
    private int propertyId;

    
    // constructore used to initilaize  information
    public Transaction(int id,String date, double finalPrice,int clientId, int agentId, int propertyId) {

        this.id = id;
        this.date = date;
        this.finalPrice = finalPrice;
        this.clientId = clientId;
        this.agentId = agentId;
        this.propertyId = propertyId;

    }

    public int getId() {
        return id; 
    }

    public String getDate() { 
        return date; 
    }

    public double getFinalPrice() { 
        return finalPrice; }

    public int getClientId() { 
        return clientId; }

    public int getAgentId() { 
        return agentId; }

    public int getPropertyId() { 
        return propertyId; }
   
}
