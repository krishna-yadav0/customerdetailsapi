package com.customerdetailsapi.Repository;

import com.customerdetailsapi.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KRISHNA PRASAD YADAV
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Long> {
    boolean existsByEmail(String email);
    boolean existsByOccupationAndDobAndCustomerGroup(
    String occupation, String dob, String customer_group);
    
}
