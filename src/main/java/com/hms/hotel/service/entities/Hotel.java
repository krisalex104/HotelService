package com.hms.hotel.service.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "hotelUid", nullable = false)
    private String hotelUid;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "about")
    private String about;
    @Column(name = "location", nullable = false)
    private String location;

}
