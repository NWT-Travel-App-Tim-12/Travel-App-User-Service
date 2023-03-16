package com.app.travel.service.user.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agencies")
public class Agency {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private UUID id;

    @OneToOne(optional = false, cascade = CascadeType.REMOVE)
    @Getter
    @Setter
    private User administratorRef;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String address;

    @Column(name = "agency-short-name")
    @Getter
    @Setter
    private String agencyShortName;

}
