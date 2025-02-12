/*
 * create by : Shubhendu Sangam
 * */

package com.ticketbooking.trainticketbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ticketbooking.trainticketbooking.repository")
public class TrainTicketBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainTicketBookingApplication.class, args);
	}

}
