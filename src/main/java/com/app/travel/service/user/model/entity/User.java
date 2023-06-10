package com.app.travel.service.user.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agencyRef;

    @Column(name = "first_name")
    @NotBlank(message = "First name can't be blank!")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name can't be blank!")
    private String lastName;

    @Column(name = "address")
    @NotBlank(message = "Address can't be blank!")
    private String address;


    @Column(name = "email")
    @Email(message = "Email address is not valid.")
    private String email;


    @OneToOne(mappedBy = "administrator")
    private Agency administratorAgency;


    @NotBlank(message="Password can't be blank")
    @JsonIgnore
    private String password;

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }



}
