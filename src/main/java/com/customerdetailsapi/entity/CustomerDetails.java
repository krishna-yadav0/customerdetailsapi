package com.customerdetailsapi.entity;

import com.customerdetailsapi.utils.CustomerGroup;
import com.customerdetailsapi.utils.Occupation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author KRISHNA PRASAD YADAV
 */
@Data
@Entity
@Table(name = "CustomerDetails")
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String dob;

    private Occupation occupation;

    private CustomerGroup customerGroup;
}
