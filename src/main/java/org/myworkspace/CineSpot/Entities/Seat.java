package org.myworkspace.CineSpot.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.myworkspace.CineSpot.DTOs.Responses.SeatResponse;
import org.hibernate.annotations.CreationTimestamp;
import org.myworkspace.CineSpot.Entities.enums.SeatType;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Entity
@Builder
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String seatNumber;

    @Column(nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @Column(name = "is_booked", columnDefinition = "bit(1) default 0", nullable = false)
    private boolean isBooked;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date bookedAt;

    @ManyToOne
    @JsonIgnore
    private Show show;

    @ManyToOne
    @JsonIgnore
    private Ticket ticket;

    public static SeatResponse toSeatResponse(Seat seat){
        return SeatResponse.builder().seatNumber(seat.seatNumber).seatType(seat.seatType).bookedAt(seat.bookedAt).build();
    }
    public static List<SeatResponse> toSeatResponse(List<Seat> seats){
        if (!CollectionUtils.isEmpty(seats)) {
            return seats.stream().map(Seat::toSeatResponse).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
