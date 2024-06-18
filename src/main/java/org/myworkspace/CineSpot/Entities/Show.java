package org.myworkspace.CineSpot.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.myworkspace.CineSpot.DTOs.Responses.ShowResponse;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "`movie_show`")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name="show_time", columnDefinition = "TIME", nullable = false)
    private LocalDateTime showTime;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updateAt;

    @JsonIgnore
    @ManyToOne
    private Movie movie;

    @JsonIgnore
    @ManyToOne
    private Theater theater;

    @JsonIgnore
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Ticket> ticketList;

    @JsonIgnore
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private static List<Seat> availableSeats;


//    public List<ShowResponse> toShowResponse(List<Show> shows){
//
//    }

    public static ShowResponse toShowResponse(Show show) {
        return ShowResponse.builder().movieName(show.getMovie().getTitle())
                .showTime(show.getShowTime())
                .theaterResponse(show.getTheater().toTheaterResponse())
                .latestUpdateAt(show.getUpdateAt()).build();
    }
}
