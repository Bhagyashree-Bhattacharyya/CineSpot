package org.myworkspace.CineSpot.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.myworkspace.CineSpot.DTOs.Responses.ReviewResponse;

import java.util.*;
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

    @Column(name = "ref_id", nullable = false, unique = true)
    private String refId;

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
        return ReviewResponse.builder().movie(review.movie.getTitle()).releaseYear(review.movie.getReleaseYear()).reviewContent(review.reviewContent)
                .rating(review.rating).build();
    }

    public static List<ReviewResponse> toReviewResponse(List<Review> reviewList) {
        if (reviewList == null) {
            return Collections.emptyList();
        }
        else {
            return reviewList.stream().map(Review::toReviewResponse)
                    .collect(Collectors.toList());
        }
    }
}