package org.myworkspace.CineSpot.DTOs.Responses;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TheaterResponse {
    private String name;
    private String city;
    private String address;
    private List<ShowResponse> shows;
}
