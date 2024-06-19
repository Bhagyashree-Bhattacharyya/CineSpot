package org.myworkspace.CineSpot.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myworkspace.CineSpot.DTOs.Responses.TheaterResponse;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(nullable = false)
    private long refId;

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();


    public TheaterResponse toTheaterResponse() {
        return TheaterResponse.builder().name(name).city(city).refId(refId)
                .address(getAddress()).build();
    }
}
