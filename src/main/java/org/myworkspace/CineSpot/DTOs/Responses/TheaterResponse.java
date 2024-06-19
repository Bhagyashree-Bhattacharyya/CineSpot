package org.myworkspace.CineSpot.DTOs.Responses;

import lombok.Builder;
import lombok.Data;
import org.myworkspace.CineSpot.DTOs.Requests.ShowRequest;
import org.myworkspace.CineSpot.Entities.Seat;
import org.myworkspace.CineSpot.Entities.Show;
import org.myworkspace.CineSpot.Entities.Theater;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class TheaterResponse {
    private String name;
    private String city;
    private String address;
    private Long refId;
    private List<ShowRequest> shows;

}
