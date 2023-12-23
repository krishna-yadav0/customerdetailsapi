package com.customerdetailsapi.serviceImplementation;

import com.customerdetailsapi.Repository.CustomerRepository;
import com.customerdetailsapi.entity.CustomerDetails;
import com.customerdetailsapi.service.CustomerService;
import com.customerdetailsapi.utils.Occupation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    public List<CustomerDetails> getDetails() {

        return customerRepository.findAll();
    }

    @Override
    public void insertCustomerDetails(String name, String email, String dob, String occupation) throws Exception {
        CustomerDetails customerDetails = new CustomerDetails();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date  = dateFormat.parse(dob);
        customerDetails.setName(name);
        customerDetails.setEmail(email);
        customerDetails.setDob(date);
        customerDetails.setOccupation(occupation);

        if (customerDetails.getEmail().endsWith("@hikeon.tech")) {
            customerDetails.setCustomerGroup("HIKEON");
        } else {
            if (customerDetails.getOccupation().equals(Occupation.DEVELOPER)) {
                customerDetails.setCustomerGroup("DEVELOPER");
            } else if (customerDetails.getOccupation().equals(Occupation.CHEF)) {
                customerDetails.setCustomerGroup("CHEF");
            } else {
                customerDetails.setCustomerGroup("NA");
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

    private boolean checkAge(Date dob) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dob);
        LocalDate birthDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        LocalDate currentDate = LocalDate.now();
        return birthDate.plusYears(18).isAfter(currentDate);
    }

    private boolean isDuplicateEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    private boolean isDuplicateOccupationDobAndCustomerGroup(String occupation, Date dob, String customer_group) {
        return customerRepository.existsByOccupationAndDobAndCustomerGroup(occupation, dob, customer_group);
    }

}
