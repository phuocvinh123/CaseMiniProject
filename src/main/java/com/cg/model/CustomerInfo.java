package com.cg.model;

import com.cg.model.dto.CustomerInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class CustomerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String mobile;
    private String address;
    @Column(nullable = false)
    private String email;

    public CustomerInfoDTO toCustomerInfoDTO(){
        return new CustomerInfoDTO()
                .setId(id)
                .setFullName(fullName)
                .setMobile(mobile)
                .setAddress(address)
                .setEmail(email);
    }
}
