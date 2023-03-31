package com.app.travel.service.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "agencies")
public class Agency {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "administrator_id")
    private User administrator;

    @Column
    private String name;

    @Column
    private String address;


    @Column
    private String agencyShortName;

}
