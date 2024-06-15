package org.myworkspace.MovieReview.DTOs.Responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewResponse {

    private String reviewContent;
    private Double rating;
}
