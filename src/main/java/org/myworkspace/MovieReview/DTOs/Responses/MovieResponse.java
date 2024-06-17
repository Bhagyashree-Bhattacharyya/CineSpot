package org.myworkspace.MovieReview.DTOs.Responses;

import lombok.Builder;
import lombok.Data;
import org.myworkspace.MovieReview.Entities.Genre;

import java.util.List;

@Data
@Builder
public class MovieResponse {

    private String title;
    private int releaseYear;
    private Genre genre;
    private Double rating;
    private List<ReviewResponse> reviews;
}
