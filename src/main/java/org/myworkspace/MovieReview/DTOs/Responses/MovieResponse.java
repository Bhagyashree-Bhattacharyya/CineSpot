package org.myworkspace.MovieReview.DTOs.Responses;

import lombok.Builder;
import org.myworkspace.MovieReview.Entities.Genre;

import java.util.List;

@Builder
public class MovieResponse {

    private String title;
    private Genre genre;
    private Double rating;
    private List<ReviewResponse> reviews;
}
