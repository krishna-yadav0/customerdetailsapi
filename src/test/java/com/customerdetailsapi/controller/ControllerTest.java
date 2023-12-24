
package com.customerdetailsapi.controller;

import com.customerdetailsapi.entity.CustomerDetails;
import com.customerdetailsapi.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private Controller controller;

    @Test
    void testGetDetails() {
        // Mocking the behavior of the customerService
        List<CustomerDetails> mockCustomerDetailsList = new ArrayList<>();
        Mockito.when(customerService.getDetails()).thenReturn(mockCustomerDetailsList);

        // Calling the method under test
        List<CustomerDetails> result = controller.getCustomerDetails();

        // Assertions
        assertNotNull(result);
        assertEquals(mockCustomerDetailsList, result);
    }

    @Test
    void testAddCustomerSuccess() throws Exception {
        // Mocking the behavior of the customerService
        Mockito.doNothing().when(customerService).insertCustomerDetails(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString());

        // Calling the method under test
        ResponseEntity<String> result = controller.addCustomer("krishna", "hike@gmail.com", "1990-03-01", "plumber");

        // Assertions
        assertNotNull(result);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals("Customer created successfully", result.getBody());
    }

    @Test
    void testAddCustomerFailure() throws Exception {
        // Mocking the behavior of the customerService to throw an exception
        Mockito.doThrow(new RuntimeException("Invalid input")).when(customerService)
                .insertCustomerDetails(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString());

        // Calling the method under test
        ResponseEntity<String> result = controller.addCustomer("invalid", "hike@gmail.com", "1999-03-01", "plumber");

        // Assertions
        assertNotNull(result);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertEquals("Invalid input", result.getBody());
    }
}