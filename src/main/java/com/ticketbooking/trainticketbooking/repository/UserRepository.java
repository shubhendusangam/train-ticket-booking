/*
 * create by : Shubhendu Sangam
 *
 * */

package com.ticketbooking.trainticketbooking.repository;

import com.ticketbooking.trainticketbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
