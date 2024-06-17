package org.myworkspace.CineSpot.DTOs.Responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class ShowResponse {
    private long id;

    @NotNull(message = "Show Time is Mandatory")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime showTime;

    @NotNull(message = "Movie is Mandatory for Show")
    private String movieName;

    @NotNull(message = "Theater is Mandatory for Show")
    private long theaterRefId;

    private Date latestUpdateAt;

    private MovieResponse movieResponse;

    private TheaterResponse theaterResponse;

    private List<SeatResponse> seats;

}
