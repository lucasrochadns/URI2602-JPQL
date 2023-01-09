package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustmoerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    /**CONSULTA CUSTOMIZADA -> PROJECTIONS*/
    @Query(nativeQuery = true, value="SELECT name FROM customers WHERE UPPER(state)= UPPER(:state)")
   List<CustmoerMinProjection> searchByNameWhereState(String state);

    @Query("SELECT new com.devsuperior.uri2602.dto.CustomerMinDTO(c.name) FROM Customer c WHERE UPPER(c.state)= UPPER(:state)")
    List<CustomerMinDTO> searchCustomerByName(String state);
}
