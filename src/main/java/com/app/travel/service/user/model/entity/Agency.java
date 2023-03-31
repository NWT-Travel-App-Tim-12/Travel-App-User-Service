package com.app.travel.service.user.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

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
    @NotBlank(message = "Name can't be blank!")
    private String name;

    @Column
    @NotBlank(message = "Address can't be blank!")
    private String address;


    @Column
    @NotBlank(message = "Agency's short name can't be blank!")
    private String agencyShortName;

}
