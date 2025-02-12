/*
 * create by : Shubhendu Sangam
 * */

package com.ticketbooking.trainticketbooking.dto;

import org.springframework.stereotype.Component;

@Component
public class SeatChangeRequest {
    private String newSection;

    public String getNewSection() {
        return newSection;
    }

    public void setNewSection(String newSection) {
        this.newSection = newSection;
    }
}
