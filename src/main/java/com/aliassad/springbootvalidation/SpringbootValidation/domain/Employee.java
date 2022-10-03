package com.aliassad.springbootvalidation.SpringbootValidation.domain;


import com.aliassad.springbootvalidation.SpringbootValidation.domain.enumration.ContractType;
import com.aliassad.springbootvalidation.SpringbootValidation.domain.enumration.Gender;
import com.aliassad.springbootvalidation.SpringbootValidation.validation.employee.MaritalStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Email;
import java.math.BigDecimal;

@Entity
@Table(name="employee")
@Setter
@Getter
public class Employee extends AbstractAuditingEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @Length(min= 3, max = 5)
    @NotNull
    private String name;

    @NotNull
    @Column(name = "position")
    private String position;

    @NotNull
    @Column(name="salary")
    private BigDecimal salary;

    @NotNull
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Column(name = "contract_type")
    @Enumerated(EnumType.ORDINAL)
    private ContractType contractType;


    @CreditCardNumber(ignoreNonDigitCharacters = true)
    @Column(name = "card_number")
    private String cardNumber;

    @Email
    @Column(name = "email")
    private  String email;

    @MaritalStatus
    @Column(name = "martial_status")
    private String martialStatus;




}
