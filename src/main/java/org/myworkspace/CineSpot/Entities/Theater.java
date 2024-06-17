package org.myworkspace.CineSpot.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.myworkspace.CineSpot.DTOs.Responses.TheaterResponse;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String city;
    private String Address;

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();

//    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
//    @JsonIgnore
//    @Builder.Default
//    private List<Seat> seats = new ArrayList<>();

    public TheaterResponse toTheaterResponse() {
        return TheaterResponse.builder().name(name).city(city)
                .address(getAddress()).build();
    }
}
