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
    @GeneratedValue (strategy = GenerationType.UUID)
    @Getter
    @Setter
    private UUID id;

    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
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

    @Getter
    @Setter
    private String agencyShortName;

}
