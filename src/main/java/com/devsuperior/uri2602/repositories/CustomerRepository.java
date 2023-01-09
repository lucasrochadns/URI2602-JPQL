package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustmoerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    /**CONSULTA CUSTOMIZADA -> PROJECTIONS*/
    @Query(nativeQuery = true, value="SELECT name FROM customers WHERE state= :state")
   List<CustmoerMinProjection> searchByNameWhereState(String state);
}
