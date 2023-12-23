package com.customerdetailsapi.Repository;

import com.customerdetailsapi.entity.CustomerDetails;
import com.customerdetailsapi.utils.CustomerGroup;
import com.customerdetailsapi.utils.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KRISHNA PRASAD YADAV
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Long> {

    public boolean existsByEmail(String email);

    public boolean existsByOccupationAndDobAndCustomerGroup(
            Occupation occupation, String dob, CustomerGroup customer_group);
}
