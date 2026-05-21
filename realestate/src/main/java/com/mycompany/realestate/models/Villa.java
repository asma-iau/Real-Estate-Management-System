// represinting villa property type.
// inherits all attribute from property
package com.mycompany.realestate.models;

public class Villa extends Property {
       public Villa(int propertyID, String location, String status,  int ownerID,int agentID, double price) {

        super(
                propertyID, location, status, "Villa",ownerID,agentID,price);
    }

}
