package com.app.travel.service.user.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private String id;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "agency_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Getter
    @Setter
    private  String agencyRef;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "address")
    @Getter
    @Setter
    private String address;


    @Column(name = "email")
    @Getter
    @Setter
    private String email;

}
