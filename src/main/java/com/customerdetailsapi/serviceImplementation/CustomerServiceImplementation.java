package com.customerdetailsapi.serviceImplementation;

import com.customerdetailsapi.Repository.CustomerRepository;
import com.customerdetailsapi.entity.CustomerDetails;
import com.customerdetailsapi.service.CustomerService;
import com.customerdetailsapi.utils.CustomerGroup;
import com.customerdetailsapi.utils.Occupation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KRISHNA PRASAD YADAV
 */
@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void insertCustomerDetails(CustomerDetails customerDetails) throws Exception {

        if (customerDetails.getEmail().endsWith("@hikeon.tech")) {
            customerDetails.setCustomerGroup(CustomerGroup.HIKEON);
        } else {
            if (customerDetails.getOccupation().equals(Occupation.DEVELOPER)) {
                customerDetails.setCustomerGroup(CustomerGroup.DEVELOPER);
            } else if (customerDetails.getOccupation().equals(Occupation.CHEF)) {
                customerDetails.setCustomerGroup(CustomerGroup.CHEF);
            } else {
                customerDetails.setCustomerGroup(CustomerGroup.NA);
            }
        }

        if (checkAge(customerDetails.getDob())) {
            throw new Exception("Customer must be 18 year or older.");
        }

        if (isDuplicateEmail(customerDetails.getEmail())
                || (isDuplicateOccupationDobAndCustomerGroup(customerDetails.getOccupation(),
                        customerDetails.getDob(), customerDetails.getCustomerGroup()))) {
            throw new Exception("Duplicate email or combination of occupation, DOB, and customer group.");
        }

        customerRepository.save(customerDetails);
    }

    private boolean checkAge(String dob) throws ParseException {
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        LocalDate birthDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        LocalDate currentDate = LocalDate.now();
        return birthDate.plusYears(18).isAfter(currentDate);
    }

    private boolean isDuplicateEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    private boolean isDuplicateOccupationDobAndCustomerGroup(Occupation occupation, String dob, CustomerGroup customer_group) {
        return customerRepository.existsByOccupationAndDobAndCustomerGroup(occupation, dob, customer_group);
    }

}
