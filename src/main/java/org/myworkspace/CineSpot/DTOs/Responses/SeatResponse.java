package org.myworkspace.CineSpot.DTOs.Responses;

import lombok.Builder;
import lombok.Data;
import org.myworkspace.CineSpot.Entities.enums.SeatType;
import java.util.Date;

@Data
@Builder
public class SeatResponse {
    private String seatNumber;
    private int rate;
    private SeatType seatType;
    private boolean booked;
    private Date bookedAt;
}
