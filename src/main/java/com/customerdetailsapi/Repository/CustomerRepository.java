package com.customerdetailsapi.Repository;

import com.customerdetailsapi.entity.CustomerDetails;
import com.customerdetailsapi.utils.CustomerGroup;
import com.customerdetailsapi.utils.Occupation;
import java.util.Date;
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
            String occupation, Date dob, String customer_group);
}
