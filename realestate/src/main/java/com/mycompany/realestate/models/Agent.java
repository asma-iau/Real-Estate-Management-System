// represents a client in the system 
package com.mycompany.realestate.models;

public class Agent {
    
    private int agentId;
    private String aName;
    private String firstName;
    private String lastName;
    private Integer supervises; 

        // constructore used to initilaize  information
    public Agent(int agentId, String aName, String firstName, String lastName, Integer supervises) {
        this.agentId = agentId;
        this.aName = aName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.supervises = supervises;
    }

    public int getAgentID() {
        return agentId;
    }

    public String getName() {
        return aName;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlasttName() {
        return lastName;
    }

    public Integer getSupervises() {
        return supervises;
    }
}
