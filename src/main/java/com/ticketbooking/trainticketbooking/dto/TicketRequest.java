/*
 * create by : Shubhendu Sangam
 * */

package com.ticketbooking.trainticketbooking.dto;

public class TicketRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String section;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
