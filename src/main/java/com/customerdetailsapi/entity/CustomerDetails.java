package com.customerdetailsapi.entity;
import javax.persistence.*;
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
    
    private String occupation;
    
    private String customerGroup;
}
