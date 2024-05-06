package com.abl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abl.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, String>{

	
}
