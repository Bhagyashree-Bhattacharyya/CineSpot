package org.myworkspace.MovieReview.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.myworkspace.MovieReview.DTOs.Responses.ReviewResponse;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Review {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reviewContent;

    private double rating;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @JsonIgnore
    private Movie movie;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;


    public static ReviewResponse toReviewResponse(Review review) {
        return ReviewResponse.builder().reviewContent(review.reviewContent)
                .rating(review.rating).build();
    }

    public static List<ReviewResponse> toReviewResponse(List<Review> reviewList) {
        if (Objects.isNull(reviewList))
            return new ArrayList<>();
        else
            return reviewList.stream().map(Review::toReviewResponse)
                    .collect(Collectors.toList());
    }
}