package com.customerdetailsapi.Repository;

import com.customerdetailsapi.entity.CustomerDetails;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KRISHNA PRASAD YADAV
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Long> {

    /**
     * This method is use to the uniqueness of the email constraint.
     * @param email
     * @return 
     */
    public boolean existsByEmail(String email);

    /**
     * This method is use to check the uniqueness of combination of occupation, DOB, and customer group.
     * @param occupation
     * @param dob
     * @param customer_group
     * @return 
     */
    public boolean existsByOccupationAndDobAndCustomerGroup(
            String occupation, Date dob, String customer_group);
}
