package org.myworkspace.CineSpot.DTOs.Requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myworkspace.CineSpot.Entities.Movie;
import org.myworkspace.CineSpot.Entities.Review;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {

    private String reviewContent;
    private double rating;
    private String movieTitle;
    private Integer releaseYear;

    public Review toReview() {
        return Review.builder().reviewContent(reviewContent)
                .rating(rating).movie(Movie.builder().title(movieTitle).releaseYear(releaseYear).build()).build();
    }
}
