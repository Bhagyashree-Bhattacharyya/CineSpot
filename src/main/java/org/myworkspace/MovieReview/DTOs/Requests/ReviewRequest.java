package org.myworkspace.MovieReview.DTOs.Requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myworkspace.MovieReview.Entities.Movie;
import org.myworkspace.MovieReview.Entities.Review;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {

    private String reviewContent;
    private double rating;
    private String movieId;

    public Review toReview() {
        return Review.builder().reviewContent(reviewContent)
                .rating(rating).movie(Movie.builder().id(movieId).build()).build();
    }
}
