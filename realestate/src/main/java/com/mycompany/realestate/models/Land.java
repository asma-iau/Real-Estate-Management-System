// represinting land property type.
// inherits all attribute from property
package com.mycompany.realestate.models;

public class Land extends Property {
      public Land(int propertyID, String location, String status, int ownerID, int agentID, double price) {

        super(
                propertyID,  location, status, "Land", ownerID, agentID,  price);
    }
}
