package org.myworkspace.CineSpot.DTOs.Requests;

import lombok.Builder;
import lombok.Data;
import org.myworkspace.CineSpot.Entities.Theater;
import org.myworkspace.CineSpot.DTOs.Responses.ShowResponse;

import java.util.List;

@Data
@Builder
public class TheaterRequest {
    private String name;
    private String city;
    private String address;

    public Theater toTheater() {
        return Theater.builder().name(name).city(city).Address(address).build();
    }
}
